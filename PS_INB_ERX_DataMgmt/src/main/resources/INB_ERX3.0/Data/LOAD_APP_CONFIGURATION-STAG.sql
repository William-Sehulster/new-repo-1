DELETE FROM erx.app_configuration;

INSERT INTO erx.app_configuration (key, value) VALUES ('MVI_RS_URI','/INB-ERX/services/rest/patientSearch/lookupPatientByName/');
INSERT INTO erx.app_configuration (key, value) VALUES ('EandE_RS_URI','/INB-ERX/services/rest/eandeVerify/fetchEligibilityStatusByKey');
INSERT INTO erx.app_configuration (key, value) VALUES ('ERX_URL','http://vaausappiep402.aac.va.gov');
INSERT INTO erx.app_configuration (key, value) VALUES ('MVI_EE_RETRY','3');
INSERT INTO erx.app_configuration (key, value) VALUES ('VISTA_RETRY','3');
INSERT INTO erx.app_configuration (key, value) VALUES ('DRGCHK_RS_URI','/INB-ERX/services/rest/drug/searchDrug');
INSERT INTO erx.app_configuration (key, value) VALUES ('PRVDRCHK_RS_URI','/INB-ERX/services/rest/provider/searchProvider/');
INSERT INTO erx.app_configuration (key, value) VALUES ('TO_VISTA_RS_URI','/INB-ERX/services/rest/sendInboundMessage/toVista');
INSERT INTO erx.app_configuration (key, value) VALUES ('OB_RS_URI','/INB-ERX/services/rest/outbound/outBoundNCPDPMessage');
INSERT INTO erx.app_configuration (key, value) VALUES ('OB_RETRY','3');
		
COMMIT;