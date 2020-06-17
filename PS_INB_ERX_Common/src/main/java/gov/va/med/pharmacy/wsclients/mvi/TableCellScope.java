
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TableCellScope.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TableCellScope"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="col"/&gt;
 *     &lt;enumeration value="colgroup"/&gt;
 *     &lt;enumeration value="row"/&gt;
 *     &lt;enumeration value="rowgroup"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TableCellScope")
@XmlEnum
public enum TableCellScope {

    @XmlEnumValue("col")
    COL("col"),
    @XmlEnumValue("colgroup")
    COLGROUP("colgroup"),
    @XmlEnumValue("row")
    ROW("row"),
    @XmlEnumValue("rowgroup")
    ROWGROUP("rowgroup");
    private final String value;

    TableCellScope(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static TableCellScope fromValue(String v) {
        for (TableCellScope c: TableCellScope.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
