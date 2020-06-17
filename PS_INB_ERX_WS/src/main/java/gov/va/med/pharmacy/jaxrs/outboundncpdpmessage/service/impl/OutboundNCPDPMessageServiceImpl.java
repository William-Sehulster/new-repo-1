package gov.va.med.pharmacy.jaxrs.outboundncpdpmessage.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Properties;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import gov.va.med.pharmacy.jaxrs.outboundncpdpmessage.model.OutboundNCPDPMessageRequest;
import gov.va.med.pharmacy.jaxrs.outboundncpdpmessage.model.OutboundNCPDPMessageResponse;
import gov.va.med.pharmacy.jaxrs.outboundncpdpmessage.service.OutboundNCPDPMessageService;
import gov.va.med.pharmacy.ncpdpmsgs.MessageType;
import gov.va.med.pharmacy.persistence.model.InboundNcpdpMsgEntity;
import gov.va.med.pharmacy.persistence.model.OutboundNcpdpMsgEntity;
import gov.va.med.pharmacy.persistence.service.InboundNcpdpMsgService;
import gov.va.med.pharmacy.persistence.service.OutboundNcpdpMsgService;
import gov.va.med.pharmacy.utility.StreamUtilities;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;




/**
 * A class that implement saves vista outbound message which are coming from vista and sends response back in JSON.
 *
 */

@Consumes("application/json")
@Produces("application/json")
public class OutboundNCPDPMessageServiceImpl implements OutboundNCPDPMessageService {

	
	private static final String HTML_START_TAG = "<html>";

	private static final String NOT_RECORD_FOUND = "Not record found.";

	private static final String WSCLIENTS_PROPERTIES_FILE = "gov.va.med.pharmacy.inboundeRx.properties";

	private static final String DAS_OUTBOUND_ENDPOINT = "das.outbound.endpoint";

	private static final String OUTBOUND_ERX_MESSAGES = "OutboundErxMessages";

	private static final String TEXT_XML = "text/xml";

	private static final String STATUS_0000 = "0000";

	private static final String UTF_8 = "UTF-8";

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(OutboundNCPDPMessageServiceImpl.class);
	
	private static final String KEYSTORE_FILE_TYPE = "JKS";
	private static final String KEYSTORE_FILE_NAME_PROPERTY = "keystore.filename";
	private static final String KEYSTORE_PASSWD_PROPERTY = "keystore.password";
	
	@Autowired
	private OutboundNcpdpMsgService outboundNcpdpMsgService;
	
	@Autowired
	private InboundNcpdpMsgService inboundNcpdpMsgService;
	
	@POST
	@Path("/outBoundNCPDPMessage/")
	public OutboundNCPDPMessageResponse sendOutboundMessage(OutboundNCPDPMessageRequest outboundRequest) {

		OutboundNCPDPMessageResponse wsResponse = new OutboundNCPDPMessageResponse();
		try {

			OutboundNcpdpMsgEntity outboundMsgEntity = null;

			outboundMsgEntity = outboundNcpdpMsgService.findById(outboundRequest.getOutboundNcpdpMsgId().longValue());

			// if outboundMsg has value then only proceed further.

			if (outboundMsgEntity != null) {

				wsResponse.setErrorMessage(null);

				wsResponse.setSuccess(true);

				MessageType outboundMessage = null;

				outboundMessage = outboundMsgEntity.getMessage();

				// if message is not null then send to DAS.

				if (null != outboundMessage) {

					// TODO - make the url property driven. clean console prints
					// and console loggings from context xml for performance.

					// TODO - Asynchronous invocation with future......

					Properties properties = new Properties();

					InputStream inputStream = null;
					try
					{
						inputStream = this.getClass().getClassLoader().getResourceAsStream(WSCLIENTS_PROPERTIES_FILE);
						
						if (null != inputStream) {
							properties.load(inputStream);
						}
					} 
					finally 
					{
						if (null != inputStream) {
							StreamUtilities.safeClose(inputStream);
						}
					}

					String dasOutboundEndpoint = properties.getProperty(DAS_OUTBOUND_ENDPOINT).trim();

					WebClient webclient = WebClient.create(dasOutboundEndpoint);

					// call method to setup TLS security parameters.
					setupTLS(webclient, properties);

					webclient.path(OUTBOUND_ERX_MESSAGES).accept(TEXT_XML);

					Response outboundResponse = webclient.post(outboundMessage);

					InputStream entityStream = (InputStream) outboundResponse.getEntity();

					if (entityStream != null) {

						StringWriter writer = new StringWriter();

						IOUtils.copy(entityStream, writer, UTF_8);

						String message = writer.toString();

						// check if the Message doesn't contain any html code in it, we need to escape those kind of messages.

						if (message.indexOf(HTML_START_TAG) == -1) {

							// persist the message.

							InboundNcpdpMsgEntity inboundeRx = new InboundNcpdpMsgEntity();

							Date date = new Date();

							inboundeRx.setErxStatusByPatientChkStatus(STATUS_0000);
						
							inboundeRx.setErxStatusByDrugChkStatus(STATUS_0000);
							
							inboundeRx.setErxStatusByProviderChkStatus(STATUS_0000);

							inboundeRx.setErxStatusByMessageStatus(STATUS_0000);

							inboundeRx.setMessage(message);

							inboundeRx.setPharmacyId(0);

							inboundeRx.setCreatedDate(date);

							inboundeRx.setUpdatedDate(date);

							inboundeRx.setReceivedDate(date);

							inboundNcpdpMsgService.saveInboundERx(inboundeRx);
						}

					}

				}

			} else {

				wsResponse.setErrorMessage(NOT_RECORD_FOUND);

				wsResponse.setSuccess(false);
			}

		} catch (Exception e) {

			LOG.error("Error in OutboundNCPDPMessageServiceImpl:" + e.getMessage());

			wsResponse.setSuccess(false);

			wsResponse.setErrorMessage("Error while processing outbound message: " + e.getMessage());
		}

		return wsResponse;
	}

