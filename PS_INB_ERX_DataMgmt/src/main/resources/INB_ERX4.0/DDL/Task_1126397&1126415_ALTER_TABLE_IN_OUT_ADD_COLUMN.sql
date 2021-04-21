ALTER TABLE erx.inbound_ncpdp_msg DROP COLUMN SCRIPT_VERSION;

ALTER TABLE erx.inbound_ncpdp_msg ADD (SCRIPT_VERSION VARCHAR2(10));

ALTER TABLE erx.outbound_ncpdp_msg DROP COLUMN SCRIPT_VERSION;

ALTER TABLE erx.outbound_ncpdp_msg ADD (SCRIPT_VERSION VARCHAR2(10));

--populate