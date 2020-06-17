
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnteralRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnteralRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ENTINSTL"/&gt;
 *     &lt;enumeration value="EFT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EnteralRoute")
@XmlEnum
public enum EnteralRoute {

    ENTINSTL,
    EFT;

    public String getValue() {
        return name();
    }

    public static EnteralRoute fromValue(String v) {
        return valueOf(v);
    }

}
