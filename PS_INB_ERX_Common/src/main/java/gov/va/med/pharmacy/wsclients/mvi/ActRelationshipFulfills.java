
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipFulfills.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipFulfills"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="FLFS"/&gt;
 *     &lt;enumeration value="OCCR"/&gt;
 *     &lt;enumeration value="OREF"/&gt;
 *     &lt;enumeration value="SCH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipFulfills")
@XmlEnum
public enum ActRelationshipFulfills {

    FLFS,
    OCCR,
    OREF,
    SCH;

    public String getValue() {
        return name();
    }

    public static ActRelationshipFulfills fromValue(String v) {
        return valueOf(v);
    }

}
