package gov.va.med.pharmacy.jaxrs.eAnde.services.impl;

import gov.va.med.pharmacy.jaxrs.eAnde.dao.PatientInfoDao;
import gov.va.med.pharmacy.jaxrs.eAnde.model.PatientInfo;
import gov.va.med.pharmacy.jaxrs.eAnde.model.PatientInfoRequest;
import gov.va.med.pharmacy.jaxrs.eAnde.model.PatientInfoResponse;
import gov.va.med.pharmacy.jaxrs.eAnde.services.PatientInfoManager;
import gov.va.med.pharmacy.jaxrs.mvi.dao.impl.PatientSearchDaoImpl;

public class PatientInfoService implements PatientInfoManager {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(PatientSearchDaoImpl.class);	
	
private PatientInfoDao patientInfoDao;
private PatientInfo patientInfo;

public PatientInfoDao getPatientInfoDao() {
	return patientInfoDao;
}

public void setPatientInfoDao(PatientInfoDao patientInfoDao) {
	this.patientInfoDao = patientInfoDao;
} 

public void setPatientInfo(PatientInfo patientInfo) {
	this.patientInfo = patientInfo;
} 


public PatientInfoResponse fetchEligibilityStatusByKey(PatientInfoRequest request) {
	   PatientInfoResponse response = new PatientInfoResponse();
	   try
	   {
		  // response.setEligibilityStatus("VERIFIED");
		   
		   this.setPatientInfo(getPatientInfoDao().lookupPatientByKey(request.getPatientInfo().getKey()));
		   
		   response.setEligibilityStatus(patientInfo.getEligibilityStatus());
		   response.setEnrollmentStatus(patientInfo.getEnrollmentStatus());

		  // response.setEligibilityStatus(getPatientInfoDao().lookupPatientByKey(
		  // request.getPatientInfo().getKey()).getEligibilityStatus());
		  
		  // response.setEnrollmentStatus(getPatientInfoDao().lookupPatientByKey(
		   //request.getPatientInfo().getKey()).getEnrollmentStatus());
	   }
	   catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
			
			LOG.error("Error in PatientSearchImpl:"+e.getMessage());		
			
			return response;
		}

	return response;
}


}
