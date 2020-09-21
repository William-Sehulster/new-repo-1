package gov.va.med.pharmacy.persistence.track.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.apache.commons.text.StringEscapeUtils; 

import gov.va.med.pharmacy.persistence.track.NcpdpMessageListModel;
import gov.va.med.pharmacy.persistence.track.NcpdpMessageModel;
import gov.va.med.pharmacy.persistence.track.NcpdpMessagesDao;

@Component
public class NcpdpMessagesDaoImpl implements NcpdpMessagesDao {
	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(NcpdpMessagesDaoImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
    NcpdpMessageModel ncpdpMsg;
	
	public NcpdpMessagesDaoImpl() {
	}
	
	 public NcpdpMessagesDaoImpl(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }
	

		public class NcpdpMsgListRowMapper implements RowMapper<NcpdpMessageListModel>
		{
			public NcpdpMessageListModel mapRow(ResultSet rs, int rowNum) throws SQLException{
				NcpdpMessageListModel ncpdpMessageListModel = new NcpdpMessageListModel();
				ncpdpMessageListModel.setInboundNcpdpMsgId((rs.getLong("inbound_ncpdp_msg_id")));
				ncpdpMessageListModel.setRxMessageId(StringEscapeUtils.escapeJson(rs.getString("rx_messageId")));				
				ncpdpMessageListModel.setRelToMessageid(StringEscapeUtils.escapeJson(rs.getString("rel_to_message_id")));
				ncpdpMessageListModel.setMessageType(StringEscapeUtils.escapeJson(rs.getString("message_type")));
				ncpdpMessageListModel.setReceivedDate(StringEscapeUtils.escapeJson(rs.getString("received_date")));
				ncpdpMessageListModel.setVisn((rs.getInt("visn")));
				ncpdpMessageListModel.setVaStationId(StringEscapeUtils.escapeJson(rs.getString("va_station_id")));
				ncpdpMessageListModel.setPharmacyName(StringEscapeUtils.escapeJson(rs.getString("pharmacy_name")));
				ncpdpMessageListModel.setPharmacyAddr1(StringEscapeUtils.escapeJson(rs.getString("pharmacy_addr_1")));
				ncpdpMessageListModel.setPrescriberName(StringEscapeUtils.escapeJson(rs.getString("prescriber_Name")));
				ncpdpMessageListModel.setPrescriberNpi(StringEscapeUtils.escapeJson(rs.getString("prescriber_npi")));
				ncpdpMessageListModel.setPrescriberDEA(StringEscapeUtils.escapeJson(rs.getString("prescriber_DEA")));
				ncpdpMessageListModel.setPatientName(StringEscapeUtils.escapeJson(rs.getString("patient_Name")));
				ncpdpMessageListModel.setRxDrugPrescribed(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Prescribed")));
				ncpdpMessageListModel.setPatient_chk_status(StringEscapeUtils.escapeJson(rs.getString("patient_chk_status")));
				ncpdpMessageListModel.setProvider_chk_status(StringEscapeUtils.escapeJson(rs.getString("provider_chk_status")));
				ncpdpMessageListModel.setDrug_chk_status(StringEscapeUtils.escapeJson(rs.getString("drug_chk_status")));
				ncpdpMessageListModel.setMessage_status(StringEscapeUtils.escapeJson(rs.getString("message_status")));
				ncpdpMessageListModel.setPatientDob(StringEscapeUtils.escapeJson(rs.getString("patient_dob")));
				ncpdpMessageListModel.setPatientSsn(StringEscapeUtils.escapeJson(rs.getString("patient_ssn")));

	    		return ncpdpMessageListModel;
			}
		}
	 
	public class NcpdpMsgRowMapper implements RowMapper<NcpdpMessageModel>
	{
		public NcpdpMessageModel mapRow(ResultSet rs, int rowNum) throws SQLException{
			NcpdpMessageModel ncpdpMessageModel = new NcpdpMessageModel();
			ncpdpMessageModel.setInboundNcpdpMsgId(Long.parseUnsignedLong((rs.getString("inbound_ncpdp_msg_id"))));
			ncpdpMessageModel.setRxMessageId(StringEscapeUtils.escapeJson(rs.getString("rx_messageId")));
			ncpdpMessageModel.setRelToMessageid(StringEscapeUtils.escapeJson(rs.getString("rel_to_message_id")));
			ncpdpMessageModel.setMessage_status(StringEscapeUtils.escapeJson(rs.getString("message_status")));
			ncpdpMessageModel.setMessageType(StringEscapeUtils.escapeJson(rs.getString("message_type")));
			ncpdpMessageModel.setReceivedDate(StringEscapeUtils.escapeJson(rs.getString("received_date")));
			ncpdpMessageModel.setPharmacyName(StringEscapeUtils.escapeJson(rs.getString("pharmacy_name")));
			ncpdpMessageModel.setPharmacyAddr1(StringEscapeUtils.escapeJson(rs.getString("pharmacy_addr_1")));
			ncpdpMessageModel.setPharmacyAddr2(StringEscapeUtils.escapeJson(rs.getString("pharmacy_addr_2")));
			ncpdpMessageModel.setPharmacyPhone(StringEscapeUtils.escapeJson(rs.getString("pharmacy_phone")));
			ncpdpMessageModel.setPharmacyNcpdpid(StringEscapeUtils.escapeJson(rs.getString("pharmacy_ncpdpid"))); 
			ncpdpMessageModel.setPrescriberFirstName(StringEscapeUtils.escapeJson(rs.getString("prescriber_First_Name")));
			ncpdpMessageModel.setPrescriberMidName(StringEscapeUtils.escapeJson(rs.getString("prescriber_Mid_Name")));
			ncpdpMessageModel.setPrescriberLastName(StringEscapeUtils.escapeJson(rs.getString("prescriber_Last_Name")));
			ncpdpMessageModel.setPrescriberAddr1(StringEscapeUtils.escapeJson(rs.getString("prescriber_addr_1")));
			ncpdpMessageModel.setPrescriberAddr2(StringEscapeUtils.escapeJson(rs.getString("prescriber_addr_2")));
			ncpdpMessageModel.setPrescriberNPI(StringEscapeUtils.escapeJson(rs.getString("prescriber_NPI")));
			ncpdpMessageModel.setPrescriberDEA(StringEscapeUtils.escapeJson(rs.getString("prescriber_DEA")));
			ncpdpMessageModel.setPrescriberStateLic(StringEscapeUtils.escapeJson(rs.getString("prescriber_State_Lic")));
			ncpdpMessageModel.setPrescriberPhone(StringEscapeUtils.escapeJson(rs.getString("prescriber_phone")));
			ncpdpMessageModel.setPrescriberFax(StringEscapeUtils.escapeJson(rs.getString("prescriber_fax")));
			ncpdpMessageModel.setPrescriberAgent(StringEscapeUtils.escapeJson(rs.getString("prescriber_Agent")));
			ncpdpMessageModel.setPatientFirstName(StringEscapeUtils.escapeJson(rs.getString("patient_First_Name")));
			ncpdpMessageModel.setPatientMidName(StringEscapeUtils.escapeJson(rs.getString("patient_Mid_Name")));
			ncpdpMessageModel.setPatientLastName(StringEscapeUtils.escapeJson(rs.getString("patient_Last_Name")));
			ncpdpMessageModel.setPatientAddr1(StringEscapeUtils.escapeJson(rs.getString("patient_addr_1")));
			ncpdpMessageModel.setPatientAddr2(StringEscapeUtils.escapeJson(rs.getString("patient_addr_2")));
			ncpdpMessageModel.setPatientDob(StringEscapeUtils.escapeJson(rs.getString("patient_dob")));
			ncpdpMessageModel.setPatientSocSn(StringEscapeUtils.escapeJson(rs.getString("patient_ssn")));
			ncpdpMessageModel.setPatientGender(StringEscapeUtils.escapeJson(rs.getString("patient_gender")));
			ncpdpMessageModel.setRxDrugPrescribed(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Prescribed")));
			ncpdpMessageModel.setRxQuantity(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity")));
			ncpdpMessageModel.setRxDaysSupply(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply")));
			ncpdpMessageModel.setRxDateWritten(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written")));
			ncpdpMessageModel.setRxPotencyUnitCode(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code")));
			ncpdpMessageModel.setRxDrugForm(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form")));
			ncpdpMessageModel.setRxDrugStrength(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength")));
			ncpdpMessageModel.setRxRefills(StringEscapeUtils.escapeJson(rs.getString("rx_Refills")));
			ncpdpMessageModel.setRxSig(StringEscapeUtils.escapeJson(rs.getString("rx_Sig")));
			ncpdpMessageModel.setRxDispenseNotes(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes")));
			ncpdpMessageModel.setRxComments(StringEscapeUtils.escapeJson(rs.getString("rx_Comments")));
			//Autocheck Status
			ncpdpMessageModel.setRxPatientCheck(StringEscapeUtils.escapeJson(rs.getString("rx_Patient_Check")));
			ncpdpMessageModel.setRxProviderCheck(StringEscapeUtils.escapeJson(rs.getString("rx_Provider_Check")));
			ncpdpMessageModel.setRxDrugCheck(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Check")));
			// Medication Dispensed
			ncpdpMessageModel.setRxDrugDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Dispensed")));
			ncpdpMessageModel.setRxDrugDispensedNdc(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Dispensed_Ndc")));
			ncpdpMessageModel.setRxDrugDispensedQualifier(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Dispensed_Qualifier")));
			ncpdpMessageModel.setRxQuantityDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Dispensed")));
			ncpdpMessageModel.setRxDaysSupplyDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Dispensed")));
			ncpdpMessageModel.setRxDateWrittenDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Dispensed")));
			ncpdpMessageModel.setRxPotencyUnitCodeDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Dispensed")));
			ncpdpMessageModel.setRxDrugFormDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Dispensed")));
			ncpdpMessageModel.setRxDrugStrengthDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Dispensed")));
			ncpdpMessageModel.setRxRefillsDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Dispensed")));
			ncpdpMessageModel.setRxSigDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Dispensed")));
			ncpdpMessageModel.setRxDispenseNotesDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Dispensed")));
			ncpdpMessageModel.setRxCommentsDispensed(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Dispensed")));
			
			ncpdpMessageModel.setPlanId(StringEscapeUtils.escapeJson(rs.getString("plan_id")));
			ncpdpMessageModel.setRxGrp(StringEscapeUtils.escapeJson(rs.getString("rx_Grp")));
			ncpdpMessageModel.setRxBinNum(StringEscapeUtils.escapeJson(rs.getString("rx_Bin_Num")));
			ncpdpMessageModel.setRxPcn(StringEscapeUtils.escapeJson(rs.getString("rx_Pcn")));
			ncpdpMessageModel.setReqRefno(StringEscapeUtils.escapeJson(rs.getString("req_refno")));
			ncpdpMessageModel.setResType(StringEscapeUtils.escapeJson(rs.getString("res_type")));
			ncpdpMessageModel.setResAprvReasonCd(StringEscapeUtils.escapeJson(rs.getString("res_aprv_reason_cd"))); 
			ncpdpMessageModel.setResAprvRefno(StringEscapeUtils.escapeJson(rs.getString("res_aprv_refno"))); 
			ncpdpMessageModel.setResAprvNote(StringEscapeUtils.escapeJson(rs.getString("res_aprv_note"))); 
			ncpdpMessageModel.setResAprvWthChngReasonCd(StringEscapeUtils.escapeJson(rs.getString("res_aprv_w_chng_reason_cd"))); 
			ncpdpMessageModel.setResAprvWthChngRefno(StringEscapeUtils.escapeJson(rs.getString("res_aprv_w_chng_refno"))); 
			ncpdpMessageModel.setResAprvWthChngNote(StringEscapeUtils.escapeJson(rs.getString("res_aprv_w_chng_note")));
			ncpdpMessageModel.setResDenialReasonCd(StringEscapeUtils.escapeJson(rs.getString("res_denial_reason_cd"))); 
			ncpdpMessageModel.setResDenialRefno(StringEscapeUtils.escapeJson(rs.getString("res_denial_refno")));
			ncpdpMessageModel.setResDenialReason(StringEscapeUtils.escapeJson(rs.getString("res_denial_reason"))); 
			ncpdpMessageModel.setResDenialNrxReasonCd(StringEscapeUtils.escapeJson(rs.getString("res_denial_nrx_reason_cd"))); 
			ncpdpMessageModel.setResDenialNrxRefno(StringEscapeUtils.escapeJson(rs.getString("res_denial_nrx_refno"))); 
			ncpdpMessageModel.setResDenialNrxReason(StringEscapeUtils.escapeJson(rs.getString("res_denial_nrx_reason"))); 	
			ncpdpMessageModel.setEsvDescriptionCode(StringEscapeUtils.escapeJson(rs.getString("esv_description_code"))); 
			ncpdpMessageModel.setEsvCode(StringEscapeUtils.escapeJson(rs.getString("esv_code"))); 
			ncpdpMessageModel.setEsvDescription(StringEscapeUtils.escapeJson(rs.getString("esv_description"))); 
			ncpdpMessageModel.setClinicId(StringEscapeUtils.escapeJson(rs.getString("clinic_id")));
			
			ncpdpMessageModel.setRxReferenceNumber(StringEscapeUtils.escapeJson(rs.getString("rx_reference_number"))); 
			ncpdpMessageModel.setPrescriberOrderNumber(StringEscapeUtils.escapeJson(rs.getString("prescriber_order_number")));
			ncpdpMessageModel.setRxDrugPrescribedNdc(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Prescribed_Ndc")));
			ncpdpMessageModel.setRxDrugPrescribedQualifier(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Prescribed_Qualifier")));
			ncpdpMessageModel.setChangeofPrescrStatFlg(StringEscapeUtils.escapeJson(rs.getString("changeof_Prescr_Stat_Flg")));
			
			//RxFill
			ncpdpMessageModel.setRxFillStatus(StringEscapeUtils.escapeJson(rs.getString("rx_fill_status"))); 
			ncpdpMessageModel.setRxFillRefNum(StringEscapeUtils.escapeJson(rs.getString("rx_fill_ref_num")));
			ncpdpMessageModel.setRxFillNote(StringEscapeUtils.escapeJson(rs.getString("rx_fill_note")));
			ncpdpMessageModel.setRxFillReasonCd(StringEscapeUtils.escapeJson(rs.getString("rx_fill_reason_cd")));
			
			//RXCHANGEREQUEST
			ncpdpMessageModel.setChangeRequestType(StringEscapeUtils.escapeJson(rs.getString("change_request_type"))); 
			ncpdpMessageModel.setRequestReferenceNumber(StringEscapeUtils.escapeJson(rs.getString("request_reference_number")));
			
			// Medication Requested
			ncpdpMessageModel.setRxDrugRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested")));
			ncpdpMessageModel.setRxDrugRequestedNdc(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested_Ndc")));
			ncpdpMessageModel.setRxQuantityRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Requested")));
			ncpdpMessageModel.setRxDaysSupplyRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Requested")));
			ncpdpMessageModel.setRxDateWrittenRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Requested")));
			ncpdpMessageModel.setRxPotencyUnitCodeRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Req")));
			ncpdpMessageModel.setRxDrugFormRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Requested")));
			ncpdpMessageModel.setRxDrugStrengthRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Requested")));
			ncpdpMessageModel.setRxRefillsRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Requested")));
			ncpdpMessageModel.setRxSigRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Requested")));
			ncpdpMessageModel.setRxDispenseNotesRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Requested")));
			ncpdpMessageModel.setRxCommentsRequested(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Requested")));
			
			//2
			ncpdpMessageModel.setRxDrugRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested2")));
			ncpdpMessageModel.setRxDrugRequestedNdc2(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested_Ndc2")));
			ncpdpMessageModel.setRxQuantityRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Requested2")));
			ncpdpMessageModel.setRxDaysSupplyRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Requested2")));
			ncpdpMessageModel.setRxDateWrittenRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Requested2")));
			ncpdpMessageModel.setRxPotencyUnitCodeRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Req2")));
			ncpdpMessageModel.setRxDrugFormRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Requested2")));
			ncpdpMessageModel.setRxDrugStrengthRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Requested2")));
			ncpdpMessageModel.setRxRefillsRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Requested2")));
			ncpdpMessageModel.setRxSigRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Requested2")));
			ncpdpMessageModel.setRxDispenseNotesRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Requested2")));
			ncpdpMessageModel.setRxCommentsRequested2(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Requested2")));
			//3
			ncpdpMessageModel.setRxDrugRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested3")));
			ncpdpMessageModel.setRxDrugRequestedNdc3(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested_Ndc3")));
			ncpdpMessageModel.setRxQuantityRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Requested3")));
			ncpdpMessageModel.setRxDaysSupplyRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Requested3")));
			ncpdpMessageModel.setRxDateWrittenRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Requested3")));
			ncpdpMessageModel.setRxPotencyUnitCodeRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Req3")));
			ncpdpMessageModel.setRxDrugFormRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Requested3")));
			ncpdpMessageModel.setRxDrugStrengthRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Requested3")));
			ncpdpMessageModel.setRxRefillsRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Requested3")));
			ncpdpMessageModel.setRxSigRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Requested3")));
			ncpdpMessageModel.setRxDispenseNotesRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Requested3")));
			ncpdpMessageModel.setRxCommentsRequested3(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Requested3")));
			//4
			ncpdpMessageModel.setRxDrugRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested4")));
			ncpdpMessageModel.setRxDrugRequestedNdc4(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested_Ndc4")));
			ncpdpMessageModel.setRxQuantityRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Requested4")));
			ncpdpMessageModel.setRxDaysSupplyRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Requested4")));
			ncpdpMessageModel.setRxDateWrittenRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Requested4")));
			ncpdpMessageModel.setRxPotencyUnitCodeRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Req4")));
			ncpdpMessageModel.setRxDrugFormRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Requested4")));
			ncpdpMessageModel.setRxDrugStrengthRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Requested4")));
			ncpdpMessageModel.setRxRefillsRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Requested4")));
			ncpdpMessageModel.setRxSigRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Requested4")));
			ncpdpMessageModel.setRxDispenseNotesRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Requested4")));
			ncpdpMessageModel.setRxCommentsRequested4(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Requested4")));
			//5
			ncpdpMessageModel.setRxDrugRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested5")));
			ncpdpMessageModel.setRxDrugRequestedNdc5(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested_Ndc5")));
			ncpdpMessageModel.setRxQuantityRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Requested5")));
			ncpdpMessageModel.setRxDaysSupplyRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Requested5")));
			ncpdpMessageModel.setRxDateWrittenRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Requested5")));
			ncpdpMessageModel.setRxPotencyUnitCodeRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Req5")));
			ncpdpMessageModel.setRxDrugFormRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Requested5")));
			ncpdpMessageModel.setRxDrugStrengthRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Requested5")));
			ncpdpMessageModel.setRxRefillsRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Requested5")));
			ncpdpMessageModel.setRxSigRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Requested5")));
			ncpdpMessageModel.setRxDispenseNotesRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Requested5")));
			ncpdpMessageModel.setRxCommentsRequested5(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Requested5")));
			//6
			ncpdpMessageModel.setRxDrugRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested6")));
			ncpdpMessageModel.setRxDrugRequestedNdc6(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested_Ndc6")));
			ncpdpMessageModel.setRxQuantityRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Requested6")));
			ncpdpMessageModel.setRxDaysSupplyRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Requested6")));
			ncpdpMessageModel.setRxDateWrittenRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Requested6")));
			ncpdpMessageModel.setRxPotencyUnitCodeRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Req6")));
			ncpdpMessageModel.setRxDrugFormRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Requested6")));
			ncpdpMessageModel.setRxDrugStrengthRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Requested6")));
			ncpdpMessageModel.setRxRefillsRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Requested6")));
			ncpdpMessageModel.setRxSigRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Requested6")));
			ncpdpMessageModel.setRxDispenseNotesRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Requested6")));
			ncpdpMessageModel.setRxCommentsRequested6(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Requested6")));
			//7
			ncpdpMessageModel.setRxDrugRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested7")));
			ncpdpMessageModel.setRxDrugRequestedNdc7(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested_Ndc7")));
			ncpdpMessageModel.setRxQuantityRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Requested7")));
			ncpdpMessageModel.setRxDaysSupplyRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Requested7")));
			ncpdpMessageModel.setRxDateWrittenRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Requested7")));
			ncpdpMessageModel.setRxPotencyUnitCodeRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Req7")));
			ncpdpMessageModel.setRxDrugFormRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Requested7")));
			ncpdpMessageModel.setRxDrugStrengthRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Requested7")));
			ncpdpMessageModel.setRxRefillsRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Requested7")));
			ncpdpMessageModel.setRxSigRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Requested7")));
			ncpdpMessageModel.setRxDispenseNotesRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Requested7")));
			ncpdpMessageModel.setRxCommentsRequested7(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Requested7")));
			//8
			ncpdpMessageModel.setRxDrugRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested8")));
			ncpdpMessageModel.setRxDrugRequestedNdc8(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested_Ndc8")));
			ncpdpMessageModel.setRxQuantityRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Requested8")));
			ncpdpMessageModel.setRxDaysSupplyRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Requested8")));
			ncpdpMessageModel.setRxDateWrittenRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Requested8")));
			ncpdpMessageModel.setRxPotencyUnitCodeRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Req8")));
			ncpdpMessageModel.setRxDrugFormRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Requested8")));
			ncpdpMessageModel.setRxDrugStrengthRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Requested8")));
			ncpdpMessageModel.setRxRefillsRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Requested8")));
			ncpdpMessageModel.setRxSigRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Requested8")));
			ncpdpMessageModel.setRxDispenseNotesRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Requested8")));
			ncpdpMessageModel.setRxCommentsRequested8(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Requested8")));
			//9
			ncpdpMessageModel.setRxDrugRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested9")));
			ncpdpMessageModel.setRxDrugRequestedNdc9(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Requested_Ndc9")));
			ncpdpMessageModel.setRxQuantityRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Quantity_Requested9")));
			ncpdpMessageModel.setRxDaysSupplyRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Days_Supply_Requested9")));
			ncpdpMessageModel.setRxDateWrittenRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Date_Written_Requested9")));
			ncpdpMessageModel.setRxPotencyUnitCodeRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Potency_Unit_Code_Req9")));
			ncpdpMessageModel.setRxDrugFormRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Form_Requested9")));
			ncpdpMessageModel.setRxDrugStrengthRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Drug_Strength_Requested9")));
			ncpdpMessageModel.setRxRefillsRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Refills_Requested9")));
			ncpdpMessageModel.setRxSigRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Sig_Requested9")));
			ncpdpMessageModel.setRxDispenseNotesRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Dispense_Notes_Requested9")));
			ncpdpMessageModel.setRxCommentsRequested9(StringEscapeUtils.escapeJson(rs.getString("rx_Comments_Requested9")));
    		return ncpdpMessageModel;
		}
	}
	
	@Override
	public NcpdpMessageModel findById(String id, String inboundOutbound, String relatedMsgSearch) {		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "";
		boolean relatedMsg = false;
		 if(relatedMsgSearch!=null && relatedMsgSearch.length()>0){ 	
	        	relatedMsg = Boolean.parseBoolean(relatedMsgSearch);
		 }
		if (relatedMsg == true||inboundOutbound.equalsIgnoreCase("Inbound")) {	
        sql = "select t.inbound_ncpdp_msg_id inbound_ncpdp_msg_id,  \r\n" + 
        		"        		  x.message_id rx_messageId,  \r\n" + 
        		"        		  x.rel_to_message_id,  \r\n" + 
        		"        		  x.message_type,  \r\n" + 
        		"				  (select code_description from erx_status where code = t.message_status) message_status, \r\n"	+
        		"				  (select code_description from erx_status where code = t.patient_chk_status) rx_Patient_Check, \r\n"	+
        		"				  (select code_description from erx_status where code = t.provider_chk_status) rx_Provider_Check, \r\n"	+
        		"				  (select code_description from erx_status where code = t.drug_chk_status) rx_Drug_Check, \r\n"	+
        		"        		  to_char(t.received_date,'MM/DD/YYYY') received_date,  \r\n" + 
        		"        		  x.pharmacy_name,  \r\n" + 
        		"        		  x.pharmacy_addr_1||' '||x.pharmacy_addr_2 pharmacy_addr_1,  \r\n" + 
        		"        		  x.pharmacy_city||', '||x.pharmacy_state||'  '||x.pharmacy_zip pharmacy_addr_2,  \r\n" + 
        		"        		pharmacy_phone.pharmacy_number pharmacy_phone,  \r\n" + 
        		"        		nvl(x.pharmacy_ncpdpid1,x.pharmacy_ncpdpid2) pharmacy_ncpdpid,   \r\n" + 
        		"        		  x.prescriber_First_Name,  \r\n" + 
        		"        		  x.prescriber_Mid_Name,  \r\n" + 
        		"        		  x.prescriber_Last_Name,  \r\n" + 
        		"        		  x.prescriber_addr_1||' '||x.prescriber_addr_2 prescriber_addr_1,  \r\n" + 
        		"        		  x.prescriber_city||', '||x.prescriber_state||'  '||x.prescriber_zip prescriber_addr_2,  \r\n" + 
        		"        		  x.npi1 prescriber_NPI,  \r\n" + 
        		"        		  x.npi2 clinic_id,  \r\n" + 
        		"        		  x.prescriber_DEA prescriber_DEA,  \r\n" + 
        		"        		  x.prescriber_State_Lic,  \r\n" + 
        		"        		prescriber_fax.prescriber_faxnumber prescriber_fax, \r\n" + 
        		"        		prescriber_phone.prescriber_number prescriber_phone,  \r\n" + 
        		"        		  x.prescriber_agent_first_name||' '||x.prescriber_agent_last_name prescriber_Agent,  \r\n" + 
        		"        		  x.patient_First_Name,  \r\n" + 
        		"        		  x.patient_Mid_Name,  \r\n" + 
        		"        		  x.patient_Last_Name,  \r\n" + 
        		"        		  x.patient_addr_1||' '||x.patient_addr_2 patient_addr_1,  \r\n" + 
        		"        		  x.patient_city||', '||x.patient_state||'  '||x.patient_zip patient_addr_2,  \r\n" + 
        		"        		  decode(length(x.patient_dob),11, x.patient_dob, to_char(to_date(x.patient_dob,'YYYY-MM-DD'),'MM/DD/YYYY')) patient_dob,  \r\n" + 
        		"        		  x.patient_ssn patient_ssn,  \r\n" +
        		"        		  x.patient_gender patient_gender,  \r\n" + 
        		"        		  benefits1.cardholder_id plan_id,  \r\n" + 
        		"        		  x.rx_Drug_Prescribed,  \r\n" + 
        		"        		  decode(x.rx_Drug_Prescribed_Qualifier, 'ND', x.rx_Drug_Prescribed_Ndc,null) rx_Drug_Prescribed_Ndc,  \r\n" + 
        		"        		  x.rx_Drug_Prescribed_Qualifier,  \r\n" + 
        		"        		  decode(x.rx_Drug_Dispensed_Qualifier, 'ND', x.rx_Drug_Dispensed_Ndc,null) rx_Drug_Dispensed_Ndc,  \r\n" + 
        		"        		  x.rx_Drug_Dispensed_Qualifier rx_Drug_Dispensed_Qualifier,  \r\n" + 
        		"        		  x.rx_Quantity,  \r\n" + 
        		"        		  x.rx_Days_Supply,  \r\n" + 
        		"				  to_char(to_date(decode(substr(x.rx_Date_Written,0,INSTR(x.rx_Date_Written,'T')-1),null,x.rx_Date_Written,substr(x.rx_Date_Written,0,INSTR(x.rx_Date_Written,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written,  \r\n" + 
        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code) rx_Potency_Unit_Code,  \r\n" + 
        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form) rx_Drug_Form,  \r\n" + 
        		"        		  x.rx_Drug_Strength||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code) rx_Drug_Strength,  \r\n" + 
        		"        		  x.rx_Refills,  \r\n" + 
        		"        		  x.rx_Sig,\r\n" + 
        		"              	  decode(x.rx_Dispense_Notes,'0','YES','1','NO') rx_Dispense_Notes,\r\n" + 
        		"				  x.rx_Comments,  \r\n" +
        		"        		  x.rx_Drug_Dispensed,  \r\n" + 
        		"        		  x.rx_Quantity_Dispensed,  \r\n" + 
        		"        		  x.rx_Days_Supply_Dispensed,  \r\n" + 
        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Dispensed,0,INSTR(x.rx_Date_Written_Dispensed,'T')-1),null,x.rx_Date_Written_Dispensed,substr(x.rx_Date_Written_Dispensed,0,INSTR(x.rx_Date_Written_Dispensed,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Dispensed,  \r\n" + 
        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Dispensed) rx_Potency_Unit_Code_Dispensed,  \r\n" + 
        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Dispensed) rx_Drug_Form_Dispensed,  \r\n" + 
        		"        		  x.rx_Drug_Strength_Dispensed||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Disp) rx_Drug_Strength_Dispensed,  \r\n" + 
        		"        		  x.rx_Refills_Dispensed,  \r\n" + 
        		"        		  x.rx_Sig_Dispensed,\r\n" + 
        		"              	  decode(x.rx_Dispense_Notes_Dispensed,'0','YES','1','NO') rx_Dispense_Notes_Dispensed,\r\n" + 
        		"				  x.rx_Comments_Dispensed,  \r\n" +
        		"				  '' rx_Drug_Requested_Ndc, \r\n" +
				"	        	  '' rx_Drug_Requested," + 
				"	        	  '' rx_Quantity_Requested," +
				"	        	  '' rx_Days_Supply_Requested," +
				"	        	  '' rx_Date_Written_Requested," +
				"	        	  '' rx_Potency_Unit_Code_Req," +
				"				  '' rx_Drug_Form_Requested," +
				"	        	  '' rx_Drug_Strength_Requested," +
				"	        	  '' rx_Drug_Strength_Code_Req," +
				"	        	  '' rx_Refills_Requested, " +
				"	        	  '' rx_Sig_Requested," + 
				"	        	  '' rx_Dispense_Notes_Requested," +
				"	        	  '' rx_Comments_Requested," +
				//2
				"				  '' rx_Drug_Requested_Ndc2, \r\n" +
				"	        	  '' rx_Drug_Requested2," + 
				"	        	  '' rx_Quantity_Requested2," +
				"	        	  '' rx_Days_Supply_Requested2," +
				"	        	  '' rx_Date_Written_Requested2," +
				"	        	  '' rx_Potency_Unit_Code_Req2," +
				"				  '' rx_Drug_Form_Requested2," +
				"	        	  '' rx_Drug_Strength_Requested2," +
				"	        	  '' rx_Drug_Strength_Code_Req2," +
				"	        	  '' rx_Refills_Requested2, " +
				"	        	  '' rx_Sig_Requested2," + 
				"	        	  '' rx_Dispense_Notes_Requested2," +
				"	        	  '' rx_Comments_Requested2," +
			//3
				"				  '' rx_Drug_Requested_Ndc3, \r\n" +
				"	        	  '' rx_Drug_Requested3," + 
				"	        	  '' rx_Quantity_Requested3," +
				"	        	  '' rx_Days_Supply_Requested3," +
				"	        	  '' rx_Date_Written_Requested3," +
				"	        	  '' rx_Potency_Unit_Code_Req3," +
				"				  '' rx_Drug_Form_Requested3," +
				"	        	  '' rx_Drug_Strength_Requested3," +
				"	        	  '' rx_Drug_Strength_Code_Req3," +
				"	        	  '' rx_Refills_Requested3, " +
				"	        	  '' rx_Sig_Requested3," + 
				"	        	  '' rx_Dispense_Notes_Requested3," +
				"	        	  '' rx_Comments_Requested3," +
			//4
				"				  '' rx_Drug_Requested_Ndc4, \r\n" +
				"	        	  '' rx_Drug_Requested4," + 
				"	        	  '' rx_Quantity_Requested4," +
				"	        	  '' rx_Days_Supply_Requested4," +
				"	        	  '' rx_Date_Written_Requested4," +
				"	        	  '' rx_Potency_Unit_Code_Req4," +
				"				  '' rx_Drug_Form_Requested4," +
				"	        	  '' rx_Drug_Strength_Requested4," +
				"	        	  '' rx_Drug_Strength_Code_Req4," +
				"	        	  '' rx_Refills_Requested4, " +
				"	        	  '' rx_Sig_Requested4," + 
				"	        	  '' rx_Dispense_Notes_Requested4," +
				"	        	  '' rx_Comments_Requested4," +
			//5
				"				  '' rx_Drug_Requested_Ndc5, \r\n" +
				"	        	  '' rx_Drug_Requested5," + 
				"	        	  '' rx_Quantity_Requested5," +
				"	        	  '' rx_Days_Supply_Requested5," +
				"	        	  '' rx_Date_Written_Requested5," +
				"	        	  '' rx_Potency_Unit_Code_Req5," +
				"				  '' rx_Drug_Form_Requested5," +
				"	        	  '' rx_Drug_Strength_Requested5," +
				"	        	  '' rx_Drug_Strength_Code_Req5," +
				"	        	  '' rx_Refills_Requested5, " +
				"	        	  '' rx_Sig_Requested5," + 
				"	        	  '' rx_Dispense_Notes_Requested5," +
				"	        	  '' rx_Comments_Requested5," +
			//6
				"				  '' rx_Drug_Requested_Ndc6, \r\n" +
				"	        	  '' rx_Drug_Requested6," + 
				"	        	  '' rx_Quantity_Requested6," +
				"	        	  '' rx_Days_Supply_Requested6," +
				"	        	  '' rx_Date_Written_Requested6," +
				"	        	  '' rx_Potency_Unit_Code_Req6," +
				"				  '' rx_Drug_Form_Requested6," +
				"	        	  '' rx_Drug_Strength_Requested6," +
				"	        	  '' rx_Drug_Strength_Code_Req6," +
				"	        	  '' rx_Refills_Requested6, " +
				"	        	  '' rx_Sig_Requested6," + 
				"	        	  '' rx_Dispense_Notes_Requested6," +
				"	        	  '' rx_Comments_Requested6," +
			//7
				"				  '' rx_Drug_Requested_Ndc7, \r\n" +
				"	        	  '' rx_Drug_Requested7," + 
				"	        	  '' rx_Quantity_Requested7," +
				"	        	  '' rx_Days_Supply_Requested7," +
				"	        	  '' rx_Date_Written_Requested7," +
				"	        	  '' rx_Potency_Unit_Code_Req7," +
				"				  '' rx_Drug_Form_Requested7," +
				"	        	  '' rx_Drug_Strength_Requested7," +
				"	        	  '' rx_Drug_Strength_Code_Req7," +
				"	        	  '' rx_Refills_Requested7, " +
				"	        	  '' rx_Sig_Requested7," + 
				"	        	  '' rx_Dispense_Notes_Requested7," +
				"	        	  '' rx_Comments_Requested7," +
			//8
				"				  '' rx_Drug_Requested_Ndc8, \r\n" +
				"	        	  '' rx_Drug_Requested8," + 
				"	        	  '' rx_Quantity_Requested8," +
				"	        	  '' rx_Days_Supply_Requested8," +
				"	        	  '' rx_Date_Written_Requested8," +
				"	        	  '' rx_Potency_Unit_Code_Req8," +
				"				  '' rx_Drug_Form_Requested8," +
				"	        	  '' rx_Drug_Strength_Requested8," +
				"	        	  '' rx_Drug_Strength_Code_Req8," +
				"	        	  '' rx_Refills_Requested8, " +
				"	        	  '' rx_Sig_Requested8," + 
				"	        	  '' rx_Dispense_Notes_Requested8," +
				"	        	  '' rx_Comments_Requested8," +
			//9
				"				  '' rx_Drug_Requested_Ndc9, \r\n" +
				"	        	  '' rx_Drug_Requested9," + 
				"	        	  '' rx_Quantity_Requested9," +
				"	        	  '' rx_Days_Supply_Requested9," +
				"	        	  '' rx_Date_Written_Requested9," +
				"	        	  '' rx_Potency_Unit_Code_Req9," +
				"				  '' rx_Drug_Form_Requested9," +
				"	        	  '' rx_Drug_Strength_Requested9," +
				"	        	  '' rx_Drug_Strength_Code_Req9," +
				"	        	  '' rx_Refills_Requested9, " +
				"	        	  '' rx_Sig_Requested9," + 
				"	        	  '' rx_Dispense_Notes_Requested9," +
				"	        	  '' rx_Comments_Requested9," +
        		"        		  benefits1.groupID rx_Grp,\r\n" + 
        		"        		  benefits1.rx_Bin_Num rx_Bin_Num,  \r\n" + 
        		"        		  benefits1.rx_Pcn rx_Pcn, \r\n" + 
        		"                 x.res_type, \r\n" + 
        		"                 x.req_refno,\r\n" + 
        		"                 (select code||':  '||definition from ecl_code where code_type = '1131 – Code List Qualifier – Response Code - RES Segment' and code = x.res_aprv_reason_cd) res_aprv_reason_cd, \r\n" + 
        		"                 x.res_aprv_refno, \r\n" + 
        		"                 x.res_aprv_note, \r\n" + 
        		"                 (select code||':  '||definition from ecl_code where code_type = '1131 – Code List Qualifier – Response Code - RES Segment' and code = x.res_aprv_w_chng_reason_cd) res_aprv_w_chng_reason_cd, \r\n" + 
        		"                 x.res_aprv_w_chng_refno, \r\n" + 
        		"                 x.res_aprv_w_chng_note, \r\n" + 
        		"                 (select code||':  '||definition from ecl_code where code_type = '1131 – Code List Qualifier – Response Code - RES Segment' and code = x.res_denial_reason_cd) res_denial_reason_cd, \r\n" + 
        		"                 x.res_denial_refno, \r\n" + 
        		"                 x.res_denial_reason, \r\n" + 
        		"                 (select code||':  '||definition from ecl_code where code_type = '1131 – Code List Qualifier – Response Code - RES Segment' and code = x.res_denial_nrx_reason_cd) res_denial_nrx_reason_cd, \r\n" + 
        		"                 x.res_denial_nrx_refno, \r\n" + 
        		"                 x.res_denial_nrx_reason, " +
        		"                 x.esv_description_code, " +
        		"                 x.esv_code, " +
        		"                 x.esv_description, " +
        		"                 x.rx_reference_number, " +
        		"                 x.prescriber_order_number, " +
        		"                 decode(x.changeof_prescr_stat_flg,'C', 'C - Cancel', 'D', 'D - Discontinue',x.changeof_prescr_stat_flg) changeof_prescr_stat_flg, " +	
        		"                 '' rx_fill_status, " +
        		"                 '' rx_fill_ref_num, " +
        		"                 '' rx_fill_note, " +
        		"                 '' rx_fill_reason_cd, " +
        		"                 '' change_request_type, " +
        		"                 '' request_reference_number " +
        		"              from inbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
        		"        		    passing t.message  \r\n" + 
        		"        		    columns   \r\n" + 
        		"        		    message_id varchar2(35) path '//ns:Header/ns:MessageID',  \r\n" + 
        		"        		    rel_to_message_id varchar2(35) path '//ns:Header/ns:RelatesToMessageID',  \r\n" + 
        		"        		    message_type varchar2(35) path 'name(/ns:Body/*[1])',  \r\n" + 
        		"        		    pharmacy_name varchar2(35) path '//ns:Pharmacy/ns:StoreName',  \r\n" + 
        		"        		    pharmacy_addr_1 varchar2(35) path '//ns:Pharmacy/ns:Address/ns:AddressLine1',  \r\n" + 
        		"        		    pharmacy_addr_2 varchar2(35) path '//ns:Pharmacy/ns:Address/ns:AddressLine2',  \r\n" + 
        		"        		    pharmacy_city varchar2(35) path '//ns:Pharmacy/ns:Address/ns:City',  \r\n" + 
        		"        		    pharmacy_state varchar2(2) path '//ns:Pharmacy/ns:Address/ns:State',  \r\n" + 
        		"        		    pharmacy_zip varchar2(14) path '//ns:Pharmacy/ns:Address/ns:ZipCode',  \r\n" + 
        		"        		    pharmacy_ncpdpid1 varchar2(35) path '//ns:Pharmacy/ns:Identification/ns:NCPDPID',  \r\n" + 
        		"        		    pharmacy_ncpdpid2 varchar2(35) path '//ns:Header/ns:To',  \r\n" + 
        		"        		    npi1 varchar2(35) path '//ns:Prescriber/ns:Identification/ns:NPI',  \r\n" + 
        		"        		    npi2 varchar2(35) path '//ns:Header/ns:From',  \r\n" + 
        		"        		    prescriber_First_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:FirstName',  \r\n" + 
        		"        		    prescriber_Mid_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:MiddleName',  \r\n" + 
        		"        		    prescriber_Last_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:LastName',  \r\n" + 
        		"        		    prescriber_addr_1 varchar2(35) path '//ns:Prescriber/ns:Address/ns:AddressLine1',  \r\n" + 
        		"        		    prescriber_addr_2 varchar2(35) path '//ns:Prescriber/ns:Address/ns:AddressLine2',  \r\n" + 
        		"        		    prescriber_city varchar2(35) path '//ns:Prescriber/ns:Address/ns:City',  \r\n" + 
        		"        		    prescriber_state varchar2(2) path '//ns:Prescriber/ns:Address/ns:State',  \r\n" + 
        		"        		    prescriber_zip varchar2(14) path '//ns:Prescriber/ns:Address/ns:ZipCode',  \r\n" + 
        		"        		    prescriber_agent_last_name varchar2(35) path '//ns:Prescriber/ns:PrescriberAgent/ns:LastName',  \r\n" + 
        		"        		    prescriber_agent_first_name varchar2(35) path '//ns:Prescriber/ns:PrescriberAgent/ns:FirstName',  \r\n" + 
        		"        		    prescriber_DEA varchar2(35) path '//ns:Prescriber/ns:Identification/ns:DEANumber',  \r\n" + 
        		"        		    prescriber_State_Lic varchar2(35) path '//ns:Prescriber/ns:Identification/ns:StateLicenseNumber',  \r\n" + 
        		"        		    patient_First_Name varchar2(35) path '//ns:Patient/ns:Name/ns:FirstName',  \r\n" + 
        		"        		    patient_Mid_Name varchar2(35) path '//ns:Patient/ns:Name/ns:MiddleName',  \r\n" + 
        		"        		    patient_Last_Name varchar2(35) path '//ns:Patient/ns:Name/ns:LastName',  \r\n" + 
        		"        		    patient_addr_1 varchar2(35) path '//ns:Patient/ns:Address/ns:AddressLine1',  \r\n" + 
        		"        		    patient_addr_2 varchar2(35) path '//ns:Patient/ns:Address/ns:AddressLine2',  \r\n" + 
        		"        		    patient_city varchar2(35) path '//ns:Patient/ns:Address/ns:City',  \r\n" + 
        		"        		    patient_state varchar2(2) path '//ns:Patient/ns:Address/ns:State',  \r\n" + 
        		"        		    patient_zip varchar2(14) path '//ns:Patient/ns:Address/ns:ZipCode',  \r\n" + 
        		"        		    patient_dob varchar2(30) path '//ns:Patient/ns:DateOfBirth/ns:Date',  \r\n" + 
        		"    				patient_ssn varchar2(11) path '//ns:Patient/ns:Identification/ns:SocialSecurity',\r\n" + 
        		"        		    patient_gender varchar2(1) path '//ns:Patient/ns:Gender',  \r\n" + 
        		"        		    rx_Drug_Prescribed varchar2(105) path '//ns:MedicationPrescribed/ns:DrugDescription',  \r\n" + 
           		"        		    rx_Drug_Prescribed_Ndc varchar2(30) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:ProductCode',  \r\n" + 
           		"        		    rx_Drug_Prescribed_Qualifier varchar2(2) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:ProductCodeQualifier',  \r\n" +
        		"        		    rx_Quantity varchar2(30) path '//ns:MedicationPrescribed/ns:Quantity/ns:Value',  \r\n" + 
        		"        		    rx_Days_Supply varchar2(30) path '//ns:MedicationPrescribed/ns:DaysSupply',  \r\n" + 
        		"        		    rx_Date_Written varchar2(30) path '//ns:MedicationPrescribed/ns:WrittenDate',  \r\n" + 
        		"        		    rx_Potency_Unit_Code varchar2(30) path '//ns:MedicationPrescribed/ns:Quantity/ns:PotencyUnitCode',  \r\n" + 
        		"        		    rx_Drug_Form varchar2(30) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:FormCode',  \r\n" + 
        		"        		    rx_Drug_Strength varchar2(70) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:Strength',  \r\n" + 
        		"					rx_Drug_Strength_Code varchar2(30) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:StrengthCode',  \r\n" +
        		"        		    rx_Refills varchar2(2) path '//ns:MedicationPrescribed/ns:Refills/ns:Value',  \r\n" + 
        		"        		    rx_Sig varchar2(140) path '//ns:MedicationPrescribed/ns:Directions',  \r\n" + 
        		"        		    rx_Dispense_Notes varchar2(35) path '//ns:MedicationPrescribed/ns:Substitutions',  \r\n" + 
        		"        		    rx_Comments varchar2(210) path '//ns:MedicationPrescribed/ns:Note',  \r\n" + 
           		"        		    rx_Drug_Dispensed_Ndc varchar2(30) path '//ns:MedicationDispensed/ns:DrugCoded/ns:ProductCode',  \r\n" + 
           		"        		    rx_Drug_Dispensed_Qualifier varchar2(2) path '//ns:MedicationDispensed/ns:DrugCoded/ns:ProductCodeQualifier',  \r\n" +
        		"        		    rx_Drug_Dispensed varchar2(105) path '//ns:MedicationDispensed/ns:DrugDescription',  \r\n" + 
        		"        		    rx_Quantity_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:Quantity/ns:Value',  \r\n" + 
        		"        		    rx_Days_Supply_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:DaysSupply',  \r\n" + 
        		"        		    rx_Date_Written_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:WrittenDate',  \r\n" + 
        		"        		    rx_Potency_Unit_Code_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:Quantity/ns:PotencyUnitCode',  \r\n" + 
        		"        		    rx_Drug_Form_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:DrugCoded/ns:FormCode',  \r\n" + 
        		"        		    rx_Drug_Strength_Dispensed varchar2(70) path '//ns:MedicationDispensed/ns:DrugCoded/ns:Strength',  \r\n" + 
        		"					rx_Drug_Strength_Code_Disp varchar2(30) path '//ns:MedicationDispensed/ns:DrugCoded/ns:StrengthCode',  \r\n" +
        		"        		    rx_Refills_Dispensed varchar2(2) path '//ns:MedicationDispensed/ns:Refills/ns:Value',  \r\n" + 
        		"        		    rx_Sig_Dispensed varchar2(140) path '//ns:MedicationDispensed/ns:Directions',  \r\n" + 
        		"        		    rx_Dispense_Notes_Dispensed varchar2(35) path '//ns:MedicationDispensed/ns:Substitutions',  \r\n" + 
        		"        		    rx_Comments_Dispensed varchar2(210) path '//ns:MedicationDispensed/ns:Note',  \r\n" + 
        		"             		res_type varchar2(70) path 'name(/ns:Body/*/ns:Response/*[1])', \r\n" + 
        		"             		req_refno varchar2(70) path '//ns:Request/ns:Request/ns:ReferenceNumber',\r\n" + 
        		"             		res_aprv_reason_cd varchar2(70) path '//ns:Response/ns:Approved/ns:ApprovalReasonCode[1]',\r\n" + 
        		"             		res_aprv_refno varchar2(70) path '//ns:Response/ns:Approved/ns:ReferenceNumber',\r\n" + 
        		"             		res_aprv_note varchar2(70) path '//ns:Response/ns:Approved/ns:Note',\r\n" + 
        		"             		res_aprv_w_chng_reason_cd varchar2(70) path '//ns:Response/ns:ApprovedWithChanges/ns:DenialReasonCode[1]',\r\n" + 
        		"             		res_aprv_w_chng_refno varchar2(70) path '//ns:Response/ns:ApprovedWithChanges/ns:ReferenceNumber',\r\n" + 
        		"             		res_aprv_w_chng_note varchar2(70) path '//ns:Response/ns:ApprovedWithChanges/ns:Note',\r\n" + 
        		"             		res_denial_reason_cd varchar2(70) path '//ns:Response/ns:Denied/ns:DenialReasonCode[1]',\r\n" + 
        		"             		res_denial_refno varchar2(70) path '//ns:Response/ns:Denied/ns:ReferenceNumber',\r\n" + 
        		"              		res_denial_reason varchar2(70) path '//ns:Response/ns:Denied/ns:DenialReason',\r\n" + 
        		"              		res_denial_nrx_reason_cd varchar2(70) path '//ns:Response/ns:DeniedNewPrescriptionToFollow/ns:DenialReasonCode[1]',\r\n" + 
        		"              		res_denial_nrx_refno varchar2(70) path '//ns:Response/ns:DeniedNewPrescriptionToFollow/ns:ReferenceNumber',\r\n" + 
        		"              		res_denial_nrx_reason varchar2(70) path '//ns:Response/ns:DeniedNewPrescriptionToFollow/ns:DenialReason' ,\r\n" +
        		"              		esv_description_code varchar2(70) path '//ns:DescriptionCode[1]',\r\n" + 
        		"              		esv_code varchar2(70) path '//ns:Code',\r\n" + 
        		"              		esv_description varchar2(70) path '//ns:Description', \r\n" +
        		"        		    rx_reference_number varchar2(35) path '//ns:Header/ns:RxReferenceNumber',  \r\n" + 
        		"        		    prescriber_order_number varchar2(35) path '//ns:Header/ns:PrescriberOrderNumber',  \r\n" +
        		"        		    changeof_prescr_stat_flg varchar2(35) path '//ns:Request/ns:ChangeofPrescriptionStatusFlag'  \r\n" +
        		"        		    ) x,  \r\n" + 
        		"        		    (select pharmacy_com.pharmacy_number pharmacy_number,  \r\n" + 
        		"        		    pharmacy_com.pharmacy_qualifier pharmacy_qualifier,  \r\n" + 
        		"        		    t.inbound_ncpdp_msg_id inbound_ncpdp_msg_id  \r\n" + 
        		"        		    from erx.inbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
        		"        		    passing t.message  \r\n" + 
        		"        		    columns records XMLTYPE PATH '//ns:Pharmacy/ns:CommunicationNumbers') r,  \r\n" + 
        		"        		    xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"),'//ns:Communication'  \r\n" + 
        		"        		    passing r.records  \r\n" + 
        		"        		    columns  \r\n" + 
        		"        		    pharmacy_number varchar2(80) path '//ns:Number',  \r\n" + 
        		"        		    pharmacy_qualifier varchar2(2) path '//ns:Qualifier') pharmacy_com  \r\n" + 
        		"        		    where pharmacy_com.pharmacy_qualifier = 'TE') pharmacy_phone,  \r\n" + 
        		"        		    (select prescriber_com.prescriber_number prescriber_number,  \r\n" + 
        		"        		    prescriber_com.prescriber_qualifier prescriber_qualifier,  \r\n" + 
        		"        		    t.inbound_ncpdp_msg_id inbound_ncpdp_msg_id  \r\n" + 
        		"        		    from erx.inbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
        		"        		    passing t.message  \r\n" + 
        		"        		    columns records XMLTYPE PATH '//ns:Prescriber/ns:CommunicationNumbers') r,  \r\n" + 
        		"        		    xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"),'//ns:Communication'  \r\n" + 
        		"        		    passing r.records  \r\n" + 
        		"        		    columns  \r\n" + 
        		"        		    prescriber_number varchar2(80) path '//ns:Number',  \r\n" + 
        		"        		    prescriber_qualifier varchar2(2) path '//ns:Qualifier') prescriber_com  \r\n" + 
        		"        		    where prescriber_com.prescriber_qualifier = 'TE') prescriber_phone,  \r\n" + 
        		"        		    (select prescriber_com.prescriber_number prescriber_faxnumber,  \r\n" + 
        		"        		    prescriber_com.prescriber_qualifier prescriber_qualifier,  \r\n" + 
        		"        		    t.inbound_ncpdp_msg_id inbound_ncpdp_msg_id  \r\n" + 
        		"        		    from erx.inbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
        		"        		    passing t.message  \r\n" + 
        		"        		    columns records XMLTYPE PATH '//ns:Prescriber/ns:CommunicationNumbers') r,  \r\n" + 
        		"        		    xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"),'//ns:Communication'  \r\n" + 
        		"        		    passing r.records  \r\n" + 
        		"        		    columns  \r\n" + 
        		"        		    prescriber_number varchar2(80) path '//ns:Number',  \r\n" + 
        		"        		    prescriber_qualifier varchar2(2) path '//ns:Qualifier') prescriber_com  \r\n" + 
        		"        		    where prescriber_com.prescriber_qualifier = 'FX') prescriber_fax,  \r\n" + 
        		"					(select benefits.cardholder_id cardholder_id ,  \r\n" + 
        		"        		    benefits.groupID groupID, \r\n" + 
        		"                   benefits.rx_Pcn,\r\n" + 
        		"                   benefits.rx_Bin_Num,\r\n" + 
        		"        		    t.inbound_ncpdp_msg_id inbound_ncpdp_msg_id  \r\n" + 
        		"        		    from erx.inbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
        		"        		    passing t.message  \r\n" + 
        		"        		    columns \r\n" + 
        		"                   rx_Pcn varchar2(35) path '//ns:BenefitsCoordination[1]/ns:PayerIdentification/ns:ProcessorIdentificationNumber',  \r\n" + 
        		"        		    rx_Bin_Num varchar2(35) path '//ns:BenefitsCoordination[1]/ns:PayerIdentification/ns:BINLocationNumber',\r\n" + 
        		"        		    cardholder_id varchar2(35) path '//ns:BenefitsCoordination[1]/ns:CardholderID',  \r\n" + 
        		"        		    groupID varchar2(35) path '//ns:BenefitsCoordination[1]/ns:GroupID') benefits) benefits1 \r\n" +
        		"        		    where t.inbound_ncpdp_msg_id = pharmacy_phone.inbound_ncpdp_msg_id (+) and rownum < 2  \r\n" + 
        		"        			and t.inbound_ncpdp_msg_id = prescriber_fax.inbound_ncpdp_msg_id (+)  \r\n" + 
        		"        		    and t.inbound_ncpdp_msg_id = prescriber_phone.inbound_ncpdp_msg_id (+)  \r\n" + 
        		"					and t.inbound_ncpdp_msg_id = benefits1.inbound_ncpdp_msg_id (+) \r\n " ;
        	        
        	
			        if(relatedMsg == true){	
			        		sql = sql +  " and t.message_id = ?   union all ";
			        	}
			        else{
			        	sql =  sql + "               and t.inbound_ncpdp_msg_id = ? ";
			        }
		}
        
		if (relatedMsg == true||inboundOutbound.equalsIgnoreCase("Outbound")) {
	        sql = sql + " select t.outbound_ncpdp_msg_id inbound_ncpdp_msg_id,  \r\n" + 
	        		"        		  x.message_id rx_messageId,  \r\n" + 
	        		"        		  x.rel_to_message_id,  \r\n" + 
	        		"        		  x.message_type,  \r\n" + 
	        		"				  (select code_description from erx_status where code = t.message_status) message_status, \r\n"	+
	        		"                 '' rx_Patient_Check, " +
	        		"                 '' rx_Provider_Check, " +
	        		"                 '' rx_Drug_Check, " +
	        		"        		  to_char(t.received_date,'MM/DD/YYYY') received_date,  \r\n" + 
	        		"        		  x.pharmacy_name,  \r\n" + 
	        		"        		  x.pharmacy_addr_1||' '||x.pharmacy_addr_2 pharmacy_addr_1,  \r\n" + 
	        		"        		  x.pharmacy_city||', '||x.pharmacy_state||'  '||x.pharmacy_zip pharmacy_addr_2,  \r\n" + 
	        		"        		pharmacy_phone.pharmacy_number pharmacy_phone,  \r\n" + 
	        		"        		nvl(x.pharmacy_ncpdpid1,x.pharmacy_ncpdpid2) pharmacy_ncpdpid,   \r\n" + 
	        		"        		  x.prescriber_First_Name,  \r\n" + 
	        		"        		  x.prescriber_Mid_Name,  \r\n" + 
	        		"        		  x.prescriber_Last_Name,  \r\n" + 
	        		"        		  x.prescriber_addr_1||' '||x.prescriber_addr_2 prescriber_addr_1,  \r\n" + 
	        		"        		  x.prescriber_city||', '||x.prescriber_state||'  '||x.prescriber_zip prescriber_addr_2,  \r\n" + 
	        		"        		  x.npi1 prescriber_NPI,  \r\n" + 
	        		"        		  x.npi2 clinic_id,  \r\n" + 
	        		"        		  x.prescriber_DEA prescriber_DEA,  \r\n" + 
	        		"        		  x.prescriber_State_Lic,  \r\n" + 
	        		"        		prescriber_fax.prescriber_faxnumber prescriber_fax, \r\n" + 
	        		"        		prescriber_phone.prescriber_number prescriber_phone,  \r\n" + 
	        		"        		  x.prescriber_agent_first_name||' '||x.prescriber_agent_last_name prescriber_Agent,  \r\n" + 
	        		"        		  x.patient_First_Name,  \r\n" + 
	        		"        		  x.patient_Mid_Name,  \r\n" + 
	        		"        		  x.patient_Last_Name,  \r\n" + 
	        		"        		  x.patient_addr_1||' '||x.patient_addr_2 patient_addr_1,  \r\n" + 
	        		"        		  x.patient_city||', '||x.patient_state||'  '||x.patient_zip patient_addr_2,  \r\n" + 
	        		"        		  decode(length(x.patient_dob),11, x.patient_dob, to_char(to_date(x.patient_dob,'YYYY-MM-DD'),'MM/DD/YYYY')) patient_dob,  \r\n" + 
	        		"        		  x.patient_ssn patient_ssn,  \r\n" +
	        		"        		  x.patient_gender patient_gender,  \r\n" + 
	        		"        		  benefits1.cardholder_id plan_id,  \r\n" + 
	        		"        		  x.rx_Drug_Prescribed,  \r\n" +
	        		"        		  decode(x.rx_Drug_Prescribed_Qualifier, 'ND', x.rx_Drug_Prescribed_Ndc,null) rx_Drug_Prescribed_Ndc,  \r\n" + 
	        		"        		  x.rx_Drug_Prescribed_Qualifier,  \r\n" + 
	        		"        		  decode(x.rx_Drug_Dispensed_Qualifier, 'ND', x.rx_Drug_Dispensed_Ndc,null) rx_Drug_Dispensed_Ndc,  \r\n" + 
	        		"        		  x.rx_Drug_Dispensed_Qualifier,  \r\n" + 
	        		"        		  x.rx_Quantity,  \r\n" + 
	        		"        		  x.rx_Days_Supply,  \r\n" + 
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written,0,INSTR(x.rx_Date_Written,'T')-1),null,x.rx_Date_Written,substr(x.rx_Date_Written,0,INSTR(x.rx_Date_Written,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code) rx_Potency_Unit_Code,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form) rx_Drug_Form,  \r\n" + 
	        		"        		  x.rx_Drug_Strength||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code) rx_Drug_Strength,  \r\n" + 
	        		"        		  x.rx_Refills,  \r\n" + 
	        		"        		  x.rx_Sig,\r\n" + 
	        		"              		decode(x.rx_Dispense_Notes,'0','YES','1','NO') rx_Dispense_Notes,\r\n" + 
	        		"					x.rx_Comments,  \r\n" + 
	        		"        		  x.rx_Drug_Dispensed,  \r\n" + 
	        		"        		  x.rx_Quantity_Dispensed,  \r\n" + 
	        		"        		  x.rx_Days_Supply_Dispensed,  \r\n" + 
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Dispensed,0,INSTR(x.rx_Date_Written_Dispensed,'T')-1),null,x.rx_Date_Written_Dispensed,substr(x.rx_Date_Written_Dispensed,0,INSTR(x.rx_Date_Written_Dispensed,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Dispensed,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Dispensed) rx_Potency_Unit_Code_Dispensed,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Dispensed) rx_Drug_Form_Dispensed,  \r\n" + 
	        		"        		  x.rx_Drug_Strength_Dispensed||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Disp) rx_Drug_Strength_Dispensed,  \r\n" + 
	        		"        		  x.rx_Refills_Dispensed,  \r\n" + 
	        		"        		  x.rx_Sig_Dispensed,\r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Dispensed,'0','YES','1','NO') rx_Dispense_Notes_Dispensed,\r\n" + 
	        		"				  x.rx_Comments_Dispensed,  \r\n" +
	        		//1
	        		"				  decode(x.rx_Drug_Requested_Qualifier, 'ND', x.rx_Drug_Requested_Ndc,null) rx_Drug_Requested_Ndc,  \r\n" + 
	        		"				  x.rx_Drug_Requested,  \r\n" + 
	        		"				  x.rx_Quantity_Requested,  \r\n" +
	        		"				  x.rx_Days_Supply_Requested,  \r\n" +
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Requested,0,INSTR(x.rx_Date_Written_Requested,'T')-1),null,x.rx_Date_Written_Requested,substr(x.rx_Date_Written_Requested,0,INSTR(x.rx_Date_Written_Requested,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Requested,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Req) rx_Potency_Unit_Code_Req,  \r\n" + 
	        		"				  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Requested) rx_Drug_Form_Requested,  \r\n" + 
	        		"				  x.rx_Drug_Strength_Requested||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Req) rx_Drug_Strength_Requested,  \r\n" +
	        		"				  x.rx_Drug_Strength_Code_Req,  \r\n" +
					"	        	  x.rx_Refills_Requested,  \r\n" +
	        		"				  x.rx_Sig_Requested,  \r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Requested,'0','YES','1','NO') rx_Dispense_Notes_Requested,\r\n" + 
	        		"				  x.rx_Comments_Requested,  \r\n" +
//2
	        		"				  decode(x.rx_Drug_Requested_Qualifier2, 'ND', x.rx_Drug_Requested_Ndc2,null) rx_Drug_Requested_Ndc2,  \r\n" + 
	        		"				  x.rx_Drug_Requested2,  \r\n" + 
	        		"				  x.rx_Quantity_Requested2,  \r\n" +
	        		"				  x.rx_Days_Supply_Requested2,  \r\n" +
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Requested2,0,INSTR(x.rx_Date_Written_Requested2,'T')-1),null,x.rx_Date_Written_Requested2,substr(x.rx_Date_Written_Requested2,0,INSTR(x.rx_Date_Written_Requested2,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Requested2,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Req2) rx_Potency_Unit_Code_Req2,  \r\n" + 
	        		"				  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Requested2) rx_Drug_Form_Requested2,  \r\n" + 
	        		"				  x.rx_Drug_Strength_Requested2||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Req2) rx_Drug_Strength_Requested2,  \r\n" +
	        		"				  x.rx_Drug_Strength_Code_Req2,  \r\n" +
					"	        	  x.rx_Refills_Requested2,  \r\n" +
	        		"				  x.rx_Sig_Requested2,  \r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Requested2,'0','YES','1','NO') rx_Dispense_Notes_Requested2,\r\n" + 
	        		"				  x.rx_Comments_Requested2,  \r\n" +
//3
	        		"				  decode(x.rx_Drug_Requested_Qualifier3, 'ND', x.rx_Drug_Requested_Ndc3,null) rx_Drug_Requested_Ndc3,  \r\n" + 
	        		"				  x.rx_Drug_Requested3,  \r\n" + 
	        		"				  x.rx_Quantity_Requested3,  \r\n" +
	        		"				  x.rx_Days_Supply_Requested3,  \r\n" +
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Requested3,0,INSTR(x.rx_Date_Written_Requested3,'T')-1),null,x.rx_Date_Written_Requested3,substr(x.rx_Date_Written_Requested3,0,INSTR(x.rx_Date_Written_Requested3,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Requested3,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Req3) rx_Potency_Unit_Code_Req3,  \r\n" + 
	        		"				  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Requested3) rx_Drug_Form_Requested3,  \r\n" + 
	        		"				  x.rx_Drug_Strength_Requested3||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Req3) rx_Drug_Strength_Requested3,  \r\n" +
	        		"				  x.rx_Drug_Strength_Code_Req3,  \r\n" +
					"	        	  x.rx_Refills_Requested3,  \r\n" +
	        		"				  x.rx_Sig_Requested3,  \r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Requested3,'0','YES','1','NO') rx_Dispense_Notes_Requested3,\r\n" + 
	        		"				  x.rx_Comments_Requested3,  \r\n" +
//4
	        		"				  decode(x.rx_Drug_Requested_Qualifier4, 'ND', x.rx_Drug_Requested_Ndc4,null) rx_Drug_Requested_Ndc4,  \r\n" + 
	        		"				  x.rx_Drug_Requested4,  \r\n" + 
	        		"				  x.rx_Quantity_Requested4,  \r\n" +
	        		"				  x.rx_Days_Supply_Requested4,  \r\n" +
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Requested4,0,INSTR(x.rx_Date_Written_Requested4,'T')-1),null,x.rx_Date_Written_Requested4,substr(x.rx_Date_Written_Requested4,0,INSTR(x.rx_Date_Written_Requested4,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Requested4,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Req4) rx_Potency_Unit_Code_Req4,  \r\n" + 
	        		"				  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Requested4) rx_Drug_Form_Requested4,  \r\n" + 
	        		"				  x.rx_Drug_Strength_Requested4||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Req4) rx_Drug_Strength_Requested4,  \r\n" +
	        		"				  x.rx_Drug_Strength_Code_Req4,  \r\n" +
					"	        	  x.rx_Refills_Requested4,  \r\n" +
	        		"				  x.rx_Sig_Requested4,  \r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Requested4,'0','YES','1','NO') rx_Dispense_Notes_Requested4,\r\n" + 
	        		"				  x.rx_Comments_Requested4,  \r\n" +
//5
	        		"				  decode(x.rx_Drug_Requested_Qualifier5, 'ND', x.rx_Drug_Requested_Ndc5,null) rx_Drug_Requested_Ndc5,  \r\n" + 
	        		"				  x.rx_Drug_Requested5,  \r\n" + 
	        		"				  x.rx_Quantity_Requested5,  \r\n" +
	        		"				  x.rx_Days_Supply_Requested5,  \r\n" +
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Requested5,0,INSTR(x.rx_Date_Written_Requested5,'T')-1),null,x.rx_Date_Written_Requested5,substr(x.rx_Date_Written_Requested5,0,INSTR(x.rx_Date_Written_Requested5,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Requested5,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Req5) rx_Potency_Unit_Code_Req5,  \r\n" + 
	        		"				  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Requested5) rx_Drug_Form_Requested5,  \r\n" + 
	        		"				  x.rx_Drug_Strength_Requested5||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Req5) rx_Drug_Strength_Requested5,  \r\n" +
	        		"				  x.rx_Drug_Strength_Code_Req5,  \r\n" +
					"	        	  x.rx_Refills_Requested5,  \r\n" +
	        		"				  x.rx_Sig_Requested5,  \r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Requested5,'0','YES','1','NO') rx_Dispense_Notes_Requested5,\r\n" + 
	        		"				  x.rx_Comments_Requested5,  \r\n" +
//6
	        		"				  decode(x.rx_Drug_Requested_Qualifier6, 'ND', x.rx_Drug_Requested_Ndc6,null) rx_Drug_Requested_Ndc6,  \r\n" + 
	        		"				  x.rx_Drug_Requested6,  \r\n" + 
	        		"				  x.rx_Quantity_Requested6,  \r\n" +
	        		"				  x.rx_Days_Supply_Requested6,  \r\n" +
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Requested6,0,INSTR(x.rx_Date_Written_Requested6,'T')-1),null,x.rx_Date_Written_Requested6,substr(x.rx_Date_Written_Requested6,0,INSTR(x.rx_Date_Written_Requested6,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Requested6,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Req6) rx_Potency_Unit_Code_Req6,  \r\n" + 
	        		"				  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Requested6) rx_Drug_Form_Requested6,  \r\n" + 
	        		"				  x.rx_Drug_Strength_Requested6||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Req6) rx_Drug_Strength_Requested6,  \r\n" +
	        		"				  x.rx_Drug_Strength_Code_Req6,  \r\n" +
					"	        	  x.rx_Refills_Requested6,  \r\n" +
	        		"				  x.rx_Sig_Requested6,  \r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Requested6,'0','YES','1','NO') rx_Dispense_Notes_Requested6,\r\n" + 
	        		"				  x.rx_Comments_Requested6,  \r\n" +
//7
	        		"				  decode(x.rx_Drug_Requested_Qualifier7, 'ND', x.rx_Drug_Requested_Ndc7,null) rx_Drug_Requested_Ndc7,  \r\n" + 
	        		"				  x.rx_Drug_Requested7,  \r\n" + 
	        		"				  x.rx_Quantity_Requested7,  \r\n" +
	        		"				  x.rx_Days_Supply_Requested7,  \r\n" +
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Requested7,0,INSTR(x.rx_Date_Written_Requested7,'T')-1),null,x.rx_Date_Written_Requested7,substr(x.rx_Date_Written_Requested7,0,INSTR(x.rx_Date_Written_Requested7,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Requested7,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Req7) rx_Potency_Unit_Code_Req7,  \r\n" + 
	        		"				  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Requested7) rx_Drug_Form_Requested7,  \r\n" + 
	        		"				  x.rx_Drug_Strength_Requested7||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Req7) rx_Drug_Strength_Requested7,  \r\n" +
	        		"				  x.rx_Drug_Strength_Code_Req7,  \r\n" +
					"	        	  x.rx_Refills_Requested7,  \r\n" +
	        		"				  x.rx_Sig_Requested7,  \r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Requested7,'0','YES','1','NO') rx_Dispense_Notes_Requested7,\r\n" + 
	        		"				  x.rx_Comments_Requested7,  \r\n" +
//8
	        		"				  decode(x.rx_Drug_Requested_Qualifier8, 'ND', x.rx_Drug_Requested_Ndc8,null) rx_Drug_Requested_Ndc8,  \r\n" + 
	        		"				  x.rx_Drug_Requested8,  \r\n" + 
	        		"				  x.rx_Quantity_Requested8,  \r\n" +
	        		"				  x.rx_Days_Supply_Requested8,  \r\n" +
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Requested8,0,INSTR(x.rx_Date_Written_Requested8,'T')-1),null,x.rx_Date_Written_Requested8,substr(x.rx_Date_Written_Requested8,0,INSTR(x.rx_Date_Written_Requested8,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Requested8,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Req8) rx_Potency_Unit_Code_Req8,  \r\n" + 
	        		"				  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Requested8) rx_Drug_Form_Requested8,  \r\n" + 
	        		"				  x.rx_Drug_Strength_Requested8||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Req8) rx_Drug_Strength_Requested8,  \r\n" +
	        		"				  x.rx_Drug_Strength_Code_Req8,  \r\n" +
					"	        	  x.rx_Refills_Requested8,  \r\n" +
	        		"				  x.rx_Sig_Requested8,  \r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Requested8,'0','YES','1','NO') rx_Dispense_Notes_Requested8,\r\n" + 
	        		"				  x.rx_Comments_Requested8,  \r\n" +
//9
	        		"				  decode(x.rx_Drug_Requested_Qualifier9, 'ND', x.rx_Drug_Requested_Ndc9,null) rx_Drug_Requested_Ndc9,  \r\n" + 
	        		"				  x.rx_Drug_Requested9,  \r\n" + 
	        		"				  x.rx_Quantity_Requested9,  \r\n" +
	        		"				  x.rx_Days_Supply_Requested9,  \r\n" +
	        		"				  to_char(to_date(decode(substr(x.rx_Date_Written_Requested9,0,INSTR(x.rx_Date_Written_Requested9,'T')-1),null,x.rx_Date_Written_Requested9,substr(x.rx_Date_Written_Requested9,0,INSTR(x.rx_Date_Written_Requested9,'T')-1)),'YYYY-MM-DD'),'MM/DD/YYYY') rx_Date_Written_Requested9,  \r\n" + 
	        		"        		  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Potency_Unit_Code_Req9) rx_Potency_Unit_Code_Req9,  \r\n" + 
	        		"				  (select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Form_Requested9) rx_Drug_Form_Requested9,  \r\n" + 
	        		"				  x.rx_Drug_Strength_Requested9||' '||(select distinct ncit_pref_term from ncpdp_code where ncit_code = x.rx_Drug_Strength_Code_Req9) rx_Drug_Strength_Requested9,  \r\n" +
	        		"				  x.rx_Drug_Strength_Code_Req9,  \r\n" +
					"	        	  x.rx_Refills_Requested9,  \r\n" +
	        		"				  x.rx_Sig_Requested9,  \r\n" + 
	        		"              	  decode(x.rx_Dispense_Notes_Requested9,'0','YES','1','NO') rx_Dispense_Notes_Requested9,\r\n" + 
	        		"				  x.rx_Comments_Requested9,  \r\n" +
	        		"        		  benefits1.groupID rx_Grp,\r\n" + 
	        		"        		  benefits1.rx_Bin_Num rx_Bin_Num,  \r\n" + 
	        		"        		  benefits1.rx_Pcn rx_Pcn, \r\n" + 
	        		"                 x.res_type, \r\n" + 
	        		"                 x.req_refno,\r\n" + 
	        		"                 (select code||':  '||definition from ecl_code where code_type = '1131 – Code List Qualifier – Response Code - RES Segment' and code = x.res_aprv_reason_cd) res_aprv_reason_cd, \r\n" + 
	        		"                 x.res_aprv_refno, \r\n" + 
	        		"                 x.res_aprv_note, \r\n" + 
	        		"                 (select code||':  '||definition from ecl_code where code_type = '1131 – Code List Qualifier – Response Code - RES Segment' and code = x.res_aprv_w_chng_reason_cd) res_aprv_w_chng_reason_cd, \r\n" + 
	        		"                 x.res_aprv_w_chng_refno, \r\n" + 
	        		"                 x.res_aprv_w_chng_note, \r\n" + 
	        		"                 (select code||':  '||definition from ecl_code where code_type = '1131 – Code List Qualifier – Response Code - RES Segment' and code = x.res_denial_reason_cd) res_denial_reason_cd, \r\n" + 
	        		"                 x.res_denial_refno, \r\n" + 
	        		"                 x.res_denial_reason, \r\n" + 
	        		"                 (select code||':  '||definition from ecl_code where code_type = '1131 – Code List Qualifier – Response Code - RES Segment' and code = x.res_denial_nrx_reason_cd) res_denial_nrx_reason_cd, \r\n" + 
	        		"                 x.res_denial_nrx_refno, \r\n" + 
	        		"                 x.res_denial_nrx_reason, " +
	        		"                 x.esv_description_code, " +
	        		"                 x.esv_code, " +
	        		"                 x.esv_description, " +
	        		"                 x.rx_reference_number, " +
	        		"                 x.prescriber_order_number, " +
	        		"                 '' changeof_prescr_stat_flg, " +
	        		"                 x.rx_fill_status, " +
	        		"                 x.rx_fill_ref_num, " +
	        		"                 x.rx_fill_note, " +
	        		"                 (select code||':  '||definition from ecl_code where code_type = '1131 – Code List Qualifier – Response Code - RES Segment' and code = x.rx_fill_reason_cd)  rx_fill_reason_cd, \r\n" +
	        		"                 decode(x.change_request_type,'G', 'Generic','T','Therapeutic Interchange','P','Prior Authorization') change_request_type, " +
	        		"                 x.request_reference_number " +
	        		"              from outbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
	        		"        		    passing t.message  \r\n" + 
	        		"        		    columns   \r\n" + 
	        		"        		    message_id varchar2(35) path '//ns:Header/ns:MessageID',  \r\n" + 
	        		"        		    rel_to_message_id varchar2(35) path '//ns:Header/ns:RelatesToMessageID',  \r\n" + 
	        		"        		    message_type varchar2(35) path 'name(/ns:Body/*[1])',  \r\n" + 
	        		"        		    pharmacy_name varchar2(35) path '//ns:Pharmacy/ns:StoreName',  \r\n" + 
	        		"        		    pharmacy_addr_1 varchar2(35) path '//ns:Pharmacy/ns:Address/ns:AddressLine1',  \r\n" + 
	        		"        		    pharmacy_addr_2 varchar2(35) path '//ns:Pharmacy/ns:Address/ns:AddressLine2',  \r\n" + 
	        		"        		    pharmacy_city varchar2(35) path '//ns:Pharmacy/ns:Address/ns:City',  \r\n" + 
	        		"        		    pharmacy_state varchar2(2) path '//ns:Pharmacy/ns:Address/ns:State',  \r\n" + 
	        		"        		    pharmacy_zip varchar2(14) path '//ns:Pharmacy/ns:Address/ns:ZipCode',  \r\n" + 
	        		"        		    pharmacy_ncpdpid1 varchar2(35) path '//ns:Pharmacy/ns:Identification/ns:NCPDPID',  \r\n" + 
	        		"        		    pharmacy_ncpdpid2 varchar2(35) path '//ns:Header/ns:From',  \r\n" + 
	        		"        		    npi1 varchar2(35) path '//ns:Prescriber/ns:Identification/ns:NPI',  \r\n" + 
	        		"        		    npi2 varchar2(35) path '//ns:Header/ns:To',  \r\n" + 
	        		"        		    prescriber_First_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:FirstName',  \r\n" + 
	        		"        		    prescriber_Mid_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:MiddleName',  \r\n" + 
	        		"        		    prescriber_Last_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:LastName',  \r\n" + 
	        		"        		    prescriber_addr_1 varchar2(35) path '//ns:Prescriber/ns:Address/ns:AddressLine1',  \r\n" + 
	        		"        		    prescriber_addr_2 varchar2(35) path '//ns:Prescriber/ns:Address/ns:AddressLine2',  \r\n" + 
	        		"        		    prescriber_city varchar2(35) path '//ns:Prescriber/ns:Address/ns:City',  \r\n" + 
	        		"        		    prescriber_state varchar2(2) path '//ns:Prescriber/ns:Address/ns:State',  \r\n" + 
	        		"        		    prescriber_zip varchar2(14) path '//ns:Prescriber/ns:Address/ns:ZipCode',  \r\n" + 
	        		"        		    prescriber_agent_last_name varchar2(35) path '//ns:Prescriber/ns:PrescriberAgent/ns:LastName',  \r\n" + 
	        		"        		    prescriber_agent_first_name varchar2(35) path '//ns:Prescriber/ns:PrescriberAgent/ns:FirstName',  \r\n" + 
	        		"        		    prescriber_DEA varchar2(35) path '//ns:Prescriber/ns:Identification/ns:DEANumber',  \r\n" + 
	        		"        		    prescriber_State_Lic varchar2(35) path '//ns:Prescriber/ns:Identification/ns:StateLicenseNumber',  \r\n" + 
	        		"        		    patient_First_Name varchar2(35) path '//ns:Patient/ns:Name/ns:FirstName',  \r\n" + 
	        		"        		    patient_Mid_Name varchar2(35) path '//ns:Patient/ns:Name/ns:MiddleName',  \r\n" + 
	        		"        		    patient_Last_Name varchar2(35) path '//ns:Patient/ns:Name/ns:LastName',  \r\n" + 
	        		"        		    patient_addr_1 varchar2(35) path '//ns:Patient/ns:Address/ns:AddressLine1',  \r\n" + 
	        		"        		    patient_addr_2 varchar2(35) path '//ns:Patient/ns:Address/ns:AddressLine2',  \r\n" + 
	        		"        		    patient_city varchar2(35) path '//ns:Patient/ns:Address/ns:City',  \r\n" + 
	        		"        		    patient_state varchar2(2) path '//ns:Patient/ns:Address/ns:State',  \r\n" + 
	        		"        		    patient_zip varchar2(14) path '//ns:Patient/ns:Address/ns:ZipCode',  \r\n" + 
	        		"        		    patient_dob varchar2(30) path '//ns:Patient/ns:DateOfBirth/ns:Date',  \r\n" +
	        		"    				patient_ssn varchar2(11) path '//ns:Patient/ns:Identification/ns:SocialSecurity',\r\n" + 
	        		"        		    patient_gender varchar2(1) path '//ns:Patient/ns:Gender',  \r\n" + 
	        		"        		    rx_Drug_Prescribed varchar2(105) path '//ns:MedicationPrescribed/ns:DrugDescription',  \r\n" + 
	          		"        		    rx_Drug_Prescribed_Ndc varchar2(30) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:ProductCode',  \r\n" + 
	           		"        		    rx_Drug_Prescribed_Qualifier varchar2(2) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:ProductCodeQualifier',  \r\n" +
	           		"        		    rx_Drug_Dispensed_Ndc varchar2(30) path '//ns:MedicationDispensed/ns:DrugCoded/ns:ProductCode',  \r\n" + 
	           		"        		    rx_Drug_Dispensed_Qualifier varchar2(2) path '//ns:MedicationDispensed/ns:DrugCoded/ns:ProductCodeQualifier',  \r\n" +
	        		"        		    rx_Quantity varchar2(30) path '//ns:MedicationPrescribed/ns:Quantity/ns:Value',  \r\n" + 
	        		"        		    rx_Days_Supply varchar2(30) path '//ns:MedicationPrescribed/ns:DaysSupply',  \r\n" + 
	        		"        		    rx_Date_Written varchar2(30) path '//ns:MedicationPrescribed/ns:WrittenDate',  \r\n" + 
	        		"        		    rx_Potency_Unit_Code varchar2(30) path '//ns:MedicationPrescribed/ns:Quantity/ns:PotencyUnitCode',  \r\n" + 
	        		"        		    rx_Drug_Form varchar2(30) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:FormCode',  \r\n" + 
	        		"        		    rx_Drug_Strength varchar2(70) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:Strength',  \r\n" +
	        		"					rx_Drug_Strength_Code varchar2(30) path '//ns:MedicationPrescribed/ns:DrugCoded/ns:StrengthCode',  \r\n" +
	        		"        		    rx_Refills varchar2(2) path '//ns:MedicationPrescribed/ns:Refills/ns:Value',  \r\n" + 
	        		"        		    rx_Sig varchar2(140) path '//ns:MedicationPrescribed/ns:Directions',  \r\n" + 
	        		"        		    rx_Dispense_Notes varchar2(35) path '//ns:MedicationPrescribed/ns:Substitutions',  \r\n" + 
	        		"        		    rx_Comments varchar2(210) path '//ns:MedicationPrescribed/ns:Note',  \r\n" + 
	        		"        		    rx_Drug_Dispensed varchar2(105) path '//ns:MedicationDispensed/ns:DrugDescription',  \r\n" + 
	        		"        		    rx_Quantity_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:Quantity/ns:Value',  \r\n" + 
	        		"        		    rx_Days_Supply_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:DaysSupply',  \r\n" + 
	        		"        		    rx_Date_Written_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:WrittenDate',  \r\n" + 
	        		"        		    rx_Potency_Unit_Code_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:Quantity/ns:PotencyUnitCode',  \r\n" + 
	        		"        		    rx_Drug_Form_Dispensed varchar2(30) path '//ns:MedicationDispensed/ns:DrugCoded/ns:FormCode',  \r\n" + 
	        		"        		    rx_Drug_Strength_Dispensed varchar2(70) path '//ns:MedicationDispensed/ns:DrugCoded/ns:Strength',  \r\n" + 
	        		"					rx_Drug_Strength_Code_Disp varchar2(30) path '//ns:MedicationDispensed/ns:DrugCoded/ns:StrengthCode',  \r\n" +
	        		"        		    rx_Refills_Dispensed varchar2(2) path '//ns:MedicationDispensed/ns:Refills/ns:Value',  \r\n" + 
	        		"        		    rx_Sig_Dispensed varchar2(140) path '//ns:MedicationDispensed/ns:Directions',  \r\n" + 
	        		"        		    rx_Dispense_Notes_Dispensed varchar2(35) path '//ns:MedicationDispensed/ns:Substitutions',  \r\n" + 
	        		"        		    rx_Comments_Dispensed varchar2(210) path '//ns:MedicationDispensed/ns:Note',  \r\n" + 
	        		
	        		"        		    rx_Drug_Requested varchar2(105) path '//ns:MedicationRequested[1]/ns:DrugDescription',  \r\n" +
	        		"        		    rx_Drug_Requested_Qualifier varchar2(2) path '//ns:MedicationRequested[1]/ns:DrugCoded/ns:ProductCodeQualifier',  \r\n" +
	           		"        		    rx_Drug_Requested_Ndc varchar2(30) path '//ns:MedicationRequested[1]/ns:DrugCoded/ns:ProductCode',  \r\n" + 
	        		"        		    rx_Quantity_Requested varchar2(30) path '//ns:MedicationRequested[1]/ns:Quantity/ns:Value',  \r\n" + 
	        		"        		    rx_Days_Supply_Requested varchar2(30) path '//ns:MedicationRequested[1]/ns:DaysSupply',  \r\n" + 
	        		"        		    rx_Date_Written_Requested varchar2(30) path '//ns:MedicationRequested[1]/ns:WrittenDate',  \r\n" + 
	        		"        		    rx_Potency_Unit_Code_Req varchar2(30) path '//ns:MedicationRequested[1]/ns:Quantity/ns:PotencyUnitCode',  \r\n" + 
	        		"        		    rx_Drug_Form_Requested varchar2(30) path '//ns:MedicationRequested[1]/ns:DrugCoded/ns:FormCode',  \r\n" + 
	        		"        		    rx_Drug_Strength_Requested varchar2(70) path '//ns:MedicationRequested[1]/ns:DrugCoded/ns:Strength',  \r\n" + 
	        		"					rx_Drug_Strength_Code_Req varchar2(30) path '//ns:MedicationRequested[1]/ns:DrugCoded/ns:StrengthCode',  \r\n" +
	        		"        		    rx_Refills_Requested varchar2(2) path '//ns:MedicationRequested[1]/ns:Refills/ns:Value',  \r\n" + 
	        		"        		    rx_Sig_Requested varchar2(140) path '//ns:MedicationRequested[1]/ns:Directions',  \r\n" + 
	        		"        		    rx_Dispense_Notes_Requested varchar2(35) path '//ns:MedicationRequested[1]/ns:Substitutions',  \r\n" + 
	        		"        		    rx_Comments_Requested varchar2(210) path '//ns:MedicationRequested[1]/ns:Note',  \r\n" + 
	                 //2
	            		"        	rx_Drug_Requested2 varchar2(105) path '//ns:MedicationRequested[2]/ns:DrugDescription',   \r\n" +
	            		"        	rx_Drug_Requested_Qualifier2 varchar2(2) path '//ns:MedicationRequested[2]/ns:DrugCoded/ns:ProductCodeQualifier',   \r\n" +
	            		"        	rx_Drug_Requested_Ndc2 varchar2(30) path '//ns:MedicationRequested[2]/ns:DrugCoded/ns:ProductCode',   \r\n" +
	            		"        	rx_Quantity_Requested2 varchar2(30) path '//ns:MedicationRequested[2]/ns:Quantity/ns:Value',   \r\n" +
	            		"        	rx_Days_Supply_Requested2 varchar2(30) path '//ns:MedicationRequested[2]/ns:DaysSupply',   \r\n" +
	            		"        	rx_Date_Written_Requested2 varchar2(30) path '//ns:MedicationRequested[2]/ns:WrittenDate',   \r\n" +
	            		"        	rx_Potency_Unit_Code_Req2 varchar2(30) path '//ns:MedicationRequested[2]/ns:Quantity/ns:PotencyUnitCode',   \r\n" +
	            		"        	rx_Drug_Form_Requested2 varchar2(30) path '//ns:MedicationRequested[2]/ns:DrugCoded/ns:FormCode',   \r\n" +
	            		"        	rx_Drug_Strength_Requested2 varchar2(70) path '//ns:MedicationRequested[2]/ns:DrugCoded/ns:Strength',   \r\n" +
	            		"        	rx_Drug_Strength_Code_Req2 varchar2(30) path '//ns:MedicationRequested[2]/ns:DrugCoded/ns:StrengthCode',   \r\n" +
	            		"        	rx_Refills_Requested2 varchar2(2) path '//ns:MedicationRequested[2]/ns:Refills/ns:Value',   \r\n" +
	            		"        	rx_Sig_Requested2 varchar2(140) path '//ns:MedicationRequested[2]/ns:Directions',   \r\n" +
	            		"        	rx_Dispense_Notes_Requested2 varchar2(35) path '//ns:MedicationRequested[2]/ns:Substitutions',   \r\n" +
	            		"        	rx_Comments_Requested2 varchar2(210) path '//ns:MedicationRequested[2]/ns:Note',  \r\n" +
	                          //3
	            		"        	rx_Drug_Requested3 varchar2(105) path '//ns:MedicationRequested[3]/ns:DrugDescription',   \r\n" +
	            		"        	rx_Drug_Requested_Qualifier3 varchar2(2) path '//ns:MedicationRequested[3]/ns:DrugCoded/ns:ProductCodeQualifier',   \r\n" +
	            		"        	rx_Drug_Requested_Ndc3 varchar2(30) path '//ns:MedicationRequested[3]/ns:DrugCoded/ns:ProductCode',   \r\n" +
	            		"        	rx_Quantity_Requested3 varchar2(30) path '//ns:MedicationRequested[3]/ns:Quantity/ns:Value',   \r\n" +
	            		"        	rx_Days_Supply_Requested3 varchar2(30) path '//ns:MedicationRequested[3]/ns:DaysSupply',   \r\n" +
	            		"        	rx_Date_Written_Requested3 varchar2(30) path '//ns:MedicationRequested[3]/ns:WrittenDate',   \r\n" +
	            		"        	rx_Potency_Unit_Code_Req3 varchar2(30) path '//ns:MedicationRequested[3]/ns:Quantity/ns:PotencyUnitCode',   \r\n" +
	            		"        	rx_Drug_Form_Requested3 varchar2(30) path '//ns:MedicationRequested[3]/ns:DrugCoded/ns:FormCode',   \r\n" +
	            		"        	rx_Drug_Strength_Requested3 varchar2(70) path '//ns:MedicationRequested[3]/ns:DrugCoded/ns:Strength',   \r\n" +
	            		"        	rx_Drug_Strength_Code_Req3 varchar2(30) path '//ns:MedicationRequested[3]/ns:DrugCoded/ns:StrengthCode',   \r\n" +
	            		"        	rx_Refills_Requested3 varchar2(2) path '//ns:MedicationRequested[3]/ns:Refills/ns:Value',   \r\n" +
	            		"        	rx_Sig_Requested3 varchar2(140) path '//ns:MedicationRequested[3]/ns:Directions',   \r\n" +
	            		"        	rx_Dispense_Notes_Requested3 varchar2(35) path '//ns:MedicationRequested[3]/ns:Substitutions',   \r\n" +
	            		"        	rx_Comments_Requested3 varchar2(210) path '//ns:MedicationRequested[3]/ns:Note',  \r\n" +
	                          //4
	            		"        	rx_Drug_Requested4 varchar2(105) path '//ns:MedicationRequested[4]/ns:DrugDescription',   \r\n" +
	            		"        	rx_Drug_Requested_Qualifier4 varchar2(2) path '//ns:MedicationRequested[4]/ns:DrugCoded/ns:ProductCodeQualifier',   \r\n" +
	            		"        	rx_Drug_Requested_Ndc4 varchar2(30) path '//ns:MedicationRequested[4]/ns:DrugCoded/ns:ProductCode',   \r\n" +
	            		"        	rx_Quantity_Requested4 varchar2(30) path '//ns:MedicationRequested[4]/ns:Quantity/ns:Value',   \r\n" +
	            		"        	rx_Days_Supply_Requested4 varchar2(30) path '//ns:MedicationRequested[4]/ns:DaysSupply',   \r\n" +
	            		"        	rx_Date_Written_Requested4 varchar2(30) path '//ns:MedicationRequested[4]/ns:WrittenDate',   \r\n" +
	            		"        	rx_Potency_Unit_Code_Req4 varchar2(30) path '//ns:MedicationRequested[4]/ns:Quantity/ns:PotencyUnitCode',   \r\n" +
	            		"        	rx_Drug_Form_Requested4 varchar2(30) path '//ns:MedicationRequested[4]/ns:DrugCoded/ns:FormCode',   \r\n" +
	            		"        	rx_Drug_Strength_Requested4 varchar2(70) path '//ns:MedicationRequested[4]/ns:DrugCoded/ns:Strength',   \r\n" +
	            		"        	rx_Drug_Strength_Code_Req4 varchar2(30) path '//ns:MedicationRequested[4]/ns:DrugCoded/ns:StrengthCode',   \r\n" +
	            		"        	rx_Refills_Requested4 varchar2(2) path '//ns:MedicationRequested[4]/ns:Refills/ns:Value',   \r\n" +
	            		"        	rx_Sig_Requested4 varchar2(140) path '//ns:MedicationRequested[4]/ns:Directions',   \r\n" +
	            		"        	rx_Dispense_Notes_Requested4 varchar2(35) path '//ns:MedicationRequested[4]/ns:Substitutions',   \r\n" +
	            		"        	rx_Comments_Requested4 varchar2(210) path '//ns:MedicationRequested[4]/ns:Note',  \r\n" +
	                          //5
	            		"        	rx_Drug_Requested5 varchar2(105) path '//ns:MedicationRequested[5]/ns:DrugDescription',   \r\n" +
	            		"        	rx_Drug_Requested_Qualifier5 varchar2(2) path '//ns:MedicationRequested[5]/ns:DrugCoded/ns:ProductCodeQualifier',   \r\n" +
	            		"        	rx_Drug_Requested_Ndc5 varchar2(30) path '//ns:MedicationRequested[5]/ns:DrugCoded/ns:ProductCode',   \r\n" +
	            		"        	rx_Quantity_Requested5 varchar2(30) path '//ns:MedicationRequested[5]/ns:Quantity/ns:Value',   \r\n" +
	            		"        	rx_Days_Supply_Requested5 varchar2(30) path '//ns:MedicationRequested[5]/ns:DaysSupply',   \r\n" +
	            		"        	rx_Date_Written_Requested5 varchar2(30) path '//ns:MedicationRequested[5]/ns:WrittenDate',   \r\n" +
	            		"        	rx_Potency_Unit_Code_Req5 varchar2(30) path '//ns:MedicationRequested[5]/ns:Quantity/ns:PotencyUnitCode',   \r\n" +
	            		"        	rx_Drug_Form_Requested5 varchar2(30) path '//ns:MedicationRequested[5]/ns:DrugCoded/ns:FormCode',   \r\n" +
	            		"        	rx_Drug_Strength_Requested5 varchar2(70) path '//ns:MedicationRequested[5]/ns:DrugCoded/ns:Strength',   \r\n" +
	            		"        	rx_Drug_Strength_Code_Req5 varchar2(30) path '//ns:MedicationRequested[5]/ns:DrugCoded/ns:StrengthCode',   \r\n" +
	            		"        	rx_Refills_Requested5 varchar2(2) path '//ns:MedicationRequested[5]/ns:Refills/ns:Value',   \r\n" +
	            		"        	rx_Sig_Requested5 varchar2(140) path '//ns:MedicationRequested[5]/ns:Directions',   \r\n" +
	            		"        	rx_Dispense_Notes_Requested5 varchar2(35) path '//ns:MedicationRequested[5]/ns:Substitutions',   \r\n" +
	            		"        	rx_Comments_Requested5 varchar2(210) path '//ns:MedicationRequested[5]/ns:Note',  \r\n" +
	                          //6
	            		"        	rx_Drug_Requested6 varchar2(105) path '//ns:MedicationRequested[6]/ns:DrugDescription',   \r\n" +
	            		"        	rx_Drug_Requested_Qualifier6 varchar2(2) path '//ns:MedicationRequested[6]/ns:DrugCoded/ns:ProductCodeQualifier',   \r\n" +
	            		"        	rx_Drug_Requested_Ndc6 varchar2(30) path '//ns:MedicationRequested[6]/ns:DrugCoded/ns:ProductCode',   \r\n" +
	            		"        	rx_Quantity_Requested6 varchar2(30) path '//ns:MedicationRequested[6]/ns:Quantity/ns:Value',   \r\n" +
	            		"        	rx_Days_Supply_Requested6 varchar2(30) path '//ns:MedicationRequested[6]/ns:DaysSupply',   \r\n" +
	            		"        	rx_Date_Written_Requested6 varchar2(30) path '//ns:MedicationRequested[6]/ns:WrittenDate',   \r\n" +
	            		"        	rx_Potency_Unit_Code_Req6 varchar2(30) path '//ns:MedicationRequested[6]/ns:Quantity/ns:PotencyUnitCode',   \r\n" +
	            		"        	rx_Drug_Form_Requested6 varchar2(30) path '//ns:MedicationRequested[6]/ns:DrugCoded/ns:FormCode',   \r\n" +
	            		"        	rx_Drug_Strength_Requested6 varchar2(70) path '//ns:MedicationRequested[6]/ns:DrugCoded/ns:Strength',   \r\n" +
	            		"        	rx_Drug_Strength_Code_Req6 varchar2(30) path '//ns:MedicationRequested[6]/ns:DrugCoded/ns:StrengthCode',   \r\n" +
	            		"        	rx_Refills_Requested6 varchar2(2) path '//ns:MedicationRequested[6]/ns:Refills/ns:Value',   \r\n" +
	            		"        	rx_Sig_Requested6 varchar2(140) path '//ns:MedicationRequested[6]/ns:Directions',   \r\n" +
	            		"        	rx_Dispense_Notes_Requested6 varchar2(35) path '//ns:MedicationRequested[6]/ns:Substitutions',   \r\n" +
	            		"        	rx_Comments_Requested6 varchar2(210) path '//ns:MedicationRequested[6]/ns:Note',  \r\n" +
	                          //7
	            		"        	rx_Drug_Requested7 varchar2(105) path '//ns:MedicationRequested[7]/ns:DrugDescription',   \r\n" +
	            		"        	rx_Drug_Requested_Qualifier7 varchar2(2) path '//ns:MedicationRequested[7]/ns:DrugCoded/ns:ProductCodeQualifier',   \r\n" +
	            		"        	rx_Drug_Requested_Ndc7 varchar2(30) path '//ns:MedicationRequested[7]/ns:DrugCoded/ns:ProductCode',   \r\n" +
	            		"        	rx_Quantity_Requested7 varchar2(30) path '//ns:MedicationRequested[7]/ns:Quantity/ns:Value',   \r\n" +
	            		"        	rx_Days_Supply_Requested7 varchar2(30) path '//ns:MedicationRequested[7]/ns:DaysSupply',   \r\n" +
	            		"        	rx_Date_Written_Requested7 varchar2(30) path '//ns:MedicationRequested[7]/ns:WrittenDate',   \r\n" +
	            		"        	rx_Potency_Unit_Code_Req7 varchar2(30) path '//ns:MedicationRequested[7]/ns:Quantity/ns:PotencyUnitCode',   \r\n" +
	            		"        	rx_Drug_Form_Requested7 varchar2(30) path '//ns:MedicationRequested[7]/ns:DrugCoded/ns:FormCode',   \r\n" +
	            		"        	rx_Drug_Strength_Requested7 varchar2(70) path '//ns:MedicationRequested[7]/ns:DrugCoded/ns:Strength',   \r\n" +
	            		"        	rx_Drug_Strength_Code_Req7 varchar2(30) path '//ns:MedicationRequested[7]/ns:DrugCoded/ns:StrengthCode',   \r\n" +
	            		"        	rx_Refills_Requested7 varchar2(2) path '//ns:MedicationRequested[7]/ns:Refills/ns:Value',   \r\n" +
	            		"        	rx_Sig_Requested7 varchar2(140) path '//ns:MedicationRequested[7]/ns:Directions',   \r\n" +
	            		"        	rx_Dispense_Notes_Requested7 varchar2(35) path '//ns:MedicationRequested[7]/ns:Substitutions',   \r\n" +
	            		"        	rx_Comments_Requested7 varchar2(210) path '//ns:MedicationRequested[7]/ns:Note',  \r\n" +
	                          //8
	            		"        	rx_Drug_Requested8 varchar2(105) path '//ns:MedicationRequested[8]/ns:DrugDescription',   \r\n" +
	            		"        	rx_Drug_Requested_Qualifier8 varchar2(2) path '//ns:MedicationRequested[8]/ns:DrugCoded/ns:ProductCodeQualifier',   \r\n" +
	            		"        	rx_Drug_Requested_Ndc8 varchar2(30) path '//ns:MedicationRequested[8]/ns:DrugCoded/ns:ProductCode',   \r\n" +
	            		"        	rx_Quantity_Requested8 varchar2(30) path '//ns:MedicationRequested[8]/ns:Quantity/ns:Value',   \r\n" +
	            		"        	rx_Days_Supply_Requested8 varchar2(30) path '//ns:MedicationRequested[8]/ns:DaysSupply',   \r\n" +
	            		"        	rx_Date_Written_Requested8 varchar2(30) path '//ns:MedicationRequested[8]/ns:WrittenDate',   \r\n" +
	            		"        	rx_Potency_Unit_Code_Req8 varchar2(30) path '//ns:MedicationRequested[8]/ns:Quantity/ns:PotencyUnitCode',   \r\n" +
	            		"        	rx_Drug_Form_Requested8 varchar2(30) path '//ns:MedicationRequested[8]/ns:DrugCoded/ns:FormCode',   \r\n" +
	            		"        	rx_Drug_Strength_Requested8 varchar2(70) path '//ns:MedicationRequested[8]/ns:DrugCoded/ns:Strength',   \r\n" +
	            		"        	rx_Drug_Strength_Code_Req8 varchar2(30) path '//ns:MedicationRequested[8]/ns:DrugCoded/ns:StrengthCode',   \r\n" +
	            		"        	rx_Refills_Requested8 varchar2(2) path '//ns:MedicationRequested[8]/ns:Refills/ns:Value',   \r\n" +
	            		"        	rx_Sig_Requested8 varchar2(140) path '//ns:MedicationRequested[8]/ns:Directions',   \r\n" +
	            		"        	rx_Dispense_Notes_Requested8 varchar2(35) path '//ns:MedicationRequested[8]/ns:Substitutions',   \r\n" +
	            		"        	rx_Comments_Requested8 varchar2(210) path '//ns:MedicationRequested[8]/ns:Note',  \r\n" +
	                          //9
	            		"        	rx_Drug_Requested9 varchar2(105) path '//ns:MedicationRequested[9]/ns:DrugDescription',   \r\n" +
	            		"        	rx_Drug_Requested_Qualifier9 varchar2(2) path '//ns:MedicationRequested[9]/ns:DrugCoded/ns:ProductCodeQualifier',   \r\n" +
	            		"        	rx_Drug_Requested_Ndc9 varchar2(30) path '//ns:MedicationRequested[9]/ns:DrugCoded/ns:ProductCode',   \r\n" +
	            		"        	rx_Quantity_Requested9 varchar2(30) path '//ns:MedicationRequested[9]/ns:Quantity/ns:Value',   \r\n" +
	            		"        	rx_Days_Supply_Requested9 varchar2(30) path '//ns:MedicationRequested[9]/ns:DaysSupply',   \r\n" +
	            		"        	rx_Date_Written_Requested9 varchar2(30) path '//ns:MedicationRequested[9]/ns:WrittenDate',   \r\n" +
	            		"        	rx_Potency_Unit_Code_Req9 varchar2(30) path '//ns:MedicationRequested[9]/ns:Quantity/ns:PotencyUnitCode',   \r\n" +
	            		"        	rx_Drug_Form_Requested9 varchar2(30) path '//ns:MedicationRequested[9]/ns:DrugCoded/ns:FormCode',   \r\n" +
	            		"        	rx_Drug_Strength_Requested9 varchar2(70) path '//ns:MedicationRequested[9]/ns:DrugCoded/ns:Strength',   \r\n" +
	            		"        	rx_Drug_Strength_Code_Req9 varchar2(30) path '//ns:MedicationRequested[9]/ns:DrugCoded/ns:StrengthCode',   \r\n" +
	            		"        	rx_Refills_Requested9 varchar2(2) path '//ns:MedicationRequested[9]/ns:Refills/ns:Value',   \r\n" +
	            		"        	rx_Sig_Requested9 varchar2(140) path '//ns:MedicationRequested[9]/ns:Directions',   \r\n" +
	            		"        	rx_Dispense_Notes_Requested9 varchar2(35) path '//ns:MedicationRequested[9]/ns:Substitutions',   \r\n" +
	            		"        	rx_Comments_Requested9 varchar2(210) path '//ns:MedicationRequested[9]/ns:Note', \r\n" +
	        		"             		res_type varchar2(70) path 'name(/ns:Body/*/ns:Response/*[1])', \r\n" + 
	        		"             		req_refno varchar2(70) path '//ns:Request/ns:Request/ns:ReferenceNumber',\r\n" + 
	        		"             		res_aprv_reason_cd varchar2(70) path '//ns:Response/ns:Approved/ns:ApprovalReasonCode[1]',\r\n" + 
	        		"             		res_aprv_refno varchar2(70) path '//ns:Response/ns:Approved/ns:ReferenceNumber',\r\n" + 
	        		"             		res_aprv_note varchar2(70) path '//ns:Response/ns:Approved/ns:Note',\r\n" + 
	        		"             		res_aprv_w_chng_reason_cd varchar2(70) path '//ns:Response/ns:ApprovedWithChanges/ns:DenialReasonCode[1]',\r\n" + 
	        		"             		res_aprv_w_chng_refno varchar2(70) path '//ns:Response/ns:ApprovedWithChanges/ns:ReferenceNumber',\r\n" + 
	        		"             		res_aprv_w_chng_note varchar2(70) path '//ns:Response/ns:ApprovedWithChanges/ns:Note',\r\n" + 
	        		"             		res_denial_reason_cd varchar2(70) path '//ns:Response/ns:Denied/ns:DenialReasonCode[1]',\r\n" + 
	        		"             		res_denial_refno varchar2(70) path '//ns:Response/ns:Denied/ns:ReferenceNumber',\r\n" + 
	        		"              		res_denial_reason varchar2(70) path '//ns:Response/ns:Denied/ns:DenialReason',\r\n" + 
	        		"              		res_denial_nrx_reason_cd varchar2(70) path '//ns:Response/ns:DeniedNewPrescriptionToFollow/ns:DenialReasonCode[1]',\r\n" + 
	        		"              		res_denial_nrx_refno varchar2(70) path '//ns:Response/ns:DeniedNewPrescriptionToFollow/ns:ReferenceNumber',\r\n" + 
	        		"              		res_denial_nrx_reason varchar2(70) path '//ns:Response/ns:DeniedNewPrescriptionToFollow/ns:DenialReason' ,\r\n" +
	        		"              		esv_description_code varchar2(70) path '//ns:DescriptionCode[1]',\r\n" + 
	        		"              		esv_code varchar2(70) path '//ns:Code',\r\n" + 
	        		"              		esv_description varchar2(70) path '//ns:Description', \r\n" +
	        		"        		    rx_reference_number varchar2(35) path '//ns:Header/ns:RxReferenceNumber',  \r\n" + 
	        		"        		    prescriber_order_number varchar2(35) path '//ns:Header/ns:PrescriberOrderNumber',  \r\n" + 
	        		"        		    rx_fill_status varchar2(35) path 'name(/ns:Body/*/ns:FillStatus/*[1])',  \r\n" + 
	        		"        		    rx_fill_ref_num varchar2(35) path '//ns:FillStatus/*/ns:ReferenceNumber',  \r\n" + 
	        		"        		    rx_fill_note varchar2(70) path '//ns:FillStatus/*/ns:Note',  \r\n" + 
	        		"        		    rx_fill_reason_cd varchar2(35) path '//ns:FillStatus/*/ns:FillReasonCode',  \r\n" +
	        		"                   change_request_type varchar2(1) path '//ns:Request/ns:ChangeRequestType',  \r\n" +
	        		"                   request_reference_number varchar2(35) path '//ns:Request/ns:RequestReferenceNumber'  \r\n" +
	        		"        		    ) x,  \r\n" + 
	        		"        		    (select pharmacy_com.pharmacy_number pharmacy_number,  \r\n" + 
	        		"        		    pharmacy_com.pharmacy_qualifier pharmacy_qualifier,  \r\n" + 
	        		"        		    t.outbound_ncpdp_msg_id outbound_ncpdp_msg_id  \r\n" + 
	        		"        		    from outbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
	        		"        		    passing t.message  \r\n" + 
	        		"        		    columns records XMLTYPE PATH '//ns:Pharmacy/ns:CommunicationNumbers') r,  \r\n" + 
	        		"        		    xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"),'//ns:Communication'  \r\n" + 
	        		"        		    passing r.records  \r\n" + 
	        		"        		    columns  \r\n" + 
	        		"        		    pharmacy_number varchar2(80) path '//ns:Number',  \r\n" + 
	        		"        		    pharmacy_qualifier varchar2(2) path '//ns:Qualifier') pharmacy_com  \r\n" + 
	        		"        		    where pharmacy_com.pharmacy_qualifier = 'TE') pharmacy_phone,  \r\n" + 
	        		"        		    (select prescriber_com.prescriber_number prescriber_number,  \r\n" + 
	        		"        		    prescriber_com.prescriber_qualifier prescriber_qualifier,  \r\n" + 
	        		"        		    t.outbound_ncpdp_msg_id outbound_ncpdp_msg_id  \r\n" + 
	        		"        		    from outbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
	        		"        		    passing t.message  \r\n" + 
	        		"        		    columns records XMLTYPE PATH '//ns:Prescriber/ns:CommunicationNumbers') r,  \r\n" + 
	        		"        		    xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"),'//ns:Communication'  \r\n" + 
	        		"        		    passing r.records  \r\n" + 
	        		"        		    columns  \r\n" + 
	        		"        		    prescriber_number varchar2(80) path '//ns:Number',  \r\n" + 
	        		"        		    prescriber_qualifier varchar2(2) path '//ns:Qualifier') prescriber_com  \r\n" + 
	        		"        		    where prescriber_com.prescriber_qualifier = 'TE') prescriber_phone,  \r\n" + 
	        		"        		    (select prescriber_com.prescriber_number prescriber_faxnumber,  \r\n" + 
	        		"        		    prescriber_com.prescriber_qualifier prescriber_qualifier,  \r\n" + 
	        		"        		    t.outbound_ncpdp_msg_id outbound_ncpdp_msg_id  \r\n" + 
	        		"        		    from outbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
	        		"        		    passing t.message  \r\n" + 
	        		"        		    columns records XMLTYPE PATH '//ns:Prescriber/ns:CommunicationNumbers') r,  \r\n" + 
	        		"        		    xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"),'//ns:Communication'  \r\n" + 
	        		"        		    passing r.records  \r\n" + 
	        		"        		    columns  \r\n" + 
	        		"        		    prescriber_number varchar2(80) path '//ns:Number',  \r\n" + 
	        		"        		    prescriber_qualifier varchar2(2) path '//ns:Qualifier') prescriber_com  \r\n" + 
	        		"        		    where prescriber_com.prescriber_qualifier = 'FX') prescriber_fax,  \r\n" + 
	        		"					(select benefits.cardholder_id cardholder_id ,  \r\n" + 
	        		"        		    benefits.groupID groupID, \r\n" + 
	        		"                   benefits.rx_Pcn,\r\n" + 
	        		"                   benefits.rx_Bin_Num,\r\n" + 
	        		"        		    t.outbound_ncpdp_msg_id outbound_ncpdp_msg_id  \r\n" + 
	        		"        		    from outbound_ncpdp_msg t, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'  \r\n" + 
	        		"        		    passing t.message  \r\n" + 
	        		"        		    columns \r\n" + 
	        		"                   rx_Pcn varchar2(35) path '//ns:BenefitsCoordination[1]/ns:PayerIdentification/ns:ProcessorIdentificationNumber',  \r\n" + 
	        		"        		    rx_Bin_Num varchar2(35) path '//ns:BenefitsCoordination[1]/ns:PayerIdentification/ns:BINLocationNumber',\r\n" + 
	        		"        		    cardholder_id varchar2(35) path '//ns:BenefitsCoordination[1]/ns:CardholderID',  \r\n" + 
	        		"        		    groupID varchar2(35) path '//ns:BenefitsCoordination[1]/ns:GroupID') benefits) benefits1 \r\n" +
	        		"        		    where t.outbound_ncpdp_msg_id = pharmacy_phone.outbound_ncpdp_msg_id (+) and rownum < 2  \r\n" + 
	        		"        			and t.outbound_ncpdp_msg_id = prescriber_fax.outbound_ncpdp_msg_id (+)  \r\n" + 
	        		"        		    and t.outbound_ncpdp_msg_id = prescriber_phone.outbound_ncpdp_msg_id (+)  \r\n" + 
	        		"					and t.outbound_ncpdp_msg_id = benefits1.outbound_ncpdp_msg_id (+) \r\n ";	        		
	        
	 	
			 	if(relatedMsg == true){
			 		
			 		sql = sql + "                 and t.message_id = ? ";
			 	}
			 	
			 else{
			 	
				 sql = sql +   "        		    and t.outbound_ncpdp_msg_id = ? ";
			 }
		}
		

		try {
			LOG.info("Retrieving NCPDP message details.");
			if (relatedMsg == true){
				ncpdpMsg = (NcpdpMessageModel) jdbcTemplate.queryForObject(sql, new Object[] { id,id },new NcpdpMsgRowMapper());
			}
			else{
				ncpdpMsg = (NcpdpMessageModel) jdbcTemplate.queryForObject(sql, new Object[] { id },new NcpdpMsgRowMapper());
			}
		} catch (DataAccessException e) {
			ncpdpMsg.setDataError(e.getMessage());
			LOG.info("Exception retrieving NCPDP message details." + e.getMessage());
		}
        
		return ncpdpMsg;

	}
	
	@Override
	public List<NcpdpMessageListModel> searchMessages(String messageType, String messageId, String relatesToId, String visn, String vaStationId,
			String fromDate, String toDate, String patientSsn, String patientLastName, String patientFirstName, String patientDob, String prescriberNpi,
			String prescriberLastName, String prescriberFirstName, String prescriberDEA,  String prescribedDrug, String messageStatus, String inboundNcpdpMsgId, String inboundOutbound, boolean mbmAllowed) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		String sql = "";
		if (inboundOutbound.equalsIgnoreCase("Inbound")) {	
        sql = "select t.inbound_ncpdp_msg_id inbound_ncpdp_msg_id,\r\n" + 
                "p.visn visn,\r\n" +
                "p.va_station_id va_station_id,\r\n" +
                "x.npi1 prescriber_npi,\r\n" +
                "x.prescriber_DEA,  \r\n" + 
                "to_char(to_date(decode(length(x.patient_dob),11,substr(x.patient_dob, 2,10), x.patient_dob),'YYYY-MM-DD'),'MM/DD/YYYY') patient_dob,\r\n" +
                "x.patient_ssn patient_ssn,\r\n" +
        		"x.pharmacy_name pharmacy_name,\r\n" + 
        		"x.pharmacy_addr_1||' '||x.pharmacy_addr_2||' '||x.pharmacy_city||nvl2(x.pharmacy_city,nvl2(x.pharmacy_state,', ',null),null)||x.pharmacy_state||' '||x.pharmacy_zip pharmacy_addr_1,\r\n" + 
        		"x.patient_Last_Name||nvl2(x.patient_Last_Name,nvl2(x.patient_First_Name,', ',null),null)||x.patient_First_Name||' '||x.patient_Mid_Name patient_Name,\r\n" + 
        		"x.prescriber_Last_Name||nvl2(x.prescriber_Last_Name,nvl2(x.prescriber_First_Name,', ',null),null)||x.prescriber_First_Name||' '||x.prescriber_Mid_Name prescriber_Name,\r\n" + 
        		"x.rx_Drug_Prescribed rx_Drug_Prescribed,\r\n" + 
        		"t.message_type message_type,\r\n" + 
        		"t.rel_to_message_id rel_to_message_id,\r\n" + 
        		"t.message_id rx_messageId,\r\n" + 
        		"t.received_date received_date,\r\n" + 
        		"(select code_description from erx_status where code = t.patient_chk_status) patient_chk_status,\r\n" + 
        		"(select code_description from erx_status where code = t.provider_chk_status) provider_chk_status,\r\n" + 
        		"(select code_description from erx_status where code = t.drug_chk_status) drug_chk_status,\r\n" + 
        		"(select code_description from erx_status where code = t.message_status) message_status\r\n" + 
        		"from inbound_ncpdp_msg t, pharmacy p, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'\r\n" + 
        		"    passing t.message\r\n" + 
        		"    columns \r\n" + 
        		"    message_id varchar2(35) path '//ns:Header/ns:MessageID',\r\n" + 
        		"    rel_to_message_id varchar2(35) path '//ns:Header/ns:RelatesToMessageID',\r\n" + 
        		"    message_type varchar2(35) path 'name(/ns:Body/*[1])',\r\n" + 
        		"    pharmacy_name varchar2(30) path '//ns:Pharmacy/ns:StoreName',\r\n" + 
        		"    pharmacy_addr_1 varchar2(30) path '//ns:Pharmacy/ns:Address/ns:AddressLine1',\r\n" + 
        		"    pharmacy_addr_2 varchar2(30) path '//ns:Pharmacy/ns:Address/ns:AddressLine2',\r\n" + 
        		"    pharmacy_city varchar2(30) path '//ns:Pharmacy/ns:Address/ns:City',\r\n" + 
        		"    pharmacy_state varchar2(30) path '//ns:Pharmacy/ns:Address/ns:State',\r\n" + 
        		"    pharmacy_zip varchar2(30) path '//ns:Pharmacy/ns:Address/ns:ZipCode',\r\n" + 
        		"	 npi1 varchar2(35) path '//ns:Prescriber/ns:Identification/ns:NPI',\r\n" + 
        		"    npi2 varchar2(35) path '//ns:Header/ns:From',\r\n" + 
        		"    prescriber_First_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:FirstName',\r\n" + 
        		"    prescriber_Mid_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:MiddleName',\r\n" + 
        		"    prescriber_Last_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:LastName',\r\n" + 
        		"    prescriber_DEA varchar2(35) path '//ns:Prescriber/ns:Identification/ns:DEANumber',  \r\n" + 
        		"    patient_First_Name varchar2(35) path '//ns:Patient/ns:Name/ns:FirstName',\r\n" + 
        		"    patient_Mid_Name varchar2(35) path '//ns:Patient/ns:Name/ns:MiddleName',\r\n" + 
        		"    patient_Last_Name varchar2(35) path '//ns:Patient/ns:Name/ns:LastName',\r\n" + 
        		"    patient_addr_1 varchar2(30) path '//ns:Patient/ns:Address/ns:AddressLine1',\r\n" + 
        		"    patient_addr_2 varchar2(30) path '//ns:Patient/ns:Address/ns:AddressLine2',\r\n" + 
        		"    patient_city varchar2(30) path '//ns:Patient/ns:Address/ns:City',\r\n" + 
        		"    patient_state varchar2(30) path '//ns:Patient/ns:Address/ns:State',\r\n" + 
        		"    patient_zip varchar2(30) path '//ns:Patient/ns:Address/ns:ZipCode',\r\n" + 
        		"    patient_dob varchar2(30) path '//ns:Patient/ns:DateOfBirth/ns:Date',\r\n" + 
        		"    patient_ssn varchar2(11) path '//ns:Patient/ns:Identification/ns:SocialSecurity',\r\n" + 
        		"    plan_id varchar2(30) path '//ns:Patient/ns:BenefitsCoordination/ns:CardholderID',\r\n" + 
        		"    rx_Drug_Prescribed varchar2(30) path '//ns:MedicationPrescribed/ns:DrugDescription'\r\n" + 
        		"    ) x\r\n";
		} else {
			sql = "select t.outbound_ncpdp_msg_id inbound_ncpdp_msg_id,\r\n" +
	                "p.visn visn,\r\n" +
	                "p.va_station_id va_station_id,\r\n" +
	                "x.npi1 prescriber_npi,\r\n" +
	                "x.prescriber_DEA,  \r\n" + 
	                "x.patient_dob patient_dob,\r\n" +
	                "x.patient_ssn patient_ssn,\r\n" +
	        		"x.pharmacy_name pharmacy_name,\r\n" + 					
	        		"x.pharmacy_addr_1||' '||x.pharmacy_addr_2||' '||x.pharmacy_city||nvl2(x.pharmacy_city,nvl2(x.pharmacy_state,', ',null),null)||x.pharmacy_state||' '||x.pharmacy_zip pharmacy_addr_1,\r\n" + 
	        		"x.patient_Last_Name||nvl2(x.patient_Last_Name,nvl2(x.patient_First_Name,', ',null),null)||x.patient_First_Name||' '||x.patient_Mid_Name patient_Name,\r\n" + 
	        		"x.prescriber_Last_Name||nvl2(x.prescriber_Last_Name,nvl2(x.prescriber_First_Name,', ',null),null)||x.prescriber_First_Name||' '||x.prescriber_Mid_Name prescriber_Name,\r\n" + 
	        		"x.rx_Drug_Prescribed rx_Drug_Prescribed,\r\n" + 
	        		"t.message_type message_type,\r\n" + 
	        		"t.rel_to_message_id rel_to_message_id,\r\n" + 
	        		"t.message_id rx_messageId,\r\n" + 
	        		"t.received_date received_date,\r\n" + 
	        		"'N/A' patient_chk_status,\r\n" + 
	        		"'N/A' provider_chk_status,\r\n" + 
	        		"'N/A' drug_chk_status,\r\n" + 
	        		"(select code_description from erx_status where code = t.message_status) message_status\r\n" + 
	        		"from outbound_ncpdp_msg t, pharmacy p, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), '/ns:Message'\r\n" + 
	        		"    passing t.message\r\n" + 
	        		"    columns \r\n" + 
	        		"    message_id varchar2(35) path '//ns:Header/ns:MessageID',\r\n" + 
	        		"    rel_to_message_id varchar2(35) path '//ns:Header/ns:RelatesToMessageID',\r\n" + 
	        		"    message_type varchar2(35) path 'name(/ns:Body/*[1])',\r\n" + 
	        		"    pharmacy_name varchar2(30) path '//ns:Pharmacy/ns:StoreName',\r\n" + 
	        		"    pharmacy_addr_1 varchar2(30) path '//ns:Pharmacy/ns:Address/ns:AddressLine1',\r\n" + 
	        		"    pharmacy_addr_2 varchar2(30) path '//ns:Pharmacy/ns:Address/ns:AddressLine2',\r\n" + 
	        		"    pharmacy_city varchar2(30) path '//ns:Pharmacy/ns:Address/ns:City',\r\n" + 
	        		"    pharmacy_state varchar2(30) path '//ns:Pharmacy/ns:Address/ns:State',\r\n" + 
	        		"    pharmacy_zip varchar2(30) path '//ns:Pharmacy/ns:Address/ns:ZipCode',\r\n" + 
	        		"	 npi1 varchar2(35) path '//ns:Prescriber/ns:Identification/ns:NPI',\r\n" + 
	        		"    npi2 varchar2(35) path '//ns:Header/ns:From',\r\n" + 
	        		"    prescriber_First_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:FirstName',\r\n" + 
	        		"    prescriber_Mid_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:MiddleName',\r\n" + 
	        		"    prescriber_Last_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:LastName',\r\n" + 
	        		"    prescriber_DEA varchar2(35) path '//ns:Prescriber/ns:Identification/ns:DEANumber',  \r\n" + 
	        		"    patient_First_Name varchar2(35) path '//ns:Patient/ns:Name/ns:FirstName',\r\n" + 
	        		"    patient_Mid_Name varchar2(35) path '//ns:Patient/ns:Name/ns:MiddleName',\r\n" + 
	        		"    patient_Last_Name varchar2(35) path '//ns:Patient/ns:Name/ns:LastName',\r\n" + 
	        		"    patient_addr_1 varchar2(30) path '//ns:Patient/ns:Address/ns:AddressLine1',\r\n" + 
	        		"    patient_addr_2 varchar2(30) path '//ns:Patient/ns:Address/ns:AddressLine2',\r\n" + 
	        		"    patient_city varchar2(30) path '//ns:Patient/ns:Address/ns:City',\r\n" + 
	        		"    patient_state varchar2(30) path '//ns:Patient/ns:Address/ns:State',\r\n" + 
	        		"    patient_zip varchar2(30) path '//ns:Patient/ns:Address/ns:ZipCode',\r\n" + 
	        		"    patient_dob varchar2(30) path '//ns:Patient/ns:DateOfBirth/ns:Date',\r\n" + 
	        		"    patient_ssn varchar2(11) path '//ns:Patient/ns:Identification/ns:SocialSecurity',\r\n" + 
	        		"    plan_id varchar2(30) path '//ns:Patient/ns:BenefitsCoordination/ns:CardholderID',\r\n" + 
	        		"    rx_Drug_Prescribed varchar2(30) path '//ns:MedicationPrescribed/ns:DrugDescription'\r\n" + 
	        		"    ) x\r\n";
		}
        		
        		sql = sql + "    where t.pharmacy_id = p.pharmacy_id and t.message_id like ? \r\n"  +
        		"    and nvl(t.rel_to_message_id,' ') like ? \r\n" +
        		"    and t.RECEIVED_DATE between to_date('" + fromDate + "','YYYY-MM-DD') and to_date('" + toDate + "','YYYY-MM-DD') + 1\r\n";
        			
        		
        		if (messageType.length() != 0){
        			sql = sql + "    and t.message_type = '" + messageType + "' \r\n";
        		}
        		if (messageStatus.length() != 0){
        			sql = sql +	"    and t.message_status = '" + messageStatus + "' \r\n";
        		} else { //excluding the 3006 status messages because they are invalid XML
        			sql = sql +	"    and t.message_status not in ('3006') \r\n"; 
        		}
        		if (visn.length() != 0 && !"All".equals(visn)) {
        			sql = sql + "    and t.pharmacy_id in (select pharmacy_id from pharmacy where visn = '" + visn + "')\r\n";
        		}
        		
        		// restrict mbm search
        		if(mbmAllowed == true){
        			   sql = sql + "    and t.pharmacy_id in (select pharmacy_id from pharmacy where va_station_id like ? ) \r\n";   
        		 }
        		else{
        			    sql = sql + "    and t.pharmacy_id in (select pharmacy_id from pharmacy where va_station_id not in ('741DUB','741CHE') and va_station_id like ? ) \r\n";
        			
        		}     
        		   
        			   			
        		if (patientSsn.length() != 0) {
        			sql = sql + " and x.patient_ssn = '" + patientSsn + "'\r\n";
        		}
        			sql = sql +	
        				"    and nvl(upper(x.patient_last_name),' ') like ?\r\n" + 
        				"    and nvl(upper(x.patient_first_name),' ') like ?\r\n"; 
        			
        			sql = sql +	
            				"    and nvl(upper(x.prescriber_last_name),' ') like ?\r\n" + 
            				"    and nvl(upper(x.prescriber_first_name),' ') like ?\r\n" +
            				"    and nvl(upper(x.prescriber_DEA),' ') like ?\r\n"; 
 
        		if (patientDob.length() != 0) {
        			sql = sql +   " and to_date(decode(length(x.patient_dob),11,substr(x.patient_dob, 2,10), x.patient_dob),'YYYY-MM-DD') = to_date('" + patientDob + "','YYYY-MM-DD') \r\n"; 
        		}
        			sql = sql +
        				"    and nvl(x.npi1, ' ') like ? \r\n" + 
        				"    and nvl(upper(x.rx_Drug_Prescribed),' ') like ? \r\n";
        			
        			if (inboundOutbound.equalsIgnoreCase("Inbound")){
        			sql = sql +	"    and t.inbound_ncpdp_msg_id like ? \r\n";
        			} else {
            		sql = sql +	"    and t.outbound_ncpdp_msg_id like ? \r\n";
        			}
        			sql = sql +	"	 order by t.RECEIVED_DATE DESC";
        
        			LOG.debug("NCPDP message details Sql is:" + sql);
        			//System.out.println("sql is:" + sql);
        			
        List<NcpdpMessageListModel> ncpdpMsgList = new ArrayList<NcpdpMessageListModel>();
        
		// Strip any leading V as seen in VistA HQ when search Outbound (Sent) 
		if (inboundNcpdpMsgId != null && inboundNcpdpMsgId.length() > 0) {
			if ((inboundNcpdpMsgId.indexOf("v") == 0 || inboundNcpdpMsgId.indexOf("V") == 0) && inboundOutbound.equalsIgnoreCase("Outbound")) {
				inboundNcpdpMsgId = inboundNcpdpMsgId.substring(1);
			}
		}
		
		try {
			//LOG.info("Retrieving NCPDP message details.");
			//System.out.println("Retrieving NCPDP message details.");
			 ncpdpMsgList = jdbcTemplate.query(sql,new NcpdpMsgListRowMapper(),messageId, relatesToId, vaStationId, patientLastName, patientFirstName, prescriberLastName, prescriberFirstName, prescriberDEA, prescriberNpi, prescribedDrug, inboundNcpdpMsgId);
		} catch (DataAccessException e) {
			//ncpdpMsg.setDataError(e.getMessage());
			//System.out.println("data error is:" + e.getMessage());
			LOG.info("Exception retrieving NCPDP message details." + e.getMessage());
		}
		return ncpdpMsgList;

	}

	@Override
	public List<NcpdpMessageListModel> searchRelatedMessages(String messageId) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		StringBuffer sqlBuffer = new StringBuffer();
		
				sqlBuffer.append("select inbound_ncpdp_msg_id inbound_ncpdp_msg_id,\r\n" ).append( 
			    		"rx_messageid rx_messageId,\r\n" ).append( 
					    "rel_to_message_id rel_to_message_id,\r\n" ).append( 
					    "message_type message_type,\r\n" ).append(  
					    "received_date received_date,\r\n" ).append(     		
			            "visn visn,\r\n" ).append(
			            "va_station_id va_station_id,\r\n" ).append( 
			            "pharmacy_name pharmacy_name,\r\n" ).append(  
						"pharmacy_addr_1 pharmacy_addr_1,\r\n" ).append(  
						"patient_name patient_Name,\r\n" ).append(  
						"prescriber_name prescriber_Name,\r\n" ).append( 
						"prescriber_npi prescriber_npi,\r\n" ).append(
						"prescriber_dea prescriber_DEA,\r\n" ).append(
						"rx_drug_prescribed rx_Drug_Prescribed,\r\n" ).append(  
						"patient_chk_status patient_chk_status,\r\n" ).append(  
						"provider_chk_status provider_chk_status,\r\n" ).append(  
						"drug_chk_status drug_chk_status,\r\n" ).append(  
						"message_status message_status,\r\n" ).append( 	
			            "patient_dob patient_dob,\r\n" ).append( 
			            "patient_ssn patient_ssn\r\n" ).append( 
			    		" from \r\n" ).append(  
				"		(select t.inbound_ncpdp_msg_id inbound_ncpdp_msg_id,\r\n" ).append(
				"            t.rel_to_message_id rel_to_message_id, \r\n" ).append(
				"            t.message_id rx_messageId, \r\n" ).append(
				"            t.message_type message_type, \r\n" ).append(
				"            p.visn visn,\r\n" ).append(
				"            p.va_station_id va_station_id,\r\n" ).append(
				"            x.npi1 prescriber_npi,\r\n" ).append(
				"            x.patient_dob patient_dob,\r\n" ).append(
				"            x.patient_ssn patient_ssn,\r\n" ).append(
				"   		x.pharmacy_name pharmacy_name, \r\n" ).append(
				"    		x.pharmacy_addr_1||' '||x.pharmacy_addr_2||' '||x.pharmacy_city||nvl2(x.pharmacy_city,nvl2(x.pharmacy_state,', ',null),null)||x.pharmacy_state||' '||x.pharmacy_zip pharmacy_addr_1, \r\n" ).append(
				"    		x.patient_Last_Name||nvl2(x.patient_Last_Name,nvl2(x.patient_First_Name,', ',null),null)||x.patient_First_Name||' '||x.patient_Mid_Name patient_Name, \r\n" ).append(
				"    		x.prescriber_Last_Name||nvl2(x.prescriber_Last_Name,nvl2(x.prescriber_First_Name,', ',null),null)||x.prescriber_First_Name||' '||x.prescriber_Mid_Name prescriber_Name, \r\n" ).append(
				"		    x.prescriber_DEA prescriber_dea, \r\n" ).append(
				"    		x.rx_Drug_Prescribed rx_Drug_Prescribed,\r\n" ).append(
				"    		t.received_date received_date, \r\n" ).append(
				"    		(select code_description from erx_status where code = t.patient_chk_status) patient_chk_status, \r\n" ).append(
				"    		(select code_description from erx_status where code = t.provider_chk_status) provider_chk_status, \r\n" ).append(
				"    		(select code_description from erx_status where code = t.drug_chk_status) drug_chk_status, \r\n" ).append(
				"    		(select code_description from erx_status where code = t.message_status) message_status \r\n" ).append(
				"    		from inbound_ncpdp_msg t, pharmacy p, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), 'ns:Message' \r\n" ).append(
				"    		    passing t.message \r\n" ).append(
				"    		    columns  \r\n" ).append(
				"    		    pharmacy_name varchar2(30) path '//ns:Pharmacy/ns:StoreName', \r\n" ).append(
				"    		    pharmacy_addr_1 varchar2(30) path '//ns:Pharmacy/ns:Address/ns:AddressLine1', \r\n" ).append(
				"    		    pharmacy_addr_2 varchar2(30) path '//ns:Pharmacy/ns:Address/ns:AddressLine2', \r\n" ).append(
				"    		    pharmacy_city varchar2(30) path '//ns:Pharmacy/ns:Address/ns:City', \r\n" ).append(
				"    		    pharmacy_state varchar2(30) path '//ns:Pharmacy/ns:Address/ns:State', \r\n" ).append(
				"    		    pharmacy_zip varchar2(30) path '//ns:Pharmacy/ns:Address/ns:ZipCode', \r\n" ).append(
				"    			npi1 varchar2(35) path '//ns:Prescriber/ns:Identification/ns:NPI', \r\n" ).append(
				"    		    npi2 varchar2(35) path '//ns:Header/ns:From', \r\n" ).append(
				"    		    prescriber_First_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:FirstName', \r\n" ).append( 
				"    		    prescriber_Mid_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:MiddleName', \r\n" ).append(
				"    		    prescriber_Last_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:LastName', \r\n" ).append(
				"    		    patient_First_Name varchar2(35) path '//ns:Patient/ns:Name/ns:FirstName', \r\n" ).append(
				"    		    patient_Mid_Name varchar2(35) path '//ns:Patient/ns:Name/ns:MiddleName', \r\n" ).append(
				"    		    patient_Last_Name varchar2(35) path '//ns:Patient/ns:Name/ns:LastName', \r\n" ).append(
				"               prescriber_DEA varchar2(35) path '//ns:Prescriber/ns:Identification/ns:DEANumber',  \r\n" ).append( 
				"    		    patient_addr_1 varchar2(30) path '//ns:Patient/ns:Address/ns:AddressLine1', \r\n" ).append(
				"    		    patient_addr_2 varchar2(30) path '//ns:Patient/ns:Address/ns:AddressLine2', \r\n" ).append(
				"    		    patient_city varchar2(30) path '//ns:Patient/ns:Address/ns:City', \r\n" ).append(
				"    		    patient_state varchar2(30) path '//ns:Patient/ns:Address/ns:State', \r\n" ).append(
				"    		    patient_zip varchar2(30) path '//ns:Patient/ns:Address/ns:ZipCode', \r\n" ).append(
				"    		    patient_dob varchar2(30) path '//ns:Patient/ns:DateOfBirth/ns:Date', \r\n" ).append(
				"    		    patient_ssn varchar2(11) path '//ns:Patient/ns:Identification/ns:SocialSecurity', \r\n" ).append( 
				"    		    plan_id varchar2(30) path '//ns:Patient/ns:BenefitsCoordination/ns:CardholderID', \r\n" ).append(
				"    		    rx_Drug_Prescribed varchar2(30) path '//ns:MedicationPrescribed/ns:DrugDescription' \r\n" ).append(
				"    		    ) x \r\n" ).append(
				"where t.pharmacy_id = p.pharmacy_id \r\n" ).append(
				"and received_date between sysdate - 365 and sysdate \r\n" ).append( 
				"and t.message_status not in ('3006') \r\n" ).append( 
				"UNION ALL \r\n" ).append(
				"select t.outbound_ncpdp_msg_id inbound_ncpdp_msg_id, \r\n" ).append(
				"                t.rel_to_message_id rel_to_message_id, \r\n" ).append(
				"                t.message_id rx_messageId, \r\n" ).append(
				"        		    t.message_type message_type, \r\n" ).append(
				"                p.visn visn, \r\n" ).append(
				"                p.va_station_id va_station_id, \r\n" ).append(
				"                x.npi1 prescriber_npi, \r\n" ).append(
				"                x.patient_dob patient_dob, \r\n" ).append(
				"                x.patient_ssn patient_ssn, \r\n" ).append(
				"        		x.pharmacy_name pharmacy_name, \r\n" ).append(		
				"        		x.pharmacy_addr_1||' '||x.pharmacy_addr_2||' '||x.pharmacy_city||nvl2(x.pharmacy_city,nvl2(x.pharmacy_state,', ',null),null)||x.pharmacy_state||' '||x.pharmacy_zip pharmacy_addr_1, \r\n" ).append(
				"        		x.patient_Last_Name||nvl2(x.patient_Last_Name,nvl2(x.patient_First_Name,', ',null),null)||x.patient_First_Name||' '||x.patient_Mid_Name patient_Name, \r\n" ).append(
				"        		x.prescriber_Last_Name||nvl2(x.prescriber_Last_Name,nvl2(x.prescriber_First_Name,', ',null),null)||x.prescriber_First_Name||' '||x.prescriber_Mid_Name prescriber_Name, \r\n" ).append(
				"		        x.prescriber_DEA prescriber_dea, \r\n" ).append(
				"        		x.rx_Drug_Prescribed rx_Drug_Prescribed, \r\n" ).append(
				"        		t.received_date received_date, \r\n" ).append(
				"        		'N/A' patient_chk_status, \r\n" ).append(
				"        		'N/A' provider_chk_status, \r\n" ).append(
				"        		'N/A' drug_chk_status, \r\n" ).append(
				"        		(select code_description from erx_status where code = t.message_status) message_status \r\n" ).append(
				"        		from outbound_ncpdp_msg t, pharmacy p, xmltable(xmlnamespaces('http://www.ncpdp.org/schema/SCRIPT' as \"ns\"), 'ns:Message' \r\n" ).append(
				"        		    passing t.message \r\n" ).append(
				"        		    columns  \r\n" ).append(
				"        		    pharmacy_name varchar2(30) path '//ns:Pharmacy/ns:StoreName', \r\n" ).append(
				"        		    pharmacy_addr_1 varchar2(30) path '//ns:Pharmacy/ns:Address/ns:AddressLine1', \r\n" ).append(
				"        		    pharmacy_addr_2 varchar2(30) path '//ns:Pharmacy/ns:Address/ns:AddressLine2', \r\n" ).append(
				"        		    pharmacy_city varchar2(30) path '//ns:Pharmacy/ns:Address/ns:City', \r\n" ).append(
				"        		    pharmacy_state varchar2(30) path '//ns:Pharmacy/ns:Address/ns:State', \r\n" ).append(
				"        		    pharmacy_zip varchar2(30) path '//ns:Pharmacy/ns:Address/ns:ZipCode', \r\n" ).append(
				"        			npi1 varchar2(35) path '//ns:Prescriber/ns:Identification/ns:NPI', \r\n" ).append(
				"        		    npi2 varchar2(35) path '//ns:Header/ns:From', \r\n" ).append(
				"        		    prescriber_First_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:FirstName', \r\n" ).append(
				"        		    prescriber_Mid_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:MiddleName', \r\n" ).append(
				"        		    prescriber_Last_Name varchar2(35) path '//ns:Prescriber/ns:Name/ns:LastName', \r\n" ).append(
		        "                   prescriber_DEA varchar2(35) path '//ns:Prescriber/ns:Identification/ns:DEANumber',  \r\n" ).append( 
				"        		    patient_First_Name varchar2(35) path '//ns:Patient/ns:Name/ns:FirstName', \r\n" ).append(
				"        		    patient_Mid_Name varchar2(35) path '//ns:Patient/ns:Name/ns:MiddleName', \r\n" ).append(
				"        		    patient_Last_Name varchar2(35) path '//ns:Patient/ns:Name/ns:LastName', \r\n" ).append(
				"        		    patient_addr_1 varchar2(30) path '//ns:Patient/ns:Address/ns:AddressLine1', \r\n" ).append(
				"        		    patient_addr_2 varchar2(30) path '//ns:Patient/ns:Address/ns:AddressLine2', \r\n" ).append(
				"        		    patient_city varchar2(30) path '//ns:Patient/ns:Address/ns:City', \r\n" ).append(
				"        		    patient_state varchar2(30) path '//ns:Patient/ns:Address/ns:State', \r\n" ).append(
				"        		    patient_zip varchar2(30) path '//ns:Patient/ns:Address/ns:ZipCode', \r\n" ).append(
				"        		    patient_dob varchar2(30) path '//ns:Patient/ns:DateOfBirth/ns:Date', \r\n" ).append(
				"        		    patient_ssn varchar2(11) path '//ns:Patient/ns:Identification/ns:SocialSecurity', \r\n" ).append(
				"        		    plan_id varchar2(30) path '//ns:Patient/ns:BenefitsCoordination/ns:CardholderID', \r\n" ).append(
				"        		    rx_Drug_Prescribed varchar2(30) path '//ns:MedicationPrescribed/ns:DrugDescription' \r\n" ).append(
				"        		    ) x \r\n" ).append(
				"where t.pharmacy_id = p.pharmacy_id	\r\n" ).append(
				"and received_date between sysdate - 365 and sysdate \r\n" ).append(
				"and t.message_status not in ('3006') \r\n" ).append( 
				"  ) results \r\n" ).append(
				"where results.rx_messageid in ( \r\n" ).append(
				"select message_id from ( \r\n" ).append(
				"select \r\n" ).append(
				"message_id, \r\n" ).append(
				"rel_to_message_id \r\n" ).append(
				"from ( \r\n" ).append(
				"select \r\n" ).append(
				"t.message_id, \r\n" ).append(
				"t.rel_to_message_id \r\n" ).append(
				"from inbound_ncpdp_msg t where received_date between sysdate - 365 and sysdate and t.message_status not in ('3006') \r\n" ).append(
				"UNION ALL \r\n" ).append(
				"select \r\n" ).append(
				"t.message_id, \r\n" ).append(
				"t.rel_to_message_id \r\n" ).append(
				"from outbound_ncpdp_msg t where received_date between sysdate - 365 and sysdate and t.message_status not in ('3006') ) results \r\n" ).append(
				"CONNECT BY PRIOR results.rel_to_message_id = results.message_id \r\n" ).append(
				" START WITH \r\n" ).append(
				"    results.message_id in (select get_newrx_msg_id_func(?) from dual) \r\n" ).append(
				"    union all \r\n" ).append(
				"    select \r\n" ).append(
				"    message_id, \r\n" ).append(
				"    rel_to_message_id \r\n" ).append(
				"    from ( \r\n" ).append(
				"select \r\n" ).append(
				"t.message_id, \r\n" ).append(
				"t.rel_to_message_id \r\n" ).append(
				"from inbound_ncpdp_msg t where received_date between sysdate - 365 and sysdate and t.message_status not in ('3006') \r\n" ).append(
				"UNION ALL \r\n" ).append(
				"select \r\n" ).append(
				"t.message_id, \r\n" ).append(
				"t.rel_to_message_id \r\n" ).append(
				"from outbound_ncpdp_msg t where received_date between sysdate - 365 and sysdate and t.message_status not in ('3006') ) results \r\n" ).append(
				"CONNECT BY PRIOR results.message_id = results.rel_to_message_id \r\n" ).append(
				" START WITH \r\n" ).append(
				"    results.message_id in (select get_newrx_msg_id_func(?) from dual) \r\n" ).append(
				" ) \r\n" ).append(
				") \r\n" ).append(
				"    order by received_date desc");
				
		
        List<NcpdpMessageListModel> ncpdpMsgList = new ArrayList<NcpdpMessageListModel>();
        
		try {

			ncpdpMsgList = jdbcTemplate.query(sqlBuffer.toString(),new NcpdpMsgListRowMapper(),messageId,messageId);

		} catch (DataAccessException e) {
		
			
			LOG.info("Exception retrieving related message details." + e.getMessage());
		}
		return ncpdpMsgList;
		
	}

}
