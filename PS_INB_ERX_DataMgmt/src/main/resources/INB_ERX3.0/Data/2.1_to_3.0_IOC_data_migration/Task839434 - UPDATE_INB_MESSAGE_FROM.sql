UPDATE inbound_ncpdp_msg t
SET message_from =
  (SELECT x.clinic_id
  FROM inbound_ncpdp_msg s,
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