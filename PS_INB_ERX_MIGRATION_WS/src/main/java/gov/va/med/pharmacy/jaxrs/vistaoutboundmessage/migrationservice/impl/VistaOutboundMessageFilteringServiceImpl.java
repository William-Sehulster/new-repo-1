package gov.va.med.pharmacy.jaxrs.vistaoutboundmessage.migrationservice.impl;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXB;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import gov.va.med.pharmacy.jaxrs.vistaoutboundmessage.migrationservice.VistaOutboundMessageFilteringService;
import gov.va.med.pharmacy.jaxrs.vistaoutboundmessage.migrationservice.model.VistaOutboundResponse;
import gov.va.med.pharmacy.ncpdpmsgs.MessageType;
import gov.va.med.pharmacy.persistence.model.AppConfiguration;
import gov.va.med.pharmacy.persistence.model.OutboundNcpdpMsgEntity;
import gov.va.med.pharmacy.persistence.model.PharmacyMigration;
import gov.va.med.pharmacy.persistence.service.PharmacyMigrationService;
import gov.va.med.pharmacy.utility.StreamUtilities;

/**
 * A class that implement saves vista outbound message which are coming from
 * vista and sends response back in JSON.
 *
 */

@Consumes({ "application/x-www-form-urlencoded", "application/xml", "text/xml" })
@Produces("application/xml")
public class VistaOutboundMessageFilteringServiceImpl implements VistaOutboundMessageFilteringService {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(VistaOutboundMessageFilteringServiceImpl.class);

	private static final String NEW_SCRIPT_VERSION = "2017071";
	
	private static final String OLD_SCRIPT_VERSION = "10.6";

	private static final String LOAD_EXTERNAL_DTD = "http://apache.org/xml/features/nonvalidating/load-external-dtd";

	private static final String EXTERNAL_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities";

	private static final String EXTERNAL_GENERAL_ENTITIES = "http://xml.org/sax/features/external-general-entities";

	private static final String SECURE_PROCESSING_CONST_STRING = "http://javax.xml.XMLConstants/feature/secure-processing";

	private static final String VA_EMD_NCPDP_SCRIPT_10_6_XSD = "VA_EMD_NCPDP_SCRIPT_10_6.xsd";

	private static final String UTF_8_CONST_STRING = "UTF-8";

	private static final String FROM_QUALIFIER_P = "<From Qualifier=\"P\">";

	private static final String FROM_ENG_TAG = "</From>";

	private static final String EMPTY_STRING = "";

	private static final String WSCLIENTS_PROPERTIES_FILE = "gov.va.med.pharmacy.inboundeRx.properties";

	@Autowired
	private PharmacyMigrationService pharmacyMigrationService;

