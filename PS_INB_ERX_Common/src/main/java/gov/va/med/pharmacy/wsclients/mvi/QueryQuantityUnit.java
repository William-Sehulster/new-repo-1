
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryQuantityUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="QueryQuantityUnit"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CH"/&gt;
 *     &lt;enumeration value="LI"/&gt;
 *     &lt;enumeration value="PG"/&gt;
 *     &lt;enumeration value="RD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "QueryQuantityUnit")
@XmlEnum
public enum QueryQuantityUnit {

    CH,
    LI,
    PG,
    RD;

    public String getValue() {
        return name();
    }

    public static QueryQuantityUnit fromValue(String v) {
        return valueOf(v);
    }

}
