
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassSupine.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassSupine"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SUP"/&gt;
 *     &lt;enumeration value="RTRD"/&gt;
 *     &lt;enumeration value="TRD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActClassSupine")
@XmlEnum
public enum ActClassSupine {

    SUP,
    RTRD,
    TRD;

    public String getValue() {
        return name();
    }

    public static ActClassSupine fromValue(String v) {
        return valueOf(v);
    }

}
