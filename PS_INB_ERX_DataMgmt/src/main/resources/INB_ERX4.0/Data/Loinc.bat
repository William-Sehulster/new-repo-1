 #local dev
 #sqlldr 'erx/erx@//127.0.0.1:1521/erxdb' control='Loinc.ctl' skip=1   
 
 #change connection below for targeted environment
 #sqlldr 'erx/erx@//vaauserxdbsdev1.aac.va.gov:1549/erxdb.aac.va.gov' control='Loinc.ctl' skip=1   
 
 sqlldr 'erx/erx@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=vaauserxdbsdev1.aac.va.gov)(PORT=1549))(CONNECT_DATA=(SERVICE_NAME=erxdb)(SERVER=DEDICATED))))' control='Loinc.ctl' skip=1 