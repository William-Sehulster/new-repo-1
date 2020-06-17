CREATE OR REPLACE FORCE VIEW "ERX"."ERX_SUMMARY_REPORT_VW" ("PHARMACY_NCPDP_ID", "PHARMACY_VA_STATION_ID", "PHARMACY_DIVISION_NAME", "VISN", "PHARMACY_ADDRESS", "NEW_RX_CNT", "REFILL_REQUEST", "RX_CHANGE_REQUEST", "REFILL_RESPONSE", "RX_CHANGE_RESPONSE", "CANCEL_RX", "CANCEL_RX_RESPONSE", "RX_FILL", "NEW_RX_MESSAGE_DATE") AS 
  (SELECT pharmacy_ncpdp_id,
  pharmacy_va_station_id,
  pharmacy_division_name,
  visn,
  pharmacy_address_line_1
  ||' '
  || pharmacy_address_line_2
  ||' '
  ||pharmacy_city
  ||', '
  ||pharmacy_state
  ||' '
  ||pharmacy_zipcode pharmacy_address,
  SUM(new_rx_cnt) new_rx_cnt,
  SUM(refill_request) refill_request,
  SUM(refill_response) refill_response,
  SUM(rx_change_request) rx_change_request,
  SUM(rx_change_response) rx_change_response,
  SUM(cancel_rx) cancel_rx,
  SUM(cancel_rx_response) cancel_rx_response,
  SUM(rx_fill) rx_fill,
  new_rx_message_date
FROM
  (SELECT pharm.ncpdp_id pharmacy_ncpdp_id,
    pharm.va_station_id pharmacy_va_station_id,
    pharm.division_name pharmacy_division_name,
    pharm.visn visn,
    pharm.pharmacy_address_line_1,
    pharm.pharmacy_address_line_2,
    pharm.pharmacy_city,
    pharm.pharmacy_state,
    pharm.pharmacy_zipcode,
    DECODE(inbmsg.message_type, 'NewRx', 1, 0) new_rx_cnt,
    0 refill_request,
    DECODE(inbmsg.message_type, 'RefillResponse', 1, 0) refill_response,
    0 rx_change_request,
    DECODE(inbmsg.message_type, 'RxChangeResponse', 1, 0) rx_change_response,
    DECODE(inbmsg.message_type, 'CancelRx', 1, 0) cancel_rx,
    0 cancel_rx_response,
    0 rx_fill,
    TRUNC(inbmsg.created_date) new_rx_message_date
  FROM erx.inbound_ncpdp_msg inbmsg,
    erx.pharmacy pharm
  WHERE inbmsg.pharmacy_id       = pharm.pharmacy_id
  AND inbmsg.MESSAGE_STATUS NOT IN ('0000')
  AND inbmsg.message_type       IN ('NewRx', 'RefillResponse', 'CancelRx', 'RxChangeResponse')
  UNION ALL
  SELECT pharm.ncpdp_id pharmacy_ncpdp_id,
    pharm.va_station_id pharmacy_va_station_id,
    pharm.division_name pharmacy_division_name,
    pharm.visn visn,
    pharm.pharmacy_address_line_1,
    pharm.pharmacy_address_line_2,
    pharm.pharmacy_city,
   pharm.pharmacy_state,
    pharm.pharmacy_zipcode,
    0 new_rx_cnt,
    DECODE(outbmsg.message_type, 'RefillRequest', 1, 0) refill_request,
    0 refill_response,
    DECODE(outbmsg.message_type, 'RxChangeRequest', 1, 0) rx_change_request,
    0 rx_change_response,
    0 cancel_rx,
    DECODE(outbmsg.message_type, 'CancelRxResponse', 1, 0) cancel_rx_response,
    DECODE(outbmsg.message_type, 'RxFill', 1, 0) rx_fill,
    TRUNC(outbmsg.created_date) new_rx_message_date
  FROM erx.outbound_ncpdp_msg outbmsg,
    erx.pharmacy pharm
  WHERE outbmsg.pharmacy_id                                                                                          = pharm.pharmacy_id
  AND outbmsg.MESSAGE_STATUS NOT                                                                                    IN ('0000')
  AND outbmsg.message_type                                                                                          IN ('RefillRequest', 'RxFill','CancelRxResponse','RxChangeRequest')
  AND outbmsg.PHARMACY_ID                                                                                           <> 0
  ) outbmsg
GROUP BY pharmacy_ncpdp_id,
  pharmacy_va_station_id,
  pharmacy_division_name,
  visn,
  pharmacy_address_line_1,
  pharmacy_address_line_2,
  pharmacy_city,
  pharmacy_state,
  pharmacy_zipcode,
  new_rx_message_date);
  
  GRANT SELECT ON erx.erx_summary_report_vw TO erx_update_role;
  GRANT SELECT ON erx.erx_summary_report_vw TO erx_read_role;
  CREATE OR REPLACE PUBLIC SYNONYM erx_summary_report_vw FOR erx.erx_summary_report_vw;
