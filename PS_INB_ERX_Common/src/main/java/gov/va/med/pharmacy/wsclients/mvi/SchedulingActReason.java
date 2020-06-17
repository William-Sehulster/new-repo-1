
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SchedulingActReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SchedulingActReason"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="MTG"/&gt;
 *     &lt;enumeration value="MED"/&gt;
 *     &lt;enumeration value="FIN"/&gt;
 *     &lt;enumeration value="DEC"/&gt;
 *     &lt;enumeration value="PAT"/&gt;
 *     &lt;enumeration value="PHY"/&gt;
 *     &lt;enumeration value="BLK"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SchedulingActReason")
@XmlEnum
public enum SchedulingActReason {

    MTG,
    MED,
    FIN,
    DEC,
    PAT,
    PHY,
    BLK;

    public String getValue() {
        return name();
    }

    public static SchedulingActReason fromValue(String v) {
        return valueOf(v);
    }

}
