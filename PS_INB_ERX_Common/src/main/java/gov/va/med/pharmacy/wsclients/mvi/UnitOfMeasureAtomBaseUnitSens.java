
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfMeasureAtomBaseUnitSens.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfMeasureAtomBaseUnitSens"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="K"/&gt;
 *     &lt;enumeration value="cd"/&gt;
 *     &lt;enumeration value="g"/&gt;
 *     &lt;enumeration value="m"/&gt;
 *     &lt;enumeration value="rad"/&gt;
 *     &lt;enumeration value="s"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "UnitOfMeasureAtomBaseUnitSens")
@XmlEnum
public enum UnitOfMeasureAtomBaseUnitSens {

    C("C"),
    K("K"),
    @XmlEnumValue("cd")
    CD("cd"),
    @XmlEnumValue("g")
    G("g"),
    @XmlEnumValue("m")
    M("m"),
    @XmlEnumValue("rad")
    RAD("rad"),
    @XmlEnumValue("s")
    S("s");
    private final String value;

    UnitOfMeasureAtomBaseUnitSens(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static UnitOfMeasureAtomBaseUnitSens fromValue(String v) {
        for (UnitOfMeasureAtomBaseUnitSens c: UnitOfMeasureAtomBaseUnitSens.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
