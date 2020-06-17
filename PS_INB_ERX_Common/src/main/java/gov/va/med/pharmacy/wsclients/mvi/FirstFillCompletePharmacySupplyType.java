
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FirstFillCompletePharmacySupplyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FirstFillCompletePharmacySupplyType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="FFC"/&gt;
 *     &lt;enumeration value="FFCS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FirstFillCompletePharmacySupplyType")
@XmlEnum
public enum FirstFillCompletePharmacySupplyType {

    FFC,
    FFCS;

    public String getValue() {
        return name();
    }

    public static FirstFillCompletePharmacySupplyType fromValue(String v) {
        return valueOf(v);
    }

}
