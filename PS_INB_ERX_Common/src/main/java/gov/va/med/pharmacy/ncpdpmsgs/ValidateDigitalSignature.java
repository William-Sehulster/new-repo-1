package gov.va.med.pharmacy.ncpdpmsgs;

import java.security.cert.Certificate;
import java.security.cert.*;
import java.security.*;
import java.security.cert.CertificateFactory;
//import java.security.spec.*;
import java.io.StringReader;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.io.ByteArrayInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
//import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;

import java.net.URL;
import java.net.URLConnection;
import java.io.DataInputStream;


public class ValidateDigitalSignature {
	
	private int checkpoint = -1;
	
	private ArrayList<String> elementsToSignWith = null;
	private String elementsToSignWith_String = "";
	
	private boolean MbM_schedule_fault = false;
	
	//Below are all the elements used to create a Digital Signature as defined in Surescript's Implementation Guide v2017071
	private String DEA_prescriber="";
	private String SSN_prescriber="";
	private String lname_prescriber="";
	private String fname_prescriber="";
	private String address_ln1_prescriber="";
	private String address_ln2_prescriber="";
	private String city_prescriber="";
	private String state_prescriber="";
	private String postal_code_prescriber="";
	private String lname_patient="";
	private String fname_patient="";
	private String address_ln1_patient="";
	private String address_ln2_patient="";
	private String city_patient="";
	private String state_patient="";
	private String postal_code_patient="";	
	private String drug_name="";
	private String drug_strength="";
	private String quantity="";
	private String sig_text="";
	private String date_written_year="";
	private String date_written_month="";
	private String date_written_day="";
	private String effective_date_year="";
	private String effective_date_month="";
	private String effective_date_day="";
	private String refill_quantity_qualifier = "R";  //This always equals "R" and thus hardcoded
	private String refills="";
	private String notes="";
	private ArrayList<String> drug_name_compound = null;           //This can occur up to 25 times within an inbound message for each ingredient
	private ArrayList<String> drug_strength_compound = null;       //This can occur up to 25 times within an inbound message for each ingredient
	private ArrayList<String> quantity_compound = null;            //This can occur up to 25 times within an inbound message for each ingredient
	
	
	private String date_year_tmp="";
	private String date_month_tmp="";
	private String date_day_tmp="";
	
	private String NCPDPID = "";
	
	private boolean certificate_revoked = false;
	
	boolean compound_exists = false;
	
	private String ErrorMessage = "Initial State";
	
	private boolean Ds_created = false;
	
	// Exist Digital Signature indicator or not
	private boolean DSIndicator = false;

	// Digital Signature indicator value true or false
	private boolean isDSIndicator = false;

	private boolean isDigitalSignature = false;

	private byte[] createdDigitalSignature = null;
	
	private byte[] testingPubKey = null;
	
	private byte[] sigToVerify = null;
	
	private byte[] eRxDigest = null;
	
	private byte[] createdeRxDigest = null;
	
	private byte[] eRxX509Data = null;
	
	private String eRxX509Data_String = "";
	
	private String sigToVerify_String = "";
	
	private String eRxDigest_String = "";
	
	private String digestMethod;
	
	private boolean signatureVerified = false;
	
	private String schedule_code="";
	
	private String donotfill="";
	
	private String incomingMsg_digestMethod;

	
	
	//List of URLs extracted from X509 certificate used to verify if or if not the certificate has been placed on CRL
	private List<String> crlUrls = new ArrayList<String>();
	private String certSerialNumber = "";
	private String certRevokeReason = "";
	

	// Built-in logger for Inbound eRx: taken from InboundNCPDPMessageServiceImpl.java.
	//private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(ValidateDigitalSignature.class);
	
	
	public ValidateDigitalSignature(String incomingMessage) {
		
		//LOG.debug("Entering ValidateDigitalSignature public constructor...");
		
		parseERXMessage(incomingMessage);
		
		if(sigToVerify != null || eRxDigest != null || eRxX509Data != null || digestMethod != null) {
			isDigitalSignature = true;
		}
		
		//create the buffer needed to create and/or validate the Digital Signature
		createelementsToSignWith();
	}
	
