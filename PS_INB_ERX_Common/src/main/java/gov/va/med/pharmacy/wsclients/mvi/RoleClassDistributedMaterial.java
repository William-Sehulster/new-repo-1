
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassDistributedMaterial.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassDistributedMaterial"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="DST"/&gt;
 *     &lt;enumeration value="RET"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassDistributedMaterial")
@XmlEnum
public enum RoleClassDistributedMaterial {

    DST,
    RET;

    public String getValue() {
        return name();
    }

    public static RoleClassDistributedMaterial fromValue(String v) {
        return valueOf(v);
    }

}
