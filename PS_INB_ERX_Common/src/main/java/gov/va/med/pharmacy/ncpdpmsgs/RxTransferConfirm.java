//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.18 at 03:04:58 PM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * This transaction is used by the pharmacy receiving (originally requesting) the transfer to confirm that the transferred prescription has been received and the transfer is complete.
 * 
 * <p>Java class for RxTransferConfirm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RxTransferConfirm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageRequestCode" type="{}LTCLevelOfChangeCode" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="ReturnReceipt" type="{}an1..3" minOccurs="0"/>
 *         &lt;element name="RequestReferenceNumber" type="{}an1..35" minOccurs="0"/>
 *         &lt;element name="FollowUpRequest" type="{}n1..1" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="ChangeOfPrescriptionStatusFlag" type="{}ChangeOfPrescriptionStatusCode" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="BenefitsCoordination" type="{}BenefitsCoordinationRestricted" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="DiagnosisGeneral" type="{}DiagnosisGeneral" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Facility" type="{}Facility" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="FillStatus" type="{}FillStatus" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Patient" type="{}PatientMandatoryAddressType"/>
 *         &lt;element name="Pharmacy" type="{}PharmacyTransfer" maxOccurs="2" minOccurs="2"/>
 *         &lt;element name="Prescriber" type="{}MandatoryPrescriberChoice" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="DispensingRequestCode" type="{}DispensingRequestCode" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="DrugAdministrationRequest" type="{}DrugAdministrationRequest" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Observation" type="{}Observation" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="MedicationDispensed" type="{}PrescribedMedication" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="MedicationPrescribed" type="{}NewRxPrescribedMedication" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="MedicationRequested" type="{}PrescribedMedication" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="RequestedDates" type="{}DateRange" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="ProhibitRenewalRequest" type="{http://www.w3.org/2001/XMLSchema}boolean" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="ChangeReasonText" type="{}an1..260" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Pharmacist" type="{}Pharmacist"/>
 *         &lt;element name="RxFillConfirmIndicator" type="{}BooleanCode"/>
 *         &lt;element name="TransferRequest" type="{}TransferRequest"/>
 *         &lt;element name="FollowUpPrescriber" type="{}FollowUpPrescriberType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RxTransferConfirm", propOrder = {
    "returnReceipt",
    "requestReferenceNumber",
    "patient",
    "pharmacy",
    "pharmacist",
    "rxFillConfirmIndicator",
    "transferRequest",
    "followUpPrescriber"
})
public class RxTransferConfirm {

    @XmlElement(name = "ReturnReceipt")
    protected String returnReceipt;
    @XmlElement(name = "RequestReferenceNumber")
    protected String requestReferenceNumber;
    @XmlElement(name = "Patient", required = true)
    protected PatientMandatoryAddressType patient;
    @XmlElement(name = "Pharmacy", required = true)
    protected List<PharmacyTransfer> pharmacy;
    @XmlElement(name = "Pharmacist", required = true)
    protected Pharmacist pharmacist;
    @XmlElement(name = "RxFillConfirmIndicator", required = true)
    @XmlSchemaType(name = "string")
    protected BooleanCode rxFillConfirmIndicator;
    @XmlElement(name = "TransferRequest", required = true)
    @XmlSchemaType(name = "string")
    protected TransferRequest transferRequest;
    @XmlElement(name = "FollowUpPrescriber")
    protected FollowUpPrescriberType followUpPrescriber;

    /**
     * Gets the value of the returnReceipt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnReceipt() {
        return returnReceipt;
    }

    /**
     * Sets the value of the returnReceipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnReceipt(String value) {
        this.returnReceipt = value;
    }

    /**
     * Gets the value of the requestReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestReferenceNumber() {
        return requestReferenceNumber;
    }

    /**
     * Sets the value of the requestReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestReferenceNumber(String value) {
        this.requestReferenceNumber = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link PatientMandatoryAddressType }
     *     
     */
    public PatientMandatoryAddressType getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientMandatoryAddressType }
     *     
     */
    public void setPatient(PatientMandatoryAddressType value) {
        this.patient = value;
    }

    /**
     * Gets the value of the pharmacy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pharmacy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPharmacy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PharmacyTransfer }
     * 
     * 
     */
    public List<PharmacyTransfer> getPharmacy() {
        if (pharmacy == null) {
            pharmacy = new ArrayList<PharmacyTransfer>();
        }
        return this.pharmacy;
    }

    /**
     * Gets the value of the pharmacist property.
     * 
     * @return
     *     possible object is
     *     {@link Pharmacist }
     *     
     */
    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    /**
     * Sets the value of the pharmacist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pharmacist }
     *     
     */
    public void setPharmacist(Pharmacist value) {
        this.pharmacist = value;
    }

    /**
     * Gets the value of the rxFillConfirmIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanCode }
     *     
     */
    public BooleanCode getRxFillConfirmIndicator() {
        return rxFillConfirmIndicator;
    }

    /**
     * Sets the value of the rxFillConfirmIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanCode }
     *     
     */
    public void setRxFillConfirmIndicator(BooleanCode value) {
        this.rxFillConfirmIndicator = value;
    }

    /**
     * Gets the value of the transferRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TransferRequest }
     *     
     */
    public TransferRequest getTransferRequest() {
        return transferRequest;
    }

    /**
     * Sets the value of the transferRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransferRequest }
     *     
     */
    public void setTransferRequest(TransferRequest value) {
        this.transferRequest = value;
    }

    /**
     * Gets the value of the followUpPrescriber property.
     * 
     * @return
     *     possible object is
     *     {@link FollowUpPrescriberType }
     *     
     */
    public FollowUpPrescriberType getFollowUpPrescriber() {
        return followUpPrescriber;
    }

    /**
     * Sets the value of the followUpPrescriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link FollowUpPrescriberType }
     *     
     */
    public void setFollowUpPrescriber(FollowUpPrescriberType value) {
        this.followUpPrescriber = value;
    }

}
