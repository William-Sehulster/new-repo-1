package gov.va.med.pharmacy.jaxrs.mvi.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

import gov.va.med.pharmacy.jaxrs.mvi.model.Patient;
import gov.va.med.pharmacy.utility.StreamUtilities;
import gov.va.med.pharmacy.wsclients.mvi.AD;
import gov.va.med.pharmacy.wsclients.mvi.ActClassControlAct;
import gov.va.med.pharmacy.wsclients.mvi.CD;
import gov.va.med.pharmacy.wsclients.mvi.CE;
import gov.va.med.pharmacy.wsclients.mvi.COCTMT090100UV01AssignedPerson;
import gov.va.med.pharmacy.wsclients.mvi.COCTMT090100UV01Person;
import gov.va.med.pharmacy.wsclients.mvi.CS;
import gov.va.med.pharmacy.wsclients.mvi.CommunicationFunctionType;
import gov.va.med.pharmacy.wsclients.mvi.EN;
import gov.va.med.pharmacy.wsclients.mvi.EntityClassDevice;
import gov.va.med.pharmacy.wsclients.mvi.II;
import gov.va.med.pharmacy.wsclients.mvi.INT;
import gov.va.med.pharmacy.wsclients.mvi.IVLTS;
import gov.va.med.pharmacy.wsclients.mvi.MCCIMT000100UV01Agent;
import gov.va.med.pharmacy.wsclients.mvi.MCCIMT000100UV01Device;
import gov.va.med.pharmacy.wsclients.mvi.MCCIMT000100UV01Organization;
import gov.va.med.pharmacy.wsclients.mvi.MCCIMT000100UV01Receiver;
import gov.va.med.pharmacy.wsclients.mvi.MCCIMT000100UV01Sender;
import gov.va.med.pharmacy.wsclients.mvi.PRPAIN201305UV02;
import gov.va.med.pharmacy.wsclients.mvi.PRPAIN201305UV02QUQIMT021001UV01ControlActProcess;
import gov.va.med.pharmacy.wsclients.mvi.PRPAIN201306UV02;
import gov.va.med.pharmacy.wsclients.mvi.PRPAIN201306UV02MFMIMT700711UV01RegistrationEvent;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201306UV02LivingSubjectAdministrativeGender;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201306UV02LivingSubjectBirthTime;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201306UV02LivingSubjectId;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201306UV02LivingSubjectName;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201306UV02ParameterList;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201306UV02PatientAddress;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201306UV02PatientTelecom;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201306UV02QueryByParameter;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201310UV02OtherIDs;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201310UV02Patient;
import gov.va.med.pharmacy.wsclients.mvi.PRPAMT201310UV02Person;
import gov.va.med.pharmacy.wsclients.mvi.QUQIMT021001UV01DataEnterer;
import gov.va.med.pharmacy.wsclients.mvi.SXCMTS;
import gov.va.med.pharmacy.wsclients.mvi.TEL;
import gov.va.med.pharmacy.wsclients.mvi.TS;
import gov.va.med.pharmacy.wsclients.mvi.VAIdM;
import gov.va.med.pharmacy.wsclients.mvi.VAIdMPort;
import gov.va.med.pharmacy.wsclients.mvi.XActMoodIntentEvent;

/**
 * MVI Client Class, A JAXWS Client Class for MVI Web Service.
 *
 */
public class MVIClient {

	// Constant Strings

