
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OregonAthapaskan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OregonAthapaskan"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-TOL"/&gt;
 *     &lt;enumeration value="x-TUU"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OregonAthapaskan")
@XmlEnum
public enum OregonAthapaskan {

    @XmlEnumValue("x-TOL")
    X_TOL("x-TOL"),
    @XmlEnumValue("x-TUU")
    X_TUU("x-TUU");
    private final String value;

    OregonAthapaskan(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static OregonAthapaskan fromValue(String v) {
        for (OregonAthapaskan c: OregonAthapaskan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
