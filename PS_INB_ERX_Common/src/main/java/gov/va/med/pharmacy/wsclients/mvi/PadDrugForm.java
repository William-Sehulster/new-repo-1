
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PadDrugForm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PadDrugForm"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PAD"/&gt;
 *     &lt;enumeration value="MEDPAD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PadDrugForm")
@XmlEnum
public enum PadDrugForm {

    PAD,
    MEDPAD;

    public String getValue() {
        return name();
    }

    public static PadDrugForm fromValue(String v) {
        return valueOf(v);
    }

}
