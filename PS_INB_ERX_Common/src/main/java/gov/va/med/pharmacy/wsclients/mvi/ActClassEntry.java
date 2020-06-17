
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassEntry.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassEntry"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ENTRY"/&gt;
 *     &lt;enumeration value="CLUSTER"/&gt;
 *     &lt;enumeration value="BATTERY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActClassEntry")
@XmlEnum
public enum ActClassEntry {

    ENTRY,
    CLUSTER,
    BATTERY;

    public String getValue() {
        return name();
    }

    public static ActClassEntry fromValue(String v) {
        return valueOf(v);
    }

}
