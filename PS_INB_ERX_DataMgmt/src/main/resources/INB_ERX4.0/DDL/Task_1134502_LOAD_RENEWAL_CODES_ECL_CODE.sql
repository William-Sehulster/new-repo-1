--Inserts the new Renewal Denied codes for 2017071

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('1131 - Code List Qualifier - Response Code - RES Segment', 'BE', 'Medication denied at patient request');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('1131 - Code List Qualifier - Response Code - RES Segment', 'CZ', 'Patient had allergy to requested medication');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('1131 - Code List Qualifier - Response Code - RES Segment', 'DA',  'Medication has been discontinued');

UPDATE ERX.ECL_CODE
SET DEFINITION = 'Fill/Refill not appropriate'
WHERE CODE = 'AG' AND CODE_TYPE = '1131 – Code List Qualifier – Response Code - RES Segment';

UPDATE ERX.ECL_CODE
SET DEFINITION = 'Prescriber not associated with this practice or location'
WHERE CODE = 'AN' AND CODE_TYPE = '1131 – Code List Qualifier – Response Code - RES Segment';

COMMIT;