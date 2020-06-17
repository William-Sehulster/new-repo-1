CREATE OR REPLACE VIEW "ERX"."SUMMARY_REPORT_VW" ("PHARMACY_NCPDP_ID", "PHARMACY_VA_STATION_ID", "PHARMACY_DIVISION_NAME", "VISN", "PHARMACY_ADDRESS", "NEW_RX_CNT", "NEW_RX_PHARM_DISABLED_AT_HUB", "NEW_RX_REJECTED_AT_HUB", "NEW_RX_PASS_AUTO_CHK", "NEW_RX_FAIL_AUTO_CHK", "NEW_RX_REJECTED_BY_PHARMACIST", "NEW_RX_FILLED", "NEW_RX_IN_PROCESS", "NEW_RX_MESSAGE_DATE") AS 
(select
pharmacy_ncpdp_id, pharmacy_va_station_id, pharmacy_division_name,
visn,
pharmacy_address_line_1||' '||
pharmacy_address_line_2||' '||pharmacy_city||', '||pharmacy_state||' '||pharmacy_zipcode pharmacy_address,
sum(new_rx_cnt) new_rx_cnt,
sum(new_rx_pharm_disabled_at_hub) new_rx_pharm_disabled_at_hub,
sum(new_rx_rejected_at_hub) new_rx_rejected_at_hub,
sum(new_rx_pass_auto_chk) new_rx_pass_auto_chk,
sum(new_rx_fail_auto_chk) new_rx_fail_auto_chk,
sum(new_rx_rejected_by_pharmacist) new_rx_rejected_by_pharmacist,
sum(new_rx_filled) new_rx_filled,
sum(new_rx_in_process) new_rx_in_process,
new_rx_message_date
from
(select pharm.ncpdp_id pharmacy_ncpdp_id, pharm.va_station_id pharmacy_va_station_id, pharm.division_name pharmacy_division_name,
pharm.visn visn,
pharm.pharmacy_address_line_1,
pharm.pharmacy_address_line_2,
pharm.pharmacy_city,
pharm.pharmacy_state,
pharm.pharmacy_zipcode,
decode(inbmsg.message_type, 'NewRx', 1, 0) new_rx_cnt,
decode(inbmsg.message_status, '3010', 1, 0) new_rx_pharm_disabled_at_hub,
decode(inbmsg.message_status, '3006', 1, 0) new_rx_rejected_at_hub,
decode((decode(inbmsg.patient_chk_status,'0101',1,0) + decode(inbmsg.provider_chk_status,'2001',1,0) + decode(inbmsg.drug_chk_status,'1001',1,0)), 3, 1, 0) new_rx_pass_auto_chk,
decode((decode(inbmsg.patient_chk_status,'0101',1,0) + decode(inbmsg.provider_chk_status,'2001',1,0) + decode(inbmsg.drug_chk_status,'1001',1,0)), 3, 0, 1)
- decode(inbmsg.message_status, '3006', 1, 0) + decode(inbmsg.message_status, '3010', 1, 0) new_rx_fail_auto_chk,
0 + 0 new_rx_rejected_by_pharmacist,
0 + 0 new_rx_filled,
decode(inbmsg.message_status, '3002', 1, 0) new_rx_in_process,
trunc(inbmsg.created_date) new_rx_message_date
from erx.inbound_ncpdp_msg inbmsg, erx.pharmacy pharm
where inbmsg.pharmacy_id = pharm.pharmacy_id
and inbmsg.MESSAGE_STATUS NOT IN ('0000') and inbmsg.message_type in ('NewRx')
union all
select pharm.ncpdp_id pharmacy_ncpdp_id, pharm.va_station_id pharmacy_va_station_id, pharm.division_name pharmacy_division_name,
pharm.visn visn,
pharm.pharmacy_address_line_1,
pharm.pharmacy_address_line_2,
pharm.pharmacy_city,
pharm.pharmacy_state,
pharm.pharmacy_zipcode,
0 + 0 new_rx_cnt,
0 + 0 new_rx_pharm_disabled_at_hub,
0 + 0 new_rx_rejected_at_hub,
0 + 0 new_rx_pass_auto_chk,
0 + 0 new_rx_fail_auto_chk,
decode(extractvalue(inbmsg.message, '//Code','xmlns="http://www.ncpdp.org/schema/SCRIPT"' ), '900', 1,0 ) new_rx_rejected_by_pharmacist,
0 + 0 new_rx_filled,
decode(inbmsg.message_status, '3002', 1, 0) new_rx_in_process,
trunc(inbmsg.created_date) new_rx_message_date
from erx.outbound_ncpdp_msg inbmsg, erx.pharmacy pharm
where inbmsg.pharmacy_id = pharm.pharmacy_id
and inbmsg.MESSAGE_STATUS NOT IN ('0000') and inbmsg.message_type in ('Error')
and inbmsg.PHARMACY_ID <> 0 
and substr(extractvalue(inbmsg.message, '//Error/Description','xmlns="http://www.ncpdp.org/schema/SCRIPT"'),1,3) in ('PTT', 'ERR', 'DRU', 'PVD')) inbmsg
group by pharmacy_ncpdp_id, pharmacy_va_station_id, pharmacy_division_name,
visn, pharmacy_address_line_1,
pharmacy_address_line_2,
pharmacy_city,
pharmacy_state,
pharmacy_zipcode,new_rx_message_date);