	/*
	 * TLS Settings. The reason why it's down within java and not cxf xml is
	 * because of more flexibility in terms of file paths and other variables.
	 */

	/**
	 * The method to setup TLS related settings.
	 * 
	 * @param port
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws GeneralSecurityException
	 */
	private void setupTLS(WebClient client, Properties properties) throws FileNotFoundException, IOException, GeneralSecurityException {

		ClassLoader classloader = this.getClass().getClassLoader();

		File file = new File(classloader.getResource(properties.getProperty(KEYSTORE_FILE_NAME_PROPERTY).trim()).getFile());

		HTTPConduit httpConduit = WebClient.getConfig(client).getHttpConduit();
		
		//setting timeout

		HTTPClientPolicy clientPolicy = new HTTPClientPolicy();
		
		clientPolicy.setReceiveTimeout(120000); // 2 minutes
		
		clientPolicy.setAllowChunking(false);
		
		httpConduit.setClient(clientPolicy);

		// We do two FileInpustreams otherwise it gives EOFException as the file
		// is read twice.


		FileInputStream fileIn1 = null;
		FileInputStream fileIn2 = null;
		TLSClientParameters tlsCP = new TLSClientParameters();
		String keyPasswd = properties.getProperty(KEYSTORE_PASSWD_PROPERTY).trim();
		KeyStore keyStore = KeyStore.getInstance(KEYSTORE_FILE_TYPE);

		try {
			fileIn1 = new FileInputStream(file);
			keyStore.load(fileIn1, keyPasswd.toCharArray());
			KeyManager[] myKeyManagers = getKeyManagers(keyStore, keyPasswd);
			tlsCP.setKeyManagers(myKeyManagers);
		} finally {
			if (null != fileIn1) {
				StreamUtilities.safeClose(fileIn1);
			}
			
			fileIn1 = null;
		}

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
			
			fileIn2 = null;
		}

		file = null;
		tlsCP = null;

	}

	private TrustManager[] getTrustManagers(KeyStore trustStore) throws NoSuchAlgorithmException, KeyStoreException {
		String alg = KeyManagerFactory.getDefaultAlgorithm();
		TrustManagerFactory fac = TrustManagerFactory.getInstance(alg);
		fac.init(trustStore);
		return fac.getTrustManagers();
	}

	private KeyManager[] getKeyManagers(KeyStore keyStore, String keyPassword)
			throws GeneralSecurityException, IOException {
		String alg = KeyManagerFactory.getDefaultAlgorithm();
		char[] keyPass = keyPassword != null ? keyPassword.toCharArray() : null;
		KeyManagerFactory fac = KeyManagerFactory.getInstance(alg);
		fac.init(keyStore, keyPass);
		return fac.getKeyManagers();
	}
}
