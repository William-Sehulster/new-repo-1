
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PatientImportance.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PatientImportance"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BM"/&gt;
 *     &lt;enumeration value="FD"/&gt;
 *     &lt;enumeration value="FOR"/&gt;
 *     &lt;enumeration value="GOVT"/&gt;
 *     &lt;enumeration value="DFM"/&gt;
 *     &lt;enumeration value="SFM"/&gt;
 *     &lt;enumeration value="STF"/&gt;
 *     &lt;enumeration value="DR"/&gt;
 *     &lt;enumeration value="VIP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PatientImportance")
@XmlEnum
public enum PatientImportance {

    BM,
    FD,
    FOR,
    GOVT,
    DFM,
    SFM,
    STF,
    DR,
    VIP;

    public String getValue() {
        return name();
    }

    public static PatientImportance fromValue(String v) {
        return valueOf(v);
    }

}
