//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.18 at 03:04:58 PM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PAResponseChoiceTypeRestricted complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PAResponseChoiceTypeRestricted">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Open" type="{}PAOpenType"/>
 *         &lt;element name="Closed" type="{}PAReasonCodeType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PAResponseChoiceTypeRestricted", propOrder = {
    "open",
    "closed"
})
public class PAResponseChoiceTypeRestricted {

    @XmlElement(name = "Open")
    protected PAOpenType open;
    @XmlElement(name = "Closed")
    protected PAReasonCodeType closed;

    /**
     * Gets the value of the open property.
     * 
     * @return
     *     possible object is
     *     {@link PAOpenType }
     *     
     */
    public PAOpenType getOpen() {
        return open;
    }

    /**
     * Sets the value of the open property.
     * 
     * @param value
     *     allowed object is
     *     {@link PAOpenType }
     *     
     */
    public void setOpen(PAOpenType value) {
        this.open = value;
    }

    /**
     * Gets the value of the closed property.
     * 
     * @return
     *     possible object is
     *     {@link PAReasonCodeType }
     *     
     */
    public PAReasonCodeType getClosed() {
        return closed;
    }

    /**
     * Sets the value of the closed property.
     * 
     * @param value
     *     allowed object is
     *     {@link PAReasonCodeType }
     *     
     */
    public void setClosed(PAReasonCodeType value) {
        this.closed = value;
    }

}
