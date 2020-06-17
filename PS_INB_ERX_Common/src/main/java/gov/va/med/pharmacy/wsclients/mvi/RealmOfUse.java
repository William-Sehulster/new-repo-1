
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RealmOfUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RealmOfUse"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="Canada"/&gt;
 *     &lt;enumeration value="NorthAmerica"/&gt;
 *     &lt;enumeration value="USA"/&gt;
 *     &lt;enumeration value="UV"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RealmOfUse")
@XmlEnum
public enum RealmOfUse {

    @XmlEnumValue("Canada")
    CANADA("Canada"),
    @XmlEnumValue("NorthAmerica")
    NORTH_AMERICA("NorthAmerica"),
    USA("USA"),
    UV("UV");
    private final String value;

    RealmOfUse(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static RealmOfUse fromValue(String v) {
        for (RealmOfUse c: RealmOfUse.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
