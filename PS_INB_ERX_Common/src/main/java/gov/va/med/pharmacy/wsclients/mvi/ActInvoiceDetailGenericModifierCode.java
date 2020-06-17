
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInvoiceDetailGenericModifierCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInvoiceDetailGenericModifierCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ISOL"/&gt;
 *     &lt;enumeration value="AFTHRS"/&gt;
 *     &lt;enumeration value="OOO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInvoiceDetailGenericModifierCode")
@XmlEnum
public enum ActInvoiceDetailGenericModifierCode {

    ISOL,
    AFTHRS,
    OOO;

    public String getValue() {
        return name();
    }

    public static ActInvoiceDetailGenericModifierCode fromValue(String v) {
        return valueOf(v);
    }

}
