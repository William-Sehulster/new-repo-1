
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ROIOverlayShape.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ROIOverlayShape"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CIRCLE"/&gt;
 *     &lt;enumeration value="ELLIPSE"/&gt;
 *     &lt;enumeration value="POINT"/&gt;
 *     &lt;enumeration value="POLY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ROIOverlayShape")
@XmlEnum
public enum ROIOverlayShape {

    CIRCLE,
    ELLIPSE,
    POINT,
    POLY;

    public String getValue() {
        return name();
    }

    public static ROIOverlayShape fromValue(String v) {
        return valueOf(v);
    }

}
