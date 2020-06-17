
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PayorRoleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PayorRoleType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ENROLBKR"/&gt;
 *     &lt;enumeration value="TPA"/&gt;
 *     &lt;enumeration value="UMO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PayorRoleType")
@XmlEnum
public enum PayorRoleType {

    ENROLBKR,
    TPA,
    UMO;

    public String getValue() {
        return name();
    }

    public static PayorRoleType fromValue(String v) {
        return valueOf(v);
    }

}
