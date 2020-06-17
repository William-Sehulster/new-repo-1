
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContainerSeparator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContainerSeparator"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="GEL"/&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ContainerSeparator")
@XmlEnum
public enum ContainerSeparator {

    GEL,
    NONE;

    public String getValue() {
        return name();
    }

    public static ContainerSeparator fromValue(String v) {
        return valueOf(v);
    }

}
