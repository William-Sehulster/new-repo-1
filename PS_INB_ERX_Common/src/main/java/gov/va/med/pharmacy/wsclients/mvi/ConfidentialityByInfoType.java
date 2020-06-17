
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfidentialityByInfoType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ConfidentialityByInfoType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="HIV"/&gt;
 *     &lt;enumeration value="PSY"/&gt;
 *     &lt;enumeration value="SDV"/&gt;
 *     &lt;enumeration value="ETH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ConfidentialityByInfoType")
@XmlEnum
public enum ConfidentialityByInfoType {

    HIV,
    PSY,
    SDV,
    ETH;

    public String getValue() {
        return name();
    }

    public static ConfidentialityByInfoType fromValue(String v) {
        return valueOf(v);
    }

}
