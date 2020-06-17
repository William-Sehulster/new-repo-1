
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassServiceDeliveryLocation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassServiceDeliveryLocation"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SDLOC"/&gt;
 *     &lt;enumeration value="DSDLOC"/&gt;
 *     &lt;enumeration value="ISDLOC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassServiceDeliveryLocation")
@XmlEnum
public enum RoleClassServiceDeliveryLocation {

    SDLOC,
    DSDLOC,
    ISDLOC;

    public String getValue() {
        return name();
    }

    public static RoleClassServiceDeliveryLocation fromValue(String v) {
        return valueOf(v);
    }

}
