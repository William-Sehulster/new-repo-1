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
 * <p>Java class for HistoryResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HistoryResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="Approved" type="{http://www.ncpdp.org/schema/SCRIPT}ApprovedType"/&gt;
 *         &lt;element name="Denied" type="{http://www.ncpdp.org/schema/SCRIPT}DeniedType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistoryResponseType", propOrder = {
    "approved",
    "denied"
})
public class HistoryResponseType {

    @XmlElement(name = "Approved")
    protected ApprovedType approved;
    @XmlElement(name = "Denied")
    protected DeniedType denied;

    /**
     * Gets the value of the approved property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovedType }
     *     
     */
    public ApprovedType getApproved() {
        return approved;
    }

    /**
     * Sets the value of the approved property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovedType }
     *     
     */
    public void setApproved(ApprovedType value) {
        this.approved = value;
    }

    /**
     * Gets the value of the denied property.
     * 
     * @return
     *     possible object is
     *     {@link DeniedType }
     *     
     */
    public DeniedType getDenied() {
        return denied;
    }

    /**
     * Sets the value of the denied property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeniedType }
     *     
     */
    public void setDenied(DeniedType value) {
        this.denied = value;
    }

}
