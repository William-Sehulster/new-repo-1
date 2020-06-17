//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.18 at 03:04:58 PM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Instruction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Instruction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="InstructionIndicator" type="{}InstructionIndicator"/>
 *           &lt;sequence maxOccurs="49" minOccurs="0">
 *             &lt;element name="MultipleTimingModifier" type="{}ANDOR" minOccurs="0"/>
 *             &lt;element name="TimingAndDuration" type="{}TimingAndDuration"/>
 *           &lt;/sequence>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;choice>
 *             &lt;element name="AdministrationIndicator" type="{}AdministrationIndicator"/>
 *             &lt;sequence>
 *               &lt;element name="DoseAdministration" type="{}DoseAdministration"/>
 *               &lt;element name="TimingAndDuration" type="{}TimingAndDuration"/>
 *               &lt;sequence maxOccurs="49" minOccurs="0">
 *                 &lt;element name="MultipleTimingModifier" type="{}ANDOR" minOccurs="0"/>
 *                 &lt;element name="TimingAndDuration" type="{}TimingAndDuration"/>
 *               &lt;/sequence>
 *             &lt;/sequence>
 *           &lt;/choice>
 *           &lt;sequence minOccurs="0">
 *             &lt;element name="IndicationForUse" type="{}Indication" maxOccurs="50"/>
 *             &lt;element name="IndicationClarifyingFreeText" type="{}an1..255" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="MaximumDoseRestriction" type="{}MaximumDoseRestriction" maxOccurs="50" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "Instruction", propOrder = {
    "instructionIndicator",
    "doseAdministration",
    "seq1",
    "administrationIndicator",
    "timingAndDuration",
    "multipleTimingModifierAndTimingAndDuration",
    "indicationForUse",
    "indicationClarifyingFreeText",
    "maximumDoseRestriction"
})
public class Instruction {

    @XmlElement(name = "InstructionIndicator")
    @XmlSchemaType(name = "string")
    protected InstructionIndicator instructionIndicator;
    @XmlElements({
        @XmlElement(name = "MultipleTimingModifier", type = String.class),
        @XmlElement(name = "TimingAndDuration", type = TimingAndDuration.class)
    })
    protected List<Object> seq1;
    @XmlElement(name = "AdministrationIndicator")
    @XmlSchemaType(name = "string")
    protected AdministrationIndicator administrationIndicator;
    @XmlElement(name = "DoseAdministration")
    protected DoseAdministration doseAdministration;
    @XmlElement(name = "TimingAndDuration")
    protected TimingAndDuration timingAndDuration;
    @XmlElements({
        @XmlElement(name = "MultipleTimingModifier", type = String.class),
        @XmlElement(name = "TimingAndDuration", type = TimingAndDuration.class)
    })
    protected List<Object> multipleTimingModifierAndTimingAndDuration;
    @XmlElement(name = "IndicationForUse")
    protected List<Indication> indicationForUse;
    @XmlElement(name = "IndicationClarifyingFreeText")
    protected String indicationClarifyingFreeText;
    @XmlElement(name = "MaximumDoseRestriction")
    protected List<MaximumDoseRestriction> maximumDoseRestriction;

    /**
     * Gets the value of the instructionIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link InstructionIndicator }
     *     
     */
    public InstructionIndicator getInstructionIndicator() {
        return instructionIndicator;
    }

    /**
     * Sets the value of the instructionIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstructionIndicator }
     *     
     */
    public void setInstructionIndicator(InstructionIndicator value) {
        this.instructionIndicator = value;
    }

    /**
     * Gets the value of the seq1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seq1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeq1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link TimingAndDuration }
     * 
     * 
     */
    public List<Object> getSeq1() {
        if (seq1 == null) {
            seq1 = new ArrayList<Object>();
        }
        return this.seq1;
    }

    /**
     * Gets the value of the administrationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link AdministrationIndicator }
     *     
     */
    public AdministrationIndicator getAdministrationIndicator() {
        return administrationIndicator;
    }

    /**
     * Sets the value of the administrationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdministrationIndicator }
     *     
     */
    public void setAdministrationIndicator(AdministrationIndicator value) {
        this.administrationIndicator = value;
    }

    /**
     * Gets the value of the doseAdministration property.
     * 
     * @return
     *     possible object is
     *     {@link DoseAdministration }
     *     
     */
    public DoseAdministration getDoseAdministration() {
        return doseAdministration;
    }

    /**
     * Sets the value of the doseAdministration property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoseAdministration }
     *     
     */
    public void setDoseAdministration(DoseAdministration value) {
        this.doseAdministration = value;
    }

    /**
     * Gets the value of the timingAndDuration property.
     * 
     * @return
     *     possible object is
     *     {@link TimingAndDuration }
     *     
     */
    public TimingAndDuration getTimingAndDuration() {
        return timingAndDuration;
    }

    /**
     * Sets the value of the timingAndDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimingAndDuration }
     *     
     */
    public void setTimingAndDuration(TimingAndDuration value) {
        this.timingAndDuration = value;
    }

    /**
     * Gets the value of the multipleTimingModifierAndTimingAndDuration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the multipleTimingModifierAndTimingAndDuration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMultipleTimingModifierAndTimingAndDuration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link TimingAndDuration }
     * 
     * 
     */
    public List<Object> getMultipleTimingModifierAndTimingAndDuration() {
        if (multipleTimingModifierAndTimingAndDuration == null) {
            multipleTimingModifierAndTimingAndDuration = new ArrayList<Object>();
        }
        return this.multipleTimingModifierAndTimingAndDuration;
    }

    /**
     * Gets the value of the indicationForUse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indicationForUse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndicationForUse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Indication }
     * 
     * 
     */
    public List<Indication> getIndicationForUse() {
        if (indicationForUse == null) {
            indicationForUse = new ArrayList<Indication>();
        }
        return this.indicationForUse;
    }

    /**
     * Gets the value of the indicationClarifyingFreeText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicationClarifyingFreeText() {
        return indicationClarifyingFreeText;
    }

    /**
     * Sets the value of the indicationClarifyingFreeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicationClarifyingFreeText(String value) {
        this.indicationClarifyingFreeText = value;
    }

    /**
     * Gets the value of the maximumDoseRestriction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maximumDoseRestriction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaximumDoseRestriction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaximumDoseRestriction }
     * 
     * 
     */
    public List<MaximumDoseRestriction> getMaximumDoseRestriction() {
        if (maximumDoseRestriction == null) {
            maximumDoseRestriction = new ArrayList<MaximumDoseRestriction>();
        }
        return this.maximumDoseRestriction;
    }

}
