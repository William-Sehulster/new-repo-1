
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterizedDataTypeInterval.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParameterizedDataTypeInterval"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IVL&lt;T&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParameterizedDataTypeInterval")
@XmlEnum
public enum ParameterizedDataTypeInterval {

    @XmlEnumValue("IVL<T>")
    IVL_T("IVL<T>");
    private final String value;

    ParameterizedDataTypeInterval(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ParameterizedDataTypeInterval fromValue(String v) {
        for (ParameterizedDataTypeInterval c: ParameterizedDataTypeInterval.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
