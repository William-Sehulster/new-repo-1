
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CentralSalish.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CentralSalish"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-CLM"/&gt;
 *     &lt;enumeration value="x-LUT"/&gt;
 *     &lt;enumeration value="x-STR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CentralSalish")
@XmlEnum
public enum CentralSalish {

    @XmlEnumValue("x-CLM")
    X_CLM("x-CLM"),
    @XmlEnumValue("x-LUT")
    X_LUT("x-LUT"),
    @XmlEnumValue("x-STR")
    X_STR("x-STR");
    private final String value;

    CentralSalish(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static CentralSalish fromValue(String v) {
        for (CentralSalish c: CentralSalish.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
