--PROMPTs for database link name e.g.(ERXD2_DBLINK.AAC.VA.GOV)
accept dblink char prompt 'Enter source database link name: '

DROP TABLE erx.outbound_ncpdp_msg_tmp;

CREATE TABLE erx.outbound_ncpdp_msg_tmp as select * from erx.outbound_ncpdp_msg@&dblink
WHERE pharmacy_id in (142,23,264);

--merging only the IOC sites Indianapolis (142), Fayettville (23) and MbM Dublin (264)

INSERT INTO outbound_ncpdp_msg (outbound_ncpdp_msg_id, message_id, rel_to_message_id, message_type, message,
pharmacy_id, message_status, message_status_details, received_date, updated_date, created_date)
SELECT * FROM erx.outbound_ncpdp_msg_tmp;


DROP TABLE erx.outbound_ncpdp_msg_tmp;
