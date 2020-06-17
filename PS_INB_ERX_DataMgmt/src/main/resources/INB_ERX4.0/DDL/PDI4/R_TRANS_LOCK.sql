DROP TABLE PDI4.R_TRANS_LOCK
;

CREATE TABLE PDI4.R_TRANS_LOCK
(
  ID_TRANS_LOCK INTEGER
, ID_TRANSFORMATION INTEGER
, ID_USER INTEGER
, LOCK_MESSAGE CLOB
, LOCK_DATE DATE
, PRIMARY KEY (ID_TRANS_LOCK)
)
;