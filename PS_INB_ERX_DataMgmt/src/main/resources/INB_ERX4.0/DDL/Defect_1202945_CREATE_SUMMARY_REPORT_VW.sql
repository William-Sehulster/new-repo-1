CREATE OR REPLACE VIEW erx.summary_report_vw
AS
(SELECT pharmacy_ncpdp_id,
  pharmacy_va_station_id,
  pharmacy_division_name,
  visn,
  pharmacy_address_line_1
  ||' '
  || pharmacy_address_line_2
  ||' '
  ||pharmacy_city
  ||', '
  ||pharmacy_state
  ||' '
  ||pharmacy_zipcode pharmacy_address,
  SUM(new_rx_cnt) new_rx_cnt,
  SUM(new_rx_pharm_disabled_at_hub) new_rx_pharm_disabled_at_hub,
  SUM(new_rx_rejected_at_hub) new_rx_rejected_at_hub,
  SUM(new_rx_pass_auto_chk) new_rx_pass_auto_chk,
  SUM(new_rx_fail_auto_chk) new_rx_fail_auto_chk,
  SUM(new_rx_rejected_by_pharmacist) new_rx_rejected_by_pharmacist,
  SUM(new_rx_filled) new_rx_filled,
  SUM(new_rx_in_process) new_rx_in_process,
  new_rx_message_date
FROM
  (SELECT pharm.ncpdp_id pharmacy_ncpdp_id,
    pharm.va_station_id pharmacy_va_station_id,
    pharm.division_name pharmacy_division_name,
    pharm.visn visn,
    pharm.pharmacy_address_line_1,
    pharm.pharmacy_address_line_2,
    pharm.pharmacy_city,
    pharm.pharmacy_state,
    pharm.pharmacy_zipcode,
    DECODE(inbmsg.message_type, 'NewRx', 1, 0) new_rx_cnt,
    DECODE(inbmsg.message_status, '3010', 1, 0) new_rx_pharm_disabled_at_hub,
    DECODE(inbmsg.message_status, '3006', 1, 0) new_rx_rejected_at_hub,
    DECODE((DECODE(inbmsg.patient_chk_status,'0101',1,0) + DECODE(inbmsg.provider_chk_status,'2001',1,0) + DECODE(inbmsg.drug_chk_status,'1001',1,0)), 3, 1, 0) new_rx_pass_auto_chk,
    DECODE((DECODE(inbmsg.patient_chk_status,'0101',1,0) + DECODE(inbmsg.provider_chk_status,'2001',1,0) + DECODE(inbmsg.drug_chk_status,'1001',1,0)), 3, 0, 1) - DECODE(inbmsg.message_status, '3006', 1, 0) + DECODE(inbmsg.message_status, '3010', 1, 0) new_rx_fail_auto_chk,
    0 new_rx_rejected_by_pharmacist,
    0 new_rx_filled,
    0 new_rx_in_process,
    TRUNC(inbmsg.created_date) new_rx_message_date
  FROM erx.inbound_ncpdp_msg inbmsg,
    erx.pharmacy pharm
  WHERE inbmsg.pharmacy_id       = pharm.pharmacy_id
  AND inbmsg.MESSAGE_STATUS NOT IN ('0000')
  AND inbmsg.message_type       IN ('NewRx')
  UNION ALL
  SELECT pharm.ncpdp_id pharmacy_ncpdp_id,
    pharm.va_station_id pharmacy_va_station_id,
    pharm.division_name pharmacy_division_name,
    pharm.visn visn,
    pharm.pharmacy_address_line_1,
    pharm.pharmacy_address_line_2,
    pharm.pharmacy_city,
   pharm.pharmacy_state,
    pharm.pharmacy_zipcode,
    0 new_rx_cnt,
    0 new_rx_pharm_disabled_at_hub,
    0 new_rx_rejected_at_hub,
    0 new_rx_pass_auto_chk,
    0 new_rx_fail_auto_chk,
    DECODE(SUBSTR(extractvalue(outbmsg.message, '//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,3),'PTT',1,'ERR',1,'DRU',1,'PVD',1,0 ) +
        DECODE(SUBSTR(extractvalue(outbmsg.message, '//Error/Description'),1,3),'PTT',1,'ERR',1,'DRU',1,'PVD',1,0 ) new_rx_rejected_by_pharmacist,
    (existsNode(outbmsg.message, '//RxFill/FillStatus/PartialFill','xmlns="http://www.ncpdp.org/schema/SCRIPT"') +
    existsNode(outbmsg.message, '//RxFill/FillStatus/Filled','xmlns="http://www.ncpdp.org/schema/SCRIPT"')) new_rx_filled,
        DECODE(extractvalue(outbmsg.message, '//VerifyStatus/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),'Accepted By Pharmacy.',1,0) +
      DECODE(extractvalue(outbmsg.message, '//VerifyStatus/Description'),'Accepted By Pharmacy.',1,0) + DECODE(extractvalue(outbmsg.message, '//VerifyStatus/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),'Accepted By Pharmacy.',1,0) new_rx_in_process, 
      TRUNC(outbmsg.created_date) new_rx_message_date
  FROM erx.outbound_ncpdp_msg outbmsg,
    erx.pharmacy pharm
  WHERE outbmsg.pharmacy_id                                                                                          = pharm.pharmacy_id
  AND outbmsg.MESSAGE_STATUS NOT                                                                                    IN ('0000')
  AND outbmsg.message_type                                                                                          IN ('Error', 'RxFill','Verify')
  AND outbmsg.PHARMACY_ID                                                                                           <> 0
  ) outbmsg
GROUP BY pharmacy_ncpdp_id,
  pharmacy_va_station_id,
  pharmacy_division_name,
  visn,
  pharmacy_address_line_1,
  pharmacy_address_line_2,
  pharmacy_city,
  pharmacy_state,
  pharmacy_zipcode,
  new_rx_message_date);