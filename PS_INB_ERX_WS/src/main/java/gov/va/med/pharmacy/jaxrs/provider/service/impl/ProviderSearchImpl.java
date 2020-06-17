package gov.va.med.pharmacy.jaxrs.provider.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.provider.dao.impl.ProviderSearchDaoImpl;
import gov.va.med.pharmacy.jaxrs.provider.model.Provider;
import gov.va.med.pharmacy.jaxrs.provider.model.ProviderSearchResponse;
import gov.va.med.pharmacy.jaxrs.provider.service.ProviderSearch;

/**
 * A class that implement provider search by taking different search parameters
 * and calls Vista RPC for provider query and sends response back in JSON.
 *
 */

@Consumes("application/json")
@Produces("application/json")
public class ProviderSearchImpl implements ProviderSearch {

	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(ProviderSearchImpl.class);
	
	@POST
	@Path("/searchProvider/")
	public ProviderSearchResponse search(Provider providerSearchObj) {

		ProviderSearchResponse searchResponse = new ProviderSearchResponse();

		try {


			ProviderSearchDaoImpl providerLookupDAO = new ProviderSearchDaoImpl();

			Provider searchResults = providerLookupDAO.lookupProvider(providerSearchObj);

			searchResponse.setProviderFirstName(searchResults.getProviderFirstName());
			
			searchResponse.setProviderLastName(searchResults.getProviderLastName());

			searchResponse.setVistaMessage(searchResults.getVistaMessage());
			
			searchResponse.setVistaIEN(searchResults.getVistaIEN());
			
			searchResponse.setVistaMessage(searchResults.getVistaMessage());
			
			searchResponse.setSuccess(searchResults.getSuccess());

			

		} catch (Exception e) {

			LOG.error("Error in ProviderSearchImpl:"+e.getMessage());
			
			searchResponse.setSuccess(false);

			searchResponse.setErrorMessage("Error while searching provider: " + e.getMessage());
		}

		return searchResponse;
	}


}
