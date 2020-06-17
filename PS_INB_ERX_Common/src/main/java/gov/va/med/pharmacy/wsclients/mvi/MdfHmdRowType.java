
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MdfHmdRowType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MdfHmdRowType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="assoc"/&gt;
 *     &lt;enumeration value="attr"/&gt;
 *     &lt;enumeration value="item"/&gt;
 *     &lt;enumeration value="hmd"/&gt;
 *     &lt;enumeration value="class"/&gt;
 *     &lt;enumeration value="stc"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MdfHmdRowType")
@XmlEnum
public enum MdfHmdRowType {

    @XmlEnumValue("assoc")
    ASSOC("assoc"),
    @XmlEnumValue("attr")
    ATTR("attr"),
    @XmlEnumValue("item")
    ITEM("item"),
    @XmlEnumValue("hmd")
    HMD("hmd"),
    @XmlEnumValue("class")
    CLASS("class"),
    @XmlEnumValue("stc")
    STC("stc");
    private final String value;

    MdfHmdRowType(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static MdfHmdRowType fromValue(String v) {
        for (MdfHmdRowType c: MdfHmdRowType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
