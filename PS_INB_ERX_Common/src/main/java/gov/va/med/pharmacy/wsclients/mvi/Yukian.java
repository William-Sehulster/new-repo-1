
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Yukian.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Yukian"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-WAO"/&gt;
 *     &lt;enumeration value="x-YUK"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Yukian")
@XmlEnum
public enum Yukian {

    @XmlEnumValue("x-WAO")
    X_WAO("x-WAO"),
    @XmlEnumValue("x-YUK")
    X_YUK("x-YUK");
    private final String value;

    Yukian(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static Yukian fromValue(String v) {
        for (Yukian c: Yukian.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
