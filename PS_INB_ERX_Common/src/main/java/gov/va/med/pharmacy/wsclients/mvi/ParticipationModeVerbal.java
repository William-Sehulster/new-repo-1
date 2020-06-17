
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationModeVerbal.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationModeVerbal"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="VERBAL"/&gt;
 *     &lt;enumeration value="DICTATE"/&gt;
 *     &lt;enumeration value="FACE"/&gt;
 *     &lt;enumeration value="PHONE"/&gt;
 *     &lt;enumeration value="VIDEOCONF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParticipationModeVerbal")
@XmlEnum
public enum ParticipationModeVerbal {

    VERBAL,
    DICTATE,
    FACE,
    PHONE,
    VIDEOCONF;

    public String getValue() {
        return name();
    }

    public static ParticipationModeVerbal fromValue(String v) {
        return valueOf(v);
    }

}
