
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Homeless.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Homeless"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="HL"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="T"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Homeless")
@XmlEnum
public enum Homeless {

    HL,
    M,
    T;

    public String getValue() {
        return name();
    }

    public static Homeless fromValue(String v) {
        return valueOf(v);
    }

}
