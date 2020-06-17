package gov.va.med.pharmacy.jaxrs.drug.dao;

import gov.va.med.pharmacy.jaxrs.drug.model.Drug;

public interface DrugSearchDao {

	
	/**
	 * @param drugObj
	 * @return
	 * @throws Exception
	 */
	public Drug lookupDrug(Drug drugObj) throws Exception;
}
