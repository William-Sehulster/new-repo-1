
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for getDeliveryPreferenceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDeliveryPreferenceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="deliveryPreference" type="{http://jaxws.webservices.esr.med.va.gov/schemas}deliveryPreferences" minOccurs="0"/&gt;
 *         &lt;element name="invocationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="eesVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDeliveryPreferenceResponse", propOrder = {

})
public class GetDeliveryPreferenceResponse {

    protected DeliveryPreferences deliveryPreference;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar invocationDate;
    protected String eesVersion;
    protected String status;
    protected String message;

    /**
     * Gets the value of the deliveryPreference property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryPreferences }
     *     
     */
    public DeliveryPreferences getDeliveryPreference() {
        return deliveryPreference;
    }

    /**
     * Sets the value of the deliveryPreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryPreferences }
     *     
     */
    public void setDeliveryPreference(DeliveryPreferences value) {
        this.deliveryPreference = value;
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
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
