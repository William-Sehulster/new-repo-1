package gov.va.med.pharmacy.jaxrs.inboundncpdpmessage.migrationservice.impl;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.concurrent.ThreadLocalRandom;

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
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import gov.va.med.pharmacy.jaxrs.inboundncpdpmessage.migrationservice.InboundMessageFilteringService;
import gov.va.med.pharmacy.ncpdpmsgs.MessageType;
import gov.va.med.pharmacy.persistence.model.AppConfiguration;
import gov.va.med.pharmacy.persistence.model.PharmacyMigration;
import gov.va.med.pharmacy.persistence.service.PharmacyMigrationService;
import gov.va.med.pharmacy.utility.StreamUtilities;

/**
 * A class that accepts incoming NCPDP message from change healthcare and returns a response.
 * 
 * This web service will be used to Inbound NCPDP message for Pharmacies using v2.1 and version 3.0 of Inbound eRx.
 *
 */

@Consumes({ "application/xml", "text/xml" })
@Produces("application/xml")
public class InboundMessageFilteringServiceImpl implements InboundMessageFilteringService {
	
	private static final String CODE_010 = "<Code>010</Code>";
	
	private static final String INCOMING_VERIFY_MESSAGE_START = "<Verify>";
	
	private static final String INCOMING_ERROR_MESSAGE_START = "<Error>";
	
	private static final String INCOMING_STATUS_MESSAGE_START = "<Status>";

	private static final String SECURE_PROCESSING_CONST_STRING = "http://javax.xml.XMLConstants/feature/secure-processing";

	private static final String EMPTY_STRING = "";

	private static final String UTC_CONST_STRING = "UTC";

	private static final String UTF_8_CONST_STRING = "UTF-8";

	private static final String LOAD_EXTERNAL_DTD = "http://apache.org/xml/features/nonvalidating/load-external-dtd";

	private static final String EXTERNAL_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities";

	private static final String EXTERNAL_GENERAL_ENTITIES = "http://xml.org/sax/features/external-general-entities";

	private static final String DESCRIPTION_MESSAGE_RECEVIED_DESCRIPTION = "<Description>Message Received.</Description>";

	// Renamed the file to address fortify scan issue for unbounded variable in xsd and to to avoid confusion with the original xsd file.
	private static final String VA_EMD_NCPDP_SCRIPT_10_6_XSD = "VA_EMD_NCPDP_SCRIPT_10_6.xsd";

	private static final String ERROR_DESCRIPTION_APPLICATION_ERROR = "<Description>Application Error</Description>";

	private static final String MESSAGE_ERROR_END = "</Error>";

	private static final String ERROR_DESCRIPTION_XSD_VALIDATION = "<Description>XSD Validation Error</Description>";

	private static final String ERROR_CODE_602 = "<Code>602</Code>";

	private static final String MESSAGE_ERROR_START = "<Error>";

	private static final String MESSAGE_BODY_END = "</Body>";

	private static final String MESSAGE_STATUS_END = "</Status>";

	private static final String CODE_000 = "<Code>000</Code>";

	private static final String MESSAGE_STATUS_START = "<Status>";

	private static final String MESSAGE_BODY_START = "<Body>";

	private static final String SENT_TIME_EBD = "</SentTime>";

	private static final String SENT_TIME_START = "<SentTime>";

	private static final String RELATES_TO_MESSAGE_ID_END_TAG = "</RelatesToMessageID>";

	private static final String RELATES_TO_MESSAGE_ID = "<RelatesToMessageID>";

	private static final String MESSAGE_ID_END = "</MessageID>";

	private static final String MESSAGE_ID_START = "<MessageID>";

	private static final String FROM_ENG_TAG = "</From>";

	private static final String FROM_QUALIFIER_P = "<From Qualifier=\"P\">";
	
	private static final String FROM_QUALIFIER_D = "<From Qualifier=\"D\">";

	private static final String TO_TAG_END = "</To>";

	private static final String TO_QUALIFIER_D = "<To Qualifier=\"D\">";
	
	private static final String TO_QUALIFIER_P = "<To Qualifier=\"P\">";

	private static final String MESSAGE_HEADER_END = "</Header>";

	private static final String MESSAGE_HEADER_START = "<Header>";

	private static final String MESSAGE_END = "</Message>";

