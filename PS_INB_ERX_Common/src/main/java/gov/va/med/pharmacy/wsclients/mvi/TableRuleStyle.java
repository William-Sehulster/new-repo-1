
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TableRuleStyle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TableRuleStyle"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="Botrule"/&gt;
 *     &lt;enumeration value="Lrule"/&gt;
 *     &lt;enumeration value="Rrule"/&gt;
 *     &lt;enumeration value="Toprule"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TableRuleStyle")
@XmlEnum
public enum TableRuleStyle {

    @XmlEnumValue("Botrule")
    BOTRULE("Botrule"),
    @XmlEnumValue("Lrule")
    LRULE("Lrule"),
    @XmlEnumValue("Rrule")
    RRULE("Rrule"),
    @XmlEnumValue("Toprule")
    TOPRULE("Toprule");
    private final String value;

    TableRuleStyle(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static TableRuleStyle fromValue(String v) {
        for (TableRuleStyle c: TableRuleStyle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
