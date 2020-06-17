
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeIntervalOfRealNumbers.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeIntervalOfRealNumbers"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IVL&lt;REAL&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeIntervalOfRealNumbers")
@XmlEnum
public enum DataTypeIntervalOfRealNumbers {

    @XmlEnumValue("IVL<REAL>")
    IVL_REAL("IVL<REAL>");
    private final String value;

    DataTypeIntervalOfRealNumbers(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static DataTypeIntervalOfRealNumbers fromValue(String v) {
        for (DataTypeIntervalOfRealNumbers c: DataTypeIntervalOfRealNumbers.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
