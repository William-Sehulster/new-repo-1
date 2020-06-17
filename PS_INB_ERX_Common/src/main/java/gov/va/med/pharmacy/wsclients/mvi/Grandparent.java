
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Grandparent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Grandparent"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="GRPRN"/&gt;
 *     &lt;enumeration value="GRFTH"/&gt;
 *     &lt;enumeration value="GRMTH"/&gt;
 *     &lt;enumeration value="MGRFTH"/&gt;
 *     &lt;enumeration value="MGRMTH"/&gt;
 *     &lt;enumeration value="MGRPRN"/&gt;
 *     &lt;enumeration value="PGRFTH"/&gt;
 *     &lt;enumeration value="PGRMTH"/&gt;
 *     &lt;enumeration value="PGRPRN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Grandparent")
@XmlEnum
public enum Grandparent {

    GRPRN,
    GRFTH,
    GRMTH,
    MGRFTH,
    MGRMTH,
    MGRPRN,
    PGRFTH,
    PGRMTH,
    PGRPRN;

    public String getValue() {
        return name();
    }

    public static Grandparent fromValue(String v) {
        return valueOf(v);
    }

}
