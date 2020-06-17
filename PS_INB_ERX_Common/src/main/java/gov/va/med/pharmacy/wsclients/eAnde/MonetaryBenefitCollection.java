
package gov.va.med.pharmacy.wsclients.eAnde;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for monetaryBenefitCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="monetaryBenefitCollection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="monetaryBenefit" type="{http://jaxws.webservices.esr.med.va.gov/schemas}monetaryBenefitInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "monetaryBenefitCollection", propOrder = {
    "monetaryBenefit"
})
public class MonetaryBenefitCollection {

    @XmlElement(nillable = true)
    protected List<MonetaryBenefitInfo> monetaryBenefit;

    /**
     * Gets the value of the monetaryBenefit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the monetaryBenefit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMonetaryBenefit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MonetaryBenefitInfo }
     * 
     * 
     */
    public List<MonetaryBenefitInfo> getMonetaryBenefit() {
        if (monetaryBenefit == null) {
            monetaryBenefit = new ArrayList<MonetaryBenefitInfo>();
        }
        return this.monetaryBenefit;
    }

}
