
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationLivingExpenseValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationLivingExpenseValue"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="LIVEXP"/&gt;
 *     &lt;enumeration value="CLOTH"/&gt;
 *     &lt;enumeration value="FOOD"/&gt;
 *     &lt;enumeration value="HEALTH"/&gt;
 *     &lt;enumeration value="HOUSE"/&gt;
 *     &lt;enumeration value="LEGAL"/&gt;
 *     &lt;enumeration value="MORTG"/&gt;
 *     &lt;enumeration value="RENT"/&gt;
 *     &lt;enumeration value="SUNDRY"/&gt;
 *     &lt;enumeration value="TRANS"/&gt;
 *     &lt;enumeration value="UTIL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationLivingExpenseValue")
@XmlEnum
public enum ObservationLivingExpenseValue {

    LIVEXP,
    CLOTH,
    FOOD,
    HEALTH,
    HOUSE,
    LEGAL,
    MORTG,
    RENT,
    SUNDRY,
    TRANS,
    UTIL;

    public String getValue() {
        return name();
    }

    public static ObservationLivingExpenseValue fromValue(String v) {
        return valueOf(v);
    }

}
