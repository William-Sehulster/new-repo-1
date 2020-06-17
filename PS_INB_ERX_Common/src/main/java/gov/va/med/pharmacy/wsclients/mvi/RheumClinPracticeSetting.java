
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RheumClinPracticeSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RheumClinPracticeSetting"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="RHEUM"/&gt;
 *     &lt;enumeration value="PEDRHEUM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RheumClinPracticeSetting")
@XmlEnum
public enum RheumClinPracticeSetting {

    RHEUM,
    PEDRHEUM;

    public String getValue() {
        return name();
    }

    public static RheumClinPracticeSetting fromValue(String v) {
        return valueOf(v);
    }

}
