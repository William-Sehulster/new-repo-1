
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfMeasureAtomBaseUnitInsens.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfMeasureAtomBaseUnitInsens"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="K"/&gt;
 *     &lt;enumeration value="CD"/&gt;
 *     &lt;enumeration value="G"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="RAD"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "UnitOfMeasureAtomBaseUnitInsens")
@XmlEnum
public enum UnitOfMeasureAtomBaseUnitInsens {

    C,
    K,
    CD,
    G,
    M,
    RAD,
    S;

    public String getValue() {
        return name();
    }

    public static UnitOfMeasureAtomBaseUnitInsens fromValue(String v) {
        return valueOf(v);
    }

}
