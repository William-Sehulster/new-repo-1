
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefillTrialBalancePharmacySupplyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RefillTrialBalancePharmacySupplyType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="TB"/&gt;
 *     &lt;enumeration value="TBS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RefillTrialBalancePharmacySupplyType")
@XmlEnum
public enum RefillTrialBalancePharmacySupplyType {

    TB,
    TBS;

    public String getValue() {
        return name();
    }

    public static RefillTrialBalancePharmacySupplyType fromValue(String v) {
        return valueOf(v);
    }

}
