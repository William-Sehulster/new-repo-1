
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessingMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProcessingMode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="T"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ProcessingMode")
@XmlEnum
public enum ProcessingMode {

    A,
    T,
    I,
    R;

    public String getValue() {
        return name();
    }

    public static ProcessingMode fromValue(String v) {
        return valueOf(v);
    }

}
