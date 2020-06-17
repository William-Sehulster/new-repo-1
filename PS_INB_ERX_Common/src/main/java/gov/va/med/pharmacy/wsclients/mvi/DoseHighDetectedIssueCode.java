
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DoseHighDetectedIssueCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DoseHighDetectedIssueCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="DOSEH"/&gt;
 *     &lt;enumeration value="DOSEHINDA"/&gt;
 *     &lt;enumeration value="DOSEHINDSA"/&gt;
 *     &lt;enumeration value="DOSEHIND"/&gt;
 *     &lt;enumeration value="DOSEHINDW"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DoseHighDetectedIssueCode")
@XmlEnum
public enum DoseHighDetectedIssueCode {

    DOSEH,
    DOSEHINDA,
    DOSEHINDSA,
    DOSEHIND,
    DOSEHINDW;

    public String getValue() {
        return name();
    }

    public static DoseHighDetectedIssueCode fromValue(String v) {
        return valueOf(v);
    }

}
