
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for linkNotificationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="linkNotificationInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="depricatedVPID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="survivingVPID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "linkNotificationInfo", propOrder = {

})
public class LinkNotificationInfo {

    @XmlElement(required = true)
    protected String depricatedVPID;
    @XmlElement(required = true)
    protected String survivingVPID;

    /**
     * Gets the value of the depricatedVPID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepricatedVPID() {
        return depricatedVPID;
    }

    /**
     * Sets the value of the depricatedVPID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepricatedVPID(String value) {
        this.depricatedVPID = value;
    }

    /**
     * Gets the value of the survivingVPID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurvivingVPID() {
        return survivingVPID;
    }

    /**
     * Sets the value of the survivingVPID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurvivingVPID(String value) {
        this.survivingVPID = value;
    }

}
