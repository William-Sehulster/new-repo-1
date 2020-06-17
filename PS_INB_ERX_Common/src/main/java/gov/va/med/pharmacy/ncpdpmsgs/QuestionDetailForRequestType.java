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
 * <p>Java class for QuestionDetailForRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuestionDetailForRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{}QuestionDetailCommonType">
 *       &lt;sequence>
 *         &lt;element name="QuestionType" type="{}QuestionTypeForRequest"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuestionDetailForRequestType", propOrder = {
    "questionType"
})
public class QuestionDetailForRequestType
    extends QuestionDetailCommonType
{

    @XmlElement(name = "QuestionType", required = true)
    protected QuestionTypeForRequest questionType;

    /**
     * Gets the value of the questionType property.
     * 
     * @return
     *     possible object is
     *     {@link QuestionTypeForRequest }
     *     
     */
    public QuestionTypeForRequest getQuestionType() {
        return questionType;
    }

    /**
     * Sets the value of the questionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuestionTypeForRequest }
     *     
     */
    public void setQuestionType(QuestionTypeForRequest value) {
        this.questionType = value;
    }

}
