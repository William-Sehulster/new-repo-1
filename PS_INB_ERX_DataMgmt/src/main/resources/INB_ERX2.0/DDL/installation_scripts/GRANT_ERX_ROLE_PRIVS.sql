-- Grants for erx_update_role 

GRANT SELECT,INSERT,UPDATE ON erx.app_configuration TO erx_update_role;
GRANT SELECT,INSERT,UPDATE ON erx.erx_status TO erx_update_role;
GRANT SELECT,INSERT,UPDATE ON erx.inbound_ncpdp_msg TO erx_update_role;
GRANT SELECT,INSERT,UPDATE ON erx.outbound_ncpdp_msg TO erx_update_role;
GRANT SELECT,INSERT,UPDATE,DELETE ON erx.pharmacy TO erx_update_role;
GRANT SELECT,INSERT,UPDATE,DELETE ON erx.va_user TO erx_update_role;

GRANT SELECT,INSERT,UPDATE ON erx.ncpdp_code TO erx_update_role;

GRANT SELECT,INSERT,UPDATE ON erx.ecl_code TO erx_update_role;

GRANT SELECT ON erx.summary_report_vw TO erx_update_role;

GRANT SELECT ON erx.ib_ncpdp_msg_id_seq TO erx_update_role;
GRANT SELECT ON erx.ob_ncpdp_msg_id_seq TO erx_update_role;
GRANT SELECT ON erx.users_id_seq TO erx_update_role;
GRANT SELECT ON erx.pharmacy_id_seq TO erx_update_role;


-- Grants for erx_read_role 

GRANT SELECT ON erx.app_configuration TO erx_read_role;
GRANT SELECT ON erx.erx_status TO erx_read_role;
GRANT SELECT ON erx.inbound_ncpdp_msg TO erx_read_role;
GRANT SELECT ON erx.outbound_ncpdp_msg TO erx_read_role;
GRANT SELECT ON erx.pharmacy TO erx_read_role;

GRANT SELECT ON erx.va_user TO erx_read_role;

GRANT SELECT ON erx.ncpdp_code TO erx_read_role;

GRANT SELECT ON erx.ecl_code TO erx_read_role;

GRANT SELECT ON erx.summary_report_vw TO erx_read_role;
