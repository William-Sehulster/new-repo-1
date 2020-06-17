
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlasticBottleEntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlasticBottleEntityType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BOTP"/&gt;
 *     &lt;enumeration value="BOTPLY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PlasticBottleEntityType")
@XmlEnum
public enum PlasticBottleEntityType {

    BOTP,
    BOTPLY;

    public String getValue() {
        return name();
    }

    public static PlasticBottleEntityType fromValue(String v) {
        return valueOf(v);
    }

}
