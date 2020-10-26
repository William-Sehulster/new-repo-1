package gov.va.med.pharmacy.jaxrs.vistaoutboundmsg.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXB;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import gov.va.med.pharmacy.jaxrs.vistaoutboundmsg.model.VistaOutboundResponse;
import gov.va.med.pharmacy.jaxrs.vistaoutboundmsg.service.VistaOutboundMsg;
import gov.va.med.pharmacy.ncpdpmsgs.MessageType;
import gov.va.med.pharmacy.persistence.model.InboundNcpdpMsgEntity;
import gov.va.med.pharmacy.persistence.model.OutboundNcpdpMsgEntity;
import gov.va.med.pharmacy.persistence.service.InboundNcpdpMsgService;
import gov.va.med.pharmacy.persistence.service.OutboundNcpdpMsgService;
import gov.va.med.pharmacy.utility.StreamUtilities;
/**
 * A class that implement saves vista outbound message which are coming from
 * vista and sends response back in JSON.
 *
 */

@Consumes({ "application/x-www-form-urlencoded", "application/xml", "text/xml" })
@Produces("application/xml")
public class VistaOutboundMsgImpl implements VistaOutboundMsg {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager
			.getLogger(VistaOutboundMsgImpl.class);

	private static final String SCRIPT_VERSION = "2017071";

	private static final String LOAD_EXTERNAL_DTD = "http://apache.org/xml/features/nonvalidating/load-external-dtd";

	private static final String EXTERNAL_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities";

	private static final String EXTERNAL_GENERAL_ENTITIES = "http://xml.org/sax/features/external-general-entities";

	private static final String SECURE_PROCESSING_CONST_STRING = "http://javax.xml.XMLConstants/feature/secure-processing";

	private static final String VA_EMD_NCPDP_SCRIPT_10_6_XSD = "VA_EMD_NCPDP_SCRIPT_10_6.xsd";

	private static final String UTF_8_CONST_STRING = "UTF-8";

	@Autowired
	private OutboundNcpdpMsgService outboundNcpdpMsgService;
	
	@Autowired
	private InboundNcpdpMsgService inboundNcpdpMsgService;

	@POST
	@Path("/processMessage/")
	public VistaOutboundResponse persistMessage(@FormParam("xmlRequest") String messageStr) {

		VistaOutboundResponse wsResponse = new VistaOutboundResponse();
		try {

			OutboundNcpdpMsgEntity outboundMsg = new OutboundNcpdpMsgEntity();

			StringReader reader = new StringReader(messageStr);

			outboundMsg.setMessage(JAXB.unmarshal(reader, MessageType.class));

			outboundMsg.setErxStatus("0000");

			outboundMsg.setPharmacyId(0);

			Date date = new Date();

			outboundMsg.setCreatedDate(date);

			outboundMsg.setUpdatedDate(date);

			outboundMsg.setReceivedDate(date);

			outboundMsg.setScriptVersion(SCRIPT_VERSION);

			long outboundMsgId = outboundNcpdpMsgService.saveOutboundMsg(outboundMsg);

			// System.out.println("------------------- Return id:" + outboundMsgId);

			wsResponse.setErrorMessage(null);

			wsResponse.setSuccess(true);

			wsResponse.setOutboundMsgId(outboundMsgId);

		} catch (Exception e) {

			LOG.error("Error in VistaOutboundMsgImpl:" + e.getMessage());

			wsResponse.setSuccess(false);

			wsResponse.setErrorMessage("Error while saving vista outbound message: " + e.getMessage());

			wsResponse.setOutboundMsgId(0);
		}

		return wsResponse;
	}

	@POST
	@Path("/processXMLMessage/")
	public VistaOutboundResponse persistXMLMessage(String message) {

		VistaOutboundResponse wsResponse = new VistaOutboundResponse();

		InputStream inputStream = null;

		StreamSource xsdStreamSource = null;

		Source xsdSource = null;
		
		SchemaFactory schemaFactory = null;
		
		Schema schema = null;

		SAXParserFactory saxParserFactory = null;
		
		SAXParser saxparser = null;

		XMLReader xmlReader = null;
		
		StringBuffer renewalRequestMsgBuffer = null;

		StringBuffer pharmacyNumberBuffer = null;

		StringBuffer pharmacyNumberExtensionBuffer = null;

		StringBuffer renewalRequestMsgPharmacyBuffer = new StringBuffer();

		StringBuffer renewalRequestMsgPrescriberBuffer = new StringBuffer();

		StringBuffer prescriberNumberBuffer = null;

		StringBuffer prescriberNumberExtensionBuffer = null;

		StringBuffer renewalRequestMsgSupervisorBuffer = null;

		StringBuffer supervisorNumberBuffer = null;

		StringBuffer supervisorNumberExtensionBuffer = null;

		StringBuffer renewalRequestMsgMedicationPrescribedBuffer = new StringBuffer();

		StringBuffer renewalRequestMsgMedicationDispensedBuffer = new StringBuffer();

		StringBuffer renewalRequestMsgMedicationPrescribedSigBuffer = null;

		StringBuffer renewalRequestMsgMedicationDispensedSigBuffer = null;

		StringBuffer patientNumberBuffer = null;

		StringBuffer patientNumberBufferExtension = null;
		
		StringBuffer patientNumberTypeBuffer = new StringBuffer();
		
		StringBuffer renewalRequestMsgMedicationPrescribedSubstitutionsBuf = new StringBuffer();
		
		StringBuffer renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf = null;
		
		String substitutionsValue = null;
		
		StreamResult formattedXMLString = null;
		
		Source inputXMLString =  null;
		
		TransformerFactory transformerFactory = null;				
		
		Transformer  transformer = null;
		
		XMLInputFactory xmlInputFactory = null;

		XMLEventReader eventReader = null;
		
		String relatesToMesageId = null;
		
		String numberOfRefills = null;
		
		String quantityUnitOfMeasure = null; 
		
		String newRxMsg = null;

		try {

			OutboundNcpdpMsgEntity outboundMsg = new OutboundNcpdpMsgEntity();

			// First of all check the version of the message. Whether it's 10.6 or 20170715.

			// if it's 10.6 then do the translation to 20170715 and only do for
			// RefillRequest.

			if ((StringUtils.isNotEmpty(message)) && (message.indexOf("TransportVersion") == -1)
					&& (message.indexOf("TransactionVersion") == -1) && (message.indexOf("release=\"006\"") != -1)
					&& (message.indexOf("RefillRequest") != -1)) {

				// System.out.println("============ Inside Migration segment.....");

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

				// v20170715 translation

				// Message - Start
				// </Header> - Start
				renewalRequestMsgBuffer = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
						+ "<Message DatatypesVersion=\"20170715\" TransportVersion=\"20170715\" TransactionDomain=\"SCRIPT\" TransactionVersion=\"20170715\" StructuresVersion=\"20170715\" ECLVersion=\"20170715\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ><Header>");

				// use stax parser to parse and extract values.

				// TODO - use stax2 com.fasterxml.woodstox

							
				// Format String xml before parsing it.			
				
				transformerFactory = TransformerFactory.newInstance();	
				
				transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
				
				//transformerFactory.setAttribute("http://javax.xml.XMLConstants/property/accessExternalDTD", "");
				
				//transformerFactory.setAttribute("http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
								
				transformer = transformerFactory.newTransformer();
				
				transformer.setParameter("http://javax.xml.XMLConstants/property/accessExternalDTD", "false");
				
				transformer.setParameter("http://javax.xml.XMLConstants/property/accessExternalStylesheet", "false");
			
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				
				
				formattedXMLString = new StreamResult(new StringWriter());
				
				inputXMLString =  new StreamSource(new StringReader(message));
				
				transformer.transform(inputXMLString, formattedXMLString);
				
				
				//formatted xml string.
				
				message = formattedXMLString.getWriter().toString();
				  
				//System.out.println("---------- Formatted String xml: "+message);	
				
				// Now query the NewRx for this 10.6 RefillRequest.
				
						
				if (message.indexOf("<RelatesToMessageID>") != -1) {

					
					relatesToMesageId = message.substring(message.indexOf("<RelatesToMessageID>") + 20,	message.indexOf("</RelatesToMessageID>"));
						

				}
				
				//System.out.println("------ NewRx MessageID:"+relatesToMesageId);
				
				InboundNcpdpMsgEntity inboundNcpdpMsgEntity = inboundNcpdpMsgService.findByMessageId(relatesToMesageId);
				
				if(null!=inboundNcpdpMsgEntity) {
				
					 newRxMsg = inboundNcpdpMsgEntity.getMessage();
				}
				
				
				
				//System.out.println("------ NewRx Queried Message:"+newRxMsg);
				
				if(null!=newRxMsg) {
					
					if (newRxMsg.indexOf("<PotencyUnitCode>") != -1) {

						
						quantityUnitOfMeasure = newRxMsg.substring(newRxMsg.indexOf("<PotencyUnitCode>") + 17,	newRxMsg.indexOf("</PotencyUnitCode>"));
							

					}
					
					if (message.indexOf("<Refills>") != -1) {

						
						String tempStr  = newRxMsg.substring(newRxMsg.indexOf("<Refills>") + 47,	newRxMsg.indexOf("</Refills>"));
						
						if(StringUtils.isNotEmpty(tempStr) && tempStr.indexOf("<Value>") != -1) {
							
							numberOfRefills = tempStr.substring(tempStr.indexOf("<Value>") + 7,	tempStr.indexOf("</Value>"));
							
						}
							

					}
					
					// System.out.println("----------- quantityUnitOfMeasure:"+quantityUnitOfMeasure);
					 
					 //System.out.println("----------- numberOfRefills:"+numberOfRefills);
					
				}
				
				
				xmlInputFactory = XMLInputFactory.newInstance();
				
				xmlInputFactory.setProperty("javax.xml.stream.isSupportingExternalEntities", false);

				eventReader = xmlInputFactory.createXMLEventReader(new StringReader(message));

				//  iterator based api which creates event objects.

				boolean cardHolderNameElementchecked = false;

				boolean patientNameElementchecked = false;				

				boolean patientCommunicationNumbersEnded = false;			

				boolean setPharmacyElements = false;

				boolean setPrescriberElements = false;

				boolean setPrescriberName = false;	
				
				boolean setPrescriberNameShortElement = false;	

				boolean setPrescriberAgentName = false;				

				boolean prescriberCommunicationNumbersEnded = false;

				boolean supervisorCommunicationNumbersEnded = false;

				boolean setSupervisorName = false;

				boolean setSupervisorElements = false;				

				boolean setMedicationPrescribedElements = false;

				boolean medicationPrescribedWrittenDate = false;

				boolean medicationPrescribeRefillQualifier = false;
				
				boolean medicationPrescribeRefillQualifierPRN = false;

				boolean setMedicationDispensedElements = false;

				boolean medicationPrescribedExpirationDate = false;

				boolean medicationPrescribedEffectiveDate = false;

				boolean medicationPrescribedPeriodEndDate = false;

				boolean medicationPrescribedDateValidated = false;

				boolean medicationPrescribedPriorAuthorizationValue = false;

				boolean medicationDispensedRefillValue = false;

				boolean medicationDispensedWrittenDate = false;

				boolean medicationDispensedLastFillDate = false;

				boolean medicationDispensedPriorAuthorizationValue = false;

				//boolean setObservationElements = false;
				
				LinkedHashMap<String, StringBuffer> patientNumberMap = new LinkedHashMap<String, StringBuffer>();

				while (eventReader.hasNext()) {
					// Move to next event

					XMLEvent xmlNextEvent = eventReader.nextEvent();

					// Check for start element.
					if (xmlNextEvent.isStartElement()) {

						StartElement startElement = xmlNextEvent.asStartElement();

						// To
						if (("To").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<To Qualifier=\"D\">");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</To>");
						}

						// From
						else if (("From").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<From Qualifier=\"P\">");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</From>");
						}

						// MessageID
						else if (("MessageID").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<MessageID>");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</MessageID>");
						}

						// RelatesToMessageID
						else if (("RelatesToMessageID").equals(startElement.getName().getLocalPart())) {
							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<RelatesToMessageID>");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</RelatesToMessageID>");
						}

