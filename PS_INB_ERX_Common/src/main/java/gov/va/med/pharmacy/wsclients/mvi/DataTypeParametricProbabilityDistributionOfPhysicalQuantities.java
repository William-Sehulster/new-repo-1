
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeParametricProbabilityDistributionOfPhysicalQuantities.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeParametricProbabilityDistributionOfPhysicalQuantities"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PPD&lt;PQ&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeParametricProbabilityDistributionOfPhysicalQuantities")
@XmlEnum
public enum DataTypeParametricProbabilityDistributionOfPhysicalQuantities {

    @XmlEnumValue("PPD<PQ>")
    PPD_PQ("PPD<PQ>");
    private final String value;

    DataTypeParametricProbabilityDistributionOfPhysicalQuantities(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static DataTypeParametricProbabilityDistributionOfPhysicalQuantities fromValue(String v) {
        for (DataTypeParametricProbabilityDistributionOfPhysicalQuantities c: DataTypeParametricProbabilityDistributionOfPhysicalQuantities.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
