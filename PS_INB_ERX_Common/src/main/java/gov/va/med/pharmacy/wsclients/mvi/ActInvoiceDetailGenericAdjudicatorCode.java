
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInvoiceDetailGenericAdjudicatorCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInvoiceDetailGenericAdjudicatorCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="COIN"/&gt;
 *     &lt;enumeration value="DEDUCTIBLE"/&gt;
 *     &lt;enumeration value="COPAYMENT"/&gt;
 *     &lt;enumeration value="PAY"/&gt;
 *     &lt;enumeration value="SPEND"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInvoiceDetailGenericAdjudicatorCode")
@XmlEnum
public enum ActInvoiceDetailGenericAdjudicatorCode {

    COIN,
    DEDUCTIBLE,
    COPAYMENT,
    PAY,
    SPEND;

    public String getValue() {
        return name();
    }

    public static ActInvoiceDetailGenericAdjudicatorCode fromValue(String v) {
        return valueOf(v);
    }

}
