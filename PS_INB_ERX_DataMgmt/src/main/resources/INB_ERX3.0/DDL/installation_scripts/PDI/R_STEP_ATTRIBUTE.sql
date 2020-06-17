DROP TABLE PDI.R_STEP_ATTRIBUTE
;

CREATE TABLE PDI.R_STEP_ATTRIBUTE
(
  ID_STEP_ATTRIBUTE INTEGER
, ID_TRANSFORMATION INTEGER
, ID_STEP INTEGER
, NR INTEGER
, CODE VARCHAR2(255)
, VALUE_NUM INTEGER
, VALUE_STR CLOB
, PRIMARY KEY (ID_STEP_ATTRIBUTE)
)
;

CREATE UNIQUE INDEX IDX_RSAT ON PDI.R_STEP_ATTRIBUTE(ID_STEP, CODE, NR)
;