	@POST
	@Path("/processXMLMessage/")
	public VistaOutboundResponse getOutboundMessage(String message) {

		VistaOutboundResponse wsResponse = new VistaOutboundResponse();

		InputStream inputStream = null;

		StreamSource xsdStreamSource = null;

		Source xsdSource = null;

		SchemaFactory schemaFactory = null;

		Schema schema = null;

		SAXParserFactory saxParserFactory = null;

		SAXParser saxparser = null;

		XMLReader xmlReader = null;

		String pharmacyNCPDPID = EMPTY_STRING;

		PharmacyMigration pharmacyMigration = null;

		AppConfiguration appConfiguration = null;

		String webServiceURL = null;
		
		String scriptVersion = null;

		try {

			OutboundNcpdpMsgEntity outboundMsg = new OutboundNcpdpMsgEntity();
			
			if ((StringUtils.isNotEmpty(message)) && (message.indexOf("TransportVersion") == -1)
					&& (message.indexOf("TransactionVersion") == -1) && (message.indexOf("release=\"006\"") != -1)
					&& (message.indexOf("RefillRequest") != -1)) {
				
				scriptVersion = NEW_SCRIPT_VERSION;
			}
			else
			{
				scriptVersion = OLD_SCRIPT_VERSION;
			}

			// First validate if the incoming refillRequest is valid xml.

			schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			// fortify get inputstream and then close it
			inputStream = this.getClass().getClassLoader().getResourceAsStream(VA_EMD_NCPDP_SCRIPT_10_6_XSD);

			xsdStreamSource = new StreamSource(inputStream);

			xsdSource = xsdStreamSource;

			schema = schemaFactory.newSchema(xsdSource);

			saxParserFactory = SAXParserFactory.newInstance();

			saxParserFactory.setSchema(schema);

			saxparser = saxParserFactory.newSAXParser();

			xmlReader = saxparser.getXMLReader();

			// fortify XXE Fix.
			xmlReader.setFeature(EXTERNAL_GENERAL_ENTITIES, false);
			xmlReader.setFeature(EXTERNAL_PARAMETER_ENTITIES, false);
			xmlReader.setFeature(LOAD_EXTERNAL_DTD, false);
			xmlReader.setFeature(SECURE_PROCESSING_CONST_STRING, true);

			InputSource inputparseXML = new InputSource(new StringReader(message));

			inputparseXML.setEncoding(UTF_8_CONST_STRING);

			xmlReader.parse(inputparseXML);

			// if validation is successful proceed further.

			if (message.indexOf(FROM_QUALIFIER_P) != -1) {

				pharmacyNCPDPID = message.substring(message.indexOf(FROM_QUALIFIER_P) + 20,
						message.indexOf(FROM_ENG_TAG));

			}

			if (StringUtils.isNotEmpty(pharmacyNCPDPID)) {

				pharmacyMigration = pharmacyMigrationService.findByNCPDPId(pharmacyNCPDPID);
			}

			// if we found the version 3.0 pharmacy call the newer 3.0 inbound WS url,
			// otherwise call the 2.0 WS url by using the lookup table.
			if (null != pharmacyMigration && pharmacyMigration.getMigrated().equals(true)) {

				// get url for v3.0 ws
				appConfiguration = pharmacyMigrationService.findByKey("INB_V4_WS_URI");
				
				wsResponse.setSuccess(true);
				
				wsResponse.setErrorMessage(null);
				
				wsResponse.setOutboundMsgId(0);

				

			} else {

				// throw an error.
				
				wsResponse.setSuccess(false);

				wsResponse.setErrorMessage("Error while saving vista outbound message, pharmacy is not migrated: ");

				wsResponse.setOutboundMsgId(0);
				
			}

			StringReader reader = new StringReader(message);

			MessageType outboundMessage = (MessageType) JAXB.unmarshal(reader, MessageType.class);

			// now call the respective WS  

			if (appConfiguration != null && StringUtils.isNotEmpty(appConfiguration.getValue())) {

				webServiceURL = appConfiguration.getValue() + "/INB-ERX/services/rest/vistaoutboundMsg/processXMLMessage";

				String username;
				String password;
				
				Properties properties = new Properties();
				
				InputStream  propInputStream = this.getClass().getClassLoader().getResourceAsStream(WSCLIENTS_PROPERTIES_FILE);

				try{
					if (null != propInputStream) {
						properties.load(propInputStream);
					}
				}
				finally{
						StreamUtilities.safeClose(propInputStream);
				}
				username = properties.getProperty("ws.user").trim();
				password = properties.getProperty("ws.user.password").trim();
				
				WebClient webclient = WebClient.create(webServiceURL, username, password, null);

				webclient.accept("application/x-www-form-urlencoded", "application/xml", "text/xml");

				Response outboundResponse = webclient.post(outboundMessage);

				InputStream entityStream = (InputStream) outboundResponse.getEntity();

				if (entityStream != null) {

					StringWriter writer = new StringWriter();

					IOUtils.copy(entityStream, writer, UTF_8_CONST_STRING);

					String outBoundMessage = writer.toString();

					LOG.info("outbound migration WS call to outbound NCPDP WS response: " + outBoundMessage);
				}

			}

			outboundMsg.setErxStatus("0000");

			outboundMsg.setPharmacyId(0);

			Date date = new Date();

			outboundMsg.setCreatedDate(date);

			outboundMsg.setUpdatedDate(date);

			outboundMsg.setReceivedDate(date);

			outboundMsg.setScriptVersion(scriptVersion);			

			

		} catch (SAXException ex) {

			// build error response. To and From are flipped.

			LOG.error("Error in VistaOutboundMsgImpl SaxException:" + ex.getMessage());

			wsResponse.setSuccess(false);

			wsResponse.setErrorMessage("Error while saving vista outbound message, SaxException: " + ex.getMessage());

			wsResponse.setOutboundMsgId(0);

		} 
		catch (Exception e) {

			LOG.error("Error in VistaOutboundMsgImpl:" + e.getMessage());

			wsResponse.setSuccess(false);

			wsResponse
					.setErrorMessage("Error while while conversion to newer format and saving vista outbound message: "
							+ e.getMessage());

			// e.printStackTrace();

			wsResponse.setOutboundMsgId(0);

		} finally {

			StreamUtilities.safeClose(inputStream);

			inputStream = null;

			xsdStreamSource = null;

			xsdSource = null;

			schemaFactory = null;

			schema = null;

			saxParserFactory = null;

			saxparser = null;

			xmlReader = null;			

		}

		return wsResponse;
	}

}
