package gov.va.med.pharmacy.jaxrs.tovista.model;
/**
 * This class represents the values from INBOUND_NCPDP_MSG table.
 *
 */

import java.sql.Clob;
import java.util.Date;

public class VistaInboundNcpdpMsg  {


	private long inboundNcpdpMsgId;
	private String erxStatusByPatientChkStatus;
	private String erxStatusByMessageStatus;
	private String erxStatusByProviderChkStatus;
	private String erxStatusByDrugChkStatus;
	private String pharmacy;
	private String messageId;
	private String relToMessageId;
	private String messageType;
	private Clob message;
	private String messageFrom;
	private String patientMatchDetails;
	private String providerMatchDetails;
	private String drugMatchDetails;
	private String vaStationId;
	private String divisionName;
	private Date receivedDate;
	private Date updatedDate;
	private Date createdDate;
	private String potencyUnitCode;
	private String potencyUnitText;
	private String drugForm;
	private String drugFormText;
	private String drugStrengthCode;
	private String drugStrengthText;
	private String npi;
	private String cancelRxDenied;
	private long relToOutboundNcpdpMsgId;
	private String prohibitRenewalRequest;
	
	public long getInboundNcpdpMsgId() {
		return inboundNcpdpMsgId;
	}


	public void setInboundNcpdpMsgId(long inboundNcpdpMsgId) {
		this.inboundNcpdpMsgId = inboundNcpdpMsgId;
	}


	public String getMessageFrom() {
		return messageFrom;
	}


	public void setMessageFrom(String messageFrom) {
		this.messageFrom = messageFrom;
	}


	public String getErxStatusByPatientChkStatus() {
		return erxStatusByPatientChkStatus;
	}


	public void setErxStatusByPatientChkStatus(String erxStatusByPatientChkStatus) {
		this.erxStatusByPatientChkStatus = erxStatusByPatientChkStatus;
	}


	public String getErxStatusByMessageStatus() {
		return erxStatusByMessageStatus;
	}


	public void setErxStatusByMessageStatus(String erxStatusByMessageStatus) {
		this.erxStatusByMessageStatus = erxStatusByMessageStatus;
	}


	public String getErxStatusByProviderChkStatus() {
		return erxStatusByProviderChkStatus;
	}


	public void setErxStatusByProviderChkStatus(String erxStatusByProviderChkStatus) {
		this.erxStatusByProviderChkStatus = erxStatusByProviderChkStatus;
	}


	public String getErxStatusByDrugChkStatus() {
		return erxStatusByDrugChkStatus;
	}


	public void setErxStatusByDrugChkStatus(String erxStatusByDrugChkStatus) {
		this.erxStatusByDrugChkStatus = erxStatusByDrugChkStatus;
	}


	public String getPharmacy() {
		return pharmacy;
	}


	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}


	public String getMessageId() {
		return messageId;
	}


	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}


	public String getRelToMessageId() {
		return relToMessageId;
	}


	public void setRelToMessageId(String relToMessageId) {
		this.relToMessageId = relToMessageId;
	}


	public String getMessageType() {
		return messageType;
	}


	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}


	public Clob getMessage() {
		return message;
	}


	public void setMessage(Clob message) {
		this.message = message;
	}


	public String getPatientMatchDetails() {
		return patientMatchDetails;
	}


	public void setPatientMatchDetails(String patientMatchDetails) {
		this.patientMatchDetails = patientMatchDetails;
	}


	public String getProviderMatchDetails() {
		return providerMatchDetails;
	}


	public void setProviderMatchDetails(String providerMatchDetails) {
		this.providerMatchDetails = providerMatchDetails;
	}


	public String getDrugMatchDetails() {
		return drugMatchDetails;
	}


	public void setDrugMatchDetails(String drugMatchDetails) {
		this.drugMatchDetails = drugMatchDetails;
	}


	public String getVaStationId() {
		return vaStationId;
	}


	public void setVaStationId(String vaStationId) {
		this.vaStationId = vaStationId;
	}


	public String getDivisionName() {
		return divisionName;
	}


	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}


	public Date getReceivedDate() {
		return receivedDate;
	}


	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public VistaInboundNcpdpMsg() {
	}


	public String getPotencyUnitCode() {
		return potencyUnitCode;
	}


	public void setPotencyUnitCode(String potencyUnitCode) {
		this.potencyUnitCode = potencyUnitCode;
	}


	public String getPotencyUnitText() {
		return potencyUnitText;
	}


	public void setPotencyUnitText(String potencyUnitText) {
		this.potencyUnitText = potencyUnitText;
	}


	public String getDrugForm() {
		return drugForm;
	}


	public void setDrugForm(String drugForm) {
		this.drugForm = drugForm;
	}


	public String getDrugFormText() {
		return drugFormText;
	}


	public void setDrugFormText(String drugFormText) {
		this.drugFormText = drugFormText;
	}


	public String getDrugStrengthCode() {
		return drugStrengthCode;
	}


	public void setDrugStrengthCode(String drugStrengthCode) {
		this.drugStrengthCode = drugStrengthCode;
	}


	public String getDrugStrengthText() {
		return drugStrengthText;
	}


	public void setDrugStrengthText(String drugStrengthText) {
		this.drugStrengthText = drugStrengthText;
	}


	public String getNpi() {
		return npi;
	}


	public void setNpi(String npi) {
		this.npi = npi;
	}


	public String getCancelRxDenied() {
		return cancelRxDenied;
	}


	public void setCancelRxDenied(String cancelRxDenied) {
		this.cancelRxDenied = cancelRxDenied;
	}


	public long getRelToOutboundNcpdpMsgId() {
		return relToOutboundNcpdpMsgId;
	}


	public void setRelToOutboundNcpdpMsgId(long relToOutboundNcpdpMsgId) {
		this.relToOutboundNcpdpMsgId = relToOutboundNcpdpMsgId;
	}


	public String getProhibitRenewalRequest() {
		return prohibitRenewalRequest;
	}


	public void setProhibitRenewalRequest(String prohibitRenewalRequest) {
		this.prohibitRenewalRequest = prohibitRenewalRequest;
	}




	
}
