
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for updateDeliveryPreferenceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateDeliveryPreferenceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="acknowledgement" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="invocationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="eesVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateDeliveryPreferenceResponse", propOrder = {

})
public class UpdateDeliveryPreferenceResponse {

    @XmlElement(required = true)
    protected String acknowledgement;
    protected String status;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar invocationDate;
    protected String eesVersion;

    /**
     * Gets the value of the acknowledgement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcknowledgement() {
        return acknowledgement;
    }

    /**
     * Sets the value of the acknowledgement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcknowledgement(String value) {
        this.acknowledgement = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the invocationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvocationDate() {
        return invocationDate;
    }

    /**
     * Sets the value of the invocationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvocationDate(XMLGregorianCalendar value) {
        this.invocationDate = value;
    }

    /**
     * Gets the value of the eesVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEesVersion() {
        return eesVersion;
    }

    /**
     * Sets the value of the eesVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEesVersion(String value) {
        this.eesVersion = value;
    }

}
