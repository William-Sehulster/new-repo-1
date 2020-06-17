
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInvoiceAdjudicationPaymentSummaryCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInvoiceAdjudicationPaymentSummaryCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CONT"/&gt;
 *     &lt;enumeration value="DAY"/&gt;
 *     &lt;enumeration value="INVTYPE"/&gt;
 *     &lt;enumeration value="LOC"/&gt;
 *     &lt;enumeration value="MONTH"/&gt;
 *     &lt;enumeration value="PAYEE"/&gt;
 *     &lt;enumeration value="PAYOR"/&gt;
 *     &lt;enumeration value="PERIOD"/&gt;
 *     &lt;enumeration value="PROV"/&gt;
 *     &lt;enumeration value="SENDAPP"/&gt;
 *     &lt;enumeration value="WEEK"/&gt;
 *     &lt;enumeration value="YEAR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInvoiceAdjudicationPaymentSummaryCode")
@XmlEnum
public enum ActInvoiceAdjudicationPaymentSummaryCode {

    CONT,
    DAY,
    INVTYPE,
    LOC,
    MONTH,
    PAYEE,
    PAYOR,
    PERIOD,
    PROV,
    SENDAPP,
    WEEK,
    YEAR;

    public String getValue() {
        return name();
    }

    public static ActInvoiceAdjudicationPaymentSummaryCode fromValue(String v) {
        return valueOf(v);
    }

}
