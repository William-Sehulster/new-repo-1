--PROMPTs for database link name e.g.(ERXD2_DBLINK.AAC.VA.GOV)
accept dblink char prompt 'Enter source database link name: '

DROP TABLE erx.inbound_ncpdp_msg_tmp;

CREATE TABLE erx.inbound_ncpdp_msg_tmp as select * from erx.inbound_ncpdp_msg@&dblink
WHERE pharmacy_id in (142,23,264);

--merging only the IOC sites Indianapolis (142), Fayettville (23) and MbM Dublin (264)

INSERT INTO erx.inbound_ncpdp_msg (inbound_ncpdp_msg_id, message_id, rel_to_message_id, message_type, message_from, message,
pharmacy_id, patient_chk_status, patient_match_details, provider_chk_status, provider_match_details, drug_chk_status,
drug_match_details, message_status, message_status_details, received_date, updated_date, created_date)
SELECT * FROM erx.inbound_ncpdp_msg_tmp;

/* UPDATE THE IEPP2 CREATED DATE WITH VALUES FROM ORIGINAL TABLE ON IEPP */

UPDATE erx.INBOUND_NCPDP_MSG a 
SET a.CREATED_DATE = 
    (SELECT b.CREATED_DATE FROM erx.inbound_ncpdp_msg_tmp b 
                           WHERE a.INBOUND_NCPDP_MSG_ID = b.INBOUND_NCPDP_MSG_ID);
                                            
COMMIT;

DROP TABLE erx.inbound_ncpdp_msg_tmp;