	private static final String MESSAGE_START = "<Message version=\"010\" release=\"006\" HighestVersionSupported=\"\" xmlns=\"http://www.ncpdp.org/schema/SCRIPT\">";

	private static final String SENT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	private static final String INB_MSG_DATE_FORMAT = "MMddyyyy.HH.mm.ss.sss";

	private static final String READY_FOR_AUTOCHECK = "0000";
	
	private static final String TEXT_XML = "text/xml";

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(InboundMessageFilteringServiceImpl.class);

	
	@Autowired
	private PharmacyMigrationService pharmacyMigrationService;

	
	@POST
	@Path("/inBoundNCPDPMessage/")
	public String getInboundMessage(String incomingMessage) {

		Date receivedDate = new Date();

		String response = null;		

		String relatesToMessageID = EMPTY_STRING;

		String incomingMessageID = EMPTY_STRING;

		String messageFrom = EMPTY_STRING;

		String messageTo = EMPTY_STRING;

		String newMessageID = null;

		String sentDateString = null;
		
		StreamSource xsdStreamSource = null;
		
		Source xsdSource = null;
		
		InputStream inputStream = null;

		StringBuffer responseBuffer = new StringBuffer(MESSAGE_START);
		
		responseBuffer.append(MESSAGE_HEADER_START);
		
		boolean isNotNewRx = false;
		
		String pharmacyNCPDPID = EMPTY_STRING;
		
		PharmacyMigration pharmacyMigration = null;
		
		AppConfiguration appConfiguration = null;
		
		String webServiceURL = null;

		try {

			// put the sent date in response in zulu time format.
			SimpleDateFormat sentDateFormatter = new SimpleDateFormat(SENT_DATE_FORMAT, Locale.US);

			sentDateFormatter.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, UTC_CONST_STRING));
			
			sentDateString = sentDateFormatter.format(receivedDate);

			// for saving. The server are in central time zone so it should be consistent.
			Date date = new Date();

			// for response.
			SimpleDateFormat inbMsgDateFormatter = new SimpleDateFormat(INB_MSG_DATE_FORMAT, Locale.US);


			String dateString = inbMsgDateFormatter.format(date);
			
			

			// 9 digit random number.
			int randomNumber = ThreadLocalRandom.current().nextInt(1, 100000000 + 1);

			newMessageID = new StringBuffer(dateString).append(randomNumber).toString();

			if (incomingMessage.indexOf(MESSAGE_ID_START) != -1) {
				
				incomingMessageID = incomingMessage.substring(incomingMessage.indexOf(MESSAGE_ID_START) + 11,	incomingMessage.indexOf(MESSAGE_ID_END));

				relatesToMessageID = incomingMessageID;

			}

			if (incomingMessage.indexOf(FROM_QUALIFIER_P) != -1 || incomingMessage.indexOf(FROM_QUALIFIER_D) != -1) {

				if (incomingMessage.indexOf(FROM_QUALIFIER_P) != -1) {

					messageFrom = incomingMessage.substring(incomingMessage.indexOf(FROM_QUALIFIER_P) + 20,	incomingMessage.indexOf(FROM_ENG_TAG));
					
				} else if (incomingMessage.indexOf(FROM_QUALIFIER_D) != -1) {

					messageFrom = incomingMessage.substring(incomingMessage.indexOf(FROM_QUALIFIER_D) + 20,	incomingMessage.indexOf(FROM_ENG_TAG));
				}

			}

			if (incomingMessage.indexOf(TO_QUALIFIER_D) != -1 || incomingMessage.indexOf(TO_QUALIFIER_P) != -1) {

				if (incomingMessage.indexOf(TO_QUALIFIER_D) != -1) {

					messageTo = incomingMessage.substring(incomingMessage.indexOf(TO_QUALIFIER_D) + 18,	incomingMessage.indexOf(TO_TAG_END));
					
				} else if (incomingMessage.indexOf(TO_QUALIFIER_P) != -1) {

					messageTo = incomingMessage.substring(incomingMessage.indexOf(TO_QUALIFIER_P) + 18,	incomingMessage.indexOf(TO_TAG_END));
				}

			}
			
			// now check the message type, if it's not NewRx, then set the response status code to 010 instead of 000.
			
