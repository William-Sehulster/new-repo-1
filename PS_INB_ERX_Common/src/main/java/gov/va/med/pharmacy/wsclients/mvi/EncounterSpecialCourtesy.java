
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EncounterSpecialCourtesy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EncounterSpecialCourtesy"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EXT"/&gt;
 *     &lt;enumeration value="NRM"/&gt;
 *     &lt;enumeration value="PRF"/&gt;
 *     &lt;enumeration value="STF"/&gt;
 *     &lt;enumeration value="VIP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EncounterSpecialCourtesy")
@XmlEnum
public enum EncounterSpecialCourtesy {

    EXT,
    NRM,
    PRF,
    STF,
    VIP;

    public String getValue() {
        return name();
    }

    public static EncounterSpecialCourtesy fromValue(String v) {
        return valueOf(v);
    }

}
