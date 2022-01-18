package gov.va.med.pharmacy.jaxrs.inboundncpdpmessage.service.impl;

import java.io.InputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.concurrent.ThreadLocalRandom;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import gov.va.med.pharmacy.jaxrs.inboundncpdpmessage.service.InboundNCPDPMessageService;
import gov.va.med.pharmacy.persistence.model.InboundNcpdpMsgEntity;
import gov.va.med.pharmacy.persistence.service.InboundNcpdpMsgService;
import gov.va.med.pharmacy.utility.StreamUtilities;
import gov.va.med.pharmacy.ncpdpmsgs.ValidateDigitalSignature;

/**
 * A class that accepts incoming NCPDP message from change healthcare and
 * returns a response.
 *
 */

@Consumes({ "application/xml", "text/xml" })
@Produces("application/xml")
public class InboundNCPDPMessageServiceImpl implements InboundNCPDPMessageService {
	
	private int inb_checkpoint = -1;
	
	private static final String SENDER_SOFTWARE_END = "</SenderSoftware>";

	private static final String SENDER_SOFTWARE_VERSION_RELEASE_ELEMENT = "<SenderSoftwareVersionRelease>v5.0</SenderSoftwareVersionRelease>";

	private static final String SENDER_SOFTWARE_PRODUCT_ELEMENT = "<SenderSoftwareProduct>Inbound ePrescribing</SenderSoftwareProduct>";

	private static final String SENDER_SOFTWARE_DEVELOPER_ELEMENT = "<SenderSoftwareDeveloper>LIBERTY ITS</SenderSoftwareDeveloper>";

	private static final String SENDER_SOFTWARE_START = "<SenderSoftware>";

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
	
	private static final String ERROR_DESCRIPTION_DS_FAIL = "<Description>Digital Signature Verification Failure</Description>";
	
	private static final String ERROR_DESCRIPTION_CERT_REVOKED  = "<Description>Certificate Has Been Revoked</Description>";

	private static final String ERROR_DESCRIPTION_CS_MBM_FAULT = "<Description>This drug is assigned a DEA schedule II. The pharmacy does not fill Schedule II prescriptions.</Description>";
	
	private static final String MESSAGE_ERROR_END = "</Error>";

	private static final String ERROR_DESCRIPTION_XSD_VALIDATION = "<Description>XSD Validation Error</Description>";

	private static final String ERROR_CODE_602 = "<Code>602</Code>";
	
	private static final String ERROR_CODE_900 = "<Code>900</Code>";

	private static final String MESSAGE_ERROR_START = "<Error>";

	private static final String MESSAGE_BODY_END = "</Body>";

	private static final String MESSAGE_STATUS_END = "</Status>";

	private static final String CODE_000 = "<Code>000</Code>";

	private static final String MESSAGE_STATUS_START = "<Status>";

	private static final String MESSAGE_BODY_START = "<Body>";

	private static final String SENT_TIME_END = "</SentTime>";

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
	
	private static final String DIGITAL_SIGNATURE_START = "<DigitalSignature Version=\"1.1\">";
	
	private static final String DIGITAL_SIGNATURE_END = "</DigitalSignature>";
	
	private static final String DIGEST_METHOD_START = "<DigestMethod>";
	
	private static final String DIGEST_METHOD_END = "</DigestMethod>";
	
	private static final String DIGEST_VALUE_START = "<DigestValue>";
	
	private static final String DIGEST_VALUE_END = "</DigestValue>";
	
	private static final String SIGNATURE_VALUE_START = "<SignatureValue>";
	
	private static final String SIGNATURE_VALUE_END = "</SignatureValue>";
	
	private static final String X509_DATA_START = "<X509Data>";
	
	private static final String X509_DATA_END = "</X509Data>";

	private static final String MESSAGE_END = "</Message>";

	
	private static final String MESSAGE_START = "<Message DatatypesVersion=\"20170715\" TransportVersion=\"20170715\" "
			+ "									TransactionDomain=\"SCRIPT\" TransactionVersion=\"20170715\" StructuresVersion=\"20170715\" ECLVersion=\"20170715\">";

