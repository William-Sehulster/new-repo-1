package gov.va.med.pharmacy.jaxrs.mvi.service;

/**
 * This class represents patient search request.
 *
 */
public class PatientSearchRequest {

	private Patient patientsearch;

	public Patient getPatientsearch() {
		return patientsearch;
	}

	public void setPatientsearch(Patient patientsearch) {
		this.patientsearch = patientsearch;
	}
	
	
}
