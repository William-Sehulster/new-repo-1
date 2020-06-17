
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntericCoatedCapsule.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntericCoatedCapsule"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ENTCAP"/&gt;
 *     &lt;enumeration value="ERENTCAP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EntericCoatedCapsule")
@XmlEnum
public enum EntericCoatedCapsule {

    ENTCAP,
    ERENTCAP;

    public String getValue() {
        return name();
    }

    public static EntericCoatedCapsule fromValue(String v) {
        return valueOf(v);
    }

}
