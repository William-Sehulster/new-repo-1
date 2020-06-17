
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInvoiceElementModifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInvoiceElementModifier"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EFORM"/&gt;
 *     &lt;enumeration value="FAX"/&gt;
 *     &lt;enumeration value="LINV"/&gt;
 *     &lt;enumeration value="PAPER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInvoiceElementModifier")
@XmlEnum
public enum ActInvoiceElementModifier {

    EFORM,
    FAX,
    LINV,
    PAPER;

    public String getValue() {
        return name();
    }

    public static ActInvoiceElementModifier fromValue(String v) {
        return valueOf(v);
    }

}
