
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationFoodIntoleranceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationFoodIntoleranceType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="FINT"/&gt;
 *     &lt;enumeration value="FALG"/&gt;
 *     &lt;enumeration value="FNAINT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationFoodIntoleranceType")
@XmlEnum
public enum ObservationFoodIntoleranceType {

    FINT,
    FALG,
    FNAINT;

    public String getValue() {
        return name();
    }

    public static ObservationFoodIntoleranceType fromValue(String v) {
        return valueOf(v);
    }

}
