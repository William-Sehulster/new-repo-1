
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassExposureAgentCarrier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassExposureAgentCarrier"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EXPAGTCAR"/&gt;
 *     &lt;enumeration value="EXPVECTOR"/&gt;
 *     &lt;enumeration value="FOMITE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassExposureAgentCarrier")
@XmlEnum
public enum RoleClassExposureAgentCarrier {

    EXPAGTCAR,
    EXPVECTOR,
    FOMITE;

    public String getValue() {
        return name();
    }

    public static RoleClassExposureAgentCarrier fromValue(String v) {
        return valueOf(v);
    }

}
