
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassOntologicalEquivalentEntityByBOT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassOntologicalEquivalentEntityByBOT"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EQUIV"/&gt;
 *     &lt;enumeration value="SAME"/&gt;
 *     &lt;enumeration value="SUBY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassOntologicalEquivalentEntityByBOT")
@XmlEnum
public enum RoleClassOntologicalEquivalentEntityByBOT {

    EQUIV,
    SAME,
    SUBY;

    public String getValue() {
        return name();
    }

    public static RoleClassOntologicalEquivalentEntityByBOT fromValue(String v) {
        return valueOf(v);
    }

}
