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
 * <p>Java class for HistorySourceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HistorySourceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Source" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SourceQualifier"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;pattern value="PC|P2|PY"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="SourceDescription" type="{http://www.ncpdp.org/schema/SCRIPT}an..35" minOccurs="0"/&gt;
 *                   &lt;element name="Reference" type="{http://www.ncpdp.org/schema/SCRIPT}IDOptionalType" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SourceReference" type="{http://www.ncpdp.org/schema/SCRIPT}an..35" minOccurs="0"/&gt;
 *         &lt;element name="FillNumber" type="{http://www.ncpdp.org/schema/SCRIPT}n..2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistorySourceType", propOrder = {
    "source",
    "sourceReference",
    "fillNumber"
})
public class HistorySourceType {

    @XmlElement(name = "Source")
    protected HistorySourceType.Source source;
    @XmlElement(name = "SourceReference")
    protected String sourceReference;
    @XmlElement(name = "FillNumber")
    protected String fillNumber;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link HistorySourceType.Source }
     *     
     */
    public HistorySourceType.Source getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistorySourceType.Source }
     *     
     */
    public void setSource(HistorySourceType.Source value) {
        this.source = value;
    }

    /**
     * Gets the value of the sourceReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceReference() {
        return sourceReference;
    }

    /**
     * Sets the value of the sourceReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceReference(String value) {
        this.sourceReference = value;
    }

    /**
     * Gets the value of the fillNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFillNumber() {
        return fillNumber;
    }

    /**
     * Sets the value of the fillNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFillNumber(String value) {
        this.fillNumber = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="SourceQualifier"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;pattern value="PC|P2|PY"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="SourceDescription" type="{http://www.ncpdp.org/schema/SCRIPT}an..35" minOccurs="0"/&gt;
     *         &lt;element name="Reference" type="{http://www.ncpdp.org/schema/SCRIPT}IDOptionalType" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sourceQualifier",
        "sourceDescription",
        "reference"
    })
    public static class Source {

        @XmlElement(name = "SourceQualifier", required = true)
        protected String sourceQualifier;
        @XmlElement(name = "SourceDescription")
        protected String sourceDescription;
        @XmlElement(name = "Reference")
        protected IDOptionalType reference;

        /**
         * Gets the value of the sourceQualifier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceQualifier() {
            return sourceQualifier;
        }

        /**
         * Sets the value of the sourceQualifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceQualifier(String value) {
            this.sourceQualifier = value;
        }

        /**
         * Gets the value of the sourceDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSourceDescription() {
            return sourceDescription;
        }

        /**
         * Sets the value of the sourceDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSourceDescription(String value) {
            this.sourceDescription = value;
        }

        /**
         * Gets the value of the reference property.
         * 
         * @return
         *     possible object is
         *     {@link IDOptionalType }
         *     
         */
        public IDOptionalType getReference() {
            return reference;
        }

        /**
         * Sets the value of the reference property.
         * 
         * @param value
         *     allowed object is
         *     {@link IDOptionalType }
         *     
         */
        public void setReference(IDOptionalType value) {
            this.reference = value;
        }

    }

}
