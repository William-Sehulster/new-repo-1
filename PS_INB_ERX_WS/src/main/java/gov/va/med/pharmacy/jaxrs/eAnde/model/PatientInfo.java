package gov.va.med.pharmacy.jaxrs.eAnde.model;

public class PatientInfo {
	private String key;
	private String eligibilityStatus;
	private String enrollmentStatus;


public String getEligibilityStatus() {
		return eligibilityStatus;
	}

public void setEligibilityStatus(String eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}

public String getEnrollmentStatus() {
	return enrollmentStatus;
}

public void setEnrollmentStatus(String enrollmentStatus) {
	this.enrollmentStatus = enrollmentStatus;
}

public void setKey(String key) {
		this.key = key;
	}

public String getKey() {
	return key;
}

}
