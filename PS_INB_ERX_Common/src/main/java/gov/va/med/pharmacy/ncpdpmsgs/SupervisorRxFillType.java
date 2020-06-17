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
 * Used in RXFILL, CENSUS
 * 
 * <p>Java class for SupervisorRxFillType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupervisorRxFillType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Identification" type="{http://www.ncpdp.org/schema/SCRIPT}OptionalProviderIDType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.ncpdp.org/schema/SCRIPT}Specialty" minOccurs="0"/&gt;
 *         &lt;element name="Name" type="{http://www.ncpdp.org/schema/SCRIPT}MandatoryNameType"/&gt;
 *         &lt;element name="ClinicName" type="{http://www.ncpdp.org/schema/SCRIPT}an..35" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{http://www.ncpdp.org/schema/SCRIPT}AddressType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.ncpdp.org/schema/SCRIPT}CommunicationNumbers"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupervisorRxFillType", propOrder = {
    "identification",
    "specialty",
    "name",
    "clinicName",
    "address",
    "communicationNumbers"
})
public class SupervisorRxFillType {

    @XmlElement(name = "Identification")
    protected OptionalProviderIDType identification;
    @XmlElement(name = "Specialty")
    protected String specialty;
    @XmlElement(name = "Name", required = true)
    protected MandatoryNameType name;
    @XmlElement(name = "ClinicName")
    protected String clinicName;
    @XmlElement(name = "Address")
    protected AddressType address;
    @XmlElement(name = "CommunicationNumbers", required = true)
    protected CommunicationNumbersType communicationNumbers;

    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link OptionalProviderIDType }
     *     
     */
    public OptionalProviderIDType getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionalProviderIDType }
     *     
     */
    public void setIdentification(OptionalProviderIDType value) {
        this.identification = value;
    }

    /**
     * Gets the value of the specialty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Sets the value of the specialty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialty(String value) {
        this.specialty = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link MandatoryNameType }
     *     
     */
    public MandatoryNameType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandatoryNameType }
     *     
     */
    public void setName(MandatoryNameType value) {
        this.name = value;
    }

    /**
     * Gets the value of the clinicName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicName() {
        return clinicName;
    }

    /**
     * Sets the value of the clinicName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicName(String value) {
        this.clinicName = value;
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

}
