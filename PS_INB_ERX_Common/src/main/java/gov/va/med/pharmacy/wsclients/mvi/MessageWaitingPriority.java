
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageWaitingPriority.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MessageWaitingPriority"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="L"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MessageWaitingPriority")
@XmlEnum
public enum MessageWaitingPriority {

    H,
    L,
    M;

    public String getValue() {
        return name();
    }

    public static MessageWaitingPriority fromValue(String v) {
        return valueOf(v);
    }

}
