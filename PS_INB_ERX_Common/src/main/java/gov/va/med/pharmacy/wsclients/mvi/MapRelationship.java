
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MapRelationship.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MapRelationship"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BT"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="NT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MapRelationship")
@XmlEnum
public enum MapRelationship {

    BT,
    E,
    NT;

    public String getValue() {
        return name();
    }

    public static MapRelationship fromValue(String v) {
        return valueOf(v);
    }

}