	// We must get a copy of the XML message and parse it here because the eRx data
	// does not persist currently due to use of SAXParser.
	private void parseERXMessage(String incomingMessage) {
		
		//LOG.debug("Entering parseERXMessage method...");
		
		elementsToSignWith = new ArrayList<>();
		
		try {

		    SAXParserFactory factory = SAXParserFactory.newInstance();
		    //Elsa.Chen - Fortify-An XML parser should be configured securely so that it does not allow external entities as part of an incoming XML document
		    factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
		    factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);	
		    SAXParser saxParser = factory.newSAXParser();
		    XMLReader xmlReader = saxParser.getXMLReader();

		    // Overrides DefaultHandler class.
		    ContentHandler handler = new ContentHandler() {
		    	
		    	// XML Header location tracking to prevent extraction of elements with same name, but wrong header.
		    	boolean bPatientHeader = false;
		    	boolean bPrescriberHeader = false;
		    	boolean bMedicationPrescribedHeader = false;
		    	boolean bMedicationResponseHeader = false;		    
		    	
		    	// DS data.
		    	boolean bDSIndicator = false;
			    boolean bDigestMethod = false;
			    boolean bDigestValue = false;
			    boolean bSignatureValue = false;
			    boolean bX509Data = false;
		    	
			    // eRx normal data.
			    boolean bDeaNumber = false;
			    boolean bSSN = false;
			    boolean bLastName = false;
			    boolean bFirstName = false;
			    boolean bAddressLine1 = false;
			    boolean bAddressLine2 = false;
			    boolean bCity = false;
			    boolean bStateProvince = false;
			    boolean bPostalCode = false;
			    boolean bDrugDescription = false;
			    boolean bStrengthValue = false;
			    boolean bValue = false;
			    boolean bDate = false;
			    boolean bDateTime = false;
				boolean bSchedule = false;
				boolean bScheduleCode = false;
				boolean bDoNotFill = false;
				boolean bNumberOfRefills=false;
				boolean bNote=false;
				boolean bcompound=false;
				boolean bcompoundDescription = false;
				boolean beffectiveDate = false;
				boolean bsigtext = false;
				boolean bName = false;
				boolean bOtherMedicationDate = false;
				boolean bOtherMedicationDateQualifier = false;
				
				//Pharmacy Data
				boolean bNCPDPID = false;
			    
			    @Override
			    public void startElement(String uri, String localName,String qName, 
		                				 Attributes attributes) throws SAXException {
			    	
			    	if (qName.equalsIgnoreCase("Patient")) {
			    		bPatientHeader = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("Prescriber")) {
			    		bPatientHeader = false;
			    		bPrescriberHeader = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("Name")) {
			    		bName = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("MedicationPrescribed")) {
			    		bMedicationPrescribedHeader = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("MedicationResponse")) {
			    		bMedicationResponseHeader = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("DigitalSignatureIndicator")) {
			    		bDSIndicator = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("DigestMethod")) {
			    		bDigestMethod = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("DigestValue")) {
			    		bDigestValue = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("SignatureValue")) {
			    		bSignatureValue = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("X509Data")) {
			    		bX509Data = true;
			        }
			        
			    	
			    	if (qName.equalsIgnoreCase("DEANumber") && bPrescriberHeader == true) {
			    		bDeaNumber = true;
			        }
	
			        if (qName.equalsIgnoreCase("SocialSecurity") && bPrescriberHeader == true) {
			        	bSSN = true;
			        }
	
			        if (qName.equalsIgnoreCase("LastName")) {
			        	bLastName = true;
			        }
	
			        if (qName.equalsIgnoreCase("FirstName")) {
			        	bFirstName = true;
			        }
			        
			        if ((qName.equalsIgnoreCase("AddressLine1") && bPatientHeader == true) ||
			        	 qName.equalsIgnoreCase("AddressLine1") && bPrescriberHeader == true) {
			        	bAddressLine1 = true;
			        }
			        
			        if ((qName.equalsIgnoreCase("AddressLine2") && bPatientHeader == true) ||
				         qName.equalsIgnoreCase("AddressLine2") && bPrescriberHeader == true) {
				        bAddressLine2 = true;
				    }
			        
			        if ((qName.equalsIgnoreCase("City") && bPatientHeader == true) ||
				         qName.equalsIgnoreCase("City") && bPrescriberHeader == true) {
				        bCity = true;
				    }
			        
			        if ((qName.equalsIgnoreCase("StateProvince") && bPatientHeader == true) ||
				         qName.equalsIgnoreCase("StateProvince") && bPrescriberHeader == true) {
				        bStateProvince = true;
				    }
			        
			        if ((qName.equalsIgnoreCase("PostalCode") && bPatientHeader == true) ||
				         qName.equalsIgnoreCase("PostalCode") && bPrescriberHeader == true) {
				        bPostalCode = true;
				    }
			        
			        if (qName.equalsIgnoreCase("DrugDescription")) {
			        	bDrugDescription = true;
			        }
			        
			        if (qName.equalsIgnoreCase("StrengthValue")) {
			        	bStrengthValue = true;
			        }
			        
					if (qName.equalsIgnoreCase("DEASchedule")  ){
						bSchedule = true;
					}
					
					if (qName.equalsIgnoreCase("Code") && bMedicationPrescribedHeader == true && bSchedule == true ){
						bScheduleCode = true;
					}
					
					if (qName.equalsIgnoreCase("Code") && bMedicationResponseHeader == true && bSchedule == true ){
						bScheduleCode = true;
					}
			        
			        if (qName.equalsIgnoreCase("Value")) {
			        	bValue = true;
			        }
			        
			        if (qName.equalsIgnoreCase("Date") && bMedicationPrescribedHeader == true) {
			        	bDate = true;
			        }
			        
			        if (qName.equalsIgnoreCase("DateTime")) {
			        	bDateTime = true;
			        }
			        if (qName.equalsIgnoreCase("OtherMedicationDate")) {
			        	bOtherMedicationDate = true;
			        }
			        if (qName.equalsIgnoreCase("OtherMedicationDateQualifier")) {
			        	bOtherMedicationDateQualifier = true;
			        }
					if (qName.equalsIgnoreCase("NumberOfRefills") && (bMedicationPrescribedHeader == true || bMedicationResponseHeader == true ) ){
						bNumberOfRefills = true;
					}	
					if ((qName.equalsIgnoreCase("Note") ||qName.equalsIgnoreCase("Notes")) && (bMedicationPrescribedHeader == true || bMedicationResponseHeader == true ) ){
						bNote = true;
					}
			        if (qName.equalsIgnoreCase("DoNotFill")) {
			        	bDoNotFill = true;
			        }
			        if (qName.equalsIgnoreCase("Compound")) {
			        	bcompound = true;
			        	compound_exists = true;
			        }
			        if (qName.equalsIgnoreCase("CompoundIngredientItemDescripton")) {
			        	bcompoundDescription = true;
			        }
			        if (qName.equalsIgnoreCase("SigText")) {
			        	bsigtext = true;
			        }			        

			        if (qName.equalsIgnoreCase("NCPDPID")) {
			        	bNCPDPID = true;
			        }
			    }
			    
			    @Override
			    public void endElement(String uri, String localName,
			            String qName) throws SAXException {
			    	
			    	if (qName.equalsIgnoreCase("X509Data")) {
			    		bX509Data = false;
			        }
			    	
			    	if (qName.equalsIgnoreCase("SignatureValue")) {
			    		bSignatureValue = false;
			        }
			    	
			    	if (qName.equalsIgnoreCase("Name")) {
			    		bName = false;
			        }
			    	
			        if (qName.equalsIgnoreCase("OtherMedicationDate")) {
			        	bOtherMedicationDate = false;
			        }			    	
			        if (qName.equalsIgnoreCase("NCPDPID")) {
			        	bNCPDPID = false;
			        }

			          	// Default method

			        }

			    @Override
		        public void characters(char ch[], int start, int length) throws SAXException {
			    	
			    	if (bDSIndicator) {
			    		
			    		DSIndicator = true;
		                
		            	String temp = new String(ch, start, length);
		            	
		            	if(temp.equalsIgnoreCase("true")) {
		            		isDSIndicator = true;
		            	}
		            	
		            	else if(temp.equalsIgnoreCase("false")) {
		            		isDSIndicator = false;
		            	}
		            	
		            	// DS Indicator is true, finish parsing process and perform auto DS.
		            	// TO BE IMPLEMENTED IN FUTURE SPRINT, FOR NOW FORWARD MESSAGE.
		            	bDSIndicator = false;
		            }
		            
		            if (bDigestMethod) {
		            	digestMethod = new String(ch, start, length);
		            	
		            	if(digestMethod.equalsIgnoreCase("SHA-1") || digestMethod.equalsIgnoreCase("SHA1WithRSA")) {
		            		incomingMsg_digestMethod = "SHA-1";
		            		digestMethod = "SHA1WithRSA";
		            	}
		            	
		            	else if(digestMethod.equalsIgnoreCase("SHA-256") || digestMethod.equalsIgnoreCase("SHA256WithRSA")) {
		            		incomingMsg_digestMethod = "SHA-256";
		            		digestMethod = "SHA256WithRSA";
		            	}
		            	
		            	bDigestMethod = false;
		            }
		            
		            if (bDigestValue) {
		            	eRxDigest_String = new String(ch, start, length);
		            	eRxDigest = Base64.getDecoder().decode(eRxDigest_String);
		            	bDigestValue = false;
		            }
		            
		            if (bSignatureValue) {
		            	sigToVerify_String = sigToVerify_String + new String(ch, start, length);
		            	sigToVerify = Base64.getDecoder().decode(sigToVerify_String);
		            	//bSignatureValue = false;
		            }
		            
		            if (bX509Data) {
		            	eRxX509Data_String = eRxX509Data_String + new String(ch, start, length);
		            	eRxX509Data = Base64.getDecoder().decode(eRxX509Data_String);
		            	//bX509Data = false;
		            }
		            
	            	if (bDeaNumber) {
	            		//elementsToSignWith.add(new String(ch, start, length));
	            		DEA_prescriber = new String(ch, start, length);
	            		bDeaNumber = false;
		            }

		            if (bSSN) {
		            	//elementsToSignWith.add(new String(ch, start, length));
		            	SSN_prescriber = new String(new String(ch, start, length));
		                bSSN = false;
		            }

		            if (bLastName && bPatientHeader && bName) {
		            	//elementsToSignWith.add(new String(ch, start, length));
		                    bLastName = false;
		                	lname_patient = new String(ch, start, length);    
		            }
		            
		            if (bLastName && bPrescriberHeader && bName) {
		            	    bLastName = false;
		            	    lname_prescriber = new String(ch, start, length);
		            }
		            
		            if (bFirstName && bPatientHeader && bName) {
		            	//elementsToSignWith.add(new String(ch, start, length));
		                    bFirstName = false;
		                	fname_patient = new String(ch, start, length);    
		            }
		            
		            if (bFirstName && bPrescriberHeader && bName) {
		            	    bFirstName = false;
		            	    fname_prescriber = new String(ch, start, length);
		            }

		            
		            if(bAddressLine1 && bPatientHeader)
		            {
		            	 bAddressLine1 = false;
		            	 address_ln1_patient = new String(ch, start, length);
		            }
		            
		            if(bAddressLine1 && bPrescriberHeader)
		            {
		            	 bAddressLine1 = false;
		            	 address_ln1_prescriber = new String(ch, start, length);
		            }
		            
		       
		            if(bAddressLine2 && bPatientHeader)
		            {
		            	 bAddressLine2 = false;
		            	 address_ln2_patient = new String(ch, start, length);
		            }
		            
		            if(bAddressLine2 && bPrescriberHeader)
		            {
		            	 bAddressLine2 = false;
		            	 address_ln2_prescriber = new String(ch, start, length);
		            }
		            
		            if(bCity && bPatientHeader) {
		            	bCity = false;
		            	city_patient = new String(ch, start, length);
		            }
		            
		            if(bCity && bPrescriberHeader) {
		            	bCity = false;
		            	city_prescriber = new String(ch, start, length);
		            }
		            
		            if(bStateProvince && bPatientHeader)
		            {
		            	bStateProvince = false;
		            	state_patient = new String(ch, start, length);
		            }
		            
		            if(bStateProvince && bPrescriberHeader)
		            {
		            	bStateProvince = false;
		            	state_prescriber = new String(ch, start, length);
		            }

		            // Postal code is last element we look for inside of headers, so reset header states once read in.
		            if(bPostalCode && bPatientHeader)
		            {
		            	postal_code_patient = new String(ch, start, length);
		            	
		            	bPatientHeader = false;
		            	bPostalCode = false;
		            }
		            
		            if(bPostalCode && bPrescriberHeader)
		            {
		            	postal_code_prescriber = new String(ch, start, length);
		            	
		            	bPrescriberHeader = false;
		            	bPostalCode = false;
		            }
		            
		            if (bPostalCode) {
		            	//elementsToSignWith.add(new String(ch, start, length));
		                
		                if(bMedicationPrescribedHeader) {
		                	postal_code_prescriber = new String(ch, start, length);
		                }
		                else {
		                	postal_code_patient = new String(ch, start, length);
		                }	
		                
		            	bPatientHeader = false;
		            	bPrescriberHeader = false;
		            	bMedicationPrescribedHeader = false;
		                bPostalCode = false;		                
		            }
		            
		            if (bDrugDescription) {
		            	//elementsToSignWith.add(new String(ch, start, length));
		            	drug_name = new String(ch, start, length);
		                bDrugDescription = false;
		            }

		            if (bStrengthValue) {
		            	//elementsToSignWith.add(new String(ch, start, length));
		            	if(bcompound) {
		            		drug_strength_compound.add(new String(ch, start, length));
		            	}
		            	else {
		            		drug_strength = new String(ch, start, length);
		            	}
		                bStrengthValue = false;
		            }
		            
					if (bSchedule && bScheduleCode) {
						
						schedule_code = new String(ch, start, length);
						bSchedule = false;
					}
					
					if (bDoNotFill) {
						
						donotfill = new String(ch, start, length);
						bDoNotFill = false;
					}

		            if (bValue) {
		            	//elementsToSignWith.add(new String(ch, start, length));
		            	if(bcompound) {
		            		quantity_compound.add(new String(ch, start, length));
		            	}
		            	else {
		                quantity = new String(ch, start, length);
		            	}
		                bValue = false;
		            }

		            if(bsigtext)
		            {
		            	bsigtext = false;
		            	sig_text = new String(ch, start, length);		            			
		            	
		            }
		            if (bDate) {
		            	//elementsToSignWith.add(new String(ch, start, length));
		            	String temp_date = new String(ch, start, length);
		            	
		            	if(bOtherMedicationDate) {
		            		date_year_tmp = temp_date.substring(0,4);
		            		date_month_tmp = temp_date.substring(5,7);
		            		date_day_tmp = temp_date.substring(8,10);
		            	}
		            	else {	
			            	date_written_year = temp_date.substring(0,4);
			            	date_written_month = temp_date.substring(5,7);
			            	date_written_day = temp_date.substring(8,10);
		            	}
		                bDate = false;
		            }

		            if (bDateTime) {
		            	//elementsToSignWith.add(new String(ch, start, length));
		            	String temp_date = new String(ch, start, length);
		            	
		            	if(beffectiveDate) {
		            		date_year_tmp = temp_date.substring(0,4);
		            		date_month_tmp = temp_date.substring(5,7);
		            		date_day_tmp = temp_date.substring(8,10);
		            	}
		            	else {
			            	date_written_year = temp_date.substring(0,4);
			            	date_written_month = temp_date.substring(5,7);
			            	date_written_day = temp_date.substring(8,10);		                
		            	}
		            	bDateTime = false;
		            }
		            
		            if(bOtherMedicationDateQualifier)
		            {
		            	String compare = new String(ch, start, length);
		            	
		            	//Check to see if Other Medication Date Qualifier is equal to 'EffectiveDate'
		            	//if it is not equal, remove the previous date parsed in the OtherMedicationDate Field
		            	if(compare.equalsIgnoreCase("EffectiveDate"))
		            	{
		            		effective_date_year = date_year_tmp;
		            		effective_date_month = date_month_tmp;
		            		effective_date_day = date_day_tmp;	
		            	}
		            	
		            }		            
		            
					if (bNumberOfRefills) {						
						
						//numberOfRefills = new String(ch, start, length);
						//elementsToSignWith.add(new String(ch, start, length));
						
						refills = new String(ch, start, length);
						bNumberOfRefills = false;
					}
					
					if (bNote) {
						//note = new String(ch, start, length);
						//elementsToSignWith.add(new String(ch, start, length));
						
						notes = new String(ch, start, length);
						bNote = false;
					}
					if (bcompoundDescription) {
						
						drug_name_compound.add(new String(ch, start, length));
						bcompoundDescription = false;
					}
					if(bNCPDPID) {
						NCPDPID = new String(ch, start, length);
					}

		        }

				@Override
				public void endDocument() throws SAXException {
					// TODO Auto-generated method stub. Required for modified ContentHandler in XMLReader.
					
				}

				@Override
				public void endPrefixMapping(String arg0) throws SAXException {
					// TODO Auto-generated method stub. Required for modified ContentHandler in XMLReader.
					
				}

				@Override
				public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
					// TODO Auto-generated method stub. Required for modified ContentHandler in XMLReader.
					
				}

				@Override
				public void processingInstruction(String arg0, String arg1) throws SAXException {
					// TODO Auto-generated method stub. Required for modified ContentHandler in XMLReader.
					
				}

				@Override
				public void setDocumentLocator(Locator arg0) {
					// TODO Auto-generated method stub. Required for modified ContentHandler in XMLReader.
					
				}

				@Override
				public void skippedEntity(String arg0) throws SAXException {
					// TODO Auto-generated method stub. Required for modified ContentHandler in XMLReader.
					
				}

				@Override
				public void startDocument() throws SAXException {
					// TODO Auto-generated method stub. Required for modified ContentHandler in XMLReader.
					
				}

				@Override
				public void startPrefixMapping(String arg0, String arg1) throws SAXException {
					// TODO Auto-generated method stub. Required for modified ContentHandler in XMLReader.
					
				}
			};		
			
