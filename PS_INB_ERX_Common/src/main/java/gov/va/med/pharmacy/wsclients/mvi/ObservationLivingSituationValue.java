
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationLivingSituationValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationLivingSituationValue"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="LIVSIT"/&gt;
 *     &lt;enumeration value="ALONE"/&gt;
 *     &lt;enumeration value="DEPCHD"/&gt;
 *     &lt;enumeration value="DEPSPS"/&gt;
 *     &lt;enumeration value="DEPYGCHD"/&gt;
 *     &lt;enumeration value="FAM"/&gt;
 *     &lt;enumeration value="RELAT"/&gt;
 *     &lt;enumeration value="SPS"/&gt;
 *     &lt;enumeration value="UNREL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationLivingSituationValue")
@XmlEnum
public enum ObservationLivingSituationValue {

    LIVSIT,
    ALONE,
    DEPCHD,
    DEPSPS,
    DEPYGCHD,
    FAM,
    RELAT,
    SPS,
    UNREL;

    public String getValue() {
        return name();
    }

    public static ObservationLivingSituationValue fromValue(String v) {
        return valueOf(v);
    }

}
