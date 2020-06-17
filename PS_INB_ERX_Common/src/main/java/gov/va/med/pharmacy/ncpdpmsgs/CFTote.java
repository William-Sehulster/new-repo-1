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
 * <p>Java class for CFTote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFTote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShipToteIdentification" type="{}an"/>
 *         &lt;element name="ToteBarcode" type="{}an" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFTote", propOrder = {
    "shipToteIdentification",
    "toteBarcode"
})
public class CFTote {

    @XmlElement(name = "ShipToteIdentification", required = true)
    protected String shipToteIdentification;
    @XmlElement(name = "ToteBarcode")
    protected String toteBarcode;

    /**
     * Gets the value of the shipToteIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipToteIdentification() {
        return shipToteIdentification;
    }

    /**
     * Sets the value of the shipToteIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipToteIdentification(String value) {
        this.shipToteIdentification = value;
    }

    /**
     * Gets the value of the toteBarcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToteBarcode() {
        return toteBarcode;
    }

    /**
     * Sets the value of the toteBarcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToteBarcode(String value) {
        this.toteBarcode = value;
    }

}
