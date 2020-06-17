
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInsurancePolicyCodeAutomobileByBOT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInsurancePolicyCodeAutomobileByBOT"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AUTOPOL"/&gt;
 *     &lt;enumeration value="COL"/&gt;
 *     &lt;enumeration value="UNINSMOT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInsurancePolicyCodeAutomobileByBOT")
@XmlEnum
public enum ActInsurancePolicyCodeAutomobileByBOT {

    AUTOPOL,
    COL,
    UNINSMOT;

    public String getValue() {
        return name();
    }

    public static ActInsurancePolicyCodeAutomobileByBOT fromValue(String v) {
        return valueOf(v);
    }

}
