
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SwabDrugForm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SwabDrugForm"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SWAB"/&gt;
 *     &lt;enumeration value="MEDSWAB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SwabDrugForm")
@XmlEnum
public enum SwabDrugForm {

    SWAB,
    MEDSWAB;

    public String getValue() {
        return name();
    }

    public static SwabDrugForm fromValue(String v) {
        return valueOf(v);
    }

}
