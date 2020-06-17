
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InteriorSalish.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InteriorSalish"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-CRD"/&gt;
 *     &lt;enumeration value="x-COL"/&gt;
 *     &lt;enumeration value="x-FLA"/&gt;
 *     &lt;enumeration value="x-OKA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "InteriorSalish")
@XmlEnum
public enum InteriorSalish {

    @XmlEnumValue("x-CRD")
    X_CRD("x-CRD"),
    @XmlEnumValue("x-COL")
    X_COL("x-COL"),
    @XmlEnumValue("x-FLA")
    X_FLA("x-FLA"),
    @XmlEnumValue("x-OKA")
    X_OKA("x-OKA");
    private final String value;

    InteriorSalish(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static InteriorSalish fromValue(String v) {
        for (InteriorSalish c: InteriorSalish.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
