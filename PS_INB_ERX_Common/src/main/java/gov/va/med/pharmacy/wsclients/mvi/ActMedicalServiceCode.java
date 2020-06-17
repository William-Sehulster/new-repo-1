
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMedicalServiceCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMedicalServiceCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ALC"/&gt;
 *     &lt;enumeration value="CARD"/&gt;
 *     &lt;enumeration value="CHR"/&gt;
 *     &lt;enumeration value="DNTL"/&gt;
 *     &lt;enumeration value="DRGRHB"/&gt;
 *     &lt;enumeration value="GENRL"/&gt;
 *     &lt;enumeration value="MED"/&gt;
 *     &lt;enumeration value="OBS"/&gt;
 *     &lt;enumeration value="ONC"/&gt;
 *     &lt;enumeration value="PALL"/&gt;
 *     &lt;enumeration value="PED"/&gt;
 *     &lt;enumeration value="PHAR"/&gt;
 *     &lt;enumeration value="PHYRHB"/&gt;
 *     &lt;enumeration value="PSYCH"/&gt;
 *     &lt;enumeration value="SURG"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActMedicalServiceCode")
@XmlEnum
public enum ActMedicalServiceCode {

    ALC,
    CARD,
    CHR,
    DNTL,
    DRGRHB,
    GENRL,
    MED,
    OBS,
    ONC,
    PALL,
    PED,
    PHAR,
    PHYRHB,
    PSYCH,
    SURG;

    public String getValue() {
        return name();
    }

    public static ActMedicalServiceCode fromValue(String v) {
        return valueOf(v);
    }

}
