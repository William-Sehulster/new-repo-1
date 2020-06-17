
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActTaskMedicationListReviewCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActTaskMedicationListReviewCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="MLREV"/&gt;
 *     &lt;enumeration value="MARWLREV"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActTaskMedicationListReviewCode")
@XmlEnum
public enum ActTaskMedicationListReviewCode {

    MLREV,
    MARWLREV;

    public String getValue() {
        return name();
    }

    public static ActTaskMedicationListReviewCode fromValue(String v) {
        return valueOf(v);
    }

}
