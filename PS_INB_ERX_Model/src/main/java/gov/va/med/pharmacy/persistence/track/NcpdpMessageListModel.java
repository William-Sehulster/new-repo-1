package gov.va.med.pharmacy.persistence.track;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class NcpdpMessageListModel {
	
	private Long inboundNcpdpMsgId;
	private String rxMessageId;
	private String relToMessageid;
	private String messageType;
	private String receivedDate;
	private String pharmacyName;
	private String pharmacyAddr1;
	private String prescriberName;
	private String prescriberAddr1;
	private String patientName;
	private String rxDrugPrescribed;
	private String errorMessage;
	private String patient_chk_status;
	private String provider_chk_status;
	private String drug_chk_status;
	private String message_status;
	private Integer visn;
	private String vaStationId;
	private String prescriberNpi;
	private String prescriberDEA;
	private String patientDob;
	private String patientSsn;
	
	
	public Number getInboundNcpdpMsgId() {
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
	
	public String getPrescriberAddr1() {
		return prescriberAddr1;
	}
	public void setPrescriberAddr1(String prescriberAddr1) {
		this.prescriberAddr1 = prescriberAddr1;
	}

	public String getRxDrugPrescribed() {
		return rxDrugPrescribed;
	}
	public void setRxDrugPrescribed(String rxDrugPrescribed) {
		this.rxDrugPrescribed = rxDrugPrescribed;
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
	public String getPrescriberName() {
		return prescriberName;
	}
	public void setPrescriberName(String prescriberName) {
		this.prescriberName = prescriberName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Integer getVisn() {
		return visn;
	}
	public void setVisn(Integer visn) {
		this.visn = visn;
	}
	public String getVaStationId() {
		return vaStationId;
	}
	public void setVaStationId(String vaStationId) {
		this.vaStationId = vaStationId;
	}
	public String getPrescriberNpi() {
		return prescriberNpi;
	}
	public void setPrescriberNpi(String prescriberNpi) {
		this.prescriberNpi = prescriberNpi;
	}
	public String getPatientDob() {
		return patientDob;
	}
	public void setPatientDob(String patientDob) {
		this.patientDob = patientDob;
	}
	public String getPatientSsn() {
		return patientSsn;
	}
	public void setPatientSsn(String patientSsn) {
		this.patientSsn = patientSsn;
	}
	
	public String getPrescriberDEA() {
		return prescriberDEA;
	}
	public void setPrescriberDEA(String prescriberDEA) {
		this.prescriberDEA = prescriberDEA;
	}
	
	// for CSV, order must match the order of headers for csv.
	
		public String[] getStringArray(){

			if (this.getInboundNcpdpMsgId() != null){
				String[] stringArray = {this.getInboundNcpdpMsgId().toString(),
						this.getMessageType(),
						this.getPatientName(),
						this.getPatientDob(),
						this.getPatientSsn(),
						this.getRxDrugPrescribed(),
						this.getRxMessageId(),
						this.getPrescriberName(),
						this.getPrescriberNpi(),
						this.getPrescriberDEA(),
						this.getVisn().toString(),
						this.getVaStationId(),
						this.getPharmacyName(),
						this.getPharmacyAddr1(),			
						this.getRelToMessageid(),				
						this.getReceivedDate(),				
						this.getPatient_chk_status(),
						this.getProvider_chk_status(),
						this.getDrug_chk_status(),
						this.getMessage_status() };
				return stringArray;
			} else
			{
				String[] stringArray = {"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"",
						"" };
				return stringArray;
			}

		}
		
	
		
}
