 CREATE OR REPLACE FORCE VIEW "ERX"."AUTO_CHECK_REPORT_VW" ("PHARMACY_NCPDP_ID",
 "PHARMACY_VA_STATION_ID",
 "PHARMACY_DIVISION_NAME",
 "VISN",
 "PHARMACY_ADDRESS",
 "NEW_RX_CNT",
 "NEW_RX_PASS_AUTO_CHK",
 "NEW_RX_FAIL_AUTO_CHK",
 "NEW_RX_MVI_PAT_FOUND",
 "NEW_RX_MVI_PAT_NOT_FOUND",
 "NEW_RX_ENE_ELGB_ENRL",
 "NEW_RX_ENE_NOT_ELGB_ENRL",
 "NEW_RX_PAT_NOT_ENRL_SITE",
 "NEW_RX_DRG_MTCH_FND",
 "NEW_RX_DRG_MTCH_NOT_FND",
 "NEW_RX_PVD_MTCH_FND",
 "NEW_RX_PVD_MTCH_NOT_FND",
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
  SUM(new_rx_cnt) new_rx_cnt,
  SUM(new_rx_pass_auto_chk) new_rx_pass_auto_chk,
  SUM(new_rx_fail_auto_chk) new_rx_fail_auto_chk,
  SUM(new_rx_mvi_pat_found)  new_rx_mvi_pat_found,
  SUM(new_rx_mvi_pat_not_found)  new_rx_mvi_pat_not_found,
  SUM(new_rx_ene_elgb_enrl)  new_rx_ene_elgb_enrl,
  SUM(new_rx_ene_not_elgb_enrl)  new_rx_ene_not_elgb_enrl,
  SUM(new_rx_pat_not_enrl_site)  new_rx_pat_not_enrl_site,
  SUM(new_rx_drg_mtch_fnd)  new_rx_drg_mtch_fnd,
  SUM(new_rx_drg_mtch_not_fnd)  new_rx_drg_mtch_not_fnd,
  SUM(new_rx_pvd_mtch_fnd)  new_rx_pvd_mtch_fnd,
  SUM(new_rx_pvd_mtch_not_fnd)  new_rx_pvd_mtch_not_fnd,
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
    DECODE((DECODE(inbmsg.patient_chk_status,'0101',1,0) + DECODE(inbmsg.provider_chk_status,'2001',1,0) + DECODE(inbmsg.drug_chk_status,'1001',1,0)), 3, 1, 0) new_rx_pass_auto_chk,
    DECODE((DECODE(inbmsg.patient_chk_status,'0101',1,0) + DECODE(inbmsg.provider_chk_status,'2001',1,0) + DECODE(inbmsg.drug_chk_status,'1001',1,0)), 3, 0, 1) - DECODE(inbmsg.message_status, '3006', 1, 0) + DECODE(inbmsg.message_status, '3010', 1, 0) new_rx_fail_auto_chk,
    DECODE(inbmsg.patient_chk_status,'0001',1,0)  new_rx_mvi_pat_found,
    DECODE(inbmsg.patient_chk_status,'0002',1,'0003',1,0)  new_rx_mvi_pat_not_found,
    DECODE(inbmsg.patient_chk_status,'0101',1,0)  new_rx_ene_elgb_enrl,
    DECODE(inbmsg.patient_chk_status,'0102',1,'0103',1,0)  new_rx_ene_not_elgb_enrl,
    DECODE(inbmsg.patient_chk_status,'0106',1,0)  new_rx_pat_not_enrl_site,
    DECODE(inbmsg.drug_chk_status,'1001',1,0) new_rx_drg_mtch_fnd,
    DECODE(inbmsg.drug_chk_status,'1002',1,'1003',1,0)  new_rx_drg_mtch_not_fnd,
    DECODE(inbmsg.provider_chk_status,'2001',1,0)  new_rx_pvd_mtch_fnd,
    DECODE(inbmsg.provider_chk_status,'2002',1,'2003',1,0)  new_rx_pvd_mtch_not_fnd,
    TRUNC(inbmsg.created_date) new_rx_message_date
  FROM erx.inbound_ncpdp_msg inbmsg,
    erx.pharmacy pharm
  WHERE inbmsg.pharmacy_id       = pharm.pharmacy_id
  AND inbmsg.MESSAGE_STATUS NOT IN ('0000')
  AND inbmsg.message_type       IN ('NewRx'))
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
