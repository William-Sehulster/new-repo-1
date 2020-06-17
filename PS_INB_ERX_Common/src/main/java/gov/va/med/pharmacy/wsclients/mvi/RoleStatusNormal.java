
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleStatusNormal.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleStatusNormal"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="normal"/&gt;
 *     &lt;enumeration value="active"/&gt;
 *     &lt;enumeration value="cancelled"/&gt;
 *     &lt;enumeration value="pending"/&gt;
 *     &lt;enumeration value="suspended"/&gt;
 *     &lt;enumeration value="terminated"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleStatusNormal")
@XmlEnum
public enum RoleStatusNormal {

    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("active")
    ACTIVE("active"),
    @XmlEnumValue("cancelled")
    CANCELLED("cancelled"),
    @XmlEnumValue("pending")
    PENDING("pending"),
    @XmlEnumValue("suspended")
    SUSPENDED("suspended"),
    @XmlEnumValue("terminated")
    TERMINATED("terminated");
    private final String value;

    RoleStatusNormal(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static RoleStatusNormal fromValue(String v) {
        for (RoleStatusNormal c: RoleStatusNormal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
