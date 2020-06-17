
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeSetOfPhysicalQuantities.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeSetOfPhysicalQuantities"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SET&lt;PQ&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeSetOfPhysicalQuantities")
@XmlEnum
public enum DataTypeSetOfPhysicalQuantities {

    @XmlEnumValue("SET<PQ>")
    SET_PQ("SET<PQ>");
    private final String value;

    DataTypeSetOfPhysicalQuantities(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static DataTypeSetOfPhysicalQuantities fromValue(String v) {
        for (DataTypeSetOfPhysicalQuantities c: DataTypeSetOfPhysicalQuantities.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
