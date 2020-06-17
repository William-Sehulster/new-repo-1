
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInvoiceOverrideCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInvoiceOverrideCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="COVGE"/&gt;
 *     &lt;enumeration value="PYRDELAY"/&gt;
 *     &lt;enumeration value="EFORM"/&gt;
 *     &lt;enumeration value="FAX"/&gt;
 *     &lt;enumeration value="GFTH"/&gt;
 *     &lt;enumeration value="LATE"/&gt;
 *     &lt;enumeration value="MANUAL"/&gt;
 *     &lt;enumeration value="ORTHO"/&gt;
 *     &lt;enumeration value="OOJ"/&gt;
 *     &lt;enumeration value="PAPER"/&gt;
 *     &lt;enumeration value="PIE"/&gt;
 *     &lt;enumeration value="REFNR"/&gt;
 *     &lt;enumeration value="REPSERV"/&gt;
 *     &lt;enumeration value="UNRELAT"/&gt;
 *     &lt;enumeration value="VERBAUTH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInvoiceOverrideCode")
@XmlEnum
public enum ActInvoiceOverrideCode {

    COVGE,
    PYRDELAY,
    EFORM,
    FAX,
    GFTH,
    LATE,
    MANUAL,
    ORTHO,
    OOJ,
    PAPER,
    PIE,
    REFNR,
    REPSERV,
    UNRELAT,
    VERBAUTH;

    public String getValue() {
        return name();
    }

    public static ActInvoiceOverrideCode fromValue(String v) {
        return valueOf(v);
    }

}
