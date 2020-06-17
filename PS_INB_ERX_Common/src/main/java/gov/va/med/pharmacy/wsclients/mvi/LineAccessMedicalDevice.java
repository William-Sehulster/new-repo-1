
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LineAccessMedicalDevice.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LineAccessMedicalDevice"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="LINE"/&gt;
 *     &lt;enumeration value="IALINE"/&gt;
 *     &lt;enumeration value="IVLINE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LineAccessMedicalDevice")
@XmlEnum
public enum LineAccessMedicalDevice {

    LINE,
    IALINE,
    IVLINE;

    public String getValue() {
        return name();
    }

    public static LineAccessMedicalDevice fromValue(String v) {
        return valueOf(v);
    }

}
