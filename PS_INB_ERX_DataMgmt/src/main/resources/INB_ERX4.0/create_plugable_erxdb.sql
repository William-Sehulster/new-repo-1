CREATE PLUGGABLE DATABASE erxdb
  ADMIN USER erx IDENTIFIED BY erx
  STORAGE (MAXSIZE 2G)
  DEFAULT TABLESPACE erx_data
    DATAFILE 'C:\Data\Programs\OracleXE\18.0.0\oradata\XE\erxdb\erx01.dbf' SIZE 250M AUTOEXTEND ON
  PATH_PREFIX = 'C:\Data\Programs\OracleXE\18.0.0\oradata\XE\erxdb'
  FILE_NAME_CONVERT = ('C:\Data\Programs\OracleXE\18.0.0\oradata\XE\', 'C:\Data\Programs\OracleXE\18.0.0\oradata\XE\erxdb\');
  
  CREATE OR REPLACE trigger erxdb_startup after startup on database
  begin
  execute immediate 'alter pluggable database open erxdb';
  end erxdb_startup;
  
  alter pluggable database erxdb open;


Might have to do these whenever the local erxdb plugable databse is needed

alter system set local_listener = '(address=(protocol=tcp)(host=localhost)(port=1521))';

alter session set container = erxdb;

startup;

alter system register;


Perhaps your issue is similar to Oracle SQL Developer 19.2 hangs upon connecting to 11g-ex , with posters there complaining about both 11g XE and 18c XE.  
The recommendation: "My issue was solved by disabling "Enable Completion Auto-Popup in SQL Worksheet" under Tools => Preferences => Code Editor => Completion Insight"


alter session set container = erxdb;
CREATE PROFILE C##SERVICE_ACCOUNT_PROFILE LIMIT 
   SESSIONS_PER_USER          UNLIMITED 
   CPU_PER_SESSION            UNLIMITED;