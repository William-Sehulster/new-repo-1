
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationIndirectTarget.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationIndirectTarget"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IND"/&gt;
 *     &lt;enumeration value="BEN"/&gt;
 *     &lt;enumeration value="CAGNT"/&gt;
 *     &lt;enumeration value="COV"/&gt;
 *     &lt;enumeration value="GUAR"/&gt;
 *     &lt;enumeration value="HLD"/&gt;
 *     &lt;enumeration value="RCV"/&gt;
 *     &lt;enumeration value="RCT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParticipationIndirectTarget")
@XmlEnum
public enum ParticipationIndirectTarget {

    IND,
    BEN,
    CAGNT,
    COV,
    GUAR,
    HLD,
    RCV,
    RCT;

    public String getValue() {
        return name();
    }

    public static ParticipationIndirectTarget fromValue(String v) {
        return valueOf(v);
    }

}
