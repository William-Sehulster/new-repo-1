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
    DECODE(extractvalue(outbmsg.message, 
'//Verify/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),'Accepted By Pharmacy.',1,0 
)  new_rx_in_process, --Accepted By Pharmacy.
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