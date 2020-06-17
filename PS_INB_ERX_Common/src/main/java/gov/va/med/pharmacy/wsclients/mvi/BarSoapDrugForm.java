
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BarSoapDrugForm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BarSoapDrugForm"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BARSOAP"/&gt;
 *     &lt;enumeration value="MEDBAR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BarSoapDrugForm")
@XmlEnum
public enum BarSoapDrugForm {

    BARSOAP,
    MEDBAR;

    public String getValue() {
        return name();
    }

    public static BarSoapDrugForm fromValue(String v) {
        return valueOf(v);
    }

}
