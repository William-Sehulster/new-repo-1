
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WesternNumic.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WesternNumic"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-MON"/&gt;
 *     &lt;enumeration value="x-PAO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "WesternNumic")
@XmlEnum
public enum WesternNumic {

    @XmlEnumValue("x-MON")
    X_MON("x-MON"),
    @XmlEnumValue("x-PAO")
    X_PAO("x-PAO");
    private final String value;

    WesternNumic(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static WesternNumic fromValue(String v) {
        for (WesternNumic c: WesternNumic.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
