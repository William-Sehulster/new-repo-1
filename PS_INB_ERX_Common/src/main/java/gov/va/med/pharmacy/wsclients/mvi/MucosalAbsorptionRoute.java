
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MucosalAbsorptionRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MucosalAbsorptionRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IDOUDMAB"/&gt;
 *     &lt;enumeration value="ITRACHMAB"/&gt;
 *     &lt;enumeration value="SMUCMAB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MucosalAbsorptionRoute")
@XmlEnum
public enum MucosalAbsorptionRoute {

    IDOUDMAB,
    ITRACHMAB,
    SMUCMAB;

    public String getValue() {
        return name();
    }

    public static MucosalAbsorptionRoute fromValue(String v) {
        return valueOf(v);
    }

}
