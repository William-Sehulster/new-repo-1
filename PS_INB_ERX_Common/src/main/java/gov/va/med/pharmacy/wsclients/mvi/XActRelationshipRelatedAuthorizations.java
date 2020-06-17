
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActRelationshipRelatedAuthorizations.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActRelationshipRelatedAuthorizations"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AUTH"/&gt;
 *     &lt;enumeration value="REFR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ActRelationshipRelatedAuthorizations")
@XmlEnum
public enum XActRelationshipRelatedAuthorizations {

    AUTH,
    REFR;

    public String getValue() {
        return name();
    }

    public static XActRelationshipRelatedAuthorizations fromValue(String v) {
        return valueOf(v);
    }

}
