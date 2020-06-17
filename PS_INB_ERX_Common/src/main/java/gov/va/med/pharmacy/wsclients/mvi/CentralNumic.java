
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CentralNumic.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CentralNumic"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-COM"/&gt;
 *     &lt;enumeration value="x-PAR"/&gt;
 *     &lt;enumeration value="x-SHH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CentralNumic")
@XmlEnum
public enum CentralNumic {

    @XmlEnumValue("x-COM")
    X_COM("x-COM"),
    @XmlEnumValue("x-PAR")
    X_PAR("x-PAR"),
    @XmlEnumValue("x-SHH")
    X_SHH("x-SHH");
    private final String value;

    CentralNumic(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static CentralNumic fromValue(String v) {
        for (CentralNumic c: CentralNumic.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
