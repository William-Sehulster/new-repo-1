
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HairRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HairRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SHAMPOO"/&gt;
 *     &lt;enumeration value="HAIR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HairRoute")
@XmlEnum
public enum HairRoute {

    SHAMPOO,
    HAIR;

    public String getValue() {
        return name();
    }

    public static HairRoute fromValue(String v) {
        return valueOf(v);
    }

}
