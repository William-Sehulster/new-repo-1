
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for combatEpisodeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="combatEpisodeInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="combatPayType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="conflictLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OEFOIFSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OEFOIFStationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "combatEpisodeInfo", propOrder = {

})
public class CombatEpisodeInfo {

    protected String combatPayType;
    protected String conflictLocation;
    protected String endDate;
    @XmlElement(name = "OEFOIFSource")
    protected String oefoifSource;
    @XmlElement(name = "OEFOIFStationNumber")
    protected String oefoifStationNumber;
    protected String startDate;

    /**
     * Gets the value of the combatPayType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCombatPayType() {
        return combatPayType;
    }

    /**
     * Sets the value of the combatPayType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCombatPayType(String value) {
        this.combatPayType = value;
    }

    /**
     * Gets the value of the conflictLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConflictLocation() {
        return conflictLocation;
    }

    /**
     * Sets the value of the conflictLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConflictLocation(String value) {
        this.conflictLocation = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the oefoifSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOEFOIFSource() {
        return oefoifSource;
    }

    /**
     * Sets the value of the oefoifSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOEFOIFSource(String value) {
        this.oefoifSource = value;
    }

    /**
     * Gets the value of the oefoifStationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOEFOIFStationNumber() {
        return oefoifStationNumber;
    }

    /**
     * Sets the value of the oefoifStationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOEFOIFStationNumber(String value) {
        this.oefoifStationNumber = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

}
