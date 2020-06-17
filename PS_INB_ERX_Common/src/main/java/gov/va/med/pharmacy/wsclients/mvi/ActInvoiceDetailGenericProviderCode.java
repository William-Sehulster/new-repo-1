
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInvoiceDetailGenericProviderCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInvoiceDetailGenericProviderCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CANCAPT"/&gt;
 *     &lt;enumeration value="DSC"/&gt;
 *     &lt;enumeration value="ESA"/&gt;
 *     &lt;enumeration value="FFSTOP"/&gt;
 *     &lt;enumeration value="FNLFEE"/&gt;
 *     &lt;enumeration value="FRSTFEE"/&gt;
 *     &lt;enumeration value="MARKUP"/&gt;
 *     &lt;enumeration value="MISSAPT"/&gt;
 *     &lt;enumeration value="PERMBNS"/&gt;
 *     &lt;enumeration value="PERFEE"/&gt;
 *     &lt;enumeration value="RESTOCK"/&gt;
 *     &lt;enumeration value="TRAVEL"/&gt;
 *     &lt;enumeration value="URGENT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInvoiceDetailGenericProviderCode")
@XmlEnum
public enum ActInvoiceDetailGenericProviderCode {

    CANCAPT,
    DSC,
    ESA,
    FFSTOP,
    FNLFEE,
    FRSTFEE,
    MARKUP,
    MISSAPT,
    PERMBNS,
    PERFEE,
    RESTOCK,
    TRAVEL,
    URGENT;

    public String getValue() {
        return name();
    }

    public static ActInvoiceDetailGenericProviderCode fromValue(String v) {
        return valueOf(v);
    }

}
