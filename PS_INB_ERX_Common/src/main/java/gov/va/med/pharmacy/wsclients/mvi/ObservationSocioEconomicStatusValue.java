
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationSocioEconomicStatusValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationSocioEconomicStatusValue"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SOECSTAT"/&gt;
 *     &lt;enumeration value="ABUSE"/&gt;
 *     &lt;enumeration value="HMLESS"/&gt;
 *     &lt;enumeration value="ILGIM"/&gt;
 *     &lt;enumeration value="INCAR"/&gt;
 *     &lt;enumeration value="PROB"/&gt;
 *     &lt;enumeration value="REFUG"/&gt;
 *     &lt;enumeration value="UNEMPL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationSocioEconomicStatusValue")
@XmlEnum
public enum ObservationSocioEconomicStatusValue {

    SOECSTAT,
    ABUSE,
    HMLESS,
    ILGIM,
    INCAR,
    PROB,
    REFUG,
    UNEMPL;

    public String getValue() {
        return name();
    }

    public static ObservationSocioEconomicStatusValue fromValue(String v) {
        return valueOf(v);
    }

}
