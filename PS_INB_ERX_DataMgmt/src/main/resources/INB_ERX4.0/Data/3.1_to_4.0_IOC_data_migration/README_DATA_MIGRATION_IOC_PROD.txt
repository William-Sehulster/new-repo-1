-- This is the order of execution for the insert/merge from 3.1 to 4.0 database

-- 1) run alter_sequence first.  It needs to be run only once and NOT with each pharmacy migration
-- the script will increase the sequence values high enough so the duplicate values are not generated in the 3.1 database
-- prior to later 4.0 migrations

-- 2) copy_va_user_data.sql 
-- This script will migrate all users.  It can be run initially for the IOC and then again for the full migration.

-- 3) update_pharmacy_data.sql
-- This script will migrate all pharmacies.  It can be run initially for the IOC and then again for the full migration.

-- 4) copy_inbound_ncpdp_msg_data.sql
-- IOC pharmacy data only at first.  Change the pharmacy_id(s) as required.

-- 5) copy_outbound_ncpdp_msg_data.sql
-- IOC pharmacy data only at first.  Change the pharmacy_id(s) as required.