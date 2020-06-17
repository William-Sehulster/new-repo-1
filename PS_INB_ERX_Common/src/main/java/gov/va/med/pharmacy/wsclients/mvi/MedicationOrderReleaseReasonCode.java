
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MedicationOrderReleaseReasonCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MedicationOrderReleaseReasonCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="HOLDINAP"/&gt;
 *     &lt;enumeration value="HOLDDONE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MedicationOrderReleaseReasonCode")
@XmlEnum
public enum MedicationOrderReleaseReasonCode {

    HOLDINAP,
    HOLDDONE;

    public String getValue() {
        return name();
    }

    public static MedicationOrderReleaseReasonCode fromValue(String v) {
        return valueOf(v);
    }

}
