//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.18 at 03:04:58 PM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This is initiated by the central fill facility to electronically inform the pharmacy of prescription orders being sent to them in their next delivery.
 * 
 * <p>Java class for CFManifest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFManifest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReturnReceipt" type="{}an1..3" minOccurs="0"/>
 *         &lt;element name="CFTote" type="{}CFTote"/>
 *         &lt;element name="CFManifestDetail" type="{}CFManifestDetail"/>
 *         &lt;element name="MandatoryPharmacy" type="{}MandatoryPharmacy"/>
 *         &lt;element name="Pharmacist" type="{}Pharmacist" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFManifest", propOrder = {
    "returnReceipt",
    "cfTote",
    "cfManifestDetail",
    "mandatoryPharmacy",
    "pharmacist"
})
public class CFManifest {

    @XmlElement(name = "ReturnReceipt")
    protected String returnReceipt;
    @XmlElement(name = "CFTote", required = true)
    protected CFTote cfTote;
    @XmlElement(name = "CFManifestDetail", required = true)
    protected CFManifestDetail cfManifestDetail;
    @XmlElement(name = "MandatoryPharmacy", required = true)
    protected MandatoryPharmacy mandatoryPharmacy;
    @XmlElement(name = "Pharmacist")
    protected Pharmacist pharmacist;

    /**
     * Gets the value of the returnReceipt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnReceipt() {
        return returnReceipt;
    }

    /**
     * Sets the value of the returnReceipt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnReceipt(String value) {
        this.returnReceipt = value;
    }

    /**
     * Gets the value of the cfTote property.
     * 
     * @return
     *     possible object is
     *     {@link CFTote }
     *     
     */
    public CFTote getCFTote() {
        return cfTote;
    }

    /**
     * Sets the value of the cfTote property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFTote }
     *     
     */
    public void setCFTote(CFTote value) {
        this.cfTote = value;
    }

    /**
     * Gets the value of the cfManifestDetail property.
     * 
     * @return
     *     possible object is
     *     {@link CFManifestDetail }
     *     
     */
    public CFManifestDetail getCFManifestDetail() {
        return cfManifestDetail;
    }

    /**
     * Sets the value of the cfManifestDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link CFManifestDetail }
     *     
     */
    public void setCFManifestDetail(CFManifestDetail value) {
        this.cfManifestDetail = value;
    }

    /**
     * Gets the value of the mandatoryPharmacy property.
     * 
     * @return
     *     possible object is
     *     {@link MandatoryPharmacy }
     *     
     */
    public MandatoryPharmacy getMandatoryPharmacy() {
        return mandatoryPharmacy;
    }

    /**
     * Sets the value of the mandatoryPharmacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandatoryPharmacy }
     *     
     */
    public void setMandatoryPharmacy(MandatoryPharmacy value) {
        this.mandatoryPharmacy = value;
    }

    /**
     * Gets the value of the pharmacist property.
     * 
     * @return
     *     possible object is
     *     {@link Pharmacist }
     *     
     */
    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    /**
     * Sets the value of the pharmacist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pharmacist }
     *     
     */
    public void setPharmacist(Pharmacist value) {
        this.pharmacist = value;
    }

}
