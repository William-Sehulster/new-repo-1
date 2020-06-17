
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcknowledgementDetailType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AcknowledgementDetailType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="W"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AcknowledgementDetailType")
@XmlEnum
public enum AcknowledgementDetailType {

    E,
    I,
    W;

    public String getValue() {
        return name();
    }

    public static AcknowledgementDetailType fromValue(String v) {
        return valueOf(v);
    }

}
