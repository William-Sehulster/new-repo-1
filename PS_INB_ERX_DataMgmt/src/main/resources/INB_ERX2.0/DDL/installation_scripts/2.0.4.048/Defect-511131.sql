DROP TABLE ERX.ECL_CODE CASCADE CONSTRAINTS ;

CREATE TABLE ERX.ECL_CODE
  (
    CODE_TYPE		VARCHAR2(2000),
    CODE     	VARCHAR2(7),
  	DEFINITION     	VARCHAR2(2000)
  )
  LOGGING ;

GRANT SELECT,INSERT,UPDATE ON erx.ecl_code TO erx_update_role;
GRANT SELECT ON erx.ecl_code TO erx_read_role;

CREATE OR REPLACE PUBLIC SYNONYM ecl_code FOR erx.ecl_code;

REM INSERTING into ERX.ECL_CODE
SET DEFINE OFF;
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AA','Patient unknown to the Prescriber');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AB','Patient never under Prescriber care');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AC','Patient no longer under Prescriber care');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AD','Patient has requested refill too soon');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AE','Medication never prescribed for the patient');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AF','Patient should contact Prescriber first');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AG','Refill not appropriate');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AH','Patient has picked up prescription');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AJ','Patient has picked up partial fill of prescription');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AK','Patient has not picked up prescription, drug returned to stock');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AL','Change not appropriate');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AM','Patient needs appointment');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AN','Prescriber not associated with this practice or location.');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AO','No attempt will be made to obtain Prior Authorization');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AP','Request already responded to by other means (e.g. phone or fax)');
Insert into ERX.ECL_CODE (CODE_TYPE,CODE,DEFINITION) values ('1131 – Code List Qualifier – Response Code - RES Segment','AQ','More Medication History Available');


commit;