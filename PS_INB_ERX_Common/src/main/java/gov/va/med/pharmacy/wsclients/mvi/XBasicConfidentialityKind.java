
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_BasicConfidentialityKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_BasicConfidentialityKind"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *     &lt;enumeration value="V"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_BasicConfidentialityKind")
@XmlEnum
public enum XBasicConfidentialityKind {

    N,
    R,
    V;

    public String getValue() {
        return name();
    }

    public static XBasicConfidentialityKind fromValue(String v) {
        return valueOf(v);
    }

}
