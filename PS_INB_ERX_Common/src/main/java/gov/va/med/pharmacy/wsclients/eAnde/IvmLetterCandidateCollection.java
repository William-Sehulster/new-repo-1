
package gov.va.med.pharmacy.wsclients.eAnde;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ivmLetterCandidateCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ivmLetterCandidateCollection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ivmLetterCandidate" type="{http://jaxws.webservices.esr.med.va.gov/schemas}ivmLetterCandidateInfo" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ivmLetterCandidateCollection", propOrder = {
    "ivmLetterCandidate"
})
public class IvmLetterCandidateCollection {

    @XmlElement(required = true)
    protected List<IvmLetterCandidateInfo> ivmLetterCandidate;

    /**
     * Gets the value of the ivmLetterCandidate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ivmLetterCandidate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIvmLetterCandidate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IvmLetterCandidateInfo }
     * 
     * 
     */
    public List<IvmLetterCandidateInfo> getIvmLetterCandidate() {
        if (ivmLetterCandidate == null) {
            ivmLetterCandidate = new ArrayList<IvmLetterCandidateInfo>();
        }
        return this.ivmLetterCandidate;
    }

}
