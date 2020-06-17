--Inserts the new Drug Coverage Status Codes for 2017071

DELETE FROM ERX.ECL_CODE WHERE CODE_TYPE = 'DRUG_COVERAGE_STATUS_CODE';

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DRUG_COVERAGE_STATUS_CODE','PR','Preferred - Preferred means available on a pharmaceutical formulary in a manner such that the product is given preference in dispensing decisions over competing products in a therapeutic class or therapeutic use.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DRUG_COVERAGE_STATUS_CODE','AP','Approved - The product is included in the plan formulary.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DRUG_COVERAGE_STATUS_CODE','PA','Prior Authorization Required - A prior authorization is required before the prescription can be dispensed.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DRUG_COVERAGE_STATUS_CODE','NF','Non-Formulary - The product is not included in the plan formulary.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DRUG_COVERAGE_STATUS_CODE','NR','Not Reimbursed - The product is not reimbursable in the plan formulary.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DRUG_COVERAGE_STATUS_CODE','DC','Differential Co-Pay - The product may be subject to potentially higher copay.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DRUG_COVERAGE_STATUS_CODE','UN','Unknown - The coverage status code is not discernible.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DRUG_COVERAGE_STATUS_CODE','ST','Step Therapy Required - The plan formulary requires that medication in a specific drug class be tried prior to the requested medication.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DRUG_COVERAGE_STATUS_CODE','SI','Signed Prescription - This indicates the prescription has been signed according to the DEA requirements for electronic prescribing of controlled substances.');

COMMIT;
