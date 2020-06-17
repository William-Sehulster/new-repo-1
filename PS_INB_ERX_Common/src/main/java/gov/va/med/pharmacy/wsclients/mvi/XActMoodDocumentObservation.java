
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActMoodDocumentObservation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActMoodDocumentObservation"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="GOL"/&gt;
 *     &lt;enumeration value="DEF"/&gt;
 *     &lt;enumeration value="EVN"/&gt;
 *     &lt;enumeration value="INT"/&gt;
 *     &lt;enumeration value="PRMS"/&gt;
 *     &lt;enumeration value="PRP"/&gt;
 *     &lt;enumeration value="RQO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ActMoodDocumentObservation")
@XmlEnum
public enum XActMoodDocumentObservation {

    GOL,
    DEF,
    EVN,
    INT,
    PRMS,
    PRP,
    RQO;

    public String getValue() {
        return name();
    }

    public static XActMoodDocumentObservation fromValue(String v) {
        return valueOf(v);
    }

}
