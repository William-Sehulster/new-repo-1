
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Currency.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Currency"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ARS"/&gt;
 *     &lt;enumeration value="AUD"/&gt;
 *     &lt;enumeration value="THB"/&gt;
 *     &lt;enumeration value="BRL"/&gt;
 *     &lt;enumeration value="CAD"/&gt;
 *     &lt;enumeration value="DEM"/&gt;
 *     &lt;enumeration value="EUR"/&gt;
 *     &lt;enumeration value="FRF"/&gt;
 *     &lt;enumeration value="INR"/&gt;
 *     &lt;enumeration value="TRL"/&gt;
 *     &lt;enumeration value="FIM"/&gt;
 *     &lt;enumeration value="MXN"/&gt;
 *     &lt;enumeration value="NLG"/&gt;
 *     &lt;enumeration value="NZD"/&gt;
 *     &lt;enumeration value="PHP"/&gt;
 *     &lt;enumeration value="GBP"/&gt;
 *     &lt;enumeration value="ZAR"/&gt;
 *     &lt;enumeration value="RUR"/&gt;
 *     &lt;enumeration value="ILS"/&gt;
 *     &lt;enumeration value="ESP"/&gt;
 *     &lt;enumeration value="CHF"/&gt;
 *     &lt;enumeration value="TWD"/&gt;
 *     &lt;enumeration value="USD"/&gt;
 *     &lt;enumeration value="CLF"/&gt;
 *     &lt;enumeration value="KRW"/&gt;
 *     &lt;enumeration value="JPY"/&gt;
 *     &lt;enumeration value="CNY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Currency")
@XmlEnum
public enum Currency {

    ARS,
    AUD,
    THB,
    BRL,
    CAD,
    DEM,
    EUR,
    FRF,
    INR,
    TRL,
    FIM,
    MXN,
    NLG,
    NZD,
    PHP,
    GBP,
    ZAR,
    RUR,
    ILS,
    ESP,
    CHF,
    TWD,
    USD,
    CLF,
    KRW,
    JPY,
    CNY;

    public String getValue() {
        return name();
    }

    public static Currency fromValue(String v) {
        return valueOf(v);
    }

}
