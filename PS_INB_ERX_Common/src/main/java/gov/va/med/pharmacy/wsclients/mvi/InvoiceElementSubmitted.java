
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvoiceElementSubmitted.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InvoiceElementSubmitted"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SBBLELAT"/&gt;
 *     &lt;enumeration value="SBBLELCT"/&gt;
 *     &lt;enumeration value="SBNFELCT"/&gt;
 *     &lt;enumeration value="SBNFELAT"/&gt;
 *     &lt;enumeration value="SBPDELAT"/&gt;
 *     &lt;enumeration value="SBPDELCT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "InvoiceElementSubmitted")
@XmlEnum
public enum InvoiceElementSubmitted {

    SBBLELAT,
    SBBLELCT,
    SBNFELCT,
    SBNFELAT,
    SBPDELAT,
    SBPDELCT;

    public String getValue() {
        return name();
    }

    public static InvoiceElementSubmitted fromValue(String v) {
        return valueOf(v);
    }

}
