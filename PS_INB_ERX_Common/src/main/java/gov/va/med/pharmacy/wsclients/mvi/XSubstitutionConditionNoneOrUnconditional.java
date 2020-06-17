
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_SubstitutionConditionNoneOrUnconditional.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_SubstitutionConditionNoneOrUnconditional"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="NOSUB"/&gt;
 *     &lt;enumeration value="UNCOND"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_SubstitutionConditionNoneOrUnconditional")
@XmlEnum
public enum XSubstitutionConditionNoneOrUnconditional {

    NOSUB,
    UNCOND;

    public String getValue() {
        return name();
    }

    public static XSubstitutionConditionNoneOrUnconditional fromValue(String v) {
        return valueOf(v);
    }

}
