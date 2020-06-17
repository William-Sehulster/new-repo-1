
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HalfSibling.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HalfSibling"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="HSIB"/&gt;
 *     &lt;enumeration value="HBRO"/&gt;
 *     &lt;enumeration value="HSIS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HalfSibling")
@XmlEnum
public enum HalfSibling {

    HSIB,
    HBRO,
    HSIS;

    public String getValue() {
        return name();
    }

    public static HalfSibling fromValue(String v) {
        return valueOf(v);
    }

}
