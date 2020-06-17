
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TableCellHorizontalAlign.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TableCellHorizontalAlign"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="center"/&gt;
 *     &lt;enumeration value="char"/&gt;
 *     &lt;enumeration value="justify"/&gt;
 *     &lt;enumeration value="left"/&gt;
 *     &lt;enumeration value="right"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TableCellHorizontalAlign")
@XmlEnum
public enum TableCellHorizontalAlign {

    @XmlEnumValue("center")
    CENTER("center"),
    @XmlEnumValue("char")
    CHAR("char"),
    @XmlEnumValue("justify")
    JUSTIFY("justify"),
    @XmlEnumValue("left")
    LEFT("left"),
    @XmlEnumValue("right")
    RIGHT("right");
    private final String value;

    TableCellHorizontalAlign(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static TableCellHorizontalAlign fromValue(String v) {
        for (TableCellHorizontalAlign c: TableCellHorizontalAlign.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
