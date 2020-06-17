
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationInformationRecipient.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationInformationRecipient"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IRCP"/&gt;
 *     &lt;enumeration value="REFB"/&gt;
 *     &lt;enumeration value="REFT"/&gt;
 *     &lt;enumeration value="PRCP"/&gt;
 *     &lt;enumeration value="TRC"/&gt;
 *     &lt;enumeration value="NOT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParticipationInformationRecipient")
@XmlEnum
public enum ParticipationInformationRecipient {

    IRCP,
    REFB,
    REFT,
    PRCP,
    TRC,
    NOT;

    public String getValue() {
        return name();
    }

    public static ParticipationInformationRecipient fromValue(String v) {
        return valueOf(v);
    }

}
