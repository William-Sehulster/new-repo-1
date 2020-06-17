
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OralInhalation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OralInhalation"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ORINHL"/&gt;
 *     &lt;enumeration value="ORIFINHL"/&gt;
 *     &lt;enumeration value="REBREATH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OralInhalation")
@XmlEnum
public enum OralInhalation {

    ORINHL,
    ORIFINHL,
    REBREATH;

    public String getValue() {
        return name();
    }

    public static OralInhalation fromValue(String v) {
        return valueOf(v);
    }

}
