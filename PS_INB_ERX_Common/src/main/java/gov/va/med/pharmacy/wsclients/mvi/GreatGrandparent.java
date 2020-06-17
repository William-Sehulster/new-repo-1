
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GreatGrandparent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GreatGrandparent"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="GGRPRN"/&gt;
 *     &lt;enumeration value="MGGRFTH"/&gt;
 *     &lt;enumeration value="MGGRMTH"/&gt;
 *     &lt;enumeration value="MGGRPRN"/&gt;
 *     &lt;enumeration value="PGGRFTH"/&gt;
 *     &lt;enumeration value="PGGRMTH"/&gt;
 *     &lt;enumeration value="PGGRPRN"/&gt;
 *     &lt;enumeration value="GGRFTH"/&gt;
 *     &lt;enumeration value="GGRMTH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "GreatGrandparent")
@XmlEnum
public enum GreatGrandparent {

    GGRPRN,
    MGGRFTH,
    MGGRMTH,
    MGGRPRN,
    PGGRFTH,
    PGGRMTH,
    PGGRPRN,
    GGRFTH,
    GGRMTH;

    public String getValue() {
        return name();
    }

    public static GreatGrandparent fromValue(String v) {
        return valueOf(v);
    }

}
