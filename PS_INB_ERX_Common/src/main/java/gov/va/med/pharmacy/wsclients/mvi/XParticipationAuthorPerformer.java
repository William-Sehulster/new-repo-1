
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ParticipationAuthorPerformer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ParticipationAuthorPerformer"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AUT"/&gt;
 *     &lt;enumeration value="PRF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ParticipationAuthorPerformer")
@XmlEnum
public enum XParticipationAuthorPerformer {

    AUT,
    PRF;

    public String getValue() {
        return name();
    }

    public static XParticipationAuthorPerformer fromValue(String v) {
        return valueOf(v);
    }

}
