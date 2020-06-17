
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cupan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Cupan"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-CHL"/&gt;
 *     &lt;enumeration value="x-CUP"/&gt;
 *     &lt;enumeration value="x-LUI"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Cupan")
@XmlEnum
public enum Cupan {

    @XmlEnumValue("x-CHL")
    X_CHL("x-CHL"),
    @XmlEnumValue("x-CUP")
    X_CUP("x-CUP"),
    @XmlEnumValue("x-LUI")
    X_LUI("x-LUI");
    private final String value;

    Cupan(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static Cupan fromValue(String v) {
        for (Cupan c: Cupan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
