-- Create of replace all eRx Public synonyms 

CREATE OR REPLACE PUBLIC SYNONYM app_configuration FOR erx.app_configuration;
CREATE OR REPLACE PUBLIC SYNONYM erx_status FOR erx.erx_status;
CREATE OR REPLACE PUBLIC SYNONYM inbound_ncpdp_msg FOR erx.inbound_ncpdp_msg;
--CREATE OR REPLACE PUBLIC SYNONYM inbound_ncpdp_msg_hist FOR erx.inbound_ncpdp_msg_hist;
CREATE OR REPLACE PUBLIC SYNONYM outbound_ncpdp_msg FOR erx.outbound_ncpdp_msg;
--CREATE OR REPLACE PUBLIC SYNONYM outbound_ncpdp_msg_hist FOR erx.outbound_ncpdp_msg_hist;
CREATE OR REPLACE PUBLIC SYNONYM pharmacy FOR erx.pharmacy;
CREATE OR REPLACE PUBLIC SYNONYM va_user FOR erx.va_user;
CREATE OR REPLACE PUBLIC SYNONYM ncpdp_code FOR erx.ncpdp_code;
CREATE OR REPLACE PUBLIC SYNONYM ecl_code FOR erx.ecl_code;
CREATE OR REPLACE PUBLIC SYNONYM summary_report_vw FOR erx.summary_report_vw;
CREATE OR REPLACE PUBLIC SYNONYM ib_ncpdp_msg_id_seq FOR erx.ib_ncpdp_msg_id_seq;
CREATE OR REPLACE PUBLIC SYNONYM ob_ncpdp_msg_id_seq FOR erx.ob_ncpdp_msg_id_seq;
CREATE OR REPLACE PUBLIC SYNONYM users_id_seq FOR erx.users_id_seq;
CREATE OR REPLACE PUBLIC SYNONYM pharmacy_id_seq FOR erx.pharmacy_id_seq;
