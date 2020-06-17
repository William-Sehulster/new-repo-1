
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInvoiceInterGroupCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInvoiceInterGroupCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CPNDDRGING"/&gt;
 *     &lt;enumeration value="CPNDINDING"/&gt;
 *     &lt;enumeration value="CPNDSUPING"/&gt;
 *     &lt;enumeration value="DRUGING"/&gt;
 *     &lt;enumeration value="FRAMEING"/&gt;
 *     &lt;enumeration value="LENSING"/&gt;
 *     &lt;enumeration value="PRDING"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInvoiceInterGroupCode")
@XmlEnum
public enum ActInvoiceInterGroupCode {

    CPNDDRGING,
    CPNDINDING,
    CPNDSUPING,
    DRUGING,
    FRAMEING,
    LENSING,
    PRDING;

    public String getValue() {
        return name();
    }

    public static ActInvoiceInterGroupCode fromValue(String v) {
        return valueOf(v);
    }

}
