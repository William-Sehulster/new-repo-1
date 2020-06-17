
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ClinicalStatementSupplyMood.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ClinicalStatementSupplyMood"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EVN"/&gt;
 *     &lt;enumeration value="INT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ClinicalStatementSupplyMood")
@XmlEnum
public enum XClinicalStatementSupplyMood {

    EVN,
    INT;

    public String getValue() {
        return name();
    }

    public static XClinicalStatementSupplyMood fromValue(String v) {
        return valueOf(v);
    }

}
