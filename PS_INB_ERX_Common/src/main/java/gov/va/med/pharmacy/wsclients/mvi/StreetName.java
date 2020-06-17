
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StreetName.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StreetName"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="STR"/&gt;
 *     &lt;enumeration value="STB"/&gt;
 *     &lt;enumeration value="STTYP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StreetName")
@XmlEnum
public enum StreetName {

    STR,
    STB,
    STTYP;

    public String getValue() {
        return name();
    }

    public static StreetName fromValue(String v) {
        return valueOf(v);
    }

}
