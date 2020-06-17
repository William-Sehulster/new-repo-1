
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GTSAbbreviationHolidaysChristianRoman.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GTSAbbreviationHolidaysChristianRoman"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="JHCHREAS"/&gt;
 *     &lt;enumeration value="JHCHRGFR"/&gt;
 *     &lt;enumeration value="JHCHRNEW"/&gt;
 *     &lt;enumeration value="JHCHRPEN"/&gt;
 *     &lt;enumeration value="JHCHRXME"/&gt;
 *     &lt;enumeration value="JHCHRXMS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "GTSAbbreviationHolidaysChristianRoman")
@XmlEnum
public enum GTSAbbreviationHolidaysChristianRoman {

    JHCHREAS,
    JHCHRGFR,
    JHCHRNEW,
    JHCHRPEN,
    JHCHRXME,
    JHCHRXMS;

    public String getValue() {
        return name();
    }

    public static GTSAbbreviationHolidaysChristianRoman fromValue(String v) {
        return valueOf(v);
    }

}
