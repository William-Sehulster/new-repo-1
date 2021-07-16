rem this script creates/recreates four materialized views to support the ERX summary reports.
rem the script should be run as the schema owner ERX.

--Grant priveleges to ERX user
	Grant GLOBAL QUERY REWRITE to ERX;
	Grant CREATE TABLE to ERX;
	Grant CREATE MATERIALIZED VIEW to ERX;
	
--AUTO_CHECK_REPORT_MVW
	DROP MATERIALIZED VIEW "ERX"."AUTO_CHECK_REPORT_MVW";	

	CREATE MATERIALIZED VIEW "ERX"."AUTO_CHECK_REPORT_MVW" (
    "PHARMACY_NCPDP_ID",
    "PHARMACY_VA_STATION_ID",
    "PHARMACY_DIVISION_NAME",
    "VISN",
    "PHARMACY_ADDRESS",
    "NEW_RX_CNT",
    "NEW_RX_PASS_AUTO_CHK",
    "NEW_RX_FAIL_AUTO_CHK",
    "NEW_RX_MVI_PAT_FOUND",
    "NEW_RX_MVI_PAT_NOT_FOUND",
    "NEW_RX_ENE_ELGB_ENRL",
    "NEW_RX_ENE_NOT_ELGB_ENRL",
    "NEW_RX_PAT_NOT_ENRL_SITE",
    "NEW_RX_DRG_MTCH_FND",
    "NEW_RX_DRG_MTCH_NOT_FND",
    "NEW_RX_PVD_MTCH_FND",
    "NEW_RX_PVD_MTCH_NOT_FND",
    "NEW_RX_MESSAGE_DATE"
)
    REFRESH
        COMPLETE
        START WITH ( sysdate )
        NEXT ( trunc(sysdate) + 1 )
