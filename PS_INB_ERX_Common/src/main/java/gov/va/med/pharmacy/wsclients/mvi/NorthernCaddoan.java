
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NorthernCaddoan.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NorthernCaddoan"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-ARI"/&gt;
 *     &lt;enumeration value="x-PAW"/&gt;
 *     &lt;enumeration value="x-WIC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NorthernCaddoan")
@XmlEnum
public enum NorthernCaddoan {

    @XmlEnumValue("x-ARI")
    X_ARI("x-ARI"),
    @XmlEnumValue("x-PAW")
    X_PAW("x-PAW"),
    @XmlEnumValue("x-WIC")
    X_WIC("x-WIC");
    private final String value;

    NorthernCaddoan(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static NorthernCaddoan fromValue(String v) {
        for (NorthernCaddoan c: NorthernCaddoan.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
