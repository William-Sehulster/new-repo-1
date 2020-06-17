
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getPersonNotificationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPersonNotificationRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="notificationType" type="{http://jaxws.webservices.esr.med.va.gov/schemas}NotificationType"/&gt;
 *         &lt;element name="primaryviewNotification" type="{http://jaxws.webservices.esr.med.va.gov/schemas}primaryviewNotificationInfo" minOccurs="0"/&gt;
 *         &lt;element name="linkNotification" type="{http://jaxws.webservices.esr.med.va.gov/schemas}linkNotificationInfo" minOccurs="0"/&gt;
 *         &lt;element name="moveNotification" type="{http://jaxws.webservices.esr.med.va.gov/schemas}moveNotificationInfo" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersonNotificationRequest", propOrder = {

})
public class GetPersonNotificationRequest {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected NotificationType notificationType;
    protected PrimaryviewNotificationInfo primaryviewNotification;
    protected LinkNotificationInfo linkNotification;
    protected MoveNotificationInfo moveNotification;

    /**
     * Gets the value of the notificationType property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationType }
     *     
     */
    public NotificationType getNotificationType() {
        return notificationType;
    }

    /**
     * Sets the value of the notificationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationType }
     *     
     */
    public void setNotificationType(NotificationType value) {
        this.notificationType = value;
    }

    /**
     * Gets the value of the primaryviewNotification property.
     * 
     * @return
     *     possible object is
     *     {@link PrimaryviewNotificationInfo }
     *     
     */
    public PrimaryviewNotificationInfo getPrimaryviewNotification() {
        return primaryviewNotification;
    }

    /**
     * Sets the value of the primaryviewNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryviewNotificationInfo }
     *     
     */
    public void setPrimaryviewNotification(PrimaryviewNotificationInfo value) {
        this.primaryviewNotification = value;
    }

    /**
     * Gets the value of the linkNotification property.
     * 
     * @return
     *     possible object is
     *     {@link LinkNotificationInfo }
     *     
     */
    public LinkNotificationInfo getLinkNotification() {
        return linkNotification;
    }

    /**
     * Sets the value of the linkNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkNotificationInfo }
     *     
     */
    public void setLinkNotification(LinkNotificationInfo value) {
        this.linkNotification = value;
    }

    /**
     * Gets the value of the moveNotification property.
     * 
     * @return
     *     possible object is
     *     {@link MoveNotificationInfo }
     *     
     */
    public MoveNotificationInfo getMoveNotification() {
        return moveNotification;
    }

    /**
     * Sets the value of the moveNotification property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoveNotificationInfo }
     *     
     */
    public void setMoveNotification(MoveNotificationInfo value) {
        this.moveNotification = value;
    }

}
