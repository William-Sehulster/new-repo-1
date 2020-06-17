package gov.va.med.pharmacy.persistence.report;

import javax.persistence.Entity;

@Entity
public class SummaryReportsModel implements java.io.Serializable {

	private static final long serialVersionUID = -9008770123720171913L;
	// names should be same as those in the javascript.
	private String pharmacy;
	
	private String address;
	
	private String numberFailed;
	
	private String numberPassed;
	
	private String rejectedBy;
	
	private String numberErrors;
	
	private String status;
	
	// station id and might need to be removed.
	private String stationID;

	public String getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberFailed() {
		return numberFailed;
	}

	public void setNumberFailed(String numberFailed) {
		this.numberFailed = numberFailed;
	}

	public String getNumberPassed() {
		return numberPassed;
	}

	public void setNumberPassed(String numberPassed) {
		this.numberPassed = numberPassed;
	}

	public String getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public String getNumberErrors() {
		return numberErrors;
	}

	public void setNumberErrors(String numberErrors) {
		this.numberErrors = numberErrors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStationID() {
		return stationID;
	}

	public void setStationID(String stationID) {
		this.stationID = stationID;
	}


	

	
	
}
