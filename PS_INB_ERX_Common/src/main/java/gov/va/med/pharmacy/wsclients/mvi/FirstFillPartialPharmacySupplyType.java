
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FirstFillPartialPharmacySupplyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FirstFillPartialPharmacySupplyType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="FFS"/&gt;
 *     &lt;enumeration value="FFCS"/&gt;
 *     &lt;enumeration value="TFS"/&gt;
 *     &lt;enumeration value="FFPS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FirstFillPartialPharmacySupplyType")
@XmlEnum
public enum FirstFillPartialPharmacySupplyType {

    FFS,
    FFCS,
    TFS,
    FFPS;

    public String getValue() {
        return name();
    }

    public static FirstFillPartialPharmacySupplyType fromValue(String v) {
        return valueOf(v);
    }

}
