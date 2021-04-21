-- This is the order of execution for the insert/merge from 3.1 to 4.0 database
-- For post IOC data migration after all pharmacies are migrated from 3.1
-- The scripts contain row counts to use for verification of success

--1) Migrate the remaining inbound data for the National Release Pharmacies
-- copy_inbound_ncpdp_msg_data.sql
-- copy_inbound_ncpdp_msg_data_2.sql
-- copy_inbound_ncpdp_msg_data_3.sql

--2) Migrate the remaining outbound data for the National Release Pharmacies
-- copy_outbound_ncpdp_msg_data.sql
-- copy_outbound_ncpdp_msg_data_2.sql
-- copy_outbound_ncpdp_msg_data_3.sql