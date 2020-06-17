//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.18 at 02:27:26 AM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OptionalProviderIDType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptionalProviderIDType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="3" minOccurs="0"&gt;
 *         &lt;element name="NCPDPID" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="FileID" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="StateLicenseNumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="MedicareNumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="MedicaidNumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="DentistLicenseNumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="UPIN" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="FacilityID" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="PPONumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="PayerID" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="ProcessorIdentificationNumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="BINLocationNumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="Commercial" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="MedicalRecordIdentificationNumberEHR" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="PatientAccountNumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="DEANumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="HIN" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="IndividualPolicyNumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="SecondaryCoverage" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="NAICCode" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="PromotionNumber" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="SocialSecurity" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="NPI" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="PriorAuthorization" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *         &lt;element name="MutuallyDefined" type="{http://www.ncpdp.org/schema/SCRIPT}an..35M"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptionalProviderIDType", propOrder = {
    "ncpdpidOrFileIDOrStateLicenseNumber"
})
public class OptionalProviderIDType {

    @XmlElementRefs({
        @XmlElementRef(name = "NPI", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IndividualPolicyNumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DentistLicenseNumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MedicalRecordIdentificationNumberEHR", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MedicaidNumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PayerID", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FileID", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DEANumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NCPDPID", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PatientAccountNumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ProcessorIdentificationNumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "NAICCode", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PriorAuthorization", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "StateLicenseNumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Commercial", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "UPIN", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HIN", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PPONumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MutuallyDefined", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PromotionNumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SocialSecurity", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "MedicareNumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SecondaryCoverage", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FacilityID", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BINLocationNumber", namespace = "http://www.ncpdp.org/schema/SCRIPT", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> ncpdpidOrFileIDOrStateLicenseNumber;

    /**
     * Gets the value of the ncpdpidOrFileIDOrStateLicenseNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ncpdpidOrFileIDOrStateLicenseNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNCPDPIDOrFileIDOrStateLicenseNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getNCPDPIDOrFileIDOrStateLicenseNumber() {
        if (ncpdpidOrFileIDOrStateLicenseNumber == null) {
            ncpdpidOrFileIDOrStateLicenseNumber = new ArrayList<JAXBElement<String>>();
        }
        return this.ncpdpidOrFileIDOrStateLicenseNumber;
    }

}
