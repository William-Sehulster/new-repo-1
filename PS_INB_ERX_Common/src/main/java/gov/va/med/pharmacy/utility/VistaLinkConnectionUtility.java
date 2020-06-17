
package gov.va.med.pharmacy.utility;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.ResourceException;

import gov.va.med.exception.FoundationsException;
import gov.va.med.vistalink.adapter.cci.VistaLinkAppProxyConnectionSpec;
import gov.va.med.vistalink.adapter.cci.VistaLinkConnection;
import gov.va.med.vistalink.adapter.cci.VistaLinkConnectionFactory;
import gov.va.med.vistalink.adapter.cci.VistaLinkConnectionSpec;
import gov.va.med.vistalink.institution.InstitutionMappingDelegate;
import gov.va.med.vistalink.rpc.RpcRequest;
import gov.va.med.vistalink.rpc.RpcRequestFactory;
import gov.va.med.vistalink.rpc.RpcResponse;


/**
 * This class provides VistA connectivity. It uses VistALink to execute RPC's on the remote VistA and retrieve the results.
 */
public class VistaLinkConnectionUtility  {

	// TO-DO
    //private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(VistaLinkConnectionUtility.class);

    private static final String VISTALINK_PROXYUSER = "vistalink.proxyuser";
	private static final String VISTALINK_PROPERTIES_FILE = "gov.va.med.pharmacy.inboundeRx.properties";
	private static final String DUZ_CONNECTION_SPEC = "DUZ";
    private static final String VPID_CONNECTION_SPEC = "VPID";
    private static final String APP_PROXY_CONNECTION_SPEC = "APP PROXY";
    public static final int DEFAULT_RPCTIMEOUT = 60000;
   
    public static final String DEFAULT_CONNSPEC = "DUZ";
    
    
    /**
     * Executes an RPC call on the VistA.
     * @param division TODO
     * @param rpcContext The context this RPC will be called in.
     * @param rpcName The name of the RPC.
     * @param rpcParams Parameter(s) that will be passed to the VistA.
     * @param user The user making the RPC call. If the user is null, default user will be used.
     * 
     * @return The RpcResponse.
     * @throws IOException 
     * @throws FoundationsException 
     */
    public RpcResponse sendRequest(String division, String rpcContext, String rpcName, ArrayList<Object> rpcParams) throws FoundationsException, IOException {

        //LOG.debug("VistA request [" + rpcContext + ", " + rpcName + "] with parameters: " + rpcParams);

    	
        String proxyUser ="PSOAPPLICATIONPROXY,PSO";
    	
        VistaLinkConnection connection = null;

        try {
        	
        	
        	Properties properties = new Properties();
    		
    		InputStream inputStream = null;
    		try{
    			
    			inputStream = this.getClass().getClassLoader().getResourceAsStream(VISTALINK_PROPERTIES_FILE);

    			if(null!=inputStream){
    				properties.load(inputStream);    				
    				proxyUser = properties.getProperty(VISTALINK_PROXYUSER).trim();
    			}
    			
    		} finally {
    			if (null != inputStream) {
    				StreamUtilities.safeClose(inputStream);
    			}
    		}
    		
    		connection = getConnection(division, proxyUser);
        	
            RpcRequest rpcRequest = RpcRequestFactory.getRpcRequest();

            rpcRequest.setRpcContext(rpcContext);
            rpcRequest.setRpcName(rpcName);
            rpcRequest.setRpcClientTimeOut(DEFAULT_RPCTIMEOUT);
            rpcRequest.setUseProprietaryMessageFormat(true);
			
            if (rpcParams != null) 
			{
				rpcRequest.setParams(rpcParams);
				
				//System.out.println("-- rpcParams--: "+rpcParams.toString());
			} 
            
            RpcResponse response = connection.executeRPC(rpcRequest);

            //LOG.debug("VistA response [" + rpcContext + ", " + rpcName + "]: " + response.getResults());

            return response;
        } catch (FoundationsException | NamingException | ResourceException e) {
        	throw new IOException (e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (ResourceException e) {
                    //LOG.error("Error closing VistALink connection.", e);
                	e.printStackTrace();
                }
            }
        }
    }

    /**
     * Retrieves VistALink connection.
     * 
     * @return A VistaLinkConnection.
     * @throws NamingException 
     * @throws ResourceException 
     * @throws Exception 
     */
    private VistaLinkConnection getConnection(String division, String proxyUser) throws FoundationsException, NamingException, ResourceException {

       // LOG.debug("Connecting to VistAlink as: " + userId + ", " + division);

        Context ic = null;

        try {
            VistaLinkConnectionSpec connectionSpec = null;

            connectionSpec = new VistaLinkAppProxyConnectionSpec(division, proxyUser);
            
            ic = new InitialContext();
            String jndiName = InstitutionMappingDelegate.getJndiConnectorNameForInstitution(division);
            VistaLinkConnectionFactory cf = (VistaLinkConnectionFactory) ic.lookup(jndiName);
            VistaLinkConnection connection = (VistaLinkConnection) cf.getConnection(connectionSpec);

            return connection;
       
        }
        
        catch (FoundationsException e) {
             //LOG.error("VistALink error while retrieving connection.", e);
        	throw new FoundationsException(e);
        }
        catch (NamingException e) {
            //LOG.error("VistALink error while retrieving connection.", e);
       	throw new NamingException();
       }
        catch (ResourceException e) {
            //LOG.error("VistALink error while retrieving connection.", e);
       	throw new ResourceException(e);
       }finally {
        	if (ic != null){
           ic.close();
        	};
        }
    }
}
