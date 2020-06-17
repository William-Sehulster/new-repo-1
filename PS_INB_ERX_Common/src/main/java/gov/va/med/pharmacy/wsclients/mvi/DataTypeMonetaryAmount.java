
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeMonetaryAmount.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeMonetaryAmount"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="MO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeMonetaryAmount")
@XmlEnum
public enum DataTypeMonetaryAmount {

    MO;

    public String getValue() {
        return name();
    }

    public static DataTypeMonetaryAmount fromValue(String v) {
        return valueOf(v);
    }

}
