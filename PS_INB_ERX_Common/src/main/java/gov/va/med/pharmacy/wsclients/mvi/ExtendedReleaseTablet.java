
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtendedReleaseTablet.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExtendedReleaseTablet"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ERTAB"/&gt;
 *     &lt;enumeration value="ERTAB12"/&gt;
 *     &lt;enumeration value="ERTAB24"/&gt;
 *     &lt;enumeration value="ERECTAB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExtendedReleaseTablet")
@XmlEnum
public enum ExtendedReleaseTablet {

    ERTAB("ERTAB"),
    @XmlEnumValue("ERTAB12")
    ERTAB_12("ERTAB12"),
    @XmlEnumValue("ERTAB24")
    ERTAB_24("ERTAB24"),
    ERECTAB("ERECTAB");
    private final String value;

    ExtendedReleaseTablet(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ExtendedReleaseTablet fromValue(String v) {
        for (ExtendedReleaseTablet c: ExtendedReleaseTablet.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
