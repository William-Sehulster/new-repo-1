
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HL7StandardVersionCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HL7StandardVersionCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ActRelationshipExpectedSubset"/&gt;
 *     &lt;enumeration value="ActRelationshipPastSubset"/&gt;
 *     &lt;enumeration value="_ParticipationSubset"/&gt;
 *     &lt;enumeration value="FUTURE"/&gt;
 *     &lt;enumeration value="LAST"/&gt;
 *     &lt;enumeration value="NEXT"/&gt;
 *     &lt;enumeration value="FIRST"/&gt;
 *     &lt;enumeration value="FUTSUM"/&gt;
 *     &lt;enumeration value="MAX"/&gt;
 *     &lt;enumeration value="MIN"/&gt;
 *     &lt;enumeration value="RECENT"/&gt;
 *     &lt;enumeration value="PAST"/&gt;
 *     &lt;enumeration value="PREVSUM"/&gt;
 *     &lt;enumeration value="SUM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HL7StandardVersionCode")
@XmlEnum
public enum HL7StandardVersionCode {

    @XmlEnumValue("ActRelationshipExpectedSubset")
    ACT_RELATIONSHIP_EXPECTED_SUBSET("ActRelationshipExpectedSubset"),
    @XmlEnumValue("ActRelationshipPastSubset")
    ACT_RELATIONSHIP_PAST_SUBSET("ActRelationshipPastSubset"),
    @XmlEnumValue("_ParticipationSubset")
    PARTICIPATION_SUBSET("_ParticipationSubset"),
    FUTURE("FUTURE"),
    LAST("LAST"),
    NEXT("NEXT"),
    FIRST("FIRST"),
    FUTSUM("FUTSUM"),
    MAX("MAX"),
    MIN("MIN"),
    RECENT("RECENT"),
    PAST("PAST"),
    PREVSUM("PREVSUM"),
    SUM("SUM");
    private final String value;

    HL7StandardVersionCode(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static HL7StandardVersionCode fromValue(String v) {
        for (HL7StandardVersionCode c: HL7StandardVersionCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
