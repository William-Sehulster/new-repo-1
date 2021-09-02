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


public class ValidateDigitalSignature {
	
	private int checkpoint = -1;
	
	private ArrayList<String> elementsToSignWith = null;
	private String elementsToSignWith_String = "";
	
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
			checkpoint = 6000;
			ErrorMessage = e.getMessage();
			//LOG.error("Error in ValidateDigitalSignature.parseERXMessage():" + e.getMessage());
		}    
	}
	
	
	private boolean verifyDigitalSignature() {
		
		//LOG.debug("Entering verifyDigitalSignature method...");
    
		try {	        
			
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
			
			
			keyGen.initialize(1024, random);
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