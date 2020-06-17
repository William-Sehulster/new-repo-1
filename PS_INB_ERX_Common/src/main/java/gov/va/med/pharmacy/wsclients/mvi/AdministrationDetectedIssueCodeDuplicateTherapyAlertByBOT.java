
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdministrationDetectedIssueCodeDuplicateTherapyAlertByBOT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdministrationDetectedIssueCodeDuplicateTherapyAlertByBOT"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="DUPTHPY"/&gt;
 *     &lt;enumeration value="DUPTHPGEN"/&gt;
 *     &lt;enumeration value="DUPTHPCLS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AdministrationDetectedIssueCodeDuplicateTherapyAlertByBOT")
@XmlEnum
public enum AdministrationDetectedIssueCodeDuplicateTherapyAlertByBOT {

    DUPTHPY,
    DUPTHPGEN,
    DUPTHPCLS;

    public String getValue() {
        return name();
    }

    public static AdministrationDetectedIssueCodeDuplicateTherapyAlertByBOT fromValue(String v) {
        return valueOf(v);
    }

}
