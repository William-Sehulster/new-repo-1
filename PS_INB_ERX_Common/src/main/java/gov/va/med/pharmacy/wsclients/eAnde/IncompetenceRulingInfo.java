
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for incompetenceRulingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="incompetenceRulingInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="civilRulingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="incompetent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="vaRulingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "incompetenceRulingInfo", propOrder = {

})
public class IncompetenceRulingInfo {

    protected String civilRulingDate;
    protected Boolean incompetent;
    protected String vaRulingDate;

    /**
     * Gets the value of the civilRulingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCivilRulingDate() {
        return civilRulingDate;
    }

    /**
     * Sets the value of the civilRulingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCivilRulingDate(String value) {
        this.civilRulingDate = value;
    }

    /**
     * Gets the value of the incompetent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncompetent() {
        return incompetent;
    }

    /**
     * Sets the value of the incompetent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncompetent(Boolean value) {
        this.incompetent = value;
    }

    /**
     * Gets the value of the vaRulingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVaRulingDate() {
        return vaRulingDate;
    }

    /**
     * Sets the value of the vaRulingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVaRulingDate(String value) {
        this.vaRulingDate = value;
    }

}
