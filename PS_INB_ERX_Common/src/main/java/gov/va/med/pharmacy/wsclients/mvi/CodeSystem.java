
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CodeSystem.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CodeSystem"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ABCcodes"/&gt;
 *     &lt;enumeration value="AS4E"/&gt;
 *     &lt;enumeration value="AS4"/&gt;
 *     &lt;enumeration value="AcknowledgementDetailType"/&gt;
 *     &lt;enumeration value="AcknowledgementCondition"/&gt;
 *     &lt;enumeration value="AcknowledgementDetailCode"/&gt;
 *     &lt;enumeration value="AcknowledgementType"/&gt;
 *     &lt;enumeration value="ActClass"/&gt;
 *     &lt;enumeration value="ActCode"/&gt;
 *     &lt;enumeration value="ActExposureLevelCode"/&gt;
 *     &lt;enumeration value="ActInvoiceElementModifier"/&gt;
 *     &lt;enumeration value="ActMood"/&gt;
 *     &lt;enumeration value="ActPriority"/&gt;
 *     &lt;enumeration value="ActReason"/&gt;
 *     &lt;enumeration value="ActRelationshipCheckpoint"/&gt;
 *     &lt;enumeration value="ActRelationshipJoin"/&gt;
 *     &lt;enumeration value="ActRelationshipSplit"/&gt;
 *     &lt;enumeration value="ActRelationshipSubset"/&gt;
 *     &lt;enumeration value="ActRelationshipType"/&gt;
 *     &lt;enumeration value="ActSite"/&gt;
 *     &lt;enumeration value="ActStatus"/&gt;
 *     &lt;enumeration value="ActUncertainty"/&gt;
 *     &lt;enumeration value="AddressPartType"/&gt;
 *     &lt;enumeration value="AdministrativeGender"/&gt;
 *     &lt;enumeration value="ACR"/&gt;
 *     &lt;enumeration value="ATC"/&gt;
 *     &lt;enumeration value="AmericanIndianAlaskaNativeLanguages"/&gt;
 *     &lt;enumeration value="CAMNCVS"/&gt;
 *     &lt;enumeration value="CSAID"/&gt;
 *     &lt;enumeration value="CDCA"/&gt;
 *     &lt;enumeration value="CDCM"/&gt;
 *     &lt;enumeration value="CDS"/&gt;
 *     &lt;enumeration value="CVX"/&gt;
 *     &lt;enumeration value="MVX"/&gt;
 *     &lt;enumeration value="CD2"/&gt;
 *     &lt;enumeration value="CE"/&gt;
 *     &lt;enumeration value="CLP"/&gt;
 *     &lt;enumeration value="CST"/&gt;
 *     &lt;enumeration value="C4"/&gt;
 *     &lt;enumeration value="C5"/&gt;
 *     &lt;enumeration value="Calendar"/&gt;
 *     &lt;enumeration value="CalendarCycle"/&gt;
 *     &lt;enumeration value="CalendarType"/&gt;
 *     &lt;enumeration value="CCI"/&gt;
 *     &lt;enumeration value="ICD-10-CA"/&gt;
 *     &lt;enumeration value="Charset"/&gt;
 *     &lt;enumeration value="CAS"/&gt;
 *     &lt;enumeration value="CodeSystem"/&gt;
 *     &lt;enumeration value="CodingRationale"/&gt;
 *     &lt;enumeration value="CommunicationFunctionType"/&gt;
 *     &lt;enumeration value="CompressionAlgorithm"/&gt;
 *     &lt;enumeration value="ConceptGenerality"/&gt;
 *     &lt;enumeration value="Confidentiality"/&gt;
 *     &lt;enumeration value="ContainerCap"/&gt;
 *     &lt;enumeration value="ContainerSeparator"/&gt;
 *     &lt;enumeration value="ContentProcessingMode"/&gt;
 *     &lt;enumeration value="ContextControl"/&gt;
 *     &lt;enumeration value="Currency"/&gt;
 *     &lt;enumeration value="DCL"/&gt;
 *     &lt;enumeration value="DQL"/&gt;
 *     &lt;enumeration value="DCM"/&gt;
 *     &lt;enumeration value="DataType"/&gt;
 *     &lt;enumeration value="Dentition"/&gt;
 *     &lt;enumeration value="DeviceAlertLevel"/&gt;
 *     &lt;enumeration value="DocumentCompletion"/&gt;
 *     &lt;enumeration value="DocumentStorage"/&gt;
 *     &lt;enumeration value="EPSG-GeodeticParameterDataset"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="EditStatus"/&gt;
 *     &lt;enumeration value="EducationLevel"/&gt;
 *     &lt;enumeration value="EmployeeJobClass"/&gt;
 *     &lt;enumeration value="EncounterAcuity"/&gt;
 *     &lt;enumeration value="EncounterAccident"/&gt;
 *     &lt;enumeration value="EncounterAdmissionSource"/&gt;
 *     &lt;enumeration value="EncounterReferralSource"/&gt;
 *     &lt;enumeration value="EncounterSpecialCourtesy"/&gt;
 *     &lt;enumeration value="EntityClass"/&gt;
 *     &lt;enumeration value="EntityCode"/&gt;
 *     &lt;enumeration value="EntityDeterminer"/&gt;
 *     &lt;enumeration value="EntityHandling"/&gt;
 *     &lt;enumeration value="EntityNamePartQualifier"/&gt;
 *     &lt;enumeration value="EntityNamePartType"/&gt;
 *     &lt;enumeration value="EntityNameUse"/&gt;
 *     &lt;enumeration value="EntityRisk"/&gt;
 *     &lt;enumeration value="EntityStatus"/&gt;
 *     &lt;enumeration value="ENZC"/&gt;
 *     &lt;enumeration value="EquipmentAlertLevel"/&gt;
 *     &lt;enumeration value="Ethnicity"/&gt;
 *     &lt;enumeration value="E5"/&gt;
 *     &lt;enumeration value="E7"/&gt;
 *     &lt;enumeration value="E6"/&gt;
 *     &lt;enumeration value="ExposureMode"/&gt;
 *     &lt;enumeration value="FDK"/&gt;
 *     &lt;enumeration value="FDDX"/&gt;
 *     &lt;enumeration value="FDDC"/&gt;
 *     &lt;enumeration value="GTSAbbreviation"/&gt;
 *     &lt;enumeration value="GenderStatus"/&gt;
 *     &lt;enumeration value="HPC"/&gt;
 *     &lt;enumeration value="HB"/&gt;
 *     &lt;enumeration value="CodeSystemType"/&gt;
 *     &lt;enumeration value="ConceptStatus"/&gt;
 *     &lt;enumeration value="HL7ITSVersionCode"/&gt;
 *     &lt;enumeration value="ConceptProperty"/&gt;
 *     &lt;enumeration value="HL7CommitteeIDInRIM"/&gt;
 *     &lt;enumeration value="HL7ConformanceInclusion"/&gt;
 *     &lt;enumeration value="HL7DefinedRoseProperty"/&gt;
 *     &lt;enumeration value="HL7StandardVersionCode"/&gt;
 *     &lt;enumeration value="HL7UpdateMode"/&gt;
 *     &lt;enumeration value="HI"/&gt;
 *     &lt;enumeration value="HealthcareProviderTaxonomyHIPAA"/&gt;
 *     &lt;enumeration value="HHC"/&gt;
 *     &lt;enumeration value="HtmlLinkType"/&gt;
 *     &lt;enumeration value="ICS"/&gt;
 *     &lt;enumeration value="I10"/&gt;
 *     &lt;enumeration value="I10P"/&gt;
 *     &lt;enumeration value="I9C"/&gt;
 *     &lt;enumeration value="I9"/&gt;
 *     &lt;enumeration value="IC2"/&gt;
 *     &lt;enumeration value="IETF1766"/&gt;
 *     &lt;enumeration value="IBT"/&gt;
 *     &lt;enumeration value="MDC"/&gt;
 *     &lt;enumeration value="ISO3166-1"/&gt;
 *     &lt;enumeration value="ISO3166-2"/&gt;
 *     &lt;enumeration value="ISO3166-3"/&gt;
 *     &lt;enumeration value="ISO4217"/&gt;
 *     &lt;enumeration value="IUPC"/&gt;
 *     &lt;enumeration value="IUPP"/&gt;
 *     &lt;enumeration value="IntegrityCheckAlgorithm"/&gt;
 *     &lt;enumeration value="ICDO"/&gt;
 *     &lt;enumeration value="ICSD"/&gt;
 *     &lt;enumeration value="JC8"/&gt;
 *     &lt;enumeration value="LanguageAbilityMode"/&gt;
 *     &lt;enumeration value="LanguageAbilityProficiency"/&gt;
 *     &lt;enumeration value="LivingArrangement"/&gt;
 *     &lt;enumeration value="LocalMarkupIgnore"/&gt;
 *     &lt;enumeration value="LocalRemoteControlState"/&gt;
 *     &lt;enumeration value="LN"/&gt;
 *     &lt;enumeration value="MDFAttributeType"/&gt;
 *     &lt;enumeration value="MDFSubjectAreaPrefix"/&gt;
 *     &lt;enumeration value="UMD"/&gt;
 *     &lt;enumeration value="MEDCIN"/&gt;
 *     &lt;enumeration value="MIME"/&gt;
 *     &lt;enumeration value="ManagedParticipationStatus"/&gt;
 *     &lt;enumeration value="MapRelationship"/&gt;
 *     &lt;enumeration value="MaritalStatus"/&gt;
 *     &lt;enumeration value="MaterialType"/&gt;
 *     &lt;enumeration value="MdfHmdMetSourceType"/&gt;
 *     &lt;enumeration value="MdfHmdRowType"/&gt;
 *     &lt;enumeration value="MdfRmimRowType"/&gt;
 *     &lt;enumeration value="MediaType"/&gt;
 *     &lt;enumeration value="MEDR"/&gt;
 *     &lt;enumeration value="MEDX"/&gt;
 *     &lt;enumeration value="MEDC"/&gt;
 *     &lt;enumeration value="MDDX"/&gt;
 *     &lt;enumeration value="MGPI"/&gt;
 *     &lt;enumeration value="MessageWaitingPriority"/&gt;
 *     &lt;enumeration value="MessageCondition"/&gt;
 *     &lt;enumeration value="ModifyIndicator"/&gt;
 *     &lt;enumeration value="MULTUM"/&gt;
 *     &lt;enumeration value="NAACCR"/&gt;
 *     &lt;enumeration value="NDA"/&gt;
 *     &lt;enumeration value="NOC"/&gt;
 *     &lt;enumeration value="NUCCProviderCodes"/&gt;
 *     &lt;enumeration value="NUBC-UB92"/&gt;
 *     &lt;enumeration value="NDC"/&gt;
 *     &lt;enumeration value="NAICS"/&gt;
 *     &lt;enumeration value="NullFlavor"/&gt;
 *     &lt;enumeration value="NIC"/&gt;
 *     &lt;enumeration value="NMMDS"/&gt;
 *     &lt;enumeration value="ObservationInterpretation"/&gt;
 *     &lt;enumeration value="ObservationMethod"/&gt;
 *     &lt;enumeration value="ObservationValue"/&gt;
 *     &lt;enumeration value="OHA"/&gt;
 *     &lt;enumeration value="OrderableDrugForm"/&gt;
 *     &lt;enumeration value="OrganizationNameType"/&gt;
 *     &lt;enumeration value="POS"/&gt;
 *     &lt;enumeration value="ParameterizedDataType"/&gt;
 *     &lt;enumeration value="ParticipationFunction"/&gt;
 *     &lt;enumeration value="ParticipationMode"/&gt;
 *     &lt;enumeration value="ParticipationSignature"/&gt;
 *     &lt;enumeration value="ParticipationType"/&gt;
 *     &lt;enumeration value="PatientImportance"/&gt;
 *     &lt;enumeration value="PaymentTerms"/&gt;
 *     &lt;enumeration value="PeriodicIntervalOfTimeAbbreviation"/&gt;
 *     &lt;enumeration value="PNDS"/&gt;
 *     &lt;enumeration value="PersonDisabilityType"/&gt;
 *     &lt;enumeration value="ConceptCodeRelationship"/&gt;
 *     &lt;enumeration value="PostalAddressUse"/&gt;
 *     &lt;enumeration value="ProbabilityDistributionType"/&gt;
 *     &lt;enumeration value="ProcedureMethod"/&gt;
 *     &lt;enumeration value="ProcessingID"/&gt;
 *     &lt;enumeration value="ProcessingMode"/&gt;
 *     &lt;enumeration value="QueryParameterValue"/&gt;
 *     &lt;enumeration value="QueryPriority"/&gt;
 *     &lt;enumeration value="QueryQuantityUnit"/&gt;
 *     &lt;enumeration value="QueryRequestLimit"/&gt;
 *     &lt;enumeration value="QueryResponse"/&gt;
 *     &lt;enumeration value="QueryStatusCode"/&gt;
 *     &lt;enumeration value="Race"/&gt;
 *     &lt;enumeration value="RC"/&gt;
 *     &lt;enumeration value="RelationalOperator"/&gt;
 *     &lt;enumeration value="RelationshipConjunction"/&gt;
 *     &lt;enumeration value="ReligiousAffiliation"/&gt;
 *     &lt;enumeration value="ResponseLevel"/&gt;
 *     &lt;enumeration value="ResponseModality"/&gt;
 *     &lt;enumeration value="ResponseMode"/&gt;
 *     &lt;enumeration value="RoleClass"/&gt;
 *     &lt;enumeration value="RoleCode"/&gt;
 *     &lt;enumeration value="RoleLinkType"/&gt;
 *     &lt;enumeration value="RoleStatus"/&gt;
 *     &lt;enumeration value="RouteOfAdministration"/&gt;
 *     &lt;enumeration value="SCDHEC-GISSpatialAccuracyTiers"/&gt;
 *     &lt;enumeration value="SNM3"/&gt;
 *     &lt;enumeration value="SNT"/&gt;
 *     &lt;enumeration value="SDM"/&gt;
 *     &lt;enumeration value="Sequencing"/&gt;
 *     &lt;enumeration value="SetOperator"/&gt;
 *     &lt;enumeration value="SpecialArrangement"/&gt;
 *     &lt;enumeration value="SpecimenType"/&gt;
 *     &lt;enumeration value="StyleType"/&gt;
 *     &lt;enumeration value="SubstanceAdminSubstitution"/&gt;
 *     &lt;enumeration value="SubstitutionCondition"/&gt;
 *     &lt;enumeration value="SNM"/&gt;
 *     &lt;enumeration value="TableCellHorizontalAlign"/&gt;
 *     &lt;enumeration value="TableCellScope"/&gt;
 *     &lt;enumeration value="TableCellVerticalAlign"/&gt;
 *     &lt;enumeration value="TableFrame"/&gt;
 *     &lt;enumeration value="TableRules"/&gt;
 *     &lt;enumeration value="IETF3066"/&gt;
 *     &lt;enumeration value="TargetAwareness"/&gt;
 *     &lt;enumeration value="TelecommunicationAddressUse"/&gt;
 *     &lt;enumeration value="RCFB"/&gt;
 *     &lt;enumeration value="RCV2"/&gt;
 *     &lt;enumeration value="TimingEvent"/&gt;
 *     &lt;enumeration value="TransmissionRelationshipTypeCode"/&gt;
 *     &lt;enumeration value="TribalEntityUS"/&gt;
 *     &lt;enumeration value="UC"/&gt;
 *     &lt;enumeration value="UCUM"/&gt;
 *     &lt;enumeration value="URLScheme"/&gt;
 *     &lt;enumeration value="UML"/&gt;
 *     &lt;enumeration value="UnitsOfMeasure"/&gt;
 *     &lt;enumeration value="UPC"/&gt;
 *     &lt;enumeration value="VaccineManufacturer"/&gt;
 *     &lt;enumeration value="VaccineType"/&gt;
 *     &lt;enumeration value="VocabularyDomainQualifier"/&gt;
 *     &lt;enumeration value="WC"/&gt;
 *     &lt;enumeration value="ART"/&gt;
 *     &lt;enumeration value="W4"/&gt;
 *     &lt;enumeration value="W1-W2"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CodeSystem")
