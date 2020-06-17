package gov.va.med.pharmacy.jaxrs.mvi.dao;

import gov.va.med.pharmacy.jaxrs.mvi.model.Patient;

public interface PatientSearchDao {

	/**
	 * Search Patients by first name and last name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return Patient
	 * @throws Exception
	 */
	public Patient lookupPatientByName(Patient patientObj) throws Exception;
}
