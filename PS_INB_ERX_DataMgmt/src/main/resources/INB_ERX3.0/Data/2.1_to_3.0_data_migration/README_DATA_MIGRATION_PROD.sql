-- This is the order of execution for the insert/merge from 2.1 to 3.0 database

1) create_pharmacy_migration_table.sql
--This script creates and loads the erx.pharmacy_migration table

2) copy_va_user_data.sql 
--This script is setup to migrate all site users excluding previous migrated users PBM, HPS and the IOC site users.  

3) update_pharmacy_data.sql
--Migrating all pharmacy data excluding 3 IOC pharmacies already migrated.

4) copy_inbound_ncpdp_msg_data.sql
--excluding IOC pharmacy data

5) copy_outbound_ncpdp_msg_data.sql
--excluding IOC pharmacy data