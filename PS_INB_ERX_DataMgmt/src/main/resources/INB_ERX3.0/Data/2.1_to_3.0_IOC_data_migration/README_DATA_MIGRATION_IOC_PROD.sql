-- This is the order of execution for the insert/merge from 2.0 to 3.0 database

-- 1) run alter_sequence first.  It needs to be run only once and NOT with each pharmacy migration
-- the script will increase the sequence values high enough so the duplicate values are not generated in the 2.0 database
-- prior to later 3.0 migrations

-- 2) copy_va_user_data.sql 
-- This script is setup to migrate only PBM, HPS and the IOC site users.  

-- 3) update_pharmacy_data.sql
-- Migrating 3 IOC pharmacies only.  Brooklyn is not setup in Prod currently

-- 4) copy_inbound_ncpdp_msg_data.sql
-- IOC pharmacy data only

-- 5) copy_outbound_ncpdp_msg_data.sql
-- IOC pharmacy data only