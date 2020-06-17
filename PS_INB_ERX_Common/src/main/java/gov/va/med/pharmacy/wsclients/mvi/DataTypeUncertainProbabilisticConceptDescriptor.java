
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeUncertainProbabilisticConceptDescriptor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeUncertainProbabilisticConceptDescriptor"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="UVP&lt;CD&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeUncertainProbabilisticConceptDescriptor")
@XmlEnum
public enum DataTypeUncertainProbabilisticConceptDescriptor {

    @XmlEnumValue("UVP<CD>")
    UVP_CD("UVP<CD>");
    private final String value;

    DataTypeUncertainProbabilisticConceptDescriptor(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static DataTypeUncertainProbabilisticConceptDescriptor fromValue(String v) {
        for (DataTypeUncertainProbabilisticConceptDescriptor c: DataTypeUncertainProbabilisticConceptDescriptor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
