
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrescriptionDispenseFilterCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrescriptionDispenseFilterCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="R"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PrescriptionDispenseFilterCode")
@XmlEnum
public enum PrescriptionDispenseFilterCode {

    C,
    R,
    N;

    public String getValue() {
        return name();
    }

    public static PrescriptionDispenseFilterCode fromValue(String v) {
        return valueOf(v);
    }

}
