
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubarachnoidRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubarachnoidRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SUBARACHINJ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SubarachnoidRoute")
@XmlEnum
public enum SubarachnoidRoute {

    SUBARACHINJ;

    public String getValue() {
        return name();
    }

    public static SubarachnoidRoute fromValue(String v) {
        return valueOf(v);
    }

}
