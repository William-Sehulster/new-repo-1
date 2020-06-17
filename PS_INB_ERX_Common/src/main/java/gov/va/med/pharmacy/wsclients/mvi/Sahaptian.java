
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Sahaptian.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Sahaptian"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-WAR"/&gt;
 *     &lt;enumeration value="x-UMA"/&gt;
 *     &lt;enumeration value="x-WAA"/&gt;
 *     &lt;enumeration value="x-YAK"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Sahaptian")
@XmlEnum
public enum Sahaptian {

    @XmlEnumValue("x-WAR")
    X_WAR("x-WAR"),
    @XmlEnumValue("x-UMA")
    X_UMA("x-UMA"),
    @XmlEnumValue("x-WAA")
    X_WAA("x-WAA"),
    @XmlEnumValue("x-YAK")
    X_YAK("x-YAK");
    private final String value;

    Sahaptian(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static Sahaptian fromValue(String v) {
        for (Sahaptian c: Sahaptian.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