AS
    ( SELECT
        pharmacy_ncpdp_id,
        pharmacy_va_station_id,
        pharmacy_division_name,
        visn,
        pharmacy_address_line_1
        || ' '
        || pharmacy_address_line_2
        || ' '
        || pharmacy_city
        || ', '
        || pharmacy_state
        || ' '
        || pharmacy_zipcode pharmacy_address,
        SUM(new_rx_cnt) new_rx_cnt,
        SUM(new_rx_pass_auto_chk) new_rx_pass_auto_chk,
        SUM(new_rx_fail_auto_chk) new_rx_fail_auto_chk,
        SUM(new_rx_mvi_pat_found) new_rx_mvi_pat_found,
        SUM(new_rx_mvi_pat_not_found) new_rx_mvi_pat_not_found,
        SUM(new_rx_ene_elgb_enrl) new_rx_ene_elgb_enrl,
        SUM(new_rx_ene_not_elgb_enrl) new_rx_ene_not_elgb_enrl,
        SUM(new_rx_pat_not_enrl_site) new_rx_pat_not_enrl_site,
        SUM(new_rx_drg_mtch_fnd) new_rx_drg_mtch_fnd,
        SUM(new_rx_drg_mtch_not_fnd) new_rx_drg_mtch_not_fnd,
        SUM(new_rx_pvd_mtch_fnd) new_rx_pvd_mtch_fnd,
        SUM(new_rx_pvd_mtch_not_fnd) new_rx_pvd_mtch_not_fnd,
        new_rx_message_date
    FROM
        (
            SELECT
                pharm.ncpdp_id        pharmacy_ncpdp_id,
                pharm.va_station_id   pharmacy_va_station_id,
                pharm.division_name   pharmacy_division_name,
                pharm.visn            visn,
                pharm.pharmacy_address_line_1,
                pharm.pharmacy_address_line_2,
                pharm.pharmacy_city,
                pharm.pharmacy_state,
                pharm.pharmacy_zipcode,
                decode(inbmsg.message_type, 'NewRx', 1, 'RxRenewalResponse', 1,
                       'RxChangeResponse', 1, 0) new_rx_cnt,
                decode((decode(inbmsg.patient_chk_status, '0101', 1, 0) + decode(inbmsg.patient_chk_status, '0108', 1, 0) + decode
                (inbmsg.provider_chk_status, '2001', 1, 0) + decode(inbmsg.drug_chk_status, '1001', 1, 0)), 3, 1, 0) new_rx_pass_auto_chk
                ,
                decode((decode(inbmsg.patient_chk_status, '0101', 1, 0) + decode(inbmsg.provider_chk_status, '2001', 1, 0) + decode
                (inbmsg.drug_chk_status, '1001', 1, 0)), 3, 0, 1) - decode(inbmsg.message_status, '3006', 1, 0) + decode(inbmsg.message_status
                , '3010', 1, 0) new_rx_fail_auto_chk,
                decode(inbmsg.patient_chk_status, '0101', 1, '0102', 1,
                       '0103', 1, '0106', 1, '0108',
                       1, 0) new_rx_mvi_pat_found,
                decode(inbmsg.patient_chk_status, '0002', 1, '0003', 1,
                       0) new_rx_mvi_pat_not_found,
                decode(inbmsg.patient_chk_status, '0101', 1, 0) new_rx_ene_elgb_enrl,
                decode(inbmsg.patient_chk_status, '0102', 1, '0103', 1,
                       0) new_rx_ene_not_elgb_enrl,
                decode(extractvalue(xmltype(nvl(patient_match_details, '<siteMatch/>')), '//siteMatch'), 'true', 0, 'false', 1,
                       0) new_rx_pat_not_enrl_site,
                decode(inbmsg.drug_chk_status, '1001', 1, 0) new_rx_drg_mtch_fnd,
                decode(inbmsg.drug_chk_status, '1002', 1, '1003', 1,
                       0) new_rx_drg_mtch_not_fnd,
                decode(inbmsg.provider_chk_status, '2001', 1, 0) new_rx_pvd_mtch_fnd,
                decode(inbmsg.provider_chk_status, '2002', 1, '2003', 1,
                       0) new_rx_pvd_mtch_not_fnd,
                trunc(inbmsg.created_date) new_rx_message_date
            FROM
                erx.inbound_ncpdp_msg   inbmsg,
                erx.pharmacy            pharm
            WHERE
                inbmsg.pharmacy_id = pharm.pharmacy_id
                AND inbmsg.message_status NOT IN (
                    '0000'
                )
                AND inbmsg.patient_chk_status NOT IN (
                    '0000'
                )
                AND inbmsg.provider_chk_status NOT IN (
                    '0000'
                )
                AND inbmsg.drug_chk_status NOT IN (
                    '0000'
                )
                AND inbmsg.message_type IN (
                    'NewRx',
                    'RxChangeResponse',
                    'RxRenewalResponse'
                )
        )
    GROUP BY
        pharmacy_ncpdp_id,
        pharmacy_va_station_id,
        pharmacy_division_name,
        visn,
        pharmacy_address_line_1,
        pharmacy_address_line_2,
        pharmacy_city,
        pharmacy_state,
        pharmacy_zipcode,
        new_rx_message_date
    );

--ERX_SUMMARY_REPORT_MVW	  
	DROP MATERIALIZED VIEW "ERX"."ERX_SUMMARY_REPORT_MVW";
		
	CREATE MATERIALIZED VIEW "ERX"."ERX_SUMMARY_REPORT_MVW" (
    "PHARMACY_NCPDP_ID",
    "PHARMACY_VA_STATION_ID",
    "PHARMACY_DIVISION_NAME",
    "VISN",
    "PHARMACY_ADDRESS",
    "NEW_RX_CNT",
    "REFILL_REQUEST",
    "RX_CHANGE_REQUEST",
    "REFILL_RESPONSE",
    "RX_CHANGE_RESPONSE",
    "CANCEL_RX",
    "CANCEL_RX_RESPONSE",
    "RX_FILL",
    "NEW_RX_MESSAGE_DATE"
)
    REFRESH
        COMPLETE
        START WITH ( sysdate )
        NEXT ( trunc(sysdate) + 1 )
