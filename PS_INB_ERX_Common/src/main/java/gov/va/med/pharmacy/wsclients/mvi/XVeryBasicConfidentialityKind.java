
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_VeryBasicConfidentialityKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_VeryBasicConfidentialityKind"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_VeryBasicConfidentialityKind")
@XmlEnum
public enum XVeryBasicConfidentialityKind {

    N,
    R;

    public String getValue() {
        return name();
    }

    public static XVeryBasicConfidentialityKind fromValue(String v) {
        return valueOf(v);
    }

}
