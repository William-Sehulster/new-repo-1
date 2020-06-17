//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.18 at 03:04:58 PM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Query transactions are used for the exchange of patient-centric clinical health information.
 * 
 * <p>Java class for ClinicalInfoRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClinicalInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{}SpecializedRequest">
 *       &lt;sequence>
 *         &lt;element name="MessageRequestCode" type="{}MessageFunctionCode" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="ReturnReceipt" type="{}an1..3" minOccurs="0"/>
 *         &lt;element name="RequestReferenceNumber" type="{}an1..35" minOccurs="0"/>
 *         &lt;element name="FollowUpRequest" type="{}n1..1" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="ClinicalInfoAttachment" type="{}Attachment" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="BenefitsCoordination" type="{}BaseBenefitsCoordination" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="DiagnosisGeneral" type="{}DiagnosisGeneral" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Facility" type="{}Facility" minOccurs="0"/>
 *         &lt;element name="Patient" type="{}PatientType"/>
 *         &lt;element name="Pharmacist" type="{}Pharmacist" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Pharmacy" type="{}MandatoryAddressPharmacy"/>
 *         &lt;element name="Prescriber" type="{}MandatoryPrescriberChoice"/>
 *         &lt;element name="Provider" type="{}Provider" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Service" type="{}GlobalServiceType" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="AnticipatedReturnDate" type="{}SimpleDateType" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="CensusEffectiveDate" type="{}SimpleDateType" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="TimeZone" type="{}TimeZone" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="DispensingRequestCode" type="{}DispensingRequestCode" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Consent" type="{}Consent"/>
 *         &lt;element name="ClinicalInfoTypesRequested" type="{}ClinicalInfoTypesRequested" maxOccurs="unbounded"/>
 *         &lt;element name="ClinicalInfoFormatsSupported" type="{}ClinicalInformationFormatSupported"/>
 *         &lt;element name="Note" type="{}an1..210" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClinicalInfoRequest")
public class ClinicalInfoRequest
    extends SpecializedRequest
{


}
