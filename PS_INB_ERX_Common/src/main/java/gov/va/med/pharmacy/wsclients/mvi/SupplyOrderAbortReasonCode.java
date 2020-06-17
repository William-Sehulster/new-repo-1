
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SupplyOrderAbortReasonCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SupplyOrderAbortReasonCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IMPROV"/&gt;
 *     &lt;enumeration value="INTOL"/&gt;
 *     &lt;enumeration value="NEWSTR"/&gt;
 *     &lt;enumeration value="NEWTHER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SupplyOrderAbortReasonCode")
@XmlEnum
public enum SupplyOrderAbortReasonCode {

    IMPROV,
    INTOL,
    NEWSTR,
    NEWTHER;

    public String getValue() {
        return name();
    }

    public static SupplyOrderAbortReasonCode fromValue(String v) {
        return valueOf(v);
    }

}
