package gov.va.med.pharmacy.jaxrs.tovista.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class represents the request/response message data.
 *
 */
@JsonIgnoreProperties({""})
public class VistaInbound {
	
	private long xmlInboundMessageId;
	private String xmlMessage;
	private String providerCheck;
	private String patientCheck;
	private String drugCheck;
	private String from;
	private String messageId;
	private String relatesToMessageId;
	private String vistaMessage;
	private Boolean success = true;
	private String division;

	
	public long getxmlInboundMessageId() {
		return xmlInboundMessageId;
	}
	public void setxmlInboundMessageId(long xmlInboundMessageId) {
		this.xmlInboundMessageId = xmlInboundMessageId;
	}	
	public String getProviderCheck() {
		return providerCheck;
	}
	public void setProviderCheck(String providerCheck) {
		this.providerCheck = providerCheck;
	}
	public String getPatientCheck() {
		return patientCheck;
	}
	public void setPatientCheck(String patientCheck) {
		this.patientCheck = patientCheck;
	}
	public String getDrugCheck() {
		return drugCheck;
	}
	public void setDrugCheck(String drugCheck) {
		this.drugCheck = drugCheck;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getRelatesToMessageId() {
		return relatesToMessageId;
	}
	public void setRelatesToMessageId(String relatesToMessageId) {
		this.relatesToMessageId = relatesToMessageId;
	}
	public String getVistaMessage() {
		return vistaMessage;
	}
	public void setVistaMessage(String vistaMessage) {
		this.vistaMessage = vistaMessage;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getXmlMessage() {
		return xmlMessage;
	}
	public void setXmlMessage(String xmlMessage) {
		this.xmlMessage = xmlMessage;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	

	

}
