
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_AccommodationRequestorRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_AccommodationRequestorRole"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AGNT"/&gt;
 *     &lt;enumeration value="PROV"/&gt;
 *     &lt;enumeration value="PAT"/&gt;
 *     &lt;enumeration value="PRS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_AccommodationRequestorRole")
@XmlEnum
public enum XAccommodationRequestorRole {

    AGNT,
    PROV,
    PAT,
    PRS;

    public String getValue() {
        return name();
    }

    public static XAccommodationRequestorRole fromValue(String v) {
        return valueOf(v);
    }

}
