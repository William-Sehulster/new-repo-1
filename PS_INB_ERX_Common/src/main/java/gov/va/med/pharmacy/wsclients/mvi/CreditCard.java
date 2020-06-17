
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreditCard.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CreditCard"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AE"/&gt;
 *     &lt;enumeration value="DN"/&gt;
 *     &lt;enumeration value="DV"/&gt;
 *     &lt;enumeration value="MC"/&gt;
 *     &lt;enumeration value="V"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CreditCard")
@XmlEnum
public enum CreditCard {

    AE,
    DN,
    DV,
    MC,
    V;

    public String getValue() {
        return name();
    }

    public static CreditCard fromValue(String v) {
        return valueOf(v);
    }

}
