
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HemClinPracticeSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HemClinPracticeSetting"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="HEM"/&gt;
 *     &lt;enumeration value="PEDHEM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HemClinPracticeSetting")
@XmlEnum
public enum HemClinPracticeSetting {

    HEM,
    PEDHEM;

    public String getValue() {
        return name();
    }

    public static HemClinPracticeSetting fromValue(String v) {
        return valueOf(v);
    }

}
