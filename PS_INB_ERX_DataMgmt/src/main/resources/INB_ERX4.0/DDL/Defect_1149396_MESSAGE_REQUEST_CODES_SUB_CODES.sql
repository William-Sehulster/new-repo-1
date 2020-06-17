--Insert Message Request Codes into ECL_CODE table

DELETE FROM ERX.ECL_CODE WHERE CODE_TYPE = 'MESSSAGE_REQUEST_CODE';

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_CODE','G', 'Generic Substitution - A modification of the product prescribed to a generic equivalent.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_CODE','P', 'Prior Authorization Required - A request to obtain prior authorization before dispensing.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_CODE','T', 'Therapeutic Interchange/Substitution - A modification of the product prescribed to a preferred product choice.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_CODE','D', 'DUE ( Drug Use Evaluation)');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_CODE','S', 'Script Clarification - The pharmacist needs to clarify what the prescriber is sending.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_CODE','OS', 'Out of Stock - Pharmacy is out of stock of the medication prescribed and it cannot be obtained in a clinically appropriate timeframe.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_CODE','U', 'Prescriber Authorization - Resolution of the prescriber authorization conflict related to state/federal regulatory requirements is required before dispensing.');


--Insert Message Request Sub Codes into ECL_CODE table

DELETE FROM ERX.ECL_CODE WHERE CODE_TYPE = 'MESSSAGE_REQUEST_SUB_CODE';

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','A', 'Prescriber must confirm their State license status');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','B', 'Prescriber must confirm their DEA license status in prescribing state');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','C', 'Prescriber must confirm their DEA registration by DEA class');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','D', 'Prescriber must confirm their State Controlled Substance Registration license status');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','E', 'Prescriber must confirm their registration by State Controlled Substance Registration class');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','F', 'Prescriber must confirm their NADEAN license status');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','G', 'Prescriber must obtain/validate Type1 NPI');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','H', 'Prescriber must enroll/re-enroll with prescription benefit plan');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','I', 'Prescriber must confirm prescriptive authority criteria for prescribed medication is met');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','J', 'Prescriber must enroll/re-enroll in REMS');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','K', 'Prescriber must confirm their assignment as patients'' lock-in prescriber');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','L', 'Prescriber must obtain/validate their supervising prescriber');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('MESSSAGE_REQUEST_SUB_CODE','M', 'Prescriber must confirm their Certificate to Prescribe Number status');

COMMIT;