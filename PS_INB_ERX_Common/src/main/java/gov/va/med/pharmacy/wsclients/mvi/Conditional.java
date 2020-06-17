
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Conditional.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Conditional"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CONFIRM"/&gt;
 *     &lt;enumeration value="NOTIFY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Conditional")
@XmlEnum
public enum Conditional {

    CONFIRM,
    NOTIFY;

    public String getValue() {
        return name();
    }

    public static Conditional fromValue(String v) {
        return valueOf(v);
    }

}
