package gov.va.med.pharmacy.persistence.model;
// Generated Jun 16, 2017 9:22:27 PM by Hibernate Tools 4.0.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "ERX_STATUS", schema = "ERX")
public class ErxStatus implements java.io.Serializable {


	private static final long serialVersionUID = -4056428032377864955L;
	
	
	private String code;
	private String autoCheck;
	private String codeDescription;
	private Date updatedDate;
	private Date createdDate;
	private Set<InboundNcpdpMsg> inboundNcpdpMsgsForPatientChkStatus = new HashSet<InboundNcpdpMsg>(0);
	private Set<InboundNcpdpMsg> inboundNcpdpMsgsForMessageStatus = new HashSet<InboundNcpdpMsg>(0);
	private Set<InboundNcpdpMsg> inboundNcpdpMsgsForProviderChkStatus = new HashSet<InboundNcpdpMsg>(0);
	private Set<OutboundNcpdpMsg> outboundNcpdpMsgs = new HashSet<OutboundNcpdpMsg>(0);
	private Set<InboundNcpdpMsg> inboundNcpdpMsgsForDrugChkStatus = new HashSet<InboundNcpdpMsg>(0);

	public ErxStatus() {
	}

	public ErxStatus(String code) {
		this.code = code;
	}

	public ErxStatus(String code, String autoCheck, String codeDescription, Date updatedDate, Date createdDate,
			Set<InboundNcpdpMsg> inboundNcpdpMsgsForPatientChkStatus,
			Set<InboundNcpdpMsg> inboundNcpdpMsgsForMessageStatus,
			Set<InboundNcpdpMsg> inboundNcpdpMsgsForProviderChkStatus, Set<OutboundNcpdpMsg> outboundNcpdpMsgs,
			Set<InboundNcpdpMsg> inboundNcpdpMsgsForDrugChkStatus) {
		this.code = code;
		this.autoCheck = autoCheck;
		this.codeDescription = codeDescription;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		this.inboundNcpdpMsgsForPatientChkStatus = inboundNcpdpMsgsForPatientChkStatus;
		this.inboundNcpdpMsgsForMessageStatus = inboundNcpdpMsgsForMessageStatus;
		this.inboundNcpdpMsgsForProviderChkStatus = inboundNcpdpMsgsForProviderChkStatus;
		this.outboundNcpdpMsgs = outboundNcpdpMsgs;
		this.inboundNcpdpMsgsForDrugChkStatus = inboundNcpdpMsgsForDrugChkStatus;
	}

	@Id

	@Column(name = "CODE", unique = true, nullable = false, length = 4)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "AUTO_CHECK", length = 15)
	public String getAutoCheck() {
		return this.autoCheck;
	}

	public void setAutoCheck(String autoCheck) {
		this.autoCheck = autoCheck;
	}

	@Column(name = "CODE_DESCRIPTION", length = 70)
	public String getCodeDescription() {
		return this.codeDescription;
	}

	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "erxStatusByPatientChkStatus")
	public Set<InboundNcpdpMsg> getInboundNcpdpMsgsForPatientChkStatus() {
		return this.inboundNcpdpMsgsForPatientChkStatus;
	}

	public void setInboundNcpdpMsgsForPatientChkStatus(Set<InboundNcpdpMsg> inboundNcpdpMsgsForPatientChkStatus) {
		this.inboundNcpdpMsgsForPatientChkStatus = inboundNcpdpMsgsForPatientChkStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "erxStatusByMessageStatus")
	public Set<InboundNcpdpMsg> getInboundNcpdpMsgsForMessageStatus() {
		return this.inboundNcpdpMsgsForMessageStatus;
	}

	public void setInboundNcpdpMsgsForMessageStatus(Set<InboundNcpdpMsg> inboundNcpdpMsgsForMessageStatus) {
		this.inboundNcpdpMsgsForMessageStatus = inboundNcpdpMsgsForMessageStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "erxStatusByProviderChkStatus")
	public Set<InboundNcpdpMsg> getInboundNcpdpMsgsForProviderChkStatus() {
		return this.inboundNcpdpMsgsForProviderChkStatus;
	}

	public void setInboundNcpdpMsgsForProviderChkStatus(Set<InboundNcpdpMsg> inboundNcpdpMsgsForProviderChkStatus) {
		this.inboundNcpdpMsgsForProviderChkStatus = inboundNcpdpMsgsForProviderChkStatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "erxStatus")
	public Set<OutboundNcpdpMsg> getOutboundNcpdpMsgs() {
		return this.outboundNcpdpMsgs;
	}

	public void setOutboundNcpdpMsgs(Set<OutboundNcpdpMsg> outboundNcpdpMsgs) {
		this.outboundNcpdpMsgs = outboundNcpdpMsgs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "erxStatusByDrugChkStatus")
	public Set<InboundNcpdpMsg> getInboundNcpdpMsgsForDrugChkStatus() {
		return this.inboundNcpdpMsgsForDrugChkStatus;
	}

	public void setInboundNcpdpMsgsForDrugChkStatus(Set<InboundNcpdpMsg> inboundNcpdpMsgsForDrugChkStatus) {
		this.inboundNcpdpMsgsForDrugChkStatus = inboundNcpdpMsgsForDrugChkStatus;
	}

}
