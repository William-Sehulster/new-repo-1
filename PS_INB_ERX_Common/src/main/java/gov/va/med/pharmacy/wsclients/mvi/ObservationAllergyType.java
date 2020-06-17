
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationAllergyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationAllergyType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ALG"/&gt;
 *     &lt;enumeration value="DALG"/&gt;
 *     &lt;enumeration value="EALG"/&gt;
 *     &lt;enumeration value="FALG"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationAllergyType")
@XmlEnum
public enum ObservationAllergyType {

    ALG,
    DALG,
    EALG,
    FALG;

    public String getValue() {
        return name();
    }

    public static ObservationAllergyType fromValue(String v) {
        return valueOf(v);
    }

}
