
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActIneligibilityReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActIneligibilityReason"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="COVSUS"/&gt;
 *     &lt;enumeration value="DECSD"/&gt;
 *     &lt;enumeration value="REGERR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActIneligibilityReason")
@XmlEnum
public enum ActIneligibilityReason {

    COVSUS,
    DECSD,
    REGERR;

    public String getValue() {
        return name();
    }

    public static ActIneligibilityReason fromValue(String v) {
        return valueOf(v);
    }

}
