--new table to store component status and updates
DROP TABLE ERX.MONITORING;

CREATE TABLE ERX.MONITORING 
(
  MONITORING_ID NUMBER NOT NULL 
, MVI_STATUS VARCHAR2(50) NOT NULL
, EANDE_STATUS VARCHAR2(50) NOT NULL
, PDI_INB_JOB_STATUS VARCHAR2(50) NOT NULL
, PDI_OUTB_JOB VARCHAR2(50) NOT NULL
, PDI_TOVISTA_JOB VARCHAR2(50) NOT NULL
, DAS_STATUS VARCHAR2(50) NOT NULL
, CREATED_DATE DATE NOT NULL
, CONSTRAINT MONITORING_PK PRIMARY KEY 
  (
    MONITORING_ID 
  )
  ENABLE 
);

CREATE OR REPLACE PUBLIC SYNONYM MONITORING for erx.monitoring;

DROP SEQUENCE ERX.MONITORING_ID_SEQ;

  CREATE SEQUENCE  ERX.MONITORING_ID_SEQ  MINVALUE 1 MAXVALUE 9999999999999999999999999999
  INCREMENT BY 1 START WITH 10 NOCACHE  ORDER  NOCYCLE ;
  
CREATE OR REPLACE TRIGGER ERX.MONITORING_TRG
    BEFORE INSERT OR UPDATE ON ERX.MONITORING
    FOR EACH ROW
BEGIN
  :NEW.CREATED_DATE := SYSDATE;
  IF :NEW.MONITORING_ID IS NULL THEN
  :NEW.MONITORING_ID := MONITORING_ID_SEQ.NEXTVAL;
  END IF;
END;
/
GRANT SELECT, INSERT, UPDATE, DELETE on erx.monitoring to erx_update_role;
GRANT SELECT on erx.monitoring to erx_read_role;
GRANT SELECT ON erx.monitoring_id_seq TO erx_update_role;

-- View to display system performance for current day
create or replace view erx.delivery_send_perf_monitor_vw as
select pharm.division_name,
pharm.va_station_id,
avg(inb.updated_date - inb.received_date)* 24 * 60 * 60  avg_delivery_time, --delivery processing time < 25 green, > 25 red 
avg(outb.updated_date - outb.received_date)* 24 * 60 * 60  avg_send_time --delivery processing time < 11.5 green > 11.5 red
from pharmacy pharm, inbound_ncpdp_msg inb, outbound_ncpdp_msg outb
where pharm.pharmacy_id = inb.pharmacy_id
and pharm.pharmacy_id = outb.pharmacy_id
and outb.message_status = '4001'
and inb.message_status = '3002'
and inb.received_date > sysdate - 1 --last day
and outb.received_date > sysdate - 1 --last day
group by Pharm.Division_Name, Pharm.Va_Station_Id;

create or replace public synonym delivery_send_perf_monitor_vw for erx.delivery_send_perf_monitor_vw;


grant select on erx.delivery_send_perf_monitor_vw to erx_update_role, erx_read_role;
