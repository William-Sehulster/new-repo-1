
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommunicationFunctionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommunicationFunctionType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="RCV"/&gt;
 *     &lt;enumeration value="RSP"/&gt;
 *     &lt;enumeration value="SND"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CommunicationFunctionType")
@XmlEnum
public enum CommunicationFunctionType {

    RCV,
    RSP,
    SND;

    public String getValue() {
        return name();
    }

    public static CommunicationFunctionType fromValue(String v) {
        return valueOf(v);
    }

}
