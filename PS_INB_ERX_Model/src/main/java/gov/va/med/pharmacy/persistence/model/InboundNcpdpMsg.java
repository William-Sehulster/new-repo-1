package gov.va.med.pharmacy.persistence.model;


import java.sql.Clob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "INBOUND_NCPDP_MSG", schema = "ERX")
public class InboundNcpdpMsg implements java.io.Serializable {

	private static final long serialVersionUID = -1567611047855137803L;
	
	private long inboundNcpdpMsgId;
	private ErxStatus erxStatusByDrugChkStatus;
	private ErxStatus erxStatusByProviderChkStatus;
	private ErxStatus erxStatusByMessageStatus;
	private Pharmacy pharmacy;
	private ErxStatus erxStatusByPatientChkStatus;
	private String messageId;
	private String relToMessageId;
	private String messageType;
	private String messageFrom;
	private Clob message;
	private String patientMatchDetails;
	private String providerMatchDetails;
	private String drugMatchDetails;
	private Date receivedDate;
	private Date updatedDate;
	private Date createdDate;
	private Set<InboundNcpdpMsgHist> inboundNcpdpMsgHists = new HashSet<InboundNcpdpMsgHist>(0);

	public InboundNcpdpMsg() {
	}

	public InboundNcpdpMsg(long inboundNcpdpMsgId, ErxStatus erxStatusByDrugChkStatus,
			ErxStatus erxStatusByProviderChkStatus, ErxStatus erxStatusByMessageStatus, Pharmacy pharmacy,
			ErxStatus erxStatusByPatientChkStatus) {
		this.inboundNcpdpMsgId = inboundNcpdpMsgId;
		this.erxStatusByDrugChkStatus = erxStatusByDrugChkStatus;
		this.erxStatusByProviderChkStatus = erxStatusByProviderChkStatus;
		this.erxStatusByMessageStatus = erxStatusByMessageStatus;
		this.pharmacy = pharmacy;
		this.erxStatusByPatientChkStatus = erxStatusByPatientChkStatus;
	}

	public InboundNcpdpMsg(long inboundNcpdpMsgId, ErxStatus erxStatusByDrugChkStatus,
			ErxStatus erxStatusByProviderChkStatus, ErxStatus erxStatusByMessageStatus, Pharmacy pharmacy,
			ErxStatus erxStatusByPatientChkStatus, String messageId, String relToMessageId, String messageType,
			String messageFrom, Clob message, String patientMatchDetails, String providerMatchDetails,
			String drugMatchDetails, Date receivedDate, Date updatedDate, Date createdDate,
			Set<InboundNcpdpMsgHist> inboundNcpdpMsgHists) {
		this.inboundNcpdpMsgId = inboundNcpdpMsgId;
		this.erxStatusByDrugChkStatus = erxStatusByDrugChkStatus;
		this.erxStatusByProviderChkStatus = erxStatusByProviderChkStatus;
		this.erxStatusByMessageStatus = erxStatusByMessageStatus;
		this.pharmacy = pharmacy;
		this.erxStatusByPatientChkStatus = erxStatusByPatientChkStatus;
		this.messageId = messageId;
		this.relToMessageId = relToMessageId;
		this.messageType = messageType;
		this.messageFrom = messageFrom;
		this.message = message;
		this.patientMatchDetails = patientMatchDetails;
		this.providerMatchDetails = providerMatchDetails;
		this.drugMatchDetails = drugMatchDetails;
		this.receivedDate = receivedDate;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		this.inboundNcpdpMsgHists = inboundNcpdpMsgHists;
	}

	@Id

	@Column(name = "INBOUND_NCPDP_MSG_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public long getInboundNcpdpMsgId() {
		return this.inboundNcpdpMsgId;
	}

	public void setInboundNcpdpMsgId(long inboundNcpdpMsgId) {
		this.inboundNcpdpMsgId = inboundNcpdpMsgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DRUG_CHK_STATUS", nullable = false)
	public ErxStatus getErxStatusByDrugChkStatus() {
		return this.erxStatusByDrugChkStatus;
	}

	public void setErxStatusByDrugChkStatus(ErxStatus erxStatusByDrugChkStatus) {
		this.erxStatusByDrugChkStatus = erxStatusByDrugChkStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROVIDER_CHK_STATUS", nullable = false)
	public ErxStatus getErxStatusByProviderChkStatus() {
		return this.erxStatusByProviderChkStatus;
	}

	public void setErxStatusByProviderChkStatus(ErxStatus erxStatusByProviderChkStatus) {
		this.erxStatusByProviderChkStatus = erxStatusByProviderChkStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MESSAGE_STATUS", nullable = false)
	public ErxStatus getErxStatusByMessageStatus() {
		return this.erxStatusByMessageStatus;
	}

	public void setErxStatusByMessageStatus(ErxStatus erxStatusByMessageStatus) {
		this.erxStatusByMessageStatus = erxStatusByMessageStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PHARMACY_ID", nullable = false)
	public Pharmacy getPharmacy() {
		return this.pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_CHK_STATUS", nullable = false)
	public ErxStatus getErxStatusByPatientChkStatus() {
		return this.erxStatusByPatientChkStatus;
	}

	public void setErxStatusByPatientChkStatus(ErxStatus erxStatusByPatientChkStatus) {
		this.erxStatusByPatientChkStatus = erxStatusByPatientChkStatus;
	}

	@Column(name = "MESSAGE_ID", length = 35)
	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Column(name = "REL_TO_MESSAGE_ID", length = 35)
	public String getRelToMessageId() {
		return this.relToMessageId;
	}

	public void setRelToMessageId(String relToMessageId) {
		this.relToMessageId = relToMessageId;
	}

	@Column(name = "MESSAGE_TYPE", length = 35)
	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Column(name = "MESSAGE_FROM", length = 35)
	public String getMessageFrom() {
		return this.messageFrom;
	}

	public void setMessageFrom(String messageFrom) {
		this.messageFrom = messageFrom;
	}

	@Column(name = "MESSAGE")
	public Clob getMessage() {
		return this.message;
	}

	public void setMessage(Clob message) {
		this.message = message;
	}

	@Column(name = "PATIENT_MATCH_DETAILS", length = 2000)
	public String getPatientMatchDetails() {
		return this.patientMatchDetails;
	}

	public void setPatientMatchDetails(String patientMatchDetails) {
		this.patientMatchDetails = patientMatchDetails;
	}

	@Column(name = "PROVIDER_MATCH_DETAILS", length = 2000)
	public String getProviderMatchDetails() {
		return this.providerMatchDetails;
	}

	public void setProviderMatchDetails(String providerMatchDetails) {
		this.providerMatchDetails = providerMatchDetails;
	}

	@Column(name = "DRUG_MATCH_DETAILS", length = 2000)
	public String getDrugMatchDetails() {
		return this.drugMatchDetails;
	}

	public void setDrugMatchDetails(String drugMatchDetails) {
		this.drugMatchDetails = drugMatchDetails;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RECEIVED_DATE", length = 7)
	public Date getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", length = 7)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inboundNcpdpMsg")
	public Set<InboundNcpdpMsgHist> getInboundNcpdpMsgHists() {
		return this.inboundNcpdpMsgHists;
	}

	public void setInboundNcpdpMsgHists(Set<InboundNcpdpMsgHist> inboundNcpdpMsgHists) {
		this.inboundNcpdpMsgHists = inboundNcpdpMsgHists;
	}

}
