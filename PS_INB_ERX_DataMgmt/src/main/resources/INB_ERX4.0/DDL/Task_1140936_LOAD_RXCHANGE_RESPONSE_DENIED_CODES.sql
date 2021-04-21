--Inserts codes for RxChange Response - Denied Type

DELETE FROM ERX.ECL_CODE WHERE CODE_TYPE = 'RXCHANGE_RESPONSE_DENIED_CODE';

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AA', 'Patient unknown to the Provider');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AB', 'Patient never under Provider care');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AC', 'Patient no longer under Provider care');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AE', 'Medication never prescribed for the patient');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AF', 'Patient should contact Provider first');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AL', 'Change not appropriate');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AM', 'Patient needs appointment');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AN', 'Prescriber not associated with this practice or location');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AO', 'No attempt will be made to obtain Prior Authorization');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'AP', 'Request was or will be responded to by other means (e.g. phone or fax)');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('RXCHANGE_RESPONSE_DENIED_CODE', 'BE', 'Medication denied at patient request');

COMMIT;