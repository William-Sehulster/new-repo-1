//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.18 at 03:04:58 PM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeniedAbstractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeniedAbstractType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReasonCode" type="{}ReasonCode" maxOccurs="10" minOccurs="0"/>
 *         &lt;element name="ReferenceNumber" type="{}an1..35" minOccurs="0"/>
 *         &lt;element name="DenialReason" type="{}an" minOccurs="0"/>
 *         &lt;element name="Pharmacy" type="{}MandatoryPharmacy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeniedAbstractType", propOrder = {
    "reasonCode",
    "referenceNumber",
    "denialReason",
    "pharmacy"
})
@XmlSeeAlso({
    DeniedTransferredTypeForTxRx.class,
    DeniedTransferredType.class,
    RefillResponseDeniedType.class,
    RxHistoryDeniedType.class,
    NewRxResponseDeniedType.class,
    DeniedTransferredResponseType.class,
    RxChangeResponseDeniedType.class
})
public class DeniedAbstractType {

    @XmlElement(name = "ReasonCode")
    @XmlSchemaType(name = "string")
    protected List<ReasonCode> reasonCode;
    @XmlElement(name = "ReferenceNumber")
    protected String referenceNumber;
    @XmlElement(name = "DenialReason")
    protected String denialReason;
    @XmlElement(name = "Pharmacy")
    protected MandatoryPharmacy pharmacy;

    /**
     * Gets the value of the reasonCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reasonCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReasonCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReasonCode }
     * 
     * 
     */
    public List<ReasonCode> getReasonCode() {
        if (reasonCode == null) {
            reasonCode = new ArrayList<ReasonCode>();
        }
        return this.reasonCode;
    }

    /**
     * Gets the value of the referenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumber(String value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the denialReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenialReason() {
        return denialReason;
    }

    /**
     * Sets the value of the denialReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenialReason(String value) {
        this.denialReason = value;
    }

    /**
     * Gets the value of the pharmacy property.
     * 
     * @return
     *     possible object is
     *     {@link MandatoryPharmacy }
     *     
     */
    public MandatoryPharmacy getPharmacy() {
        return pharmacy;
    }

    /**
     * Sets the value of the pharmacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandatoryPharmacy }
     *     
     */
    public void setPharmacy(MandatoryPharmacy value) {
        this.pharmacy = value;
    }

}
