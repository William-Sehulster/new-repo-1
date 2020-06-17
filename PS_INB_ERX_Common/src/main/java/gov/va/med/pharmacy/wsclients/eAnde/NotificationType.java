
package gov.va.med.pharmacy.wsclients.eAnde;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotificationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NotificationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PrimaryViewUpdate"/&gt;
 *     &lt;enumeration value="Link"/&gt;
 *     &lt;enumeration value="Move"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NotificationType")
@XmlEnum
public enum NotificationType {

    @XmlEnumValue("PrimaryViewUpdate")
    PRIMARY_VIEW_UPDATE("PrimaryViewUpdate"),
    @XmlEnumValue("Link")
    LINK("Link"),
    @XmlEnumValue("Move")
    MOVE("Move");
    private final String value;

    NotificationType(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static NotificationType fromValue(String v) {
        for (NotificationType c: NotificationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
