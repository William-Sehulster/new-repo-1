
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntrapulmonaryRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntrapulmonaryRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EXTCORPINJ"/&gt;
 *     &lt;enumeration value="IPINJ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntrapulmonaryRoute")
@XmlEnum
public enum IntrapulmonaryRoute {

    EXTCORPINJ,
    IPINJ;

    public String getValue() {
        return name();
    }

    public static IntrapulmonaryRoute fromValue(String v) {
        return valueOf(v);
    }

}
