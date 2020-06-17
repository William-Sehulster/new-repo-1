
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SerranoGabrielino.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SerranoGabrielino"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-SER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SerranoGabrielino")
@XmlEnum
public enum SerranoGabrielino {

    @XmlEnumValue("x-SER")
    X_SER("x-SER");
    private final String value;

    SerranoGabrielino(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static SerranoGabrielino fromValue(String v) {
        for (SerranoGabrielino c: SerranoGabrielino.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
