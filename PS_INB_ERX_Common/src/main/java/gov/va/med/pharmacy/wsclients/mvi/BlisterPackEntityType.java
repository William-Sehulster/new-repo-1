
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BlisterPackEntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BlisterPackEntityType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BLSTRPK"/&gt;
 *     &lt;enumeration value="CARD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BlisterPackEntityType")
@XmlEnum
public enum BlisterPackEntityType {

    BLSTRPK,
    CARD;

    public String getValue() {
        return name();
    }

    public static BlisterPackEntityType fromValue(String v) {
        return valueOf(v);
    }

}
