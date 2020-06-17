
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationPhysicalPerformer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationPhysicalPerformer"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PRF"/&gt;
 *     &lt;enumeration value="DIST"/&gt;
 *     &lt;enumeration value="PPRF"/&gt;
 *     &lt;enumeration value="SPRF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParticipationPhysicalPerformer")
@XmlEnum
public enum ParticipationPhysicalPerformer {

    PRF,
    DIST,
    PPRF,
    SPRF;

    public String getValue() {
        return name();
    }

    public static ParticipationPhysicalPerformer fromValue(String v) {
        return valueOf(v);
    }

}
