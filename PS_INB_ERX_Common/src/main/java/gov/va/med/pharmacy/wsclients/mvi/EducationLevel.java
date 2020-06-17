
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EducationLevel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EducationLevel"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ASSOC"/&gt;
 *     &lt;enumeration value="BD"/&gt;
 *     &lt;enumeration value="POSTG"/&gt;
 *     &lt;enumeration value="ELEM"/&gt;
 *     &lt;enumeration value="GD"/&gt;
 *     &lt;enumeration value="HS"/&gt;
 *     &lt;enumeration value="SCOL"/&gt;
 *     &lt;enumeration value="PB"/&gt;
 *     &lt;enumeration value="SEC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EducationLevel")
@XmlEnum
public enum EducationLevel {

    ASSOC,
    BD,
    POSTG,
    ELEM,
    GD,
    HS,
    SCOL,
    PB,
    SEC;

    public String getValue() {
        return name();
    }

    public static EducationLevel fromValue(String v) {
        return valueOf(v);
    }

}
