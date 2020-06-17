
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Keresan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Keresan"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-KJQ"/&gt;
 *     &lt;enumeration value="x-KEE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Keresan")
@XmlEnum
public enum Keresan {

    @XmlEnumValue("x-KJQ")
    X_KJQ("x-KJQ"),
    @XmlEnumValue("x-KEE")
    X_KEE("x-KEE");
    private final String value;

    Keresan(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static Keresan fromValue(String v) {
        for (Keresan c: Keresan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
