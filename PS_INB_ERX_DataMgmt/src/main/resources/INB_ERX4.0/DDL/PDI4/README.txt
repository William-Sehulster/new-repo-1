1) The scripts in the installation_scripts\pdi4 directory create all the schema objects to hold the
meta-data for the Pentaho Data Integration repository.  The intent is to create a version 4.0 repository that 
can coexist in the same DB instance as the PDI (version 3.1) repository.

2) The scripts assume the presence of an pdi4 schema in the database.  The CREATE_PDI4_USER.sql script
is provided to create the pdi user/schema if not present. 


3) The CREATE_PDI4_USER.sql script requires dba privs (or sys/system user) in order to run.

In order to run the create pdi user script, the 'SERVICE_ACCOUNT_PROFILE' profile and ERX_DATA tablespace
 must be created.

for example:  CREATE PROFILE SERVICE_ACCOUNT_PROFILE LIMIT 
   SESSIONS_PER_USER          UNLIMITED 
   CPU_PER_SESSION            UNLIMITED;
   
for example: create tablespace ERX_DATA datafile 'C:\oraclexe\app\oracle\oradata\XE\erx01.dbf'
 size 32m autoextend
 on next 32m maxsize 2048m extent management local; 
  
4) The CREATE_PDI4_SCHEMA_OBJECTS.sql script will create all the pdi4 owned schema objects and can be run by the pdi4 user or sys/system user.


