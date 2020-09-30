--PROMPTs for database link name e.g.(ERXD2_DBLINK.AAC.VA.GOV)
accept dblink char prompt 'Enter source database link name: '

DROP TABLE erx.pharmacy_tmp;

CREATE TABLE erx.pharmacy_tmp as select * from erx.pharmacy@&dblink;


--merging all pharmacies

MERGE INTO erx.pharmacy target
USING (SELECT
pharmacy_id,
va_station_id,
visn,
division_name,
ncpdp_id,
npi,
store_name,
pharmacist_last_name,
pharmacist_first_name,
pharmacist_middle_name,
pharmacist_suffix,
pharmacist_prefix,
pharmacy_address_line_1,
pharmacy_address_line_2,
pharmacy_city,
pharmacy_state,
pharmacy_zipcode,
cross_street,
pharmacy_phone_number,
pharmacy_fax_number,
inbound_erx_enabled,
updated_date,
created_date,
created_by,
updated_by,
eande_check
FROM erx.pharmacy_tmp) s
ON (target.pharmacy_id = s.pharmacy_id)
WHEN MATCHED THEN
	UPDATE SET
target.va_station_id = s.va_station_id,
target.visn = s.visn,
target.division_name = s.division_name,
target.ncpdp_id = s.ncpdp_id,
target.npi = s.npi,
target.store_name = s.store_name,
target.pharmacist_last_name = s.pharmacist_last_name,
target.pharmacist_first_name = s.pharmacist_first_name,
target.pharmacist_middle_name = s.pharmacist_middle_name,
target.pharmacist_suffix = s.pharmacist_suffix,
target.pharmacist_prefix = s.pharmacist_prefix,
target.pharmacy_address_line_1 = s.pharmacy_address_line_1,
target.pharmacy_address_line_2 = s.pharmacy_address_line_2,
target.pharmacy_city = s.pharmacy_city,
target.pharmacy_state = s.pharmacy_state,
target.pharmacy_zipcode = s.pharmacy_zipcode,
target.cross_street = s.cross_street,
target.pharmacy_phone_number = s.pharmacy_phone_number,
target.pharmacy_fax_number = s.pharmacy_fax_number,
target.inbound_erx_enabled = s.inbound_erx_enabled,
target.updated_date = s.updated_date,
target.created_date = s.created_date,
target.created_by = s.created_by,
target.updated_by = s.updated_by,
target.eande_check = s.eande_check
WHEN NOT MATCHED THEN
INSERT
(pharmacy_id,
va_station_id,
visn,
division_name,
ncpdp_id,
npi,
store_name,
pharmacist_last_name,
pharmacist_first_name,
pharmacist_middle_name,
pharmacist_suffix,
pharmacist_prefix,
pharmacy_address_line_1,
pharmacy_address_line_2,
pharmacy_city,
pharmacy_state,
pharmacy_zipcode,
cross_street,
pharmacy_phone_number,
pharmacy_fax_number,
inbound_erx_enabled,
updated_date,
created_date,
created_by,
updated_by,
eande_check)
VALUES (
s.pharmacy_id,
s.va_station_id,
s.visn,
s.division_name,
s.ncpdp_id,
s.npi,
s.store_name,
s.pharmacist_last_name,
s.pharmacist_first_name,
s.pharmacist_middle_name,
s.pharmacist_suffix,
s.pharmacist_prefix,
s.pharmacy_address_line_1,
s.pharmacy_address_line_2,
s.pharmacy_city,
s.pharmacy_state,
s.pharmacy_zipcode,
s.cross_street,
s.pharmacy_phone_number,
s.pharmacy_fax_number,
s.inbound_erx_enabled,
s.updated_date,
s.created_date,
s.created_by,
s.updated_by,
s.eande_check);

DROP TABLE erx.pharmacy_tmp;
