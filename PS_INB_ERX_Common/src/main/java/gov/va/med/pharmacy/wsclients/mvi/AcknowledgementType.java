
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcknowledgementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AcknowledgementType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CA"/&gt;
 *     &lt;enumeration value="CE"/&gt;
 *     &lt;enumeration value="CR"/&gt;
 *     &lt;enumeration value="AA"/&gt;
 *     &lt;enumeration value="AE"/&gt;
 *     &lt;enumeration value="AR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AcknowledgementType")
@XmlEnum
public enum AcknowledgementType {

    CA,
    CE,
    CR,
    AA,
    AE,
    AR;

    public String getValue() {
        return name();
    }

    public static AcknowledgementType fromValue(String v) {
        return valueOf(v);
    }

}
