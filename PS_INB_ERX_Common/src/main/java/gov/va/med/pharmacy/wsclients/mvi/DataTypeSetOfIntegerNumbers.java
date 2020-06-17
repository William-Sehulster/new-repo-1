
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeSetOfIntegerNumbers.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeSetOfIntegerNumbers"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SET&lt;INT&gt;"/&gt;
 *     &lt;enumeration value="IVL&lt;INT&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeSetOfIntegerNumbers")
@XmlEnum
public enum DataTypeSetOfIntegerNumbers {

    @XmlEnumValue("SET<INT>")
    SET_INT("SET<INT>"),
    @XmlEnumValue("IVL<INT>")
    IVL_INT("IVL<INT>");
    private final String value;

    DataTypeSetOfIntegerNumbers(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static DataTypeSetOfIntegerNumbers fromValue(String v) {
        for (DataTypeSetOfIntegerNumbers c: DataTypeSetOfIntegerNumbers.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
