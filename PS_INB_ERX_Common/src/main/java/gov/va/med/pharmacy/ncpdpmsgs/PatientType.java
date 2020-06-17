//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.18 at 02:27:26 AM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Updated the order of the tags within the NCPDP 10-15-2012 distributed schema
 * 
 * <p>Java class for PatientType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.ncpdp.org/schema/SCRIPT}PatientRelationship" minOccurs="0"/&gt;
 *         &lt;element name="Identification" type="{http://www.ncpdp.org/schema/SCRIPT}PatientIDType" minOccurs="0"/&gt;
 *         &lt;element name="Name" type="{http://www.ncpdp.org/schema/SCRIPT}MandatoryPatientNameType"/&gt;
 *         &lt;element ref="{http://www.ncpdp.org/schema/SCRIPT}Gender"/&gt;
 *         &lt;element ref="{http://www.ncpdp.org/schema/SCRIPT}DateOfBirth"/&gt;
 *         &lt;element ref="{http://www.ncpdp.org/schema/SCRIPT}Address" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.ncpdp.org/schema/SCRIPT}CommunicationNumbers" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.ncpdp.org/schema/SCRIPT}PatientLocation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientType", propOrder = {
    "patientRelationship",
    "identification",
    "name",
    "gender",
    "dateOfBirth",
    "address",
    "communicationNumbers",
    "patientLocation"
})
public class PatientType {

    @XmlElement(name = "PatientRelationship")
    protected String patientRelationship;
    @XmlElement(name = "Identification")
    protected PatientIDType identification;
    @XmlElement(name = "Name", required = true)
    protected MandatoryPatientNameType name;
    @XmlElement(name = "Gender", required = true)
    protected String gender;
    @XmlElement(name = "DateOfBirth", required = true)
    protected DateType dateOfBirth;
    @XmlElement(name = "Address")
    protected AddressType address;
    @XmlElement(name = "CommunicationNumbers")
    protected CommunicationNumbersType communicationNumbers;
    @XmlElement(name = "PatientLocation")
    protected PatientLocation patientLocation;

    /**
     * Gets the value of the patientRelationship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientRelationship() {
        return patientRelationship;
    }

    /**
     * Sets the value of the patientRelationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientRelationship(String value) {
        this.patientRelationship = value;
    }

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link PatientIDType }
     *     
     */
    public PatientIDType getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientIDType }
     *     
     */
    public void setIdentification(PatientIDType value) {
        this.identification = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link MandatoryPatientNameType }
     *     
     */
    public MandatoryPatientNameType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandatoryPatientNameType }
     *     
     */
    public void setName(MandatoryPatientNameType value) {
        this.name = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Variance: 10.6 it is optional. 10.8 it is mandatory
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDateOfBirth(DateType value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the communicationNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationNumbersType }
     *     
     */
    public CommunicationNumbersType getCommunicationNumbers() {
        return communicationNumbers;
    }

    /**
     * Sets the value of the communicationNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationNumbersType }
     *     
     */
    public void setCommunicationNumbers(CommunicationNumbersType value) {
        this.communicationNumbers = value;
    }

    /**
     * Gets the value of the patientLocation property.
     * 
     * @return
     *     possible object is
     *     {@link PatientLocation }
     *     
     */
    public PatientLocation getPatientLocation() {
        return patientLocation;
    }

    /**
     * Sets the value of the patientLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientLocation }
     *     
     */
    public void setPatientLocation(PatientLocation value) {
        this.patientLocation = value;
    }

}
