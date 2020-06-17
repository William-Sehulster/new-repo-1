
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LanguageAbilityMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LanguageAbilityMode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ESGN"/&gt;
 *     &lt;enumeration value="ESP"/&gt;
 *     &lt;enumeration value="EWR"/&gt;
 *     &lt;enumeration value="RSGN"/&gt;
 *     &lt;enumeration value="RSP"/&gt;
 *     &lt;enumeration value="RWR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LanguageAbilityMode")
@XmlEnum
public enum LanguageAbilityMode {

    ESGN,
    ESP,
    EWR,
    RSGN,
    RSP,
    RWR;

    public String getValue() {
        return name();
    }

    public static LanguageAbilityMode fromValue(String v) {
        return valueOf(v);
    }

}
