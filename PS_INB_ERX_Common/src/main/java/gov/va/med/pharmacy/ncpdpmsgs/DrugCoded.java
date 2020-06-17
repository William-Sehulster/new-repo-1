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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Coded Drug Structure used in Medication
 * 
 * <p>Java class for DrugCoded complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrugCoded">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductCode" type="{}ProductCode" minOccurs="0"/>
 *         &lt;element name="Strength" type="{}Strength" minOccurs="0"/>
 *         &lt;element name="DrugDBCode" type="{}DrugDBCode" minOccurs="0"/>
 *         &lt;element name="DEASchedule" type="{}NCICode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DrugCoded", propOrder = {
    "productCode",
    "strength",
    "drugDBCode",
    "deaSchedule"
})
@XmlSeeAlso({
    CFDrugCoded.class
})
public class DrugCoded {

    @XmlElement(name = "ProductCode")
    protected ProductCode productCode;
    @XmlElement(name = "Strength")
    protected Strength strength;
    @XmlElement(name = "DrugDBCode")
    protected DrugDBCode drugDBCode;
    @XmlElement(name = "DEASchedule")
    protected NCICode deaSchedule;

    /**
     * Gets the value of the productCode property.
     * 
     * @return
     *     possible object is
     *     {@link ProductCode }
     *     
     */
    public ProductCode getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductCode }
     *     
     */
    public void setProductCode(ProductCode value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the strength property.
     * 
     * @return
     *     possible object is
     *     {@link Strength }
     *     
     */
    public Strength getStrength() {
        return strength;
    }

    /**
     * Sets the value of the strength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Strength }
     *     
     */
    public void setStrength(Strength value) {
        this.strength = value;
    }

    /**
     * Gets the value of the drugDBCode property.
     * 
     * @return
     *     possible object is
     *     {@link DrugDBCode }
     *     
     */
    public DrugDBCode getDrugDBCode() {
        return drugDBCode;
    }

    /**
     * Sets the value of the drugDBCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DrugDBCode }
     *     
     */
    public void setDrugDBCode(DrugDBCode value) {
        this.drugDBCode = value;
    }

    /**
     * Gets the value of the deaSchedule property.
     * 
     * @return
     *     possible object is
     *     {@link NCICode }
     *     
     */
    public NCICode getDEASchedule() {
        return deaSchedule;
    }

    /**
     * Sets the value of the deaSchedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link NCICode }
     *     
     */
    public void setDEASchedule(NCICode value) {
        this.deaSchedule = value;
    }

}
