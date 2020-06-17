
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassInactiveIngredient.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassInactiveIngredient"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IACT"/&gt;
 *     &lt;enumeration value="COLR"/&gt;
 *     &lt;enumeration value="FLVR"/&gt;
 *     &lt;enumeration value="PRSV"/&gt;
 *     &lt;enumeration value="STBL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassInactiveIngredient")
@XmlEnum
public enum RoleClassInactiveIngredient {

    IACT,
    COLR,
    FLVR,
    PRSV,
    STBL;

    public String getValue() {
        return name();
    }

    public static RoleClassInactiveIngredient fromValue(String v) {
        return valueOf(v);
    }

}
