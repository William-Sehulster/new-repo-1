//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.18 at 02:27:26 AM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Request" type="{http://www.ncpdp.org/schema/SCRIPT}ShortRequestType" minOccurs="0"/&gt;
 *         &lt;element name="Pharmacy" type="{http://www.ncpdp.org/schema/SCRIPT}MandatoryAddressPharmacyType"/&gt;
 *         &lt;element name="Prescriber" type="{http://www.ncpdp.org/schema/SCRIPT}PrescriberTypeRefillRequest"/&gt;
 *         &lt;element name="Supervisor" type="{http://www.ncpdp.org/schema/SCRIPT}SupervisorTypeRefillRequest" minOccurs="0"/&gt;
 *         &lt;element name="Facility" type="{http://www.ncpdp.org/schema/SCRIPT}MandatoryFaciltyType" minOccurs="0"/&gt;
 *         &lt;element name="Patient" type="{http://www.ncpdp.org/schema/SCRIPT}PatientType"/&gt;
 *         &lt;element name="MedicationPrescribed" type="{http://www.ncpdp.org/schema/SCRIPT}ResupplyMedicationType"/&gt;
 *         &lt;element name="MedicationDispensed" type="{http://www.ncpdp.org/schema/SCRIPT}ResupplyMedicationType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.ncpdp.org/schema/SCRIPT}Observation" minOccurs="0"/&gt;
 *         &lt;element name="BenefitsCoordination" type="{http://www.ncpdp.org/schema/SCRIPT}BenefitsCoordinationType" maxOccurs="3" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "request",
    "pharmacy",
    "prescriber",
    "supervisor",
    "facility",
    "patient",
    "medicationPrescribed",
    "medicationDispensed",
    "observation",
    "benefitsCoordination"
})
@XmlRootElement(name = "Resupply")
public class Resupply {

    @XmlElement(name = "Request")
    protected ShortRequestType request;
    @XmlElement(name = "Pharmacy", required = true)
    protected MandatoryAddressPharmacyType pharmacy;
    @XmlElement(name = "Prescriber", required = true)
    protected PrescriberTypeRefillRequest prescriber;
    @XmlElement(name = "Supervisor")
    protected SupervisorTypeRefillRequest supervisor;
    @XmlElement(name = "Facility")
    protected MandatoryFaciltyType facility;
    @XmlElement(name = "Patient", required = true)
    protected PatientType patient;
    @XmlElement(name = "MedicationPrescribed", required = true)
    protected ResupplyMedicationType medicationPrescribed;
    @XmlElement(name = "MedicationDispensed")
    protected ResupplyMedicationType medicationDispensed;
    @XmlElement(name = "Observation")
    protected ObservationType observation;
    @XmlElement(name = "BenefitsCoordination")
    protected List<BenefitsCoordinationType> benefitsCoordination;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link ShortRequestType }
     *     
     */
    public ShortRequestType getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortRequestType }
     *     
     */
    public void setRequest(ShortRequestType value) {
        this.request = value;
    }

    /**
     * Gets the value of the pharmacy property.
     * 
     * @return
     *     possible object is
     *     {@link MandatoryAddressPharmacyType }
     *     
     */
    public MandatoryAddressPharmacyType getPharmacy() {
        return pharmacy;
    }

    /**
     * Sets the value of the pharmacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandatoryAddressPharmacyType }
     *     
     */
    public void setPharmacy(MandatoryAddressPharmacyType value) {
        this.pharmacy = value;
    }

    /**
     * Gets the value of the prescriber property.
     * 
     * @return
     *     possible object is
     *     {@link PrescriberTypeRefillRequest }
     *     
     */
    public PrescriberTypeRefillRequest getPrescriber() {
        return prescriber;
    }

    /**
     * Sets the value of the prescriber property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrescriberTypeRefillRequest }
     *     
     */
    public void setPrescriber(PrescriberTypeRefillRequest value) {
        this.prescriber = value;
    }

    /**
     * Gets the value of the supervisor property.
     * 
     * @return
     *     possible object is
     *     {@link SupervisorTypeRefillRequest }
     *     
     */
    public SupervisorTypeRefillRequest getSupervisor() {
        return supervisor;
    }

    /**
     * Sets the value of the supervisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupervisorTypeRefillRequest }
     *     
     */
    public void setSupervisor(SupervisorTypeRefillRequest value) {
        this.supervisor = value;
    }

    /**
     * Gets the value of the facility property.
     * 
     * @return
     *     possible object is
     *     {@link MandatoryFaciltyType }
     *     
     */
    public MandatoryFaciltyType getFacility() {
        return facility;
    }

    /**
     * Sets the value of the facility property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandatoryFaciltyType }
     *     
     */
    public void setFacility(MandatoryFaciltyType value) {
        this.facility = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link PatientType }
     *     
     */
    public PatientType getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientType }
     *     
     */
    public void setPatient(PatientType value) {
        this.patient = value;
    }

    /**
     * Gets the value of the medicationPrescribed property.
     * 
     * @return
     *     possible object is
     *     {@link ResupplyMedicationType }
     *     
     */
    public ResupplyMedicationType getMedicationPrescribed() {
        return medicationPrescribed;
    }

    /**
     * Sets the value of the medicationPrescribed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResupplyMedicationType }
     *     
     */
    public void setMedicationPrescribed(ResupplyMedicationType value) {
        this.medicationPrescribed = value;
    }

    /**
     * Gets the value of the medicationDispensed property.
     * 
     * @return
     *     possible object is
     *     {@link ResupplyMedicationType }
     *     
     */
    public ResupplyMedicationType getMedicationDispensed() {
        return medicationDispensed;
    }

    /**
     * Sets the value of the medicationDispensed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResupplyMedicationType }
     *     
     */
    public void setMedicationDispensed(ResupplyMedicationType value) {
        this.medicationDispensed = value;
    }

    /**
     * Gets the value of the observation property.
     * 
     * @return
     *     possible object is
     *     {@link ObservationType }
     *     
     */
    public ObservationType getObservation() {
        return observation;
    }

    /**
     * Sets the value of the observation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObservationType }
     *     
     */
    public void setObservation(ObservationType value) {
        this.observation = value;
    }

    /**
     * Gets the value of the benefitsCoordination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the benefitsCoordination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBenefitsCoordination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BenefitsCoordinationType }
     * 
     * 
     */
    public List<BenefitsCoordinationType> getBenefitsCoordination() {
        if (benefitsCoordination == null) {
            benefitsCoordination = new ArrayList<BenefitsCoordinationType>();
        }
        return this.benefitsCoordination;
    }

}
