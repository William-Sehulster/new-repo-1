--Task 559662 rollback script. Removes interval partitioning to enabe support for the domain index created on inbound_ncpdp_msg and outbound_ncpdp_msg tables.  Adds range partition to handle recieved_date values until 2099. 


alter table erx.inbound_ncpdp_msg set INTERVAL (NUMTOYMINTERVAL(1, 'MONTH'));

DROP INDEX erx.ib_xmlmessage_idx;

alter table erx.outbound_ncpdp_msg set INTERVAL (NUMTOYMINTERVAL(1, 'MONTH'));

DROP INDEX erx.ob_xmlmessage_idx;

