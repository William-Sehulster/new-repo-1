
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="NPPD&lt;IVL&lt;PQ&gt;&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities")
@XmlEnum
public enum DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities {

    @XmlEnumValue("NPPD<IVL<PQ>>")
    NPPD_IVL_PQ("NPPD<IVL<PQ>>");
    private final String value;

    DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities fromValue(String v) {
        for (DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities c: DataTypeNonParametricProbabilityDistributionOfIntervalOfPhysicalQuantities.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
