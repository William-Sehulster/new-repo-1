
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntraesophagealRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntraesophagealRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IESOPHINSTIL"/&gt;
 *     &lt;enumeration value="IESOPHTA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntraesophagealRoute")
@XmlEnum
public enum IntraesophagealRoute {

    IESOPHINSTIL,
    IESOPHTA;

    public String getValue() {
        return name();
    }

    public static IntraesophagealRoute fromValue(String v) {
        return valueOf(v);
    }

}
