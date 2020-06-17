
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for categoryCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="categoryCollection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="category" type="{http://jaxws.webservices.esr.med.va.gov/schemas}categoryInfo"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categoryCollection", propOrder = {

})
public class CategoryCollection {

    @XmlElement(required = true)
    protected CategoryInfo category;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryInfo }
     *     
     */
    public CategoryInfo getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryInfo }
     *     
     */
    public void setCategory(CategoryInfo value) {
        this.category = value;
    }

}
