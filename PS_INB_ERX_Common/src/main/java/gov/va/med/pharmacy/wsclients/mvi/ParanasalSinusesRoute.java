
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParanasalSinusesRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParanasalSinusesRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PNSINJ"/&gt;
 *     &lt;enumeration value="PNSINSTL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParanasalSinusesRoute")
@XmlEnum
public enum ParanasalSinusesRoute {

    PNSINJ,
    PNSINSTL;

    public String getValue() {
        return name();
    }

    public static ParanasalSinusesRoute fromValue(String v) {
        return valueOf(v);
    }

}
