--Task 1216693 - New codes to support suppressing the send of outbound from VistA VERIFY (accpetance) and ERROR (rejection) messages.

INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('4010','MESSAGE','OB_MSG_SEND_SUPPRESED_IN_PROGRESS');
INSERT INTO erx.erx_status (code, auto_check, code_description) VALUES ('4011','MESSAGE','OB_MSG_SEND_SUPPRESED_FOR_HUB_REPORTING_ONLY');

COMMIT;