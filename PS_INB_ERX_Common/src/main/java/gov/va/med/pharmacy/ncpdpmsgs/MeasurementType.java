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
 * <p>Java class for MeasurementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeasurementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Dimension"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="HT|WG|ZZS|ZZD"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Value" type="{http://www.ncpdp.org/schema/SCRIPT}n..18M"/&gt;
 *         &lt;element name="ObservationDate" type="{http://www.ncpdp.org/schema/SCRIPT}DateType" minOccurs="0"/&gt;
 *         &lt;element name="MeasurementDataQualifier" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="1|2|3|4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MeasurementSourceCode" type="{http://www.ncpdp.org/schema/SCRIPT}SourceCodeList" minOccurs="0"/&gt;
 *         &lt;element name="MeasurementUnitCode" type="{http://www.ncpdp.org/schema/SCRIPT}an..15"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasurementType", propOrder = {
    "dimension",
    "value",
    "observationDate",
    "measurementDataQualifier",
    "measurementSourceCode",
    "measurementUnitCode"
})
public class MeasurementType {

    @XmlElement(name = "Dimension", required = true)
    protected String dimension;
    @XmlElement(name = "Value", required = true)
    protected String value;
    @XmlElement(name = "ObservationDate")
    protected DateType observationDate;
    @XmlElement(name = "MeasurementDataQualifier")
    protected String measurementDataQualifier;
    @XmlElement(name = "MeasurementSourceCode")
    protected String measurementSourceCode;
    @XmlElement(name = "MeasurementUnitCode", required = true)
    protected String measurementUnitCode;

    /**
     * Gets the value of the dimension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * Sets the value of the dimension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimension(String value) {
        this.dimension = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the observationDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getObservationDate() {
        return observationDate;
    }

    /**
     * Sets the value of the observationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setObservationDate(DateType value) {
        this.observationDate = value;
    }

    /**
     * Gets the value of the measurementDataQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasurementDataQualifier() {
        return measurementDataQualifier;
    }

    /**
     * Sets the value of the measurementDataQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasurementDataQualifier(String value) {
        this.measurementDataQualifier = value;
    }

    /**
     * Gets the value of the measurementSourceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasurementSourceCode() {
        return measurementSourceCode;
    }

    /**
     * Sets the value of the measurementSourceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasurementSourceCode(String value) {
        this.measurementSourceCode = value;
    }

    /**
     * Gets the value of the measurementUnitCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasurementUnitCode() {
        return measurementUnitCode;
    }

    /**
     * Sets the value of the measurementUnitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasurementUnitCode(String value) {
        this.measurementUnitCode = value;
    }

}
