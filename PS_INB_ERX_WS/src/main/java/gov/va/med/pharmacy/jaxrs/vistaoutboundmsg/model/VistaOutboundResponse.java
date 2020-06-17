package gov.va.med.pharmacy.jaxrs.vistaoutboundmsg.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class returns the response to the vista outbound message request.
 *
 */
//@JsonIgnoreProperties({""})
@XmlRootElement
public class VistaOutboundResponse {
	//@XmlElement
	private Boolean success = true;
	//@XmlElement
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
