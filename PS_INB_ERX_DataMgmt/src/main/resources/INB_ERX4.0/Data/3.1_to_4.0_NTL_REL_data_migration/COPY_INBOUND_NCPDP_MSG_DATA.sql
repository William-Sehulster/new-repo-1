--PROMPTs for database link name e.g.(IEPP2.AAC.VA.GOV@IEPP2)

--This script will pull the 10.6 messages from IEPP2 for the sites and time range defined in the CREATE TABLE AS
--statement below and then load them into a temporary table on IEPP (version 4 DB).
--It should be run from IEPP and the DB link from IEPP to IEPP2 must be in place.

accept dblink char prompt 'Enter source database link name: '

DROP TABLE erx.inbound_ncpdp_msg_tmp;

--pulling data for all sites EXCLUDING the 4.0 IOC sites Honolulu (137), Indianapolis (142), MbM Chey (365) and MbM Dublin (264)

CREATE TABLE erx.inbound_ncpdp_msg_tmp unrecoverable as select * from erx.inbound_ncpdp_msg@&dblink t
WHERE t.pharmacy_id not in (137,142,365,264) and t.message_type in ('NewRx','CancelRx','RefillResponse')
                            and t.message_status = '3002'
                            and t.received_date between to_date('2020-11-12 21:03:00', 'YYYY-MM-DD HH24:MI:SS') and SYSDATE;
							

SELECT COUNT(inbound_ncpdp_msg_id) from erx.inbound_ncpdp_msg_tmp;
--Count should equal 167,870


