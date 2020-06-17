
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActTaskClinicalNoteEntryCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActTaskClinicalNoteEntryCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CLINNOTEE"/&gt;
 *     &lt;enumeration value="DIAGLISTE"/&gt;
 *     &lt;enumeration value="DISCHSUME"/&gt;
 *     &lt;enumeration value="PATREPE"/&gt;
 *     &lt;enumeration value="PROBLISTE"/&gt;
 *     &lt;enumeration value="RADREPE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActTaskClinicalNoteEntryCode")
@XmlEnum
public enum ActTaskClinicalNoteEntryCode {

    CLINNOTEE,
    DIAGLISTE,
    DISCHSUME,
    PATREPE,
    PROBLISTE,
    RADREPE;

    public String getValue() {
        return name();
    }

    public static ActTaskClinicalNoteEntryCode fromValue(String v) {
        return valueOf(v);
    }

}
