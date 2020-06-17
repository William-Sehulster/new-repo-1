
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for vamcInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vamcInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="dfnNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="facilityNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastVisitDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="vamcReportDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vamcInfo", propOrder = {

})
public class VamcInfo {

    protected String dfnNumber;
    protected String facilityNumber;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastVisitDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar vamcReportDate;

    /**
     * Gets the value of the dfnNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDfnNumber() {
        return dfnNumber;
    }

    /**
     * Sets the value of the dfnNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDfnNumber(String value) {
        this.dfnNumber = value;
    }

    /**
     * Gets the value of the facilityNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityNumber() {
        return facilityNumber;
    }

    /**
     * Sets the value of the facilityNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityNumber(String value) {
        this.facilityNumber = value;
    }

    /**
     * Gets the value of the lastVisitDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastVisitDate() {
        return lastVisitDate;
    }

    /**
     * Sets the value of the lastVisitDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastVisitDate(XMLGregorianCalendar value) {
        this.lastVisitDate = value;
    }

    /**
     * Gets the value of the vamcReportDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVamcReportDate() {
        return vamcReportDate;
    }

    /**
     * Sets the value of the vamcReportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVamcReportDate(XMLGregorianCalendar value) {
        this.vamcReportDate = value;
    }

}
