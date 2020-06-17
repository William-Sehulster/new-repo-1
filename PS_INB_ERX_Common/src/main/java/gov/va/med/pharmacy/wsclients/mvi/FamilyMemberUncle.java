
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FamilyMemberUncle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FamilyMemberUncle"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="UNCLE"/&gt;
 *     &lt;enumeration value="MUNCLE"/&gt;
 *     &lt;enumeration value="PUNCLE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FamilyMemberUncle")
@XmlEnum
public enum FamilyMemberUncle {

    UNCLE,
    MUNCLE,
    PUNCLE;

    public String getValue() {
        return name();
    }

    public static FamilyMemberUncle fromValue(String v) {
        return valueOf(v);
    }

}
