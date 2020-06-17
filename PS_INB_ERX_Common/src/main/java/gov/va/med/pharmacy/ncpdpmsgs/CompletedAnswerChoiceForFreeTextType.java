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
 * <p>Java class for CompletedAnswerChoiceForFreeTextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompletedAnswerChoiceForFreeTextType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="PrescriberProvidedAnswer" type="{}an1..2000"/>
 *         &lt;element name="CodedReferenceAnswer" type="{}CodedReferenceAnswerChoiceFreeTextType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedAnswerChoiceForFreeTextType", propOrder = {
    "prescriberProvidedAnswer",
    "codedReferenceAnswer"
})
public class CompletedAnswerChoiceForFreeTextType {

    @XmlElement(name = "PrescriberProvidedAnswer")
    protected String prescriberProvidedAnswer;
    @XmlElement(name = "CodedReferenceAnswer")
    protected CodedReferenceAnswerChoiceFreeTextType codedReferenceAnswer;

    /**
     * Gets the value of the prescriberProvidedAnswer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrescriberProvidedAnswer() {
        return prescriberProvidedAnswer;
    }

    /**
     * Sets the value of the prescriberProvidedAnswer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrescriberProvidedAnswer(String value) {
        this.prescriberProvidedAnswer = value;
    }

    /**
     * Gets the value of the codedReferenceAnswer property.
     * 
     * @return
     *     possible object is
     *     {@link CodedReferenceAnswerChoiceFreeTextType }
     *     
     */
    public CodedReferenceAnswerChoiceFreeTextType getCodedReferenceAnswer() {
        return codedReferenceAnswer;
    }

    /**
     * Sets the value of the codedReferenceAnswer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodedReferenceAnswerChoiceFreeTextType }
     *     
     */
    public void setCodedReferenceAnswer(CodedReferenceAnswerChoiceFreeTextType value) {
        this.codedReferenceAnswer = value;
    }

}
