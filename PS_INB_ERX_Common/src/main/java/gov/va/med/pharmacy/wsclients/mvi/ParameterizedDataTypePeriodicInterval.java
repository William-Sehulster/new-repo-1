
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParameterizedDataTypePeriodicInterval.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParameterizedDataTypePeriodicInterval"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PIVL&lt;T&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParameterizedDataTypePeriodicInterval")
@XmlEnum
public enum ParameterizedDataTypePeriodicInterval {

    @XmlEnumValue("PIVL<T>")
    PIVL_T("PIVL<T>");
    private final String value;

    ParameterizedDataTypePeriodicInterval(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ParameterizedDataTypePeriodicInterval fromValue(String v) {
        for (ParameterizedDataTypePeriodicInterval c: ParameterizedDataTypePeriodicInterval.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
