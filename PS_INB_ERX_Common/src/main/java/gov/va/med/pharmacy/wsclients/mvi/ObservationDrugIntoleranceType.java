
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationDrugIntoleranceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationDrugIntoleranceType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="DINT"/&gt;
 *     &lt;enumeration value="DALG"/&gt;
 *     &lt;enumeration value="DNAINT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationDrugIntoleranceType")
@XmlEnum
public enum ObservationDrugIntoleranceType {

    DINT,
    DALG,
    DNAINT;

    public String getValue() {
        return name();
    }

    public static ObservationDrugIntoleranceType fromValue(String v) {
        return valueOf(v);
    }

}
