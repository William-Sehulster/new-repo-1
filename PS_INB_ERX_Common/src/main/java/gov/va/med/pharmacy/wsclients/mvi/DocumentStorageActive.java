
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentStorageActive.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DocumentStorageActive"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AC"/&gt;
 *     &lt;enumeration value="AA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DocumentStorageActive")
@XmlEnum
public enum DocumentStorageActive {

    AC,
    AA;

    public String getValue() {
        return name();
    }

    public static DocumentStorageActive fromValue(String v) {
        return valueOf(v);
    }

}
