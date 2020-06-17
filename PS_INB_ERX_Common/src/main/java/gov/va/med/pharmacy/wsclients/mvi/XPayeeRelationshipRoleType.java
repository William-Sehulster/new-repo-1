
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_PayeeRelationshipRoleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_PayeeRelationshipRoleType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="FM"/&gt;
 *     &lt;enumeration value="GT"/&gt;
 *     &lt;enumeration value="PT"/&gt;
 *     &lt;enumeration value="PH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_PayeeRelationshipRoleType")
@XmlEnum
public enum XPayeeRelationshipRoleType {

    FM,
    GT,
    PT,
    PH;

    public String getValue() {
        return name();
    }

    public static XPayeeRelationshipRoleType fromValue(String v) {
        return valueOf(v);
    }

}
