--Inserts the new Renewal Denied codes for 2017071 and corrects to legacy incorrect descriptions.

DELETE FROM ERX.ECL_CODE WHERE CODE IN ('BE','CZ','DA');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('1131 - Code List Qualifier - Response Code - RES Segment', 'BE', 'Medication denied at patient request');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('1131 - Code List Qualifier - Response Code - RES Segment', 'CZ', 'Patient had allergy to requested medication');

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('1131 - Code List Qualifier - Response Code - RES Segment', 'DA',  'Medication has been discontinued');

UPDATE ERX.ECL_CODE
SET DEFINITION = 'Fill/Refill not appropriate'
WHERE CODE = 'AG';

UPDATE ERX.ECL_CODE
SET DEFINITION = 'Prescriber not associated with this practice or location'
WHERE CODE = 'AN';

COMMIT;