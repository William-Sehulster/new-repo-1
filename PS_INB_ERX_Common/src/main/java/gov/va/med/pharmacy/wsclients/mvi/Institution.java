
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Institution.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Institution"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="X"/&gt;
 *     &lt;enumeration value="G"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="CS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Institution")
@XmlEnum
public enum Institution {

    I,
    X,
    G,
    N,
    CS;

    public String getValue() {
        return name();
    }

    public static Institution fromValue(String v) {
        return valueOf(v);
    }

}
