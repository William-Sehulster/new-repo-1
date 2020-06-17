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
 * <p>Java class for ReasonCode9.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReasonCode9">
 *   &lt;restriction base="{}ReasonCode">
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="AB"/>
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="AF"/>
 *     &lt;enumeration value="AM"/>
 *     &lt;enumeration value="AN"/>
 *     &lt;enumeration value="AP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReasonCode9")
@XmlEnum(ReasonCode.class)
public enum ReasonCode9 {


    /**
     * Patient unknown to the Provider
     * 
     */
    AA,

    /**
     * Patient never under  Provider care
     * 
     */
    AB,

    /**
     * Patient no longer under  Provider care
     * 
     */
    AC,

    /**
     * Patient should contact Provider first
     * 
     */
    AF,

    /**
     * Patient needs appointment
     * 
     */
    AM,

    /**
     * Prescriber not associated with this practice or location.
     * 
     */
    AN,

    /**
     * Request already responded to by other means (e.g. phone or fax)
     * 
     */
    AP;

    public String value() {
        return name();
    }

    public static ReasonCode9 fromValue(String v) {
        return valueOf(v);
    }

}
