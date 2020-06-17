
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UrethralRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UrethralRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="URETHINJ"/&gt;
 *     &lt;enumeration value="URETHINS"/&gt;
 *     &lt;enumeration value="URETHSUP"/&gt;
 *     &lt;enumeration value="URETHINSTL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "UrethralRoute")
@XmlEnum
public enum UrethralRoute {

    URETHINJ,
    URETHINS,
    URETHSUP,
    URETHINSTL;

    public String getValue() {
        return name();
    }

    public static UrethralRoute fromValue(String v) {
        return valueOf(v);
    }

}
