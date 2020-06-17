
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NieceNephew.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NieceNephew"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="NIENEPH"/&gt;
 *     &lt;enumeration value="NEPHEW"/&gt;
 *     &lt;enumeration value="NIECE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NieceNephew")
@XmlEnum
public enum NieceNephew {

    NIENEPH,
    NEPHEW,
    NIECE;

    public String getValue() {
        return name();
    }

    public static NieceNephew fromValue(String v) {
        return valueOf(v);
    }

}
