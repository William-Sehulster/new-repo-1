
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassIngredientEntityActiveIngredientByBOT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassIngredientEntityActiveIngredientByBOT"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ACTI"/&gt;
 *     &lt;enumeration value="ACTIB"/&gt;
 *     &lt;enumeration value="ACTIM"/&gt;
 *     &lt;enumeration value="ACTIR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassIngredientEntityActiveIngredientByBOT")
@XmlEnum
public enum RoleClassIngredientEntityActiveIngredientByBOT {

    ACTI,
    ACTIB,
    ACTIM,
    ACTIR;

    public String getValue() {
        return name();
    }

    public static RoleClassIngredientEntityActiveIngredientByBOT fromValue(String v) {
        return valueOf(v);
    }

}
