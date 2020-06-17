
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActFinancialProductAcquisitionCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActFinancialProductAcquisitionCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="RENT"/&gt;
 *     &lt;enumeration value="SALE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ActFinancialProductAcquisitionCode")
@XmlEnum
public enum XActFinancialProductAcquisitionCode {

    RENT,
    SALE;

    public String getValue() {
        return name();
    }

    public static XActFinancialProductAcquisitionCode fromValue(String v) {
        return valueOf(v);
    }

}
