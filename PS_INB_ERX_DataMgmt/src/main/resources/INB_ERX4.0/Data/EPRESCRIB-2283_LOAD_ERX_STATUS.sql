--EPRECRIB-2283 - New codes to fix issue where attempting to send the same RxChangeResponse or RxRenewalResponse to VistA is possible
--if an auto-check retry condition occurs

INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0109','PATIENT','PATIENT_MATCH_NOT_APPLICABLE');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('1005','DRUG','DRUG_MATCH_NOT_APPLICABLE');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('2005','PROVIDER','PROVIDER_MATCH_NOT_APPLICABLE');

-- Cleanup unused codes

DELETE FROM erx.erx_status where code in ('3007', '3008');

-- New code to support suppressing the delivery of inbound ERROR messages when prescriber software doesn't support VERIFY messages.

INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3007','MESSAGE','VISTAOP_DELIVERY_SUPPRESSED');

COMMIT;