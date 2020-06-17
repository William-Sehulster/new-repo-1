
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eds complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eds"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="eligibilityStatusInfo" type="{http://jaxws.webservices.esr.med.va.gov/schemas}eligibilityStatusInfo" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eds", propOrder = {

})
public class Eds {

    protected EligibilityStatusInfo eligibilityStatusInfo;

    /**
     * Gets the value of the eligibilityStatusInfo property.
     * 
     * @return
     *     possible object is
     *     {@link EligibilityStatusInfo }
     *     
     */
    public EligibilityStatusInfo getEligibilityStatusInfo() {
        return eligibilityStatusInfo;
    }

    /**
     * Sets the value of the eligibilityStatusInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link EligibilityStatusInfo }
     *     
     */
    public void setEligibilityStatusInfo(EligibilityStatusInfo value) {
        this.eligibilityStatusInfo = value;
    }

}
