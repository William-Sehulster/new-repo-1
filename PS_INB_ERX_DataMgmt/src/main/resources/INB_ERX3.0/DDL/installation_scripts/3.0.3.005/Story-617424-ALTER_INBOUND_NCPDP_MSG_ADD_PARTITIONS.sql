ALTER TABLE erx.inbound_ncpdp_msg
   DROP PARTITION rcvd_date_p99;

ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p13 VALUES LESS THAN (TO_DATE('01-JUN-2018', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p14 VALUES LESS THAN (TO_DATE('01-JUL-2018', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p15 VALUES LESS THAN (TO_DATE('01-AUG-2018', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p16 VALUES LESS THAN (TO_DATE('01-SEP-2018', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p17 VALUES LESS THAN (TO_DATE('01-OCT-2018', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p18 VALUES LESS THAN (TO_DATE('01-NOV-2018', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p19 VALUES LESS THAN (TO_DATE('01-DEC-2018', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p20 VALUES LESS THAN (TO_DATE('01-JAN-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p21 VALUES LESS THAN (TO_DATE('01-FEB-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p22 VALUES LESS THAN (TO_DATE('01-MAR-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p23 VALUES LESS THAN (TO_DATE('01-APR-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p24 VALUES LESS THAN (TO_DATE('01-MAY-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p25 VALUES LESS THAN (TO_DATE('01-JUN-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p26 VALUES LESS THAN (TO_DATE('01-JUL-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p27 VALUES LESS THAN (TO_DATE('01-AUG-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p28 VALUES LESS THAN (TO_DATE('01-SEP-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p29 VALUES LESS THAN (TO_DATE('01-OCT-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p30 VALUES LESS THAN (TO_DATE('01-NOV-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
   
ALTER TABLE erx.inbound_ncpdp_msg
   ADD PARTITION rcvd_date_p31 VALUES LESS THAN (TO_DATE('01-DEC-2019', 'DD-MON-YYYY'))
   TABLESPACE ERX_DATA;
    
ALTER TABLE erx.inbound_ncpdp_msg
  ADD PARTITION rcvd_date_p99 VALUES LESS THAN (TO_DATE('31-DEC-2099', 'DD-MON-YYYY'))
  TABLESPACE ERX_DATA;
  
  begin 
  	  	DBMS_STATS.GATHER_TABLE_STATS (
  	  	  ownname => '"ERX"',
          tabname => '"INBOUND_NCPDP_MSG"',
          estimate_percent => 1
          );
  end;