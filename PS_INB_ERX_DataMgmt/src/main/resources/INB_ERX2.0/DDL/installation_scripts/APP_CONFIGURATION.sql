DROP TABLE ERX.APP_CONFIGURATION CASCADE CONSTRAINTS ;

CREATE TABLE ERX.APP_CONFIGURATION
  (
    KEY          VARCHAR2 (15) NOT NULL ,
    VALUE        VARCHAR2 (70) ,
    UPDATED_DATE  DATE ,
    CREATED_DATE DATE
  )
  LOGGING ;
CREATE UNIQUE INDEX ERX.APP_CONFIGURATION_PK ON ERX.APP_CONFIGURATION
  (
    KEY ASC
  )
  LOGGING ;
