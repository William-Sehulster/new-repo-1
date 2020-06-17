
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Enema.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Enema"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ENEMA"/&gt;
 *     &lt;enumeration value="RETENEMA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Enema")
@XmlEnum
public enum Enema {

    ENEMA,
    RETENEMA;

    public String getValue() {
        return name();
    }

    public static Enema fromValue(String v) {
        return valueOf(v);
    }

}