	private static final String SENT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	private static final String INB_MSG_DATE_FORMAT = "MMddyyyy.HH.mm.ss.sss";

	private static final String READY_FOR_AUTOCHECK = "0000";

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(InboundNCPDPMessageServiceImpl.class);

	private static final String SCRIPT_VERSION = "2017071";
	
	private boolean DS_failure = false;

	@Autowired
	private InboundNcpdpMsgService inboundNcpdpMsgService;

	
	@POST
	@Path("/inBoundNCPDPMessage2017071/")
	public String getInboundMessage(String incomingMessage) {

		Date receivedDate = new Date();

		String response = null;

		InboundNcpdpMsgEntity inboundeRx;

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
		
		StringBuffer responseBuffer_Ds = new StringBuffer("");
		
		boolean isNotNewRx = false;
		
		String incomingMessageOriginal = incomingMessage;
		
		ValidateDigitalSignature validateDS = new ValidateDigitalSignature(incomingMessageOriginal);

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
 
			// Take a copy of the string to avoid using modified version produced by first XML parser for ValidateDigitalSignature
			/*String incomingMessageOriginal = incomingMessage;*/
			
			InputSource inputparseXML = new InputSource(new StringReader(incomingMessage));
			
			inputparseXML.setEncoding(UTF_8_CONST_STRING);

			xmlReader.parse(inputparseXML);
			
			
			//if(validateDS.getHasDSIndicator() || validateDS.getHasDigitalSignature()) {
			if(validateDS.getDSIndicator() || validateDS.getHasDigitalSignature()) {				
				inb_checkpoint++; //0
				//if(validateDS.getValidation()== false && validateDS.getHasDSIndicator()) {
				/*if(validateDS.getValidation()== false ) {
					inb_checkpoint++; //1
					throw new Exception("Digital Signature Invalid");*/
				validateDS.getValidation();
			/*	}*/
			}

			
			
			// if validation is successful proceed further.
		

			inboundeRx = new InboundNcpdpMsgEntity();


			inboundeRx.setMessageId(incomingMessageID);

			// relates to message ID should be null.
			inboundeRx.setRelToMessageId(null);

			inboundeRx.setErxStatusByPatientChkStatus(READY_FOR_AUTOCHECK);

			inboundeRx.setErxStatusByDrugChkStatus(READY_FOR_AUTOCHECK);

			inboundeRx.setErxStatusByProviderChkStatus(READY_FOR_AUTOCHECK);

			inboundeRx.setErxStatusByMessageStatus(READY_FOR_AUTOCHECK);

			inboundeRx.setPharmacyId(0);

			inboundeRx.setCreatedDate(date);

			inboundeRx.setUpdatedDate(date);

			inboundeRx.setReceivedDate(date);
			
			inboundeRx.setScriptVersion(SCRIPT_VERSION);
			
			//Check to see if script has Digital signature
			//if(validateDS.getHasSignatureVerified()) {
			//Digital Signature Valid: set inbound table columns to show CS script
			 if (validateDS.getHasDSIndicator() && validateDS.getDs_created() && !validateDS.getMbM_fault()) {
				 inb_checkpoint=10; //10 
				inboundeRx.seterxtype("CS");
				inboundeRx.setdigitalsignature("TRUE");
				inboundeRx.setschedule(validateDS.getSchedule());
				inboundeRx.setdonotfill(validateDS.getDoNotFill());
				//Digital Signature Valid: set Digital Signature information
				//StringBuffer responseBuffer_Ds = new StringBuffer(DIGITAL_SIGNATURE_START);
				String emptyStr = new String("");
				responseBuffer_Ds.append(DIGEST_METHOD_START);
				responseBuffer_Ds.append((validateDS.getIncomingMsg_DigestMethod()==null)? emptyStr:validateDS.getIncomingMsg_DigestMethod());
				responseBuffer_Ds.append(DIGEST_METHOD_END);
				responseBuffer_Ds.append(DIGEST_VALUE_START);
				responseBuffer_Ds.append((validateDS.getCreatedeRxDigestString()==null)? emptyStr : validateDS.getCreatedeRxDigestString());
				responseBuffer_Ds.append(DIGEST_VALUE_END);
				responseBuffer_Ds.append(SIGNATURE_VALUE_START);
				responseBuffer_Ds.append((validateDS.getCreatedDigitalSignatureString()==null)? emptyStr : validateDS.getCreatedDigitalSignatureString());
				responseBuffer_Ds.append(SIGNATURE_VALUE_END);
				responseBuffer_Ds.append(X509_DATA_START);
				responseBuffer_Ds.append((validateDS.getTestingPubKeyString()==null)? emptyStr : validateDS.getTestingPubKeyString());
				responseBuffer_Ds.append(X509_DATA_END);

				// set Digital Signature data inbound Message
				String dsTrue_Str = new String ("<DigitalSignatureIndicator>true</DigitalSignatureIndicator>");
				incomingMessage = incomingMessage.replace(dsTrue_Str, responseBuffer_Ds.toString());
				 inb_checkpoint++; //11
				
			 }
			 else if (validateDS.getHasDigitalSignature() && (validateDS.getSignatureVerified()==true )) {
				//Digital Signature Valid: set inbound table columns to show CS script
				inboundeRx.seterxtype("CS");
				inboundeRx.setdigitalsignature("VERIFIED");
				 inb_checkpoint=20; //20
				inboundeRx.setschedule(validateDS.getSchedule());
				inboundeRx.setdonotfill(validateDS.getDoNotFill());
				 inb_checkpoint++; //21
				//HasDigitalSignature already and Varify Digital Signature successfully
				String emptyStr = new String("");
				responseBuffer_Ds.append(DIGITAL_SIGNATURE_START);
				responseBuffer_Ds.append(DIGEST_METHOD_START);
				responseBuffer_Ds.append((validateDS.getIncomingMsg_DigestMethod() == null)? emptyStr:validateDS.getIncomingMsg_DigestMethod());
				responseBuffer_Ds.append(DIGEST_METHOD_END);
				responseBuffer_Ds.append(DIGEST_VALUE_START);
				responseBuffer_Ds.append((validateDS.geteRxDigestString()==null)? emptyStr : validateDS.geteRxDigestString());
				responseBuffer_Ds.append(DIGEST_VALUE_END);
				responseBuffer_Ds.append(SIGNATURE_VALUE_START);
				responseBuffer_Ds.append((validateDS.getsigToVerifyString()==null)? emptyStr : validateDS.getsigToVerifyString());
				responseBuffer_Ds.append(SIGNATURE_VALUE_END);
				responseBuffer_Ds.append(X509_DATA_START);
				responseBuffer_Ds.append((validateDS.geteRxX509DataString()==null)? emptyStr : validateDS.geteRxX509DataString());
				responseBuffer_Ds.append(X509_DATA_END);
				responseBuffer_Ds.append(DIGITAL_SIGNATURE_END);
				 inb_checkpoint++; //22
				
				}		 
			//}
			else if (validateDS.getMbM_fault() || (validateDS.getHasDigitalSignature() && (validateDS.getSignatureVerified()==false ))) {
				    inb_checkpoint=30; //30 
					inboundeRx.seterxtype("CS");
					inboundeRx.setdigitalsignature("FAILED");
					inboundeRx.setschedule(validateDS.getSchedule());
					inboundeRx.setdonotfill(validateDS.getDoNotFill());
					inboundeRx.setErxStatusByMessageStatus("3006"); //NCPDP_MSG_INVALID
					
					if(validateDS.getMbM_fault())
					{
						//inboundeRx.setErxStatusByMessageStatus("30061");
						//inboundeRx.setMessageType("Error");
					}
					
					inb_checkpoint++; //31
					String emptyStr = new String("");
					responseBuffer_Ds.append(DIGITAL_SIGNATURE_START);
					responseBuffer_Ds.append(DIGEST_METHOD_START);
					responseBuffer_Ds.append((validateDS.getIncomingMsg_DigestMethod()==null)? emptyStr:validateDS.getIncomingMsg_DigestMethod());
					responseBuffer_Ds.append(DIGEST_METHOD_END);
					responseBuffer_Ds.append(DIGEST_VALUE_START);
					responseBuffer_Ds.append((validateDS.geteRxDigestString()==null)? emptyStr : validateDS.geteRxDigestString());
					responseBuffer_Ds.append(DIGEST_VALUE_END);
					responseBuffer_Ds.append(SIGNATURE_VALUE_START);
					responseBuffer_Ds.append((validateDS.getsigToVerifyString()==null)? emptyStr : validateDS.getsigToVerifyString());
					responseBuffer_Ds.append(SIGNATURE_VALUE_END);
					responseBuffer_Ds.append(X509_DATA_START);
					responseBuffer_Ds.append((validateDS.geteRxX509DataString()==null)? emptyStr : validateDS.geteRxX509DataString());
					responseBuffer_Ds.append(X509_DATA_END);
					responseBuffer_Ds.append(DIGITAL_SIGNATURE_END);
					inb_checkpoint++; //32
			 }
			else if ( (validateDS.getDSIndicator() == true) && (validateDS.getHasDSIndicator() == false) && ( validateDS.getHasDigitalSignature() == false)) {
				inboundeRx.seterxtype("NONCS");
				inboundeRx.setdigitalsignature("FALSE");
				inboundeRx.setschedule(validateDS.getSchedule());
				inboundeRx.setdonotfill(validateDS.getDoNotFill());
//				inboundeRx.setErxStatusByMessageStatus("3006"); //NCPDP_MSG_INVALID
				
			}
 /**/			
				//Digital Signature not present also no Digital Signature Indicator: set inbound table to show NONCS script
			else { 
				inboundeRx.seterxtype("NONCS");
				inboundeRx.setdigitalsignature("NULL");
				inboundeRx.setschedule(validateDS.getSchedule());
				inboundeRx.setdonotfill(validateDS.getDoNotFill());
			 }
			
			//inb_checkpoint=40; //40 
			inboundeRx.setMessage(incomingMessage);
			//inb_checkpoint++; //41
			inboundNcpdpMsgService.saveInboundERx(inboundeRx);
			//inb_checkpoint++; //42
			
/* CS DS indicator is false - throw exception */
			if  ((validateDS.getHasDigitalSignature() && validateDS.getSignatureVerified()==false)  || validateDS.getMbM_fault())
			{
				
				//inb_checkpoint = 98;
				DS_failure = true;
				throw new Exception("Digital Signature Invalid");
				
			}
			
			//inb_checkpoint = 99;
/*			
			if    ( (validateDS.getDSIndicator() == true) && (validateDS.getHasDSIndicator() == false) && ( validateDS.getHasDigitalSignature() == false))  
			{
				throw new Exception("Digital Signature Indicator false");  
				 }
*/				 
			
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
			responseBuffer.append(SENT_TIME_END);
			// sender software start 201707
			
			//responseBuffer.append("CA URLs: ");
			//responseBuffer.append(validateDS.getCRL_URL());
			
			
			responseBuffer.append(SENDER_SOFTWARE_START);
			responseBuffer.append(SENDER_SOFTWARE_DEVELOPER_ELEMENT);
			responseBuffer.append(SENDER_SOFTWARE_PRODUCT_ELEMENT);
			responseBuffer.append(SENDER_SOFTWARE_VERSION_RELEASE_ELEMENT);
			responseBuffer.append(SENDER_SOFTWARE_END);
			// sender software end.
			//DS 
			/*
			if (validateDS.getHasDSIndicator() && validateDS.getDs_created())
				{
				inb_checkpoint++; //43
					responseBuffer.append(DIGITAL_SIGNATURE_START);
					responseBuffer.append(responseBuffer_Ds);
					responseBuffer.append(DIGITAL_SIGNATURE_END);
				}
			else if(validateDS.getHasSignatureVerified())
			{
				responseBuffer.append(responseBuffer_Ds);
			}
			
			responseBuffer.append("ElementsToSignWith:");
			responseBuffer.append(validateDS.getElementsToSignWith());
			responseBuffer.append(" Checkpoint:");
			responseBuffer.append(validateDS.getCheckpoint());
            */
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
			
			LOG.error("Error in SAXParse InboundNCPDPMessageServiceImpl:" + ex.getMessage());

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
			responseBuffer.append(SENT_TIME_END);
			// sender software start 201707
			responseBuffer.append(SENDER_SOFTWARE_START);
			responseBuffer.append(SENDER_SOFTWARE_DEVELOPER_ELEMENT);
			responseBuffer.append(SENDER_SOFTWARE_PRODUCT_ELEMENT);
			responseBuffer.append(SENDER_SOFTWARE_VERSION_RELEASE_ELEMENT);
			responseBuffer.append(SENDER_SOFTWARE_END);
			// sender software end.
			
	/*		//DEBUG CODE
			// Append SAXParseDS for testing 
			String emptyStr = new String("");
    		responseBuffer.append("SAXParseDS and CheckPoint:");
  			responseBuffer.append(validateDS.getCheckpoint());
  			responseBuffer.append("inb_checkpoint:");
  			responseBuffer.append(inb_checkpoint);
  			responseBuffer.append("TestingPubKey:");
			responseBuffer.append((validateDS.getTestingPubKeyString()==null)? "-null-" : validateDS.getTestingPubKeyString());
			responseBuffer.append("DigestMethod:");
			responseBuffer.append((validateDS.getIncomingMsg_DigestMethod()==null)? "-null" :validateDS.getIncomingMsg_DigestMethod());
			responseBuffer.append("CreatedeRxDigest:");
			responseBuffer.append((validateDS.getCreatedeRxDigestString()==null)? "-null-" : validateDS.getCreatedeRxDigestString());
			responseBuffer.append("CreatedDigitalSignature:");
			responseBuffer.append((validateDS.getCreatedDigitalSignatureString()==null)? "-null" : validateDS.getCreatedDigitalSignatureString());
			responseBuffer.append("X509 Data:");
			responseBuffer_Ds.append((validateDS.geteRxX509DataString()==null)? emptyStr : validateDS.geteRxX509DataString());
			responseBuffer.append("ElementsToSignWith:");
			responseBuffer.append(validateDS.getElementsToSignWith());
			responseBuffer.append("CA URLs: ");
			responseBuffer.append(validateDS.getCRL_URL());
			responseBuffer.append(" ERROR: " + validateDS.getErrorMessage());
	*/		
			responseBuffer.append(MESSAGE_HEADER_END);
			
			responseBuffer.append(MESSAGE_BODY_START);
			responseBuffer.append(MESSAGE_ERROR_START);
/*			responseBuffer.append(ERROR_CODE_602); */
			responseBuffer.append(ERROR_CODE_900);
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
			responseBuffer.append(SENT_TIME_END);
			// sender software start 201707
			responseBuffer.append(SENDER_SOFTWARE_START);
			responseBuffer.append(SENDER_SOFTWARE_DEVELOPER_ELEMENT);
			responseBuffer.append(SENDER_SOFTWARE_PRODUCT_ELEMENT);
			responseBuffer.append(SENDER_SOFTWARE_VERSION_RELEASE_ELEMENT);
			responseBuffer.append(SENDER_SOFTWARE_END);
			// sender software end.
/*			responseBuffer.append("Invalid Digital Signature");
			responseBuffer.append("CheckPoint:");
  			responseBuffer.append(validateDS.getCheckpoint());
  			responseBuffer.append("inb_checkpoint:");
  			responseBuffer.append(inb_checkpoint);
 			
  		
			//DEBUG CODE
			String emptyStr = new String("");	
			responseBuffer.append(DIGITAL_SIGNATURE_START);
			responseBuffer.append(DIGEST_METHOD_START);
			responseBuffer.append((validateDS.getIncomingMsg_DigestMethod()==null)? "-null-" :validateDS.getIncomingMsg_DigestMethod());
			responseBuffer.append(DIGEST_METHOD_END);
			responseBuffer.append(DIGEST_VALUE_START);
			//responseBuffer.append((validateDS.getCreatedeRxDigestString()==null)? "-null-" : validateDS.getCreatedeRxDigestString());
			responseBuffer.append(validateDS.getDigestValueString());
			responseBuffer.append(DIGEST_VALUE_END);
			responseBuffer.append(SIGNATURE_VALUE_START);
			//responseBuffer.append((validateDS.getCreatedDigitalSignatureString()==null)? "-null-" : validateDS.getCreatedDigitalSignatureString());
			responseBuffer.append(validateDS.getSigToVerifyString());
			responseBuffer.append(SIGNATURE_VALUE_END);
			responseBuffer.append(X509_DATA_START);
			//responseBuffer.append((validateDS.getTestingPubKeyString()==null)? "-null-" : validateDS.getTestingPubKeyString());
			//responseBuffer_Ds.append((validateDS.geteRxX509DataString()==null)? emptyStr : validateDS.geteRxX509DataString());
			responseBuffer.append(validateDS.geteRxX509DataString());
			responseBuffer.append(" ERROR: " + validateDS.getErrorMessage());
			responseBuffer.append(X509_DATA_END);
			responseBuffer.append(DIGITAL_SIGNATURE_END);
			responseBuffer.append("ElementsToSignWith:");
			responseBuffer.append(validateDS.getElementsToSignWith());
	 		responseBuffer.append(" Checkpoint:");
			responseBuffer.append(validateDS.getCheckpoint());
		*/	//responseBuffer.append(" inbound Checkpoint:");
			//responseBuffer.append(inb_checkpoint);
			
		    responseBuffer.append(MESSAGE_HEADER_END);
			responseBuffer.append(MESSAGE_BODY_START);
			responseBuffer.append(MESSAGE_ERROR_START);
			
			//<SenderSoftwareVersionRelease>V5.0</SenderSoftwareVersionRelease>
			if(validateDS.isCertRevoked())
			{
				responseBuffer.append(ERROR_CODE_602);
				responseBuffer.append(ERROR_DESCRIPTION_CERT_REVOKED);				
			}
				
			else if(validateDS.getMbM_fault()) {
				responseBuffer.append(ERROR_CODE_602);
				responseBuffer.append(ERROR_DESCRIPTION_CS_MBM_FAULT);
			}
			
			else if(DS_failure) {
				responseBuffer.append(ERROR_CODE_602);
				responseBuffer.append(ERROR_DESCRIPTION_DS_FAIL);
			}
			
			else {
				responseBuffer.append(ERROR_CODE_900);
				responseBuffer.append(ERROR_DESCRIPTION_APPLICATION_ERROR);
			}
		
			//Additional Debug code
	/*		responseBuffer.append("CA URLs: ");
			responseBuffer.append(validateDS.getCRL_URL());
			responseBuffer.append(" ERROR: " + validateDS.getErrorMessage());
			responseBuffer.append(" Cert Serial #: ");
			responseBuffer.append(validateDS.getCertSerialNumber());
			responseBuffer.append(" REVOKE REASON: ");
			responseBuffer.append(validateDS.getRevokeReason());
	*/
			responseBuffer.append(MESSAGE_ERROR_END);
			responseBuffer.append(MESSAGE_BODY_END);
			responseBuffer.append(MESSAGE_END);

			response = responseBuffer.toString();

		} finally {

			StreamUtilities.safeClose(inputStream);
			
			inboundeRx = null;
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
