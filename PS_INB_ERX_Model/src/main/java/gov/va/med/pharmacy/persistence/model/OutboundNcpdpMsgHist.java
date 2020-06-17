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
@Table(name = "OUTBOUND_NCPDP_MSG_HIST", schema = "ERX")
public class OutboundNcpdpMsgHist implements java.io.Serializable {

	
	private static final long serialVersionUID = 1192333855861203527L;
	
	
	private Long outboundNcpdpMsgHistId;
	private OutboundNcpdpMsg outboundNcpdpMsg;
	private String messageStatus;
	private Long runCnt;
	private Date updatedDate;
	private Date createdDate;

	public OutboundNcpdpMsgHist() {
	}

	public OutboundNcpdpMsgHist(Long outboundNcpdpMsgHistId, OutboundNcpdpMsg outboundNcpdpMsg) {
		this.outboundNcpdpMsgHistId = outboundNcpdpMsgHistId;
		this.outboundNcpdpMsg = outboundNcpdpMsg;
	}

	public OutboundNcpdpMsgHist(Long outboundNcpdpMsgHistId, OutboundNcpdpMsg outboundNcpdpMsg,
			String messageStatus, Long runCnt, Date updatedDate, Date createdDate) {
		this.outboundNcpdpMsgHistId = outboundNcpdpMsgHistId;
		this.outboundNcpdpMsg = outboundNcpdpMsg;
		this.messageStatus = messageStatus;
		this.runCnt = runCnt;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}

	@Id

	@Column(name = "OUTBOUND_NCPDP_MSG_HIST_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public long getOutboundNcpdpMsgHistId() {
		return this.outboundNcpdpMsgHistId;
	}

	public void setOutboundNcpdpMsgHistId(long outboundNcpdpMsgHistId) {
		this.outboundNcpdpMsgHistId = outboundNcpdpMsgHistId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OUTBOUND_NCPDP_MSG_ID", nullable = false)
	public OutboundNcpdpMsg getOutboundNcpdpMsg() {
		return this.outboundNcpdpMsg;
	}

	public void setOutboundNcpdpMsg(OutboundNcpdpMsg outboundNcpdpMsg) {
		this.outboundNcpdpMsg = outboundNcpdpMsg;
	}

	@Column(name = "MESSAGE_STATUS", length = 4)
	public String getMessageStatus() {
		return this.messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
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
