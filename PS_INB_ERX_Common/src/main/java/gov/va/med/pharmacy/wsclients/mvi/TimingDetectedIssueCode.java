
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimingDetectedIssueCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TimingDetectedIssueCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="TIME"/&gt;
 *     &lt;enumeration value="ENDLATE"/&gt;
 *     &lt;enumeration value="STRTLATE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TimingDetectedIssueCode")
@XmlEnum
public enum TimingDetectedIssueCode {

    TIME,
    ENDLATE,
    STRTLATE;

    public String getValue() {
        return name();
    }

    public static TimingDetectedIssueCode fromValue(String v) {
        return valueOf(v);
    }

}
