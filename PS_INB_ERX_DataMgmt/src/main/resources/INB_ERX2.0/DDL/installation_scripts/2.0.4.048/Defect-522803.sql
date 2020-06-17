--Defect 522803

ALTER TABLE erx.va_user add (updated_by VARCHAR2(20));

ALTER TABLE erx.va_user add (created_by VARCHAR2(20));

GRANT SELECT,INSERT,UPDATE,DELETE ON erx.va_user TO erx_update_role;