
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for sensitivityInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sensitivityInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="sensitivityChangeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="sensitivityChangeSite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sensitivityChangeSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sensityFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sensitivityInfo", propOrder = {

})
public class SensitivityInfo {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sensitivityChangeDate;
    protected String sensitivityChangeSite;
    protected String sensitivityChangeSource;
    protected Boolean sensityFlag;

    /**
     * Gets the value of the sensitivityChangeDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSensitivityChangeDate() {
        return sensitivityChangeDate;
    }

    /**
     * Sets the value of the sensitivityChangeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSensitivityChangeDate(XMLGregorianCalendar value) {
        this.sensitivityChangeDate = value;
    }

    /**
     * Gets the value of the sensitivityChangeSite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSensitivityChangeSite() {
        return sensitivityChangeSite;
    }

    /**
     * Sets the value of the sensitivityChangeSite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensitivityChangeSite(String value) {
        this.sensitivityChangeSite = value;
    }

    /**
     * Gets the value of the sensitivityChangeSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSensitivityChangeSource() {
        return sensitivityChangeSource;
    }

    /**
     * Sets the value of the sensitivityChangeSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensitivityChangeSource(String value) {
        this.sensitivityChangeSource = value;
    }

    /**
     * Gets the value of the sensityFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSensityFlag() {
        return sensityFlag;
    }

    /**
     * Sets the value of the sensityFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSensityFlag(Boolean value) {
        this.sensityFlag = value;
    }

}
