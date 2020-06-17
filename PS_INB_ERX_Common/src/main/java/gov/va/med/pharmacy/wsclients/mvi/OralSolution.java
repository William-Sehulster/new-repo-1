
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OralSolution.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OralSolution"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ORALSOL"/&gt;
 *     &lt;enumeration value="ELIXIR"/&gt;
 *     &lt;enumeration value="RINSE"/&gt;
 *     &lt;enumeration value="ORDROP"/&gt;
 *     &lt;enumeration value="SYRUP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OralSolution")
@XmlEnum
public enum OralSolution {

    ORALSOL,
    ELIXIR,
    RINSE,
    ORDROP,
    SYRUP;

    public String getValue() {
        return name();
    }

    public static OralSolution fromValue(String v) {
        return valueOf(v);
    }

}
