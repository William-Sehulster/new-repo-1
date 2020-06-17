
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_AdverseEventCausalityAssessmentMethods.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_AdverseEventCausalityAssessmentMethods"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ALGM"/&gt;
 *     &lt;enumeration value="BYCL"/&gt;
 *     &lt;enumeration value="GINT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_AdverseEventCausalityAssessmentMethods")
@XmlEnum
public enum XAdverseEventCausalityAssessmentMethods {

    ALGM,
    BYCL,
    GINT;

    public String getValue() {
        return name();
    }

    public static XAdverseEventCausalityAssessmentMethods fromValue(String v) {
        return valueOf(v);
    }

}
