
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CodeSystemType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CodeSystemType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="EI"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CodeSystemType")
@XmlEnum
public enum CodeSystemType {

    E,
    EI,
    I;

    public String getValue() {
        return name();
    }

    public static CodeSystemType fromValue(String v) {
        return valueOf(v);
    }

}
