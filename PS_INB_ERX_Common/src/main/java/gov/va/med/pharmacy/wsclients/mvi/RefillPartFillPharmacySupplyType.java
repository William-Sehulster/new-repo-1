
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefillPartFillPharmacySupplyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RefillPartFillPharmacySupplyType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="RFP"/&gt;
 *     &lt;enumeration value="RFPS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RefillPartFillPharmacySupplyType")
@XmlEnum
public enum RefillPartFillPharmacySupplyType {

    RFP,
    RFPS;

    public String getValue() {
        return name();
    }

    public static RefillPartFillPharmacySupplyType fromValue(String v) {
        return valueOf(v);
    }

}
