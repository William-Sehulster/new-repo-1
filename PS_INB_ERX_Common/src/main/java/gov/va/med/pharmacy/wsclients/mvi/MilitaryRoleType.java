
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MilitaryRoleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MilitaryRoleType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="MIL"/&gt;
 *     &lt;enumeration value="ACTMIL"/&gt;
 *     &lt;enumeration value="RETMIL"/&gt;
 *     &lt;enumeration value="VET"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MilitaryRoleType")
@XmlEnum
public enum MilitaryRoleType {

    MIL,
    ACTMIL,
    RETMIL,
    VET;

    public String getValue() {
        return name();
    }

    public static MilitaryRoleType fromValue(String v) {
        return valueOf(v);
    }

}
