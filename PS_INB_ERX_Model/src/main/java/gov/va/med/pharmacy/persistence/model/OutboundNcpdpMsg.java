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
@Table(name = "OUTBOUND_NCPDP_MSG", schema = "ERX")
public class OutboundNcpdpMsg implements java.io.Serializable {

   
	private static final long serialVersionUID = -6565673291000233831L;
	
	private long outboundNcpdpMsgId;
	private ErxStatus erxStatus;
	private Pharmacy pharmacy;
	private String messageId;
	private String relToMessageId;
	private String messageType;
	private Clob message;
	private Date receivedDate;
	private Date updatedDate;
	private Date createdDate;
	private Set<OutboundNcpdpMsgHist> outboundNcpdpMsgHists = new HashSet<OutboundNcpdpMsgHist>(0);

	public OutboundNcpdpMsg() {
	}

	public OutboundNcpdpMsg(long outboundNcpdpMsgId, ErxStatus erxStatus, Pharmacy pharmacy) {
		this.outboundNcpdpMsgId = outboundNcpdpMsgId;
		this.erxStatus = erxStatus;
		this.pharmacy = pharmacy;
	}

	public OutboundNcpdpMsg(long outboundNcpdpMsgId, ErxStatus erxStatus, Pharmacy pharmacy, String messageId,
			String relToMessageId, String messageType, Clob message,  Date receivedDate,
			Date updatedDate, Date createdDate, Set<OutboundNcpdpMsgHist> outboundNcpdpMsgHists) {
		this.outboundNcpdpMsgId = outboundNcpdpMsgId;
		this.erxStatus = erxStatus;
		this.pharmacy = pharmacy;
		this.messageId = messageId;
		this.relToMessageId = relToMessageId;
		this.messageType = messageType;
		this.message = message;
		this.receivedDate = receivedDate;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		this.outboundNcpdpMsgHists = outboundNcpdpMsgHists;
	}

	@Id

	@Column(name = "OUTBOUND_NCPDP_MSG_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public long getOutboundNcpdpMsgId() {
		return this.outboundNcpdpMsgId;
	}

	public void setOutboundNcpdpMsgId(long outboundNcpdpMsgId) {
		this.outboundNcpdpMsgId = outboundNcpdpMsgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MESSAGE_STATUS", nullable = false)
	public ErxStatus getErxStatus() {
		return this.erxStatus;
	}

	public void setErxStatus(ErxStatus erxStatus) {
		this.erxStatus = erxStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PHARMACY_ID", nullable = false)
	public Pharmacy getPharmacy() {
		return this.pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
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

	@Column(name = "MESSAGE")
	public Clob getMessage() {
		return this.message;
	}

	public void setMessage(Clob message) {
		this.message = message;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outboundNcpdpMsg")
	public Set<OutboundNcpdpMsgHist> getOutboundNcpdpMsgHists() {
		return this.outboundNcpdpMsgHists;
	}

	public void setOutboundNcpdpMsgHists(Set<OutboundNcpdpMsgHist> outboundNcpdpMsgHists) {
		this.outboundNcpdpMsgHists = outboundNcpdpMsgHists;
	}

}
