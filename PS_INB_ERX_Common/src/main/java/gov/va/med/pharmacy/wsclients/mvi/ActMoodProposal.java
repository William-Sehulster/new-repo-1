
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMoodProposal.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMoodProposal"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PRP"/&gt;
 *     &lt;enumeration value="RMD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActMoodProposal")
@XmlEnum
public enum ActMoodProposal {

    PRP,
    RMD;

    public String getValue() {
        return name();
    }

    public static ActMoodProposal fromValue(String v) {
        return valueOf(v);
    }

}
