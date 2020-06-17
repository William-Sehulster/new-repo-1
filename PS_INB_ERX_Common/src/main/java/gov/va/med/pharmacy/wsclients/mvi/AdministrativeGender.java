
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdministrativeGender.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdministrativeGender"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="UN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AdministrativeGender")
@XmlEnum
public enum AdministrativeGender {

    F,
    M,
    UN;

    public String getValue() {
        return name();
    }

    public static AdministrativeGender fromValue(String v) {
        return valueOf(v);
    }

}
