
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardClinPracticeSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CardClinPracticeSetting"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CARD"/&gt;
 *     &lt;enumeration value="PEDCARD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CardClinPracticeSetting")
@XmlEnum
public enum CardClinPracticeSetting {

    CARD,
    PEDCARD;

    public String getValue() {
        return name();
    }

    public static CardClinPracticeSetting fromValue(String v) {
        return valueOf(v);
    }

}
