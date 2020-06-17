
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntracardiacInjection.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntracardiacInjection"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ICARDINJ"/&gt;
 *     &lt;enumeration value="ICARINJP"/&gt;
 *     &lt;enumeration value="ICARDINJRP"/&gt;
 *     &lt;enumeration value="ICARDINJSP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntracardiacInjection")
@XmlEnum
public enum IntracardiacInjection {

    ICARDINJ,
    ICARINJP,
    ICARDINJRP,
    ICARDINJSP;

    public String getValue() {
        return name();
    }

    public static IntracardiacInjection fromValue(String v) {
        return valueOf(v);
    }

}
