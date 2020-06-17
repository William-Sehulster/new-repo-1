
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntragastricRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntragastricRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IGASTINSTIL"/&gt;
 *     &lt;enumeration value="IGASTIRR"/&gt;
 *     &lt;enumeration value="IGASTLAV"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntragastricRoute")
@XmlEnum
public enum IntragastricRoute {

    IGASTINSTIL,
    IGASTIRR,
    IGASTLAV;

    public String getValue() {
        return name();
    }

    public static IntragastricRoute fromValue(String v) {
        return valueOf(v);
    }

}
