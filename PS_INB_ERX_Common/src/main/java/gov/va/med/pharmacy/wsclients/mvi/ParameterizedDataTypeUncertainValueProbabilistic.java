
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterizedDataTypeUncertainValueProbabilistic.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParameterizedDataTypeUncertainValueProbabilistic"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="UVP&lt;T&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParameterizedDataTypeUncertainValueProbabilistic")
@XmlEnum
public enum ParameterizedDataTypeUncertainValueProbabilistic {

    @XmlEnumValue("UVP<T>")
    UVP_T("UVP<T>");
    private final String value;

    ParameterizedDataTypeUncertainValueProbabilistic(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ParameterizedDataTypeUncertainValueProbabilistic fromValue(String v) {
        for (ParameterizedDataTypeUncertainValueProbabilistic c: ParameterizedDataTypeUncertainValueProbabilistic.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
