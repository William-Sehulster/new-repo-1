
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActSpecObsVolumeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActSpecObsVolumeCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="VOLUME"/&gt;
 *     &lt;enumeration value="AVAILABLE"/&gt;
 *     &lt;enumeration value="CONSUMPTION"/&gt;
 *     &lt;enumeration value="CURRENT"/&gt;
 *     &lt;enumeration value="INITIAL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActSpecObsVolumeCode")
@XmlEnum
public enum ActSpecObsVolumeCode {

    VOLUME,
    AVAILABLE,
    CONSUMPTION,
    CURRENT,
    INITIAL;

    public String getValue() {
        return name();
    }

    public static ActSpecObsVolumeCode fromValue(String v) {
        return valueOf(v);
    }

}