@XmlEnum
public enum CodeSystem {

    @XmlEnumValue("ABCcodes")
    AB_CCODES("ABCcodes"),
    @XmlEnumValue("AS4E")
    AS_4_E("AS4E"),
    @XmlEnumValue("AS4")
    AS_4("AS4"),
    @XmlEnumValue("AcknowledgementDetailType")
    ACKNOWLEDGEMENT_DETAIL_TYPE("AcknowledgementDetailType"),
    @XmlEnumValue("AcknowledgementCondition")
    ACKNOWLEDGEMENT_CONDITION("AcknowledgementCondition"),
    @XmlEnumValue("AcknowledgementDetailCode")
    ACKNOWLEDGEMENT_DETAIL_CODE("AcknowledgementDetailCode"),
    @XmlEnumValue("AcknowledgementType")
    ACKNOWLEDGEMENT_TYPE("AcknowledgementType"),
    @XmlEnumValue("ActClass")
    ACT_CLASS("ActClass"),
    @XmlEnumValue("ActCode")
    ACT_CODE("ActCode"),
    @XmlEnumValue("ActExposureLevelCode")
    ACT_EXPOSURE_LEVEL_CODE("ActExposureLevelCode"),
    @XmlEnumValue("ActInvoiceElementModifier")
    ACT_INVOICE_ELEMENT_MODIFIER("ActInvoiceElementModifier"),
    @XmlEnumValue("ActMood")
    ACT_MOOD("ActMood"),
    @XmlEnumValue("ActPriority")
    ACT_PRIORITY("ActPriority"),
    @XmlEnumValue("ActReason")
    ACT_REASON("ActReason"),
    @XmlEnumValue("ActRelationshipCheckpoint")
    ACT_RELATIONSHIP_CHECKPOINT("ActRelationshipCheckpoint"),
    @XmlEnumValue("ActRelationshipJoin")
    ACT_RELATIONSHIP_JOIN("ActRelationshipJoin"),
    @XmlEnumValue("ActRelationshipSplit")
    ACT_RELATIONSHIP_SPLIT("ActRelationshipSplit"),
    @XmlEnumValue("ActRelationshipSubset")
    ACT_RELATIONSHIP_SUBSET("ActRelationshipSubset"),
    @XmlEnumValue("ActRelationshipType")
    ACT_RELATIONSHIP_TYPE("ActRelationshipType"),
    @XmlEnumValue("ActSite")
    ACT_SITE("ActSite"),
    @XmlEnumValue("ActStatus")
    ACT_STATUS("ActStatus"),
    @XmlEnumValue("ActUncertainty")
    ACT_UNCERTAINTY("ActUncertainty"),
    @XmlEnumValue("AddressPartType")
    ADDRESS_PART_TYPE("AddressPartType"),
    @XmlEnumValue("AdministrativeGender")
    ADMINISTRATIVE_GENDER("AdministrativeGender"),
    ACR("ACR"),
    ATC("ATC"),
    @XmlEnumValue("AmericanIndianAlaskaNativeLanguages")
    AMERICAN_INDIAN_ALASKA_NATIVE_LANGUAGES("AmericanIndianAlaskaNativeLanguages"),
    CAMNCVS("CAMNCVS"),
    CSAID("CSAID"),
    CDCA("CDCA"),
    CDCM("CDCM"),
    CDS("CDS"),
    CVX("CVX"),
    MVX("MVX"),
    @XmlEnumValue("CD2")
    CD_2("CD2"),
    CE("CE"),
    CLP("CLP"),
    CST("CST"),
    @XmlEnumValue("C4")
    C_4("C4"),
    @XmlEnumValue("C5")
    C_5("C5"),
    @XmlEnumValue("Calendar")
    CALENDAR("Calendar"),
    @XmlEnumValue("CalendarCycle")
    CALENDAR_CYCLE("CalendarCycle"),
    @XmlEnumValue("CalendarType")
    CALENDAR_TYPE("CalendarType"),
    CCI("CCI"),
    @XmlEnumValue("ICD-10-CA")
    ICD_10_CA("ICD-10-CA"),
    @XmlEnumValue("Charset")
    CHARSET("Charset"),
    CAS("CAS"),
    @XmlEnumValue("CodeSystem")
    CODE_SYSTEM("CodeSystem"),
    @XmlEnumValue("CodingRationale")
    CODING_RATIONALE("CodingRationale"),
    @XmlEnumValue("CommunicationFunctionType")
    COMMUNICATION_FUNCTION_TYPE("CommunicationFunctionType"),
    @XmlEnumValue("CompressionAlgorithm")
    COMPRESSION_ALGORITHM("CompressionAlgorithm"),
    @XmlEnumValue("ConceptGenerality")
    CONCEPT_GENERALITY("ConceptGenerality"),
    @XmlEnumValue("Confidentiality")
    CONFIDENTIALITY("Confidentiality"),
    @XmlEnumValue("ContainerCap")
    CONTAINER_CAP("ContainerCap"),
    @XmlEnumValue("ContainerSeparator")
    CONTAINER_SEPARATOR("ContainerSeparator"),
    @XmlEnumValue("ContentProcessingMode")
    CONTENT_PROCESSING_MODE("ContentProcessingMode"),
    @XmlEnumValue("ContextControl")
    CONTEXT_CONTROL("ContextControl"),
    @XmlEnumValue("Currency")
    CURRENCY("Currency"),
    DCL("DCL"),
    DQL("DQL"),
    DCM("DCM"),
    @XmlEnumValue("DataType")
    DATA_TYPE("DataType"),
    @XmlEnumValue("Dentition")
    DENTITION("Dentition"),
    @XmlEnumValue("DeviceAlertLevel")
    DEVICE_ALERT_LEVEL("DeviceAlertLevel"),
    @XmlEnumValue("DocumentCompletion")
    DOCUMENT_COMPLETION("DocumentCompletion"),
    @XmlEnumValue("DocumentStorage")
    DOCUMENT_STORAGE("DocumentStorage"),
    @XmlEnumValue("EPSG-GeodeticParameterDataset")
    EPSG_GEODETIC_PARAMETER_DATASET("EPSG-GeodeticParameterDataset"),
    E("E"),
    @XmlEnumValue("EditStatus")
    EDIT_STATUS("EditStatus"),
    @XmlEnumValue("EducationLevel")
    EDUCATION_LEVEL("EducationLevel"),
    @XmlEnumValue("EmployeeJobClass")
    EMPLOYEE_JOB_CLASS("EmployeeJobClass"),
    @XmlEnumValue("EncounterAcuity")
    ENCOUNTER_ACUITY("EncounterAcuity"),
    @XmlEnumValue("EncounterAccident")
    ENCOUNTER_ACCIDENT("EncounterAccident"),
    @XmlEnumValue("EncounterAdmissionSource")
    ENCOUNTER_ADMISSION_SOURCE("EncounterAdmissionSource"),
    @XmlEnumValue("EncounterReferralSource")
    ENCOUNTER_REFERRAL_SOURCE("EncounterReferralSource"),
    @XmlEnumValue("EncounterSpecialCourtesy")
    ENCOUNTER_SPECIAL_COURTESY("EncounterSpecialCourtesy"),
    @XmlEnumValue("EntityClass")
    ENTITY_CLASS("EntityClass"),
    @XmlEnumValue("EntityCode")
    ENTITY_CODE("EntityCode"),
    @XmlEnumValue("EntityDeterminer")
    ENTITY_DETERMINER("EntityDeterminer"),
    @XmlEnumValue("EntityHandling")
    ENTITY_HANDLING("EntityHandling"),
    @XmlEnumValue("EntityNamePartQualifier")
    ENTITY_NAME_PART_QUALIFIER("EntityNamePartQualifier"),
    @XmlEnumValue("EntityNamePartType")
    ENTITY_NAME_PART_TYPE("EntityNamePartType"),
    @XmlEnumValue("EntityNameUse")
    ENTITY_NAME_USE("EntityNameUse"),
    @XmlEnumValue("EntityRisk")
    ENTITY_RISK("EntityRisk"),
    @XmlEnumValue("EntityStatus")
    ENTITY_STATUS("EntityStatus"),
    ENZC("ENZC"),
    @XmlEnumValue("EquipmentAlertLevel")
    EQUIPMENT_ALERT_LEVEL("EquipmentAlertLevel"),
    @XmlEnumValue("Ethnicity")
    ETHNICITY("Ethnicity"),
    @XmlEnumValue("E5")
    E_5("E5"),
    @XmlEnumValue("E7")
    E_7("E7"),
    @XmlEnumValue("E6")
    E_6("E6"),
    @XmlEnumValue("ExposureMode")
    EXPOSURE_MODE("ExposureMode"),
    FDK("FDK"),
    FDDX("FDDX"),
    FDDC("FDDC"),
    @XmlEnumValue("GTSAbbreviation")
    GTS_ABBREVIATION("GTSAbbreviation"),
    @XmlEnumValue("GenderStatus")
    GENDER_STATUS("GenderStatus"),
    HPC("HPC"),
    HB("HB"),
    @XmlEnumValue("CodeSystemType")
    CODE_SYSTEM_TYPE("CodeSystemType"),
    @XmlEnumValue("ConceptStatus")
    CONCEPT_STATUS("ConceptStatus"),
    @XmlEnumValue("HL7ITSVersionCode")
    HL_7_ITS_VERSION_CODE("HL7ITSVersionCode"),
    @XmlEnumValue("ConceptProperty")
    CONCEPT_PROPERTY("ConceptProperty"),
    @XmlEnumValue("HL7CommitteeIDInRIM")
    HL_7_COMMITTEE_ID_IN_RIM("HL7CommitteeIDInRIM"),
    @XmlEnumValue("HL7ConformanceInclusion")
    HL_7_CONFORMANCE_INCLUSION("HL7ConformanceInclusion"),
    @XmlEnumValue("HL7DefinedRoseProperty")
    HL_7_DEFINED_ROSE_PROPERTY("HL7DefinedRoseProperty"),
    @XmlEnumValue("HL7StandardVersionCode")
    HL_7_STANDARD_VERSION_CODE("HL7StandardVersionCode"),
    @XmlEnumValue("HL7UpdateMode")
    HL_7_UPDATE_MODE("HL7UpdateMode"),
    HI("HI"),
    @XmlEnumValue("HealthcareProviderTaxonomyHIPAA")
    HEALTHCARE_PROVIDER_TAXONOMY_HIPAA("HealthcareProviderTaxonomyHIPAA"),
    HHC("HHC"),
    @XmlEnumValue("HtmlLinkType")
    HTML_LINK_TYPE("HtmlLinkType"),
    ICS("ICS"),
    @XmlEnumValue("I10")
    I_10("I10"),
    @XmlEnumValue("I10P")
    I_10_P("I10P"),
    @XmlEnumValue("I9C")
    I_9_C("I9C"),
    @XmlEnumValue("I9")
    I_9("I9"),
    @XmlEnumValue("IC2")
    IC_2("IC2"),
    @XmlEnumValue("IETF1766")
    IETF_1766("IETF1766"),
    IBT("IBT"),
    MDC("MDC"),
    @XmlEnumValue("ISO3166-1")
    ISO_3166_1("ISO3166-1"),
    @XmlEnumValue("ISO3166-2")
    ISO_3166_2("ISO3166-2"),
    @XmlEnumValue("ISO3166-3")
    ISO_3166_3("ISO3166-3"),
    @XmlEnumValue("ISO4217")
    ISO_4217("ISO4217"),
    IUPC("IUPC"),
    IUPP("IUPP"),
    @XmlEnumValue("IntegrityCheckAlgorithm")
    INTEGRITY_CHECK_ALGORITHM("IntegrityCheckAlgorithm"),
    ICDO("ICDO"),
    ICSD("ICSD"),
    @XmlEnumValue("JC8")
    JC_8("JC8"),
    @XmlEnumValue("LanguageAbilityMode")
    LANGUAGE_ABILITY_MODE("LanguageAbilityMode"),
    @XmlEnumValue("LanguageAbilityProficiency")
    LANGUAGE_ABILITY_PROFICIENCY("LanguageAbilityProficiency"),
    @XmlEnumValue("LivingArrangement")
    LIVING_ARRANGEMENT("LivingArrangement"),
    @XmlEnumValue("LocalMarkupIgnore")
    LOCAL_MARKUP_IGNORE("LocalMarkupIgnore"),
    @XmlEnumValue("LocalRemoteControlState")
    LOCAL_REMOTE_CONTROL_STATE("LocalRemoteControlState"),
    LN("LN"),
    @XmlEnumValue("MDFAttributeType")
    MDF_ATTRIBUTE_TYPE("MDFAttributeType"),
    @XmlEnumValue("MDFSubjectAreaPrefix")
    MDF_SUBJECT_AREA_PREFIX("MDFSubjectAreaPrefix"),
    UMD("UMD"),
    MEDCIN("MEDCIN"),
    MIME("MIME"),
    @XmlEnumValue("ManagedParticipationStatus")
    MANAGED_PARTICIPATION_STATUS("ManagedParticipationStatus"),
    @XmlEnumValue("MapRelationship")
    MAP_RELATIONSHIP("MapRelationship"),
    @XmlEnumValue("MaritalStatus")
    MARITAL_STATUS("MaritalStatus"),
    @XmlEnumValue("MaterialType")
    MATERIAL_TYPE("MaterialType"),
    @XmlEnumValue("MdfHmdMetSourceType")
    MDF_HMD_MET_SOURCE_TYPE("MdfHmdMetSourceType"),
    @XmlEnumValue("MdfHmdRowType")
    MDF_HMD_ROW_TYPE("MdfHmdRowType"),
    @XmlEnumValue("MdfRmimRowType")
    MDF_RMIM_ROW_TYPE("MdfRmimRowType"),
    @XmlEnumValue("MediaType")
    MEDIA_TYPE("MediaType"),
    MEDR("MEDR"),
    MEDX("MEDX"),
    MEDC("MEDC"),
    MDDX("MDDX"),
    MGPI("MGPI"),
    @XmlEnumValue("MessageWaitingPriority")
    MESSAGE_WAITING_PRIORITY("MessageWaitingPriority"),
    @XmlEnumValue("MessageCondition")
    MESSAGE_CONDITION("MessageCondition"),
    @XmlEnumValue("ModifyIndicator")
    MODIFY_INDICATOR("ModifyIndicator"),
    MULTUM("MULTUM"),
    NAACCR("NAACCR"),
    NDA("NDA"),
    NOC("NOC"),
    @XmlEnumValue("NUCCProviderCodes")
    NUCC_PROVIDER_CODES("NUCCProviderCodes"),
    @XmlEnumValue("NUBC-UB92")
    NUBC_UB_92("NUBC-UB92"),
    NDC("NDC"),
    NAICS("NAICS"),
    @XmlEnumValue("NullFlavor")
    NULL_FLAVOR("NullFlavor"),
    NIC("NIC"),
    NMMDS("NMMDS"),
    @XmlEnumValue("ObservationInterpretation")
    OBSERVATION_INTERPRETATION("ObservationInterpretation"),
    @XmlEnumValue("ObservationMethod")
    OBSERVATION_METHOD("ObservationMethod"),
    @XmlEnumValue("ObservationValue")
    OBSERVATION_VALUE("ObservationValue"),
    OHA("OHA"),
    @XmlEnumValue("OrderableDrugForm")
    ORDERABLE_DRUG_FORM("OrderableDrugForm"),
    @XmlEnumValue("OrganizationNameType")
    ORGANIZATION_NAME_TYPE("OrganizationNameType"),
    POS("POS"),
    @XmlEnumValue("ParameterizedDataType")
    PARAMETERIZED_DATA_TYPE("ParameterizedDataType"),
    @XmlEnumValue("ParticipationFunction")
    PARTICIPATION_FUNCTION("ParticipationFunction"),
    @XmlEnumValue("ParticipationMode")
    PARTICIPATION_MODE("ParticipationMode"),
    @XmlEnumValue("ParticipationSignature")
    PARTICIPATION_SIGNATURE("ParticipationSignature"),
    @XmlEnumValue("ParticipationType")
    PARTICIPATION_TYPE("ParticipationType"),
    @XmlEnumValue("PatientImportance")
    PATIENT_IMPORTANCE("PatientImportance"),
    @XmlEnumValue("PaymentTerms")
    PAYMENT_TERMS("PaymentTerms"),
    @XmlEnumValue("PeriodicIntervalOfTimeAbbreviation")
    PERIODIC_INTERVAL_OF_TIME_ABBREVIATION("PeriodicIntervalOfTimeAbbreviation"),
    PNDS("PNDS"),
    @XmlEnumValue("PersonDisabilityType")
    PERSON_DISABILITY_TYPE("PersonDisabilityType"),
    @XmlEnumValue("ConceptCodeRelationship")
    CONCEPT_CODE_RELATIONSHIP("ConceptCodeRelationship"),
    @XmlEnumValue("PostalAddressUse")
    POSTAL_ADDRESS_USE("PostalAddressUse"),
    @XmlEnumValue("ProbabilityDistributionType")
    PROBABILITY_DISTRIBUTION_TYPE("ProbabilityDistributionType"),
    @XmlEnumValue("ProcedureMethod")
    PROCEDURE_METHOD("ProcedureMethod"),
    @XmlEnumValue("ProcessingID")
    PROCESSING_ID("ProcessingID"),
    @XmlEnumValue("ProcessingMode")
    PROCESSING_MODE("ProcessingMode"),
    @XmlEnumValue("QueryParameterValue")
    QUERY_PARAMETER_VALUE("QueryParameterValue"),
    @XmlEnumValue("QueryPriority")
    QUERY_PRIORITY("QueryPriority"),
    @XmlEnumValue("QueryQuantityUnit")
    QUERY_QUANTITY_UNIT("QueryQuantityUnit"),
    @XmlEnumValue("QueryRequestLimit")
    QUERY_REQUEST_LIMIT("QueryRequestLimit"),
    @XmlEnumValue("QueryResponse")
    QUERY_RESPONSE("QueryResponse"),
    @XmlEnumValue("QueryStatusCode")
    QUERY_STATUS_CODE("QueryStatusCode"),
    @XmlEnumValue("Race")
    RACE("Race"),
    RC("RC"),
    @XmlEnumValue("RelationalOperator")
    RELATIONAL_OPERATOR("RelationalOperator"),
    @XmlEnumValue("RelationshipConjunction")
    RELATIONSHIP_CONJUNCTION("RelationshipConjunction"),
    @XmlEnumValue("ReligiousAffiliation")
    RELIGIOUS_AFFILIATION("ReligiousAffiliation"),
    @XmlEnumValue("ResponseLevel")
    RESPONSE_LEVEL("ResponseLevel"),
    @XmlEnumValue("ResponseModality")
    RESPONSE_MODALITY("ResponseModality"),
    @XmlEnumValue("ResponseMode")
    RESPONSE_MODE("ResponseMode"),
    @XmlEnumValue("RoleClass")
    ROLE_CLASS("RoleClass"),
    @XmlEnumValue("RoleCode")
    ROLE_CODE("RoleCode"),
    @XmlEnumValue("RoleLinkType")
    ROLE_LINK_TYPE("RoleLinkType"),
    @XmlEnumValue("RoleStatus")
    ROLE_STATUS("RoleStatus"),
    @XmlEnumValue("RouteOfAdministration")
    ROUTE_OF_ADMINISTRATION("RouteOfAdministration"),
    @XmlEnumValue("SCDHEC-GISSpatialAccuracyTiers")
    SCDHEC_GIS_SPATIAL_ACCURACY_TIERS("SCDHEC-GISSpatialAccuracyTiers"),
    @XmlEnumValue("SNM3")
    SNM_3("SNM3"),
    SNT("SNT"),
    SDM("SDM"),
    @XmlEnumValue("Sequencing")
    SEQUENCING("Sequencing"),
    @XmlEnumValue("SetOperator")
    SET_OPERATOR("SetOperator"),
    @XmlEnumValue("SpecialArrangement")
    SPECIAL_ARRANGEMENT("SpecialArrangement"),
    @XmlEnumValue("SpecimenType")
    SPECIMEN_TYPE("SpecimenType"),
    @XmlEnumValue("StyleType")
    STYLE_TYPE("StyleType"),
    @XmlEnumValue("SubstanceAdminSubstitution")
    SUBSTANCE_ADMIN_SUBSTITUTION("SubstanceAdminSubstitution"),
    @XmlEnumValue("SubstitutionCondition")
    SUBSTITUTION_CONDITION("SubstitutionCondition"),
    SNM("SNM"),
    @XmlEnumValue("TableCellHorizontalAlign")
    TABLE_CELL_HORIZONTAL_ALIGN("TableCellHorizontalAlign"),
    @XmlEnumValue("TableCellScope")
    TABLE_CELL_SCOPE("TableCellScope"),
    @XmlEnumValue("TableCellVerticalAlign")
    TABLE_CELL_VERTICAL_ALIGN("TableCellVerticalAlign"),
    @XmlEnumValue("TableFrame")
    TABLE_FRAME("TableFrame"),
    @XmlEnumValue("TableRules")
    TABLE_RULES("TableRules"),
    @XmlEnumValue("IETF3066")
    IETF_3066("IETF3066"),
    @XmlEnumValue("TargetAwareness")
    TARGET_AWARENESS("TargetAwareness"),
    @XmlEnumValue("TelecommunicationAddressUse")
    TELECOMMUNICATION_ADDRESS_USE("TelecommunicationAddressUse"),
    RCFB("RCFB"),
    @XmlEnumValue("RCV2")
    RCV_2("RCV2"),
    @XmlEnumValue("TimingEvent")
    TIMING_EVENT("TimingEvent"),
    @XmlEnumValue("TransmissionRelationshipTypeCode")
    TRANSMISSION_RELATIONSHIP_TYPE_CODE("TransmissionRelationshipTypeCode"),
    @XmlEnumValue("TribalEntityUS")
    TRIBAL_ENTITY_US("TribalEntityUS"),
    UC("UC"),
    UCUM("UCUM"),
    @XmlEnumValue("URLScheme")
    URL_SCHEME("URLScheme"),
    UML("UML"),
    @XmlEnumValue("UnitsOfMeasure")
    UNITS_OF_MEASURE("UnitsOfMeasure"),
    UPC("UPC"),
    @XmlEnumValue("VaccineManufacturer")
    VACCINE_MANUFACTURER("VaccineManufacturer"),
    @XmlEnumValue("VaccineType")
    VACCINE_TYPE("VaccineType"),
    @XmlEnumValue("VocabularyDomainQualifier")
    VOCABULARY_DOMAIN_QUALIFIER("VocabularyDomainQualifier"),
    WC("WC"),
    ART("ART"),
    @XmlEnumValue("W4")
    W_4("W4"),
    @XmlEnumValue("W1-W2")
    W_1_W_2("W1-W2");
    private final String value;

    CodeSystem(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static CodeSystem fromValue(String v) {
        for (CodeSystem c: CodeSystem.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
