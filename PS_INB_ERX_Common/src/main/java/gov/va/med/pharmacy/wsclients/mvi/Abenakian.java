
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Abenakian.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Abenakian"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-AAQ"/&gt;
 *     &lt;enumeration value="x-MAC"/&gt;
 *     &lt;enumeration value="x-ABE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Abenakian")
@XmlEnum
public enum Abenakian {

    @XmlEnumValue("x-AAQ")
    X_AAQ("x-AAQ"),
    @XmlEnumValue("x-MAC")
    X_MAC("x-MAC"),
    @XmlEnumValue("x-ABE")
    X_ABE("x-ABE");
    private final String value;

    Abenakian(String v) {
        value = v;
    }

   

    public static Abenakian fromValue(String v) {
        for (Abenakian c: Abenakian.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }



	public String getValue() {
		return value;
	}

}
