
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FontStyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FontStyle"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="bold"/&gt;
 *     &lt;enumeration value="emphasis"/&gt;
 *     &lt;enumeration value="italics"/&gt;
 *     &lt;enumeration value="underline"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FontStyle")
@XmlEnum
public enum FontStyle {

    @XmlEnumValue("bold")
    BOLD("bold"),
    @XmlEnumValue("emphasis")
    EMPHASIS("emphasis"),
    @XmlEnumValue("italics")
    ITALICS("italics"),
    @XmlEnumValue("underline")
    UNDERLINE("underline");
    private final String value;

    FontStyle(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static FontStyle fromValue(String v) {
        for (FontStyle c: FontStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
