
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TopicalPowder.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TopicalPowder"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="TOPPWD"/&gt;
 *     &lt;enumeration value="RECPWD"/&gt;
 *     &lt;enumeration value="VAGPWD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TopicalPowder")
@XmlEnum
public enum TopicalPowder {

    TOPPWD,
    RECPWD,
    VAGPWD;

    public String getValue() {
        return name();
    }

    public static TopicalPowder fromValue(String v) {
        return valueOf(v);
    }

}
