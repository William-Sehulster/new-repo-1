
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransdermalPatch.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransdermalPatch"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="TPATCH"/&gt;
 *     &lt;enumeration value="TPATH16"/&gt;
 *     &lt;enumeration value="TPATH24"/&gt;
 *     &lt;enumeration value="TPATH72"/&gt;
 *     &lt;enumeration value="TPATH2WK"/&gt;
 *     &lt;enumeration value="TPATHWK"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TransdermalPatch")
@XmlEnum
public enum TransdermalPatch {

    TPATCH("TPATCH"),
    @XmlEnumValue("TPATH16")
    TPATH_16("TPATH16"),
    @XmlEnumValue("TPATH24")
    TPATH_24("TPATH24"),
    @XmlEnumValue("TPATH72")
    TPATH_72("TPATH72"),
    @XmlEnumValue("TPATH2WK")
    TPATH_2_WK("TPATH2WK"),
    TPATHWK("TPATHWK");
    private final String value;

    TransdermalPatch(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static TransdermalPatch fromValue(String v) {
        for (TransdermalPatch c: TransdermalPatch.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
