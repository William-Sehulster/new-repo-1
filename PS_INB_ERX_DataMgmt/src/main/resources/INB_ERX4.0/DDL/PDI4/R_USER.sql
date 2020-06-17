DROP TABLE PDI4.R_USER
;

CREATE TABLE PDI4.R_USER
(
  ID_USER INTEGER
, LOGIN VARCHAR2(255)
, PASSWORD VARCHAR2(255)
, NAME VARCHAR2(255)
, DESCRIPTION VARCHAR2(255)
, ENABLED CHAR(1)
, PRIMARY KEY (ID_USER)
)
;

INSERT INTO PDI4.R_USER(ID_USER, LOGIN, PASSWORD, NAME, DESCRIPTION, ENABLED) VALUES (1,'admin','2be98afc86aa7f2e4cb79ce71da9fa6d4','Administrator','User manager','Y');

INSERT INTO PDI4.R_USER(ID_USER, LOGIN, PASSWORD, NAME, DESCRIPTION, ENABLED) VALUES (2,'guest','2be98afc86aa7f2e4cb79ce77cb97bcce','Guest account','Read-only guest account','Y');

