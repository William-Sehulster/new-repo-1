package gov.va.med.pharmacy.jaxrs.outboundncpdpmessage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class returns the response to the vista outbound message request.
 *
 */
@JsonIgnoreProperties({""})
public class OutboundNCPDPMessageResponse {

	private Boolean success = true;
	private String errorMessage;
	
	
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
	
	

}