	private static final String WSCLIENTS_PROPERTIES_FILE = "gov.va.med.pharmacy.inboundeRx.properties";
	private static final String PHYSICAL_CONST = "PHYS";
	private static final String COMMA_REGEX_CONST = "\\,";
	private static final String HOME_PHONE_CONST = "HP";
	private static final String COUNTRY_CONST = "country";
	private static final String POSTAL_CODE_CONST = "postalCode";
	private static final String STATE_CONST = "state";
	private static final String CITY_CONST = "city";
	private static final String STREET_ADDRESS_LINE_CONST = "streetAddressLine";
	private static final String MVI_CLIENT_ENDPOINT_PROPERTY = "mvi.client.endpoint";
	private static final String KEYSTORE_FILE_TYPE = "JKS";
	private static final String KEYSTORE_FILE_NAME_PROPERTY = "keystore.filename";
	private static final String KEYSTORE_PASSWD_PROPERTY = "keystore.password";
	private static final String LEGAL_NAME = "Legal Name";
	private static final String L_CHARACTER = "L";
	private static final String EMPTY_STRING = "";
	private static final String CAP_REGEX_CONST = "\\^";
	private static final String CONST_ESR = "ESR";
	private static final String CAP_CHARACTER = "^";
	private static final String SSN_ROOT = "2.16.840.1.113883.4.1";
	private static final String DATE_OF_BIRTH_CONST = "Date of Birth";
	private static final String GENDER_CONST = "Gender";
	private static final String MVI_COMP1_CONST = "MVI.COMP1";
	private static final String NF_STATUS = "NF";
	private static final String AE_STATUS = "AE";
	private static final String QE_STATUS = "QE";
	private static final String SSN_CONST = "SSN";
	private static final String OK_STATUS = "OK";
	private static final String QUERY_BY_PARAMETER_CONST = "queryByParameter";
	private static final String FAMILY_NAME_CONST = "family";
	private static final String GIVEN_NAME_CONST = "given";
	private static final String ASSIGNED_PERSON_ID_EXTENSION = "bfuser001";
	private static final String CONTROL_ACT_PROCESS_CODE = "PRPA_TE201305UV02";
	private static final String ITS_VERSION = "XML_1.0";
	private static final String TELECOM_CONST = "http://servicelocation/PDQuery";
	private static final String AP_CONST = "AP";
	private static final String ENT_CONST = "ENT";
	private static final String ASSIGNED_CONST = "ASSIGNED";
	private static final String PSN_CONST = "PSN";
	private static final String ASSIGNED_PERSON_HL7_QNAME = "assignedPerson";
	private static final String QUERY_ID_EXTENSION = "0b0be46c-86df-4811-b2c1-fd9bf9f109c5";
	private static final String QUERY_ID_ROOT = "1.2.840.114350.1.13.28.1.18.5.999";
	private static final String ORG_CONST = "ORG";
	private static final String REPRESENTED_ORGANIZATION_CONST = "representedOrganization";
	private static final String SENDER_AGENT_CLASS_CODE = "AGNT";
	private static final String VHA_ID_VALUE = "2.16.840.1.113883.4.349";
	private static final String DETERMINER_CODE = "INSTANCE";
	private static final String QUERY_STATUS = "NEW";
	private static final String INB_ERX_SENDER_CODE = "200PERX";
	private static final String MVI_HL7_QNAME = "urn:hl7-org:v3";
	private static final String AS_AGENT = "asAgent";
	private static final String ALWAYS = "AL";
	private static final String WS_ENVIROMENT = "T";
	private static final String MVI_WS_VERSION = "3.0";
	private static final String REQUEST_ID_ROOT = "1.2.840.114350.1.13.0.1.7.1.1";
	private static final String FIND_CANDIDATE_OPERATION = "PRPA_IN201305UV02";
	private static final String REQUEST_INTERACTION_ID = "2.16.840.1.113883.1.6";
	private static final QName SERVICE_NAME = new QName("http://vaww.oed.oit.va.gov", "VAIdM");

	
	
	//@Autowired
	//private Environment environment;
	
