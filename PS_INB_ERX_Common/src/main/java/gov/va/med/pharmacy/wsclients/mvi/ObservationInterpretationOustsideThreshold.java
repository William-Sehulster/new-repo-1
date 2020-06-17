
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationInterpretationOustsideThreshold.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationInterpretationOustsideThreshold"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EX"/&gt;
 *     &lt;enumeration value="HX"/&gt;
 *     &lt;enumeration value="LX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationInterpretationOustsideThreshold")
@XmlEnum
public enum ObservationInterpretationOustsideThreshold {

    EX,
    HX,
    LX;

    public String getValue() {
        return name();
    }

    public static ObservationInterpretationOustsideThreshold fromValue(String v) {
        return valueOf(v);
    }

}
