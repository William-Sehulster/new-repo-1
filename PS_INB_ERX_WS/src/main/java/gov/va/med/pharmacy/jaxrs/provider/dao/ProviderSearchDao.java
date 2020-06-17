package gov.va.med.pharmacy.jaxrs.provider.dao;

import gov.va.med.pharmacy.jaxrs.provider.model.Provider;

public interface ProviderSearchDao {

	
	/**	 * Search Provider by their details
	 * 
	 * @param providerObj
	 * @return Provider
	 * @throws Exception
	 */
	public Provider lookupProvider(Provider providerObj) throws Exception;
}
