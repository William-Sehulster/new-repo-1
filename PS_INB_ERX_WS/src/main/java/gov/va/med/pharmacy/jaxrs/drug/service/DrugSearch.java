package gov.va.med.pharmacy.jaxrs.drug.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.drug.model.Drug;
import gov.va.med.pharmacy.jaxrs.drug.model.DrugSearchResponse;

/**
 * Drug search interface.
 *
 */
@Consumes("application/json")
@Produces("application/json")
public interface DrugSearch {

	/**
	 * @param request
	 * @return DrugSearchResponse
	 */
	
	public DrugSearchResponse search(Drug drugSearchObj );
}
