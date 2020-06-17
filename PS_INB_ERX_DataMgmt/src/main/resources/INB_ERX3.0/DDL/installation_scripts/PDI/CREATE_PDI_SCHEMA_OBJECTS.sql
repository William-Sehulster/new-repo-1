--script drops and creates all pdi schema objects
--assumes pdi user is created and



--set the define below for scripts directory location if not in pwd
define dir=.

spool &dir\create_pdi_schema_objects.log



start &dir\R_REPOSITORY_LOG.sql
start &dir\R_VERSION.sql
start &dir\R_DATABASE_TYPE.sql
start &dir\R_DATABASE_CONTYPE.sql
start &dir\R_NOTE.sql
start &dir\R_DATABASE.sql
start &dir\R_DATABASE_ATTRIBUTE.sql
start &dir\R_DIRECTORY.sql
start &dir\R_TRANSFORMATION.sql
start &dir\R_TRANS_ATTRIBUTE.sql
start &dir\R_JOB_ATTRIBUTE.sql
start &dir\R_DEPENDENCY.sql
start &dir\R_PARTITION_SCHEMA.sql
start &dir\R_PARTITION.sql
start &dir\R_TRANS_PARTITION_SCHEMA.sql
start &dir\R_CLUSTER.sql
start &dir\R_SLAVE.sql
start &dir\R_CLUSTER_SLAVE.sql
start &dir\R_TRANS_SLAVE.sql
start &dir\R_TRANS_CLUSTER.sql
start &dir\R_TRANS_HOP.sql
start &dir\R_TRANS_STEP_CONDITION.sql
start &dir\R_CONDITION.sql
start &dir\R_VALUE.sql
start &dir\R_STEP_TYPE.sql
start &dir\R_STEP.sql
start &dir\R_STEP_ATTRIBUTE.sql
start &dir\R_STEP_DATABASE.sql
start &dir\R_TRANS_NOTE.sql
start &dir\R_LOGLEVEL.sql
start &dir\R_LOG.sql
start &dir\R_JOB.sql
start &dir\R_JOBENTRY_DATABASE.sql
start &dir\R_JOBENTRY_TYPE.sql
start &dir\R_JOBENTRY.sql
start &dir\R_JOBENTRY_COPY.sql
start &dir\R_JOBENTRY_ATTRIBUTE.sql
start &dir\R_JOB_HOP.sql
start &dir\R_JOB_NOTE.sql
start &dir\R_TRANS_LOCK.sql
start &dir\R_JOB_LOCK.sql
start &dir\R_NAMESPACE.sql
start &dir\R_ELEMENT_TYPE.sql
start &dir\R_ELEMENT.sql
start &dir\R_ELEMENT_ATTRIBUTE.sql
start &dir\R_USER.sql


spool off