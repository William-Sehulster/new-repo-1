DELETE FROM erx.erx_status;

INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0000','MESSAGE', 'READY_FOR_AUTOCHECK');

--PATIENT CHECK STATUS
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0001','PATIENT', 'MVI_MATCH_FOUND');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0002','PATIENT', 'MVI_MATCH_NOT_FOUND');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0003','PATIENT', 'MVI_RETRIES_EXCEEDED_SERVICE_NOT_REACHABLE');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0004','PATIENT', 'MVI_SERVICE_NOT_REACHABLE_AWAITING_RETRY');

INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0101','PATIENT', 'EandE_PATIENT_ELIGIBLE');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0102','PATIENT', 'EandE_PATIENT_NOT_ELIGIBLE');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0103','PATIENT', 'EandE_RETRIES_EXCEEDED_SERVICE_NOT_REACHABLE');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0104','PATIENT', 'PATIENT_MATCH_FOUND');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0105','PATIENT', 'PATIENT_MATCH_NOT_FOUND');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0106','PATIENT', 'PATIENT_SITE_REGISTRATION_NOT_CONFIRMED');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('0107','PATIENT', 'EandE_SERVICE_NOT_REACHABLE_AWAITING_RETRY');

--DRUG CHECK STATUS
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('1001','DRUG', 'VISTAOP_DRUG_MATCH_FOUND');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('1002','DRUG', 'VISTAOP_DRUG_MATCH_NOT_FOUND');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('1003','DRUG', 'VISTAOP_RETRIES_EXCEEDED_DRUG_RPC_NOT_AVAILABLE');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('1004','DRUG', 'VISTAOP_DRUG_RPC_NOT_AVAILABLE_AWAITING_RETRY');

--PROVIDER CHECK STATUS
INSERT INTO ERX.ERX_STATUS (code, auto_check, code_description) VALUES ('2001','PROVIDER','VISTAOP_PROVIDER_MATCH_FOUND');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('2002','PROVIDER','VISTAOP_PROVIDER_MATCH_NOT_FOUND/PROVIDER_NOT_AUTHORIZED');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('2003','PROVIDER','VISTAOP_RETRIES_EXCEEDED_PROVIDER_RPC_NOT_AVAILABLE');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('2004','PROVIDER','VISTAOP_PROVIDER_RPC_NOT_AVAILABLE_AWAITING_RETRY');

--MESSAGE LEVEL STATUS
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3001','MESSAGE','AUTOCHECK_PROCESSING_COMPLETED');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3002','MESSAGE','VISTAOP_DELIVERY_SUCCESSFUL');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3003','MESSAGE','VISTAOP_DELIVERY_IN_PROCESS');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3004','MESSAGE','VISTAOP_DELIVERY_FAILED_AWAITING_RETRY');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3005','MESSAGE','VISTAOP_DELIVERY_RETRIES_EXCEEDED');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3006','MESSAGE','NCPDP_MSG_INVALID');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3007','MESSAGE','VISTAOP_OB_VISTA_MSG_TRANSLATION_SUCCESSFUL');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3008','MESSAGE','VISTAOP_OB_VISTA_MSG_TRANSLATION_FAILED');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3009','MESSAGE','AUTOCHECK_IN_PROGRESS');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3010','MESSAGE','PHARMACY_INBOUND_ERX_NOT_ENABLED');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('3011','MESSAGE','PHARMACY_UNKNOWN');

INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('4001','MESSAGE','OB_MSG_SEND_COMPLETED');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('4005','MESSAGE','OB_MSG_DELIVERY_RETRIES_EXCEEDED');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('4009','MESSAGE','OB_MSG_SEND_IN_PROGRESS');


COMMIT;