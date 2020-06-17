
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for militaryServiceSiteRecordInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="militaryServiceSiteRecordInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="conflictExperiences" type="{http://jaxws.webservices.esr.med.va.gov/schemas}conflictExperienceCollection" minOccurs="0"/&gt;
 *         &lt;element name="militaryServiceEpisodes" type="{http://jaxws.webservices.esr.med.va.gov/schemas}militaryServiceEpisodeCollection" minOccurs="0"/&gt;
 *         &lt;element name="servicePeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="site" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "militaryServiceSiteRecordInfo", propOrder = {

})
public class MilitaryServiceSiteRecordInfo {

    protected ConflictExperienceCollection conflictExperiences;
    protected MilitaryServiceEpisodeCollection militaryServiceEpisodes;
    protected String servicePeriod;
    protected String site;

    /**
     * Gets the value of the conflictExperiences property.
     * 
     * @return
     *     possible object is
     *     {@link ConflictExperienceCollection }
     *     
     */
    public ConflictExperienceCollection getConflictExperiences() {
        return conflictExperiences;
    }

    /**
     * Sets the value of the conflictExperiences property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConflictExperienceCollection }
     *     
     */
    public void setConflictExperiences(ConflictExperienceCollection value) {
        this.conflictExperiences = value;
    }

    /**
     * Gets the value of the militaryServiceEpisodes property.
     * 
     * @return
     *     possible object is
     *     {@link MilitaryServiceEpisodeCollection }
     *     
     */
    public MilitaryServiceEpisodeCollection getMilitaryServiceEpisodes() {
        return militaryServiceEpisodes;
    }

    /**
     * Sets the value of the militaryServiceEpisodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link MilitaryServiceEpisodeCollection }
     *     
     */
    public void setMilitaryServiceEpisodes(MilitaryServiceEpisodeCollection value) {
        this.militaryServiceEpisodes = value;
    }

    /**
     * Gets the value of the servicePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicePeriod() {
        return servicePeriod;
    }

    /**
     * Sets the value of the servicePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicePeriod(String value) {
        this.servicePeriod = value;
    }

    /**
     * Gets the value of the site property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSite() {
        return site;
    }

    /**
     * Sets the value of the site property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSite(String value) {
        this.site = value;
    }

}
