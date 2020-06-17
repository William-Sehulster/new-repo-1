package gov.va.med.pharmacy.jaxrs.provider.dao.impl;

import gov.va.med.pharmacy.jaxrs.provider.dao.ProviderSearchDao;
import gov.va.med.pharmacy.jaxrs.provider.model.Provider;

/**
 * This class acts as Data Access Object layer, calls RPC and does data
 * processing to build up provider object.
 *
 */

public class ProviderSearchDaoImpl implements ProviderSearchDao {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(ProviderSearchDaoImpl.class);
	
	@Override
	public Provider lookupProvider(Provider providerSearchObj) throws Exception {

			
		Provider providerResults = null;
		ProviderRPC providerRPC = new ProviderRPC();

		try {

			providerResults = providerRPC.lookupProvider(providerSearchObj);

		} catch (Exception e) {
			LOG.error("Error in ProviderSearchDaoImpl:"+e.getMessage());
			e.printStackTrace();
			throw new Exception(e); // let the exception go all the way up.
		}

		return providerResults;

	}

}