AS
    ( SELECT
        pharmacy_ncpdp_id,
        pharmacy_va_station_id,
        pharmacy_division_name,
        visn,
        pharmacy_address_line_1
        || ' '
        || pharmacy_address_line_2
        || ' '
        || pharmacy_city
        || ', '
        || pharmacy_state
        || ' '
        || pharmacy_zipcode pharmacy_address,
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
        (
            SELECT
                pharm.ncpdp_id        pharmacy_ncpdp_id,
                pharm.va_station_id   pharmacy_va_station_id,
                pharm.division_name   pharmacy_division_name,
                pharm.visn            visn,
                pharm.pharmacy_address_line_1,
                pharm.pharmacy_address_line_2,
                pharm.pharmacy_city,
                pharm.pharmacy_state,
                pharm.pharmacy_zipcode,
                decode(inbmsg.message_type, 'NewRx', 1, 0) new_rx_cnt,
                0 refill_request,
                decode(inbmsg.message_type, 'RefillResponse', 1, 'RxRenewalResponse', 1,
                       0) refill_response,
                0 rx_change_request,
                decode(inbmsg.message_type, 'RxChangeResponse', 1, 0) rx_change_response,
                decode(inbmsg.message_type, 'CancelRx', 1, 0) cancel_rx,
                0 cancel_rx_response,
                0 rx_fill,
                trunc(inbmsg.created_date) new_rx_message_date
            FROM
                erx.inbound_ncpdp_msg   inbmsg,
                erx.pharmacy            pharm
            WHERE
                inbmsg.pharmacy_id = pharm.pharmacy_id
                AND inbmsg.message_status NOT IN (
                    '0000'
                )
                AND inbmsg.message_type IN (
                    'NewRx',
                    'RefillResponse',
                    'RxRenewalResponse',
                    'CancelRx',
                    'RxChangeResponse'
                )
            UNION ALL
            SELECT
                pharm.ncpdp_id        pharmacy_ncpdp_id,
                pharm.va_station_id   pharmacy_va_station_id,
                pharm.division_name   pharmacy_division_name,
                pharm.visn            visn,
                pharm.pharmacy_address_line_1,
                pharm.pharmacy_address_line_2,
                pharm.pharmacy_city,
                pharm.pharmacy_state,
                pharm.pharmacy_zipcode,
                0 new_rx_cnt,
                decode(outbmsg.message_type, 'RefillRequest', 1, 'RxRenewalRequest', 1,
                       0) refill_request,
                0 refill_response,
                decode(outbmsg.message_type, 'RxChangeRequest', 1, 0) rx_change_request,
                0 rx_change_response,
                0 cancel_rx,
                decode(outbmsg.message_type, 'CancelRxResponse', 1, 0) cancel_rx_response,
                decode(outbmsg.message_type, 'RxFill', 1, 0) rx_fill,
                trunc(outbmsg.created_date) new_rx_message_date
            FROM
                erx.outbound_ncpdp_msg   outbmsg,
                erx.pharmacy             pharm
            WHERE
                outbmsg.pharmacy_id = pharm.pharmacy_id
                AND outbmsg.message_status NOT IN (
                    '0000'
                )
                AND outbmsg.message_type IN (
                    'RxRenewalRequest',
                    'RefillRequest',
                    'RxFill',
                    'CancelRxResponse',
                    'RxChangeRequest'
                )
                AND outbmsg.pharmacy_id <> 0
        ) outbmsg
    GROUP BY
        pharmacy_ncpdp_id,
        pharmacy_va_station_id,
        pharmacy_division_name,
        visn,
        pharmacy_address_line_1,
        pharmacy_address_line_2,
        pharmacy_city,
        pharmacy_state,
        pharmacy_zipcode,
        new_rx_message_date
    );	
	
