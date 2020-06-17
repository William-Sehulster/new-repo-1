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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommunicationNumbersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommunicationNumbersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrimaryTelephone" type="{}PhoneType"/>
 *         &lt;element name="Beeper" type="{}PhoneType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ElectronicMail" type="{}MailAddressType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Fax" type="{}PhoneType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="HomeTelephone" type="{}PhoneType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="WorkTelephone" type="{}PhoneType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OtherTelephone" type="{}PhoneType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DirectAddress" type="{}an1..254" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunicationNumbersType", propOrder = {
    "primaryTelephone",
    "beeper",
    "electronicMail",
    "fax",
    "homeTelephone",
    "workTelephone",
    "otherTelephone",
    "directAddress"
})
@XmlSeeAlso({
    CommunicationNumbersTypeRestricted.class
})
public class CommunicationNumbersType {

    @XmlElement(name = "PrimaryTelephone", required = true)
    protected PhoneType primaryTelephone;
    @XmlElement(name = "Beeper")
    protected List<PhoneType> beeper;
    @XmlElement(name = "ElectronicMail")
    protected List<String> electronicMail;
    @XmlElement(name = "Fax")
    protected List<PhoneType> fax;
    @XmlElement(name = "HomeTelephone")
    protected List<PhoneType> homeTelephone;
    @XmlElement(name = "WorkTelephone")
    protected List<PhoneType> workTelephone;
    @XmlElement(name = "OtherTelephone")
    protected List<PhoneType> otherTelephone;
    @XmlElement(name = "DirectAddress")
    protected String directAddress;

    /**
     * Gets the value of the primaryTelephone property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneType }
     *     
     */
    public PhoneType getPrimaryTelephone() {
        return primaryTelephone;
    }

    /**
     * Sets the value of the primaryTelephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneType }
     *     
     */
    public void setPrimaryTelephone(PhoneType value) {
        this.primaryTelephone = value;
    }

    /**
     * Gets the value of the beeper property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beeper property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeeper().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneType }
     * 
     * 
     */
    public List<PhoneType> getBeeper() {
        if (beeper == null) {
            beeper = new ArrayList<PhoneType>();
        }
        return this.beeper;
    }

    /**
     * Gets the value of the electronicMail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the electronicMail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElectronicMail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getElectronicMail() {
        if (electronicMail == null) {
            electronicMail = new ArrayList<String>();
        }
        return this.electronicMail;
    }

    /**
     * Gets the value of the fax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneType }
     * 
     * 
     */
    public List<PhoneType> getFax() {
        if (fax == null) {
            fax = new ArrayList<PhoneType>();
        }
        return this.fax;
    }

    /**
     * Gets the value of the homeTelephone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the homeTelephone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHomeTelephone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneType }
     * 
     * 
     */
    public List<PhoneType> getHomeTelephone() {
        if (homeTelephone == null) {
            homeTelephone = new ArrayList<PhoneType>();
        }
        return this.homeTelephone;
    }

    /**
     * Gets the value of the workTelephone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workTelephone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkTelephone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneType }
     * 
     * 
     */
    public List<PhoneType> getWorkTelephone() {
        if (workTelephone == null) {
            workTelephone = new ArrayList<PhoneType>();
        }
        return this.workTelephone;
    }

    /**
     * Gets the value of the otherTelephone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherTelephone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherTelephone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneType }
     * 
     * 
     */
    public List<PhoneType> getOtherTelephone() {
        if (otherTelephone == null) {
            otherTelephone = new ArrayList<PhoneType>();
        }
        return this.otherTelephone;
    }

    /**
     * Gets the value of the directAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirectAddress() {
        return directAddress;
    }

    /**
     * Sets the value of the directAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectAddress(String value) {
        this.directAddress = value;
    }

}
