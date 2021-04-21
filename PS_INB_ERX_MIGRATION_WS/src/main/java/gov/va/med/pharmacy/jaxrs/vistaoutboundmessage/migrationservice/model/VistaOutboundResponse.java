package gov.va.med.pharmacy.jaxrs.vistaoutboundmessage.migrationservice.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class returns the response to the vista outbound message request.
 *
 */
@XmlRootElement
public class VistaOutboundResponse {	
	private Boolean success = true;
	
	private String errorMessage;
	
	private long outboundMsgId = 0 ;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public long getOutboundMsgId() {
		return outboundMsgId;
	}
	public void setOutboundMsgId(long outboundMsgId) {
		this.outboundMsgId = outboundMsgId;
	}
	
	
	

}
