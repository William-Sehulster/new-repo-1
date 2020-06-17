
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterizedDataTypeBag.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParameterizedDataTypeBag"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BAG&lt;T&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParameterizedDataTypeBag")
@XmlEnum
public enum ParameterizedDataTypeBag {

    @XmlEnumValue("BAG<T>")
    BAG_T("BAG<T>");
    private final String value;

    ParameterizedDataTypeBag(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ParameterizedDataTypeBag fromValue(String v) {
        for (ParameterizedDataTypeBag c: ParameterizedDataTypeBag.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
