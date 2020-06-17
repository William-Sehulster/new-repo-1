
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterizedDataTypeAnnotated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParameterizedDataTypeAnnotated"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ANT&lt;T&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParameterizedDataTypeAnnotated")
@XmlEnum
public enum ParameterizedDataTypeAnnotated {

    @XmlEnumValue("ANT<T>")
    ANT_T("ANT<T>");
    private final String value;

    ParameterizedDataTypeAnnotated(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ParameterizedDataTypeAnnotated fromValue(String v) {
        for (ParameterizedDataTypeAnnotated c: ParameterizedDataTypeAnnotated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
