package gov.va.med.pharmacy.jaxrs.drug.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.drug.dao.impl.DrugSearchDaoImpl;
import gov.va.med.pharmacy.jaxrs.drug.model.Drug;
import gov.va.med.pharmacy.jaxrs.drug.model.DrugSearchResponse;
import gov.va.med.pharmacy.jaxrs.drug.service.DrugSearch;

/**
 * A class that implement provider search by taking different search parameters
 * and calls Vista RPC for drug query and sends response back in JSON.
 *
 */

@Consumes("application/json")
@Produces("application/json")
public class DrugSearchImpl implements DrugSearch {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(DrugSearchImpl.class);

	private DrugSearchDaoImpl drugSearchDao; 
	
	public DrugSearchDaoImpl getDrugSearchDao() {
		return drugSearchDao;
	}

	public void setDrugSearchDao(DrugSearchDaoImpl drugSearchDao) {
		this.drugSearchDao = drugSearchDao;
	} 

	@POST
	@Path("/searchDrug/")
	public DrugSearchResponse search(Drug drugObj) {

		DrugSearchResponse searchResponse = new DrugSearchResponse();

		try {

			Drug searchResults = drugSearchDao.lookupDrug(drugObj);

			searchResponse.setDrugDescription(searchResults.getDrugDescription());
			
			searchResponse.setVistaIEN(searchResults.getVistaIEN());
			
			searchResponse.setVistaMessage(searchResults.getVistaMessage());
			
			searchResponse.setSuccess(searchResults.getSuccess());


		} catch (Exception e) {
			searchResponse.setSuccess(false);

			searchResponse.setErrorMessage("Error while searching drug: " + e.getMessage());
			
			LOG.error("Error in DrugSearchImpl:"+e.getMessage());
			LOG.error("FULL STACK TRACE:" + e);
		}

		return searchResponse;
	}


}
