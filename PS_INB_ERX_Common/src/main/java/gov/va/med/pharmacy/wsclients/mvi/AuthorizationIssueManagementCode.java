
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthorizationIssueManagementCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuthorizationIssueManagementCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EMAUTH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AuthorizationIssueManagementCode")
@XmlEnum
public enum AuthorizationIssueManagementCode {

    EMAUTH;

    public String getValue() {
        return name();
    }

    public static AuthorizationIssueManagementCode fromValue(String v) {
        return valueOf(v);
    }

}
