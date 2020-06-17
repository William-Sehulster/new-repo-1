package gov.va.med.pharmacy.jaxrs.eAnde.dao.impl;
import gov.va.med.pharmacy.jaxrs.eAnde.dao.PatientInfoDao;
import gov.va.med.pharmacy.jaxrs.eAnde.model.PatientInfo;
import gov.va.med.pharmacy.jaxrs.eAnde.services.impl.EESummary_Client;
import gov.va.med.pharmacy.wsclients.eAnde.getEESummaryResponse;


public class PatientInfoWSDao implements PatientInfoDao {
	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(PatientInfoWSDao.class);
	
	@Override
	public PatientInfo lookupPatientByKey(String key) throws Exception {
		PatientInfo patientInfo = new PatientInfo();
		EESummary_Client eeClient = new EESummary_Client();
		
	try {
			getEESummaryResponse  eeSummaryResponse = eeClient.returnResponse(key);
		
			  if (eeSummaryResponse != null && eeSummaryResponse.getSummary()!=null){
				patientInfo.setEligibilityStatus(eeSummaryResponse.getSummary().getEligibilityVerificationInfo().getEligibilityStatus());
				patientInfo.setEnrollmentStatus(eeSummaryResponse.getSummary().getEnrollmentDeterminationInfo().getEnrollmentStatus());
			}
	
		} catch (Exception e) {
			
			LOG.error("Error in PatientInfoWSDao:"+e.getMessage());
			
			throw new Exception(e); // let the exception go all the way up.
		}
		
		return patientInfo;
	}
}
