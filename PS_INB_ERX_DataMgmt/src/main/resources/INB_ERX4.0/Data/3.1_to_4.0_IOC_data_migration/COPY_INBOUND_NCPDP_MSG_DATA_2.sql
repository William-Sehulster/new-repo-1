--This script will load the 10.6 messages from IEPP2 (previously loaded into erx.inbound_ncpdp_msg_tmp) into the IEPP table erx.inbound_ncpdp_msg.
--It should be run after COPY_INBOUND_NCPDP_MSG_DATA.sql which creates the required temp table of data from IEPP2 
 

INSERT INTO erx.inbound_ncpdp_msg (inbound_ncpdp_msg_id, message_id, rel_to_message_id, message_type, message_from, message,
pharmacy_id, patient_chk_status, patient_match_details, provider_chk_status, provider_match_details, drug_chk_status,
drug_match_details, message_status, message_status_details, received_date, updated_date, created_date)
SELECT * FROM erx.inbound_ncpdp_msg_tmp;

--Number of rows inserted should be 29,353 for IOC sites

