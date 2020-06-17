
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PharmacySupplyEventStockReasonCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PharmacySupplyEventStockReasonCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="FLRSTCK"/&gt;
 *     &lt;enumeration value="LTC"/&gt;
 *     &lt;enumeration value="OFFICE"/&gt;
 *     &lt;enumeration value="PHARM"/&gt;
 *     &lt;enumeration value="PROG"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PharmacySupplyEventStockReasonCode")
@XmlEnum
public enum PharmacySupplyEventStockReasonCode {

    FLRSTCK,
    LTC,
    OFFICE,
    PHARM,
    PROG;

    public String getValue() {
        return name();
    }

    public static PharmacySupplyEventStockReasonCode fromValue(String v) {
        return valueOf(v);
    }

}
