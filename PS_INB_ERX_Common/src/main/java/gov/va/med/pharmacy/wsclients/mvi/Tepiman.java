
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tepiman.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Tepiman"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-PAP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Tepiman")
@XmlEnum
public enum Tepiman {

    @XmlEnumValue("x-PAP")
    X_PAP("x-PAP");
    private final String value;

    Tepiman(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static Tepiman fromValue(String v) {
        for (Tepiman c: Tepiman.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
