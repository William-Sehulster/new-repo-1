package gov.va.med.pharmacy.jaxrs.eAnde.dao;

import gov.va.med.pharmacy.jaxrs.eAnde.model.PatientInfo;

public interface PatientInfoDao {

	public PatientInfo lookupPatientByKey(String key) throws Exception;
}
