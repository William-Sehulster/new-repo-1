
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliveryAddressLine.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeliveryAddressLine"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="DAL"/&gt;
 *     &lt;enumeration value="DINSTA"/&gt;
 *     &lt;enumeration value="DINSTQ"/&gt;
 *     &lt;enumeration value="DINST"/&gt;
 *     &lt;enumeration value="DMOD"/&gt;
 *     &lt;enumeration value="DMODID"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DeliveryAddressLine")
@XmlEnum
public enum DeliveryAddressLine {

    DAL,
    DINSTA,
    DINSTQ,
    DINST,
    DMOD,
    DMODID;

    public String getValue() {
        return name();
    }

    public static DeliveryAddressLine fromValue(String v) {
        return valueOf(v);
    }

}
