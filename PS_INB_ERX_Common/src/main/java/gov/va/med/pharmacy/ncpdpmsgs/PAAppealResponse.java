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
 * This transaction is a response from the payer to the prescriber with the status of a PAAppealRequest.
 * 
 * <p>Java class for PAAppealResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PAAppealResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{}PAResponseAbstract">
 *       &lt;sequence>
 *         &lt;element name="Attachment" type="{}AttachmentWithControlNumber" minOccurs="0"/>
 *         &lt;element name="Response" type="{}PAResponseStructureForAppeal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PAAppealResponse", propOrder = {
    "attachment",
    "response"
})
public class PAAppealResponse
    extends PAResponseAbstract
{

    @XmlElement(name = "Attachment")
    protected AttachmentWithControlNumber attachment;
    @XmlElement(name = "Response", required = true)
    protected PAResponseStructureForAppeal response;

    /**
     * Gets the value of the attachment property.
     * 
     * @return
     *     possible object is
     *     {@link AttachmentWithControlNumber }
     *     
     */
    public AttachmentWithControlNumber getAttachment() {
        return attachment;
    }

    /**
     * Sets the value of the attachment property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachmentWithControlNumber }
     *     
     */
    public void setAttachment(AttachmentWithControlNumber value) {
        this.attachment = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link PAResponseStructureForAppeal }
     *     
     */
    public PAResponseStructureForAppeal getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link PAResponseStructureForAppeal }
     *     
     */
    public void setResponse(PAResponseStructureForAppeal value) {
        this.response = value;
    }

}
