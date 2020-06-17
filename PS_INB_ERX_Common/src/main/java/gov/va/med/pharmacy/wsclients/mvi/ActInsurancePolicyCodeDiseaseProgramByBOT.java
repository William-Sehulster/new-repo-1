
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInsurancePolicyCodeDiseaseProgramByBOT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInsurancePolicyCodeDiseaseProgramByBOT"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="DISEASEPRG"/&gt;
 *     &lt;enumeration value="HIVAIDS"/&gt;
 *     &lt;enumeration value="CANPRG"/&gt;
 *     &lt;enumeration value="ENDRENAL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInsurancePolicyCodeDiseaseProgramByBOT")
@XmlEnum
public enum ActInsurancePolicyCodeDiseaseProgramByBOT {

    DISEASEPRG,
    HIVAIDS,
    CANPRG,
    ENDRENAL;

    public String getValue() {
        return name();
    }

    public static ActInsurancePolicyCodeDiseaseProgramByBOT fromValue(String v) {
        return valueOf(v);
    }

}
