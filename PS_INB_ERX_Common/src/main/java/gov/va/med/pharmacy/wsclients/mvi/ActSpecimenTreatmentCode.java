
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActSpecimenTreatmentCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActSpecimenTreatmentCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ACID"/&gt;
 *     &lt;enumeration value="ALK"/&gt;
 *     &lt;enumeration value="DEFB"/&gt;
 *     &lt;enumeration value="FILT"/&gt;
 *     &lt;enumeration value="LDLP"/&gt;
 *     &lt;enumeration value="NEUT"/&gt;
 *     &lt;enumeration value="RECA"/&gt;
 *     &lt;enumeration value="UFIL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActSpecimenTreatmentCode")
@XmlEnum
public enum ActSpecimenTreatmentCode {

    ACID,
    ALK,
    DEFB,
    FILT,
    LDLP,
    NEUT,
    RECA,
    UFIL;

    public String getValue() {
        return name();
    }

    public static ActSpecimenTreatmentCode fromValue(String v) {
        return valueOf(v);
    }

}
