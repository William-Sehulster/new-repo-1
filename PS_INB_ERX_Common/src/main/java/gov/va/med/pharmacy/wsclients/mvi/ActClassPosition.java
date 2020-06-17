
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassPosition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassPosition"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="POS"/&gt;
 *     &lt;enumeration value="POSACC"/&gt;
 *     &lt;enumeration value="POSCOORD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActClassPosition")
@XmlEnum
public enum ActClassPosition {

    POS,
    POSACC,
    POSCOORD;

    public String getValue() {
        return name();
    }

    public static ActClassPosition fromValue(String v) {
        return valueOf(v);
    }

}
