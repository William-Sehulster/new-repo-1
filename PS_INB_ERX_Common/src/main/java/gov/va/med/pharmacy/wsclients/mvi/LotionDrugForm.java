
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LotionDrugForm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LotionDrugForm"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="LTN"/&gt;
 *     &lt;enumeration value="TOPLTN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LotionDrugForm")
@XmlEnum
public enum LotionDrugForm {

    LTN,
    TOPLTN;

    public String getValue() {
        return name();
    }

    public static LotionDrugForm fromValue(String v) {
        return valueOf(v);
    }

}
