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
 * <p>Java class for PADeniedTypeForAppeal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PADeniedTypeForAppeal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PACaseID" type="{}an1..35"/>
 *         &lt;element name="Appeal" type="{}PAAppeal"/>
 *         &lt;element name="PANote" type="{}an1..2000" minOccurs="0"/>
 *         &lt;element name="AppealCaseID" type="{}an1..35"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PADeniedTypeForAppeal", propOrder = {
    "paCaseID",
    "appeal",
    "paNote",
    "appealCaseID"
})
public class PADeniedTypeForAppeal {

    @XmlElement(name = "PACaseID", required = true)
    protected String paCaseID;
    @XmlElement(name = "Appeal", required = true)
    protected PAAppeal appeal;
    @XmlElement(name = "PANote")
    protected String paNote;
    @XmlElement(name = "AppealCaseID", required = true)
    protected String appealCaseID;

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
     * Gets the value of the appealCaseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppealCaseID() {
        return appealCaseID;
    }

    /**
     * Sets the value of the appealCaseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppealCaseID(String value) {
        this.appealCaseID = value;
    }

}
