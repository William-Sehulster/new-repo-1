
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeTelecommunicationAddress.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeTelecommunicationAddress"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="TEL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeTelecommunicationAddress")
@XmlEnum
public enum DataTypeTelecommunicationAddress {

    TEL;

    public String getValue() {
        return name();
    }

    public static DataTypeTelecommunicationAddress fromValue(String v) {
        return valueOf(v);
    }

}
