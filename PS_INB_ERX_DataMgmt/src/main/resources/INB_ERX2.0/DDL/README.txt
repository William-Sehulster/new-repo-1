1) The scripts in the installation_scripts directory create all the schema objects for the eRx system.

2) The scripts assume the presence of an erx schema in the database.  The CREATE_ERX_USER.sql script
is provided to create the erx user/schema if not present. 


3) In order to run the create erx user script, the 'SERVICE_ACCOUNT_PROFILE' profile and ERX_DATA tablespace
 must be created.

for example:  CREATE PROFILE SERVICE_ACCOUNT_PROFILE LIMIT 
   SESSIONS_PER_USER          UNLIMITED 
   CPU_PER_SESSION            UNLIMITED;
   
for example: create tablespace ERX_DATA datafile 'C:\oraclexe\app\oracle\oradata\XE\erx01.dbf'
 size 32m autoextend
 on next 32m maxsize 2048m extent management local; 
 

4) The CREATE_ERX_SCHEMA_OBJECTS.sql script will create all the erx owned schema objects and can be run by the erx user or sys/system user.

5) After sucessfulll erx schema creation. Run the following scripts as sys/system/dba user:
 CREATE_ERX_ROLES.sql, CREATE_PUBLIC_SYNONYMS.sql, GRANT_ROLE_PRIVS.sql  
 
6) Next proceed to load data into tables using provided scripts. 

5) Note for installation in a Development Oracle XE.  If you are using a development install of Oracle XE run the following command as SYS user to work around a 
limitation of the XE version of Oracle. The table creates with the XMLTYPE will fail without setting the system
property db_securefile to IGNORE.  It shouldn’t be an issue in the EE version used on the VA servers.

Alter system set db_securefile = ‘IGNORE’;
