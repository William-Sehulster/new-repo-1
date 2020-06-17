package gov.va.med.pharmacy.jaxrs.mvi.dao.impl;

import gov.va.med.pharmacy.jaxrs.mvi.dao.PatientSearchDao;
import gov.va.med.pharmacy.jaxrs.mvi.model.Patient;

/**
 * This class acts as Data Access Object layer, calls MVI client and does data
 * processing to build up patient object.
 *
 */

public class PatientSearchDaoImpl implements PatientSearchDao {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(PatientSearchDaoImpl.class);
	
	@Override
	public Patient lookupPatientByName(Patient patientSearchObj) throws Exception {


		MVIClient mviClient = new MVIClient();
		
		Patient patientResults;

		try {

			patientResults = mviClient.getMVIData(patientSearchObj);

		} catch (Exception e) {
			LOG.error("Error in PatientSearchDaoImpl:"+e.getMessage());
			
			throw new Exception(e); // let the exception go all the way up.
		}

		return patientResults;

	}

}
