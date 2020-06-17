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
 * <p>Java class for ReasonCode18.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReasonCode18">
 *   &lt;restriction base="{}ReasonCode">
 *     &lt;enumeration value="DF"/>
 *     &lt;enumeration value="DG"/>
 *     &lt;enumeration value="DH"/>
 *     &lt;enumeration value="FT"/>
 *     &lt;enumeration value="FV"/>
 *     &lt;enumeration value="GA"/>
 *     &lt;enumeration value="GB"/>
 *     &lt;enumeration value="GC"/>
 *     &lt;enumeration value="GD"/>
 *     &lt;enumeration value="GE"/>
 *     &lt;enumeration value="GF"/>
 *     &lt;enumeration value="GG"/>
 *     &lt;enumeration value="GH"/>
 *     &lt;enumeration value="GI"/>
 *     &lt;enumeration value="GJ"/>
 *     &lt;enumeration value="GK"/>
 *     &lt;enumeration value="GL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReasonCode18")
@XmlEnum(ReasonCode.class)
public enum ReasonCode18 {


    /**
     * Generic Substitution � A modification of the product prescribed to a generic equivalent.
     * 
     */
    DF,

    /**
     * Therapeutic Interchange/Substitution � A modification of the product prescribed to a preferred product choice.
     * 
     */
    DG,

    /**
     * Profile Medication � medication appropriate for administration, not dispensed by pharmacy at this time.
     * 
     */
    DH,

    /**
     * The medication presscribed is available for administration from the Automated Dispensing System 
     * 
     */
    FT,

    /**
     * The medication prescribed is available for cycle fill
     * 
     */
    FV,

    /**
     * Prescriber Authorization � prescriber must confirm their state license status.
     * 
     */
    GA,

    /**
     * Prescriber Authorization � prescriber must confirm their DEA license status in prescribing state.
     * 
     */
    GB,

    /**
     * Prescriber Authorization � prescriber must confirm their DEA registration by DEA class.
     * 
     */
    GC,

    /**
     * Prescriber Authorization � prescriber must confirm their state Controlled Substance Registration license status.
     * 
     */
    GD,

    /**
     * Prescriber Authorization � prescriber must confirm their registration by state Controlled Substance Registration class.
     * 
     */
    GE,

    /**
     * Prescriber Authorization � prescriber must confirm their NADEAN license status.
     * 
     */
    GF,

    /**
     * Prescriber Authorization � prescriber must obtain/validate Type1 NPI.
     * 
     */
    GG,

    /**
     * Prescriber Authorization � prescriber must enroll/re-enroll with prescription benefit plan.
     * 
     */
    GH,

    /**
     * Prescriber Authorization � prescriber must confirm prescriptive authority criteria for prescribed medication is met.
     * 
     */
    GI,

    /**
     * Prescriber Authorization � prescriber must enroll/re-enroll in REMS.  
     * 
     */
    GJ,

    /**
     * Patient unknown to the Provider
     * 
     */
    GK,

    /**
     * Prescriber Authorization � prescriber must obtain/validate their supervising prescriber.
     * 
     */
    GL;

    public String value() {
        return name();
    }

    public static ReasonCode18 fromValue(String v) {
        return valueOf(v);
    }

}
