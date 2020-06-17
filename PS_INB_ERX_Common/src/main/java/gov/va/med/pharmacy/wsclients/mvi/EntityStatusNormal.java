
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityStatusNormal.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityStatusNormal"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="normal"/&gt;
 *     &lt;enumeration value="active"/&gt;
 *     &lt;enumeration value="inactive"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EntityStatusNormal")
@XmlEnum
public enum EntityStatusNormal {

    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("active")
    ACTIVE("active"),
    @XmlEnumValue("inactive")
    INACTIVE("inactive");
    private final String value;

    EntityStatusNormal(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static EntityStatusNormal fromValue(String v) {
        for (EntityStatusNormal c: EntityStatusNormal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
