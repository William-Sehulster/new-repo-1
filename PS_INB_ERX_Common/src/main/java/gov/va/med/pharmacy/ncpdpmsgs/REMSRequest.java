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
 * <p>Java class for REMSRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="REMSRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{}REMSRequestAbstract">
 *       &lt;sequence>
 *         &lt;element name="Attachment" type="{}AttachmentWithControlNumber" minOccurs="0"/>
 *         &lt;element name="Request" type="{}REMSModelType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REMSRequest", propOrder = {
    "attachment",
    "request"
})
public class REMSRequest
    extends REMSRequestAbstract
{

    @XmlElement(name = "Attachment")
    protected AttachmentWithControlNumber attachment;
    @XmlElement(name = "Request", required = true)
    protected REMSModelType request;

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
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link REMSModelType }
     *     
     */
    public REMSModelType getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link REMSModelType }
     *     
     */
    public void setRequest(REMSModelType value) {
        this.request = value;
    }

}
