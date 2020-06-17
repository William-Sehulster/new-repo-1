package gov.va.med.pharmacy.jaxrs.provider.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.provider.model.Provider;
import gov.va.med.pharmacy.jaxrs.provider.model.ProviderSearchResponse;

/**
 * Provider search interface.
 *
 */
@Consumes("application/json")
@Produces("application/json")
public interface ProviderSearch {

	/**
	 * @param request
	 * @return ProviderSearchResponse
	 */
	
	public ProviderSearchResponse search(Provider providerSearchObj );
}
