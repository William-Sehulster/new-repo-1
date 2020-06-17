
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActSpecimenTransportCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActSpecimenTransportCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SSTOR"/&gt;
 *     &lt;enumeration value="STRAN"/&gt;
 *     &lt;enumeration value="SREC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActSpecimenTransportCode")
@XmlEnum
public enum ActSpecimenTransportCode {

    SSTOR,
    STRAN,
    SREC;

    public String getValue() {
        return name();
    }

    public static ActSpecimenTransportCode fromValue(String v) {
        return valueOf(v);
    }

}
