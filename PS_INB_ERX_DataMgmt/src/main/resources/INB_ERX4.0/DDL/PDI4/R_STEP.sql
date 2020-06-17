DROP TABLE PDI4.R_STEP
;

CREATE TABLE PDI4.R_STEP
(
  ID_STEP INTEGER
, ID_TRANSFORMATION INTEGER
, NAME VARCHAR2(255)
, DESCRIPTION CLOB
, ID_STEP_TYPE INTEGER
, DISTRIBUTE CHAR(1)
, COPIES INTEGER
, GUI_LOCATION_X INTEGER
, GUI_LOCATION_Y INTEGER
, GUI_DRAW CHAR(1)
, COPIES_STRING VARCHAR2(255)
, PRIMARY KEY (ID_STEP)
)
;