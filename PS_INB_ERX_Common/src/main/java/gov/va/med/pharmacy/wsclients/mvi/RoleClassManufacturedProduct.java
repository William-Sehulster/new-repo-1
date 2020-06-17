
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassManufacturedProduct.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassManufacturedProduct"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="MANU"/&gt;
 *     &lt;enumeration value="THER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassManufacturedProduct")
@XmlEnum
public enum RoleClassManufacturedProduct {

    MANU,
    THER;

    public String getValue() {
        return name();
    }

    public static RoleClassManufacturedProduct fromValue(String v) {
        return valueOf(v);
    }

}
