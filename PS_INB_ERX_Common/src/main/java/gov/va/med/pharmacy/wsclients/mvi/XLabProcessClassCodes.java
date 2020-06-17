
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_LabProcessClassCodes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_LabProcessClassCodes"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ACSN"/&gt;
 *     &lt;enumeration value="CONTREG"/&gt;
 *     &lt;enumeration value="PROC"/&gt;
 *     &lt;enumeration value="SPCTRT"/&gt;
 *     &lt;enumeration value="TRNS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_LabProcessClassCodes")
@XmlEnum
public enum XLabProcessClassCodes {

    ACSN,
    CONTREG,
    PROC,
    SPCTRT,
    TRNS;

    public String getValue() {
        return name();
    }

    public static XLabProcessClassCodes fromValue(String v) {
        return valueOf(v);
    }

}
