
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActNoImmunizationReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActNoImmunizationReason"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IMMUNE"/&gt;
 *     &lt;enumeration value="MEDPREC"/&gt;
 *     &lt;enumeration value="OSTOCK"/&gt;
 *     &lt;enumeration value="PATOBJ"/&gt;
 *     &lt;enumeration value="PHILISOP"/&gt;
 *     &lt;enumeration value="RELIG"/&gt;
 *     &lt;enumeration value="VACEFF"/&gt;
 *     &lt;enumeration value="VACSAF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActNoImmunizationReason")
@XmlEnum
public enum ActNoImmunizationReason {

    IMMUNE,
    MEDPREC,
    OSTOCK,
    PATOBJ,
    PHILISOP,
    RELIG,
    VACEFF,
    VACSAF;

    public String getValue() {
        return name();
    }

    public static ActNoImmunizationReason fromValue(String v) {
        return valueOf(v);
    }

}
