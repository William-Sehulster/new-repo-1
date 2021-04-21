rem this script grants create materialized view to the ERX user and 4 public synonyms to support the ERX summary reports.
rem the script should be run as sys/system or another dba account that has grant privs and create public synonym privs.

grant create materialized view to erx;

rem create pub synonyms and grant privs to application roles

drop public synonym auto_check_report_mvw;
  
create public synonym auto_check_report_mvw for erx.auto_check_report_mvw;

drop public synonym erx_summary_report_mvw;

create public synonym erx_summary_report_mvw for erx.erx_summary_report_mvw;

drop public synonym summary_report_mvw;

create public synonym summary_report_mvw for erx.summary_report_mvw;

drop public synonym reject_reasons_report_mvw;

create public synonym reject_reasons_report_mvw for erx.reject_reasons_report_mvw;

