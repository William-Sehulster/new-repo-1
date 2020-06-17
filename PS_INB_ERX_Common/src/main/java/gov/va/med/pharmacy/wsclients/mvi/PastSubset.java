
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PastSubset.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PastSubset"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PAST"/&gt;
 *     &lt;enumeration value="FIRST"/&gt;
 *     &lt;enumeration value="RECENT"/&gt;
 *     &lt;enumeration value="PREVSUM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PastSubset")
@XmlEnum
public enum PastSubset {

    PAST,
    FIRST,
    RECENT,
    PREVSUM;

    public String getValue() {
        return name();
    }

    public static PastSubset fromValue(String v) {
        return valueOf(v);
    }

}
