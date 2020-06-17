
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CentralMuskogean.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CentralMuskogean"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="x-AKZ"/&gt;
 *     &lt;enumeration value="x-CKU"/&gt;
 *     &lt;enumeration value="x-MIK"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CentralMuskogean")
@XmlEnum
public enum CentralMuskogean {

    @XmlEnumValue("x-AKZ")
    X_AKZ("x-AKZ"),
    @XmlEnumValue("x-CKU")
    X_CKU("x-CKU"),
    @XmlEnumValue("x-MIK")
    X_MIK("x-MIK");
    private final String value;

    CentralMuskogean(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static CentralMuskogean fromValue(String v) {
        for (CentralMuskogean c: CentralMuskogean.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
