
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntrabronchialRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntrabronchialRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IBRONCHINSTIL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntrabronchialRoute")
@XmlEnum
public enum IntrabronchialRoute {

    IBRONCHINSTIL;

    public String getValue() {
        return name();
    }

    public static IntrabronchialRoute fromValue(String v) {
        return valueOf(v);
    }

}
