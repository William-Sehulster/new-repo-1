
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrivateResidence.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrivateResidence"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PR"/&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *     &lt;enumeration value="SL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PrivateResidence")
@XmlEnum
public enum PrivateResidence {

    PR,
    H,
    R,
    SL;

    public String getValue() {
        return name();
    }

    public static PrivateResidence fromValue(String v) {
        return valueOf(v);
    }

}
