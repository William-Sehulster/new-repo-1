
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentCompletion.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DocumentCompletion"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AU"/&gt;
 *     &lt;enumeration value="DI"/&gt;
 *     &lt;enumeration value="DO"/&gt;
 *     &lt;enumeration value="IP"/&gt;
 *     &lt;enumeration value="IN"/&gt;
 *     &lt;enumeration value="LA"/&gt;
 *     &lt;enumeration value="PA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DocumentCompletion")
@XmlEnum
public enum DocumentCompletion {

    AU,
    DI,
    DO,
    IP,
    IN,
    LA,
    PA;

    public String getValue() {
        return name();
    }

    public static DocumentCompletion fromValue(String v) {
        return valueOf(v);
    }

}
