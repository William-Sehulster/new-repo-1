
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tsamosan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Tsamosan"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-COW"/&gt;
 *     &lt;enumeration value="x-CEA"/&gt;
 *     &lt;enumeration value="x-QUN"/&gt;
 *     &lt;enumeration value="x-CJH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Tsamosan")
@XmlEnum
public enum Tsamosan {

    @XmlEnumValue("x-COW")
    X_COW("x-COW"),
    @XmlEnumValue("x-CEA")
    X_CEA("x-CEA"),
    @XmlEnumValue("x-QUN")
    X_QUN("x-QUN"),
    @XmlEnumValue("x-CJH")
    X_CJH("x-CJH");
    private final String value;

    Tsamosan(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static Tsamosan fromValue(String v) {
        for (Tsamosan c: Tsamosan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
