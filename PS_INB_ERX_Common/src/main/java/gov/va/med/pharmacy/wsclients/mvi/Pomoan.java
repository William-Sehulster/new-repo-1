
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Pomoan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Pomoan"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-POO"/&gt;
 *     &lt;enumeration value="x-KJU"/&gt;
 *     &lt;enumeration value="x-PEF"/&gt;
 *     &lt;enumeration value="x-PEO"/&gt;
 *     &lt;enumeration value="x-PEQ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Pomoan")
@XmlEnum
public enum Pomoan {

    @XmlEnumValue("x-POO")
    X_POO("x-POO"),
    @XmlEnumValue("x-KJU")
    X_KJU("x-KJU"),
    @XmlEnumValue("x-PEF")
    X_PEF("x-PEF"),
    @XmlEnumValue("x-PEO")
    X_PEO("x-PEO"),
    @XmlEnumValue("x-PEQ")
    X_PEQ("x-PEQ");
    private final String value;

    Pomoan(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static Pomoan fromValue(String v) {
        for (Pomoan c: Pomoan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
