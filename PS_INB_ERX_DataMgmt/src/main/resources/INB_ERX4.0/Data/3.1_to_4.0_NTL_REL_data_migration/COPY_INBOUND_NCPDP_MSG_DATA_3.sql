--This is script #3 which loads the remaining 10.6 messages for transistioned pharmacies from IEPP2 into IEPP
--This script will commit the inserted data from the COPY_INBOUND_NCPDP_MSG_DATA2.sql script and drop the temporary table
--It should be run after COPY_INBOUND_NCPDP_MSG_DATA2.sql is run and message counts are validated 
 
COMMIT;

DROP TABLE erx.inbound_ncpdp_msg_tmp;

