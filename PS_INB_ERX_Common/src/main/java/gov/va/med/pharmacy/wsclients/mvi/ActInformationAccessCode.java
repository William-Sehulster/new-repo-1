
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInformationAccessCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInformationAccessCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ACADR"/&gt;
 *     &lt;enumeration value="ACALLG"/&gt;
 *     &lt;enumeration value="ACOBS"/&gt;
 *     &lt;enumeration value="ACDEMO"/&gt;
 *     &lt;enumeration value="ACIMMUN"/&gt;
 *     &lt;enumeration value="ACLAB"/&gt;
 *     &lt;enumeration value="ACMEDC"/&gt;
 *     &lt;enumeration value="ACMED"/&gt;
 *     &lt;enumeration value="ACPOLPRG"/&gt;
 *     &lt;enumeration value="ACPSERV"/&gt;
 *     &lt;enumeration value="ACPROV"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInformationAccessCode")
@XmlEnum
public enum ActInformationAccessCode {

    ACADR,
    ACALLG,
    ACOBS,
    ACDEMO,
    ACIMMUN,
    ACLAB,
    ACMEDC,
    ACMED,
    ACPOLPRG,
    ACPSERV,
    ACPROV;

    public String getValue() {
        return name();
    }

    public static ActInformationAccessCode fromValue(String v) {
        return valueOf(v);
    }

}
