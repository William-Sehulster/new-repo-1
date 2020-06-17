
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationTargetDevice.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationTargetDevice"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="DEV"/&gt;
 *     &lt;enumeration value="NRD"/&gt;
 *     &lt;enumeration value="RDV"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParticipationTargetDevice")
@XmlEnum
public enum ParticipationTargetDevice {

    DEV,
    NRD,
    RDV;

    public String getValue() {
        return name();
    }

    public static ParticipationTargetDevice fromValue(String v) {
        return valueOf(v);
    }

}
