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