--PROMPTs for database link name e.g.(ERXD2_DBLINK.AAC.VA.GOV)
accept dblink char prompt 'Enter source database link name: '

DROP TABLE erx.inbound_ncpdp_msg_tmp;

CREATE TABLE erx.inbound_ncpdp_msg_tmp as select * from erx.inbound_ncpdp_msg@&dblink
WHERE pharmacy_id not in (142,23,264,108,0,42,41,40,43) and inbound_ncpdp_msg_id > 1;

--excluding the previously merged the IOC sites Indianapolis (142), Fayettville (23) and MbM Dublin (264)

INSERT INTO erx.inbound_ncpdp_msg (inbound_ncpdp_msg_id, message_id, rel_to_message_id, message_type, message_from, message,
pharmacy_id, patient_chk_status, patient_match_details, provider_chk_status, provider_match_details, drug_chk_status,
drug_match_details, message_status, message_status_details, received_date, updated_date, created_date)
SELECT * FROM erx.inbound_ncpdp_msg_tmp;

/* UPDATE THE CREATED DATE WITH VALUES FROM ORIGINAL TABLE  */

UPDATE erx.INBOUND_NCPDP_MSG a 
SET a.CREATED_DATE = 
    (SELECT b.CREATED_DATE FROM erx.inbound_ncpdp_msg_tmp b 
                           WHERE a.INBOUND_NCPDP_MSG_ID = b.INBOUND_NCPDP_MSG_ID)
                           WHERE a.pharmacy_id not in (142,23,264,108,0,42,41,40,43) and inbound_ncpdp_msg_id > 1;

/* Updates the message_from to the clinic_id versus npi for 2.1 records related to Task 839434*/
UPDATE erx.inbound_ncpdp_msg t
SET message_from =
  (SELECT x.clinic_id
  FROM erx.inbound_ncpdp_msg_tmp s,
    xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' AS "ns"), 
    '/ns:Message' passing t.message columns
    clinic_id VARCHAR2(35) path '//ns:Header/ns:From',
    npi VARCHAR2(35) path '//ns:Prescriber/ns:Identification/ns:NPI',
    message_id VARCHAR2(35) path '//ns:Header/ns:MessageID' ) x
  WHERE s.message_type       = 'NewRx'
  AND s.message             IS NOT NULL
  AND s.inbound_ncpdp_msg_id = t.inbound_ncpdp_msg_id
  AND s.message_id           = t.message_id
  AND s.message_id           = x.message_id
  AND s.message_from         = x.npi
  )
WHERE t.inbound_ncpdp_msg_id < 200000
AND t.message_type = 'NewRx'
AND t.pharmacy_id not in (142,23,264,108);
                                            
COMMIT;

DROP TABLE erx.inbound_ncpdp_msg_tmp;