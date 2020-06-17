package gov.va.med.pharmacy.jaxrs.drug.dao.impl;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import gov.va.med.pharmacy.jaxrs.drug.model.Drug;
import gov.va.med.pharmacy.utility.VistaLinkConnectionUtility;
import gov.va.med.vistalink.rpc.RpcResponse;

/**
 * This class makes RPC call to Vista to get drug information (Drug Check).
 *
 */
public class DrugRpc {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(DrugRpc.class);
	private VistaLinkConnectionUtility vistaLinkConnectionUtility;
	
	public VistaLinkConnectionUtility getVistaLinkConnectionUtility() {
		return vistaLinkConnectionUtility;
	}
	public void setVistaLinkConnectionUtility(VistaLinkConnectionUtility vistaLinkConnectionUtility) {
		this.vistaLinkConnectionUtility = vistaLinkConnectionUtility;
	}
	
	public Drug lookupDrug(Drug searchObj) throws Exception {

		Drug searchResults = new Drug();
		//inject
		//VistaLinkConnectionUtility vistaLinkConnectionUtility = new VistaLinkConnectionUtility();

		RpcResponse rpcResponse;
		
		String rpcName ="PSOERXA0 DRGMTCH";
		
		String rpcContext ="PSO WEB SERVICES OPTION";
		
		ArrayList<Object> params = new ArrayList<Object>();
		 
        params.add(searchObj.getNdcUPN());
        params.add(searchObj.getDrugDescription());        
         
         

		try {
			rpcResponse = vistaLinkConnectionUtility.sendRequest(searchObj.getDivision(), rpcContext, rpcName, params);
		} catch (Exception e) {
			LOG.error("Error in DrugRPC RPC:"+e.getMessage());
			throw new Exception(e);
		}

		//LOG.debug("XML Response is: " + rpcResponse.getResults());

		String response = rpcResponse.getResults(); 
		
		
		if(StringUtils.isNotEmpty(response) && (!StringUtils.startsWith(response, "0") ) )  
		{
			String vistaIEN = response.substring(0,response.indexOf("^"));
			String drugDetails = response.substring(response.indexOf("^")+1,response.length() );

			searchResults.setVistaIEN(vistaIEN);
			searchResults.setDrugDescription(drugDetails);
			searchResults.setSuccess(true);
		}
		else{
			searchResults.setVistaMessage(response.substring(response.indexOf("^")+1,response.length() ));
			searchResults.setSuccess(false);
		}
		return searchResults;


	}

}
