DROP INDEX erx.ib_xmlmessage_idx;

CREATE INDEX erx.ib_xmlmessage_idx ON erx.inbound_ncpdp_msg(message) INDEXTYPE IS XDB.XMLIndex local;
