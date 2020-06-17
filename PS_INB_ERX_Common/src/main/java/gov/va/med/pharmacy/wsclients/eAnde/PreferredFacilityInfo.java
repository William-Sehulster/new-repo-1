
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for preferredFacilityInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="preferredFacilityInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="preferredFacility" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="assignmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="unassignmentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preferredFacilityInfo", propOrder = {

})
public class PreferredFacilityInfo {

    protected String preferredFacility;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar assignmentDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar unassignmentDate;

    /**
     * Gets the value of the preferredFacility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredFacility() {
        return preferredFacility;
    }

    /**
     * Sets the value of the preferredFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredFacility(String value) {
        this.preferredFacility = value;
    }

    /**
     * Gets the value of the assignmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAssignmentDate() {
        return assignmentDate;
    }

    /**
     * Sets the value of the assignmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAssignmentDate(XMLGregorianCalendar value) {
        this.assignmentDate = value;
    }

    /**
     * Gets the value of the unassignmentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUnassignmentDate() {
        return unassignmentDate;
    }

    /**
     * Sets the value of the unassignmentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUnassignmentDate(XMLGregorianCalendar value) {
        this.unassignmentDate = value;
    }

}
