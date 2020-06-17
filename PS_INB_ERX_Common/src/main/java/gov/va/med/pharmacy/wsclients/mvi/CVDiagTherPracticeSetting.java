
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CVDiagTherPracticeSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CVDiagTherPracticeSetting"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CVDX"/&gt;
 *     &lt;enumeration value="CATH"/&gt;
 *     &lt;enumeration value="ECHO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CVDiagTherPracticeSetting")
@XmlEnum
public enum CVDiagTherPracticeSetting {

    CVDX,
    CATH,
    ECHO;

    public String getValue() {
        return name();
    }

    public static CVDiagTherPracticeSetting fromValue(String v) {
        return valueOf(v);
    }

}