	public Patient getMVIData(Patient patientSearchObj) throws java.lang.Exception {

		// The following prints out a lot of debug information.
		// It should only be uncommented in dev environment or for
		// troubleshooting purposes only.

		// System.setProperty("javax.net.debug", "ssl, handshake");

		Properties properties = new Properties();
		
		InputStream inputStream = null;
		try {
			inputStream = this.getClass().getClassLoader()
					.getResourceAsStream(WSCLIENTS_PROPERTIES_FILE);
			if (null != inputStream) {
				properties.load(inputStream);
			}
		} finally {
			if (null != inputStream) {
				StreamUtilities.safeClose(inputStream);
			}
		}
			
		String mviClientEndpoint = null;
		
		Patient patientSearchResults = new Patient();

		// generate new query date and time
		Date queryCreationDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddhhmmss");
		String queryDate = dateFormat.format(queryCreationDate);

		// generate new random UUID

		UUID queryUUID = UUID.randomUUID();

		URL wsdlURL = VAIdM.WSDL_LOCATION;

		VAIdM ss = new VAIdM(wsdlURL, SERVICE_NAME);
		VAIdMPort port = ss.getVAIdMPort();

		
		mviClientEndpoint = properties.getProperty(MVI_CLIENT_ENDPOINT_PROPERTY).trim(); // trim the value for any potential whitespace.
		// Secure Dev
		((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,	mviClientEndpoint);

		// call method to setup TLS security parameters.
		setupTLS(port, properties);
		
		
		PRPAIN201305UV02 mviRequestObj = new PRPAIN201305UV02();
		II testRequestId = new II();
		testRequestId.setExtension(queryUUID.toString());
		testRequestId.setRoot(REQUEST_ID_ROOT);

		II interactionId = new II();
		interactionId.setExtension(FIND_CANDIDATE_OPERATION);
		interactionId.setRoot(REQUEST_INTERACTION_ID);

		TS createTime = new TS();
		createTime.setValue(queryDate);

		CS versionCode = new CS();
		versionCode.setCode(MVI_WS_VERSION);

		CS processingCode = new CS();

		// T for Test, P for Production
		processingCode.setCode(WS_ENVIROMENT);

		CS processingModeCode = new CS();
		processingModeCode.setCode(WS_ENVIROMENT);

		CS acceptAckCode = new CS();

		// Values can be AL, ER, NE, AL is default for request
		acceptAckCode.setCode(ALWAYS);

		mviRequestObj.setITSVersion(ITS_VERSION);
		mviRequestObj.setId(testRequestId);
		mviRequestObj.setCreationTime(createTime);
		mviRequestObj.setVersionCode(versionCode);
		mviRequestObj.setInteractionId(interactionId);
		mviRequestObj.setProcessingCode(processingCode);
		mviRequestObj.setProcessingModeCode(processingModeCode);
		mviRequestObj.setAcceptAckCode(acceptAckCode);

		// receiver start
		MCCIMT000100UV01Receiver receiver = new MCCIMT000100UV01Receiver();
		receiver.setTypeCode(CommunicationFunctionType.RCV);

		MCCIMT000100UV01Device receiverDevice = new MCCIMT000100UV01Device();
		receiverDevice.setClassCode(EntityClassDevice.DEV);
		receiverDevice.setDeterminerCode(DETERMINER_CODE);

		II receiverDeviceID = new II();
		receiverDeviceID.setRoot(VHA_ID_VALUE);

		receiverDevice.getId().add(receiverDeviceID);

		TEL telecom = new TEL();
		telecom.setValue(TELECOM_CONST);

		receiverDevice.getTelecom().add(telecom);

		receiver.setDevice(receiverDevice);

		// receiver end

		mviRequestObj.getReceiver().add(receiver);

		// sender start

		MCCIMT000100UV01Sender mccSender = new MCCIMT000100UV01Sender();
		mccSender.setTypeCode(CommunicationFunctionType.SND);

		MCCIMT000100UV01Device senderDevice = new MCCIMT000100UV01Device();
		senderDevice.setClassCode(EntityClassDevice.DEV);
		senderDevice.setDeterminerCode(DETERMINER_CODE);

		II senderDeviceID = new II();
		senderDeviceID.setRoot(VHA_ID_VALUE);
		senderDeviceID.setExtension(INB_ERX_SENDER_CODE);

		senderDevice.getId().add(senderDeviceID);

		MCCIMT000100UV01Agent senderAsAgent = new MCCIMT000100UV01Agent();

		MCCIMT000100UV01Organization representedOrganization = new MCCIMT000100UV01Organization();
		representedOrganization.setClassCode(ORG_CONST);
		representedOrganization.setDeterminerCode(DETERMINER_CODE);

		II representedOrganizationID = new II();
		representedOrganizationID.setRoot(VHA_ID_VALUE);
		representedOrganizationID.setExtension(INB_ERX_SENDER_CODE);

		representedOrganization.getId().add(representedOrganizationID);

		QName organizationQName = new QName(MVI_HL7_QNAME, REPRESENTED_ORGANIZATION_CONST);
		JAXBElement<MCCIMT000100UV01Organization> orgs = new JAXBElement<MCCIMT000100UV01Organization>(
				organizationQName, MCCIMT000100UV01Organization.class, representedOrganization);

		String senderAgentClassCode = new String(SENDER_AGENT_CLASS_CODE);

		senderAsAgent.getClassCode().add(senderAgentClassCode);

		senderAsAgent.setRepresentedOrganization(orgs);

		QName agentsQname = new QName(MVI_HL7_QNAME, AS_AGENT);

		JAXBElement<MCCIMT000100UV01Agent> agents = new JAXBElement<MCCIMT000100UV01Agent>(agentsQname,	MCCIMT000100UV01Agent.class, senderAsAgent);

		senderDevice.setAsAgent(agents);

		mccSender.setDevice(senderDevice);

		// sender end

		// ControlActProcess start
		PRPAIN201305UV02QUQIMT021001UV01ControlActProcess controlActProcess = new PRPAIN201305UV02QUQIMT021001UV01ControlActProcess();

		controlActProcess.setClassCode(ActClassControlAct.CACT);
		controlActProcess.setMoodCode(XActMoodIntentEvent.EVN);

		CD controlActProcessCode = new CD();

		controlActProcessCode.setCodeSystem(REQUEST_INTERACTION_ID);
		controlActProcessCode.setCode(CONTROL_ACT_PROCESS_CODE);
		controlActProcess.setCode(controlActProcessCode);

		QUQIMT021001UV01DataEnterer dataEnterer = new QUQIMT021001UV01DataEnterer();
		dataEnterer.setContextControlCode(AP_CONST);
		dataEnterer.getTypeCode().add(ENT_CONST);

		COCTMT090100UV01AssignedPerson assignedPerson = new COCTMT090100UV01AssignedPerson();
		assignedPerson.setClassCode(ASSIGNED_CONST);

		II assignedPersonId = new II();
		assignedPersonId.setRoot(VHA_ID_VALUE);
		assignedPersonId.setExtension(ASSIGNED_PERSON_ID_EXTENSION);

		assignedPerson.getId().add(assignedPersonId);

		COCTMT090100UV01Person searchAssignedPerson = new COCTMT090100UV01Person();
		searchAssignedPerson.getClassCode().add(PSN_CONST);
		searchAssignedPerson.setDeterminerCode(DETERMINER_CODE);

		EN searchName = new EN();

		String givenName = patientSearchObj.getFirstName().toUpperCase();
		String family = patientSearchObj.getLastName().toUpperCase();

		QName givenNameQName = new QName(MVI_HL7_QNAME, GIVEN_NAME_CONST);
		QName familyNameQName = new QName(MVI_HL7_QNAME, FAMILY_NAME_CONST);

		JAXBElement<String> givenNameElement = new JAXBElement<String>(givenNameQName, String.class, EN.class,givenName);
		JAXBElement<String> familyNameElement = new JAXBElement<String>(familyNameQName, String.class, EN.class,family);

		searchName.getContent().add(givenNameElement);
		searchName.getContent().add(familyNameElement);
		searchAssignedPerson.getName().add(searchName);

		QName personQname = new QName(MVI_HL7_QNAME, ASSIGNED_PERSON_HL7_QNAME);
		JAXBElement<COCTMT090100UV01Person> persons = new JAXBElement<COCTMT090100UV01Person>(personQname,	COCTMT090100UV01Person.class, searchAssignedPerson);

		assignedPerson.setAssignedPerson(persons);

		dataEnterer.setAssignedPerson(assignedPerson);

		controlActProcess.getDataEnterer().add(dataEnterer);

		// query by parameter start

		PRPAMT201306UV02QueryByParameter queryByParameter = new PRPAMT201306UV02QueryByParameter();

		II queryId = new II();
		queryId.setExtension(QUERY_ID_EXTENSION);
		queryId.setRoot(QUERY_ID_ROOT);

		queryByParameter.setQueryId(queryId);

		CS querySstatusCode = new CS();
		querySstatusCode.setCode(QUERY_STATUS);

		queryByParameter.setStatusCode(querySstatusCode);

		CS queryModifyCode = new CS();
		queryModifyCode.setCode(MVI_COMP1_CONST); // can be T or MVI.COMP1 for getCorIds.

		queryByParameter.setModifyCode(queryModifyCode);

		INT queryInitialQuantity = new INT();
		queryInitialQuantity.setValue(BigInteger.valueOf(1));

		queryByParameter.setInitialQuantity(queryInitialQuantity);

		PRPAMT201306UV02ParameterList queryParameterList = new PRPAMT201306UV02ParameterList();

		// set Gender
		if (null != patientSearchObj.getGender()) {

			PRPAMT201306UV02LivingSubjectAdministrativeGender personGender = new PRPAMT201306UV02LivingSubjectAdministrativeGender();
			CE genderValue = new CE();
			genderValue.setCode(patientSearchObj.getGender());
			personGender.getValue().add(genderValue);
			personGender.setSemanticsText(GENDER_CONST);

			queryParameterList.getLivingSubjectAdministrativeGender().add(personGender);
		}

		// set DOB
		if (null != patientSearchObj.getDateOfBirth()) {

			PRPAMT201306UV02LivingSubjectBirthTime personDOB = new PRPAMT201306UV02LivingSubjectBirthTime();
			IVLTS birthDateAndTime = new IVLTS();
			birthDateAndTime.setValue(patientSearchObj.getDateOfBirth());
			personDOB.getValue().add(birthDateAndTime);
			personDOB.setSemanticsText(DATE_OF_BIRTH_CONST);
			queryParameterList.getLivingSubjectBirthTime().add(personDOB);
		}

		// set SSN
		if (null != patientSearchObj.getSocSecNum()) {

			PRPAMT201306UV02LivingSubjectId personSSN = new PRPAMT201306UV02LivingSubjectId();
			II SSNValue = new II();
			SSNValue.setRoot(SSN_ROOT);

			SSNValue.setExtension(patientSearchObj.getSocSecNum());

			personSSN.getValue().add(SSNValue);
			personSSN.setSemanticsText(SSN_CONST);
			queryParameterList.getLivingSubjectId().add(personSSN);
		}

		// set name
		if (null != patientSearchObj.getFirstName() && null != patientSearchObj.getLastName()){

			PRPAMT201306UV02LivingSubjectName personName = new PRPAMT201306UV02LivingSubjectName();

			EN searchLegalName = new EN();

			searchLegalName.getContent().add(givenNameElement);
			searchLegalName.getContent().add(familyNameElement);

			searchLegalName.getUse().add(L_CHARACTER);

			personName.getValue().add(searchLegalName);
			personName.setSemanticsText(LEGAL_NAME);

			queryParameterList.getLivingSubjectName().add(personName);
		}
		
		// set address
		
		if (null != patientSearchObj.getAddress()) {

			PRPAMT201306UV02PatientAddress patientAddresss = new PRPAMT201306UV02PatientAddress();
			
			AD value = new AD();
			
			value.getUse().add(PHYSICAL_CONST);
			
			String streetAddressLine = null;
			String city = null;
			String state = null;
			String postalCode = null;
			String country = null;
			String[] addressTokens = null;
			
			
			addressTokens = patientSearchObj.getAddress().split(COMMA_REGEX_CONST);

			if (addressTokens != null && addressTokens.length > 0) {

				// run the loop only once.
				for (int i = 0; i < addressTokens.length; i++) {
					streetAddressLine = addressTokens[i].trim();
					
					// to avoid string index out of bound exception.
					if(addressTokens.length>=4){
					
						city = addressTokens[i+1].trim();
					
						state = addressTokens[i+2].trim();
					
						postalCode = addressTokens[i+3].trim();
					
					}
					
					if(addressTokens.length==5){
					
						country = addressTokens[i+4].trim();
					}
					
					break;
					
				}
			}
			
			
			QName streetAddressLineQName = new QName(MVI_HL7_QNAME, STREET_ADDRESS_LINE_CONST);
			QName cityQName = new QName(MVI_HL7_QNAME, CITY_CONST);
			QName stateQName = new QName(MVI_HL7_QNAME, STATE_CONST);
			QName postalCodeQName = new QName(MVI_HL7_QNAME, POSTAL_CODE_CONST);
			QName countryQName = new QName(MVI_HL7_QNAME, COUNTRY_CONST);
			
			JAXBElement<String> streetAddressLineElement = new JAXBElement<String>(streetAddressLineQName, String.class,  AD.class,streetAddressLine);
			JAXBElement<String> cityElement = new JAXBElement<String>(cityQName, String.class,  AD.class,city);
			JAXBElement<String> stateElement = new JAXBElement<String>(stateQName, String.class,  AD.class,state);
			JAXBElement<String> postalCodeElement = new JAXBElement<String>(postalCodeQName, String.class,  AD.class,postalCode);
			JAXBElement<String> countryElement = null;
			
			if(null!=country){
				countryElement = new JAXBElement<String>(countryQName, String.class,  AD.class,country);
			}

			
			value.getContent().add(streetAddressLineElement);
			value.getContent().add(cityElement);
			value.getContent().add(stateElement);
			value.getContent().add(postalCodeElement);
			if(null!=country){
				value.getContent().add(countryElement);
			}
			
			patientAddresss.getValue().add(value);
			
			queryParameterList.getPatientAddress().add(patientAddresss);
			
		}

		
		// set telephone.
		
		if (null != patientSearchObj.getTelephone()) {
			
			PRPAMT201306UV02PatientTelecom patientTelephone = new PRPAMT201306UV02PatientTelecom();
			
			TEL telephone = new TEL();
			telephone.getUse().add(HOME_PHONE_CONST);// Home Phone
			
			SXCMTS value = new SXCMTS();
			value.setValue(patientSearchObj.getTelephone());
			
			telephone.getUseablePeriod().add(value);
			
			patientTelephone.getValue().add(telephone);
			
			queryParameterList.getPatientTelecom().add(patientTelephone);
			
		}
		
		queryByParameter.setParameterList(queryParameterList);

		// query by parameter end
		QName queryQName = new QName(MVI_HL7_QNAME, QUERY_BY_PARAMETER_CONST);
		JAXBElement<PRPAMT201306UV02QueryByParameter> queries = new JAXBElement<PRPAMT201306UV02QueryByParameter>(
				queryQName, PRPAMT201306UV02QueryByParameter.class, queryByParameter);

		controlActProcess.setQueryByParameter(queries);
		// ControlActProcess end

		mviRequestObj.setSender(mccSender);
		mviRequestObj.setControlActProcess(controlActProcess);

		// WS Response and data filtering below.

		PRPAIN201306UV02 mviResponseObj = port.prpaIN201305UV02(mviRequestObj);

		String acknowledgementCode = mviResponseObj.getControlActProcess().getQueryAck().getQueryResponseCode().getCode();

		// Happy Path
		if (OK_STATUS.equalsIgnoreCase(acknowledgementCode)) {

			// looks like returning multiple.
			PRPAIN201306UV02MFMIMT700711UV01RegistrationEvent registertrationEvent = mviResponseObj.getControlActProcess().getSubject().get(0).getRegistrationEvent();

			PRPAMT201310UV02Patient patient = registertrationEvent.getSubject1().getPatient();

			List<II> ids = patient.getId();

			String ICN = null;
			StringBuffer stationdIdBuffer = new StringBuffer();
			String[] stationTokens = null;
			String stationIds = null;

			for (II id : ids) {
				if (id.getExtension().contains(CONST_ESR)) {

					ICN = id.getExtension();							

				}
				// get ICN only once.
				else if (StringUtils.isEmpty(ICN)) {

					ICN = id.getExtension();					
				}

				stationTokens = id.getExtension().split(CAP_REGEX_CONST);

				if (stationTokens != null && stationTokens.length > 0) {

					for (int i = 0; i < stationTokens.length; i++) {

						if (i == 2) {
							stationdIdBuffer.append(stationTokens[i]);
							if (stationdIdBuffer.length() > 0) {

								stationdIdBuffer.append(CAP_CHARACTER);
							}
							
							break;
							
						} else {
							
							continue;
						}
					}
				}

			}

			stationIds = stationdIdBuffer.toString();

			if (stationIds.endsWith(CAP_CHARACTER)) {
				stationIds = stationIds.substring(0, stationIds.length() - 1);
			}
			if (ICN != null){
				ICN = ICN.substring(0, ICN.indexOf(CAP_CHARACTER));
			};

			patientSearchResults.setStationIds(stationIds);

			patientSearchResults.setICN(ICN);

			PRPAMT201310UV02Person person = patient.getPatientPerson().getValue();

			List<Serializable> objs = person.getName().get(0).getContent();

			JAXBElement<String> returnedElement = new JAXBElement<String>(givenNameQName, String.class, EN.class,EMPTY_STRING);
			JAXBElement<String> returnedGivenNameElement = new JAXBElement<String>(givenNameQName, String.class, EN.class, EMPTY_STRING);
			JAXBElement<String> returnedFamilyNameElement = new JAXBElement<String>(familyNameQName, String.class,EN.class, EMPTY_STRING);

			for (Serializable obj : objs) {

				returnedElement = (JAXBElement) obj;

				if (givenNameQName.equals(returnedElement.getName())
						&& StringUtils.isEmpty(patientSearchResults.getFirstName())) {

					returnedGivenNameElement = returnedElement;
					patientSearchResults.setFirstName(returnedGivenNameElement.getValue());

				} else if (givenNameQName.equals(returnedElement.getName())
						&& StringUtils.isEmpty(patientSearchResults.getMiddleName())) {

					returnedGivenNameElement = returnedElement;
					patientSearchResults.setMiddleName(returnedGivenNameElement.getValue());

				}
				else if (familyNameQName.equals(returnedElement.getName())
						&& StringUtils.isEmpty(patientSearchResults.getLastName())) {

					returnedFamilyNameElement = returnedElement;
					patientSearchResults.setLastName(returnedFamilyNameElement.getValue());
				}

			}

			// get date of birth
			String dateOfBirth = person.getBirthTime().getValue();

			if (null != dateOfBirth) {

				patientSearchResults.setDateOfBirth(dateOfBirth);
			}

			// Social SN
			String socSecNum = EMPTY_STRING;
			List<PRPAMT201310UV02OtherIDs> otherIDs = person.getAsOtherIDs();

			for (PRPAMT201310UV02OtherIDs id : otherIDs) {
				if (SSN_CONST.equalsIgnoreCase(id.getClassCode().get(0))) {
					socSecNum = id.getId().get(0).getExtension();
					patientSearchResults.setSocSecNum(socSecNum);
					break;
				}

			}

			// build up the result object.
			patientSearchResults.setQueryReturnCode(acknowledgementCode);

			// clean up.
			returnedElement = null;
			returnedGivenNameElement = null;
			returnedFamilyNameElement = null;
			stationIds = null;
			givenNameQName = null;
			familyNameQName = null;

			ICN = null;
			mviRequestObj = null;
			mviResponseObj = null;
			acknowledgementCode = null;
			dateOfBirth = null;

		} // End Happy Path
		else if (QE_STATUS.equalsIgnoreCase(acknowledgementCode)) {
			// Query Error
			patientSearchResults.setQueryReturnCode(acknowledgementCode);
		}

		else if (AE_STATUS.equalsIgnoreCase(acknowledgementCode)) {
			// Application Error
			patientSearchResults.setQueryReturnCode(acknowledgementCode);
		}

		else if (NF_STATUS.equalsIgnoreCase(acknowledgementCode)) {
			// No Record Found
			patientSearchResults.setQueryReturnCode(acknowledgementCode);
		}

		return patientSearchResults;

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
	private void setupTLS(VAIdMPort port, Properties properties) throws FileNotFoundException, IOException, GeneralSecurityException {

		ClassLoader classloader = this.getClass().getClassLoader();
		
		File file = new File(classloader.getResource(properties.getProperty(KEYSTORE_FILE_NAME_PROPERTY).trim()).getFile());
		HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(port).getConduit();
		
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
