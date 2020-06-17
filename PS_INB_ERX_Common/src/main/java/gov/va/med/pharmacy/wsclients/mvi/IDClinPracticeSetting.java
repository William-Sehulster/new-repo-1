
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDClinPracticeSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IDClinPracticeSetting"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="INFD"/&gt;
 *     &lt;enumeration value="PEDID"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IDClinPracticeSetting")
@XmlEnum
public enum IDClinPracticeSetting {

    INFD,
    PEDID;

    public String getValue() {
        return name();
    }

    public static IDClinPracticeSetting fromValue(String v) {
        return valueOf(v);
    }

}
