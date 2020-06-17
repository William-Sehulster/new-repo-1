
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntravascularRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntravascularRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="HEMODIFF"/&gt;
 *     &lt;enumeration value="IVASCINFUS"/&gt;
 *     &lt;enumeration value="HEMOPORT"/&gt;
 *     &lt;enumeration value="IVASCINJ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntravascularRoute")
@XmlEnum
public enum IntravascularRoute {

    HEMODIFF,
    IVASCINFUS,
    HEMOPORT,
    IVASCINJ;

    public String getValue() {
        return name();
    }

    public static IntravascularRoute fromValue(String v) {
        return valueOf(v);
    }

}
