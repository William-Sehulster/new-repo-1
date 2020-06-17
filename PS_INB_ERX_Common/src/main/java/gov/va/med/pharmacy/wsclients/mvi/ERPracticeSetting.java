
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ERPracticeSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ERPracticeSetting"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ER"/&gt;
 *     &lt;enumeration value="ETU"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ERPracticeSetting")
@XmlEnum
public enum ERPracticeSetting {

    ER,
    ETU;

    public String getValue() {
        return name();
    }

    public static ERPracticeSetting fromValue(String v) {
        return valueOf(v);
    }

}
