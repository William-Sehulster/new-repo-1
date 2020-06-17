
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GTSAbbreviationHolidaysUSNational.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GTSAbbreviationHolidaysUSNational"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="JHNUS"/&gt;
 *     &lt;enumeration value="JHNUSCLM"/&gt;
 *     &lt;enumeration value="JHNUSIND"/&gt;
 *     &lt;enumeration value="JHNUSIND1"/&gt;
 *     &lt;enumeration value="JHNUSIND5"/&gt;
 *     &lt;enumeration value="JHNUSLBR"/&gt;
 *     &lt;enumeration value="JHNUSMEM"/&gt;
 *     &lt;enumeration value="JHNUSMEM5"/&gt;
 *     &lt;enumeration value="JHNUSMEM6"/&gt;
 *     &lt;enumeration value="JHNUSMLK"/&gt;
 *     &lt;enumeration value="JHNUSPRE"/&gt;
 *     &lt;enumeration value="JHNUSTKS"/&gt;
 *     &lt;enumeration value="JHNUSTKS5"/&gt;
 *     &lt;enumeration value="JHNUSVET"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "GTSAbbreviationHolidaysUSNational")
@XmlEnum
public enum GTSAbbreviationHolidaysUSNational {

    JHNUS("JHNUS"),
    JHNUSCLM("JHNUSCLM"),
    JHNUSIND("JHNUSIND"),
    @XmlEnumValue("JHNUSIND1")
    JHNUSIND_1("JHNUSIND1"),
    @XmlEnumValue("JHNUSIND5")
    JHNUSIND_5("JHNUSIND5"),
    JHNUSLBR("JHNUSLBR"),
    JHNUSMEM("JHNUSMEM"),
    @XmlEnumValue("JHNUSMEM5")
    JHNUSMEM_5("JHNUSMEM5"),
    @XmlEnumValue("JHNUSMEM6")
    JHNUSMEM_6("JHNUSMEM6"),
    JHNUSMLK("JHNUSMLK"),
    JHNUSPRE("JHNUSPRE"),
    JHNUSTKS("JHNUSTKS"),
    @XmlEnumValue("JHNUSTKS5")
    JHNUSTKS_5("JHNUSTKS5"),
    JHNUSVET("JHNUSVET");
    private final String value;

    GTSAbbreviationHolidaysUSNational(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static GTSAbbreviationHolidaysUSNational fromValue(String v) {
        for (GTSAbbreviationHolidaysUSNational c: GTSAbbreviationHolidaysUSNational.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
