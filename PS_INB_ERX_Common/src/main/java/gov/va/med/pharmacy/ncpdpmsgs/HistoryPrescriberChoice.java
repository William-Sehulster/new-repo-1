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
 * <p>Java class for HistoryPrescriberChoice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HistoryPrescriberChoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="NonVeterinarian" type="{}HistoryPrescriber"/>
 *         &lt;element name="Veterinarian" type="{}VetPrescriberMirrorHistoryPrescriber"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistoryPrescriberChoice", propOrder = {
    "nonVeterinarian",
    "veterinarian"
})
@XmlSeeAlso({
    PrescriberGeneralChoice.class,
    PrescriberChoice.class,
    MandatoryPrescriberChoice.class,
    OptionalPrescriberChoice.class
})
public class HistoryPrescriberChoice {

    @XmlElement(name = "NonVeterinarian")
    protected HistoryPrescriber nonVeterinarian;
    @XmlElement(name = "Veterinarian")
    protected VetPrescriberMirrorHistoryPrescriber veterinarian;

    /**
     * Gets the value of the nonVeterinarian property.
     * 
     * @return
     *     possible object is
     *     {@link HistoryPrescriber }
     *     
     */
    public HistoryPrescriber getNonVeterinarian() {
        return nonVeterinarian;
    }

    /**
     * Sets the value of the nonVeterinarian property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoryPrescriber }
     *     
     */
    public void setNonVeterinarian(HistoryPrescriber value) {
        this.nonVeterinarian = value;
    }

    /**
     * Gets the value of the veterinarian property.
     * 
     * @return
     *     possible object is
     *     {@link VetPrescriberMirrorHistoryPrescriber }
     *     
     */
    public VetPrescriberMirrorHistoryPrescriber getVeterinarian() {
        return veterinarian;
    }

    /**
     * Sets the value of the veterinarian property.
     * 
     * @param value
     *     allowed object is
     *     {@link VetPrescriberMirrorHistoryPrescriber }
     *     
     */
    public void setVeterinarian(VetPrescriberMirrorHistoryPrescriber value) {
        this.veterinarian = value;
    }

}
