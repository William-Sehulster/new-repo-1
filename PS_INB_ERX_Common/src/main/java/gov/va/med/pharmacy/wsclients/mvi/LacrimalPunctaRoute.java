
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LacrimalPunctaRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LacrimalPunctaRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="LPINS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LacrimalPunctaRoute")
@XmlEnum
public enum LacrimalPunctaRoute {

    LPINS;

    public String getValue() {
        return name();
    }

    public static LacrimalPunctaRoute fromValue(String v) {
        return valueOf(v);
    }

}
