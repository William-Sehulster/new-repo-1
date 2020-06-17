
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SuppositoryDrugForm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SuppositoryDrugForm"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SUPP"/&gt;
 *     &lt;enumeration value="RECSUPP"/&gt;
 *     &lt;enumeration value="URETHSUPP"/&gt;
 *     &lt;enumeration value="VAGSUPP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SuppositoryDrugForm")
@XmlEnum
public enum SuppositoryDrugForm {

    SUPP,
    RECSUPP,
    URETHSUPP,
    VAGSUPP;

    public String getValue() {
        return name();
    }

    public static SuppositoryDrugForm fromValue(String v) {
        return valueOf(v);
    }

}
