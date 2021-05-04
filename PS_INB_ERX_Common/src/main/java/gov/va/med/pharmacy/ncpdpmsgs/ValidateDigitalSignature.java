package gov.va.med.pharmacy.ncpdpmsgs;

import java.security.*;
import java.security.spec.*;
import java.io.StringReader;
import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

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
	
	private String digestMethod;
	
	private boolean signatureVerified = false;
	
	private String schedule_code="";
	
	private String incomingMsg_digestMethod;
	

	// Built-in logger for Inbound eRx: taken from InboundNCPDPMessageServiceImpl.java.
	//private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(ValidateDigitalSignature.class);
	
	
	public ValidateDigitalSignature(String incomingMessage) {
		
		//LOG.debug("Entering ValidateDigitalSignature public constructor...");
		
		parseERXMessage(incomingMessage);
		
		if(sigToVerify != null || eRxDigest != null || eRxX509Data != null || digestMethod != null) {
			isDigitalSignature = true;
		}
	}
	
	// We must get a copy of the XML message and parse it here because the eRx data
	// does not persist currently due to use of SAXParser.
	private void parseERXMessage(String incomingMessage) {
		
		//LOG.debug("Entering parseERXMessage method...");
		
		elementsToSignWith = new ArrayList<>();
		
		try {

		    SAXParserFactory factory = SAXParserFactory.newInstance();
		    SAXParser saxParser = factory.newSAXParser();
		    XMLReader xmlReader = saxParser.getXMLReader();

		    // Overrides DefaultHandler class.
		    ContentHandler handler = new ContentHandler() {
		    	
		    	// XML Header location tracking to prevent extraction of elements with same name, but wrong header.
		    	boolean bPatientHeader = false;
		    	boolean bPrescriberHeader = false;
		    	boolean bMedicationPrescribedHeader = false;
		    	
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
			    
			    @Override
			    public void startElement(String uri, String localName,String qName, 
		                				 Attributes attributes) throws SAXException {
			    	
			    	if (qName.equalsIgnoreCase("Patient")) {
			    		bPatientHeader = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("Prescriber")) {
			    		bPrescriberHeader = true;
			        }
			    	
			    	if (qName.equalsIgnoreCase("MedicationPrescribed")) {
			    		bMedicationPrescribedHeader = true;
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
			        
			    	
			    	if (qName.equalsIgnoreCase("DEANumber")) {
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
			        
			        if (qName.equalsIgnoreCase("Value")) {
			        	bValue = true;
			        }
			        
			        if (qName.equalsIgnoreCase("Date") && bMedicationPrescribedHeader == true) {
			        	bDate = true;
			        }
			        
			        if (qName.equalsIgnoreCase("DateTime")) {
			        	bDateTime = true;
			        }

			    }
			    
			    @Override
			    public void endElement(String uri, String localName,
			            String qName) throws SAXException {

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
		            	
		            	if(digestMethod.equalsIgnoreCase("SHA-1") || digestMethod.equalsIgnoreCase("SHA1WithDSA")) {
		            		incomingMsg_digestMethod = "SHA-1";
		            		digestMethod = "SHA1WithDSA";
		            	}
		            	
		            	else if(digestMethod.equalsIgnoreCase("SHA-256") || digestMethod.equalsIgnoreCase("SHA256WithDSA")) {
		            		incomingMsg_digestMethod = "SHA-256";
		            		digestMethod = "SHA256WithDSA";
		            	}
		            	
		            	bDigestMethod = false;
		            }
		            
		            if (bDigestValue) {
		            	eRxDigest = Base64.getDecoder().decode(new String(ch, start, length));
		            	bDigestValue = false;
		            }
		            
		            if (bSignatureValue) {
		            	sigToVerify = Base64.getDecoder().decode(new String(ch, start, length));
		            	bSignatureValue = false;
		            }
		            
		            if (bX509Data) {
		            	eRxX509Data = Base64.getDecoder().decode(new String(ch, start, length));
		            	bX509Data = false;
		            }
		            
	            	if (bDeaNumber) {
	            		elementsToSignWith.add(new String(ch, start, length));
	            		bDeaNumber = false;
		            }

		            if (bSSN) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bSSN = false;
		            }

		            if (bLastName) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bLastName = false;
		            }
		            
		            if (bFirstName) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bFirstName = false;
		            }

		            if (bAddressLine1) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bAddressLine1 = false;
		            }

		            if (bAddressLine2) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bAddressLine2 = false;
		            }
		            
		            if (bCity) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bCity = false;
		            }

		            if (bStateProvince) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bStateProvince = false;
		            }

		            // Postal code is last element we look for inside of headers, so reset header states once read in.
		            if (bPostalCode) {
		            	elementsToSignWith.add(new String(ch, start, length));
		            	bPatientHeader = false;
		            	bPrescriberHeader = false;
		            	bMedicationPrescribedHeader = false;
		                bPostalCode = false;
		            }
		            
		            if (bDrugDescription) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bDrugDescription = false;
		            }

		            if (bStrengthValue) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bStrengthValue = false;
		            }
		            
					if (bSchedule && bScheduleCode) {
						
						schedule_code = new String(ch, start, length);
						bSchedule = false;
					}

		            if (bValue) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bValue = false;
		            }
		            
		            if (bDate) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bDate = false;
		            }

		            if (bDateTime) {
		            	elementsToSignWith.add(new String(ch, start, length));
		                bDateTime = false;
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
			
			//LOG.error("Error in ValidateDigitalSignature.parseERXMessage():" + e.getMessage());
		}    
	}
	
	
	private boolean verifyDigitalSignature() {
		
		//LOG.debug("Entering verifyDigitalSignature method...");
		
		try {
			
			// Read in public key from eRx and convert to a PublicKey object for use.
			X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(eRxX509Data);
	
			KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");

			
			PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
				
			// Create signature object to be verified against.
			Signature sig = Signature.getInstance(digestMethod, "SUN");

			
			sig.initVerify(pubKey);
				
			// enhanced for loop to sig.update with fields to be signed
			for(String item : elementsToSignWith) {
				
				sig.update(item.getBytes());
			}
				
			// Verify the supplied hash against our generated one.
			//return signatureVerified = sig.verify(sigToVerify);
			//signatureVerified = sig.verify(sigToVerify);
			setSignatureVerified (sig.verify(sigToVerify));
			checkpoint=20; //20
			return getSignatureVerified();
	
		} 
  
		catch(NoSuchAlgorithmException e) {
			
			checkpoint = 9000;
			// If supplied hashing algorithm is not available from specified provider.
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
			
		}
		
		catch(ProviderException e) {
			
			checkpoint = 9001;
			// Provider is not in registered security provider list.
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
			
		}
		
		catch(InvalidKeyException e) {
			
			checkpoint = 9002;
			// Supplied opaque public key is invalid.
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
			
		}
		
		catch(SignatureException e) {
			
			checkpoint = 9003;
			// sig.verify has technical issue. Will not trigger if verification simply returns false.
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
			
		}
		
		catch(Exception e) {
		    
			checkpoint = 9004;
			// General exceptions
			//LOG.error("Error in ValidateDigitalSignature.verifyDigitalSignature():" + e.getMessage());
		
		}
		
		return false;
    }
	
	// Creates digital signature to attach to eRx message.
	// Use getters and setters to get data to implementing class.
	private void createDigitalSignature() {
		
		//LOG.debug("Entering createDigitalSignature method...");
		
		digestMethod = "SHA256withDSA";
		incomingMsg_digestMethod =  "SHA-256";
		
		// Generate the private/public key pair.
		try {
			checkpoint++;//0
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
			checkpoint++;//1
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
			
			
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
			
			Signature sig = Signature.getInstance("SHA256withDSA", "SUN"); 
			checkpoint++;//8
			
			
			sig.initSign(privateKey);
			checkpoint++;//9
			
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");
			
			// Supply signature creation with data to be signed with.
			for(String item : elementsToSignWith) {
				sig.update(item.getBytes());
				md.update(item.getBytes());
			}

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
    		this.digestMethod = "SHA256withDSA";
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
	
	public ArrayList<String> getElementsToSignWith() {
		
		return elementsToSignWith;
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
        return ((eRxX509Data ==null) ? null : Base64.getEncoder().encodeToString(eRxX509Data));       
    }

 // End ELSA
	
}