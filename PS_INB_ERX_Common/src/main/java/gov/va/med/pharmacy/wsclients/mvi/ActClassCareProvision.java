
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassCareProvision.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassCareProvision"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PCPR"/&gt;
 *     &lt;enumeration value="ENC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActClassCareProvision")
@XmlEnum
public enum ActClassCareProvision {

    PCPR,
    ENC;

    public String getValue() {
        return name();
    }

    public static ActClassCareProvision fromValue(String v) {
        return valueOf(v);
    }

}
