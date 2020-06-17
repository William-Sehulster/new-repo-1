
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActBoundedROICode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActBoundedROICode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ROIFS"/&gt;
 *     &lt;enumeration value="ROIPS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActBoundedROICode")
@XmlEnum
public enum ActBoundedROICode {

    ROIFS,
    ROIPS;

    public String getValue() {
        return name();
    }

    public static ActBoundedROICode fromValue(String v) {
        return valueOf(v);
    }

}
