
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelationshipConjunction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelationshipConjunction"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AND"/&gt;
 *     &lt;enumeration value="XOR"/&gt;
 *     &lt;enumeration value="OR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RelationshipConjunction")
@XmlEnum
public enum RelationshipConjunction {

    AND,
    XOR,
    OR;

    public String getValue() {
        return name();
    }

    public static RelationshipConjunction fromValue(String v) {
        return valueOf(v);
    }

}
