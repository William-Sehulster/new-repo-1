
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationInterpretationNormalityHigh.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationInterpretationNormalityHigh"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="HH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationInterpretationNormalityHigh")
@XmlEnum
public enum ObservationInterpretationNormalityHigh {

    H,
    HH;

    public String getValue() {
        return name();
    }

    public static ObservationInterpretationNormalityHigh fromValue(String v) {
        return valueOf(v);
    }

}
