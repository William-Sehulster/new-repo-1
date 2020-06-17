--Task 559662 script. Removes interval partitioning to enabe support for the domain index created on inbound_ncpdp_msg and outbound_ncpdp_msg tables.  Adds range partition to handle recieved_date values until 2099. 

alter table erx.inbound_ncpdp_msg set INTERVAL();

ALTER TABLE erx.INBOUND_NCPDP_MSG 
ADD PARTITION RCVD_DATE_P99 VALUES LESS THAN (TO_DATE('2099-12-31 00:00:00', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN'));

alter table erx.outbound_ncpdp_msg set INTERVAL();

ALTER TABLE erx.OUTBOUND_NCPDP_MSG 
ADD PARTITION RCVD_DATE_P99 VALUES LESS THAN (TO_DATE('2099-12-31 00:00:00', 'SYYYY-MM-DD HH24:MI:SS', 'NLS_CALENDAR=GREGORIAN'));
