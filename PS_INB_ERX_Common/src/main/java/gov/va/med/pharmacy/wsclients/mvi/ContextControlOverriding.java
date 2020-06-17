
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContextControlOverriding.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContextControlOverriding"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ON"/&gt;
 *     &lt;enumeration value="OP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ContextControlOverriding")
@XmlEnum
public enum ContextControlOverriding {

    ON,
    OP;

    public String getValue() {
        return name();
    }

    public static ContextControlOverriding fromValue(String v) {
        return valueOf(v);
    }

}
