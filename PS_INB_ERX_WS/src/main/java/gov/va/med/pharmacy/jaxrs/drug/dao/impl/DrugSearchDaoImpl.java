package gov.va.med.pharmacy.jaxrs.drug.dao.impl;

import gov.va.med.pharmacy.jaxrs.drug.dao.DrugSearchDao;
import gov.va.med.pharmacy.jaxrs.drug.model.Drug;

/**
 * This class acts as Data Access Object layer, calls RPC and does data
 * processing to build up drug object.
 *
 */

public class DrugSearchDaoImpl implements DrugSearchDao {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(DrugSearchDaoImpl.class);
	private DrugRpc drugRpc;
	
	public DrugRpc getDrugRpc() {
		return drugRpc;
	}
	public void setDrugRpc(DrugRpc drugRpc) {
		this.drugRpc = drugRpc;
	}
	
	@Override
	public Drug lookupDrug(Drug drugObj) throws Exception {
			
		Drug drugResults = null;

		try {

			drugResults = drugRpc.lookupDrug(drugObj);

		} catch (Exception e) {
			LOG.error("Error in DrugSearchDaoImpl:"+e.getMessage());
			throw new Exception(e); // let the exception go all the way up.
		}

		return drugResults;

	}

}
