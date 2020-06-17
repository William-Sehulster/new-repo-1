
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PedsClinPracticeSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PedsClinPracticeSetting"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PEDC"/&gt;
 *     &lt;enumeration value="PEDCARD"/&gt;
 *     &lt;enumeration value="PEDE"/&gt;
 *     &lt;enumeration value="PEDGI"/&gt;
 *     &lt;enumeration value="PEDHEM"/&gt;
 *     &lt;enumeration value="PEDID"/&gt;
 *     &lt;enumeration value="PEDNEPH"/&gt;
 *     &lt;enumeration value="PEDHO"/&gt;
 *     &lt;enumeration value="PEDRHEUM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PedsClinPracticeSetting")
@XmlEnum
public enum PedsClinPracticeSetting {

    PEDC,
    PEDCARD,
    PEDE,
    PEDGI,
    PEDHEM,
    PEDID,
    PEDNEPH,
    PEDHO,
    PEDRHEUM;

    public String getValue() {
        return name();
    }

    public static PedsClinPracticeSetting fromValue(String v) {
        return valueOf(v);
    }

}
