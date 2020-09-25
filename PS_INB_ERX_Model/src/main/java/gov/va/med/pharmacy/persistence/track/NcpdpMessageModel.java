package gov.va.med.pharmacy.persistence.track;

import org.springframework.stereotype.Component;

@Component
public class NcpdpMessageModel {
	
	private Long inboundNcpdpMsgId;
	private String rxMessageId;
	private String relToMessageid;
	private String messageType;
	private String receivedDate;
	private String pharmacyName;
	private String pharmacyAddr1;
	private String pharmacyAddr2;
	private String pharmacyPhone;
	private String pharmacyNcpdpid; 
	private String prescriberFirstName;
	private String prescriberMidName;
	private String prescriberLastName;
	private String prescriberAddr1;
	private String prescriberAddr2;
	private String prescriberNPI;
	private String prescriberDEA;
	private String prescriberStateLic;
	private String prescriberPhone;
	private String prescriberFax;
	private String prescriberAgent;
	private String patientFirstName;
	private String patientMidName;
	private String patientLastName;
	private String patientAddr1;
	private String patientAddr2;
	private String patientDob;
	private String patientSocSn;
	private String patientGender;
	private String patientPrimaryPhone;
	private String patientHomePhone;
	private String patientWeight;
	private String patientHeight;
	private String planId;
	private String rxDrugPrescribed;
	private String rxQuantity;
	private String rxDaysSupply;
	private String rxDateWritten;
	private String rxIssueDate;
	private String rxPotencyUnitCode;
	private String rxDrugForm;
	private String rxDrugStrength;
	private String rxRefills;
	private String rxSig;
	private String rxDispenseNotes;
	private String rxComments;
	private String rxDrugDispensed;
	private String rxQuantityDispensed;  
	private String rxDaysSupplyDispensed; 
	private String rxDateWrittenDispensed; 
	private String rxPotencyUnitCodeDispensed; 
	private String rxDrugFormDispensed; 
	private String rxDrugStrengthDispensed; 
	private String rxDrugStrengthCodeDisp; 
	private String rxRefillsDispensed; 
	private String rxSigDispensed; 
	private String rxDispenseNotesDispensed;  
	private String rxCommentsDispensed;
	private String rxGrp;
	private String rxBinNum;
	private String rxPcn;
	private String errorMessage;
	private String patient_chk_status;
	private String provider_chk_status;
	private String drug_chk_status;
	private String message_status;
	private String reqRefno;
	private String resType;
	private String resAprvReasonCd;
	private String resAprvRefno;
	private String resAprvNote;
	private String resAprvWthChngReasonCd; 
	private String resAprvWthChngRefno;
	private String resAprvWthChngNote;
	private String resDenialReasonCd; 
	private String resDenialRefno;
	private String resDenialReason; 
	private String resDenialNrxReasonCd; 
	private String resDenialNrxRefno;
	private String resDenialNrxReason; 
	private String esvDescriptionCode;
	private String esvCode;
	private String esvDescription;
	private String clinicId;
	private String rxReferenceNumber;
	private String prescriberOrderNumber;
	private String rxDrugPrescribedNdc;
	private String rxDrugPrescribedQualifier;
	private String rxDrugDispensedNdc;
	private String rxDrugDispensedQualifier;
	private String changeofPrescrStatFlg;
	private String rxFillStatus;
	private String rxFillRefNum;
	private String rxFillNote;
	private String rxFillReasonCd;
	private String changeRequestType;
	private String requestReferenceNumber;
	private String prohibitRenewalRequest;
	// Med Requested 1
	private String rxDrugRequested;
	private String rxDrugRequestedNdc;
	private String rxQuantityRequested;
	private String rxDaysSupplyRequested;
	private String rxDateWrittenRequested;
	private String rxPotencyUnitCodeRequested;
	private String rxDrugFormRequested; 
	private String rxDrugStrengthRequested;
	private String rxDrugStrengthCodeReq;
	private String rxRefillsRequested; 
	private String rxSigRequested; 
	private String rxDispenseNotesRequested;
	private String rxCommentsRequested;
	// Med Requested 2
	private String rxDrugRequested2;
	private String rxDrugRequestedNdc2;
	private String rxQuantityRequested2;
	private String rxDaysSupplyRequested2;
	private String rxDateWrittenRequested2;
	private String rxPotencyUnitCodeRequested2;
	private String rxDrugFormRequested2; 
	private String rxDrugStrengthRequested2;
	private String rxDrugStrengthCodeReq2;
	private String rxRefillsRequested2; 
	private String rxSigRequested2; 
	private String rxDispenseNotesRequested2;
	private String rxCommentsRequested2;
	// Med Requested 3
	private String rxDrugRequested3;
	private String rxDrugRequestedNdc3;
	private String rxQuantityRequested3;
	private String rxDaysSupplyRequested3;
	private String rxDateWrittenRequested3;
	private String rxPotencyUnitCodeRequested3;
	private String rxDrugFormRequested3; 
	private String rxDrugStrengthRequested3;
	private String rxDrugStrengthCodeReq3;
	private String rxRefillsRequested3; 
	private String rxSigRequested3; 
	private String rxDispenseNotesRequested3;
	private String rxCommentsRequested3;
	// Med Requested 4
	private String rxDrugRequested4;
	private String rxDrugRequestedNdc4;
	private String rxQuantityRequested4;
	private String rxDaysSupplyRequested4;
	private String rxDateWrittenRequested4;
	private String rxPotencyUnitCodeRequested4;
	private String rxDrugFormRequested4; 
	private String rxDrugStrengthRequested4;
	private String rxDrugStrengthCodeReq4;
	private String rxRefillsRequested4; 
	private String rxSigRequested4; 
	private String rxDispenseNotesRequested4;
	private String rxCommentsRequested4;
	// Med Requested 5
	private String rxDrugRequested5;
	private String rxDrugRequestedNdc5;
	private String rxQuantityRequested5;
	private String rxDaysSupplyRequested5;
	private String rxDateWrittenRequested5;
	private String rxPotencyUnitCodeRequested5;
	private String rxDrugFormRequested5; 
	private String rxDrugStrengthRequested5;
	private String rxDrugStrengthCodeReq5;
	private String rxRefillsRequested5; 
	private String rxSigRequested5; 
	private String rxDispenseNotesRequested5;
	private String rxCommentsRequested5;
	// Med Requested 6
	private String rxDrugRequested6;
	private String rxDrugRequestedNdc6;
	private String rxQuantityRequested6;
	private String rxDaysSupplyRequested6;
	private String rxDateWrittenRequested6;
	private String rxPotencyUnitCodeRequested6;
	private String rxDrugFormRequested6; 
	private String rxDrugStrengthRequested6;
	private String rxDrugStrengthCodeReq6;
	private String rxRefillsRequested6; 
	private String rxSigRequested6; 
	private String rxDispenseNotesRequested6;
	private String rxCommentsRequested6;
	// Med Requested 7
	private String rxDrugRequested7;
	private String rxDrugRequestedNdc7;
	private String rxQuantityRequested7;
	private String rxDaysSupplyRequested7;
	private String rxDateWrittenRequested7;
	private String rxPotencyUnitCodeRequested7;
	private String rxDrugFormRequested7; 
	private String rxDrugStrengthRequested7;
	private String rxDrugStrengthCodeReq7;
	private String rxRefillsRequested7; 
	private String rxSigRequested7; 
	private String rxDispenseNotesRequested7;
	private String rxCommentsRequested7;
	// Med Requested 8
	private String rxDrugRequested8;
	private String rxDrugRequestedNdc8;
	private String rxQuantityRequested8;
	private String rxDaysSupplyRequested8;
	private String rxDateWrittenRequested8;
	private String rxPotencyUnitCodeRequested8;
	private String rxDrugFormRequested8; 
	private String rxDrugStrengthRequested8;
	private String rxDrugStrengthCodeReq8;
	private String rxRefillsRequested8; 
	private String rxSigRequested8; 
	private String rxDispenseNotesRequested8;
	private String rxCommentsRequested8;
	// Med Requested 9
	private String rxDrugRequested9;
	private String rxDrugRequestedNdc9;
	private String rxQuantityRequested9;
	private String rxDaysSupplyRequested9;
	private String rxDateWrittenRequested9;
	private String rxPotencyUnitCodeRequested9;
	private String rxDrugFormRequested9; 
	private String rxDrugStrengthRequested9;
	private String rxDrugStrengthCodeReq9;
	private String rxRefillsRequested9; 
	private String rxSigRequested9; 
	private String rxDispenseNotesRequested9;
	private String rxCommentsRequested9;
	
