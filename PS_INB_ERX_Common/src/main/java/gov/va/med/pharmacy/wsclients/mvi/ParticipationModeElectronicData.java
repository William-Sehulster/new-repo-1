
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationModeElectronicData.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationModeElectronicData"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ELECTRONIC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParticipationModeElectronicData")
@XmlEnum
public enum ParticipationModeElectronicData {

    ELECTRONIC;

    public String getValue() {
        return name();
    }

    public static ParticipationModeElectronicData fromValue(String v) {
        return valueOf(v);
    }

}
