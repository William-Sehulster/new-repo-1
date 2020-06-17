
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdoptedChild.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdoptedChild"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CHLDADOPT"/&gt;
 *     &lt;enumeration value="DAUADOPT"/&gt;
 *     &lt;enumeration value="SONADOPT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AdoptedChild")
@XmlEnum
public enum AdoptedChild {

    CHLDADOPT,
    DAUADOPT,
    SONADOPT;

    public String getValue() {
        return name();
    }

    public static AdoptedChild fromValue(String v) {
        return valueOf(v);
    }

}
