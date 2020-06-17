1) The scripts in the installation_scripts\pdi directory create all the schema objects to hold the
meta-data for the Pentaho Data Integration repository.

2) The scripts assume the presence of an pdi schema in the database.  The CREATE_PDI_USER.sql script
is provided to create the pdi user/schema if not present. 


3) The CREATE_PDI_USER.sql script requires dba privs (or sys/system user) in order to run.

In order to run the PDI schemas, the 'SERVICE_ACCOUNT_PROFILE' profile and ERX_DATA tablespace
 must be created.(scripts "CREATE_SERVICE_ACCOUNT_PROFILE.sql" provided in installaion directory)

for example:  CREATE PROFILE SERVICE_ACCOUNT_PROFILE LIMIT 
   SESSIONS_PER_USER          UNLIMITED 
   CPU_PER_SESSION            UNLIMITED;
   
for example: create tablespace ERX_DATA datafile 'C:\oraclexe\app\oracle\oradata\XE\erx01.dbf'
 size 32m autoextend
 on next 32m maxsize 2048m extent management local; 
  
4) The CREATE_PDI_SCHEMA_OBJECTS.sql script will create all the pdi owned schema objects and can be run by the pdi user or sys/system user.

5) After successful pdi schema creation. Run the following scripts as sys/system/dba user:
 CREATE_PDI_ROLES.sql, CREATE_PDI_PUBLIC_SYNONYMS.sql, GRANT_PDI_ROLE_PRIVS.sql, GRANT_ERX_AND_PDI_ROLES_TO_USERS.sql 
