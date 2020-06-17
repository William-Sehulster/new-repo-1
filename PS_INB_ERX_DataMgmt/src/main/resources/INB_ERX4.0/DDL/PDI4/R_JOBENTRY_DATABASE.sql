DROP TABLE PDI4.R_JOBENTRY_DATABASE
;

CREATE TABLE PDI4.R_JOBENTRY_DATABASE
(
  ID_JOB INTEGER
, ID_JOBENTRY INTEGER
, ID_DATABASE INTEGER
)
;

CREATE INDEX IDX_4_RJD1 ON PDI4.R_JOBENTRY_DATABASE(ID_JOB)
;

CREATE INDEX IDX_4_RJD2 ON PDI4.R_JOBENTRY_DATABASE(ID_DATABASE)
;