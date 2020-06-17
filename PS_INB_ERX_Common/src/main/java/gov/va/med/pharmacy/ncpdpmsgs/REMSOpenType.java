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
 * <p>Java class for REMSOpenType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="REMSOpenType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="REMSCaseID" type="{}an1..35"/>
 *         &lt;element name="DeadlineForReply" type="{}DateType"/>
 *         &lt;element name="QuestionSet" type="{}QuestionSetGroup" minOccurs="0"/>
 *         &lt;element name="REMSNote" type="{}an1..2000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REMSOpenType", propOrder = {
    "remsCaseID",
    "deadlineForReply",
    "questionSet",
    "remsNote"
})
public class REMSOpenType {

    @XmlElement(name = "REMSCaseID", required = true)
    protected String remsCaseID;
    @XmlElement(name = "DeadlineForReply", required = true)
    protected DateType deadlineForReply;
    @XmlElement(name = "QuestionSet")
    protected QuestionSetGroup questionSet;
    @XmlElement(name = "REMSNote")
    protected String remsNote;

    /**
     * Gets the value of the remsCaseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMSCaseID() {
        return remsCaseID;
    }

    /**
     * Sets the value of the remsCaseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMSCaseID(String value) {
        this.remsCaseID = value;
    }

    /**
     * Gets the value of the deadlineForReply property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDeadlineForReply() {
        return deadlineForReply;
    }

    /**
     * Sets the value of the deadlineForReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDeadlineForReply(DateType value) {
        this.deadlineForReply = value;
    }

    /**
     * Gets the value of the questionSet property.
     * 
     * @return
     *     possible object is
     *     {@link QuestionSetGroup }
     *     
     */
    public QuestionSetGroup getQuestionSet() {
        return questionSet;
    }

    /**
     * Sets the value of the questionSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuestionSetGroup }
     *     
     */
    public void setQuestionSet(QuestionSetGroup value) {
        this.questionSet = value;
    }

    /**
     * Gets the value of the remsNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREMSNote() {
        return remsNote;
    }

    /**
     * Sets the value of the remsNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREMSNote(String value) {
        this.remsNote = value;
    }

}
