--update_inbound_msg_from_data.sql
--Updating past version 2.1 NewRx records where message_from column should contain the clinic_id version the NPI of the prescriber.

DROP TABLE erx.inbound_ncpdp_msg_tmp;

CREATE TABLE erx.inbound_ncpdp_msg_tmp as SELECT s.inbound_ncpdp_msg_id, x.clinic_id
  FROM erx.inbound_ncpdp_msg s,
    xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' AS "ns"), 
    '/ns:Message' passing s.message columns
    clinic_id VARCHAR2(35) path '//ns:Header/ns:From',
    npi VARCHAR2(35) path '//ns:Prescriber/ns:Identification/ns:NPI',
    message_id VARCHAR2(35) path '//ns:Header/ns:MessageID' ) x
  WHERE s.message_type       = 'NewRx'
  AND s.message             IS NOT NULL
  AND s.message_id           = x.message_id
  AND s.message_from         = x.npi
  AND s.pharmacy_id not in (142,23,264,108,0,42,41,40,43)
  AND s.inbound_ncpdp_msg_id < 200000;
  
  
  MERGE INTO erx.inbound_ncpdp_msg t1
  USING
    (SELECT *
        FROM erx.inbound_ncpdp_msg_tmp) t2
    ON(t1.inbound_ncpdp_msg_id = t2.inbound_ncpdp_msg_id)
      WHEN MATCHED THEN UPDATE SET
      t1.message_from = t2.clinic_id;
              
COMMIT;
  
DROP TABLE erx.inbound_ncpdp_msg_tmp;