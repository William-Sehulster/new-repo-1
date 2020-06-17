
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubsidizedHealthProgram.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubsidizedHealthProgram"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SUBSIDIZ"/&gt;
 *     &lt;enumeration value="SUBSIDMC"/&gt;
 *     &lt;enumeration value="SUBSUPP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SubsidizedHealthProgram")
@XmlEnum
public enum SubsidizedHealthProgram {

    SUBSIDIZ,
    SUBSIDMC,
    SUBSUPP;

    public String getValue() {
        return name();
    }

    public static SubsidizedHealthProgram fromValue(String v) {
        return valueOf(v);
    }

}
