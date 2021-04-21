-- EPRESCRIB-942 -- load new configuration value (TO_VISTA_LB_DYS) in to erx.app_configuration table to support
-- partition pruning on main send to Vista Pentaho Job to improve SQL performance
-- if needed this parameter can be changed to increase the days in the past the job will look for 
-- processed messages to deliver in the event of an out or other situation where messages could
-- back up in the queue waiting for delivery
-- Additionally loading new configuration value (ERR_SUPP_DLVRY) which allows the inbound delivery to 
-- to VistA to be suppressed for certain ERROR messages that don't add functional value in the holding
-- queue.  For example, when the prescriber system doesn't support/accpet electronic VERIFY messages 

ALTER TABLE erx.app_configuration modify (value VARCHAR2(2000));

DELETE FROM erx.app_configuration where key = 'TO_VISTA_LB_DYS';

INSERT INTO erx.app_configuration (key, value) values ('TO_VISTA_LB_DYS','7');

DELETE FROM erx.app_configuration where key = 'ERR_SUPP_DLVRY';

INSERT INTO erx.app_configuration (key, value) values ('ERR_SUPP_DLVRY','ERX630 PRESCRIBER DOES NOT ACCEPT ELECTRONIC VERIFY');

COMMIT;