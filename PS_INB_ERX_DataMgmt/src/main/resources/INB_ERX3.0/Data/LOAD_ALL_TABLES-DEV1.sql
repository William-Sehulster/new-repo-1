--script loads erx tables

--set the define below for scripts directory location if not in pwd
define dir=.

spool &dir\load_all_tables.log

start &dir\LOAD_APP_CONFIGURATION-DEV1.sql

start &dir\LOAD_ERX_STATUS.sql

start &dir\LOAD_PHARMACY.sql

start &dir\LOAD_NCPDP_CODE.sql

start &dir\LOAD_ECL_CODE.sql

spool off