 CREATE OR REPLACE FORCE VIEW "ERX"."REJECT_REASONS_REPORT_VW" ("PHARMACY_NCPDP_ID",
  "PHARMACY_VA_STATION_ID",  
  "PHARMACY_DIVISION_NAME",
  "VISN",
  "PHARMACY_ADDRESS",
  "NEW_RX_IN_PROCESS",
  "NEW_RX_REJECTED_BY_PHARMACIST",
  "NEW_RX_PATIENT_NOT_ELIG",
  "NEW_RX_PATIENT_NOT_FOUND",
  "NEW_RX_PROVIDER_NOT_ELIG",
  "NEW_RX_PROVIDER_NOT_FOUND",
  "NEW_RX_NOT_ELIG_REFILLS",
  "NEW_RX_NON_FORMULARY",
  "NEW_RX_DUPLICATE",
  "NEW_RX_INVALID_QTY",
  "NEW_RX_DUP_THERA_CLASS",
  "NEW_RX_CS_NOT_ALLOWED",
  "NEW_RX_ERR_MULTI_CALL_PHARM",
  "NEW_RX_INCORRECT_PHARM",
  "NEW_RX_ERR_CALL_PHARM",
  "NEW_RX_MESSAGE_DATE") AS 
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
  SUM(new_rx_in_process)  new_rx_in_process,
  SUM(new_rx_rejected_by_pharmacist) new_rx_rejected_by_pharmacist,
  SUM(new_rx_patient_not_elig) new_rx_patient_not_elig,
  SUM(new_rx_patient_not_found) new_rx_patient_not_found,
  SUM(new_rx_provider_not_elig) new_rx_provider_not_elig,
  SUM(new_rx_provider_not_found) new_rx_provider_not_found,
  SUM(new_rx_not_elig_refills) new_rx_not_elig_refills,
  SUM(new_rx_non_formulary) new_rx_non_formulary,
  SUM(new_rx_duplicate) new_rx_duplicate,
  SUM(new_rx_invalid_qty) new_rx_invalid_qty,
  SUM(new_rx_dup_thera_class) new_rx_dup_thera_class,
  SUM(new_rx_cs_not_allowed) new_rx_cs_not_allowed,
  SUM(new_rx_err_multi_call_pharm) new_rx_err_multi_call_pharm,
  SUM(new_rx_incorrect_pharm) new_rx_incorrect_pharm,
  SUM(new_rx_err_call_pharm) new_rx_err_call_pharm,
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
    0  new_rx_in_process,
    0 new_rx_rejected_by_pharmacist,
    0 new_rx_patient_not_elig,
    0 new_rx_patient_not_found,
    0 new_rx_provider_not_elig,
    0 new_rx_provider_not_found,
    0 new_rx_not_elig_refills,
    0 new_rx_non_formulary,
    0 new_rx_duplicate,
    0 new_rx_invalid_qty,
    0 new_rx_dup_thera_class,
    0 new_rx_cs_not_allowed,
    0 new_rx_err_multi_call_pharm,
    0 new_rx_incorrect_pharm,
    0 new_rx_err_call_pharm,
    TRUNC(inbmsg.created_date) new_rx_message_date
  FROM erx.inbound_ncpdp_msg inbmsg,
    erx.pharmacy pharm
  WHERE (inbmsg.pharmacy_id       = pharm.pharmacy_id
  AND inbmsg.MESSAGE_STATUS NOT IN ('0000')
  AND inbmsg.message_type       IN ('NewRx') AND pharm.pharmacy_id <> 0)
  OR (pharm.inbound_erx_enabled = 1 and pharm.pharmacy_id <> 0)
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
    DECODE(extractvalue(outbmsg.message, 
'//VerifyStatus/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),'Accepted By Pharmacy.',1,0 
) + DECODE(extractvalue(outbmsg.message, 
'//VerifyStatus/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),'',1,0 
) new_rx_in_process, --Accepted By Pharmacy + where Description is null to count legacy Verify messages created in Hub.
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,3),'PTT',1,'ERR',1,'DRU',1,
'PVD',1,0 ) new_rx_rejected_by_pharmacist,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'PTT01',1,0 ) 
new_rx_patient_not_elig,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'PTT02',1,0 ) 
new_rx_patient_not_found,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'PVD01',1,0 ) 
new_rx_provider_not_elig,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'PVD02',1,0 ) 
new_rx_provider_not_found,
DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'DRU01',1,0 ) 
new_rx_not_elig_refills,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'DRU02',1,0 ) 
new_rx_non_formulary,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'DRU03',1,0 ) 
new_rx_duplicate,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'DRU04',1,0 ) 
new_rx_invalid_qty,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'DRU05',1,0 ) 
new_rx_dup_thera_class,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'DRU06',1,0 ) 
new_rx_cs_not_allowed,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'ERR01',1,0 ) 
new_rx_err_multi_call_pharm,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'ERR02',1,0 ) 
new_rx_incorrect_pharm,
    DECODE(SUBSTR(extractvalue(outbmsg.message, 
'//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,5),'ERR03',1,0 ) 
new_rx_err_call_pharm,
    TRUNC(outbmsg.created_date) new_rx_message_date
  FROM erx.outbound_ncpdp_msg outbmsg,
    erx.pharmacy pharm
  WHERE outbmsg.pharmacy_id                                                                       
                   = pharm.pharmacy_id
  AND outbmsg.MESSAGE_STATUS NOT                                                                  
                  IN ('0000')
  AND outbmsg.message_type                                                                        
                  IN ('Error','Verify')
  AND outbmsg.PHARMACY_ID                                                                         
                  <> 0
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
  
  
  CREATE OR REPLACE VIEW "ERX"."SUMMARY_REPORT_VW" ("PHARMACY_NCPDP_ID", "PHARMACY_VA_STATION_ID", "PHARMACY_DIVISION_NAME", "VISN", "PHARMACY_ADDRESS", "NEW_RX_CNT", "NEW_RX_PHARM_DISABLED_AT_HUB", "NEW_RX_REJECTED_AT_HUB", "NEW_RX_PASS_AUTO_CHK", "NEW_RX_FAIL_AUTO_CHK", "NEW_RX_REJECTED_BY_PHARMACIST", "NEW_RX_FILLED", "NEW_RX_IN_PROCESS", "NEW_RX_MESSAGE_DATE") AS 
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
    DECODE(SUBSTR(extractvalue(outbmsg.message, '//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,3),'PTT',1,'ERR',1,'DRU',1,'PVD',1,0 ) new_rx_rejected_by_pharmacist,
    (existsNode(outbmsg.message, '//RxFill/FillStatus/PartialFill','xmlns="http://www.ncpdp.org/schema/SCRIPT"') + 
    existsNode(outbmsg.message, '//RxFill/FillStatus/Filled','xmlns="http://www.ncpdp.org/schema/SCRIPT"')) new_rx_filled,
        DECODE(extractvalue(outbmsg.message, '//VerifyStatus/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),'Accepted By Pharmacy.',1,0) + 
        DECODE(extractvalue(outbmsg.message, '//VerifyStatus/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),'',1,0) new_rx_in_process, --Accepted By Pharmacy + where Description is null to count legacy Verify messages created in Hub.
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