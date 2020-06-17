
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntraarterialInjection.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntraarterialInjection"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IAINJ"/&gt;
 *     &lt;enumeration value="IAINJP"/&gt;
 *     &lt;enumeration value="IAINJSP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntraarterialInjection")
@XmlEnum
public enum IntraarterialInjection {

    IAINJ,
    IAINJP,
    IAINJSP;

    public String getValue() {
        return name();
    }

    public static IntraarterialInjection fromValue(String v) {
        return valueOf(v);
    }

}
