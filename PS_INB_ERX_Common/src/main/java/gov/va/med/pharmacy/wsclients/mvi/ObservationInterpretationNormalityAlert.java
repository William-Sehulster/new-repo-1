
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationInterpretationNormalityAlert.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationInterpretationNormalityAlert"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AA"/&gt;
 *     &lt;enumeration value="HH"/&gt;
 *     &lt;enumeration value="LL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationInterpretationNormalityAlert")
@XmlEnum
public enum ObservationInterpretationNormalityAlert {

    AA,
    HH,
    LL;

    public String getValue() {
        return name();
    }

    public static ObservationInterpretationNormalityAlert fromValue(String v) {
        return valueOf(v);
    }

}
