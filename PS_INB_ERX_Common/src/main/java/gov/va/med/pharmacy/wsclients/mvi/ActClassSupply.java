
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassSupply.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassSupply"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SPLY"/&gt;
 *     &lt;enumeration value="DIET"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActClassSupply")
@XmlEnum
public enum ActClassSupply {

    SPLY,
    DIET;

    public String getValue() {
        return name();
    }

    public static ActClassSupply fromValue(String v) {
        return valueOf(v);
    }

}
