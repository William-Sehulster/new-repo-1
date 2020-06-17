package gov.va.med.pharmacy.web;

import java.util.List;

public class ResponseMessage implements java.io.Serializable {

	
	private static final long serialVersionUID = 7000446237176368510L;
	

	private String successMessage;
	
	private List<String> errorMessage;

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public List<String> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
}