--REJECT_REASONS_REPORT_MVW
	DROP MATERIALIZED VIEW "ERX"."REJECT_REASONS_REPORT_MVW";	

	CREATE MATERIALIZED VIEW "ERX"."REJECT_REASONS_REPORT_MVW" (
    "PHARMACY_NCPDP_ID",
    "PHARMACY_VA_STATION_ID",
    "PHARMACY_DIVISION_NAME",
    "VISN",
    "PHARMACY_ADDRESS",
    "NEW_RX_CNT",
    "NEW_RX_IN_PROCESS",
    "NEW_RX_REJECTED_BY_PHARMACIST",
    "NEW_RX_PATIENT_NOT_ELIG",
    "NEW_RX_PATIENT_NOT_FOUND",
    "NEW_RX_PROVIDER_NOT_ELIG",
    "NEW_RX_PROVIDER_NOT_FOUND",
    "NEW_RX_NOT_ELIG_REFILLS",
    "NEW_RX_NON_FORMULARY",
    "NEW_RX_DUPLICATE",
    "NEW_RX_INVALID_QTY",
    "NEW_RX_DUP_THERA_CLASS",
    "NEW_RX_CS_NOT_ALLOWED",
    "NEW_RX_ERR_MULTI_CALL_PHARM",
    "NEW_RX_INCORRECT_PHARM",
    "NEW_RX_ERR_CALL_PHARM",
    "NEW_RX_MESSAGE_DATE"
)
    REFRESH
        COMPLETE
        START WITH ( sysdate )
        NEXT ( trunc(sysdate) + 1 )
