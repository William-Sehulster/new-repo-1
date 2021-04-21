--This script will load the 10.6 messages from IEPP2 (previously loaded into erx.inbound_ncpdp_msg_tmp) into the IEPP table erx.outbound_ncpdp_msg.
--It should be run after COPY_OUTBOUND_NCPDP_MSG_DATA.sql which creates the required temp table of data from IEPP2 
 

INSERT INTO outbound_ncpdp_msg (outbound_ncpdp_msg_id, message_id, rel_to_message_id, message_type, message,
pharmacy_id, message_status, message_status_details, received_date, updated_date, created_date)
SELECT * FROM erx.outbound_ncpdp_msg_tmp;

--Number of rows inserted should be 136,688 
