
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmnioticFluidSacRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AmnioticFluidSacRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AMNINJ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AmnioticFluidSacRoute")
@XmlEnum
public enum AmnioticFluidSacRoute {

    AMNINJ;

    public String getValue() {
        return name();
    }

    public static AmnioticFluidSacRoute fromValue(String v) {
        return valueOf(v);
    }

}