AS
    ( SELECT
        pharmacy_ncpdp_id,
        pharmacy_va_station_id,
        pharmacy_division_name,
        visn,
        pharmacy_address_line_1
        || ' '
        || pharmacy_address_line_2
        || ' '
        || pharmacy_city
        || ', '
        || pharmacy_state
        || ' '
        || pharmacy_zipcode pharmacy_address,
        SUM(new_rx_cnt) new_rx_cnt,
        SUM(new_rx_in_process) new_rx_in_process,
        SUM(new_rx_rejected_by_pharmacist) new_rx_rejected_by_pharmacist,
        SUM(new_rx_patient_not_elig) new_rx_patient_not_elig,
        SUM(new_rx_patient_not_found) new_rx_patient_not_found,
        SUM(new_rx_provider_not_elig) new_rx_provider_not_elig,
        SUM(new_rx_provider_not_found) new_rx_provider_not_found,
        SUM(new_rx_not_elig_refills) new_rx_not_elig_refills,
        SUM(new_rx_non_formulary) new_rx_non_formulary,
        SUM(new_rx_duplicate) new_rx_duplicate,
        SUM(new_rx_invalid_qty) new_rx_invalid_qty,
        SUM(new_rx_dup_thera_class) new_rx_dup_thera_class,
        SUM(new_rx_cs_not_allowed) new_rx_cs_not_allowed,
        SUM(new_rx_err_multi_call_pharm) new_rx_err_multi_call_pharm,
        SUM(new_rx_incorrect_pharm) new_rx_incorrect_pharm,
        SUM(new_rx_err_call_pharm) new_rx_err_call_pharm,
        new_rx_message_date
    FROM
        (
            SELECT
                pharm.ncpdp_id        pharmacy_ncpdp_id,
                pharm.va_station_id   pharmacy_va_station_id,
                pharm.division_name   pharmacy_division_name,
                pharm.visn            visn,
                pharm.pharmacy_address_line_1,
                pharm.pharmacy_address_line_2,
                pharm.pharmacy_city,
                pharm.pharmacy_state,
                pharm.pharmacy_zipcode,
                decode(inbmsg.message_type, 'NewRx', 1, 0) new_rx_cnt,
                0 new_rx_in_process,
                0 new_rx_rejected_by_pharmacist,
                0 new_rx_patient_not_elig,
                0 new_rx_patient_not_found,
                0 new_rx_provider_not_elig,
                0 new_rx_provider_not_found,
                0 new_rx_not_elig_refills,
                0 new_rx_non_formulary,
                0 new_rx_duplicate,
                0 new_rx_invalid_qty,
                0 new_rx_dup_thera_class,
                0 new_rx_cs_not_allowed,
                0 new_rx_err_multi_call_pharm,
                0 new_rx_incorrect_pharm,
                0 new_rx_err_call_pharm,
                trunc(inbmsg.created_date) new_rx_message_date
            FROM
                erx.inbound_ncpdp_msg   inbmsg,
                erx.pharmacy            pharm
            WHERE
                ( inbmsg.pharmacy_id = pharm.pharmacy_id
                  AND inbmsg.message_status NOT IN (
                    '0000'
                )
                  AND inbmsg.message_type IN (
                    'NewRx'
                )
                  AND pharm.pharmacy_id <> 0 )
            UNION ALL
            SELECT
                pharm.ncpdp_id        pharmacy_ncpdp_id,
                pharm.va_station_id   pharmacy_va_station_id,
                pharm.division_name   pharmacy_division_name,
                pharm.visn            visn,
                pharm.pharmacy_address_line_1,
                pharm.pharmacy_address_line_2,
                pharm.pharmacy_city,
                pharm.pharmacy_state,
                pharm.pharmacy_zipcode,
                0 new_rx_cnt,
                decode(extractvalue(outbmsg.message, '//VerifyStatus/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                'Accepted By Pharmacy.', 1, 0) + decode(extractvalue(outbmsg.message, '//VerifyStatus/Description'), 'Accepted By Pharmacy.'
                , 1, 0) new_rx_in_process,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 3), 'PTT', 1, 'ERR', 1,
                       'DRU', 1, 'PVD', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 3), 'PTT',
                       1, 'ERR', 1,
                                                       'DRU', 1, 'PVD', 1, 0) new_rx_rejected_by_pharmacist,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'PTT01', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'PTT01', 1, 0)
                new_rx_patient_not_elig,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'PTT02', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'PTT02', 1, 0)
                new_rx_patient_not_found,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'PVD01', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'PVD01', 1, 0)
                new_rx_provider_not_elig,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'PVD02', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'PVD02', 1, 0)
                new_rx_provider_not_found,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'DRU01', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'DRU01', 1, 0)
                new_rx_not_elig_refills,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'DRU02', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'DRU02', 1, 0)
                new_rx_non_formulary,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'DRU03', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'DRU03', 1, 0)
                new_rx_duplicate,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'DRU04', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'DRU04', 1, 0)
                new_rx_invalid_qty,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'DRU05', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'DRU05', 1, 0)
                new_rx_dup_thera_class,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'DRU06', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'DRU06', 1, 0)
                new_rx_cs_not_allowed,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'ERR01', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'ERR01', 1, 0)
                new_rx_err_multi_call_pharm,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'ERR02', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'ERR02', 1, 0)
                new_rx_incorrect_pharm,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 5), 'ERR03', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 5), 'ERR03', 1, 0)
                new_rx_err_call_pharm,
                trunc(outbmsg.created_date) new_rx_message_date
            FROM
                erx.outbound_ncpdp_msg   outbmsg,
                erx.pharmacy             pharm
            WHERE
                outbmsg.pharmacy_id = pharm.pharmacy_id
                AND outbmsg.message_status NOT IN (
                    '0000'
                )
                AND outbmsg.message_type IN (
                    'Error',
                    'Verify'
                )
                AND outbmsg.pharmacy_id <> 0
        ) outbmsg
    GROUP BY
        pharmacy_ncpdp_id,
        pharmacy_va_station_id,
        pharmacy_division_name,
        visn,
        pharmacy_address_line_1,
        pharmacy_address_line_2,
        pharmacy_city,
        pharmacy_state,
        pharmacy_zipcode,
        new_rx_message_date
    );	

