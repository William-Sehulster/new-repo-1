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
start &dir\IB_MSG_STATUS_IDX.sql
start &dir\IB_NCPDP_MSG_PHARMACY_ID_IDX.sql
start &dir\IB_REL_TO_MSG_ID_IDX.sql
start &dir\IB_MSG_ID_IDX.sql

start &dir\OUTBOUND_NCPDP_MSG.sql
start &dir\OUTBOUND_MSG_ERX_STATUS_FK.sql
start &dir\OUTBOUND_MSG_PHARMACY_ID_FK.sql
start &dir\OUTBOUND_NCPDP_MSG_Constraints.sql
start &dir\OB_MSG_STATUS_IDX.sql
start &dir\OB_NCPDP_MSG_PHARMACY_ID_IDX.sql
start &dir\OB_REL_TO_MSG_ID_IDX.sql
start &dir\OB_MSG_ID_IDX.sql

start &dir\ERX_STATUS_ID_SEQ.sql
start &dir\IB_NCPDP_MSG_ID_SEQ.sql
start &dir\OB_NCPDP_MSG_ID_SEQ.sql
start &dir\PHARMACY_ID_SEQ.sql
start &dir\USERS_ID_SEQ.sql

start &dir\OB_NCPDP_MSG_TRG.sql
start &dir\IB_NCPDP_MSG_TRG.sql
start &dir\PHARMACY_TRG.sql
start &dir\ERX_STATUS_TRG.sql
start &dir\APP_CONFIGURATION_TRG.sql
start &dir\VA_USER_TRG.sql

start &dir\SUMMARY_REPORT_VW.sql
start &dir\AUTO_CHECK_REPORT_VW.sql
start &dir\REJECT_REASONS_REPORT_VW.sql
start &dir\ERX_SUMMARY_REPORT_VW.sql
start &dir\INBOUND_NCPDP_MSG_DEIDENT_VW.sql
start &dir\OUTBOUND_NCPDP_MSG_DEIDENT_VW.sql
start &dir\DELIVERY_SEND_PERF_MONITOR_VW.sql

start &dir\NCPDP_CODE.sql

start &dir\ECL_CODE.sql

start &dir\MONITORING.sql
start &dir\MONITORING_ID_SEQ.sql
start &dir\MONITORING_TRG.sql


rem checking object counts, also for invalid objects

select
count(object_name) actual,
case
when status = 'INVALID' then
decode(object_type, 'SEQUENCE',0,'TRIGGER', 0,'TABLE', 0, 'INDEX',0,'VIEW',0)
when status ='VALID' then
decode(object_type, 'SEQUENCE',8,'TRIGGER', 11,'TABLE', 11, 'INDEX',14,'VIEW',7)
end
expected,
object_type,
status object_status
from all_objects
where owner = 'ERX' and object_type in ('TABLE', 'TRIGGER', 'SEQUENCE', 'INDEX','VIEW')
group by object_type, status;

spool off