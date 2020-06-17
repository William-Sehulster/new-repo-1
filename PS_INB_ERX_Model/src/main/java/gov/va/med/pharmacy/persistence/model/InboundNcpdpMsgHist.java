package gov.va.med.pharmacy.persistence.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "INBOUND_NCPDP_MSG_HIST", schema = "ERX")
public class InboundNcpdpMsgHist implements java.io.Serializable {

	private static final long serialVersionUID = -512719495558080236L;
	
	private Long inboundNcpdpMsgHistId;
	private InboundNcpdpMsg inboundNcpdpMsg;
	private String messageStatus;
	private String patientChkStatus;
	private String providerChkStatus;
	private String drugChkStatus;
	private Long runCnt;
	private Date updatedDate;
	private Date createdDate;

	public InboundNcpdpMsgHist() {
	}

	public InboundNcpdpMsgHist(Long inboundNcpdpMsgHistId, InboundNcpdpMsg inboundNcpdpMsg) {
		this.inboundNcpdpMsgHistId = inboundNcpdpMsgHistId;
		this.inboundNcpdpMsg = inboundNcpdpMsg;
	}

	public InboundNcpdpMsgHist(Long inboundNcpdpMsgHistId, InboundNcpdpMsg inboundNcpdpMsg, String messageStatus,
			String patientChkStatus, String providerChkStatus, String drugChkStatus, Long runCnt,
			Date updatedDate, Date createdDate) {
		this.inboundNcpdpMsgHistId = inboundNcpdpMsgHistId;
		this.inboundNcpdpMsg = inboundNcpdpMsg;
		this.messageStatus = messageStatus;
		this.patientChkStatus = patientChkStatus;
		this.providerChkStatus = providerChkStatus;
		this.drugChkStatus = drugChkStatus;
		this.runCnt = runCnt;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}

	@Id

	@Column(name = "INBOUND_NCPDP_MSG_HIST_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getInboundNcpdpMsgHistId() {
		return this.inboundNcpdpMsgHistId;
	}

	public void setInboundNcpdpMsgHistId(Long inboundNcpdpMsgHistId) {
		this.inboundNcpdpMsgHistId = inboundNcpdpMsgHistId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INBOUND_NCPDP_MSG_ID", nullable = false)
	public InboundNcpdpMsg getInboundNcpdpMsg() {
		return this.inboundNcpdpMsg;
	}

	public void setInboundNcpdpMsg(InboundNcpdpMsg inboundNcpdpMsg) {
		this.inboundNcpdpMsg = inboundNcpdpMsg;
	}

	@Column(name = "MESSAGE_STATUS", length = 4)
	public String getMessageStatus() {
		return this.messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	@Column(name = "PATIENT_CHK_STATUS", length = 4)
	public String getPatientChkStatus() {
		return this.patientChkStatus;
	}

	public void setPatientChkStatus(String patientChkStatus) {
		this.patientChkStatus = patientChkStatus;
	}

	@Column(name = "PROVIDER_CHK_STATUS", length = 4)
	public String getProviderChkStatus() {
		return this.providerChkStatus;
	}

	public void setProviderChkStatus(String providerChkStatus) {
		this.providerChkStatus = providerChkStatus;
	}

	@Column(name = "DRUG_CHK_STATUS", length = 4)
	public String getDrugChkStatus() {
		return this.drugChkStatus;
	}

	public void setDrugChkStatus(String drugChkStatus) {
		this.drugChkStatus = drugChkStatus;
	}

	@Column(name = "RUN_CNT", precision = 22, scale = 0)
	public Long getRunCnt() {
		return this.runCnt;
	}

	public void setRunCnt(Long runCnt) {
		this.runCnt = runCnt;
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

}
