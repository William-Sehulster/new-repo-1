
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnderwriterParticipationFunction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnderwriterParticipationFunction"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PAYORCNTR"/&gt;
 *     &lt;enumeration value="REINS"/&gt;
 *     &lt;enumeration value="RETROCES"/&gt;
 *     &lt;enumeration value="SUBCTRT"/&gt;
 *     &lt;enumeration value="UNDERWRTNG"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "UnderwriterParticipationFunction")
@XmlEnum
public enum UnderwriterParticipationFunction {

    PAYORCNTR,
    REINS,
    RETROCES,
    SUBCTRT,
    UNDERWRTNG;

    public String getValue() {
        return name();
    }

    public static UnderwriterParticipationFunction fromValue(String v) {
        return valueOf(v);
    }

}
