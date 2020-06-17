
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntraperitonealRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntraperitonealRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IPERINJ"/&gt;
 *     &lt;enumeration value="PDPINJ"/&gt;
 *     &lt;enumeration value="CAPDINSTL"/&gt;
 *     &lt;enumeration value="PDPINSTL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntraperitonealRoute")
@XmlEnum
public enum IntraperitonealRoute {

    IPERINJ,
    PDPINJ,
    CAPDINSTL,
    PDPINSTL;

    public String getValue() {
        return name();
    }

    public static IntraperitonealRoute fromValue(String v) {
        return valueOf(v);
    }

}
