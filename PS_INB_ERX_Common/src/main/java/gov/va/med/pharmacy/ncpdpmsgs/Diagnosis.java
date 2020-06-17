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
 * <p>Java class for Diagnosis complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Diagnosis">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClinicalInformationQualifier" type="{}ClinicalInformationQualifier"/>
 *         &lt;element name="Primary" type="{}DiagnosisQualifiedCodeWithDescription"/>
 *         &lt;element name="Secondary" type="{}DiagnosisQualifiedCodeWithDescription" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Diagnosis", propOrder = {
    "clinicalInformationQualifier",
    "primary",
    "secondary"
})
@XmlSeeAlso({
    DiagnosisRestricted.class
})
public class Diagnosis {

    @XmlElement(name = "ClinicalInformationQualifier", required = true)
    protected String clinicalInformationQualifier;
    @XmlElement(name = "Primary", required = true)
    protected DiagnosisQualifiedCodeWithDescription primary;
    @XmlElement(name = "Secondary")
    protected DiagnosisQualifiedCodeWithDescription secondary;

    /**
     * Gets the value of the clinicalInformationQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClinicalInformationQualifier() {
        return clinicalInformationQualifier;
    }

    /**
     * Sets the value of the clinicalInformationQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClinicalInformationQualifier(String value) {
        this.clinicalInformationQualifier = value;
    }

    /**
     * Gets the value of the primary property.
     * 
     * @return
     *     possible object is
     *     {@link DiagnosisQualifiedCodeWithDescription }
     *     
     */
    public DiagnosisQualifiedCodeWithDescription getPrimary() {
        return primary;
    }

    /**
     * Sets the value of the primary property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagnosisQualifiedCodeWithDescription }
     *     
     */
    public void setPrimary(DiagnosisQualifiedCodeWithDescription value) {
        this.primary = value;
    }

    /**
     * Gets the value of the secondary property.
     * 
     * @return
     *     possible object is
     *     {@link DiagnosisQualifiedCodeWithDescription }
     *     
     */
    public DiagnosisQualifiedCodeWithDescription getSecondary() {
        return secondary;
    }

    /**
     * Sets the value of the secondary property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagnosisQualifiedCodeWithDescription }
     *     
     */
    public void setSecondary(DiagnosisQualifiedCodeWithDescription value) {
        this.secondary = value;
    }

}
