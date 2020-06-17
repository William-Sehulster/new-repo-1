--script drops inbound_ncpdp_msg_hist, outbound_ncpdp_msg_hist, and drops and recreates
--inbound_ncpdp_msg and outbound_ncpdp_msg tables and associated objects


--set the define below for scripts directory location if not in pwd
define dir=.

spool &dir\task_54788.log

drop table erx.inbound_ncpdp_msg_hist;

drop table erx.outbound_ncpdp_msg_hist;

drop public synonym outbound_ncpdp_msg_hist;

drop public synonym inbound_ncpdp_msg_hist;

drop sequence erx.IB_NCPDP_MSG_HIST_ID_SEQ;

drop sequence erx.OB_NCPDP_MSG_HIST_ID_SEQ;



--Create Inbound Table
start &dir\INBOUND_NCPDP_MSG.sql
start &dir\INBOUND_NCPDP_MSG_Constraints.sql
start &dir\IB_NCPDP_MSG_ERX_STATUS_FK.sql
start &dir\IB_NCPDP_MSG_ERX_STATUS_FK1.sql
start &dir\IB_NCPDP_MSG_ERX_STATUS_FK2.sql
start &dir\IB_NCPDP_MSG_ERX_STATUS_FK3.sql
start &dir\IB_NCPDP_MSG_PHARMACY_FK.sql

start &dir\IB_NCPDP_MSG_TRG.sql


--Create Outbound Table
start &dir\OUTBOUND_NCPDP_MSG.sql
start &dir\OUTBOUND_MSG_ERX_STATUS_FK.sql
start &dir\OUTBOUND_MSG_PHARMACY_ID_FK.sql
start &dir\OUTBOUND_NCPDP_MSG_Constraints.sql

start &dir\OB_NCPDP_MSG_TRG.sql

--grant privs

start &dir\GRANT_ERX_ROLE_PRIVS.sql
