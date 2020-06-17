
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TracheostomyRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TracheostomyRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="TRACH"/&gt;
 *     &lt;enumeration value="TRACHINSTL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TracheostomyRoute")
@XmlEnum
public enum TracheostomyRoute {

    TRACH,
    TRACHINSTL;

    public String getValue() {
        return name();
    }

    public static TracheostomyRoute fromValue(String v) {
        return valueOf(v);
    }

}
