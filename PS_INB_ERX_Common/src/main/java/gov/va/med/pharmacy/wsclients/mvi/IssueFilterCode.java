
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IssueFilterCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IssueFilterCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ISSFA"/&gt;
 *     &lt;enumeration value="ISSFI"/&gt;
 *     &lt;enumeration value="ISSFU"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IssueFilterCode")
@XmlEnum
public enum IssueFilterCode {

    ISSFA,
    ISSFI,
    ISSFU;

    public String getValue() {
        return name();
    }

    public static IssueFilterCode fromValue(String v) {
        return valueOf(v);
    }

}
