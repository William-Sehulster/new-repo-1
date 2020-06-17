
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationInterpretationChange.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationInterpretationChange"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *     &lt;enumeration value="W"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationInterpretationChange")
@XmlEnum
public enum ObservationInterpretationChange {

    B,
    D,
    U,
    W;

    public String getValue() {
        return name();
    }

    public static ObservationInterpretationChange fromValue(String v) {
        return valueOf(v);
    }

}
