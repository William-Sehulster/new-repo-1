
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeGeneralTimingSpecification.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeGeneralTimingSpecification"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="GTS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeGeneralTimingSpecification")
@XmlEnum
public enum DataTypeGeneralTimingSpecification {

    GTS;

    public String getValue() {
        return name();
    }

    public static DataTypeGeneralTimingSpecification fromValue(String v) {
        return valueOf(v);
    }

}
