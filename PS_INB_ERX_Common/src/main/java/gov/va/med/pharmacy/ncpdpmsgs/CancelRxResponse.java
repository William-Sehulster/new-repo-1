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
 * This transaction is used to notify the pharmacy that a previously sent prescription should be canceled and not filled.  
 * 
 * <p>Java class for CancelRxResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelRxResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{}SCRIPTResponse">
 *       &lt;sequence>
 *         &lt;element name="MessageRequestCode" type="{}LTCLevelOfChangeCode" minOccurs="0"/>
 *         &lt;element name="ReturnReceipt" type="{}an1..3" minOccurs="0"/>
 *         &lt;element name="RequestReferenceNumber" type="{}an1..35" minOccurs="0"/>
 *         &lt;element name="UrgencyIndicatorCode" type="{}UrgencyIndicatorCode" minOccurs="0"/>
 *         &lt;element name="ChangeOfPrescriptionStatusFlag" type="{}ChangeOfPrescriptionStatusCode" minOccurs="0"/>
 *         &lt;element name="Response" type="{}CancellRxResponseType"/>
 *         &lt;element name="BenefitsCoordination" type="{}BaseBenefitsCoordination" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Facility" type="{}Facility" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Patient" type="{}PatientFullType" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Pharmacy" type="{}Pharmacy" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Prescriber" type="{}PrescriberGeneralChoice" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Observation" type="{}Observation" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Supervisor" type="{}SupervisorType" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="MedicationDispensed" type="{}Medication" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="MedicationDispensedAdministered" type="{}Medication" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="MedicationPrescribed" type="{}Medication" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="MedicationResponse" type="{}RefillResponseReplacedMedication" maxOccurs="0" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelRxResponse")
public class CancelRxResponse
    extends SCRIPTResponse
{


}