						// SentTime
						else if (("SentTime").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<SentTime>");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</SentTime>");
						}

						// Security - Start
						else if (("Security").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<Security>");
						}

						// Sender
						else if (("Sender").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<Sender>");

						}

						// Sender/Receiver - TertiaryIdentification
						else if (("TertiaryIdentification").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<TertiaryIdentification>");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</TertiaryIdentification>");

						}

						// Receiver
						else if (("Receiver").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<Receiver>");
						}

						// RxReferenceNumber
						else if (("RxReferenceNumber").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<RxReferenceNumber>");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</RxReferenceNumber>");
						}

						// PrescriberOrderNumber
						else if (("PrescriberOrderNumber").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<PrescriberOrderNumber>");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</PrescriberOrderNumber>");
						}

						// Body - Start
						else if (("Body").equals(startElement.getName().getLocalPart())) {

							renewalRequestMsgBuffer.append("<Body>");
							xmlNextEvent = eventReader.nextEvent();

						}

						// RxRenewalRequest - Start
						else if (("RefillRequest").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();

							renewalRequestMsgBuffer.append("<RxRenewalRequest>");

						}

						// Pharmacy - Start
						if (("Pharmacy").equals(startElement.getName().getLocalPart())) {

							

							renewalRequestMsgPharmacyBuffer.append("<Pharmacy>");

							setPharmacyElements = true;

							xmlNextEvent = eventReader.nextEvent();

						}

						if (setPharmacyElements == true) {

							if (("Identification").equals(startElement.getName().getLocalPart())) {

								renewalRequestMsgPharmacyBuffer.append("<Identification>");

								xmlNextEvent = eventReader.nextEvent();

							}

							if (("NCPDPID").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPharmacyBuffer.append("<NCPDPID>");
								renewalRequestMsgPharmacyBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPharmacyBuffer.append("</NCPDPID>");

							} else if (("NPI").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPharmacyBuffer.append("<NPI>");
								renewalRequestMsgPharmacyBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPharmacyBuffer.append("</NPI>");

								renewalRequestMsgPharmacyBuffer.append("</Identification>");

													
								

							}

							else if (("StoreName").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPharmacyBuffer.append("<BusinessName>");
								renewalRequestMsgPharmacyBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPharmacyBuffer.append("</BusinessName>");

							}

							else if (("Address").equals(startElement.getName().getLocalPart())) {

								renewalRequestMsgPharmacyBuffer.append("<Address>");
								xmlNextEvent = eventReader.nextEvent();

							}

							else if (("AddressLine1").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPharmacyBuffer.append("<AddressLine1>");
								renewalRequestMsgPharmacyBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPharmacyBuffer.append("</AddressLine1>");

							}

							else if (("AddressLine2").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPharmacyBuffer.append("<AddressLine2>");
								renewalRequestMsgPharmacyBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPharmacyBuffer.append("</AddressLine2>");

							}

							else if (("City").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgPharmacyBuffer.append("<City>");
								renewalRequestMsgPharmacyBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPharmacyBuffer.append("</City>");

							}

							else if (("State").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgPharmacyBuffer.append("<StateProvince>");
								renewalRequestMsgPharmacyBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPharmacyBuffer.append("</StateProvince>");

							}

							else if (("ZipCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgPharmacyBuffer.append("<PostalCode>");
								renewalRequestMsgPharmacyBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPharmacyBuffer.append("</PostalCode>");
								
								renewalRequestMsgPharmacyBuffer.append("<CountryCode>");
								renewalRequestMsgPharmacyBuffer.append("US");
								renewalRequestMsgPharmacyBuffer.append("</CountryCode>");


								renewalRequestMsgPharmacyBuffer.append("</Address>");

							}

							else if (("CommunicationNumbers").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgPharmacyBuffer.append("<CommunicationNumbers>");

							}

							else if (("Number").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								pharmacyNumberBuffer = new StringBuffer();

								String pharmacyNumberExtensionValue = xmlNextEvent.asCharacters().getData();

								if (StringUtils.isNotEmpty(pharmacyNumberExtensionValue) && pharmacyNumberExtensionValue.contains("@")) {

									pharmacyNumberBuffer.append(xmlNextEvent.asCharacters().getData());

								} else if (StringUtils.isNotEmpty(pharmacyNumberExtensionValue) && pharmacyNumberExtensionValue.contains("X")) {

									pharmacyNumberExtensionBuffer = new StringBuffer();

									pharmacyNumberExtensionBuffer
											.append(pharmacyNumberExtensionValue.substring(pharmacyNumberExtensionValue.indexOf("X") + 1, pharmacyNumberExtensionValue.length()));

									pharmacyNumberBuffer.append("<Number>");

									pharmacyNumberBuffer.append(pharmacyNumberExtensionValue.substring(0, pharmacyNumberExtensionValue.indexOf("X")));

									pharmacyNumberBuffer.append("</Number>");

								} else if (StringUtils.isNotEmpty(pharmacyNumberExtensionValue) && pharmacyNumberExtensionValue.contains("x")) {

									pharmacyNumberExtensionBuffer = new StringBuffer();

									pharmacyNumberExtensionBuffer
											.append(pharmacyNumberExtensionValue.substring(pharmacyNumberExtensionValue.indexOf("x") + 1, pharmacyNumberExtensionValue.length()));

									pharmacyNumberBuffer.append("<Number>");

									pharmacyNumberBuffer.append(pharmacyNumberExtensionValue.substring(0, pharmacyNumberExtensionValue.indexOf("x")));

									pharmacyNumberBuffer.append("</Number>");

								} else {

									pharmacyNumberBuffer.append("<Number>");
									pharmacyNumberBuffer.append(xmlNextEvent.asCharacters().getData());
									pharmacyNumberBuffer.append("</Number>");
								}

							}

							else if (("Qualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								String numberQualifer = xmlNextEvent.asCharacters().getData();

								if (("HP").equals(numberQualifer)) {

									renewalRequestMsgPharmacyBuffer.append("<HomeTelephone>");

									renewalRequestMsgPharmacyBuffer.append(pharmacyNumberBuffer);									

									renewalRequestMsgPharmacyBuffer.append("</HomeTelephone>");

								}

								else if (("TE").equals(numberQualifer)) {

									renewalRequestMsgPharmacyBuffer.append("<PrimaryTelephone>");

									renewalRequestMsgPharmacyBuffer.append(pharmacyNumberBuffer);

									if (pharmacyNumberExtensionBuffer != null) {

										renewalRequestMsgPharmacyBuffer.append("<Extension>");
										renewalRequestMsgPharmacyBuffer.append(pharmacyNumberExtensionBuffer);
										renewalRequestMsgPharmacyBuffer.append("</Extension>");
									}

									

									renewalRequestMsgPharmacyBuffer.append("</PrimaryTelephone>");

								}

								else if (("FX").equals(numberQualifer)) {

									renewalRequestMsgPharmacyBuffer.append("<Fax>");

									renewalRequestMsgPharmacyBuffer.append(pharmacyNumberBuffer);

									
									renewalRequestMsgPharmacyBuffer.append("</Fax>");

								} else if (("WP").equals(numberQualifer)) {

									renewalRequestMsgPharmacyBuffer.append("<WorkTelephone>");

									renewalRequestMsgPharmacyBuffer.append(pharmacyNumberBuffer);

									if (pharmacyNumberExtensionBuffer != null) {

										renewalRequestMsgPharmacyBuffer.append("<Extension>");
										renewalRequestMsgPharmacyBuffer.append(pharmacyNumberExtensionBuffer);
										renewalRequestMsgPharmacyBuffer.append("</Extension>");
									}

									

									renewalRequestMsgPharmacyBuffer.append("</WorkTelephone>");

								}

								else if (("NP").equals(numberQualifer)) {

									renewalRequestMsgPharmacyBuffer.append("<OtherTelephone>");

									renewalRequestMsgPharmacyBuffer.append(pharmacyNumberBuffer);

									renewalRequestMsgPharmacyBuffer.append("</OtherTelephone>");

								}

								// - Need to check CP

								else if (("CP").equals(numberQualifer)) {

									renewalRequestMsgPharmacyBuffer.append("<OtherTelephone>");

									renewalRequestMsgPharmacyBuffer.append(pharmacyNumberBuffer);

									renewalRequestMsgPharmacyBuffer.append("</OtherTelephone>");

								}

								else if (("BN").equals(numberQualifer)) {

									renewalRequestMsgPharmacyBuffer.append("<Beeper>");

									renewalRequestMsgPharmacyBuffer.append(pharmacyNumberBuffer);

									

									renewalRequestMsgPharmacyBuffer.append("</Beeper>");

								}

								else if (("EM").equals(numberQualifer)) {

									renewalRequestMsgPharmacyBuffer.append("<ElectronicMail>");

									renewalRequestMsgPharmacyBuffer.append(pharmacyNumberBuffer);

									renewalRequestMsgPharmacyBuffer.append("</ElectronicMail>");

								}

							}

						}

						// BenefitsCoordination - Start
						if (("BenefitsCoordination").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();

							renewalRequestMsgBuffer.append("<BenefitsCoordination>");

						}

						// CardholderID
						if (("CardholderID").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();

							renewalRequestMsgBuffer.append("<CardholderID>");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</CardholderID>");
						}

						// CardHolderName - Start
						if (("CardHolderName").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();

							renewalRequestMsgBuffer.append("<CardHolderName>");

							cardHolderNameElementchecked = true;

						}

						// This block should only be executed once.
						if (cardHolderNameElementchecked == true) {

							// LastName
							if (("LastName").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<LastName>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</LastName>");

							}

							// FirstName
							if (("FirstName").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgBuffer.append("<FirstName>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</FirstName>");

							}

							// MiddleName
							if (("MiddleName").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<MiddleName>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</MiddleName>");

							}

							// Suffix
							if (("Suffix").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgBuffer.append("<Suffix>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</Suffix>");

							}

							// Prefix
							if (("Prefix").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgBuffer.append("<Prefix>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</Prefix>");

							}

						}

						// GroupID
						if (("GroupID").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();
							renewalRequestMsgBuffer.append("<GroupID>");
							renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
							renewalRequestMsgBuffer.append("</GroupID>");

						}

						// Patient - Start
						if (("Patient").equals(startElement.getName().getLocalPart())) {

							xmlNextEvent = eventReader.nextEvent();

							// Patient - Start
							renewalRequestMsgBuffer.append("<Patient>");

							renewalRequestMsgBuffer.append("<HumanPatient>");

							renewalRequestMsgBuffer.append("<Identification>");

							renewalRequestMsgBuffer.append("</Identification>");

							patientNameElementchecked = true;
						}

						// Patient Name - This block should executed only once.
						if (patientNameElementchecked == true) {

							// Name
							if (("Name").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<Name>");

							}

							// LastName
							if (("LastName").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<LastName>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</LastName>");

							}

							// FirstName
							if (("FirstName").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<FirstName>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</FirstName>");

							}

							// MiddleName
							if (("MiddleName").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<MiddleName>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</MiddleName>");

							}

							// Suffix
							if (("Suffix").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<Suffix>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</Suffix>");

							}

							// Prefix
							if (("Prefix").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<Prefix>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</Prefix>");
							}

							

							// Gender
							if (("Gender").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<Gender>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</Gender>");

							}

							if (("Date").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<DateOfBirth>");

								renewalRequestMsgBuffer.append("<Date>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</Date>");

								renewalRequestMsgBuffer.append("</DateOfBirth>");

							}

							if (("Address").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<Address>");

							}

							if (("AddressLine1").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<AddressLine1>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</AddressLine1>");

							}

							if (("AddressLine2").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<AddressLine2>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</AddressLine2>");

							}

							if (("City").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<City>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</City>");

							}

							if (("State").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<StateProvince>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</StateProvince>");

							}

							if (("ZipCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<PostalCode>");
								renewalRequestMsgBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgBuffer.append("</PostalCode>");

								renewalRequestMsgBuffer.append("</Address>");

							}

							if (("CommunicationNumbers").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgBuffer.append("<CommunicationNumbers>");

							}

							if (("Number").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								patientNumberBuffer = new StringBuffer();							

								String patientNumExtensionvalue = xmlNextEvent.asCharacters().getData();

								if (StringUtils.isNotEmpty(patientNumExtensionvalue) && patientNumExtensionvalue.contains("@")) {

									patientNumberBuffer.append(xmlNextEvent.asCharacters().getData());
									
								} else if (StringUtils.isNotEmpty(patientNumExtensionvalue) && patientNumExtensionvalue.contains("X")) {

									patientNumberBufferExtension = new StringBuffer();

									patientNumberBufferExtension.append(patientNumExtensionvalue.substring(patientNumExtensionvalue.indexOf("X")+1, patientNumExtensionvalue.length()));

									patientNumberBuffer.append("<Number>");

									patientNumberBuffer.append(patientNumExtensionvalue.substring(0, patientNumExtensionvalue.indexOf("X")));

									patientNumberBuffer.append("</Number>");

								} else if (StringUtils.isNotEmpty(patientNumExtensionvalue) && patientNumExtensionvalue.contains("x")) {

									patientNumberBufferExtension = new StringBuffer();

									patientNumberBufferExtension.append(patientNumExtensionvalue.substring(patientNumExtensionvalue.indexOf("x")+1, patientNumExtensionvalue.length()));

									patientNumberBuffer.append("<Number>");

									patientNumberBuffer.append(patientNumExtensionvalue.substring(0, patientNumExtensionvalue.indexOf("x")));

									patientNumberBuffer.append("</Number>");

								} else {

									patientNumberBuffer.append("<Number>");
									patientNumberBuffer.append(xmlNextEvent.asCharacters().getData());
									patientNumberBuffer.append("</Number>");
								}

							}

							if (("Qualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								String numberQualifer = xmlNextEvent.asCharacters().getData();

								if (("HP").equals(numberQualifer)) {

									patientNumberTypeBuffer.append("<HomeTelephone>");

									patientNumberTypeBuffer.append(patientNumberBuffer);									

									patientNumberTypeBuffer.append("</HomeTelephone>");
									
									patientNumberMap.put("HP",patientNumberTypeBuffer );

								} else if (("TE").equals(numberQualifer)) {

									patientNumberTypeBuffer.append("<PrimaryTelephone>");

									patientNumberTypeBuffer.append(patientNumberBuffer);

									if (patientNumberBufferExtension != null) {

										patientNumberTypeBuffer.append("<Extension>");
										patientNumberTypeBuffer.append(patientNumberBufferExtension);
										patientNumberTypeBuffer.append("</Extension>");
									}

									
									patientNumberTypeBuffer.append("</PrimaryTelephone>");
									
									patientNumberMap.put("TE",patientNumberTypeBuffer );						
									

								}

								else if (("FX").equals(numberQualifer)) {

									patientNumberTypeBuffer.append("<Fax>");

									patientNumberTypeBuffer.append(patientNumberBuffer);									

									patientNumberTypeBuffer.append("</Fax>");
									
									patientNumberMap.put("FX",patientNumberTypeBuffer );

								} else if (("WP").equals(numberQualifer)) {

									patientNumberTypeBuffer.append("<WorkTelephone>");

									patientNumberTypeBuffer.append(patientNumberBuffer);

									if (patientNumberBufferExtension != null) {

										patientNumberTypeBuffer.append("<Extension>");
										patientNumberTypeBuffer.append(patientNumberBufferExtension);
										patientNumberTypeBuffer.append("</Extension>");
									}									

									patientNumberTypeBuffer.append("</WorkTelephone>");
									
									patientNumberMap.put("WP",patientNumberTypeBuffer );

								}

								else if (("NP").equals(numberQualifer)) {

									patientNumberTypeBuffer.append("<OtherTelephone>");

									patientNumberTypeBuffer.append(patientNumberBuffer);

									patientNumberTypeBuffer.append("</OtherTelephone>");
									
									patientNumberMap.put("NP",patientNumberTypeBuffer );
									

								}

								// - Need to check else

								if (("CP").equals(numberQualifer)) {

									patientNumberTypeBuffer.append("<OtherTelephone>");

									patientNumberTypeBuffer.append(patientNumberBuffer);

									patientNumberTypeBuffer.append("</OtherTelephone>");
									
									patientNumberMap.put("CP",patientNumberTypeBuffer );

								}

								else if (("BN").equals(numberQualifer)) {

									patientNumberTypeBuffer.append("<Beeper>");

									patientNumberTypeBuffer.append(patientNumberBuffer);									

									patientNumberTypeBuffer.append("</Beeper>");
									
									patientNumberMap.put("BN",patientNumberTypeBuffer );

								}

								else if (("EM").equals(numberQualifer)) {

									patientNumberTypeBuffer.append("<ElectronicMail>");

									patientNumberTypeBuffer.append(patientNumberBuffer);

									patientNumberTypeBuffer.append("</ElectronicMail>");
									
									patientNumberMap.put("EM",patientNumberTypeBuffer );

								}

								patientCommunicationNumbersEnded = true;
							}

						}
						// patient end.

						// Prescriber start

						if (("Prescriber").equals(startElement.getName().getLocalPart())) {


							renewalRequestMsgPrescriberBuffer.append("<Prescriber>");

							renewalRequestMsgPrescriberBuffer.append("<NonVeterinarian>");

							setPrescriberElements = true;

							xmlNextEvent = eventReader.nextEvent();

						}

						if (setPrescriberElements == true) {

							if (("Identification").equals(startElement.getName().getLocalPart())) {

								renewalRequestMsgPrescriberBuffer.append("<Identification>");

								xmlNextEvent = eventReader.nextEvent();

							}

							else if (("DEANumber").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();								

								renewalRequestMsgPrescriberBuffer.append("<DEANumber>");
								renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPrescriberBuffer.append("</DEANumber>");

							} else if (("HIN").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPrescriberBuffer.append("<HIN>");
								renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPrescriberBuffer.append("</HIN>");

							}

							else if (("NPI").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPrescriberBuffer.append("<NPI>");
								renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPrescriberBuffer.append("</NPI>");

								renewalRequestMsgPrescriberBuffer.append("</Identification>");

							}

							else if (("Specialty").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPrescriberBuffer.append("<Specialty>");
								renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPrescriberBuffer.append("</Specialty>");

								renewalRequestMsgPrescriberBuffer.append("<PracticeLocation>");

								renewalRequestMsgPrescriberBuffer.append("<Identification>");

								renewalRequestMsgPrescriberBuffer.append("</Identification>");
								

								renewalRequestMsgPrescriberBuffer.append("</PracticeLocation>");

								setPrescriberName = true;
							}

							// Prescriber Name elements
							else if (setPrescriberName == true) {

								// Name
								if (("Name").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<Name>");

								}

								// LastName
								if (("LastName").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<LastName>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</LastName>");

								}

								// FirstName
								if (("FirstName").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<FirstName>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</FirstName>");

								}

								// MiddleName
								if (("MiddleName").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<MiddleName>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</MiddleName>");

								}

								// Suffix
								if (("Suffix").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<Suffix>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</Suffix>");

								}

								// Prefix
								if (("Prefix").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<Prefix>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</Prefix>");
								}

								

							}
							else {
								
								// Name
								if (("Name").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<Name>");

								}

								// LastName
								if (("LastName").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<LastName>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</LastName>");

								}

								// FirstName
								if (("FirstName").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<FirstName>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</FirstName>");

								}

								// MiddleName
								if (("MiddleName").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<MiddleName>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</MiddleName>");

								}

								// Suffix
								if (("Suffix").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<Suffix>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</Suffix>");

								}

								// Prefix
								if (("Prefix").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgPrescriberBuffer.append("<Prefix>");
									renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgPrescriberBuffer.append("</Prefix>");
								}

								setPrescriberNameShortElement = true;
								
							}

							if (("Address").equals(startElement.getName().getLocalPart())) {

								renewalRequestMsgPrescriberBuffer.append("<Address>");
								xmlNextEvent = eventReader.nextEvent();

							}

							else if (("AddressLine1").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPrescriberBuffer.append("<AddressLine1>");
								renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPrescriberBuffer.append("</AddressLine1>");

							}

							else if (("AddressLine2").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPrescriberBuffer.append("<AddressLine2>");
								renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPrescriberBuffer.append("</AddressLine2>");

							}

							else if (("City").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgPrescriberBuffer.append("<City>");
								renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPrescriberBuffer.append("</City>");

							}

							else if (("State").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgPrescriberBuffer.append("<StateProvince>");
								renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPrescriberBuffer.append("</StateProvince>");

							}

							else if (("ZipCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgPrescriberBuffer.append("<PostalCode>");
								renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgPrescriberBuffer.append("</PostalCode>");

								renewalRequestMsgPrescriberBuffer.append("</Address>");

							}

							else if (("CommunicationNumbers").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();
								renewalRequestMsgPrescriberBuffer.append("<CommunicationNumbers>");

							}

							else if (("Number").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								prescriberNumberBuffer = new StringBuffer();

								String prescriberNumberExtensionValue = xmlNextEvent.asCharacters().getData();

								if (StringUtils.isNotEmpty(prescriberNumberExtensionValue) && prescriberNumberExtensionValue.contains("@")) {

									prescriberNumberBuffer.append(xmlNextEvent.asCharacters().getData());
								} else if (StringUtils.isNotEmpty(prescriberNumberExtensionValue) && prescriberNumberExtensionValue.contains("X")) {

									prescriberNumberExtensionBuffer = new StringBuffer();

									prescriberNumberExtensionBuffer
											.append(prescriberNumberExtensionValue.substring(prescriberNumberExtensionValue.indexOf("X") + 1, prescriberNumberExtensionValue.length()));

									prescriberNumberBuffer.append("<Number>");

									prescriberNumberBuffer.append(prescriberNumberExtensionValue.substring(0, prescriberNumberExtensionValue.indexOf("X")));

									prescriberNumberBuffer.append("</Number>");

								} else if (StringUtils.isNotEmpty(prescriberNumberExtensionValue) && prescriberNumberExtensionValue.contains("x")) {

									prescriberNumberExtensionBuffer = new StringBuffer();

									prescriberNumberExtensionBuffer
											.append(prescriberNumberExtensionValue.substring(prescriberNumberExtensionValue.indexOf("x") + 1, prescriberNumberExtensionValue.length()));

									prescriberNumberBuffer.append("<Number>");

									prescriberNumberBuffer.append(prescriberNumberExtensionValue.substring(0, prescriberNumberExtensionValue.indexOf("x")));

									prescriberNumberBuffer.append("</Number>");

								} else {

									prescriberNumberBuffer.append("<Number>");
									prescriberNumberBuffer.append(xmlNextEvent.asCharacters().getData());
									prescriberNumberBuffer.append("</Number>");
								}

							}

							else if (("Qualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								String numberQualifer = xmlNextEvent.asCharacters().getData();

								if (("HP").equals(numberQualifer)) {

									renewalRequestMsgPrescriberBuffer.append("<HomeTelephone>");

									renewalRequestMsgPrescriberBuffer.append(prescriberNumberBuffer);									

									renewalRequestMsgPrescriberBuffer.append("</HomeTelephone>");

								}

								else if (("TE").equals(numberQualifer)) {

									renewalRequestMsgPrescriberBuffer.append("<PrimaryTelephone>");

									renewalRequestMsgPrescriberBuffer.append(prescriberNumberBuffer);

									if (prescriberNumberExtensionBuffer != null) {

										renewalRequestMsgPrescriberBuffer.append("<Extension>");
										renewalRequestMsgPrescriberBuffer.append(prescriberNumberExtensionBuffer);
										renewalRequestMsgPrescriberBuffer.append("</Extension>");
									}									

									renewalRequestMsgPrescriberBuffer.append("</PrimaryTelephone>");

								}

								else if (("FX").equals(numberQualifer)) {

									renewalRequestMsgPrescriberBuffer.append("<Fax>");

									renewalRequestMsgPrescriberBuffer.append(prescriberNumberBuffer);
								

									renewalRequestMsgPrescriberBuffer.append("</Fax>");

								} else if (("WP").equals(numberQualifer)) {

									renewalRequestMsgPrescriberBuffer.append("<WorkTelephone>");

									renewalRequestMsgPrescriberBuffer.append(prescriberNumberBuffer);

									if (prescriberNumberExtensionBuffer != null) {

										renewalRequestMsgPrescriberBuffer.append("<Extension>");
										renewalRequestMsgPrescriberBuffer.append(prescriberNumberExtensionBuffer);
										renewalRequestMsgPrescriberBuffer.append("</Extension>");
									}

									renewalRequestMsgPrescriberBuffer.append("</WorkTelephone>");

								}

								else if (("NP").equals(numberQualifer)) {

									renewalRequestMsgPrescriberBuffer.append("<OtherTelephone>");

									renewalRequestMsgPrescriberBuffer.append(prescriberNumberBuffer);

									renewalRequestMsgPrescriberBuffer.append("</OtherTelephone>");

								}

								// - Need to check CP

								else if (("CP").equals(numberQualifer)) {

									renewalRequestMsgPrescriberBuffer.append("<OtherTelephone>");

									renewalRequestMsgPrescriberBuffer.append(prescriberNumberBuffer);

									renewalRequestMsgPrescriberBuffer.append("</OtherTelephone>");

								}

								else if (("BN").equals(numberQualifer)) {

									renewalRequestMsgPrescriberBuffer.append("<Beeper>");

									renewalRequestMsgPrescriberBuffer.append(prescriberNumberBuffer);

									

									renewalRequestMsgPrescriberBuffer.append("</Beeper>");

								}

								else if (("EM").equals(numberQualifer)) {

									renewalRequestMsgPrescriberBuffer.append("<ElectronicMail>");

									renewalRequestMsgPrescriberBuffer.append(prescriberNumberBuffer);

									renewalRequestMsgPrescriberBuffer.append("</ElectronicMail>");

								}

								prescriberCommunicationNumbersEnded = true;

							}

							else if (("PrescriberAgent").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgPrescriberBuffer.append("<PrescriberAgent>");

								setPrescriberAgentName = true;

							}

							if (setPrescriberAgentName == true) {

								// LastName
								if (("LastName").equals(startElement.getName().getLocalPart())) {

									
									
									if(xmlNextEvent.isCharacters()) {
										
										renewalRequestMsgPrescriberBuffer.append("<Name>");
										renewalRequestMsgPrescriberBuffer.append("<LastName>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</LastName>");
										
										
									}
									else if(xmlNextEvent.isEndElement() == false) {
										
										xmlNextEvent = eventReader.nextEvent();
										
										renewalRequestMsgPrescriberBuffer.append("<Name>");
										renewalRequestMsgPrescriberBuffer.append("<LastName>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</LastName>");
									}

									

								}

								// FirstName
								if (("FirstName").equals(startElement.getName().getLocalPart())) {

									
									
									if(xmlNextEvent.isCharacters()) {
										
										renewalRequestMsgPrescriberBuffer.append("<FirstName>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</FirstName>");
										
									}
									else if(xmlNextEvent.isEndElement() == false) {
										
										xmlNextEvent = eventReader.nextEvent();
										
										renewalRequestMsgPrescriberBuffer.append("<FirstName>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</FirstName>");
										
										
									}
									
					
								}

								// MiddleName
								if (("MiddleName").equals(startElement.getName().getLocalPart())) {

									if(xmlNextEvent.isCharacters()) {
										
										renewalRequestMsgPrescriberBuffer.append("<MiddleName>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</MiddleName>");
										
									}
									else if(xmlNextEvent.isEndElement() == false) {
										
										xmlNextEvent = eventReader.nextEvent();

										renewalRequestMsgPrescriberBuffer.append("<MiddleName>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</MiddleName>");
									}
									

								}

								// Suffix
								if (("Suffix").equals(startElement.getName().getLocalPart())) {

									if(xmlNextEvent.isCharacters()) {
										
										
										renewalRequestMsgPrescriberBuffer.append("<Suffix>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</Suffix>");

									}
									else if(xmlNextEvent.isEndElement() == false) {
										
										xmlNextEvent = eventReader.nextEvent();

										renewalRequestMsgPrescriberBuffer.append("<Suffix>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</Suffix>");
									}
									
									
								}

								// Prefix
								if (("Prefix").equals(startElement.getName().getLocalPart())) {

									
									if(xmlNextEvent.isCharacters()) {										

										renewalRequestMsgPrescriberBuffer.append("<Prefix>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</Prefix>");			
									}
									else if(xmlNextEvent.isEndElement() == false) {
										
										xmlNextEvent = eventReader.nextEvent();

										renewalRequestMsgPrescriberBuffer.append("<Prefix>");
										renewalRequestMsgPrescriberBuffer.append(xmlNextEvent.asCharacters().getData());
										renewalRequestMsgPrescriberBuffer.append("</Prefix>");			
									}
									
																								

								}

								

							}

							// prescriber end
						}

						// Supervisor start

						if (("Supervisor").equals(startElement.getName().getLocalPart())) {

							renewalRequestMsgSupervisorBuffer = new StringBuffer();
							
							renewalRequestMsgSupervisorBuffer.append("<Supervisor>");

							renewalRequestMsgSupervisorBuffer.append("<NonVeterinarian>");

							setSupervisorElements = true;

							xmlNextEvent = eventReader.nextEvent();

						}

						if (setSupervisorElements == true) {

							if (("Identification").equals(startElement.getName().getLocalPart())) {

								if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<Identification>");
								}

								xmlNextEvent = eventReader.nextEvent();

							}

							else if (("StateLicenseNumber").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("<StateLicenseNumber>");
								renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgSupervisorBuffer.append("</StateLicenseNumber>");
								}
								
							} else if (("DEANumber").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("<DEANumber>");
								renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgSupervisorBuffer.append("</DEANumber>");

								renewalRequestMsgSupervisorBuffer.append("</Identification>");

								renewalRequestMsgSupervisorBuffer.append("<PracticeLocation>");

								renewalRequestMsgSupervisorBuffer.append("<Identification>");

								renewalRequestMsgSupervisorBuffer.append("</Identification>");

								renewalRequestMsgSupervisorBuffer.append("</PracticeLocation>");
								}
								setSupervisorName = true;

							}

							// Supervisor Name elements
							else if (setSupervisorName == true) {

								// Name
								if (("Name").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<Name>");
									}

								}

								// LastName
								if (("LastName").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<LastName>");
									renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgSupervisorBuffer.append("</LastName>");
									}

								}

								// FirstName
								if (("FirstName").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<FirstName>");
									renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgSupervisorBuffer.append("</FirstName>");
									}

								}

								// MiddleName
								if (("MiddleName").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<MiddleName>");
									renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgSupervisorBuffer.append("</MiddleName>");
									}

								}

								// Suffix
								if (("Suffix").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<Suffix>");
									renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgSupervisorBuffer.append("</Suffix>");
									}

								}

								// Prefix
								if (("Prefix").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<Prefix>");
									renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgSupervisorBuffer.append("</Prefix>");	
									}

								}

								

							}

							if (("Address").equals(startElement.getName().getLocalPart())) {
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("<Address>");
								}
								xmlNextEvent = eventReader.nextEvent();

							}

							else if (("AddressLine1").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("<AddressLine1>");
								renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgSupervisorBuffer.append("</AddressLine1>");
								}

							}

							else if (("AddressLine2").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("<AddressLine2>");
								renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgSupervisorBuffer.append("</AddressLine2>");
								}

							}

							else if (("City").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("<City>");
								renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgSupervisorBuffer.append("</City>");
								}

							}

							else if (("State").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("<StateProvince>");
								renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgSupervisorBuffer.append("</StateProvince>");
								}

							}

							else if (("ZipCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("<PostalCode>");
								renewalRequestMsgSupervisorBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgSupervisorBuffer.append("</PostalCode>");

								renewalRequestMsgSupervisorBuffer.append("</Address>");
								}

							}

							else if (("CommunicationNumbers").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("<CommunicationNumbers>");
								}

							}

							else if (("Number").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								supervisorNumberBuffer = new StringBuffer();

								String value = xmlNextEvent.asCharacters().getData();

								if (StringUtils.isNotEmpty(value) && value.contains("@")) {

									supervisorNumberBuffer.append(xmlNextEvent.asCharacters().getData());
								} else if (StringUtils.isNotEmpty(value) && value.contains("X")) {

									supervisorNumberExtensionBuffer = new StringBuffer();

									supervisorNumberExtensionBuffer
											.append(value.substring(value.indexOf("X") + 1, value.length()));

									supervisorNumberBuffer.append("<Number>");

									supervisorNumberBuffer.append(value.substring(0, value.indexOf("X")));

									supervisorNumberBuffer.append("</Number>");

								} else if (StringUtils.isNotEmpty(value) && value.contains("x")) {

									supervisorNumberExtensionBuffer = new StringBuffer();

									supervisorNumberExtensionBuffer
											.append(value.substring(value.indexOf("x") + 1, value.length()));

									supervisorNumberBuffer.append("<Number>");

									supervisorNumberBuffer.append(value.substring(0, value.indexOf("x")));

									supervisorNumberBuffer.append("</Number>");

								} else {

									supervisorNumberBuffer.append("<Number>");
									supervisorNumberBuffer.append(xmlNextEvent.asCharacters().getData());
									supervisorNumberBuffer.append("</Number>");
								}

							}

							else if (("Qualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();
								String numberQualifer = xmlNextEvent.asCharacters().getData();

								if (("HP").equals(numberQualifer)) {
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<HomeTelephone>");

									renewalRequestMsgSupervisorBuffer.append(supervisorNumberBuffer);
								
									renewalRequestMsgSupervisorBuffer.append("</HomeTelephone>");
									}

								}

								else if (("TE").equals(numberQualifer)) {
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<PrimaryTelephone>");

									renewalRequestMsgSupervisorBuffer.append(supervisorNumberBuffer);
									}
									if (supervisorNumberExtensionBuffer != null) {
										if(null!=renewalRequestMsgSupervisorBuffer) {
										renewalRequestMsgSupervisorBuffer.append("<Extension>");
										renewalRequestMsgSupervisorBuffer.append(supervisorNumberExtensionBuffer);
										renewalRequestMsgSupervisorBuffer.append("</Extension>");
										}
									}

									
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("</PrimaryTelephone>");
									}

								}

								else if (("FX").equals(numberQualifer)) {
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<Fax>");

									renewalRequestMsgSupervisorBuffer.append(supervisorNumberBuffer);
									

									renewalRequestMsgSupervisorBuffer.append("</Fax>");
									}
								} else if (("WP").equals(numberQualifer)) {
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<WorkTelephone>");

									renewalRequestMsgSupervisorBuffer.append(supervisorNumberBuffer);
									}
									if (supervisorNumberExtensionBuffer != null) {
										if(null!=renewalRequestMsgSupervisorBuffer) {
										renewalRequestMsgSupervisorBuffer.append("<Extension>");
										renewalRequestMsgSupervisorBuffer.append(supervisorNumberExtensionBuffer);
										renewalRequestMsgSupervisorBuffer.append("</Extension>");
										}
									}

									
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("</WorkTelephone>");
									}
								}

								else if (("NP").equals(numberQualifer)) {
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<OtherTelephone>");

									renewalRequestMsgSupervisorBuffer.append(supervisorNumberBuffer);

									renewalRequestMsgSupervisorBuffer.append("</OtherTelephone>");
									}
								}

								// - Need to check CP

								else if (("CP").equals(numberQualifer)) {
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<OtherTelephone>");

									renewalRequestMsgSupervisorBuffer.append(supervisorNumberBuffer);

									renewalRequestMsgSupervisorBuffer.append("</OtherTelephone>");
									}
								}

								else if (("BN").equals(numberQualifer)) {
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<Beeper>");

									renewalRequestMsgSupervisorBuffer.append(supervisorNumberBuffer);

									

									renewalRequestMsgSupervisorBuffer.append("</Beeper>");
									}
								}

								else if (("EM").equals(numberQualifer)) {
									if(null!=renewalRequestMsgSupervisorBuffer) {
									renewalRequestMsgSupervisorBuffer.append("<ElectronicMail>");

									renewalRequestMsgSupervisorBuffer.append(supervisorNumberBuffer);

									renewalRequestMsgSupervisorBuffer.append("</ElectronicMail>");
									}
								}

								supervisorCommunicationNumbersEnded = true;

							}

							// Supervisor end
						}

						// MedicationPrescribed Start
						if (("MedicationPrescribed").equals(startElement.getName().getLocalPart())) {


							renewalRequestMsgMedicationPrescribedBuffer.append("<MedicationPrescribed>");

							setMedicationPrescribedElements = true;

							xmlNextEvent = eventReader.nextEvent();

						}

						if (setMedicationPrescribedElements == true) {

							if (("DrugDescription").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<DrugDescription>");
								renewalRequestMsgMedicationPrescribedBuffer
										.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgMedicationPrescribedBuffer.append("</DrugDescription>");
							}

							if (("DrugCoded").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<DrugCoded>");

							}

							if (("ProductCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<ProductCode>");

								renewalRequestMsgMedicationPrescribedBuffer.append("<Code>");
								renewalRequestMsgMedicationPrescribedBuffer
										.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgMedicationPrescribedBuffer.append("</Code>");

							}

							if (("ProductCodeQualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<Qualifier>");
								renewalRequestMsgMedicationPrescribedBuffer
										.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgMedicationPrescribedBuffer.append("</Qualifier>");
								
								renewalRequestMsgMedicationPrescribedBuffer.append("</ProductCode>");

							}

							if (("Strength").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								
							

							}

							if (("DrugDBCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<DrugDBCode>");

								renewalRequestMsgMedicationPrescribedBuffer.append("<Code>");
								renewalRequestMsgMedicationPrescribedBuffer
										.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgMedicationPrescribedBuffer.append("</Code>");

							}

							if (("DrugDBCodeQualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<Qualifier>");

								renewalRequestMsgMedicationPrescribedBuffer
										.append(xmlNextEvent.asCharacters().getData());

								renewalRequestMsgMedicationPrescribedBuffer.append("</Qualifier>");

								renewalRequestMsgMedicationPrescribedBuffer.append("</DrugDBCode>");

							}

							if (("FormSourceCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

							}

							if (("FormCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

							}

							if (("StrengthSourceCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

							}

							if (("StrengthCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

							}
							if (("Quantity").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<Quantity>");

							}

							if (("Value").equals(startElement.getName().getLocalPart())) {
								
								// Don't print this value as Refills value.
								if(medicationPrescribeRefillQualifier == false) {
									
									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgMedicationPrescribedBuffer.append("<Value>");
									renewalRequestMsgMedicationPrescribedBuffer
											.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgMedicationPrescribedBuffer.append("</Value>");
								}
																
								

							}

							if (("CodeListQualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<CodeListQualifier>");
								renewalRequestMsgMedicationPrescribedBuffer
										.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgMedicationPrescribedBuffer.append("</CodeListQualifier>");

							}
							if (("UnitSourceCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

							}

							if (("PotencyUnitCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<QuantityUnitOfMeasure>");

								renewalRequestMsgMedicationPrescribedBuffer.append("<Code>");
								
								renewalRequestMsgMedicationPrescribedBuffer.append(quantityUnitOfMeasure!=null?quantityUnitOfMeasure:xmlNextEvent.asCharacters().getData());
								
								renewalRequestMsgMedicationPrescribedBuffer.append("</Code>");

								renewalRequestMsgMedicationPrescribedBuffer.append("</QuantityUnitOfMeasure>");

								renewalRequestMsgMedicationPrescribedBuffer.append("</Quantity>");

							}

							if (("DaysSupply").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<DaysSupply>");
								renewalRequestMsgMedicationPrescribedBuffer
										.append(xmlNextEvent.asCharacters().getData());

								renewalRequestMsgMedicationPrescribedBuffer.append("</DaysSupply>");

							}

							if (("Directions").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedSigBuffer = new StringBuffer();

								renewalRequestMsgMedicationPrescribedSigBuffer.append("<Sig>");

								renewalRequestMsgMedicationPrescribedSigBuffer.append("<SigText>");

								renewalRequestMsgMedicationPrescribedSigBuffer.append(xmlNextEvent.asCharacters().getData());

								renewalRequestMsgMedicationPrescribedSigBuffer.append("</SigText>");

							}

							if (("Note").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<Note>");

								renewalRequestMsgMedicationPrescribedBuffer
										.append(xmlNextEvent.asCharacters().getData());

								renewalRequestMsgMedicationPrescribedBuffer.append("</Note>");

							}

							if (("Refills").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								medicationPrescribeRefillQualifier = true;

							}

							if (medicationPrescribeRefillQualifier == true) {

								if (("Qualifier").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									String value = xmlNextEvent.asCharacters().getData();

									if (StringUtils.isNotEmpty(value) && "PRN".equals(value)) {

										value = "99";
										
										renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf = new StringBuffer();
										
										medicationPrescribeRefillQualifierPRN = true;
										
										renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf.append("<NumberOfRefills>");

										renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf.append(value);

										renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf.append("</NumberOfRefills>");

										medicationPrescribeRefillQualifier = false;
									}

									

								}
								else if (("Value").equals(startElement.getName().getLocalPart())) {
									
									if(medicationPrescribeRefillQualifierPRN == false) {
										
										renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf = new StringBuffer();
										
										if(xmlNextEvent.isCharacters()) {
											
											renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf.append("<NumberOfRefills>");

											renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf.append(numberOfRefills!=null?numberOfRefills:0);

											renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf.append("</NumberOfRefills>");
										}
										else  if(xmlNextEvent.isEndElement() == false) {
											
											xmlNextEvent = eventReader.nextEvent();
											
											renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf.append("<NumberOfRefills>");
											
											renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf.append(numberOfRefills!=null?numberOfRefills:0);

											renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf.append("</NumberOfRefills>");
											
										}
										
										
									}
									
									
									
								}
							}
							
								
								

							if (("Substitutions").equals(startElement.getName().getLocalPart())) {
								
								
								
								xmlNextEvent = eventReader.nextEvent();

								
								substitutionsValue = xmlNextEvent.asCharacters().getData();
								renewalRequestMsgMedicationPrescribedSubstitutionsBuf.append("<Substitutions>");
								renewalRequestMsgMedicationPrescribedSubstitutionsBuf.append(substitutionsValue);
								renewalRequestMsgMedicationPrescribedSubstitutionsBuf.append("</Substitutions>");
								
								
							}

							if (("WrittenDate").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<WrittenDate>");

								medicationPrescribedWrittenDate = true;

							}

							if (medicationPrescribedWrittenDate == true) {
								if (("Date").equals(startElement.getName().getLocalPart())) {
									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgMedicationPrescribedBuffer.append("<Date>");
									renewalRequestMsgMedicationPrescribedBuffer
											.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgMedicationPrescribedBuffer.append("</Date>");

									renewalRequestMsgMedicationPrescribedBuffer.append("</WrittenDate>");

									medicationPrescribedWrittenDate = false;

								}

							}

							if (("ExpirationDate").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();

								medicationPrescribedExpirationDate = true;

							}

							if (medicationPrescribedExpirationDate == true) {

								if (("Date").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgMedicationPrescribedBuffer.append("<OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer.append("<OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer.append("<Date>");

									renewalRequestMsgMedicationPrescribedBuffer
											.append(xmlNextEvent.asCharacters().getData());

									renewalRequestMsgMedicationPrescribedBuffer.append("</Date>");

									renewalRequestMsgMedicationPrescribedBuffer.append("</OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer
											.append("<OtherMedicationDateQualifier>");

									renewalRequestMsgMedicationPrescribedBuffer.append("ExpirationDate");

									renewalRequestMsgMedicationPrescribedBuffer
											.append("</OtherMedicationDateQualifier>");

									renewalRequestMsgMedicationPrescribedBuffer.append("</OtherMedicationDate>");

									medicationPrescribedExpirationDate = false;
								}

							}

							if (("EffectiveDate").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								medicationPrescribedEffectiveDate = true;
							}

							if (medicationPrescribedEffectiveDate == true) {

								if (("Date").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgMedicationPrescribedBuffer.append("<OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer.append("<OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer.append("<Date>");

									renewalRequestMsgMedicationPrescribedBuffer
											.append(xmlNextEvent.asCharacters().getData());

									renewalRequestMsgMedicationPrescribedBuffer.append("</Date>");

									renewalRequestMsgMedicationPrescribedBuffer.append("</OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer
											.append("<OtherMedicationDateQualifier>");

									renewalRequestMsgMedicationPrescribedBuffer.append("EffectiveDate");

									renewalRequestMsgMedicationPrescribedBuffer
											.append("</OtherMedicationDateQualifier>");

									renewalRequestMsgMedicationPrescribedBuffer.append("</OtherMedicationDate>");

									medicationPrescribedEffectiveDate = false;

								}
							}

							if (("PeriodEnd").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();

								medicationPrescribedPeriodEndDate = true;
							}

							if (medicationPrescribedPeriodEndDate == true) {

								if (("Date").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgMedicationPrescribedBuffer.append("<OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer.append("<OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer.append("<Date>");

									renewalRequestMsgMedicationPrescribedBuffer
											.append(xmlNextEvent.asCharacters().getData());

									renewalRequestMsgMedicationPrescribedBuffer.append("</Date>");

									renewalRequestMsgMedicationPrescribedBuffer.append("</OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer
											.append("<OtherMedicationDateQualifier>");

									renewalRequestMsgMedicationPrescribedBuffer.append("PeriodEnd");

									renewalRequestMsgMedicationPrescribedBuffer
											.append("</OtherMedicationDateQualifier>");

									renewalRequestMsgMedicationPrescribedBuffer.append("</OtherMedicationDate>");

									medicationPrescribedPeriodEndDate = false;
								}

							}

							if (("DateValidated").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								medicationPrescribedDateValidated = true;
							}

							if (medicationPrescribedDateValidated == true) {

								if (("Date").equals(startElement.getName().getLocalPart())) {

									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgMedicationPrescribedBuffer.append("<OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer.append("<OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer.append("<Date>");

									renewalRequestMsgMedicationPrescribedBuffer
											.append(xmlNextEvent.asCharacters().getData());

									renewalRequestMsgMedicationPrescribedBuffer.append("</Date>");

									renewalRequestMsgMedicationPrescribedBuffer.append("</OtherMedicationDate>");

									renewalRequestMsgMedicationPrescribedBuffer
											.append("<OtherMedicationDateQualifier>");

									renewalRequestMsgMedicationPrescribedBuffer.append("DateValidated");

									renewalRequestMsgMedicationPrescribedBuffer
											.append("</OtherMedicationDateQualifier>");

									renewalRequestMsgMedicationPrescribedBuffer.append("</OtherMedicationDate>");

									medicationPrescribedDateValidated = false;

								}
							}

							if (("PriorAuthorization").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								medicationPrescribedPriorAuthorizationValue = true;
							}

							if (("Qualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

							}

							if (medicationPrescribedPriorAuthorizationValue == true) {

								if (("Value").equals(startElement.getName().getLocalPart())) {

									if (xmlNextEvent.isCharacters()) {

										renewalRequestMsgMedicationPrescribedBuffer.append("<PriorAuthorization>");

										renewalRequestMsgMedicationPrescribedBuffer
												.append(xmlNextEvent.asCharacters().getData());

										renewalRequestMsgMedicationPrescribedBuffer.append("</PriorAuthorization>");

										medicationPrescribedPriorAuthorizationValue = false;
									}

									else {
										xmlNextEvent = eventReader.nextEvent();

										renewalRequestMsgMedicationPrescribedBuffer.append("<PriorAuthorization>");

										renewalRequestMsgMedicationPrescribedBuffer
												.append(xmlNextEvent.asCharacters().getData());

										renewalRequestMsgMedicationPrescribedBuffer.append("</PriorAuthorization>");

										medicationPrescribedPriorAuthorizationValue = false;
									}

								}

							}

							if (("PriorAuthorizationStatus").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationPrescribedBuffer.append("<PriorAuthorizationStatus>");

								renewalRequestMsgMedicationPrescribedBuffer
										.append(xmlNextEvent.asCharacters().getData());

								renewalRequestMsgMedicationPrescribedBuffer.append("</PriorAuthorizationStatus>");
							}

							if (("StructuredSIG").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();
							}

							if (("RepeatingSIG").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();
							}

							if (("SigSequencePositionNumber").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();
							}

							if (("MultipleSigModifier").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();

							}

							
							

						} // MedicationPrescribed End

						// MedicationDispensed Start
						if (("MedicationDispensed").equals(startElement.getName().getLocalPart())) {

							renewalRequestMsgMedicationDispensedBuffer.append("<MedicationDispensed>");

							setMedicationDispensedElements = true;

							xmlNextEvent = eventReader.nextEvent();

						}

						if (setMedicationDispensedElements == true) {

							if (("DrugDescription").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<DrugDescription>");
								renewalRequestMsgMedicationDispensedBuffer.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgMedicationDispensedBuffer.append("</DrugDescription>");
							}
							
							if (("DrugCoded").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<DrugCoded>");

							}

							if (("ProductCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<ProductCode>");

								renewalRequestMsgMedicationDispensedBuffer.append("<Code>");
								renewalRequestMsgMedicationDispensedBuffer
										.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgMedicationDispensedBuffer.append("</Code>");

							}

							if (("ProductCodeQualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<Qualifier>");
								renewalRequestMsgMedicationDispensedBuffer
										.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgMedicationDispensedBuffer.append("</Qualifier>");
								
								renewalRequestMsgMedicationDispensedBuffer.append("</ProductCode>");

							}

							if (("Quantity").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();							

								renewalRequestMsgMedicationDispensedBuffer.append("<Quantity>");

							}

							if (("Value").equals(startElement.getName().getLocalPart())) {
								
								// Don't print this as Refills value for Medication Dispensed section.
								if(medicationDispensedRefillValue == false) {
									
									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgMedicationDispensedBuffer.append("<Value>");
									renewalRequestMsgMedicationDispensedBuffer
											.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgMedicationDispensedBuffer.append("</Value>");
								}
								

							}

							if (("CodeListQualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<CodeListQualifier>");
								renewalRequestMsgMedicationDispensedBuffer
										.append(xmlNextEvent.asCharacters().getData());
								renewalRequestMsgMedicationDispensedBuffer.append("</CodeListQualifier>");

							}
							if (("UnitSourceCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

							}

							if (("PotencyUnitCode").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<QuantityUnitOfMeasure>");

								renewalRequestMsgMedicationDispensedBuffer.append("<Code>");
								
								renewalRequestMsgMedicationDispensedBuffer.append(quantityUnitOfMeasure!=null?quantityUnitOfMeasure:xmlNextEvent.asCharacters().getData());
								
								renewalRequestMsgMedicationDispensedBuffer.append("</Code>");

								renewalRequestMsgMedicationDispensedBuffer.append("</QuantityUnitOfMeasure>");

								renewalRequestMsgMedicationDispensedBuffer.append("</Quantity>");

							}

							if (("DaysSupply").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<DaysSupply>");
								renewalRequestMsgMedicationDispensedBuffer
										.append(xmlNextEvent.asCharacters().getData());

								renewalRequestMsgMedicationDispensedBuffer.append("</DaysSupply>");

							}

							if (("Directions").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedSigBuffer = new StringBuffer();
								
								
								renewalRequestMsgMedicationDispensedSigBuffer.append("<Substitutions>");
								renewalRequestMsgMedicationDispensedSigBuffer.append(substitutionsValue);
								renewalRequestMsgMedicationDispensedSigBuffer.append("</Substitutions>");
								

								renewalRequestMsgMedicationDispensedSigBuffer.append("<Sig>");

								renewalRequestMsgMedicationDispensedSigBuffer.append("<SigText>");

								renewalRequestMsgMedicationDispensedSigBuffer
										.append(xmlNextEvent.asCharacters().getData());

								renewalRequestMsgMedicationDispensedSigBuffer.append("</SigText>");

							}

							if (("Note").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<Note>");

								renewalRequestMsgMedicationDispensedBuffer
										.append(xmlNextEvent.asCharacters().getData());

								renewalRequestMsgMedicationDispensedBuffer.append("</Note>");

							}

							if (("Refills").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								medicationDispensedRefillValue = true;

							}

							if (medicationDispensedRefillValue == true) {

								if (("Value").equals(startElement.getName().getLocalPart())) {

									if (xmlNextEvent.isCharacters()) {
										
										// fortify fix.
										if(null!=renewalRequestMsgMedicationDispensedSigBuffer) {
											
											
											renewalRequestMsgMedicationDispensedSigBuffer.append("</Sig>");

											

											renewalRequestMsgMedicationDispensedSigBuffer.append("<PharmacyRequestedRefills>");

											renewalRequestMsgMedicationDispensedSigBuffer
													.append(xmlNextEvent.asCharacters().getData());

											renewalRequestMsgMedicationDispensedSigBuffer
													.append("</PharmacyRequestedRefills>");
											
										}
										
										

										medicationDispensedRefillValue = false;
										
									} else {
										
										xmlNextEvent = eventReader.nextEvent();
										
										// fortify fix.
										if(null!=renewalRequestMsgMedicationDispensedSigBuffer) {
											
											renewalRequestMsgMedicationDispensedSigBuffer.append("</Sig>");																		

											renewalRequestMsgMedicationDispensedSigBuffer.append("<PharmacyRequestedRefills>");

											renewalRequestMsgMedicationDispensedSigBuffer
													.append(xmlNextEvent.asCharacters().getData());

											renewalRequestMsgMedicationDispensedSigBuffer
													.append("</PharmacyRequestedRefills>");
										}
										

										medicationDispensedRefillValue = false;

									}

								}
							}

							if (("WrittenDate").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<WrittenDate>");

								medicationDispensedWrittenDate = true;

							}

							if (medicationDispensedWrittenDate == true) {
								if (("Date").equals(startElement.getName().getLocalPart())) {
									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgMedicationDispensedBuffer.append("<Date>");
									renewalRequestMsgMedicationDispensedBuffer
											.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgMedicationDispensedBuffer.append("</Date>");

									renewalRequestMsgMedicationDispensedBuffer.append("</WrittenDate>");

									medicationDispensedWrittenDate = false;

								}

							}

							if (("LastFillDate").equals(startElement.getName().getLocalPart())) {
								xmlNextEvent = eventReader.nextEvent();

								renewalRequestMsgMedicationDispensedBuffer.append("<LastFillDate>");

								medicationDispensedLastFillDate = true;

							}

							if (medicationDispensedLastFillDate == true) {
								if (("Date").equals(startElement.getName().getLocalPart())) {
									xmlNextEvent = eventReader.nextEvent();

									renewalRequestMsgMedicationDispensedBuffer.append("<Date>");
									renewalRequestMsgMedicationDispensedBuffer
											.append(xmlNextEvent.asCharacters().getData());
									renewalRequestMsgMedicationDispensedBuffer.append("</Date>");

									renewalRequestMsgMedicationDispensedBuffer.append("</LastFillDate>");

									medicationDispensedLastFillDate = false;

								}

							}

							if (("PriorAuthorization").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

								medicationDispensedPriorAuthorizationValue = true;
							}

							if (("Qualifier").equals(startElement.getName().getLocalPart())) {

								xmlNextEvent = eventReader.nextEvent();

							}

							if (medicationDispensedPriorAuthorizationValue == true) {

								if (("Value").equals(startElement.getName().getLocalPart())) {

									if (xmlNextEvent.isCharacters()) {

										renewalRequestMsgMedicationDispensedBuffer.append("<PriorAuthorization>");

										renewalRequestMsgMedicationDispensedBuffer
												.append(xmlNextEvent.asCharacters().getData());

										renewalRequestMsgMedicationDispensedBuffer.append("</PriorAuthorization>");

										medicationDispensedPriorAuthorizationValue = false;
									}

									else {
										xmlNextEvent = eventReader.nextEvent();

										renewalRequestMsgMedicationDispensedBuffer.append("<PriorAuthorization>");

										renewalRequestMsgMedicationDispensedBuffer
												.append(xmlNextEvent.asCharacters().getData());

										renewalRequestMsgMedicationDispensedBuffer.append("</PriorAuthorization>");

										medicationDispensedPriorAuthorizationValue = false;
									}

								}

							}

							

						} // MedicationDispensed End

						
					} // Start element

					// End element
					if (xmlNextEvent.isEndElement()) {

						EndElement endElement = xmlNextEvent.asEndElement();

						if (("Sender").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgBuffer.append("</Sender>");
						}

						else if (("Receiver").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgBuffer.append("</Receiver>");
						}

						// Security - End
						else if (("Security").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgBuffer.append("</Security>");

							renewalRequestMsgBuffer.append("<SenderSoftware>");							
							renewalRequestMsgBuffer.append("<SenderSoftwareDeveloper>");
							renewalRequestMsgBuffer.append("TECHNATOMY");
							renewalRequestMsgBuffer.append("</SenderSoftwareDeveloper>");
							renewalRequestMsgBuffer.append("<SenderSoftwareProduct>");
							renewalRequestMsgBuffer.append("Inbound ePrescribing");
							renewalRequestMsgBuffer.append("</SenderSoftwareProduct>");
							renewalRequestMsgBuffer.append("<SenderSoftwareVersionRelease>");
							renewalRequestMsgBuffer.append("v4.0");
							renewalRequestMsgBuffer.append("</SenderSoftwareVersionRelease>");
							renewalRequestMsgBuffer.append("</SenderSoftware>");
						}

						// Header - End
						else if (("Header").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgBuffer.append("</Header>");
						}

						// CardHolderName - End
						else if (("CardHolderName").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgBuffer.append("</CardHolderName>");

							cardHolderNameElementchecked = false; // reset. So it only sets values once.
						}

						// BenefitsCoordination - End
						else if (("BenefitsCoordination").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgBuffer.append("</BenefitsCoordination>");
						}

						// BenefitsCoordination - End
						else if (("BenefitsCoordination").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgBuffer.append("</BenefitsCoordination>");
						}

						// Patient - Name- End
						else if (("Name").equals(endElement.getName().getLocalPart())) {

							if (patientNameElementchecked == true) {

								renewalRequestMsgBuffer.append("</Name>");

							}

							else if (setPrescriberName == true || setPrescriberNameShortElement == true) {

								renewalRequestMsgPrescriberBuffer.append("</Name>");
								

							}

							else if (setSupervisorName == true) {
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("</Name>");								
								}
							}
							
							
							
							

						}

						// Patient/Pharmacy - CommunicationNumbers- End
						else if (("CommunicationNumbers").equals(endElement.getName().getLocalPart())) {

							if (setPharmacyElements == true) {

								renewalRequestMsgPharmacyBuffer.append("</CommunicationNumbers>");
							} else if (patientCommunicationNumbersEnded == true) {
								
								
								if(patientNumberMap.containsKey("TE") == false) {
									
									
									String temp  =  patientNumberMap.get("HP").toString();
									
									String primaryNumber = temp.replaceAll("<HomeTelephone>", "<PrimaryTelephone>");
									
									primaryNumber = primaryNumber.replaceAll("</HomeTelephone>", "</PrimaryTelephone>");
									
									patientNumberMap.put("HP",	new StringBuffer(primaryNumber));
								}
								
								for(Map.Entry<String, StringBuffer> entry: patientNumberMap.entrySet()) {
									
									renewalRequestMsgBuffer.append(entry.getValue());
								}

								renewalRequestMsgBuffer.append("</CommunicationNumbers>");

							} else if (prescriberCommunicationNumbersEnded == true) {

								renewalRequestMsgPrescriberBuffer.append("</CommunicationNumbers>");

							} else if (supervisorCommunicationNumbersEnded == true) {
								if(null!=renewalRequestMsgSupervisorBuffer) {
								renewalRequestMsgSupervisorBuffer.append("</CommunicationNumbers>");
								}
							}

						}

						// Patient - End
						else if (("Patient").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgBuffer.append("</HumanPatient>");

							renewalRequestMsgBuffer.append("</Patient>");

							patientNameElementchecked = false; // reset. So it only sets values once.

							patientCommunicationNumbersEnded = false;						
							

							renewalRequestMsgBuffer.append(renewalRequestMsgPharmacyBuffer);

							renewalRequestMsgBuffer.append(renewalRequestMsgPrescriberBuffer);

						}

						// Pharmacy - End
						else if (("Pharmacy").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgPharmacyBuffer.append("</Pharmacy>");

							setPharmacyElements = false; // reset. So it only sets values once.

						}

						// Prescriber Agent - End
						else if (("PrescriberAgent").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgPrescriberBuffer.append("</Name>");	
							
							renewalRequestMsgPrescriberBuffer.append("</PrescriberAgent>");

							setPrescriberAgentName = false; // reset. So it only sets values once.

						}
						// Prescriber - End
						else if (("Prescriber").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgPrescriberBuffer.append("</NonVeterinarian>");
							renewalRequestMsgPrescriberBuffer.append("</Prescriber>");

							setPrescriberElements = false; // reset. So it only sets values once.

							prescriberCommunicationNumbersEnded = false;
							
							setPrescriberName = false;
							
							setPrescriberNameShortElement = false;
							

						}
						// Supervisor - End
						else if (("Supervisor").equals(endElement.getName().getLocalPart())) {
							if(null!=renewalRequestMsgSupervisorBuffer) {
							renewalRequestMsgSupervisorBuffer.append("</NonVeterinarian>");
							renewalRequestMsgSupervisorBuffer.append("</Supervisor>");
							}
							setSupervisorElements = false; // reset. So it only sets values once.
							
							setSupervisorName = false;

						}
						// DrugCoded - End
						else if (("DrugCoded").equals(endElement.getName().getLocalPart())) {

							if (setMedicationPrescribedElements == true) {

								
								renewalRequestMsgMedicationPrescribedBuffer.append("</DrugCoded>");

							} 
						    else if (setMedicationDispensedElements == true) {
								  
								 renewalRequestMsgMedicationDispensedBuffer.append("</DrugCoded>");
								  
						   }
								 

						}


						// MedicationPrescribed - End
						else if (("MedicationPrescribed").equals(endElement.getName().getLocalPart())) {
							
							//fortify fix
							if(null!=renewalRequestMsgMedicationPrescribedSigBuffer) {
								
								renewalRequestMsgMedicationPrescribedSigBuffer.append("</Sig>");
							}
							
							
							
							renewalRequestMsgMedicationPrescribedSubstitutionsBuf.append(renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf);
							
							renewalRequestMsgMedicationPrescribedSubstitutionsBuf.append(renewalRequestMsgMedicationPrescribedSigBuffer);
							
							renewalRequestMsgMedicationPrescribedBuffer.append(renewalRequestMsgMedicationPrescribedSubstitutionsBuf);						
							
							renewalRequestMsgMedicationPrescribedBuffer.append("</MedicationPrescribed>");

							setMedicationPrescribedElements = false; // reset. So it only sets values once.
							

						}
						// MedicationDispensed - End
						else if (("MedicationDispensed").equals(endElement.getName().getLocalPart())) {

							renewalRequestMsgMedicationDispensedBuffer.append(renewalRequestMsgMedicationDispensedSigBuffer);
							
							renewalRequestMsgMedicationDispensedBuffer.append("</MedicationDispensed>");

							renewalRequestMsgBuffer.append(renewalRequestMsgMedicationDispensedBuffer);				
							
							
							//Medication Prescribed goes after Medication Dispensed in newer format.
							renewalRequestMsgBuffer.append(renewalRequestMsgMedicationPrescribedBuffer);

							setMedicationDispensedElements = false; // reset. So it only sets values once.

						}
						

					}

				}

				// Supervisor - Start
				if(null!=renewalRequestMsgSupervisorBuffer) {
				
					renewalRequestMsgBuffer.append(renewalRequestMsgSupervisorBuffer);
				}
				

				// Supervisor - End

				// RxRenewalRequest - End
				renewalRequestMsgBuffer.append("</RxRenewalRequest>");

				// Body - End
				renewalRequestMsgBuffer.append("</Body>");

				// Message - End
				renewalRequestMsgBuffer.append("</Message>");

				//System.out.println("----- Converted RenewalRequest Msg = " + renewalRequestMsgBuffer.toString());

				// Now persist the message.

				StringReader reader = new StringReader(renewalRequestMsgBuffer.toString());

				outboundMsg.setMessage(JAXB.unmarshal(reader, MessageType.class));

				// wsResponse.setOutboundMsgId(0);

			} // 10.6 refill translation check
			else 
			{
				// native 20170715 messages coming in from VistA

				outboundMsg.setMessage(JAXB.unmarshal(new StringReader(message), MessageType.class));

			}
			
			//suppress sending of Error and Verify messages coming from VistA
			if ((StringUtils.isNotEmpty(message)) && ((message.indexOf("<Error>") != -1) || (message.indexOf("<Verify>") != -1))) {
				
				outboundMsg.setErxStatus("4010");  //tells the outbound Hub job not to send, only do minimal processing
				
			} else {
				
				outboundMsg.setErxStatus("0000"); //regular processing
				
			}			

			outboundMsg.setPharmacyId(0);

			Date date = new Date();

			outboundMsg.setCreatedDate(date);

			outboundMsg.setUpdatedDate(date);

			outboundMsg.setReceivedDate(date);

			outboundMsg.setScriptVersion(SCRIPT_VERSION);

			long outboundMsgId = outboundNcpdpMsgService.saveOutboundMsg(outboundMsg);

			wsResponse.setErrorMessage(null);

			wsResponse.setSuccess(true);

			wsResponse.setOutboundMsgId(outboundMsgId);
			
			

		} catch (SAXException ex) {

			// build error response. To and From are flipped.

			LOG.error("Error in VistaOutboundMsgImpl SaxException:" + ex.getMessage());

			wsResponse.setSuccess(false);

			wsResponse.setErrorMessage("Error while saving vista outbound message, SaxException: " + ex.getMessage());

			wsResponse.setOutboundMsgId(0);

		} catch (XMLStreamException ex) {

			// build error response. To and From are flipped.

			LOG.error("Error in VistaOutboundMsgImpl while conversion to newer format:" + ex.getMessage());

			wsResponse.setSuccess(false);

			wsResponse.setErrorMessage("Error while saving vista outbound message: " + ex.getMessage());

			wsResponse.setOutboundMsgId(0);

		}

		catch (Exception e) {

			LOG.error("Error in VistaOutboundMsgImpl:" + e.getMessage());

			wsResponse.setSuccess(false);

			wsResponse.setErrorMessage("Error while conversion to newer format and saving vista outbound message: "+ e.getMessage());

			//e.printStackTrace();

			wsResponse.setOutboundMsgId(0);

		} finally {

			StreamUtilities.safeClose(inputStream);

			//StreamUtilities.safeClose(formattedXMLString);
			
			try {
				
				if(null!=formattedXMLString ) {
				
					formattedXMLString.getWriter().close();
				}
				
				
			} catch (IOException e) {
				
				LOG.error("Error in VistaOutboundMsgImpl:" + e.getMessage());
				
			}
			
			inputStream = null;

			xsdStreamSource = null;

			xsdSource = null;
			
			schemaFactory = null;
			
			schema = null;

			saxParserFactory = null;
			
			saxparser = null;

			xmlReader = null;
			
			renewalRequestMsgBuffer = null;

			pharmacyNumberBuffer = null;

			pharmacyNumberExtensionBuffer = null;

			renewalRequestMsgPharmacyBuffer = null;

			renewalRequestMsgPrescriberBuffer = null;

			prescriberNumberBuffer = null;

			prescriberNumberExtensionBuffer = null;

			renewalRequestMsgSupervisorBuffer = null;

			supervisorNumberBuffer = null;

			supervisorNumberExtensionBuffer = null;

			renewalRequestMsgMedicationPrescribedBuffer = null;

			renewalRequestMsgMedicationDispensedBuffer = null;

			renewalRequestMsgMedicationPrescribedSigBuffer = null;

			renewalRequestMsgMedicationDispensedSigBuffer = null;

			patientNumberBuffer = null;

			patientNumberBufferExtension = null;
			
			patientNumberTypeBuffer = null;
			
			renewalRequestMsgMedicationPrescribedSubstitutionsBuf = null;
			
			renewalRequestMsgMedicationPrescribedNumberOfRefillsBuf = null;
			
			substitutionsValue = null;
			
			formattedXMLString = null;
			
			inputXMLString =  null;
			
			transformerFactory = null;				
			
			transformer = null;
			
			xmlInputFactory = null;

			eventReader = null;
			
			relatesToMesageId = null;
			
			numberOfRefills = null;
			
			quantityUnitOfMeasure = null; 
			
			newRxMsg = null;

			
			
		}

		return wsResponse;
	}

	/*
	 * // old web method
	 * 
	 * @POST
	 * 
	 * @Path("/processXMLMessage/") public VistaOutboundResponse
	 * persistXMLMessage(MessageType message) {
	 * 
	 * VistaOutboundResponse wsResponse = new VistaOutboundResponse(); try {
	 * 
	 * OutboundNcpdpMsgEntity outboundMsg = new OutboundNcpdpMsgEntity();
	 * 
	 * outboundMsg.setMessage(message);
	 * 
	 * outboundMsg.setErxStatus("0000");
	 * 
	 * outboundMsg.setPharmacyId(0);
	 * 
	 * Date date = new Date();
	 * 
	 * outboundMsg.setCreatedDate(date);
	 * 
	 * outboundMsg.setUpdatedDate(date);
	 * 
	 * outboundMsg.setReceivedDate(date);
	 * 
	 * outboundMsg.setScriptVersion(SCRIPT_VERSION);
	 * 
	 * long outboundMsgId = outboundNcpdpMsgService.saveOutboundMsg(outboundMsg);
	 * 
	 * wsResponse.setErrorMessage(null);
	 * 
	 * wsResponse.setSuccess(true);
	 * 
	 * wsResponse.setOutboundMsgId(outboundMsgId);
	 * 
	 * 
	 * } catch (Exception e) {
	 * 
	 * LOG.error("Error in VistaOutboundMsgImpl:"+e.getMessage());
	 * 
	 * wsResponse.setSuccess(false);
	 * 
	 * wsResponse.setErrorMessage("Error while saving vista outbound message: " +
	 * e.getMessage());
	 * 
	 * wsResponse.setOutboundMsgId(0); }
	 * 
	 * return wsResponse; }
	 * 
	 */

}
