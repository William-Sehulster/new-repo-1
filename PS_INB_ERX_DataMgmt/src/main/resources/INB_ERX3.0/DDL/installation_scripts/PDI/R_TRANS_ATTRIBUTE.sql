DROP TABLE PDI.R_TRANS_ATTRIBUTE
;


CREATE TABLE PDI.R_TRANS_ATTRIBUTE
(
  ID_TRANS_ATTRIBUTE INTEGER
, ID_TRANSFORMATION INTEGER
, NR INTEGER
, CODE VARCHAR2(255)
, VALUE_NUM INTEGER
, VALUE_STR CLOB
, PRIMARY KEY (ID_TRANS_ATTRIBUTE)
)
;

CREATE UNIQUE INDEX IDX_TATT ON PDI.R_TRANS_ATTRIBUTE(ID_TRANSFORMATION, CODE, NR)
;