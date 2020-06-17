
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubstanceAdminGenericSubstitution.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubstanceAdminGenericSubstitution"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="G"/&gt;
 *     &lt;enumeration value="TE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SubstanceAdminGenericSubstitution")
@XmlEnum
public enum SubstanceAdminGenericSubstitution {

    G,
    TE;

    public String getValue() {
        return name();
    }

    public static SubstanceAdminGenericSubstitution fromValue(String v) {
        return valueOf(v);
    }

}
