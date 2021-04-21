package gov.va.med.pharmacy.persistence.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import gov.va.med.pharmacy.persistence.model.usertypes.OutboundNcpdpMsgUserType;
import gov.va.med.pharmacy.ncpdpmsgs.MessageType;


@Entity(name = "OutboundNcpdpMsgEntity")
@TypeDef(name = "MessageType", typeClass = OutboundNcpdpMsgUserType.class)
@Table(name = "OUTBOUND_NCPDP_MSG", schema = "ERX")
public class OutboundNcpdpMsgEntity implements java.io.Serializable {


	
	private static final long serialVersionUID = -4277236723847807744L;

	@Id	
	@SequenceGenerator(name="OB_MSG_SEQ_GEN", sequenceName="ERX.OB_NCPDP_MSG_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OB_MSG_SEQ_GEN")	
	@Column(name = "OUTBOUND_NCPDP_MSG_ID", unique = true, nullable = false, precision = 22, scale = 0)
	private long outboundNcpdpMsgId;
	
	@Column(name = "MESSAGE_STATUS", nullable = false)
	private String erxStatus;
	
	@Column(name = "PHARMACY_ID", nullable = false)
	private long pharmacyId;
	
	@Column(name = "MESSAGE_ID", length = 35)
	private String messageId;
	
	@Column(name = "REL_TO_MESSAGE_ID", length = 35)
	private String relToMessageId;
	
	@Column(name = "MESSAGE_TYPE", length = 35)
	private String messageType;
	
	@Type(type = "gov.va.med.pharmacy.persistence.model.usertypes.OutboundNcpdpMsgUserType") 
	@Column(name = "MESSAGE")
	private MessageType message;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "RECEIVED_DATE", length = 7)
	private Date receivedDate;	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	private Date updatedDate;	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", length = 7)
	private Date createdDate;
	
	@Column(name = "SCRIPT_VERSION", length = 10)
	private String scriptVersion;

	public OutboundNcpdpMsgEntity() {
	}

	public OutboundNcpdpMsgEntity(long outboundNcpdpMsgId, String erxStatus, long pharmacyId) {
		this.outboundNcpdpMsgId = outboundNcpdpMsgId;
		this.erxStatus = erxStatus;
		this.pharmacyId = pharmacyId;
	}

	public OutboundNcpdpMsgEntity(long outboundNcpdpMsgId, String erxStatus, long pharmacyId, String messageId,
			String relToMessageId, String messageType, MessageType message, Date receivedDate,
			Date updatedDate, Date createdDate, String scriptVersion ) {
		this.outboundNcpdpMsgId = outboundNcpdpMsgId;
		this.erxStatus = erxStatus;
		this.pharmacyId = pharmacyId;
		this.messageId = messageId;
		this.relToMessageId = relToMessageId;
		this.messageType = messageType;
		this.message = message;
		this.receivedDate = receivedDate;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
		this.scriptVersion = scriptVersion;
	}

	
	public long getOutboundNcpdpMsgId() {
		return this.outboundNcpdpMsgId;
	}

	public void setOutboundNcpdpMsgId(long outboundNcpdpMsgId) {
		this.outboundNcpdpMsgId = outboundNcpdpMsgId;
	}
	
	
	public String getErxStatus() {
		return this.erxStatus;
	}

	public void setErxStatus(String erxStatus) {
		this.erxStatus = erxStatus;
	}

	
	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	
	public String getRelToMessageId() {
		return this.relToMessageId;
	}

	public void setRelToMessageId(String relToMessageId) {
		this.relToMessageId = relToMessageId;
	}

	
	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	
	public MessageType getMessage() {
		return this.message;
	}

	public void setMessage(MessageType message) {
		this.message = message;
	}

		
	public Date getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}


	public String getScriptVersion() {
		return this.scriptVersion;
	}

	public void setScriptVersion(String scriptVersion) {
		this.scriptVersion = scriptVersion;
	}
}
