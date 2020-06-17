
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoftTissueRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SoftTissueRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SOFTISINJ"/&gt;
 *     &lt;enumeration value="SOFTISINSTIL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SoftTissueRoute")
@XmlEnum
public enum SoftTissueRoute {

    SOFTISINJ,
    SOFTISINSTIL;

    public String getValue() {
        return name();
    }

    public static SoftTissueRoute fromValue(String v) {
        return valueOf(v);
    }

}
