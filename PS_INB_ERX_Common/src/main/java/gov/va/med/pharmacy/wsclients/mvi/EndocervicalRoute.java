
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EndocervicalRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EndocervicalRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AMNINJ"/&gt;
 *     &lt;enumeration value="BILINJ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EndocervicalRoute")
@XmlEnum
public enum EndocervicalRoute {

    AMNINJ,
    BILINJ;

    public String getValue() {
        return name();
    }

    public static EndocervicalRoute fromValue(String v) {
        return valueOf(v);
    }

}
