
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EasternMiwok.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EasternMiwok"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-CSM"/&gt;
 *     &lt;enumeration value="x-NSQ"/&gt;
 *     &lt;enumeration value="x-PMW"/&gt;
 *     &lt;enumeration value="x-SKD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EasternMiwok")
@XmlEnum
public enum EasternMiwok {

    @XmlEnumValue("x-CSM")
    X_CSM("x-CSM"),
    @XmlEnumValue("x-NSQ")
    X_NSQ("x-NSQ"),
    @XmlEnumValue("x-PMW")
    X_PMW("x-PMW"),
    @XmlEnumValue("x-SKD")
    X_SKD("x-SKD");
    private final String value;

    EasternMiwok(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static EasternMiwok fromValue(String v) {
        for (EasternMiwok c: EasternMiwok.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
