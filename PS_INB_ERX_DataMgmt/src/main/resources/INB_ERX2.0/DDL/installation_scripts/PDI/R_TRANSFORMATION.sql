DROP TABLE PDI.R_TRANSFORMATION
;

CREATE TABLE PDI.R_TRANSFORMATION
(
  ID_TRANSFORMATION INTEGER
, ID_DIRECTORY INTEGER
, NAME VARCHAR2(255)
, DESCRIPTION CLOB
, EXTENDED_DESCRIPTION CLOB
, TRANS_VERSION VARCHAR2(255)
, TRANS_STATUS INTEGER
, ID_STEP_READ INTEGER
, ID_STEP_WRITE INTEGER
, ID_STEP_INPUT INTEGER
, ID_STEP_OUTPUT INTEGER
, ID_STEP_UPDATE INTEGER
, ID_DATABASE_LOG INTEGER
, TABLE_NAME_LOG VARCHAR2(255)
, USE_BATCHID CHAR(1)
, USE_LOGFIELD CHAR(1)
, ID_DATABASE_MAXDATE INTEGER
, TABLE_NAME_MAXDATE VARCHAR2(255)
, FIELD_NAME_MAXDATE VARCHAR2(255)
, OFFSET_MAXDATE NUMBER(12, 2)
, DIFF_MAXDATE NUMBER(12, 2)
, CREATED_USER VARCHAR2(255)
, CREATED_DATE DATE
, MODIFIED_USER VARCHAR2(255)
, MODIFIED_DATE DATE
, SIZE_ROWSET INTEGER
, PRIMARY KEY (ID_TRANSFORMATION)
)
;