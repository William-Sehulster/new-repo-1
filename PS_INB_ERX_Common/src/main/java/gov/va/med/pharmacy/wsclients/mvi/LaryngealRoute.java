
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LaryngealRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LaryngealRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="LARYNGINSTIL"/&gt;
 *     &lt;enumeration value="LARYNGTA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LaryngealRoute")
@XmlEnum
public enum LaryngealRoute {

    LARYNGINSTIL,
    LARYNGTA;

    public String getValue() {
        return name();
    }

    public static LaryngealRoute fromValue(String v) {
        return valueOf(v);
    }

}
