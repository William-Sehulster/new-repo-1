
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Implantation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Implantation"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IDIMPLNT"/&gt;
 *     &lt;enumeration value="IVITIMPLNT"/&gt;
 *     &lt;enumeration value="SQIMPLNT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Implantation")
@XmlEnum
public enum Implantation {

    IDIMPLNT,
    IVITIMPLNT,
    SQIMPLNT;

    public String getValue() {
        return name();
    }

    public static Implantation fromValue(String v) {
        return valueOf(v);
    }

}
