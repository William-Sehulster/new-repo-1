DROP TABLE ERX.ERX_STATUS CASCADE CONSTRAINTS ;

CREATE TABLE ERX.ERX_STATUS
  (
    CODE             VARCHAR2 (4) NOT NULL ,
    AUTO_CHECK       VARCHAR2 (15) ,
    CODE_DESCRIPTION VARCHAR2 (70) ,
    UPDATED_DATE     DATE ,
    CREATED_DATE     DATE
  )
  LOGGING ;

CREATE UNIQUE INDEX ERX.ERX_STATUS_PK ON ERX.ERX_STATUS
  (
    CODE ASC
  )
  LOGGING ;
