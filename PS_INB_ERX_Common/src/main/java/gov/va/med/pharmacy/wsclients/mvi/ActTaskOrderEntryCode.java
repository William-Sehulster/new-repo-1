
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActTaskOrderEntryCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActTaskOrderEntryCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="OE"/&gt;
 *     &lt;enumeration value="LABOE"/&gt;
 *     &lt;enumeration value="MEDOE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActTaskOrderEntryCode")
@XmlEnum
public enum ActTaskOrderEntryCode {

    OE,
    LABOE,
    MEDOE;

    public String getValue() {
        return name();
    }

    public static ActTaskOrderEntryCode fromValue(String v) {
        return valueOf(v);
    }

}