			if ( (incomingMessage.indexOf(INCOMING_VERIFY_MESSAGE_START) != -1) || (incomingMessage.indexOf(INCOMING_ERROR_MESSAGE_START) != -1 ) || 
					(incomingMessage.indexOf(INCOMING_STATUS_MESSAGE_START) != -1) ) {
				
				isNotNewRx = true;

			}
			
			

			// First do xml validation against xsd using sax parser.

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			// fortify get inputstream and then close it 
			inputStream = this.getClass().getClassLoader().getResourceAsStream(VA_EMD_NCPDP_SCRIPT_10_6_XSD);
			
			xsdStreamSource = new StreamSource(inputStream);
			
			xsdSource = xsdStreamSource;

			Schema schema = schemaFactory.newSchema(xsdSource);

			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

			saxParserFactory.setSchema(schema);

			SAXParser saxparser =  saxParserFactory.newSAXParser();
			
			XMLReader xmlReader = saxparser.getXMLReader();
			
            // fortify XXE Fix.
			xmlReader.setFeature(EXTERNAL_GENERAL_ENTITIES, false); 
			xmlReader.setFeature(EXTERNAL_PARAMETER_ENTITIES, false); 
			xmlReader.setFeature(LOAD_EXTERNAL_DTD,false);
			xmlReader.setFeature(SECURE_PROCESSING_CONST_STRING, true);
 
			
			InputSource inputparseXML = new InputSource(new StringReader(incomingMessage));
			
			inputparseXML.setEncoding(UTF_8_CONST_STRING);

			xmlReader.parse(inputparseXML);

			
			
			// if validation is successful proceed further and call the WS.
			
			// now check NCPDPD ID of the pharmacy to check whether it's v2.1 or v3.0 pharmacy.
			
			if (incomingMessage.indexOf("<NCPDPID>") != -1) {
				
				pharmacyNCPDPID = incomingMessage.substring(incomingMessage.indexOf("<NCPDPID>") + 9,	incomingMessage.indexOf("</NCPDPID>"));
			}
			
			
			if(StringUtils.isNotEmpty(pharmacyNCPDPID)){
				
				
				pharmacyMigration = pharmacyMigrationService.findByNCPDPId(pharmacyNCPDPID);
			}
			
			// if we found the version 3.0 pharmacy call the newer 3.0 inbound WS url, otherwise call the 2.0 WS url by using the lookup table.
			if(null!=pharmacyMigration && pharmacyMigration.getMigrated().equals(true)){
				
				// get url for v3.0 ws
				appConfiguration = pharmacyMigrationService.findByKey("INB_V3_WS_URI");
				
				
			}
			else{
				
				
				// get url for v2.0 ws	
				
				appConfiguration = pharmacyMigrationService.findByKey("INB_V2_WS_URI");
			}
			

			 StringReader reader = new StringReader(incomingMessage);
			 
			 MessageType inboundMessage = (MessageType)JAXB.unmarshal(reader, MessageType.class);
						
			// now call the respective WS			 
		
			if(appConfiguration!=null && StringUtils.isNotEmpty(appConfiguration.getValue())){
				
				webServiceURL = appConfiguration.getValue() + "/INB-ERX/services/rest/inbound/inBoundNCPDPMessage";
				
				WebClient webclient = WebClient.create(webServiceURL);
				
				webclient.accept("application/xml");
				
				Response inboundResponse = webclient.post(inboundMessage);
				
				InputStream entityStream = (InputStream) inboundResponse.getEntity();
				
				if (entityStream != null) {

					StringWriter writer = new StringWriter();

					IOUtils.copy(entityStream, writer, UTF_8_CONST_STRING);

					String message = writer.toString();
					
					LOG.info("inbound migration WS call to inbound NCPDP WS response: "+message);
				}	
				
				
				
			}
			
			
			// To and From are flipped.
			responseBuffer.append(TO_QUALIFIER_D);
			responseBuffer.append(messageFrom);
			responseBuffer.append(TO_TAG_END);
			responseBuffer.append(FROM_QUALIFIER_P);
			responseBuffer.append(messageTo);
			responseBuffer.append(FROM_ENG_TAG);
			responseBuffer.append(MESSAGE_ID_START);
			responseBuffer.append(newMessageID);
			responseBuffer.append(MESSAGE_ID_END);
			responseBuffer.append(RELATES_TO_MESSAGE_ID);
			responseBuffer.append(relatesToMessageID);
			responseBuffer.append(RELATES_TO_MESSAGE_ID_END_TAG);
			responseBuffer.append(SENT_TIME_START);
			responseBuffer.append(sentDateString);
			responseBuffer.append(SENT_TIME_EBD);
			responseBuffer.append(MESSAGE_HEADER_END);
			responseBuffer.append(MESSAGE_BODY_START);
			responseBuffer.append(MESSAGE_STATUS_START);
			
