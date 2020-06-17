
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NasalInhalation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NasalInhalation"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="NASINHL"/&gt;
 *     &lt;enumeration value="NASINHLC"/&gt;
 *     &lt;enumeration value="NP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NasalInhalation")
@XmlEnum
public enum NasalInhalation {

    NASINHL,
    NASINHLC,
    NP;

    public String getValue() {
        return name();
    }

    public static NasalInhalation fromValue(String v) {
        return valueOf(v);
    }

}
