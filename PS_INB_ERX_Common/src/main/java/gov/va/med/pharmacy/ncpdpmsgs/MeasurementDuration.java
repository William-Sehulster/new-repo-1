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
 * <p>Java class for MeasurementDuration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeasurementDuration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeasurementDurationNumericValue" type="{}n"/>
 *         &lt;element name="MeasurementDurationText" type="{}SigCode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasurementDuration", propOrder = {
    "measurementDurationNumericValue",
    "measurementDurationText"
})
public class MeasurementDuration {

    @XmlElement(name = "MeasurementDurationNumericValue", required = true)
    protected String measurementDurationNumericValue;
    @XmlElement(name = "MeasurementDurationText", required = true)
    protected SigCode measurementDurationText;

    /**
     * Gets the value of the measurementDurationNumericValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasurementDurationNumericValue() {
        return measurementDurationNumericValue;
    }

    /**
     * Sets the value of the measurementDurationNumericValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasurementDurationNumericValue(String value) {
        this.measurementDurationNumericValue = value;
    }

    /**
     * Gets the value of the measurementDurationText property.
     * 
     * @return
     *     possible object is
     *     {@link SigCode }
     *     
     */
    public SigCode getMeasurementDurationText() {
        return measurementDurationText;
    }

    /**
     * Sets the value of the measurementDurationText property.
     * 
     * @param value
     *     allowed object is
     *     {@link SigCode }
     *     
     */
    public void setMeasurementDurationText(SigCode value) {
        this.measurementDurationText = value;
    }

}
