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
 * <p>Java class for OrderCaptureMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrderCaptureMethod">
 *   &lt;restriction base="{}Code">
 *     &lt;enumeration value="EP"/>
 *     &lt;enumeration value="VT"/>
 *     &lt;enumeration value="VI"/>
 *     &lt;enumeration value="WR"/>
 *     &lt;enumeration value="TV"/>
 *     &lt;enumeration value="OM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OrderCaptureMethod")
@XmlEnum
public enum OrderCaptureMethod {


    /**
     * Entered by Prescriber - The prescribing practitioner entered the order directly into the electronic prescribing system. Includes entry from a remote location (e.g., via a web interface).
     * 
     */
    EP,

    /**
     * Verbal Telephone Order - The order was received by telephone from the prescriber and entered into the prescribing system by the receiving party.
     * 
     */
    VT,

    /**
     * Verbal In-Person Order - The order was received verbally from the prescriber and entered into the prescribing system by the receiving party. Order was received in-person. (Note: this value is also used for orders received by telephone if the prescribing system is unable to track telephone orders separately from other verbal orders entered by the receiving party).
     * 
     */
    VI,

    /**
     * Written Order - The order was written by the prescriber and entered by another party into the electronic prescribing system. Includes faxed orders.
     * 
     */
    WR,

    /**
     * Transcribed Verbal Order - The order was given verbally or by telephone to one party, but was entered into the electronic prescribing system by another party.
     * 
     */
    TV,

    /**
     * Other Method - The order was captured by another method different from those implied or specified.
     * 
     */
    OM;

    public String value() {
        return name();
    }

    public static OrderCaptureMethod fromValue(String v) {
        return valueOf(v);
    }

}