	private String rxPatientCheck;
	private String rxProviderCheck;
	private String rxDrugCheck;
	
	//rxChangeResponse
	private String validatedPrescriberNPI;
	private String validatedPrescriberDEA;
	private String validatedPrescriberStateLic;
	private String rxChangeResponseValidatedDate;
	private String rxChangValidatedReasonCode;
	private String rxChangeDeniedReasonCode;
	private String rxChangeVLDReasonDescription;
	private String rxChangeDNDReasonDescription;
	private String rxChangeResponseDenialReason;
	private String rxChangeResponseNote;
	private String rxChangeDrugCoverageStatusCode;
	private String rxChangeResponsePriorAuthorization;
	private String rxChangeResponsePriorAuthorizationStatus;
	
	
	public Long getInboundNcpdpMsgId() {
		return inboundNcpdpMsgId;
	}
	public void setInboundNcpdpMsgId(Long inboundNcpdpMsgId) {
		this.inboundNcpdpMsgId = inboundNcpdpMsgId;
	}
	public String getRxMessageId() {
		return rxMessageId;
	}
	public void setRxMessageId(String rxMessageId) {
		this.rxMessageId = rxMessageId;
	}
	public String getRelToMessageid() {
		return relToMessageid;
	}
	public void setRelToMessageid(String relToMessageid) {
		this.relToMessageid = relToMessageid;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getPharmacyAddr1() {
		return pharmacyAddr1;
	}
	public void setPharmacyAddr1(String pharmacyAddr1) {
		this.pharmacyAddr1 = pharmacyAddr1;
	}
	public String getPharmacyAddr2() {
		return pharmacyAddr2;
	}
	public void setPharmacyAddr2(String pharmacyAddr2) {
		this.pharmacyAddr2 = pharmacyAddr2;
	}
	public String getPharmacyPhone() {
		return pharmacyPhone;
	}
	public void setPharmacyPhone(String pharmacyPhone) {
		this.pharmacyPhone = pharmacyPhone;
	}
	public String getPrescriberFax() {
		return prescriberFax;
	}
	public void setPrescriberFax(String prescriberFax) {
		this.prescriberFax = prescriberFax;
	}
	public String getPharmacyNcpdpid() {
		return pharmacyNcpdpid;
	}
	public void setPharmacyNcpdpid(String pharmacyNcpdpid) {
		this.pharmacyNcpdpid = pharmacyNcpdpid;
	}
	public String getPrescriberFirstName() {
		return prescriberFirstName;
	}
	public void setPrescriberFirstName(String prescriberFirstName) {
		this.prescriberFirstName = prescriberFirstName;
	}
	public String getPrescriberMidName() {
		return prescriberMidName;
	}
	public void setPrescriberMidName(String prescriberMidName) {
		this.prescriberMidName = prescriberMidName;
	}
	public String getPrescriberLastName() {
		return prescriberLastName;
	}
	public void setPrescriberLastName(String prescriberLastName) {
		this.prescriberLastName = prescriberLastName;
	}
	public String getPrescriberAddr1() {
		return prescriberAddr1;
	}
	public void setPrescriberAddr1(String prescriberAddr1) {
		this.prescriberAddr1 = prescriberAddr1;
	}
	public String getPrescriberAddr2() {
		return prescriberAddr2;
	}
	public void setPrescriberAddr2(String prescriberAddr2) {
		this.prescriberAddr2 = prescriberAddr2;
	}
	public String getPrescriberNPI() {
		return prescriberNPI;
	}
	public void setPrescriberNPI(String prescriberNPI) {
		this.prescriberNPI = prescriberNPI;
	}
	public String getPrescriberDEA() {
		return prescriberDEA;
	}
	public void setPrescriberDEA(String prescriberDEA) {
		this.prescriberDEA = prescriberDEA;
	}
	public String getPrescriberStateLic() {
		return prescriberStateLic;
	}
	public void setPrescriberStateLic(String prescriberStateLic) {
		this.prescriberStateLic = prescriberStateLic;
	}
	public String getPrescriberPhone() {
		return prescriberPhone;
	}
	public void setPrescriberPhone(String prescriberPhone) {
		this.prescriberPhone = prescriberPhone;
	}
	public String getPrescriberAgent() {
		return prescriberAgent;
	}
	public void setPrescriberAgent(String prescriberAgent) {
		this.prescriberAgent = prescriberAgent;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientMidName() {
		return patientMidName;
	}
	public void setPatientMidName(String patientMidName) {
		this.patientMidName = patientMidName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getPatientAddr1() {
		return patientAddr1;
	}
	public void setPatientAddr1(String patientAddr1) {
		this.patientAddr1 = patientAddr1;
	}
	public String getPatientAddr2() {
		return patientAddr2;
	}
	public void setPatientAddr2(String patientAddr2) {
		this.patientAddr2 = patientAddr2;
	}
	public String getPatientDob() {
		return patientDob;
	}
	public void setPatientDob(String patientDob) {
		this.patientDob = patientDob;
	}
	public String getPatientSocSn() {
		return patientSocSn;
	}
	public void setPatientSocSn(String patientSocSn) {
		this.patientSocSn = patientSocSn;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getRxDrugPrescribed() {
		return rxDrugPrescribed;
	}
	public void setRxDrugPrescribed(String rxDrugPrescribed) {
		this.rxDrugPrescribed = rxDrugPrescribed;
	}
	public String getRxQuantity() {
		return rxQuantity;
	}
	public void setRxQuantity(String rxQuantity) {
		this.rxQuantity = rxQuantity;
	}
	public String getRxDaysSupply() {
		return rxDaysSupply;
	}
	public void setRxDaysSupply(String rxDaysSupply) {
		this.rxDaysSupply = rxDaysSupply;
	}
	public String getRxDateWritten() {
		return rxDateWritten;
	}
	public void setRxDateWritten(String rxDateWritten) {
		this.rxDateWritten = rxDateWritten;
	}
	public String getRxIssueDate() {
		return rxIssueDate;
	}
	public void setRxIssueDate(String rxIssueDate) {
		this.rxIssueDate = rxIssueDate;
	}
	public String getRxPotencyUnitCode() {
		return rxPotencyUnitCode;
	}
	public void setRxPotencyUnitCode(String rxPotencyUnitCode) {
		this.rxPotencyUnitCode = rxPotencyUnitCode;
	}
	public String getRxDrugForm() {
		return rxDrugForm;
	}
	public void setRxDrugForm(String rxDrugForm) {
		this.rxDrugForm = rxDrugForm;
	}
	public String getRxDrugStrength() {
		return rxDrugStrength;
	}
	public void setRxDrugStrength(String rxDrugStrength) {
		this.rxDrugStrength = rxDrugStrength;
	}
	public String getRxRefills() {
		return rxRefills;
	}
	public void setRxRefills(String rxRefills) {
		this.rxRefills = rxRefills;
	}
	public String getRxSig() {
		return rxSig;
	}
	public void setRxSig(String rxSig) {
		this.rxSig = rxSig;
	}
	public String getRxDispenseNotes() {
		return rxDispenseNotes;
	}
	public void setRxDispenseNotes(String rxDispenseNotes) {
		this.rxDispenseNotes = rxDispenseNotes;
	}
	public String getRxComments() {
		return rxComments;
	}
	public void setRxComments(String rxComments) {
		this.rxComments = rxComments;
	}
	public String getRxDrugDispensed() {
		return rxDrugDispensed;
	}
	public void setRxDrugDispensed(String rxDrugDispensed) {
		this.rxDrugDispensed = rxDrugDispensed;
	}
	public String getRxQuantityDispensed() {
		return rxQuantityDispensed;
	}
	public void setRxQuantityDispensed(String rxQuantityDispensed) {
		this.rxQuantityDispensed = rxQuantityDispensed;
	}
	public String getRxDaysSupplyDispensed() {
		return rxDaysSupplyDispensed;
	}
	public void setRxDaysSupplyDispensed(String rxDaysSupplyDispensed) {
		this.rxDaysSupplyDispensed = rxDaysSupplyDispensed;
	}
	public String getRxDateWrittenDispensed() {
		return rxDateWrittenDispensed;
	}
	public void setRxDateWrittenDispensed(String rxDateWrittenDispensed) {
		this.rxDateWrittenDispensed = rxDateWrittenDispensed;
	}
	public String getRxPotencyUnitCodeDispensed() {
		return rxPotencyUnitCodeDispensed;
	}
	public void setRxPotencyUnitCodeDispensed(String rxPotencyUnitCodeDispensed) {
		this.rxPotencyUnitCodeDispensed = rxPotencyUnitCodeDispensed;
	}
	public String getRxDrugFormDispensed() {
		return rxDrugFormDispensed;
	}
	public void setRxDrugFormDispensed(String rxDrugFormDispensed) {
		this.rxDrugFormDispensed = rxDrugFormDispensed;
	}
	public String getRxDrugStrengthDispensed() {
		return rxDrugStrengthDispensed;
	}
	public void setRxDrugStrengthDispensed(String rxDrugStrengthDispensed) {
		this.rxDrugStrengthDispensed = rxDrugStrengthDispensed;
	}
	public String getRxDrugStrengthCodeDisp() {
		return rxDrugStrengthCodeDisp;
	}
	public void setRxDrugStrengthCodeDisp(String rxDrugStrengthCodeDisp) {
		this.rxDrugStrengthCodeDisp = rxDrugStrengthCodeDisp;
	}
	public String getRxDispenseNotesDispensed() {
		return rxDispenseNotesDispensed;
	}
	public void setRxDispenseNotesDispensed(String rxDispenseNotesDispensed) {
		this.rxDispenseNotesDispensed = rxDispenseNotesDispensed;
	}
	public String getRxRefillsDispensed() {
		return rxRefillsDispensed;
	}
	public void setRxRefillsDispensed(String rxRefillsDispensed) {
		this.rxRefillsDispensed = rxRefillsDispensed;
	}
	public String getRxSigDispensed() {
		return rxSigDispensed;
	}
	public void setRxSigDispensed(String rxSigDispensed) {
		this.rxSigDispensed = rxSigDispensed;
	}
	public String getRxCommentsDispensed() {
		return rxCommentsDispensed;
	}
	public void setRxCommentsDispensed(String rxCommentsDispensed) {
		this.rxCommentsDispensed = rxCommentsDispensed;
	}
	public String getRxGrp() {
		return rxGrp;
	}
	public void setRxGrp(String rxGrp) {
		this.rxGrp = rxGrp;
	}
	public String getRxBinNum() {
		return rxBinNum;
	}
	public void setRxBinNum(String rxBinNum) {
		this.rxBinNum = rxBinNum;
	}
	public String getRxPcn() {
		return rxPcn;
	}
	public void setRxPcn(String rxPcn) {
		this.rxPcn = rxPcn;
	}
	public String getDataError() {
		return errorMessage;
	}
	public void setDataError(String errorMessage) {
		this.errorMessage= errorMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getPatient_chk_status() {
		return patient_chk_status;
	}
	public void setPatient_chk_status(String patient_chk_status) {
		this.patient_chk_status = patient_chk_status;
	}
	public String getProvider_chk_status() {
		return provider_chk_status;
	}
	public void setProvider_chk_status(String provider_chk_status) {
		this.provider_chk_status = provider_chk_status;
	}
	public String getDrug_chk_status() {
		return drug_chk_status;
	}
	public void setDrug_chk_status(String drug_chk_status) {
		this.drug_chk_status = drug_chk_status;
	}
	public String getMessage_status() {
		return message_status;
	}
	public void setMessage_status(String message_status) {
		this.message_status = message_status;
	}
	public String getReqRefno() {
		return reqRefno;
	}
	public void setReqRefno(String reqRefno) {
		this.reqRefno = reqRefno;
	}
	
	public String getResType() {
		return resType;
	}
	public void setResType(String resType) {
		this.resType = resType;
	}
	public String getResAprvReasonCd() {
		return resAprvReasonCd;
	}
	public void setResAprvReasonCd(String resAprvReasonCd) {
		this.resAprvReasonCd = resAprvReasonCd;
	}
	public String getResAprvRefno() {
		return resAprvRefno;
	}
	public void setResAprvRefno(String resAprvRefno) {
		this.resAprvRefno = resAprvRefno;
	}
	public String getResAprvNote() {
		return resAprvNote;
	}
	public void setResAprvNote(String resAprvNote) {
		this.resAprvNote = resAprvNote;
	}
	public String getResAprvWthChngReasonCd() {
		return resAprvWthChngReasonCd;
	}
	public void setResAprvWthChngReasonCd(String resAprvWthChngReasonCd) {
		this.resAprvWthChngReasonCd = resAprvWthChngReasonCd;
	}
	public String getResAprvWthChngRefno() {
		return resAprvWthChngRefno;
	}
	public void setResAprvWthChngRefno(String resAprvWthChngRefno) {
		this.resAprvWthChngRefno = resAprvWthChngRefno;
	}
	public String getResAprvWthChngNote() {
		return resAprvWthChngNote;
	}
	public void setResAprvWthChngNote(String resAprvWthChngNote) {
		this.resAprvWthChngNote = resAprvWthChngNote;
	}
	public String getResDenialReasonCd() {
		return resDenialReasonCd;
	}
	public void setResDenialReasonCd(String resDenialReasonCd) {
		this.resDenialReasonCd = resDenialReasonCd;
	}
	public String getResDenialRefno() {
		return resDenialRefno;
	}
	public void setResDenialRefno(String resDenialRefno) {
		this.resDenialRefno = resDenialRefno;
	}
	public String getResDenialReason() {
		return resDenialReason;
	}
	public void setResDenialReason(String resDenialReason) {
		this.resDenialReason = resDenialReason;
	}
	public String getResDenialNrxReasonCd() {
		return resDenialNrxReasonCd;
	}
	public void setResDenialNrxReasonCd(String resDenialNrxReasonCd) {
		this.resDenialNrxReasonCd = resDenialNrxReasonCd;
	}
	public String getResDenialNrxRefno() {
		return resDenialNrxRefno;
	}
	public void setResDenialNrxRefno(String resDenialNrxRefno) {
		this.resDenialNrxRefno = resDenialNrxRefno;
	}
	public String getResDenialNrxReason() {
		return resDenialNrxReason;
	}
	public void setResDenialNrxReason(String resDenialNrxReason) {
		this.resDenialNrxReason = resDenialNrxReason;
	}
	public String getEsvDescriptionCode() {
		return esvDescriptionCode;
	}
	public void setEsvDescriptionCode(String esvDescriptionCode) {
		this.esvDescriptionCode = esvDescriptionCode;
	}
	public String getEsvCode() {
		return esvCode;
	}
	public void setEsvCode(String esvCode) {
		this.esvCode = esvCode;
	}
	public String getEsvDescription() {
		return esvDescription;
	}
	public void setEsvDescription(String esvDescription) {
		this.esvDescription = esvDescription;
	}
	public String getClinicId() {
		return clinicId;
	}
	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}
	public String getRxReferenceNumber() {
		return rxReferenceNumber;
	}
	public void setRxReferenceNumber(String rxReferenceNumber) {
		this.rxReferenceNumber = rxReferenceNumber;
	}
	public String getPrescriberOrderNumber() {
		return prescriberOrderNumber;
	}
	public void setPrescriberOrderNumber(String prescriberOrderNumber) {
		this.prescriberOrderNumber = prescriberOrderNumber;
	}
	public String getRxDrugPrescribedNdc() {
		return rxDrugPrescribedNdc;
	}
	public void setRxDrugPrescribedNdc(String rxDrugPrescribedNdc) {
		this.rxDrugPrescribedNdc = rxDrugPrescribedNdc;
	}
	public String getRxDrugPrescribedQualifier() {
		return rxDrugPrescribedQualifier;
	}
	public void setRxDrugPrescribedQualifier(String rxDrugPrescribedQualifier) {
		this.rxDrugPrescribedQualifier = rxDrugPrescribedQualifier;
	}
	public String getRxDrugDispensedNdc() {
		return rxDrugDispensedNdc;
	}
	public void setRxDrugDispensedNdc(String rxDrugDispensedNdc) {
		this.rxDrugDispensedNdc = rxDrugDispensedNdc;
	}
	public String getRxDrugDispensedQualifier() {
		return rxDrugDispensedQualifier;
	}
	public void setRxDrugDispensedQualifier(String rxDrugDispensedQualifier) {
		this.rxDrugDispensedQualifier = rxDrugDispensedQualifier;
	}
	public String getChangeofPrescrStatFlg() {
		return changeofPrescrStatFlg;
	}
	public void setChangeofPrescrStatFlg(String changeofPrescrStatFlg) {
		this.changeofPrescrStatFlg = changeofPrescrStatFlg;
	}
	public String getRxFillStatus() {
		return rxFillStatus;
	}
	public void setRxFillStatus(String rxFillStatus) {
		this.rxFillStatus = rxFillStatus;
	}
	public String getRxFillRefNum() {
		return rxFillRefNum;
	}
	public void setRxFillRefNum(String rxFillRefNum) {
		this.rxFillRefNum = rxFillRefNum;
	}
	public String getRxFillNote() {
		return rxFillNote;
	}
	public void setRxFillNote(String rxFillNote) {
		this.rxFillNote = rxFillNote;
	}
	public String getRxFillReasonCd() {
		return rxFillReasonCd;
	}
	public void setRxFillReasonCd(String rxFillReasonCd) {
		this.rxFillReasonCd = rxFillReasonCd;
	}
	public String getChangeRequestType() {
		return changeRequestType;
	}
	public void setChangeRequestType(String changeRequestType) {
		this.changeRequestType = changeRequestType;
	}
	public String getRequestReferenceNumber() {
		return requestReferenceNumber;
	}
	public void setRequestReferenceNumber(String requestReferenceNumber) {
		this.requestReferenceNumber = requestReferenceNumber;
	}
	public String getRxDrugRequested() {
		return rxDrugRequested;
	}
	public void setRxDrugRequested(String rxDrugRequested) {
		this.rxDrugRequested = rxDrugRequested;
	}
	public String getRxDrugRequestedNdc() {
		return rxDrugRequestedNdc;
	}
	public void setRxDrugRequestedNdc(String rxDrugRequestedNdc) {
		this.rxDrugRequestedNdc = rxDrugRequestedNdc;
	}
	public String getRxQuantityRequested() {
		return rxQuantityRequested;
	}
	public void setRxQuantityRequested(String rxQuantityRequested) {
		this.rxQuantityRequested = rxQuantityRequested;
	}
	public String getRxDaysSupplyRequested() {
		return rxDaysSupplyRequested;
	}
	public void setRxDaysSupplyRequested(String rxDaysSupplyRequested) {
		this.rxDaysSupplyRequested = rxDaysSupplyRequested;
	}
	public String getRxDateWrittenRequested() {
		return rxDateWrittenRequested;
	}
	public void setRxDateWrittenRequested(String rxDateWrittenRequested) {
		this.rxDateWrittenRequested = rxDateWrittenRequested;
	}
	public String getRxPotencyUnitCodeRequested() {
		return rxPotencyUnitCodeRequested;
	}
	public void setRxPotencyUnitCodeRequested(String rxPotencyUnitCodeRequested) {
		this.rxPotencyUnitCodeRequested = rxPotencyUnitCodeRequested;
	}
	public String getRxDrugStrengthRequested() {
		return rxDrugStrengthRequested;
	}
	public void setRxDrugStrengthRequested(String rxDrugStrengthRequested) {
		this.rxDrugStrengthRequested = rxDrugStrengthRequested;
	}
	public String getRxDrugStrengthCodeReq() {
		return rxDrugStrengthCodeReq;
	}
	public void setRxDrugStrengthCodeReq(String rxDrugStrengthCodeReq) {
		this.rxDrugStrengthCodeReq = rxDrugStrengthCodeReq;
	}
	public String getRxSigRequested() {
		return rxSigRequested;
	}
	public void setRxSigRequested(String rxSigRequested) {
		this.rxSigRequested = rxSigRequested;
	}
	public String getRxDispenseNotesRequested() {
		return rxDispenseNotesRequested;
	}
	public void setRxDispenseNotesRequested(String rxDispenseNotesRequested) {
		this.rxDispenseNotesRequested = rxDispenseNotesRequested;
	}
	public String getRxCommentsRequested() {
		return rxCommentsRequested;
	}
	public void setRxCommentsRequested(String rxCommentsRequested) {
		this.rxCommentsRequested = rxCommentsRequested;
	}
	public String getRxDrugFormRequested() {
		return rxDrugFormRequested;
	}
	public void setRxDrugFormRequested(String rxDrugFormRequested) {
		this.rxDrugFormRequested = rxDrugFormRequested;
	}
	public String getRxRefillsRequested() {
		return rxRefillsRequested;
	}
	public void setRxRefillsRequested(String rxRefillsRequested) {
		this.rxRefillsRequested = rxRefillsRequested;
	}
	public String getRxPatientCheck() {
		return rxPatientCheck;
	}
	public void setRxPatientCheck(String rxPatientCheck) {
		this.rxPatientCheck = rxPatientCheck;
	}
	public String getRxProviderCheck() {
		return rxProviderCheck;
	}
	public void setRxProviderCheck(String rxProviderCheck) {
		this.rxProviderCheck = rxProviderCheck;
	}
	public String getRxDrugCheck() {
		return rxDrugCheck;
	}
	public void setRxDrugCheck(String rxDrugCheck) {
		this.rxDrugCheck = rxDrugCheck;
	}
	public String getRxDrugRequested2() {
		return rxDrugRequested2;
	}
	public void setRxDrugRequested2(String rxDrugRequested2) {
		this.rxDrugRequested2 = rxDrugRequested2;
	}
	public String getRxDrugRequestedNdc2() {
		return rxDrugRequestedNdc2;
	}
	public void setRxDrugRequestedNdc2(String rxDrugRequestedNdc2) {
		this.rxDrugRequestedNdc2 = rxDrugRequestedNdc2;
	}
	public String getRxQuantityRequested2() {
		return rxQuantityRequested2;
	}
	public void setRxQuantityRequested2(String rxQuantityRequested2) {
		this.rxQuantityRequested2 = rxQuantityRequested2;
	}
	public String getRxDaysSupplyRequested2() {
		return rxDaysSupplyRequested2;
	}
	public void setRxDaysSupplyRequested2(String rxDaysSupplyRequested2) {
		this.rxDaysSupplyRequested2 = rxDaysSupplyRequested2;
	}
	public String getRxDateWrittenRequested2() {
		return rxDateWrittenRequested2;
	}
	public void setRxDateWrittenRequested2(String rxDateWrittenRequested2) {
		this.rxDateWrittenRequested2 = rxDateWrittenRequested2;
	}
	public String getRxPotencyUnitCodeRequested2() {
		return rxPotencyUnitCodeRequested2;
	}
	public void setRxPotencyUnitCodeRequested2(String rxPotencyUnitCodeRequested2) {
		this.rxPotencyUnitCodeRequested2 = rxPotencyUnitCodeRequested2;
	}
	public String getRxDrugFormRequested2() {
		return rxDrugFormRequested2;
	}
	public void setRxDrugFormRequested2(String rxDrugFormRequested2) {
		this.rxDrugFormRequested2 = rxDrugFormRequested2;
	}
	public String getRxDrugStrengthRequested2() {
		return rxDrugStrengthRequested2;
	}
	public void setRxDrugStrengthRequested2(String rxDrugStrengthRequested2) {
		this.rxDrugStrengthRequested2 = rxDrugStrengthRequested2;
	}
	public String getRxDrugStrengthCodeReq2() {
		return rxDrugStrengthCodeReq2;
	}
	public void setRxDrugStrengthCodeReq2(String rxDrugStrengthCodeReq2) {
		this.rxDrugStrengthCodeReq2 = rxDrugStrengthCodeReq2;
	}
	public String getRxRefillsRequested2() {
		return rxRefillsRequested2;
	}
	public void setRxRefillsRequested2(String rxRefillsRequested2) {
		this.rxRefillsRequested2 = rxRefillsRequested2;
	}
	public String getRxSigRequested2() {
		return rxSigRequested2;
	}
	public void setRxSigRequested2(String rxSigRequested2) {
		this.rxSigRequested2 = rxSigRequested2;
	}
	public String getRxDispenseNotesRequested2() {
		return rxDispenseNotesRequested2;
	}
	public void setRxDispenseNotesRequested2(String rxDispenseNotesRequested2) {
		this.rxDispenseNotesRequested2 = rxDispenseNotesRequested2;
	}
	public String getRxCommentsRequested2() {
		return rxCommentsRequested2;
	}
	public void setRxCommentsRequested2(String rxCommentsRequested2) {
		this.rxCommentsRequested2 = rxCommentsRequested2;
	}
	public String getRxDrugRequested3() {
		return rxDrugRequested3;
	}
	public void setRxDrugRequested3(String rxDrugRequested3) {
		this.rxDrugRequested3 = rxDrugRequested3;
	}
	public String getRxDrugRequestedNdc3() {
		return rxDrugRequestedNdc3;
	}
	public void setRxDrugRequestedNdc3(String rxDrugRequestedNdc3) {
		this.rxDrugRequestedNdc3 = rxDrugRequestedNdc3;
	}
	public String getRxQuantityRequested3() {
		return rxQuantityRequested3;
	}
	public void setRxQuantityRequested3(String rxQuantityRequested3) {
		this.rxQuantityRequested3 = rxQuantityRequested3;
	}
	public String getRxDaysSupplyRequested3() {
		return rxDaysSupplyRequested3;
	}
	public void setRxDaysSupplyRequested3(String rxDaysSupplyRequested3) {
		this.rxDaysSupplyRequested3 = rxDaysSupplyRequested3;
	}
	public String getRxDateWrittenRequested3() {
		return rxDateWrittenRequested3;
	}
	public void setRxDateWrittenRequested3(String rxDateWrittenRequested3) {
		this.rxDateWrittenRequested3 = rxDateWrittenRequested3;
	}
	public String getRxPotencyUnitCodeRequested3() {
		return rxPotencyUnitCodeRequested3;
	}
	public void setRxPotencyUnitCodeRequested3(String rxPotencyUnitCodeRequested3) {
		this.rxPotencyUnitCodeRequested3 = rxPotencyUnitCodeRequested3;
	}
	public String getRxDrugFormRequested3() {
		return rxDrugFormRequested3;
	}
	public void setRxDrugFormRequested3(String rxDrugFormRequested3) {
		this.rxDrugFormRequested3 = rxDrugFormRequested3;
	}
	public String getRxDrugStrengthRequested3() {
		return rxDrugStrengthRequested3;
	}
	public void setRxDrugStrengthRequested3(String rxDrugStrengthRequested3) {
		this.rxDrugStrengthRequested3 = rxDrugStrengthRequested3;
	}
	public String getRxDrugStrengthCodeReq3() {
		return rxDrugStrengthCodeReq3;
	}
	public void setRxDrugStrengthCodeReq3(String rxDrugStrengthCodeReq3) {
		this.rxDrugStrengthCodeReq3 = rxDrugStrengthCodeReq3;
	}
	public String getRxRefillsRequested3() {
		return rxRefillsRequested3;
	}
	public void setRxRefillsRequested3(String rxRefillsRequested3) {
		this.rxRefillsRequested3 = rxRefillsRequested3;
	}
	public String getRxSigRequested3() {
		return rxSigRequested3;
	}
	public void setRxSigRequested3(String rxSigRequested3) {
		this.rxSigRequested3 = rxSigRequested3;
	}
	public String getRxDispenseNotesRequested3() {
		return rxDispenseNotesRequested3;
	}
	public void setRxDispenseNotesRequested3(String rxDispenseNotesRequested3) {
		this.rxDispenseNotesRequested3 = rxDispenseNotesRequested3;
	}
	public String getRxCommentsRequested3() {
		return rxCommentsRequested3;
	}
	public void setRxCommentsRequested3(String rxCommentsRequested3) {
		this.rxCommentsRequested3 = rxCommentsRequested3;
	}
	public String getRxDrugRequested4() {
		return rxDrugRequested4;
	}
	public void setRxDrugRequested4(String rxDrugRequested4) {
		this.rxDrugRequested4 = rxDrugRequested4;
	}
	public String getRxDrugRequestedNdc4() {
		return rxDrugRequestedNdc4;
	}
	public void setRxDrugRequestedNdc4(String rxDrugRequestedNdc4) {
		this.rxDrugRequestedNdc4 = rxDrugRequestedNdc4;
	}
	public String getRxQuantityRequested4() {
		return rxQuantityRequested4;
	}
	public void setRxQuantityRequested4(String rxQuantityRequested4) {
		this.rxQuantityRequested4 = rxQuantityRequested4;
	}
	public String getRxDaysSupplyRequested4() {
		return rxDaysSupplyRequested4;
	}
	public void setRxDaysSupplyRequested4(String rxDaysSupplyRequested4) {
		this.rxDaysSupplyRequested4 = rxDaysSupplyRequested4;
	}
	public String getRxDateWrittenRequested4() {
		return rxDateWrittenRequested4;
	}
	public void setRxDateWrittenRequested4(String rxDateWrittenRequested4) {
		this.rxDateWrittenRequested4 = rxDateWrittenRequested4;
	}
	public String getRxPotencyUnitCodeRequested4() {
		return rxPotencyUnitCodeRequested4;
	}
	public void setRxPotencyUnitCodeRequested4(String rxPotencyUnitCodeRequested4) {
		this.rxPotencyUnitCodeRequested4 = rxPotencyUnitCodeRequested4;
	}
	public String getRxDrugFormRequested4() {
		return rxDrugFormRequested4;
	}
	public void setRxDrugFormRequested4(String rxDrugFormRequested4) {
		this.rxDrugFormRequested4 = rxDrugFormRequested4;
	}
	public String getRxDrugStrengthRequested4() {
		return rxDrugStrengthRequested4;
	}
	public void setRxDrugStrengthRequested4(String rxDrugStrengthRequested4) {
		this.rxDrugStrengthRequested4 = rxDrugStrengthRequested4;
	}
	public String getRxDrugStrengthCodeReq4() {
		return rxDrugStrengthCodeReq4;
	}
	public void setRxDrugStrengthCodeReq4(String rxDrugStrengthCodeReq4) {
		this.rxDrugStrengthCodeReq4 = rxDrugStrengthCodeReq4;
	}
	public String getRxRefillsRequested4() {
		return rxRefillsRequested4;
	}
	public void setRxRefillsRequested4(String rxRefillsRequested4) {
		this.rxRefillsRequested4 = rxRefillsRequested4;
	}
	public String getRxSigRequested4() {
		return rxSigRequested4;
	}
	public void setRxSigRequested4(String rxSigRequested4) {
		this.rxSigRequested4 = rxSigRequested4;
	}
	public String getRxDispenseNotesRequested4() {
		return rxDispenseNotesRequested4;
	}
	public void setRxDispenseNotesRequested4(String rxDispenseNotesRequested4) {
		this.rxDispenseNotesRequested4 = rxDispenseNotesRequested4;
	}
	public String getRxCommentsRequested4() {
		return rxCommentsRequested4;
	}
	public void setRxCommentsRequested4(String rxCommentsRequested4) {
		this.rxCommentsRequested4 = rxCommentsRequested4;
	}
	public String getRxDrugRequested5() {
		return rxDrugRequested5;
	}
	public void setRxDrugRequested5(String rxDrugRequested5) {
		this.rxDrugRequested5 = rxDrugRequested5;
	}
	public String getRxDrugRequestedNdc5() {
		return rxDrugRequestedNdc5;
	}
	public void setRxDrugRequestedNdc5(String rxDrugRequestedNdc5) {
		this.rxDrugRequestedNdc5 = rxDrugRequestedNdc5;
	}
	public String getRxQuantityRequested5() {
		return rxQuantityRequested5;
	}
	public void setRxQuantityRequested5(String rxQuantityRequested5) {
		this.rxQuantityRequested5 = rxQuantityRequested5;
	}
	public String getRxDaysSupplyRequested5() {
		return rxDaysSupplyRequested5;
	}
	public void setRxDaysSupplyRequested5(String rxDaysSupplyRequested5) {
		this.rxDaysSupplyRequested5 = rxDaysSupplyRequested5;
	}
	public String getRxDateWrittenRequested5() {
		return rxDateWrittenRequested5;
	}
	public void setRxDateWrittenRequested5(String rxDateWrittenRequested5) {
		this.rxDateWrittenRequested5 = rxDateWrittenRequested5;
	}
	public String getRxPotencyUnitCodeRequested5() {
		return rxPotencyUnitCodeRequested5;
	}
	public void setRxPotencyUnitCodeRequested5(String rxPotencyUnitCodeRequested5) {
		this.rxPotencyUnitCodeRequested5 = rxPotencyUnitCodeRequested5;
	}
	public String getRxDrugFormRequested5() {
		return rxDrugFormRequested5;
	}
	public void setRxDrugFormRequested5(String rxDrugFormRequested5) {
		this.rxDrugFormRequested5 = rxDrugFormRequested5;
	}
	public String getRxDrugStrengthRequested5() {
		return rxDrugStrengthRequested5;
	}
	public void setRxDrugStrengthRequested5(String rxDrugStrengthRequested5) {
		this.rxDrugStrengthRequested5 = rxDrugStrengthRequested5;
	}
	public String getRxDrugStrengthCodeReq5() {
		return rxDrugStrengthCodeReq5;
	}
	public void setRxDrugStrengthCodeReq5(String rxDrugStrengthCodeReq5) {
		this.rxDrugStrengthCodeReq5 = rxDrugStrengthCodeReq5;
	}
	public String getRxRefillsRequested5() {
		return rxRefillsRequested5;
	}
	public void setRxRefillsRequested5(String rxRefillsRequested5) {
		this.rxRefillsRequested5 = rxRefillsRequested5;
	}
	public String getRxSigRequested5() {
		return rxSigRequested5;
	}
	public void setRxSigRequested5(String rxSigRequested5) {
		this.rxSigRequested5 = rxSigRequested5;
	}
	public String getRxDispenseNotesRequested5() {
		return rxDispenseNotesRequested5;
	}
	public void setRxDispenseNotesRequested5(String rxDispenseNotesRequested5) {
		this.rxDispenseNotesRequested5 = rxDispenseNotesRequested5;
	}
	public String getRxCommentsRequested5() {
		return rxCommentsRequested5;
	}
	public void setRxCommentsRequested5(String rxCommentsRequested5) {
		this.rxCommentsRequested5 = rxCommentsRequested5;
	}
	public String getRxDrugRequested6() {
		return rxDrugRequested6;
	}
	public void setRxDrugRequested6(String rxDrugRequested6) {
		this.rxDrugRequested6 = rxDrugRequested6;
	}
	public String getRxDrugRequestedNdc6() {
		return rxDrugRequestedNdc6;
	}
	public void setRxDrugRequestedNdc6(String rxDrugRequestedNdc6) {
		this.rxDrugRequestedNdc6 = rxDrugRequestedNdc6;
	}
	public String getRxQuantityRequested6() {
		return rxQuantityRequested6;
	}
	public void setRxQuantityRequested6(String rxQuantityRequested6) {
		this.rxQuantityRequested6 = rxQuantityRequested6;
	}
	public String getRxDaysSupplyRequested6() {
		return rxDaysSupplyRequested6;
	}
	public void setRxDaysSupplyRequested6(String rxDaysSupplyRequested6) {
		this.rxDaysSupplyRequested6 = rxDaysSupplyRequested6;
	}
	public String getRxDateWrittenRequested6() {
		return rxDateWrittenRequested6;
	}
	public void setRxDateWrittenRequested6(String rxDateWrittenRequested6) {
		this.rxDateWrittenRequested6 = rxDateWrittenRequested6;
	}
	public String getRxPotencyUnitCodeRequested6() {
		return rxPotencyUnitCodeRequested6;
	}
	public void setRxPotencyUnitCodeRequested6(String rxPotencyUnitCodeRequested6) {
		this.rxPotencyUnitCodeRequested6 = rxPotencyUnitCodeRequested6;
	}
	public String getRxDrugFormRequested6() {
		return rxDrugFormRequested6;
	}
	public void setRxDrugFormRequested6(String rxDrugFormRequested6) {
		this.rxDrugFormRequested6 = rxDrugFormRequested6;
	}
	public String getRxDrugStrengthRequested6() {
		return rxDrugStrengthRequested6;
	}
	public void setRxDrugStrengthRequested6(String rxDrugStrengthRequested6) {
		this.rxDrugStrengthRequested6 = rxDrugStrengthRequested6;
	}
	public String getRxDrugStrengthCodeReq6() {
		return rxDrugStrengthCodeReq6;
	}
	public void setRxDrugStrengthCodeReq6(String rxDrugStrengthCodeReq6) {
		this.rxDrugStrengthCodeReq6 = rxDrugStrengthCodeReq6;
	}
	public String getRxRefillsRequested6() {
		return rxRefillsRequested6;
	}
	public void setRxRefillsRequested6(String rxRefillsRequested6) {
		this.rxRefillsRequested6 = rxRefillsRequested6;
	}
	public String getRxSigRequested6() {
		return rxSigRequested6;
	}
	public void setRxSigRequested6(String rxSigRequested6) {
		this.rxSigRequested6 = rxSigRequested6;
	}
	public String getRxDispenseNotesRequested6() {
		return rxDispenseNotesRequested6;
	}
	public void setRxDispenseNotesRequested6(String rxDispenseNotesRequested6) {
		this.rxDispenseNotesRequested6 = rxDispenseNotesRequested6;
	}
	public String getRxCommentsRequested6() {
		return rxCommentsRequested6;
	}
	public void setRxCommentsRequested6(String rxCommentsRequested6) {
		this.rxCommentsRequested6 = rxCommentsRequested6;
	}
	public String getRxDrugRequested7() {
		return rxDrugRequested7;
	}
	public void setRxDrugRequested7(String rxDrugRequested7) {
		this.rxDrugRequested7 = rxDrugRequested7;
	}
	public String getRxDrugRequestedNdc7() {
		return rxDrugRequestedNdc7;
	}
	public void setRxDrugRequestedNdc7(String rxDrugRequestedNdc7) {
		this.rxDrugRequestedNdc7 = rxDrugRequestedNdc7;
	}
	public String getRxQuantityRequested7() {
		return rxQuantityRequested7;
	}
	public void setRxQuantityRequested7(String rxQuantityRequested7) {
		this.rxQuantityRequested7 = rxQuantityRequested7;
	}
	public String getRxDaysSupplyRequested7() {
		return rxDaysSupplyRequested7;
	}
	public void setRxDaysSupplyRequested7(String rxDaysSupplyRequested7) {
		this.rxDaysSupplyRequested7 = rxDaysSupplyRequested7;
	}
	public String getRxDateWrittenRequested7() {
		return rxDateWrittenRequested7;
	}
	public void setRxDateWrittenRequested7(String rxDateWrittenRequested7) {
		this.rxDateWrittenRequested7 = rxDateWrittenRequested7;
	}
	public String getRxPotencyUnitCodeRequested7() {
		return rxPotencyUnitCodeRequested7;
	}
	public void setRxPotencyUnitCodeRequested7(String rxPotencyUnitCodeRequested7) {
		this.rxPotencyUnitCodeRequested7 = rxPotencyUnitCodeRequested7;
	}
	public String getRxDrugFormRequested7() {
		return rxDrugFormRequested7;
	}
	public void setRxDrugFormRequested7(String rxDrugFormRequested7) {
		this.rxDrugFormRequested7 = rxDrugFormRequested7;
	}
	public String getRxDrugStrengthRequested7() {
		return rxDrugStrengthRequested7;
	}
	public void setRxDrugStrengthRequested7(String rxDrugStrengthRequested7) {
		this.rxDrugStrengthRequested7 = rxDrugStrengthRequested7;
	}
	public String getRxDrugStrengthCodeReq7() {
		return rxDrugStrengthCodeReq7;
	}
	public void setRxDrugStrengthCodeReq7(String rxDrugStrengthCodeReq7) {
		this.rxDrugStrengthCodeReq7 = rxDrugStrengthCodeReq7;
	}
	public String getRxRefillsRequested7() {
		return rxRefillsRequested7;
	}
	public void setRxRefillsRequested7(String rxRefillsRequested7) {
		this.rxRefillsRequested7 = rxRefillsRequested7;
	}
	public String getRxSigRequested7() {
		return rxSigRequested7;
	}
	public void setRxSigRequested7(String rxSigRequested7) {
		this.rxSigRequested7 = rxSigRequested7;
	}
	public String getRxDispenseNotesRequested7() {
		return rxDispenseNotesRequested7;
	}
	public void setRxDispenseNotesRequested7(String rxDispenseNotesRequested7) {
		this.rxDispenseNotesRequested7 = rxDispenseNotesRequested7;
	}
	public String getRxCommentsRequested7() {
		return rxCommentsRequested7;
	}
	public void setRxCommentsRequested7(String rxCommentsRequested7) {
		this.rxCommentsRequested7 = rxCommentsRequested7;
	}
	public String getRxDrugRequested8() {
		return rxDrugRequested8;
	}
	public void setRxDrugRequested8(String rxDrugRequested8) {
		this.rxDrugRequested8 = rxDrugRequested8;
	}
	public String getRxDrugRequestedNdc8() {
		return rxDrugRequestedNdc8;
	}
	public void setRxDrugRequestedNdc8(String rxDrugRequestedNdc8) {
		this.rxDrugRequestedNdc8 = rxDrugRequestedNdc8;
	}
	public String getRxQuantityRequested8() {
		return rxQuantityRequested8;
	}
	public void setRxQuantityRequested8(String rxQuantityRequested8) {
		this.rxQuantityRequested8 = rxQuantityRequested8;
	}
	public String getRxDaysSupplyRequested8() {
		return rxDaysSupplyRequested8;
	}
	public void setRxDaysSupplyRequested8(String rxDaysSupplyRequested8) {
		this.rxDaysSupplyRequested8 = rxDaysSupplyRequested8;
	}
	public String getRxDateWrittenRequested8() {
		return rxDateWrittenRequested8;
	}
	public void setRxDateWrittenRequested8(String rxDateWrittenRequested8) {
		this.rxDateWrittenRequested8 = rxDateWrittenRequested8;
	}
	public String getRxPotencyUnitCodeRequested8() {
		return rxPotencyUnitCodeRequested8;
	}
	public void setRxPotencyUnitCodeRequested8(String rxPotencyUnitCodeRequested8) {
		this.rxPotencyUnitCodeRequested8 = rxPotencyUnitCodeRequested8;
	}
	public String getRxDrugFormRequested8() {
		return rxDrugFormRequested8;
	}
	public void setRxDrugFormRequested8(String rxDrugFormRequested8) {
		this.rxDrugFormRequested8 = rxDrugFormRequested8;
	}
	public String getRxDrugStrengthRequested8() {
		return rxDrugStrengthRequested8;
	}
	public void setRxDrugStrengthRequested8(String rxDrugStrengthRequested8) {
		this.rxDrugStrengthRequested8 = rxDrugStrengthRequested8;
	}
	public String getRxDrugStrengthCodeReq8() {
		return rxDrugStrengthCodeReq8;
	}
	public void setRxDrugStrengthCodeReq8(String rxDrugStrengthCodeReq8) {
		this.rxDrugStrengthCodeReq8 = rxDrugStrengthCodeReq8;
	}
	public String getRxRefillsRequested8() {
		return rxRefillsRequested8;
	}
	public void setRxRefillsRequested8(String rxRefillsRequested8) {
		this.rxRefillsRequested8 = rxRefillsRequested8;
	}
	public String getRxSigRequested8() {
		return rxSigRequested8;
	}
	public void setRxSigRequested8(String rxSigRequested8) {
		this.rxSigRequested8 = rxSigRequested8;
	}
	public String getRxDispenseNotesRequested8() {
		return rxDispenseNotesRequested8;
	}
	public void setRxDispenseNotesRequested8(String rxDispenseNotesRequested8) {
		this.rxDispenseNotesRequested8 = rxDispenseNotesRequested8;
	}
	public String getRxCommentsRequested8() {
		return rxCommentsRequested8;
	}
	public void setRxCommentsRequested8(String rxCommentsRequested8) {
		this.rxCommentsRequested8 = rxCommentsRequested8;
	}
	public String getRxDrugRequested9() {
		return rxDrugRequested9;
	}
	public void setRxDrugRequested9(String rxDrugRequested9) {
		this.rxDrugRequested9 = rxDrugRequested9;
	}
	public String getRxDrugRequestedNdc9() {
		return rxDrugRequestedNdc9;
	}
	public void setRxDrugRequestedNdc9(String rxDrugRequestedNdc9) {
		this.rxDrugRequestedNdc9 = rxDrugRequestedNdc9;
	}
	public String getRxQuantityRequested9() {
		return rxQuantityRequested9;
	}
	public void setRxQuantityRequested9(String rxQuantityRequested9) {
		this.rxQuantityRequested9 = rxQuantityRequested9;
	}
	public String getRxDaysSupplyRequested9() {
		return rxDaysSupplyRequested9;
	}
	public void setRxDaysSupplyRequested9(String rxDaysSupplyRequested9) {
		this.rxDaysSupplyRequested9 = rxDaysSupplyRequested9;
	}
	public String getRxDateWrittenRequested9() {
		return rxDateWrittenRequested9;
	}
	public void setRxDateWrittenRequested9(String rxDateWrittenRequested9) {
		this.rxDateWrittenRequested9 = rxDateWrittenRequested9;
	}
	public String getRxPotencyUnitCodeRequested9() {
		return rxPotencyUnitCodeRequested9;
	}
	public void setRxPotencyUnitCodeRequested9(String rxPotencyUnitCodeRequested9) {
		this.rxPotencyUnitCodeRequested9 = rxPotencyUnitCodeRequested9;
	}
	public String getRxDrugFormRequested9() {
		return rxDrugFormRequested9;
	}
	public void setRxDrugFormRequested9(String rxDrugFormRequested9) {
		this.rxDrugFormRequested9 = rxDrugFormRequested9;
	}
	public String getRxDrugStrengthRequested9() {
		return rxDrugStrengthRequested9;
	}
	public void setRxDrugStrengthRequested9(String rxDrugStrengthRequested9) {
		this.rxDrugStrengthRequested9 = rxDrugStrengthRequested9;
	}
	public String getRxDrugStrengthCodeReq9() {
		return rxDrugStrengthCodeReq9;
	}
	public void setRxDrugStrengthCodeReq9(String rxDrugStrengthCodeReq9) {
		this.rxDrugStrengthCodeReq9 = rxDrugStrengthCodeReq9;
	}
	public String getRxRefillsRequested9() {
		return rxRefillsRequested9;
	}
	public void setRxRefillsRequested9(String rxRefillsRequested9) {
		this.rxRefillsRequested9 = rxRefillsRequested9;
	}
	public String getRxSigRequested9() {
		return rxSigRequested9;
	}
	public void setRxSigRequested9(String rxSigRequested9) {
		this.rxSigRequested9 = rxSigRequested9;
	}
	public String getRxDispenseNotesRequested9() {
		return rxDispenseNotesRequested9;
	}
	public void setRxDispenseNotesRequested9(String rxDispenseNotesRequested9) {
		this.rxDispenseNotesRequested9 = rxDispenseNotesRequested9;
	}
	public String getRxCommentsRequested9() {
		return rxCommentsRequested9;
	}
	public void setRxCommentsRequested9(String rxCommentsRequested9) {
		this.rxCommentsRequested9 = rxCommentsRequested9;
	}
	public String getPatientWeight() {
		return patientWeight;
	}
	public void setPatientWeight(String patientWeight) {
		this.patientWeight = patientWeight;
	}
	public String getPatientHeight() {
		return patientHeight;
	}
	public void setPatientHeight(String patientHeight) {
		this.patientHeight = patientHeight;
	}
	public String getPatientPrimaryPhone() {
		return patientPrimaryPhone;
	}
	public void setPatientPrimaryPhone(String patientPrimaryPhone) {
		this.patientPrimaryPhone = patientPrimaryPhone;
	}
	public String getPatientHomePhone() {
		return patientHomePhone;
	}
	public void setPatientHomePhone(String patientHomePhone) {
		this.patientHomePhone = patientHomePhone;
	}
	public String getProhibitRenewalRequest() {
		return prohibitRenewalRequest;
	}
	public void setProhibitRenewalRequest(String prohibitRenewalReq) {
		this.prohibitRenewalRequest = prohibitRenewalReq;
	}
	public String getValidatedPrescriberNPI() {
		return validatedPrescriberNPI;
	}
	public void setValidatedPrescriberNPI(String validatedPrescriberNPI) {
		this.validatedPrescriberNPI = validatedPrescriberNPI;
	}
	public String getValidatedPrescriberDEA() {
		return validatedPrescriberDEA;
	}
	public void setValidatedPrescriberDEA(String validatedPrescriberDEA) {
		this.validatedPrescriberDEA = validatedPrescriberDEA;
	}
	public String getValidatedPrescriberStateLic() {
		return validatedPrescriberStateLic;
	}
	public void setValidatedPrescriberStateLic(String validatedPrescriberStateLic) {
		this.validatedPrescriberStateLic = validatedPrescriberStateLic;
	}
	public String getRxChangeResponseValidatedDate() {
		return rxChangeResponseValidatedDate;
	}
	public void setRxChangeResponseValidatedDate(String rxChangeResponseValidatedDate) {
		this.rxChangeResponseValidatedDate = rxChangeResponseValidatedDate;
	}
	public String getRxChangValidatedReasonCode() {
		return rxChangValidatedReasonCode;
	}
	public void setRxChangValidatedReasonCode(String rxChangValidatedReasonCode) {
		this.rxChangValidatedReasonCode = rxChangValidatedReasonCode;
	}
	public String getRxChangeDeniedReasonCode() {
		return rxChangeDeniedReasonCode;
	}
	public void setRxChangeDeniedReasonCode(String rxChangeDeniedReasonCode) {
		this.rxChangeDeniedReasonCode = rxChangeDeniedReasonCode;
	}
	public String getRxChangeVLDReasonDescription() {
		return rxChangeVLDReasonDescription;
	}
	public void setRxChangeVLDReasonDescription(String rxChangeVLDReasonDescription) {
		this.rxChangeVLDReasonDescription = rxChangeVLDReasonDescription;
	}
	public String getRxChangeDNDReasonDescription() {
		return rxChangeDNDReasonDescription;
	}
	public void setRxChangeDNDReasonDescription(String rxChangeDNDReasonDescription) {
		this.rxChangeDNDReasonDescription = rxChangeDNDReasonDescription;
	}
	public String getRxChangeResponseDenialReason() {
		return rxChangeResponseDenialReason;
	}
	public void setRxChangeResponseDenialReason(String rxChangeResponseDenialReason) {
		this.rxChangeResponseDenialReason = rxChangeResponseDenialReason;
	}
	public String getRxChangeResponseNote() {
		return rxChangeResponseNote;
	}
	public void setRxChangeResponseNote(String rxChangeResponseNote) {
		this.rxChangeResponseNote = rxChangeResponseNote;
	}
	public String getRxChangeDrugCoverageStatusCode() {
		return rxChangeDrugCoverageStatusCode;
	}
	public void setRxChangeDrugCoverageStatusCode(String rxChangeDrugCoverageStatusCode) {
		this.rxChangeDrugCoverageStatusCode = rxChangeDrugCoverageStatusCode;
	}
	public String getRxChangeResponsePriorAuthorization() {
		return rxChangeResponsePriorAuthorization;
	}
	public void setRxChangeResponsePriorAuthorization(String rxChangeResponsePriorAuthorization) {
		this.rxChangeResponsePriorAuthorization = rxChangeResponsePriorAuthorization;
	}
	public String getRxChangeResponsePriorAuthorizationStatus() {
		return rxChangeResponsePriorAuthorizationStatus;
	}
	public void setRxChangeResponsePriorAuthorizationStatus(String rxChangeResponsePriorAuthorizationStatus) {
		this.rxChangeResponsePriorAuthorizationStatus = rxChangeResponsePriorAuthorizationStatus;
	}
	
	

	
   
	
}
