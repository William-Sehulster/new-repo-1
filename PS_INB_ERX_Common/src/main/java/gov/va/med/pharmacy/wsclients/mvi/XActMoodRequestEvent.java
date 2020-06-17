
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActMoodRequestEvent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActMoodRequestEvent"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EVN"/&gt;
 *     &lt;enumeration value="RQO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ActMoodRequestEvent")
@XmlEnum
public enum XActMoodRequestEvent {

    EVN,
    RQO;

    public String getValue() {
        return name();
    }

    public static XActMoodRequestEvent fromValue(String v) {
        return valueOf(v);
    }

}
