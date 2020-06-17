
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActExposureCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActExposureCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="HOMECARE"/&gt;
 *     &lt;enumeration value="CONVEYNC"/&gt;
 *     &lt;enumeration value="PLACE"/&gt;
 *     &lt;enumeration value="SUBSTNCE"/&gt;
 *     &lt;enumeration value="TRAVINT"/&gt;
 *     &lt;enumeration value="CHLDCARE"/&gt;
 *     &lt;enumeration value="HLTHCARE"/&gt;
 *     &lt;enumeration value="PTNTCARE"/&gt;
 *     &lt;enumeration value="HOSPPTNT"/&gt;
 *     &lt;enumeration value="HOSPVSTR"/&gt;
 *     &lt;enumeration value="HOUSEHLD"/&gt;
 *     &lt;enumeration value="INMATE"/&gt;
 *     &lt;enumeration value="INTIMATE"/&gt;
 *     &lt;enumeration value="LTRMCARE"/&gt;
 *     &lt;enumeration value="SCHOOL2"/&gt;
 *     &lt;enumeration value="SOCIAL2"/&gt;
 *     &lt;enumeration value="WORK2"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActExposureCode")
@XmlEnum
public enum ActExposureCode {

    HOMECARE("HOMECARE"),
    CONVEYNC("CONVEYNC"),
    PLACE("PLACE"),
    SUBSTNCE("SUBSTNCE"),
    TRAVINT("TRAVINT"),
    CHLDCARE("CHLDCARE"),
    HLTHCARE("HLTHCARE"),
    PTNTCARE("PTNTCARE"),
    HOSPPTNT("HOSPPTNT"),
    HOSPVSTR("HOSPVSTR"),
    HOUSEHLD("HOUSEHLD"),
    INMATE("INMATE"),
    INTIMATE("INTIMATE"),
    LTRMCARE("LTRMCARE"),
    @XmlEnumValue("SCHOOL2")
    SCHOOL_2("SCHOOL2"),
    @XmlEnumValue("SOCIAL2")
    SOCIAL_2("SOCIAL2"),
    @XmlEnumValue("WORK2")
    WORK_2("WORK2");
    private final String value;

    ActExposureCode(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static ActExposureCode fromValue(String v) {
        for (ActExposureCode c: ActExposureCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
