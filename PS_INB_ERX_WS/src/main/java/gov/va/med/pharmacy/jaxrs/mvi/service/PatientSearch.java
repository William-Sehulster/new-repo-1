package gov.va.med.pharmacy.jaxrs.mvi.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.mvi.model.Patient;
import gov.va.med.pharmacy.jaxrs.mvi.model.PatientSearchResponse;

/**
 * Patient Search interface.
 *
 */
@Consumes("application/json")
@Produces("application/json")
public interface PatientSearch {

	/**
	 * @param request
	 * @return PatientSearchResponse
	 */
	
	public PatientSearchResponse searchPatientByName(Patient patientSearchObj );
}
