package gov.va.med.pharmacy.jaxrs.provider.dao.impl;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import gov.va.med.pharmacy.jaxrs.provider.model.Provider;
import gov.va.med.pharmacy.utility.VistaLinkConnectionUtility;
import gov.va.med.vistalink.rpc.RpcResponse;

/**
 * This class makes RPC call to Vista to get provider information.
 *
 */
public class ProviderRPC {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(ProviderRPC.class);
	
	public Provider lookupProvider(Provider searchObj) throws Exception {

		Provider searchResults = new Provider();

		VistaLinkConnectionUtility vistaLinkConnectionUtility = new VistaLinkConnectionUtility();

		RpcResponse rpcResponse;
		
		String rpcName ="PSOERXA0 PRVMTCH";
		
		String rpcContext ="PSO WEB SERVICES OPTION";
		
		ArrayList<Object> params = new ArrayList<Object>();
		 
         params.add(searchObj.getProviderNPI());
         params.add(searchObj.getProviderDEANumber());        
         params.add(searchObj.getControlledSubstance());
         
         

		try {
			rpcResponse = vistaLinkConnectionUtility.sendRequest(searchObj.getDivision(), rpcContext, rpcName, params);
		} catch (Exception e) {
			LOG.error("Error in Provider RPC:"+e.getMessage());
			throw new Exception(e);						
		}

		//LOG.debug("XML Response is: " + rpcResponse.getResults());

		String response = rpcResponse.getResults(); 
		if(StringUtils.isNotEmpty(response) && (!StringUtils.startsWith(response, "0") ))
		{
			String vistaIEN = response.substring(0,response.indexOf("^"));
			String providerName = response.substring(response.indexOf("^")+1,response.length() );

			String [] names = providerName.split("\\,");
			searchResults.setProviderFirstName(names[1]);
			searchResults.setProviderLastName(names[0]);
			searchResults.setVistaIEN(vistaIEN);
			searchResults.setSuccess(true);
		}
		else{
			searchResults.setVistaMessage(response.substring(response.indexOf("^")+1,response.length()));
			searchResults.setSuccess(false);
		}
		return searchResults;


	}

}
