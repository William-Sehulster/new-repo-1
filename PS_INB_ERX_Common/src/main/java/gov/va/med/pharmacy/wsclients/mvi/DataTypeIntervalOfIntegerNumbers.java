
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeIntervalOfIntegerNumbers.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeIntervalOfIntegerNumbers"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IVL&lt;INT&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeIntervalOfIntegerNumbers")
@XmlEnum
public enum DataTypeIntervalOfIntegerNumbers {

    @XmlEnumValue("IVL<INT>")
    IVL_INT("IVL<INT>");
    private final String value;

    DataTypeIntervalOfIntegerNumbers(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static DataTypeIntervalOfIntegerNumbers fromValue(String v) {
        for (DataTypeIntervalOfIntegerNumbers c: DataTypeIntervalOfIntegerNumbers.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
