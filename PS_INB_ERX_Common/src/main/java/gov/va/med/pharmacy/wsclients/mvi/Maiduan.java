
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Maiduan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Maiduan"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-NSZ"/&gt;
 *     &lt;enumeration value="x-NMU"/&gt;
 *     &lt;enumeration value="x-MAI"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Maiduan")
@XmlEnum
public enum Maiduan {

    @XmlEnumValue("x-NSZ")
    X_NSZ("x-NSZ"),
    @XmlEnumValue("x-NMU")
    X_NMU("x-NMU"),
    @XmlEnumValue("x-MAI")
    X_MAI("x-MAI");
    private final String value;

    Maiduan(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static Maiduan fromValue(String v) {
        for (Maiduan c: Maiduan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
