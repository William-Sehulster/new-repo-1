
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActMoodPermPermrq.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActMoodPermPermrq"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PERM"/&gt;
 *     &lt;enumeration value="PERMRQ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ActMoodPermPermrq")
@XmlEnum
public enum XActMoodPermPermrq {

    PERM,
    PERMRQ;

    public String getValue() {
        return name();
    }

    public static XActMoodPermPermrq fromValue(String v) {
        return valueOf(v);
    }

}
