
--Inserts reason codes for RxChange Response - Validated Type

DELETE FROM ERX.ECL_CODE WHERE CODE_TYPE = 'RXCHANGE_RESPONSE_VALIDATED_CODE';

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_VALIDATED_CODE', 'GM', 'Active Registration Status.');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_VALIDATED_CODE', 'GN', 'In-Active License with prescriptive authority based on state/federal regulations.');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_VALIDATED_CODE', 'GP', 'Active with Prescriptive Authority - prescribed product class.');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_VALIDATED_CODE', 'GQ', 'Active with Prescriptive Authority - Prescriber Type.');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_VALIDATED_CODE', 'GR', 'Active with Prescriptive Authority - Supervising Prescriber Type.');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_VALIDATED_CODE', 'GS', 'Registered.');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_VALIDATED_CODE', 'GT', 'Enrolled/Re-Enrolled.');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_VALIDATED_CODE', 'GU', 'Assigned.');

COMMIT;