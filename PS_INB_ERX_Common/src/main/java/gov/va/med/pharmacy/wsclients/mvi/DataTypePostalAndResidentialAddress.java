
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypePostalAndResidentialAddress.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypePostalAndResidentialAddress"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AD"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypePostalAndResidentialAddress")
@XmlEnum
public enum DataTypePostalAndResidentialAddress {

    AD;

    public String getValue() {
        return name();
    }

    public static DataTypePostalAndResidentialAddress fromValue(String v) {
        return valueOf(v);
    }

}
