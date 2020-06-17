
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationInterpretationSusceptibility.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationInterpretationSusceptibility"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="MS"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *     &lt;enumeration value="VS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationInterpretationSusceptibility")
@XmlEnum
public enum ObservationInterpretationSusceptibility {

    I,
    MS,
    R,
    S,
    VS;

    public String getValue() {
        return name();
    }

    public static ObservationInterpretationSusceptibility fromValue(String v) {
        return valueOf(v);
    }

}
