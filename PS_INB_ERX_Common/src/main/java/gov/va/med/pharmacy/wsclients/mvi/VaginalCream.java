
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VaginalCream.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VaginalCream"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="VAGCRM"/&gt;
 *     &lt;enumeration value="VAGCRMAPL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VaginalCream")
@XmlEnum
public enum VaginalCream {

    VAGCRM,
    VAGCRMAPL;

    public String getValue() {
        return name();
    }

    public static VaginalCream fromValue(String v) {
        return valueOf(v);
    }

}
