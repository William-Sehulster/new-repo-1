--Inserts the new Prior Authorization Status Codes for 2017071

DELETE FROM ERX.ECL_CODE WHERE CODE_TYPE = 'PRIOR_AUTH_STATUS_CODE';

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('PRIOR_AUTH_STATUS_CODE','A','Approved - The medication was approved by the payer.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('PRIOR_AUTH_STATUS_CODE','D','Denied - The medication was not approved by the payer.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('PRIOR_AUTH_STATUS_CODE','F','Deferred - The medication request being reviewed by the payer.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('PRIOR_AUTH_STATUS_CODE','N','Not Required - A prior authorization is not required for this medication.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('PRIOR_AUTH_STATUS_CODE','R','Requested - The action of obtaining a prior authorization approval is being sought.');

COMMIT;
