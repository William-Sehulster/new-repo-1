
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Palaihnihan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Palaihnihan"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-ACH"/&gt;
 *     &lt;enumeration value="x-ATW"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Palaihnihan")
@XmlEnum
public enum Palaihnihan {

    @XmlEnumValue("x-ACH")
    X_ACH("x-ACH"),
    @XmlEnumValue("x-ATW")
    X_ATW("x-ATW");
    private final String value;

    Palaihnihan(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static Palaihnihan fromValue(String v) {
        for (Palaihnihan c: Palaihnihan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
