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
 * Used exclusively for SIG
 * 
 * <p>Java class for RouteOfAdministrationCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RouteOfAdministrationCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RouteOfAdministrationText" type="{}an1..50" minOccurs="0"/>
 *         &lt;element name="RouteOfAdministrationCode" type="{}an1..15" minOccurs="0"/>
 *         &lt;element name="RouteOfAdministrationCodeQualifier" type="{}TerminologyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteOfAdministrationCode", propOrder = {
    "routeOfAdministrationText",
    "routeOfAdministrationCode",
    "routeOfAdministrationCodeQualifier"
})
public class RouteOfAdministrationCode {

    @XmlElement(name = "RouteOfAdministrationText")
    protected String routeOfAdministrationText;
    @XmlElement(name = "RouteOfAdministrationCode")
    protected String routeOfAdministrationCode;
    @XmlElement(name = "RouteOfAdministrationCodeQualifier", required = true)
    protected String routeOfAdministrationCodeQualifier;

    /**
     * Gets the value of the routeOfAdministrationText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteOfAdministrationText() {
        return routeOfAdministrationText;
    }

    /**
     * Sets the value of the routeOfAdministrationText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteOfAdministrationText(String value) {
        this.routeOfAdministrationText = value;
    }

    /**
     * Gets the value of the routeOfAdministrationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteOfAdministrationCode() {
        return routeOfAdministrationCode;
    }

    /**
     * Sets the value of the routeOfAdministrationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteOfAdministrationCode(String value) {
        this.routeOfAdministrationCode = value;
    }

    /**
     * Gets the value of the routeOfAdministrationCodeQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteOfAdministrationCodeQualifier() {
        return routeOfAdministrationCodeQualifier;
    }

    /**
     * Sets the value of the routeOfAdministrationCodeQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteOfAdministrationCodeQualifier(String value) {
        this.routeOfAdministrationCodeQualifier = value;
    }

}
