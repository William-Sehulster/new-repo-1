
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassNamedInsured.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassNamedInsured"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="NAMED"/&gt;
 *     &lt;enumeration value="DEPEN"/&gt;
 *     &lt;enumeration value="INDIV"/&gt;
 *     &lt;enumeration value="SUBSCR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassNamedInsured")
@XmlEnum
public enum RoleClassNamedInsured {

    NAMED,
    DEPEN,
    INDIV,
    SUBSCR;

    public String getValue() {
        return name();
    }

    public static RoleClassNamedInsured fromValue(String v) {
        return valueOf(v);
    }

}
