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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PAPartiallyDeniedDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PAPartiallyDeniedDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PACaseID" type="{}an1..35"/>
 *         &lt;element name="AuthorizationNumber" type="{}an1..140" minOccurs="0"/>
 *         &lt;element name="AuthorizationDetail" type="{}PAAuthorizationDetails" maxOccurs="5" minOccurs="0"/>
 *         &lt;element name="AuthorizationPeriod" type="{}DateGroupWithEffectiveExpiredDate" minOccurs="0"/>
 *         &lt;element name="Appeal" type="{}PAAppeal"/>
 *         &lt;element name="PANote" type="{}an1..2000" minOccurs="0"/>
 *         &lt;element name="PAProcessor" type="{}PAProcessor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PAPartiallyDeniedDetail", propOrder = {
    "paCaseID",
    "authorizationNumber",
    "authorizationDetail",
    "authorizationPeriod",
    "appeal",
    "paNote",
    "paProcessor"
})
public class PAPartiallyDeniedDetail {

    @XmlElement(name = "PACaseID", required = true)
    protected String paCaseID;
    @XmlElement(name = "AuthorizationNumber")
    protected String authorizationNumber;
    @XmlElement(name = "AuthorizationDetail")
    protected List<PAAuthorizationDetails> authorizationDetail;
    @XmlElement(name = "AuthorizationPeriod")
    protected DateGroupWithEffectiveExpiredDate authorizationPeriod;
    @XmlElement(name = "Appeal", required = true)
    protected PAAppeal appeal;
    @XmlElement(name = "PANote")
    protected String paNote;
    @XmlElement(name = "PAProcessor")
    protected PAProcessor paProcessor;

    /**
     * Gets the value of the paCaseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPACaseID() {
        return paCaseID;
    }

    /**
     * Sets the value of the paCaseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPACaseID(String value) {
        this.paCaseID = value;
    }

    /**
     * Gets the value of the authorizationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    /**
     * Sets the value of the authorizationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationNumber(String value) {
        this.authorizationNumber = value;
    }

    /**
     * Gets the value of the authorizationDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorizationDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorizationDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PAAuthorizationDetails }
     * 
     * 
     */
    public List<PAAuthorizationDetails> getAuthorizationDetail() {
        if (authorizationDetail == null) {
            authorizationDetail = new ArrayList<PAAuthorizationDetails>();
        }
        return this.authorizationDetail;
    }

    /**
     * Gets the value of the authorizationPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link DateGroupWithEffectiveExpiredDate }
     *     
     */
    public DateGroupWithEffectiveExpiredDate getAuthorizationPeriod() {
        return authorizationPeriod;
    }

    /**
     * Sets the value of the authorizationPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateGroupWithEffectiveExpiredDate }
     *     
     */
    public void setAuthorizationPeriod(DateGroupWithEffectiveExpiredDate value) {
        this.authorizationPeriod = value;
    }

    /**
     * Gets the value of the appeal property.
     * 
     * @return
     *     possible object is
     *     {@link PAAppeal }
     *     
     */
    public PAAppeal getAppeal() {
        return appeal;
    }

    /**
     * Sets the value of the appeal property.
     * 
     * @param value
     *     allowed object is
     *     {@link PAAppeal }
     *     
     */
    public void setAppeal(PAAppeal value) {
        this.appeal = value;
    }

    /**
     * Gets the value of the paNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPANote() {
        return paNote;
    }

    /**
     * Sets the value of the paNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPANote(String value) {
        this.paNote = value;
    }

    /**
     * Gets the value of the paProcessor property.
     * 
     * @return
     *     possible object is
     *     {@link PAProcessor }
     *     
     */
    public PAProcessor getPAProcessor() {
        return paProcessor;
    }

    /**
     * Sets the value of the paProcessor property.
     * 
     * @param value
     *     allowed object is
     *     {@link PAProcessor }
     *     
     */
    public void setPAProcessor(PAProcessor value) {
        this.paProcessor = value;
    }

}
