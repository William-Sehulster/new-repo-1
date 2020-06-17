
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActSpecObsInterferenceCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActSpecObsInterferenceCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="INTFR"/&gt;
 *     &lt;enumeration value="FIBRIN"/&gt;
 *     &lt;enumeration value="HEMOLYSIS"/&gt;
 *     &lt;enumeration value="ICTERUS"/&gt;
 *     &lt;enumeration value="LIPEMIA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActSpecObsInterferenceCode")
@XmlEnum
public enum ActSpecObsInterferenceCode {

    INTFR,
    FIBRIN,
    HEMOLYSIS,
    ICTERUS,
    LIPEMIA;

    public String getValue() {
        return name();
    }

    public static ActSpecObsInterferenceCode fromValue(String v) {
        return valueOf(v);
    }

}
