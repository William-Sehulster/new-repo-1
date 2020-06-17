
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeNonParametricProbabilityDistribution.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeNonParametricProbabilityDistribution"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="NPPD&lt;ANY&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeNonParametricProbabilityDistribution")
@XmlEnum
public enum DataTypeNonParametricProbabilityDistribution {

    @XmlEnumValue("NPPD<ANY>")
    NPPD_ANY("NPPD<ANY>");
    private final String value;

    DataTypeNonParametricProbabilityDistribution(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static DataTypeNonParametricProbabilityDistribution fromValue(String v) {
        for (DataTypeNonParametricProbabilityDistribution c: DataTypeNonParametricProbabilityDistribution.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
