package gov.va.med.pharmacy.jaxrs.admin.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.admin.model.AppInfoResponse;

/**
 * AppInfo interface.
 *
 */
@Consumes("application/json")
@Produces("application/json")
public interface AppInfoSearch {

	/**
	 * @param request
	 * @return AppInfoResponse
	 */
	
	public AppInfoResponse view();
}
