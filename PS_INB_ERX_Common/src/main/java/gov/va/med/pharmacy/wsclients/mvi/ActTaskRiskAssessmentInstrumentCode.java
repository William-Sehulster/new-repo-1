
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActTaskRiskAssessmentInstrumentCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActTaskRiskAssessmentInstrumentCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="RISKASSESS"/&gt;
 *     &lt;enumeration value="FALLRISK"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActTaskRiskAssessmentInstrumentCode")
@XmlEnum
public enum ActTaskRiskAssessmentInstrumentCode {

    RISKASSESS,
    FALLRISK;

    public String getValue() {
        return name();
    }

    public static ActTaskRiskAssessmentInstrumentCode fromValue(String v) {
        return valueOf(v);
    }

}
