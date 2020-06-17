
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for prisonerOfWarInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prisonerOfWarInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="episodes" type="{http://jaxws.webservices.esr.med.va.gov/schemas}powEpisodeCollection" minOccurs="0"/&gt;
 *         &lt;element name="powIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prisonerOfWarInfo", propOrder = {

})
public class PrisonerOfWarInfo {

    protected PowEpisodeCollection episodes;
    protected String powIndicator;

    /**
     * Gets the value of the episodes property.
     * 
     * @return
     *     possible object is
     *     {@link PowEpisodeCollection }
     *     
     */
    public PowEpisodeCollection getEpisodes() {
        return episodes;
    }

    /**
     * Sets the value of the episodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PowEpisodeCollection }
     *     
     */
    public void setEpisodes(PowEpisodeCollection value) {
        this.episodes = value;
    }

    /**
     * Gets the value of the powIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPowIndicator() {
        return powIndicator;
    }

    /**
     * Sets the value of the powIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPowIndicator(String value) {
        this.powIndicator = value;
    }

}
