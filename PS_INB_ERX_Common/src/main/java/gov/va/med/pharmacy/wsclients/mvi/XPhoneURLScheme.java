
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_PhoneURLScheme.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_PhoneURLScheme"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="fax"/&gt;
 *     &lt;enumeration value="tel"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_PhoneURLScheme")
@XmlEnum
public enum XPhoneURLScheme {

    @XmlEnumValue("fax")
    FAX("fax"),
    @XmlEnumValue("tel")
    TEL("tel");
    private final String value;

    XPhoneURLScheme(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static XPhoneURLScheme fromValue(String v) {
        for (XPhoneURLScheme c: XPhoneURLScheme.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
