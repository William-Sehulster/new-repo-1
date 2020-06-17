
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActReplaceOrRevise.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActReplaceOrRevise"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="MOD"/&gt;
 *     &lt;enumeration value="RPLC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ActReplaceOrRevise")
@XmlEnum
public enum XActReplaceOrRevise {

    MOD,
    RPLC;

    public String getValue() {
        return name();
    }

    public static XActReplaceOrRevise fromValue(String v) {
        return valueOf(v);
    }

}
