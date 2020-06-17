
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GIClinicPracticeSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GIClinicPracticeSetting"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="GI"/&gt;
 *     &lt;enumeration value="PEDGI"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "GIClinicPracticeSetting")
@XmlEnum
public enum GIClinicPracticeSetting {

    GI,
    PEDGI;

    public String getValue() {
        return name();
    }

    public static GIClinicPracticeSetting fromValue(String v) {
        return valueOf(v);
    }

}
