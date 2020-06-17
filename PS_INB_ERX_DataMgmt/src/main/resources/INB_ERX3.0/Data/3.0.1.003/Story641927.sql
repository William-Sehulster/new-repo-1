--Story 641927
--Adding new message status code and configuration value to support outbound message send retry

DELETE FROM erx.erx_status where code = '4004';

INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('4004','MESSAGE','OB_MSG_DELIVERY_FAILED_AWAITING_RETRY');

DELETE FROM erx.app_configuration where key = 'OB_RETRY';

INSERT INTO erx.app_configuration (key, value) VALUES ('OB_RETRY','3');

COMMIT;