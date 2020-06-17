
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActPaymentCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActPaymentCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ACH"/&gt;
 *     &lt;enumeration value="CHK"/&gt;
 *     &lt;enumeration value="DDP"/&gt;
 *     &lt;enumeration value="NON"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActPaymentCode")
@XmlEnum
public enum ActPaymentCode {

    ACH,
    CHK,
    DDP,
    NON;

    public String getValue() {
        return name();
    }

    public static ActPaymentCode fromValue(String v) {
        return valueOf(v);
    }

}
