package gov.va.med.pharmacy.jaxrs.provider.model;

/**
 * This class returns the response to the provider search request.
 *
 */
public class ProviderSearchResponse {

	private Boolean success = true;
	private String errorMessage;
	private String providerFirstName;
	private String providerLastName;
	private String vistaIEN;
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
	public String getProviderFirstName() {
		return providerFirstName;
	}
	public void setProviderFirstName(String providerFirstName) {
		this.providerFirstName = providerFirstName;
	}
	public String getProviderLastName() {
		return providerLastName;
	}
	public void setProviderLastName(String providerLastName) {
		this.providerLastName = providerLastName;
	}
	public String getVistaIEN() {
		return vistaIEN;
	}
	public void setVistaIEN(String vistaIEN) {
		this.vistaIEN = vistaIEN;
	}
	public String getVistaMessage() {
		return vistaMessage;
	}
	public void setVistaMessage(String vistaMessage) {
		this.vistaMessage = vistaMessage;
	}

	
	

}
