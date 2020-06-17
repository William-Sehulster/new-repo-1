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
 * <p>Java class for SecurityIdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityIdentificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SecondaryIdentification" type="{http://www.ncpdp.org/schema/SCRIPT}an..35" minOccurs="0"/&gt;
 *         &lt;element name="TertiaryIdentification" type="{http://www.ncpdp.org/schema/SCRIPT}an..35" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityIdentificationType", propOrder = {
    "secondaryIdentification",
    "tertiaryIdentification"
})
public class SecurityIdentificationType {

    @XmlElement(name = "SecondaryIdentification")
    protected String secondaryIdentification;
    @XmlElement(name = "TertiaryIdentification")
    protected String tertiaryIdentification;

    /**
     * Gets the value of the secondaryIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryIdentification() {
        return secondaryIdentification;
    }

    /**
     * Sets the value of the secondaryIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryIdentification(String value) {
        this.secondaryIdentification = value;
    }

    /**
     * Gets the value of the tertiaryIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTertiaryIdentification() {
        return tertiaryIdentification;
    }

    /**
     * Sets the value of the tertiaryIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTertiaryIdentification(String value) {
        this.tertiaryIdentification = value;
    }

}
