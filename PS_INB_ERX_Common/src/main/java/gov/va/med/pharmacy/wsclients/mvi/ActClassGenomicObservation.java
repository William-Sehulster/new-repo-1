
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassGenomicObservation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassGenomicObservation"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="GEN"/&gt;
 *     &lt;enumeration value="SEQ"/&gt;
 *     &lt;enumeration value="SEQVAR"/&gt;
 *     &lt;enumeration value="DETPOL"/&gt;
 *     &lt;enumeration value="EXP"/&gt;
 *     &lt;enumeration value="LOC"/&gt;
 *     &lt;enumeration value="PHN"/&gt;
 *     &lt;enumeration value="POL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActClassGenomicObservation")
@XmlEnum
public enum ActClassGenomicObservation {

    GEN,
    SEQ,
    SEQVAR,
    DETPOL,
    EXP,
    LOC,
    PHN,
    POL;

    public String getValue() {
        return name();
    }

    public static ActClassGenomicObservation fromValue(String v) {
        return valueOf(v);
    }

}
