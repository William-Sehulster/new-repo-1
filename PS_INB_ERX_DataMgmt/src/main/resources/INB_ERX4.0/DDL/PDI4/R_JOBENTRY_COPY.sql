DROP TABLE PDI4.R_JOBENTRY_COPY
;

CREATE TABLE PDI4.R_JOBENTRY_COPY
(
  ID_JOBENTRY_COPY INTEGER
, ID_JOBENTRY INTEGER
, ID_JOB INTEGER
, ID_JOBENTRY_TYPE INTEGER
, NR INTEGER
, GUI_LOCATION_X INTEGER
, GUI_LOCATION_Y INTEGER
, GUI_DRAW CHAR(1)
, PARALLEL CHAR(1)
, PRIMARY KEY (ID_JOBENTRY_COPY)
)
;