--SUMMARY_REPORT_MVW		
	DROP MATERIALIZED VIEW "ERX" ."SUMMARY_REPORT_MVW";
		 
	CREATE MATERIALIZED VIEW "ERX"."SUMMARY_REPORT_MVW" (
    "PHARMACY_NCPDP_ID",
    "PHARMACY_VA_STATION_ID",
    "PHARMACY_DIVISION_NAME",
    "VISN",
    "PHARMACY_ADDRESS",
    "NEW_RX_CNT",
    "NEW_RX_PHARM_DISABLED_AT_HUB",
    "NEW_RX_REJECTED_AT_HUB",
    "NEW_RX_PASS_AUTO_CHK",
    "NEW_RX_FAIL_AUTO_CHK",
    "NEW_RX_REJECTED_BY_PHARMACIST",
    "NEW_RX_FILLED",
    "NEW_RX_IN_PROCESS",
    "NEW_RX_MESSAGE_DATE"
)
    REFRESH
        COMPLETE
        START WITH ( sysdate )
        NEXT ( trunc(sysdate) + 1 )
AS
    ( SELECT
        pharmacy_ncpdp_id,
        pharmacy_va_station_id,
        pharmacy_division_name,
        visn,
        pharmacy_address_line_1
        || ' '
        || pharmacy_address_line_2
        || ' '
        || pharmacy_city
        || ', '
        || pharmacy_state
        || ' '
        || pharmacy_zipcode pharmacy_address,
        SUM(new_rx_cnt) new_rx_cnt,
        SUM(new_rx_pharm_disabled_at_hub) new_rx_pharm_disabled_at_hub,
        SUM(new_rx_rejected_at_hub) new_rx_rejected_at_hub,
        SUM(new_rx_pass_auto_chk) new_rx_pass_auto_chk,
        SUM(new_rx_fail_auto_chk) new_rx_fail_auto_chk,
        SUM(new_rx_rejected_by_pharmacist) new_rx_rejected_by_pharmacist,
        SUM(new_rx_filled) new_rx_filled,
        SUM(new_rx_in_process) new_rx_in_process,
        new_rx_message_date
    FROM
        (
            SELECT
                pharm.ncpdp_id        pharmacy_ncpdp_id,
                pharm.va_station_id   pharmacy_va_station_id,
                pharm.division_name   pharmacy_division_name,
                pharm.visn            visn,
                pharm.pharmacy_address_line_1,
                pharm.pharmacy_address_line_2,
                pharm.pharmacy_city,
                pharm.pharmacy_state,
                pharm.pharmacy_zipcode,
                decode(inbmsg.message_type, 'NewRx', 1, 'RxRenewalResponse', 1,
                       'RxChangeResponse', 1, 0) new_rx_cnt,
                decode(inbmsg.message_status, '3010', 1, 0) new_rx_pharm_disabled_at_hub,
                decode(inbmsg.message_status, '3006', 1, 0) new_rx_rejected_at_hub,
                decode((decode(inbmsg.patient_chk_status, '0101', 1, 0) + decode(inbmsg.provider_chk_status, '2001', 1, 0) + decode
                (inbmsg.drug_chk_status, '1001', 1, 0)), 3, 1, 0) new_rx_pass_auto_chk,
                decode((decode(inbmsg.patient_chk_status, '0101', 1, 0) + decode(inbmsg.provider_chk_status, '2001', 1, 0) + decode
                (inbmsg.drug_chk_status, '1001', 1, 0)), 3, 0, 1) - decode(inbmsg.message_status, '3006', 1, 0) + decode(inbmsg.message_status
                , '3010', 1, 0) new_rx_fail_auto_chk,
                0 new_rx_rejected_by_pharmacist,
                0 new_rx_filled,
                0 new_rx_in_process,
                trunc(inbmsg.created_date) new_rx_message_date
            FROM
                erx.inbound_ncpdp_msg   inbmsg,
                erx.pharmacy            pharm
            WHERE
                inbmsg.pharmacy_id = pharm.pharmacy_id
                AND inbmsg.message_status NOT IN (
                    '0000'
                )
                AND inbmsg.patient_chk_status NOT IN (
                    '0000'
                )
                AND inbmsg.provider_chk_status NOT IN (
                    '0000'
                )
                AND inbmsg.drug_chk_status NOT IN (
                    '0000'
                )
                AND inbmsg.message_type IN (
                    'NewRx',
                    'RxChangeResponse',
                    'RxRenewalResponse'
                )
            UNION ALL
            SELECT
                pharm.ncpdp_id        pharmacy_ncpdp_id,
                pharm.va_station_id   pharmacy_va_station_id,
                pharm.division_name   pharmacy_division_name,
                pharm.visn            visn,
                pharm.pharmacy_address_line_1,
                pharm.pharmacy_address_line_2,
                pharm.pharmacy_city,
                pharm.pharmacy_state,
                pharm.pharmacy_zipcode,
                0 new_rx_cnt,
                0 new_rx_pharm_disabled_at_hub,
                0 new_rx_rejected_at_hub,
                0 new_rx_pass_auto_chk,
                0 new_rx_fail_auto_chk,
                decode(substr(extractvalue(outbmsg.message, '//Error/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                1, 3), 'PTT', 1, 'ERR', 1,
                       'DRU', 1, 'PVD', 1, 0) + decode(substr(extractvalue(outbmsg.message, '//Error/Description'), 1, 3), 'PTT',
                       1, 'ERR', 1,
                                                       'DRU', 1, 'PVD', 1, 0) new_rx_rejected_by_pharmacist,
                ( existsnode(outbmsg.message, '//RxFill/FillStatus/PartialFill', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"') + existsnode
                (outbmsg.message, '//RxFill/FillStatus/Filled', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"') ) new_rx_filled,
                decode(extractvalue(outbmsg.message, '//VerifyStatus/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'),
                'Accepted By Pharmacy.', 1, 0) + decode(extractvalue(outbmsg.message, '//VerifyStatus/Description', 'xmlns="http://www.ncpdp.org/schema/SCRIPT"'
                ), '', 1, 0) new_rx_in_process, --Accepted By Pharmacy + where Description is null to count legacy Verify messages created in Hub.
                trunc(outbmsg.created_date) new_rx_message_date
            FROM
                erx.outbound_ncpdp_msg   outbmsg,
                erx.pharmacy             pharm
            WHERE
                outbmsg.pharmacy_id = pharm.pharmacy_id
                AND outbmsg.message_status NOT IN (
                    '0000'
                )
                AND outbmsg.message_type IN (
                    'Error',
                    'RxFill',
                    'Verify'
                )
                AND outbmsg.pharmacy_id <> 0
        ) outbmsg
    GROUP BY
        pharmacy_ncpdp_id,
        pharmacy_va_station_id,
        pharmacy_division_name,
        visn,
        pharmacy_address_line_1,
        pharmacy_address_line_2,
        pharmacy_city,
        pharmacy_state,
        pharmacy_zipcode,
        new_rx_message_date
    );	  
	

--rem grant privileges to application roles	  
	

	grant select on erx.auto_check_report_mvw to erx_update_role, erx_read_role;	

	grant select on erx.erx_summary_report_mvw to erx_update_role, erx_read_role;	

	grant select on erx.summary_report_mvw to erx_update_role, erx_read_role;	

	grant select on erx.reject_reasons_report_mvw to erx_update_role, erx_read_role;


--------------------------------------------------------------------------------------------------------------------------------------------------------
