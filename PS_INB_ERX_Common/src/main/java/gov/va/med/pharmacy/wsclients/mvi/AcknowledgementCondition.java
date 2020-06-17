
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcknowledgementCondition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AcknowledgementCondition"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AL"/&gt;
 *     &lt;enumeration value="ER"/&gt;
 *     &lt;enumeration value="NE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AcknowledgementCondition")
@XmlEnum
public enum AcknowledgementCondition {

    AL,
    ER,
    NE;

    public String getValue() {
        return name();
    }

    public static AcknowledgementCondition fromValue(String v) {
        return valueOf(v);
    }

}
