
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassInvestigationSubject.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassInvestigationSubject"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="INVSBJ"/&gt;
 *     &lt;enumeration value="CASEBJ"/&gt;
 *     &lt;enumeration value="RESBJ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassInvestigationSubject")
@XmlEnum
public enum RoleClassInvestigationSubject {

    INVSBJ,
    CASEBJ,
    RESBJ;

    public String getValue() {
        return name();
    }

    public static RoleClassInvestigationSubject fromValue(String v) {
        return valueOf(v);
    }

}
