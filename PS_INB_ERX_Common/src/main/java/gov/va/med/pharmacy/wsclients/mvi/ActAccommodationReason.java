
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActAccommodationReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActAccommodationReason"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ACCREQNA"/&gt;
 *     &lt;enumeration value="FLRCNV"/&gt;
 *     &lt;enumeration value="MEDNEC"/&gt;
 *     &lt;enumeration value="PAT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActAccommodationReason")
@XmlEnum
public enum ActAccommodationReason {

    ACCREQNA,
    FLRCNV,
    MEDNEC,
    PAT;

    public String getValue() {
        return name();
    }

    public static ActAccommodationReason fromValue(String v) {
        return valueOf(v);
    }

}
