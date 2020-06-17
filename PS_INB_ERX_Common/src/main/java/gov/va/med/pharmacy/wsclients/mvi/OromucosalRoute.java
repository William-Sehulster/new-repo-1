
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OromucosalRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OromucosalRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="GARGLE"/&gt;
 *     &lt;enumeration value="SUCK"/&gt;
 *     &lt;enumeration value="SWISHSPIT"/&gt;
 *     &lt;enumeration value="SWISHSWAL"/&gt;
 *     &lt;enumeration value="ORMUC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OromucosalRoute")
@XmlEnum
public enum OromucosalRoute {

    GARGLE,
    SUCK,
    SWISHSPIT,
    SWISHSWAL,
    ORMUC;

    public String getValue() {
        return name();
    }

    public static OromucosalRoute fromValue(String v) {
        return valueOf(v);
    }

}