			if(isNotNewRx == true){
				responseBuffer.append(CODE_010);
			}
			else{
				responseBuffer.append(CODE_000);
			}
			
			responseBuffer.append(DESCRIPTION_MESSAGE_RECEVIED_DESCRIPTION);
			responseBuffer.append(MESSAGE_STATUS_END);
			responseBuffer.append(MESSAGE_BODY_END);
			responseBuffer.append(MESSAGE_END);

			response = responseBuffer.toString();

		} catch (SAXException ex) {
			
			LOG.error("Error in InboundNCPDPMessageServiceImpl:" + ex.getMessage());

			// build error response. To and From are flipped.
			
			responseBuffer.append(TO_QUALIFIER_D);
			responseBuffer.append(messageFrom);
			responseBuffer.append(TO_TAG_END);
			responseBuffer.append(FROM_QUALIFIER_P);
			responseBuffer.append(messageTo);
			responseBuffer.append(FROM_ENG_TAG);
			responseBuffer.append(MESSAGE_ID_START);
			responseBuffer.append(newMessageID);
			responseBuffer.append(MESSAGE_ID_END);
			responseBuffer.append(RELATES_TO_MESSAGE_ID);
			responseBuffer.append(relatesToMessageID);
			responseBuffer.append(RELATES_TO_MESSAGE_ID_END_TAG);
			responseBuffer.append(SENT_TIME_START);
			responseBuffer.append(sentDateString);
			responseBuffer.append(SENT_TIME_EBD);
			responseBuffer.append(MESSAGE_HEADER_END);
			responseBuffer.append(MESSAGE_BODY_START);
			responseBuffer.append(MESSAGE_ERROR_START);
			responseBuffer.append(ERROR_CODE_602);
			responseBuffer.append(ERROR_DESCRIPTION_XSD_VALIDATION);
			responseBuffer.append(MESSAGE_ERROR_END);
			responseBuffer.append(MESSAGE_BODY_END);
			responseBuffer.append(MESSAGE_END);

			response = responseBuffer.toString();

		} catch (Exception e) {

			LOG.error("Error in InboundNCPDPMessageServiceImpl:" + e.getMessage());

			// build error response. To and From are flipped.
			
			responseBuffer.append(TO_QUALIFIER_D);
			responseBuffer.append(messageFrom);
			responseBuffer.append(TO_TAG_END);
			responseBuffer.append(FROM_QUALIFIER_P);
			responseBuffer.append(messageTo);
			responseBuffer.append(FROM_ENG_TAG);
			responseBuffer.append(MESSAGE_ID_START);
			responseBuffer.append(newMessageID);
			responseBuffer.append(MESSAGE_ID_END);
			responseBuffer.append(RELATES_TO_MESSAGE_ID);
			responseBuffer.append(relatesToMessageID);
			responseBuffer.append(RELATES_TO_MESSAGE_ID_END_TAG);
			responseBuffer.append(SENT_TIME_START);
			responseBuffer.append(sentDateString);
			responseBuffer.append(SENT_TIME_EBD);
			responseBuffer.append(MESSAGE_HEADER_END);
			responseBuffer.append(MESSAGE_BODY_START);
			responseBuffer.append(MESSAGE_ERROR_START);
			responseBuffer.append(ERROR_CODE_602);
			responseBuffer.append(ERROR_DESCRIPTION_APPLICATION_ERROR);
			responseBuffer.append(MESSAGE_ERROR_END);
			responseBuffer.append(MESSAGE_BODY_END);
			responseBuffer.append(MESSAGE_END);

			response = responseBuffer.toString();

		} finally {

			StreamUtilities.safeClose(inputStream);
			
			relatesToMessageID = null;
			messageFrom = null;
			messageTo = null;
			incomingMessageID = null;
			
			xsdSource = null;
			xsdStreamSource = null;
			responseBuffer = null;
		}

		return response;
	}

}
