
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipCheckpoint.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipCheckpoint"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *     &lt;enumeration value="X"/&gt;
 *     &lt;enumeration value="T"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipCheckpoint")
@XmlEnum
public enum ActRelationshipCheckpoint {

    B,
    E,
    S,
    X,
    T;

    public String getValue() {
        return name();
    }

    public static ActRelationshipCheckpoint fromValue(String v) {
        return valueOf(v);
    }

}
