--script drops and creates all erx schema objects
--assumes erx user is created 


--set the define below for scripts directory location if not in pwd
define dir=.

spool &dir\create_schema_objects.log


start &dir\APP_CONFIGURATION.sql
start &dir\APP_CONFIGURATION_Constraints.sql


start &dir\ERX_STATUS.sql
start &dir\ERX_STATUS_Constraints.sql


start &dir\VA_USER.sql
start &dir\VA_USER_Constraints.sql

start &dir\PHARMACY.sql
start &dir\PHARMACY_Constraints.sql
start &dir\PHARMACY_USERS_CREATED_BY_FK.sql
start &dir\PHARMACY_USERS_UPDATED_BY_FK.sql


start &dir\INBOUND_NCPDP_MSG.sql
start &dir\INBOUND_NCPDP_MSG_Constraints.sql
start &dir\IB_NCPDP_MSG_ERX_STATUS_FK.sql
start &dir\IB_NCPDP_MSG_ERX_STATUS_FK1.sql
start &dir\IB_NCPDP_MSG_ERX_STATUS_FK2.sql
start &dir\IB_NCPDP_MSG_ERX_STATUS_FK3.sql
start &dir\IB_NCPDP_MSG_PHARMACY_FK.sql
--start &dir\IB_NCPDP_MSG_IDX.sql


--start &dir\INBOUND_NCPDP_MSG_HIST.sql
--start &dir\INBOUND_NCPDP_MSG_HIST_Constraints.sql
--start &dir\INBOUND_NCPDP_MSG_FK.sql

start &dir\OUTBOUND_NCPDP_MSG.sql
start &dir\OUTBOUND_MSG_ERX_STATUS_FK.sql
start &dir\OUTBOUND_MSG_PHARMACY_ID_FK.sql
start &dir\OUTBOUND_NCPDP_MSG_Constraints.sql
--start &dir\OB_NCPDP_MSG_IDX.sql

--start &dir\OUTBOUND_NCPDP_MSG_HIST.sql
--start &dir\OUTBOUND_NCPDP_MSG_HIST_Constraints.sql
--start &dir\OB_NCPDP_MSG_HIST_FK.sql

start &dir\ERX_STATUS_ID_SEQ.sql
--start &dir\IB_NCPDP_MSG_HIST_ID_SEQ.sql
start &dir\IB_NCPDP_MSG_ID_SEQ.sql
--start &dir\OB_NCPDP_MSG_HIST_ID_SEQ.sql
start &dir\OB_NCPDP_MSG_ID_SEQ.sql
start &dir\PHARMACY_ID_SEQ.sql
start &dir\USERS_ID_SEQ.sql

start &dir\OB_NCPDP_MSG_TRG.sql
--start &dir\OB_NCPDP_MSG_INS_TRG.sql
--start &dir\OB_NCPDP_MSG_HIST_TRG.sql
--start &dir\IB_NCPDP_MSG_HIST_INS_TRG.sql
--start &dir\IB_NCPDP_MSG_HIST_TRG.sql
start &dir\IB_NCPDP_MSG_TRG.sql
start &dir\PHARMACY_TRG.sql
start &dir\ERX_STATUS_TRG.sql
start &dir\APP_CONFIGURATION_TRG.sql
start &dir\VA_USER_TRG.sql

start &dir\SUMMARY_REPORT_VW.sql

start &dir\NCPDP_CODE.sql

start &dir\ECL_CODE.sql


rem checking object counts, also for invalid objects

select
count(object_name) actual,
case
when status = 'INVALID' then
decode(object_type, 'SEQUENCE',0,'TRIGGER', 0,'TABLE', 0, 'INDEX',0,'VIEW',0)
when status ='VALID' then
decode(object_type, 'SEQUENCE',7,'TRIGGER', 10,'TABLE', 10, 'INDEX',14,'VIEW',1)
end
expected,
object_type,
status object_status
from all_objects
where owner = 'ERX' and object_type in ('TABLE', 'TRIGGER', 'SEQUENCE', 'INDEX','VIEW')
group by object_type, status;

spool off