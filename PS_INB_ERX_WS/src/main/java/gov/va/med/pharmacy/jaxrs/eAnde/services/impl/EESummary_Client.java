package gov.va.med.pharmacy.jaxrs.eAnde.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import gov.va.med.pharmacy.utility.StreamUtilities;
import gov.va.med.pharmacy.wsclients.eAnde.ClientPasswordCallback;
import gov.va.med.pharmacy.wsclients.eAnde.EeSummaryPort;
import gov.va.med.pharmacy.wsclients.eAnde.EeSummaryPortService;
import gov.va.med.pharmacy.wsclients.eAnde.GetEESummaryRequest;
import gov.va.med.pharmacy.wsclients.eAnde.getEESummaryResponse;


/**
 * JAX-WS Client for EESummary (Enrollment and Eligibility Service).
 *
 */
public final class EESummary_Client {
	
	private static final String WSCLIENTS_PROPERTIES_FILE = "gov.va.med.pharmacy.inboundeRx.properties";
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(EESummary_Client.class);
    private static final String E_AND_E_REQUEST_NAME = "eAnde.request.name";
	private static final String E_AND_E_USERNAME = "eAnde.username";
	private static final String E_AND_E_CLIENT_ENDPOINT = "eAnde.client.endpoint";
	private static final QName SERVICE_NAME = new QName("http://jaxws.webservices.esr.med.va.gov/schemas", "eeSummaryPortService");
	private static final String KEYSTORE_FILE_TYPE = "JKS";
	private static final String KEYSTORE_FILE_NAME_PROPERTY = "keystore.filename";
	private static final String KEYSTORE_PASSWD_PROPERTY = "keystore.password";

    public getEESummaryResponse returnResponse(String key) throws java.lang.Exception {
    	
        Properties properties = new Properties();
        
        String username = null;
        String eAndeEndpoint = null;
        String eAndeRequestName = null;
		
		InputStream inputStream = null;
		try{
			inputStream = this.getClass().getClassLoader().getResourceAsStream(WSCLIENTS_PROPERTIES_FILE);
			if(null != inputStream){
				properties.load(inputStream);
			} else
			{
				LOG.error("Property file not loaded/found.");	
			}	
		}
		finally{
				StreamUtilities.safeClose(inputStream);
		}
		

		eAndeEndpoint = properties.getProperty(E_AND_E_CLIENT_ENDPOINT).trim();
		
		username = properties.getProperty(E_AND_E_USERNAME).trim();
    	
		eAndeRequestName = properties.getProperty(E_AND_E_REQUEST_NAME).trim();
    	
		String url = "";

    	
        URL wsdlURL = EeSummaryPortService.WSDL_LOCATION;
     
        if (wsdlURL != null && !"".equals(wsdlURL)) { 
            File wsdlFile = new File(url);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(url);
                }
            } catch (MalformedURLException e) {                
                
                throw new Exception(e); // let the exception go all the way up.
            }
        }
      
       EeSummaryPortService ss = new EeSummaryPortService(wsdlURL, SERVICE_NAME);
     
       EeSummaryPort port = ss.getEeSummaryPortSoap11(); 
       
       setupTLS(port, properties);
      
       ((BindingProvider)port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,eAndeEndpoint);
                
       GetEESummaryRequest eeSummaryRequest = null;
  
       Client client = ClientProxy.getClient(port);
       Endpoint cxfEndpoint = client.getEndpoint();
 
        Map<String, Object> outProps = new HashMap<String, Object>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        outProps.put(WSHandlerConstants.USER, username);
        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        ClientPasswordCallback handler = new ClientPasswordCallback();
        outProps.put(WSHandlerConstants.PW_CALLBACK_REF, handler);

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
       
        cxfEndpoint.getOutInterceptors().add(wssOut);
        
        eeSummaryRequest= new GetEESummaryRequest();
        
        eeSummaryRequest.setKey(key);

        eeSummaryRequest.setRequestName(eAndeRequestName);
        
        getEESummaryResponse eeSummaryResponse = port.getEESummary(eeSummaryRequest);
		
    	return eeSummaryResponse;

    }
    
    /**
	 * The method to setup TLS related settings.
	 * 
	 * @param port
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws GeneralSecurityException
	 */
	private void setupTLS(EeSummaryPort port, Properties properties) throws FileNotFoundException, IOException, GeneralSecurityException {
		
		if (this.getClass().getClassLoader() != null){
		ClassLoader classloader = this.getClass().getClassLoader();
		File file = new File(classloader.getResource(properties.getProperty(KEYSTORE_FILE_NAME_PROPERTY).trim()).getFile());
		
		HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(port).getConduit();
				
		FileInputStream fileIn2 = null;
		TLSClientParameters tlsCP = new TLSClientParameters();
		String keyPasswd = properties.getProperty(KEYSTORE_PASSWD_PROPERTY).trim();
		
		try {
		fileIn2 = new FileInputStream(file);
		KeyStore trustStore = KeyStore.getInstance(KEYSTORE_FILE_TYPE);
		trustStore.load(fileIn2, keyPasswd.toCharArray());
		TrustManager[] myTrustStoreKeyManagers = getTrustManagers(trustStore);
		tlsCP.setTrustManagers(myTrustStoreKeyManagers);
		httpConduit.setTlsClientParameters(tlsCP);
		} finally {
			if (null != fileIn2) {
				StreamUtilities.safeClose(fileIn2);
			}
			
			file = null;
			tlsCP = null;
			fileIn2 = null;
		}
		
		
		}
	}

	private TrustManager[] getTrustManagers(KeyStore trustStore) throws NoSuchAlgorithmException, KeyStoreException {
		String alg = KeyManagerFactory.getDefaultAlgorithm();
		TrustManagerFactory fac = TrustManagerFactory.getInstance(alg);
		fac.init(trustStore);
		return fac.getTrustManagers();
	}


}
