
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MedicationObservationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MedicationObservationType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SPLCOATING"/&gt;
 *     &lt;enumeration value="SPLCOLOR"/&gt;
 *     &lt;enumeration value="SPLIMAGE"/&gt;
 *     &lt;enumeration value="SPLIMPRINT"/&gt;
 *     &lt;enumeration value="REP_HALF_LIFE"/&gt;
 *     &lt;enumeration value="SPLSCORING"/&gt;
 *     &lt;enumeration value="SPLSHAPE"/&gt;
 *     &lt;enumeration value="SPLSIZE"/&gt;
 *     &lt;enumeration value="SPLSYMBOL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MedicationObservationType")
@XmlEnum
public enum MedicationObservationType {

    SPLCOATING,
    SPLCOLOR,
    SPLIMAGE,
    SPLIMPRINT,
    REP_HALF_LIFE,
    SPLSCORING,
    SPLSHAPE,
    SPLSIZE,
    SPLSYMBOL;

    public String getValue() {
        return name();
    }

    public static MedicationObservationType fromValue(String v) {
        return valueOf(v);
    }

}
