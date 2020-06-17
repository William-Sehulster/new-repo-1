
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntravenousInjection.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntravenousInjection"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IVINJ"/&gt;
 *     &lt;enumeration value="IVINJBOL"/&gt;
 *     &lt;enumeration value="IVPUSH"/&gt;
 *     &lt;enumeration value="IVRPUSH"/&gt;
 *     &lt;enumeration value="IVSPUSH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntravenousInjection")
@XmlEnum
public enum IntravenousInjection {

    IVINJ,
    IVINJBOL,
    IVPUSH,
    IVRPUSH,
    IVSPUSH;

    public String getValue() {
        return name();
    }

    public static IntravenousInjection fromValue(String v) {
        return valueOf(v);
    }

}
