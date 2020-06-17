
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PulmonaryRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PulmonaryRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IPPB"/&gt;
 *     &lt;enumeration value="VENT"/&gt;
 *     &lt;enumeration value="VENTMASK"/&gt;
 *     &lt;enumeration value="ETINSTL"/&gt;
 *     &lt;enumeration value="NTT"/&gt;
 *     &lt;enumeration value="ETNEB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PulmonaryRoute")
@XmlEnum
public enum PulmonaryRoute {

    IPPB,
    VENT,
    VENTMASK,
    ETINSTL,
    NTT,
    ETNEB;

    public String getValue() {
        return name();
    }

    public static PulmonaryRoute fromValue(String v) {
        return valueOf(v);
    }

}
