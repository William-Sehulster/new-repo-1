
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_EncounterAdmissionUrgency.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_EncounterAdmissionUrgency"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EL"/&gt;
 *     &lt;enumeration value="EM"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *     &lt;enumeration value="UR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_EncounterAdmissionUrgency")
@XmlEnum
public enum XEncounterAdmissionUrgency {

    EL,
    EM,
    R,
    UR;

    public String getValue() {
        return name();
    }

    public static XEncounterAdmissionUrgency fromValue(String v) {
        return valueOf(v);
    }

}
