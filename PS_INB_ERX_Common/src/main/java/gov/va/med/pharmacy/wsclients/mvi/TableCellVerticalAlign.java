
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TableCellVerticalAlign.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TableCellVerticalAlign"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="baseline"/&gt;
 *     &lt;enumeration value="bottom"/&gt;
 *     &lt;enumeration value="middle"/&gt;
 *     &lt;enumeration value="top"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TableCellVerticalAlign")
@XmlEnum
public enum TableCellVerticalAlign {

    @XmlEnumValue("baseline")
    BASELINE("baseline"),
    @XmlEnumValue("bottom")
    BOTTOM("bottom"),
    @XmlEnumValue("middle")
    MIDDLE("middle"),
    @XmlEnumValue("top")
    TOP("top");
    private final String value;

    TableCellVerticalAlign(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static TableCellVerticalAlign fromValue(String v) {
        for (TableCellVerticalAlign c: TableCellVerticalAlign.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
