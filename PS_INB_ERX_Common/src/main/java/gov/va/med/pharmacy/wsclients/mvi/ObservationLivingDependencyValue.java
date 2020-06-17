
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationLivingDependencyValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationLivingDependencyValue"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="LIVDEP"/&gt;
 *     &lt;enumeration value="RELDEP"/&gt;
 *     &lt;enumeration value="SPSDEP"/&gt;
 *     &lt;enumeration value="URELDEP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationLivingDependencyValue")
@XmlEnum
public enum ObservationLivingDependencyValue {

    LIVDEP,
    RELDEP,
    SPSDEP,
    URELDEP;

    public String getValue() {
        return name();
    }

    public static ObservationLivingDependencyValue fromValue(String v) {
        return valueOf(v);
    }

}
