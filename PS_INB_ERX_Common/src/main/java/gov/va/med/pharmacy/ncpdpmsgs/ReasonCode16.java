//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.18 at 03:04:58 PM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReasonCode16.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReasonCode16">
 *   &lt;restriction base="{}ReasonCode">
 *     &lt;enumeration value="BJ"/>
 *     &lt;enumeration value="BL"/>
 *     &lt;enumeration value="BM"/>
 *     &lt;enumeration value="BN"/>
 *     &lt;enumeration value="BO"/>
 *     &lt;enumeration value="BP"/>
 *     &lt;enumeration value="BQ"/>
 *     &lt;enumeration value="BR"/>
 *     &lt;enumeration value="BS"/>
 *     &lt;enumeration value="BT"/>
 *     &lt;enumeration value="BV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReasonCode16")
@XmlEnum(ReasonCode.class)
public enum ReasonCode16 {


    /**
     * Out of Stock � The dispensing entity does not have sufficient quantity of the requested product to fulfill the order/prescription.
     * 
     */
    BJ,

    /**
     * Rx Received After Established Deadline � The order was not received in time for the requested shipment date.
     * 
     */
    BL,

    /**
     * Duplicate Order � More than one message for an order was received.
     * 
     */
    BM,

    /**
     * Fill Locally not filled by Central Fill Facility
     * 
     */
    BN,

    /**
     * NDC Discontinued from Formulary � Do not resend.  The NDC number requested in on the discontinued inventory list and there is not sufficient quantity of the medication requested to fulfill the order.
     * 
     */
    BO,

    /**
     * Out of Stock/Manufacturer Back Order � NDC requested is currently on back order from the manufacturer.
     * 
     */
    BP,

    /**
     * Discontinued by Manufacturer � NDC requested has been discontinued by the manufacturer.
     * 
     */
    BQ,

    /**
     * Rx Canceled by Central Fill Facility: Automation � Due to automation issues at the Central Fill Facility the Rx must be filled locally.
     * 
     */
    BR,

    /**
     * Rx Canceled by Central Fill Facility: Site Closure � Due to site closure issues at Central Fill Facility the Rx must be filled locally.
     * 
     */
    BS,

    /**
     * Drug Recalled by Manufacturer � NDC requested has been recalled by the manufacturer.
     * 
     */
    BT,

    /**
     * Pharmacy not enrolled/aligned with Central Fill Facility
     * 
     */
    BV;

    public String value() {
        return name();
    }

    public static ReasonCode16 fromValue(String v) {
        return valueOf(v);
    }

}
