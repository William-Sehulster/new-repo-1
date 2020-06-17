
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChiwereWinnebago.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ChiwereWinnebago"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-IOW"/&gt;
 *     &lt;enumeration value="x-WIN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ChiwereWinnebago")
@XmlEnum
public enum ChiwereWinnebago {

    @XmlEnumValue("x-IOW")
    X_IOW("x-IOW"),
    @XmlEnumValue("x-WIN")
    X_WIN("x-WIN");
    private final String value;

    ChiwereWinnebago(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ChiwereWinnebago fromValue(String v) {
        for (ChiwereWinnebago c: ChiwereWinnebago.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
