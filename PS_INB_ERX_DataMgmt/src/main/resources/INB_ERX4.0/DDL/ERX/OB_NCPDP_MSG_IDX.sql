DROP INDEX erx.ob_xmlmessage_idx;

CREATE INDEX erx.ob_xmlmessage_idx ON erx.outbound_ncpdp_msg(message) INDEXTYPE IS XDB.XMLIndex local;