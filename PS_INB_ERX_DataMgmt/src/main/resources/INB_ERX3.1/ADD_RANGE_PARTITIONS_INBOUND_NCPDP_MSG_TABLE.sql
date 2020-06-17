--This script adds additional range partitions (3 years worth) to the inbound_ncpdp_msg table
--The rcvd_date_p99 partition (which is precautionary and would catch records with received dates beyond the range of the last monthly partition.  This should always be empty)
--The rcvd_date_p99 partition is dropped prior to adding the addtional partitions, it's added back at the end of the script

ALTER TABLE erx.inbound_ncpdp_msg DROP PARTITION rcvd_date_p99
   UPDATE INDEXES;

ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p32 VALUES LESS THAN (TO_DATE('01-JAN-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p33 VALUES LESS THAN (TO_DATE('01-FEB-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p34 VALUES LESS THAN (TO_DATE('01-MAR-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p35 VALUES LESS THAN (TO_DATE('01-APR-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p36 VALUES LESS THAN (TO_DATE('01-MAY-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p37 VALUES LESS THAN (TO_DATE('01-JUN-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p38 VALUES LESS THAN (TO_DATE('01-JUL-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p39 VALUES LESS THAN (TO_DATE('01-AUG-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p40 VALUES LESS THAN (TO_DATE('01-SEP-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p41 VALUES LESS THAN (TO_DATE('01-OCT-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p42 VALUES LESS THAN (TO_DATE('01-NOV-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p43 VALUES LESS THAN (TO_DATE('01-DEC-2020', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p44 VALUES LESS THAN (TO_DATE('01-JAN-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p45 VALUES LESS THAN (TO_DATE('01-FEB-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p46 VALUES LESS THAN (TO_DATE('01-MAR-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p47 VALUES LESS THAN (TO_DATE('01-APR-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p48 VALUES LESS THAN (TO_DATE('01-MAY-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p49 VALUES LESS THAN (TO_DATE('01-JUN-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p50 VALUES LESS THAN (TO_DATE('01-JUL-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p51 VALUES LESS THAN (TO_DATE('01-AUG-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p52 VALUES LESS THAN (TO_DATE('01-SEP-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p53 VALUES LESS THAN (TO_DATE('01-OCT-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p54 VALUES LESS THAN (TO_DATE('01-NOV-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p55 VALUES LESS THAN (TO_DATE('01-DEC-2021', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
     ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p56 VALUES LESS THAN (TO_DATE('01-JAN-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p57 VALUES LESS THAN (TO_DATE('01-FEB-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p58 VALUES LESS THAN (TO_DATE('01-MAR-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p59 VALUES LESS THAN (TO_DATE('01-APR-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p60 VALUES LESS THAN (TO_DATE('01-MAY-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p61 VALUES LESS THAN (TO_DATE('01-JUN-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p62 VALUES LESS THAN (TO_DATE('01-JUL-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p63 VALUES LESS THAN (TO_DATE('01-AUG-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p64 VALUES LESS THAN (TO_DATE('01-SEP-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p65 VALUES LESS THAN (TO_DATE('01-OCT-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p66 VALUES LESS THAN (TO_DATE('01-NOV-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p67 VALUES LESS THAN (TO_DATE('01-DEC-2022', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p68 VALUES LESS THAN (TO_DATE('01-JAN-2023', 'DD-MON-YYYY'))
   TABLESPACE ERX_INDEX;
   
   ALTER TABLE erx.inbound_ncpdp_msg
  ADD PARTITION rcvd_date_p99 VALUES LESS THAN (TO_DATE('31-DEC-2099', 'DD-MON-YYYY'))
  TABLESPACE ERX_INDEX;
  
  
 begin 
  	  	DBMS_STATS.GATHER_TABLE_STATS (
  	  	  ownname => '"ERX"',
          tabname => '"INBOUND_NCPDP_MSG"',
          estimate_percent => 1
          );
  end;
  /
  
  select index_owner, index_name, partition_name, status from all_ind_partitions
where status = 'UNUSABLE';
   