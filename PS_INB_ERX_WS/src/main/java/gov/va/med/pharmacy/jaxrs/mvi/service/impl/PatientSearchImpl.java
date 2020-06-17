package gov.va.med.pharmacy.jaxrs.mvi.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.mvi.dao.impl.PatientSearchDaoImpl;
import gov.va.med.pharmacy.jaxrs.mvi.model.Patient;
import gov.va.med.pharmacy.jaxrs.mvi.model.PatientSearchResponse;
import gov.va.med.pharmacy.jaxrs.mvi.service.PatientSearch;

/**
 * A class that implement patient search by taking different search paramters
 * and calls MVI Web Service and sends response back in JSON.
 *
 */
@Path("/patientSearch")
@Consumes("application/json")
@Produces("application/json")
public class PatientSearchImpl implements PatientSearch {

	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(PatientSearchImpl.class);
	
	/*
	 * private PatientSearchDao patientLookupDAO;
	 * 
	 * 
	 * public PatientSearchDao getPatientLookupDAO() { return patientLookupDAO;
	 * }
	 * 
	 * @Autowired public void setPatientLookupDAO(PatientSearchDao
	 * patientLookupDAO) { this.patientLookupDAO = patientLookupDAO; }
	 */
	
	

	@POST
	@Path("/lookupPatientByName/")
	public PatientSearchResponse searchPatientByName(Patient patientSearchObj) {

		PatientSearchResponse searchResponse = new PatientSearchResponse();

		try {

			

			// Patient searchResults =
			// patientLookupDAO.lookupPatientByName(patientSearchObj);

			PatientSearchDaoImpl patientLookupDAO = new PatientSearchDaoImpl();

			Patient searchResults = patientLookupDAO.lookupPatientByName(patientSearchObj);

			String queryReturnCode = searchResults.getQueryReturnCode();

			switch (queryReturnCode) {
			case "OK":

				searchResponse.setPatientFirstName(searchResults.getFirstName());
				
				searchResponse.setPatientMiddleName(searchResults.getMiddleName());
				
				searchResponse.setPatientLastName(searchResults.getLastName());

				searchResponse.setPatientICN(searchResults.getICN());

				searchResponse.setPatientSocSecNum(searchResults.getSocSecNum());
				
				searchResponse.setPatientDateOfBirth(searchResults.getDateOfBirth());
				
				searchResponse.setPatientStationIds(searchResults.getStationIds());

				searchResponse.setSuccess(true);
				break;
			case "AE":
				searchResponse.setSuccess(false);
				searchResponse.setErrorMessage("Error while searching patient: Application Error");
				break;
			case "QE":
				searchResponse.setSuccess(false);
				searchResponse.setErrorMessage("Error while searching patient: Query Error");
				break;
			case "NF":
				searchResponse.setSuccess(false);
				searchResponse.setErrorMessage("Error while searching patient: No Record Found");
				break;
			default:
				break;
			}

		} catch (Exception e) {
			LOG.error("Error in PatientSearchImpl:"+e.getMessage());
			
			searchResponse.setSuccess(false);

			searchResponse.setErrorMessage("Error while searching patient: " + e.getMessage());
		}

		return searchResponse;
	}

}
