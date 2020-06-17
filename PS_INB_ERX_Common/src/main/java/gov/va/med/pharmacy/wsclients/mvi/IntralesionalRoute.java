
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntralesionalRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntralesionalRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ILESINJ"/&gt;
 *     &lt;enumeration value="ILESIRR"/&gt;
 *     &lt;enumeration value="ILTOP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntralesionalRoute")
@XmlEnum
public enum IntralesionalRoute {

    ILESINJ,
    ILESIRR,
    ILTOP;

    public String getValue() {
        return name();
    }

    public static IntralesionalRoute fromValue(String v) {
        return valueOf(v);
    }

}
