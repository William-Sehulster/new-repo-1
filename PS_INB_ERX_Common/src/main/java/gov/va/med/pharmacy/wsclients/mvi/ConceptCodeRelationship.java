
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConceptCodeRelationship.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConceptCodeRelationship"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="hasPart"/&gt;
 *     &lt;enumeration value="hasSubtype"/&gt;
 *     &lt;enumeration value="smallerThan"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ConceptCodeRelationship")
@XmlEnum
public enum ConceptCodeRelationship {

    @XmlEnumValue("hasPart")
    HAS_PART("hasPart"),
    @XmlEnumValue("hasSubtype")
    HAS_SUBTYPE("hasSubtype"),
    @XmlEnumValue("smallerThan")
    SMALLER_THAN("smallerThan");
    private final String value;

    ConceptCodeRelationship(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ConceptCodeRelationship fromValue(String v) {
        for (ConceptCodeRelationship c: ConceptCodeRelationship.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
