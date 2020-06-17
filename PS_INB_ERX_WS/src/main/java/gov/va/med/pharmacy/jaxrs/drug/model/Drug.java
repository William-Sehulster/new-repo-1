package gov.va.med.pharmacy.jaxrs.drug.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({""})
public class Drug {
	
	private String ndcUPN;
	private String drugDescription;
	private String vistaMessage;
	private String vistaIEN;	
	private Boolean success = true;
	private String division;

	
	public String getNdcUPN() {
		return ndcUPN;
	}
	public void setNdcUPN(String ndcUPN) {
		this.ndcUPN = ndcUPN;
	}
	public String getDrugDescription() {
		return drugDescription;
	}
	public void setDrugDescription(String drugDescription) {
		this.drugDescription = drugDescription;
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
