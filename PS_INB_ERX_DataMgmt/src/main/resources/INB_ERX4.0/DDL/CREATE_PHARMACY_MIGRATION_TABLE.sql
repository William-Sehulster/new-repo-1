DROP TABLE ERX.PHARMACY_MIGRATION CASCADE CONSTRAINTS ;

CREATE TABLE ERX.PHARMACY_MIGRATION
  (
    PHARMACY_NCPDP_ID         VARCHAR2(7) NOT NULL,       
	MIGRATED				  VARCHAR2(1 BYTE) DEFAULT 'Y' NOT NULL,
	CREATED_DATE     		  DATE,
    UPDATED_DATE     		  DATE  
  )
  LOGGING ;

CREATE UNIQUE INDEX ERX.PHARMACY_NCPDP_ID_UK ON ERX.PHARMACY_MIGRATION
  (
    PHARMACY_NCPDP_ID ASC
  )
  LOGGING ;
  
ALTER TABLE ERX.PHARMACY_MIGRATION ADD CONSTRAINT PHARMACY_NCPDP_ID_UK UNIQUE ( PHARMACY_NCPDP_ID ) USING INDEX ERX.PHARMACY_NCPDP_ID_UK ;

GRANT SELECT,INSERT,UPDATE,DELETE ON erx.pharmacy_migration TO erx_update_role;

GRANT SELECT ON erx.pharmacy_migration TO erx_read_role;

CREATE OR REPLACE PUBLIC SYNONYM pharmacy_migration FOR erx.pharmacy_migration;

INSERT INTO erx.pharmacy_migration VALUES ('1516206','Y',SYSDATE, SYSDATE);
INSERT INTO erx.pharmacy_migration VALUES ('1162700','Y',SYSDATE, SYSDATE);
INSERT INTO erx.pharmacy_migration VALUES ('0420466','Y',SYSDATE, SYSDATE);
INSERT INTO erx.pharmacy_migration VALUES ('3330773','Y',SYSDATE, SYSDATE);

COMMIT;