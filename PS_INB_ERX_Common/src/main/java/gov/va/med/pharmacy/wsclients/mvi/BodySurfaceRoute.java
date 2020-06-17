
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BodySurfaceRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BodySurfaceRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ELECTOSMOS"/&gt;
 *     &lt;enumeration value="SOAK"/&gt;
 *     &lt;enumeration value="TOPICAL"/&gt;
 *     &lt;enumeration value="IONTO"/&gt;
 *     &lt;enumeration value="DRESS"/&gt;
 *     &lt;enumeration value="SWAB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BodySurfaceRoute")
@XmlEnum
public enum BodySurfaceRoute {

    ELECTOSMOS,
    SOAK,
    TOPICAL,
    IONTO,
    DRESS,
    SWAB;

    public String getValue() {
        return name();
    }

    public static BodySurfaceRoute fromValue(String v) {
        return valueOf(v);
    }

}
