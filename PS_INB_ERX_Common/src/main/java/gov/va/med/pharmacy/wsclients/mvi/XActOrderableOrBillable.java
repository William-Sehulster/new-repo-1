
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActOrderableOrBillable.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActOrderableOrBillable"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ACCM"/&gt;
 *     &lt;enumeration value="PCPR"/&gt;
 *     &lt;enumeration value="ENC"/&gt;
 *     &lt;enumeration value="SBADM"/&gt;
 *     &lt;enumeration value="TRNS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ActOrderableOrBillable")
@XmlEnum
public enum XActOrderableOrBillable {

    ACCM,
    PCPR,
    ENC,
    SBADM,
    TRNS;

    public String getValue() {
        return name();
    }

    public static XActOrderableOrBillable fromValue(String v) {
        return valueOf(v);
    }

}
