
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DosageProblem.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DosageProblem"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="DOSE"/&gt;
 *     &lt;enumeration value="DOSEDUR"/&gt;
 *     &lt;enumeration value="DOSEIVL"/&gt;
 *     &lt;enumeration value="DOSEH"/&gt;
 *     &lt;enumeration value="DOSEL"/&gt;
 *     &lt;enumeration value="DOSECOND"/&gt;
 *     &lt;enumeration value="MDOSE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DosageProblem")
@XmlEnum
public enum DosageProblem {

    DOSE,
    DOSEDUR,
    DOSEIVL,
    DOSEH,
    DOSEL,
    DOSECOND,
    MDOSE;

    public String getValue() {
        return name();
    }

    public static DosageProblem fromValue(String v) {
        return valueOf(v);
    }

}
