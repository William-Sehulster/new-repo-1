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
 * <p>Java class for ReasonCode8.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReasonCode8">
 *   &lt;restriction base="{}ReasonCode">
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="AB"/>
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="BB"/>
 *     &lt;enumeration value="BC"/>
 *     &lt;enumeration value="BD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReasonCode8")
@XmlEnum(ReasonCode.class)
public enum ReasonCode8 {


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
     * No Information Available
     * 
     */
    BB,

    /**
     * Not Authorized to Release
     * 
     */
    BC,

    /**
     * Unable to send Response in Format Requested
     * 
     */
    BD;

    public String value() {
        return name();
    }

    public static ReasonCode8 fromValue(String v) {
        return valueOf(v);
    }

}
