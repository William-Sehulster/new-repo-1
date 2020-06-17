
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_EncounterPerformerParticipation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_EncounterPerformerParticipation"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CON"/&gt;
 *     &lt;enumeration value="PRF"/&gt;
 *     &lt;enumeration value="SPRF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_EncounterPerformerParticipation")
@XmlEnum
public enum XEncounterPerformerParticipation {

    CON,
    PRF,
    SPRF;

    public String getValue() {
        return name();
    }

    public static XEncounterPerformerParticipation fromValue(String v) {
        return valueOf(v);
    }

}