			InputSource inputParseXML = new InputSource(new StringReader(incomingMessage));
			inputParseXML.setEncoding("UTF-8");
			xmlReader.setContentHandler(handler);
			
			xmlReader.parse(inputParseXML);
	
			//LOG.debug("SAX Parsing of eRx completed...");
		}
		
		catch(Exception e) {
			//checkpoint = 6000;
			ErrorMessage = e.getMessage();
			//LOG.error("Error in ValidateDigitalSignature.parseERXMessage():" + e.getMessage());
		}    
	}
	
	
	private boolean verifyDigitalSignature() {
		
		//LOG.debug("Entering verifyDigitalSignature method...");
    
		try {	        
			
			//Extract CRL URLs from the X509 certificate 
			CRLExtraction(eRxX509Data);
			
			//Check to see if their Certificate within the message is contained within the CA's CRL
			//Will return True if Certificate is contained within CRL and will no longer continue to 
			//process DS
			if(CertVerification(eRxX509Data)) return false;
			
			//Check to see Pharmacy identified within the script is a Meds by Mail (MbM) pharmacy and 
			//if it is check to see if the Schedule type of the drug is Scedule II, if so reject message.
			if(MbM_Check()) return false;
			
			
			//checkpoint = 9000;
			//Verify Digest
			MessageDigest dig = MessageDigest.getInstance(incomingMsg_digestMethod);
			//checkpoint = 9001;
			byte[] localDigest = dig.digest(elementsToSignWith_String.getBytes());
			//checkpoint = 9002;
			boolean digestHashMatch = Arrays.equals(localDigest, eRxDigest);
			//checkpoint = 9003;
			if(!digestHashMatch) return false;
			
			//checkpoint = 9004;

			//Create Certificate Object
			CertificateFactory certFactory = CertificateFactory.getInstance("X509");
			//checkpoint = 9005;
			Certificate x509Cert = certFactory.generateCertificate(new ByteArrayInputStream(eRxX509Data));
			
			//checkpoint = 9006;
            //Create Signature Object
			Signature sig = Signature.getInstance(digestMethod);
			//checkpoint = 9007;
			sig.initVerify(x509Cert.getPublicKey());
			//checkpoint = 9008;
			sig.update(elementsToSignWith_String.getBytes());
			
			//checkpoint = 9009;
			//verify Signature
			boolean verified = sig.verify(sigToVerify);	
			//checkpoint = 9010;
			setSignatureVerified (verified);

			//if(verified)
			//	checkpoint = 99999;
			//else
			//	checkpoint = 999991;
			
			return verified;
			
/*
			// Read in public key from eRx and convert to a PublicKey object for use.
			X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(eRxX509Data);
			//KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			
			PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
			checkpoint = 7003;	
			// Create signature object to be verified against.
			Signature sig = Signature.getInstance(digestMethod);
			
			sig.initVerify(pubKey);
			sig.update(elementsToSignWith_String.getBytes());
			
			// Verify the supplied hash against our generated one.
			setSignatureVerified (sig.verify(sigToVerify));
			return getSignatureVerified();
*/	
		} 
  
		catch(NoSuchAlgorithmException e) {
			
			// If supplied hashing algorithm is not available from specified provider.
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
			ErrorMessage = e.getMessage();
			
		}
		
		catch(ProviderException e) {
			
			// Provider is not in registered security provider list.
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
			ErrorMessage = e.getMessage();
			
		}
		
		catch(InvalidKeyException e) {
			
			// Supplied opaque public key is invalid.
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
			ErrorMessage = e.getMessage();
			
		}
		
		catch(SignatureException e) {
			
			//checkpoint = 9003;
			// sig.verify has technical issue. Will not trigger if verification simply returns false.
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
			ErrorMessage = e.getMessage();
		}
		catch(CertificateException e) {
			
			ErrorMessage = e.getMessage();

			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
			
		}
		
		
		catch(Exception e) {
		    
			
			ErrorMessage = e.getMessage();
			//checkpoint = 9004;
			// General exceptions
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
		
		}
		
		return false;
    }
	
	//Creates Buffer used to create Digital signature as described in Surescripts Implementation guide v2017071
	private void createelementsToSignWith() {
		
		if(!DEA_prescriber.isEmpty()) {
			elementsToSignWith.add(DEA_prescriber);
			elementsToSignWith_String = elementsToSignWith_String + DEA_prescriber;
		}
		if(!SSN_prescriber.isEmpty()) {
			elementsToSignWith.add(SSN_prescriber);
			elementsToSignWith_String = elementsToSignWith_String + SSN_prescriber;
		}
		if(!lname_prescriber.isEmpty()) {
			elementsToSignWith.add(lname_prescriber);
			elementsToSignWith_String = elementsToSignWith_String + lname_prescriber;
		}
		if(!fname_prescriber.isEmpty()) {
			elementsToSignWith.add(fname_prescriber);
			elementsToSignWith_String = elementsToSignWith_String + fname_prescriber;
		}
		if(!address_ln1_prescriber.isEmpty()) {
			elementsToSignWith.add(address_ln1_prescriber);
			elementsToSignWith_String = elementsToSignWith_String + address_ln1_prescriber;
		}
		if(!address_ln2_prescriber.isEmpty()) {
			elementsToSignWith.add(address_ln2_prescriber);
			elementsToSignWith_String = elementsToSignWith_String + address_ln2_prescriber;
		}
		if(!city_prescriber.isEmpty()) {
			elementsToSignWith.add(city_prescriber);
			elementsToSignWith_String = elementsToSignWith_String + city_prescriber;
		}
		if(!state_prescriber.isEmpty()) {
			elementsToSignWith.add(state_prescriber);
			elementsToSignWith_String = elementsToSignWith_String + state_prescriber;
		}
		if(!postal_code_prescriber.isEmpty()) {
			elementsToSignWith.add(postal_code_prescriber);
			elementsToSignWith_String = elementsToSignWith_String + postal_code_prescriber;
		}
		if(!lname_patient.isEmpty()) {
			elementsToSignWith.add(lname_patient);
			elementsToSignWith_String = elementsToSignWith_String + lname_patient;
		}
		if(!fname_patient.isEmpty()) {
			elementsToSignWith.add(fname_patient);
			elementsToSignWith_String = elementsToSignWith_String + fname_patient;
		}
		if(!address_ln1_patient.isEmpty()) {
			elementsToSignWith.add(address_ln1_patient);
			elementsToSignWith_String = elementsToSignWith_String + address_ln1_patient;
		}
		if(!address_ln2_patient.isEmpty()) {
			elementsToSignWith.add(address_ln2_patient);
			elementsToSignWith_String = elementsToSignWith_String + address_ln2_patient;
		}
		if(!city_patient.isEmpty()) {
			elementsToSignWith.add(city_patient);
			elementsToSignWith_String = elementsToSignWith_String + city_patient;
		}
		if(!state_patient.isEmpty()) {
			elementsToSignWith.add(state_patient);
			elementsToSignWith_String = elementsToSignWith_String + state_patient;
		}
		if(!postal_code_patient.isEmpty()) {
			elementsToSignWith.add(postal_code_patient);
			elementsToSignWith_String = elementsToSignWith_String + postal_code_patient;
		}
		if(!drug_name.isEmpty()) {
			elementsToSignWith.add(drug_name);
			elementsToSignWith_String = elementsToSignWith_String + drug_name;
		}
		if(!drug_strength.isEmpty()) {
			elementsToSignWith.add(drug_strength);
			elementsToSignWith_String = elementsToSignWith_String + drug_strength;
		}
		if(!quantity.isEmpty()) {
			elementsToSignWith.add(quantity);
			elementsToSignWith_String = elementsToSignWith_String + quantity;
		}
		if(!sig_text.isEmpty()) {
			elementsToSignWith.add(sig_text);
			elementsToSignWith_String = elementsToSignWith_String + sig_text;
		}
		if(!date_written_year.isEmpty()) {
			elementsToSignWith.add(date_written_year);
			elementsToSignWith_String = elementsToSignWith_String + date_written_year;
		}
		if(!date_written_month.isEmpty()) {
			elementsToSignWith.add(date_written_month);
			elementsToSignWith_String = elementsToSignWith_String + date_written_month;
		}
		if(!date_written_day.isEmpty()) {
			elementsToSignWith.add(date_written_day);
			elementsToSignWith_String = elementsToSignWith_String + date_written_day;
		}
		if(!effective_date_year.isEmpty()) {
			elementsToSignWith.add(effective_date_year);
			elementsToSignWith_String = elementsToSignWith_String + effective_date_year;
		}
		if(!effective_date_month.isEmpty()) {
			elementsToSignWith.add(effective_date_month);
			elementsToSignWith_String = elementsToSignWith_String + effective_date_month;
		}
		if(!effective_date_day.isEmpty()) {
			elementsToSignWith.add(effective_date_day);
			elementsToSignWith_String = elementsToSignWith_String + effective_date_day;
		}
		if(!refill_quantity_qualifier.isEmpty()) {
			elementsToSignWith.add(refill_quantity_qualifier);
			elementsToSignWith_String = elementsToSignWith_String + refill_quantity_qualifier;
		}
		if(!refills.isEmpty()) {
			elementsToSignWith.add(refills);
			elementsToSignWith_String = elementsToSignWith_String + refills;
		}
		if(!notes.isEmpty()) {
			elementsToSignWith.add(notes);
			elementsToSignWith_String = elementsToSignWith_String + notes;
		}
		
		if(compound_exists)
		{
	        for(int i = 0; i < drug_name_compound.size(); i++)
	        {
	        	elementsToSignWith.add(drug_name_compound.get(i));  
	        	elementsToSignWith.add(drug_strength_compound.get(i));
	        	elementsToSignWith.add(quantity_compound.get(i));
	        }
		}
		
	}
	
	// Creates digital signature to attach to eRx message.
	// Use getters and setters to get data to implementing class.
	private void createDigitalSignature() {
		
		//LOG.debug("Entering createDigitalSignature method...");
		
		//digestMethod = "SHA256withDSA";
		digestMethod = "SHA256withRSA";
		incomingMsg_digestMethod =  "SHA-256";
		
		// Generate the private/public key pair.
		try {
			checkpoint++;//0
			//KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
			checkpoint++;//1
			//SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			
			
			checkpoint++;//2
			
			
			keyGen.initialize(2048, random);
			checkpoint++;//3
			KeyPair pair = keyGen.generateKeyPair();
			checkpoint++;//4
			
			PrivateKey privateKey = pair.getPrivate();
			checkpoint++;//5
			// Generated to the X.509 standard which is a part of the DSA standard.
			PublicKey publicKey = pair.getPublic();
			checkpoint++;//6
			
			
			testingPubKey = publicKey.getEncoded();
			checkpoint++;//7
			
			//Signature sig = Signature.getInstance("SHA256withDSA", "SUN"); 
			Signature sig = Signature.getInstance("SHA256withRSA");
			checkpoint++;//8
			
			
			sig.initSign(privateKey);
			checkpoint++;//9
			
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");
			
			// Supply signature creation with data to be signed with.
		/*	for(String item : elementsToSignWith) {
				sig.update(item.getBytes());
				md.update(item.getBytes());
			}
*/
			
			sig.update(elementsToSignWith_String.getBytes());
			md.update(elementsToSignWith_String.getBytes());
			
			createdeRxDigest = md.digest();
			checkpoint++;//10
			createdDigitalSignature = sig.sign();
			checkpoint++;//11
		}
		
		catch(Exception e) {
			
			//LOG.error("Error in ValidateDigitalSignature.createDigitalSignature():" + e.getMessage());
		}	
	}
	

	// Method to be called from other parts of inbound eRx.
	public boolean getValidation() {

		//LOG.debug("Entering getValidation method...");
		//boolean invalid = true;
		
		boolean valid = false;
    	if(isDSIndicator) {
    		
     		createDigitalSignature();
    		
    		//signatureVerified = false;
    		//provide newly generated values to be verified
    		//this.digestMethod = "SHA256withDSA";
    		this.digestMethod = "SHA256withRSA";
     		this.eRxDigest = this.createdeRxDigest;
    		this.eRxX509Data = this.testingPubKey;
    		this.sigToVerify = this.createdDigitalSignature;
    		setDs_created (true);
    		valid = true;
    		checkpoint++;//12
    		
    		//Check to see Pharmacy identified within the script is a Meds by Mail (MbM) pharmacy and 
    		//if it is check to see if the Schedule type of the drug is Schedule II, if so reject message.
    		if(MbM_Check()) {
    			
    			setSignatureVerified (false);
    			return false;
    		}
    		
    		
    		//verify the newly created digital signature
    		//return verifyDigitalSignature();
    		//return true;
    	}

       if(isDigitalSignature) {
    		
    		valid = verifyDigitalSignature();
     	 }
       
		//return signatureVerified;
       return valid;
    }
    

	private void CRLExtraction(byte[] x509)
	{
		
		try
        {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

            //X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(new FileInputStream(new File("CERT_FILE_PATH")));
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(eRxX509Data));

            byte[] crlDistributionPointDerEncodedArray = certificate.getExtensionValue(Extension.cRLDistributionPoints.getId());

            ASN1InputStream oAsnInStream = new ASN1InputStream(new ByteArrayInputStream(crlDistributionPointDerEncodedArray));
            ASN1Primitive derObjCrlDP = oAsnInStream.readObject();
            DEROctetString dosCrlDP = (DEROctetString) derObjCrlDP;

            oAsnInStream.close();

            byte[] crldpExtOctets = dosCrlDP.getOctets();
            ASN1InputStream oAsnInStream2 = new ASN1InputStream(new ByteArrayInputStream(crldpExtOctets));
            ASN1Primitive derObj2 = oAsnInStream2.readObject();
            CRLDistPoint distPoint = CRLDistPoint.getInstance(derObj2);

            oAsnInStream2.close();

            //List<String> crlUrls = new ArrayList<String>();
            for (DistributionPoint dp : distPoint.getDistributionPoints())
            {
                DistributionPointName dpn = dp.getDistributionPoint();
                // Look for URIs in fullName
                if (dpn != null)
                {
                    if (dpn.getType() == DistributionPointName.FULL_NAME)
                    {
                        GeneralName[] genNames = GeneralNames.getInstance(dpn.getName()).getNames();
                        // Look for an URI
                        for (int j = 0; j < genNames.length; j++)
                        {
                            if (genNames[j].getTagNo() == GeneralName.uniformResourceIdentifier)
                            {
                                String url = DERIA5String.getInstance(genNames[j].getName()).getString();
                                crlUrls.add(url);
                            }
                        }
                    }
                }
            }

            //for (String url : crlUrls)
                //System.out.println(url);
        }
        catch (Throwable e)
        {
        	ErrorMessage = e.getMessage();
        }
    }		
	
	//CertVerification method checks whether a certificate is contained within its CA's CRL.
	//If it is contained within the CRL that means the certificate is revoked and should not 
	//be processed further.
	//Input:  X509 Certificate
	//Output: TRUE/FALSE   TRUE-Cert is revoked    FALSE-Cert was not found in CRL
	private boolean CertVerification(byte[] x509)
	{
        //String certificatePath = "C:\\Users\\user1\\Desktop\\test.cer";
		//boolean revoked = false;
		
        try {
        	//checkpoint = 9000;
		        CertificateFactory cf = CertificateFactory.getInstance("X509");
		        //checkpoint = 9001;
		        X509Certificate certificate = null;
		        //checkpoint = 9002;
		        X509CRLEntry revokedCertificate = null;
		        //checkpoint = 9003;
		        X509CRL crl = null;
		        //checkpoint = 9004;
		        
		        //boolean revoked = false;
		
		        certificate = (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(eRxX509Data));
		        //certSerialNumber = certificate.getSerialNumber().toString();
		        //checkpoint = 9005;
		        for (String url_crl : crlUrls)
		        {
		        	//checkpoint = 9006;
			        URL url = new URL(url_crl);
			        //checkpoint = 9007;
			        URLConnection connection = url.openConnection();
			        //checkpoint = 9008;
			
			        try(DataInputStream inStream = new DataInputStream(connection.getInputStream())){
			
			        	//checkpoint = 9009;
			            crl = (X509CRL)cf.generateCRL(inStream);
			            //checkpoint = 9010;
			        }
			
			        //checkpoint = 9011;
			        if ( (certificate !=null) && ((certificate.getSerialNumber()) !=null ) &&  (crl != null) ) {
			        revokedCertificate = crl.getRevokedCertificate(certificate.getSerialNumber());}
			        
			        //checkpoint = 9012;
			        if(revokedCertificate !=null){
			        certSerialNumber = revokedCertificate.getSerialNumber().toString();}
			        //checkpoint = 9013;
			       // certRevokeReason = revokedCertificate.getRevocationReason().toString();
			        //checkpoint = 9014;
			
			        if(revokedCertificate !=null){
			        	certificate_revoked = true;
			        	//checkpoint = 999999;
			        }
		
		        }
        //http://javax.xml.XMLConstants/property/accessExternalDTD
           }
        catch (Throwable e)
        {
        	ErrorMessage = e.getMessage();
        }
        
        //checkpoint = 9014;
        return certificate_revoked;
		
	}
	
	private boolean MbM_Check()
	{
		//check incoming message against the below pharmacies
	   String MbM_pharm_ncpdpid_1 = "1162700";
	   String MbM_pharm_ncpdpid_2 = "5204437";
	   
	   if (NCPDPID.equalsIgnoreCase(MbM_pharm_ncpdpid_1) || NCPDPID.equalsIgnoreCase(MbM_pharm_ncpdpid_2))
		   if(this.getSchedule().equalsIgnoreCase("C48675"))
			   MbM_schedule_fault = true;
	   
	   return MbM_schedule_fault;
			   
	}
	
	public boolean getMbM_fault() {
		return MbM_schedule_fault;
	}
	
	public String getRevokeReason()
	{
		return certRevokeReason;
		
	}
	public String getCertSerialNumber()
	{
		
		return certSerialNumber;
	}

	//Returns whether the cert contained within the digital signature has been revoked
	public boolean isCertRevoked()
	{
		
		return certificate_revoked;
	}
	
	//Return all URLs extracted from the certificate
	public String getCRL_URL()
	{
		String CA_URL = "";
		
		for (String url : crlUrls)
			CA_URL = CA_URL + url + " ";
		
		return CA_URL;
	}
	// Getters for the created digital signature so that it may be appended onto the 
    // response buffer in InboundNCPDPMessageServiceImpl.java.
	public boolean getDSIndicator() {
		return DSIndicator;
	}
	
	public boolean getDs_created() {
		return Ds_created;
	}
	
	public void setDs_created(boolean onceCreated ) {

		this.Ds_created = onceCreated;
	}
	
	public boolean getSignatureVerified() {
		return signatureVerified;
	}
	
	public void setSignatureVerified(boolean afterVarified ) {

		this.signatureVerified = afterVarified;
	}
	
	public byte[] getTestingPubKey() {
		
		return testingPubKey;
	}

	public String getCreatedDigitalSignature() {

		String temp = new String(createdDigitalSignature, StandardCharsets.UTF_8);
		
		return temp;
	}
	
	public String getDigestMethod() {

		return digestMethod;
	}
	
	public String getIncomingMsg_DigestMethod() {

		return incomingMsg_digestMethod;
	}
	
	public boolean getHasDigitalSignature() {

		return isDigitalSignature;
	}
	
	public boolean getHasDSIndicator() {

		return isDSIndicator;
	}
	
	public String getCheckpoint() {
		
		String temp = String.valueOf(checkpoint);
		return temp;
	}
