
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleLinkRelated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleLinkRelated"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="REL"/&gt;
 *     &lt;enumeration value="IDENT"/&gt;
 *     &lt;enumeration value="DIRAUTH"/&gt;
 *     &lt;enumeration value="INDAUTH"/&gt;
 *     &lt;enumeration value="PART"/&gt;
 *     &lt;enumeration value="BACKUP"/&gt;
 *     &lt;enumeration value="REPL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleLinkRelated")
@XmlEnum
public enum RoleLinkRelated {

    REL,
    IDENT,
    DIRAUTH,
    INDAUTH,
    PART,
    BACKUP,
    REPL;

    public String getValue() {
        return name();
    }

    public static RoleLinkRelated fromValue(String v) {
        return valueOf(v);
    }

}
