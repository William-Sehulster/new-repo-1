
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KitEntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="KitEntityType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="KIT"/&gt;
 *     &lt;enumeration value="SYSTM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "KitEntityType")
@XmlEnum
public enum KitEntityType {

    KIT,
    SYSTM;

    public String getValue() {
        return name();
    }

    public static KitEntityType fromValue(String v) {
        return valueOf(v);
    }

}