/*	
	public ArrayList<String> getElementsToSignWith() {
		
		return elementsToSignWith;
	}
*/	
	
	public String getElementsToSignWith() {
		
		return elementsToSignWith_String;
	}
	
	public boolean getHasSignatureVerified() {
		
		return signatureVerified;
	}
	
	public String getCreatedeRxDigest() {
		
		String temp = new String(createdeRxDigest, StandardCharsets.UTF_8);
		return temp;
	}
	
	public String getSchedule() {
		
		return schedule_code;
	}
	
	public String getDoNotFill() {
		
		return donotfill;
	}
 // Start ELSA
    public String getTestingPubKeyString() {
              return ((testingPubKey ==null) ? null : Base64.getEncoder().encodeToString(testingPubKey));       
       }
  
    public String getCreatedDigitalSignatureString() {
              return ((createdDigitalSignature ==null) ? null : Base64.getEncoder().encodeToString(createdDigitalSignature));           
       }
    
    public String getCreatedeRxDigestString() {
           return ((createdeRxDigest ==null) ? null : Base64.getEncoder().encodeToString(createdeRxDigest));
    }
           
    public String getsigToVerifyString() {
           return ((sigToVerify ==null) ? null : Base64.getEncoder().encodeToString(sigToVerify));       
       }
    
    public String geteRxDigestString() {
        return ((eRxDigest ==null) ? null : Base64.getEncoder().encodeToString(eRxDigest));       
    }
    
    public String geteRxX509DataString() {
        //return ((eRxX509Data ==null) ? null : Base64.getEncoder().encodeToString(eRxX509Data)); 
    	return eRxX509Data_String;
    }
    
    public String getSigToVerifyString() {
    	return sigToVerify_String;
    }
    
    public String getDigestValueString() {
    	return eRxDigest_String;
    }
    
    public String getErrorMessage() {
    	
    	return ErrorMessage;
    }

 // End ELSA
	
}
