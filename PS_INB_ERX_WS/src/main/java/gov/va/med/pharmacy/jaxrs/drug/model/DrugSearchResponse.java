package gov.va.med.pharmacy.jaxrs.drug.model;

/**
 * This class returns the response to the drug search request.
 *
 */
public class DrugSearchResponse {

	private Boolean success = true;
	private String errorMessage;
	private String drugDescription;	
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
	public String getDrugDescription() {
		return drugDescription;
	}
	public void setDrugDescription(String drugDescription) {
		this.drugDescription = drugDescription;
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
