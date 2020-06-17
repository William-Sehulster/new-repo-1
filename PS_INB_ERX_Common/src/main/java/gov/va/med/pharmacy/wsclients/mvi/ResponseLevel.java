
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResponseLevel"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *     &lt;enumeration value="X"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ResponseLevel")
@XmlEnum
public enum ResponseLevel {

    C,
    F,
    D,
    E,
    N,
    R,
    X;

    public String getValue() {
        return name();
    }

    public static ResponseLevel fromValue(String v) {
        return valueOf(v);
    }

}
