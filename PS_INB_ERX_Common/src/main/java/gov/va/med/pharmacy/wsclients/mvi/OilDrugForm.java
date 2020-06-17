
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OilDrugForm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OilDrugForm"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="OIL"/&gt;
 *     &lt;enumeration value="TOPOIL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OilDrugForm")
@XmlEnum
public enum OilDrugForm {

    OIL,
    TOPOIL;

    public String getValue() {
        return name();
    }

    public static OilDrugForm fromValue(String v) {
        return valueOf(v);
    }

}
