
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StepSibling.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StepSibling"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="STPSIB"/&gt;
 *     &lt;enumeration value="STPBRO"/&gt;
 *     &lt;enumeration value="STPSIS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StepSibling")
@XmlEnum
public enum StepSibling {

    STPSIB,
    STPBRO,
    STPSIS;

    public String getValue() {
        return name();
    }

    public static StepSibling fromValue(String v) {
        return valueOf(v);
    }

}
