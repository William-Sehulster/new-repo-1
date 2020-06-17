
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MedicationGeneralizationRoleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MedicationGeneralizationRoleType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="GD"/&gt;
 *     &lt;enumeration value="GDF"/&gt;
 *     &lt;enumeration value="GDS"/&gt;
 *     &lt;enumeration value="GDSF"/&gt;
 *     &lt;enumeration value="MGDSF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MedicationGeneralizationRoleType")
@XmlEnum
public enum MedicationGeneralizationRoleType {

    GD,
    GDF,
    GDS,
    GDSF,
    MGDSF;

    public String getValue() {
        return name();
    }

    public static MedicationGeneralizationRoleType fromValue(String v) {
        return valueOf(v);
    }

}
