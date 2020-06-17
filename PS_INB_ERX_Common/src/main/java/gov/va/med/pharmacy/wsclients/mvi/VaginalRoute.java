
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VaginalRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VaginalRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="DOUCHE"/&gt;
 *     &lt;enumeration value="VAGINSI"/&gt;
 *     &lt;enumeration value="VAGINS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VaginalRoute")
@XmlEnum
public enum VaginalRoute {

    DOUCHE,
    VAGINSI,
    VAGINS;

    public String getValue() {
        return name();
    }

    public static VaginalRoute fromValue(String v) {
        return valueOf(v);
    }

}
