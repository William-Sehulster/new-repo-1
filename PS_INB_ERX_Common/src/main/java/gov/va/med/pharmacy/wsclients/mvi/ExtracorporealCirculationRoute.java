
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtracorporealCirculationRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExtracorporealCirculationRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EXTCORPDIF"/&gt;
 *     &lt;enumeration value="EXTCORPINJ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExtracorporealCirculationRoute")
@XmlEnum
public enum ExtracorporealCirculationRoute {

    EXTCORPDIF,
    EXTCORPINJ;

    public String getValue() {
        return name();
    }

    public static ExtracorporealCirculationRoute fromValue(String v) {
        return valueOf(v);
    }

}
