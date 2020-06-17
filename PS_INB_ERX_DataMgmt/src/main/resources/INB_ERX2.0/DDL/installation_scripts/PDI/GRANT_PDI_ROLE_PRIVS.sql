-- Grants for pdi_update_role 

GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_REPOSITORY_LOG TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_VERSION TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_DATABASE_TYPE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_DATABASE_CONTYPE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_NOTE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_DATABASE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_DATABASE_ATTRIBUTE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_DIRECTORY TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_TRANSFORMATION TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_TRANS_ATTRIBUTE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOB_ATTRIBUTE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_DEPENDENCY TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_PARTITION_SCHEMA TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_PARTITION TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_TRANS_PARTITION_SCHEMA TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_CLUSTER TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_SLAVE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_CLUSTER_SLAVE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_TRANS_SLAVE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_TRANS_CLUSTER TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_TRANS_HOP TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_TRANS_STEP_CONDITION TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_CONDITION TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_VALUE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_STEP_TYPE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_STEP TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_STEP_ATTRIBUTE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_STEP_DATABASE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_TRANS_NOTE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_LOGLEVEL TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_LOG TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOB TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOBENTRY_DATABASE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOBENTRY_TYPE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOBENTRY TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOBENTRY_COPY TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOBENTRY_ATTRIBUTE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOB_HOP TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOB_NOTE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_TRANS_LOCK TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_JOB_LOCK TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_NAMESPACE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_ELEMENT_TYPE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_ELEMENT TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_ELEMENT_ATTRIBUTE TO PDI_UPDATE_ROLE;
GRANT SELECT,INSERT,UPDATE,DELETE ON pdi.R_USER TO PDI_UPDATE_ROLE;


-- Grants for pdi_read_role 

GRANT SELECT ON pdi.R_REPOSITORY_LOG TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_VERSION TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_DATABASE_TYPE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_DATABASE_CONTYPE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_NOTE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_DATABASE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_DATABASE_ATTRIBUTE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_DIRECTORY TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_TRANSFORMATION TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_TRANS_ATTRIBUTE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOB_ATTRIBUTE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_DEPENDENCY TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_PARTITION_SCHEMA TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_PARTITION TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_TRANS_PARTITION_SCHEMA TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_CLUSTER TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_SLAVE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_CLUSTER_SLAVE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_TRANS_SLAVE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_TRANS_CLUSTER TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_TRANS_HOP TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_TRANS_STEP_CONDITION TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_CONDITION TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_VALUE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_STEP_TYPE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_STEP TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_STEP_ATTRIBUTE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_STEP_DATABASE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_TRANS_NOTE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_LOGLEVEL TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_LOG TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOB TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOBENTRY_DATABASE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOBENTRY_TYPE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOBENTRY TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOBENTRY_COPY TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOBENTRY_ATTRIBUTE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOB_HOP TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOB_NOTE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_TRANS_LOCK TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_JOB_LOCK TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_NAMESPACE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_ELEMENT_TYPE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_ELEMENT TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_ELEMENT_ATTRIBUTE TO PDI_READ_ROLE;
GRANT SELECT ON pdi.R_USER TO PDI_READ_ROLE;
