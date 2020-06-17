package gov.va.med.pharmacy.jaxrs.provider.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({""})
public class Provider {
	
	private String providerNPI;
	private String providerDEANumber;
	private String providerFirstName;
	private String providerLastName;
	private String controlledSubstance;
	private String vistaMessage;
	private String vistaIEN;	
	private Boolean success = true;
	private String division;
	
	public String getProviderNPI() {
		return providerNPI;
	}
	public void setProviderNPI(String providerNPI) {
		this.providerNPI = providerNPI;
	}
	public String getProviderDEANumber() {
		return providerDEANumber;
	}
	public void setProviderDEANumber(String providerDEANumber) {
		this.providerDEANumber = providerDEANumber;
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
	public String getControlledSubstance() {
		return controlledSubstance;
	}
	public void setControlledSubstance(String controlledSubstance) {
		this.controlledSubstance = controlledSubstance;
	}
	public String getVistaMessage() {
		return vistaMessage;
	}
	public void setVistaMessage(String vistaMessage) {
		this.vistaMessage = vistaMessage;
	}
	public String getVistaIEN() {
		return vistaIEN;
	}
	public void setVistaIEN(String vistaIEN) {
		this.vistaIEN = vistaIEN;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	

	

}
