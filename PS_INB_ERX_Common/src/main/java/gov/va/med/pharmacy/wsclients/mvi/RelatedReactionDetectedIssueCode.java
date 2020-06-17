
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelatedReactionDetectedIssueCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelatedReactionDetectedIssueCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="RREACT"/&gt;
 *     &lt;enumeration value="RALG"/&gt;
 *     &lt;enumeration value="RINT"/&gt;
 *     &lt;enumeration value="RAR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RelatedReactionDetectedIssueCode")
@XmlEnum
public enum RelatedReactionDetectedIssueCode {

    RREACT,
    RALG,
    RINT,
    RAR;

    public String getValue() {
        return name();
    }

    public static RelatedReactionDetectedIssueCode fromValue(String v) {
        return valueOf(v);
    }

}
