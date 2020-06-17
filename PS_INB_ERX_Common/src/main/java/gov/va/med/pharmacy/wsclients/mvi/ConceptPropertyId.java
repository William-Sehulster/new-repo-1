
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConceptPropertyId.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConceptPropertyId"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="OID"/&gt;
 *     &lt;enumeration value="_ValueSetPropertyId"/&gt;
 *     &lt;enumeration value="appliesTo"/&gt;
 *     &lt;enumeration value="howApplies"/&gt;
 *     &lt;enumeration value="inverseRelationship"/&gt;
 *     &lt;enumeration value="openIssue"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ConceptPropertyId")
@XmlEnum
public enum ConceptPropertyId {

    OID("OID"),
    @XmlEnumValue("_ValueSetPropertyId")
    VALUE_SET_PROPERTY_ID("_ValueSetPropertyId"),
    @XmlEnumValue("appliesTo")
    APPLIES_TO("appliesTo"),
    @XmlEnumValue("howApplies")
    HOW_APPLIES("howApplies"),
    @XmlEnumValue("inverseRelationship")
    INVERSE_RELATIONSHIP("inverseRelationship"),
    @XmlEnumValue("openIssue")
    OPEN_ISSUE("openIssue");
    private final String value;

    ConceptPropertyId(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ConceptPropertyId fromValue(String v) {
        for (ConceptPropertyId c: ConceptPropertyId.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
