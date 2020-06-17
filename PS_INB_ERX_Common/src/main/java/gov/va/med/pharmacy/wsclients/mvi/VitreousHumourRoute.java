
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VitreousHumourRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VitreousHumourRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IVITIMPLNT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VitreousHumourRoute")
@XmlEnum
public enum VitreousHumourRoute {

    IVITIMPLNT;

    public String getValue() {
        return name();
    }

    public static VitreousHumourRoute fromValue(String v) {
        return valueOf(v);
    }

}
