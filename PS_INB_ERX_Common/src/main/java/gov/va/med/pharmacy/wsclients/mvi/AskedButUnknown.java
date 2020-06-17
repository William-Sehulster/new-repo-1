
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AskedButUnknown.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AskedButUnknown"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ASKU"/&gt;
 *     &lt;enumeration value="NAV"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AskedButUnknown")
@XmlEnum
public enum AskedButUnknown {

    ASKU,
    NAV;

    public String getValue() {
        return name();
    }

    public static AskedButUnknown fromValue(String v) {
        return valueOf(v);
    }

}
