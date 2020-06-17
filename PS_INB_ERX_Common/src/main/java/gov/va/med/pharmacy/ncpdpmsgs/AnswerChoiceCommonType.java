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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnswerChoiceCommonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnswerChoiceCommonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChoiceID" type="{}an1..35"/>
 *         &lt;element name="SequenceNumber" type="{}n1..3"/>
 *         &lt;element name="ChoiceText" type="{}an1..2000"/>
 *         &lt;element name="AdditionalFreeTextIndicator" type="{}AdditionalFreeTextIndicator"/>
 *         &lt;element name="CodedReference" type="{}CodedReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NextQuestionID" type="{}an1..35" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnswerChoiceCommonType", propOrder = {
    "choiceID",
    "sequenceNumber",
    "choiceText",
    "additionalFreeTextIndicator",
    "codedReference",
    "nextQuestionID"
})
public class AnswerChoiceCommonType {

    @XmlElement(name = "ChoiceID", required = true)
    protected String choiceID;
    @XmlElement(name = "SequenceNumber", required = true)
    protected String sequenceNumber;
    @XmlElement(name = "ChoiceText", required = true)
    protected String choiceText;
    @XmlElement(name = "AdditionalFreeTextIndicator", required = true)
    @XmlSchemaType(name = "string")
    protected AdditionalFreeTextIndicator additionalFreeTextIndicator;
    @XmlElement(name = "CodedReference")
    protected List<CodedReference> codedReference;
    @XmlElement(name = "NextQuestionID")
    protected String nextQuestionID;

    /**
     * Gets the value of the choiceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoiceID() {
        return choiceID;
    }

    /**
     * Sets the value of the choiceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoiceID(String value) {
        this.choiceID = value;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequenceNumber(String value) {
        this.sequenceNumber = value;
    }

    /**
     * Gets the value of the choiceText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoiceText() {
        return choiceText;
    }

    /**
     * Sets the value of the choiceText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoiceText(String value) {
        this.choiceText = value;
    }

    /**
     * Gets the value of the additionalFreeTextIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalFreeTextIndicator }
     *     
     */
    public AdditionalFreeTextIndicator getAdditionalFreeTextIndicator() {
        return additionalFreeTextIndicator;
    }

    /**
     * Sets the value of the additionalFreeTextIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalFreeTextIndicator }
     *     
     */
    public void setAdditionalFreeTextIndicator(AdditionalFreeTextIndicator value) {
        this.additionalFreeTextIndicator = value;
    }

    /**
     * Gets the value of the codedReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codedReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodedReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodedReference }
     * 
     * 
     */
    public List<CodedReference> getCodedReference() {
        if (codedReference == null) {
            codedReference = new ArrayList<CodedReference>();
        }
        return this.codedReference;
    }

    /**
     * Gets the value of the nextQuestionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextQuestionID() {
        return nextQuestionID;
    }

    /**
     * Sets the value of the nextQuestionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextQuestionID(String value) {
        this.nextQuestionID = value;
    }

}
