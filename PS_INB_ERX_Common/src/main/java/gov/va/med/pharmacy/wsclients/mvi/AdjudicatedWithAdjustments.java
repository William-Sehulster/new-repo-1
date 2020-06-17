
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdjudicatedWithAdjustments.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdjudicatedWithAdjustments"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AA"/&gt;
 *     &lt;enumeration value="ANF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AdjudicatedWithAdjustments")
@XmlEnum
public enum AdjudicatedWithAdjustments {

    AA,
    ANF;

    public String getValue() {
        return name();
    }

    public static AdjudicatedWithAdjustments fromValue(String v) {
        return valueOf(v);
    }

}
