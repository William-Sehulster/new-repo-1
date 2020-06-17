
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartialCompletionScale.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PartialCompletionScale"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="G"/&gt;
 *     &lt;enumeration value="LE"/&gt;
 *     &lt;enumeration value="ME"/&gt;
 *     &lt;enumeration value="MI"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PartialCompletionScale")
@XmlEnum
public enum PartialCompletionScale {

    G,
    LE,
    ME,
    MI,
    N,
    S;

    public String getValue() {
        return name();
    }

    public static PartialCompletionScale fromValue(String v) {
        return valueOf(v);
    }

}
