package gov.va.med.pharmacy.jaxrs.tovista.model;

/**
 * This class returns the response to the message send request.
 *
 */
public class VistaInboundResponse {

	private Boolean success = true;
	private String errorMessage;
	private String vistaMessage;
	
	
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
	public String getVistaMessage() {
		return vistaMessage;
	}
	public void setVistaMessage(String vistaMessage) {
		this.vistaMessage = vistaMessage;
	}
	
	
	

}
