
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LifeInsurancePolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LifeInsurancePolicy"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="LIFE"/&gt;
 *     &lt;enumeration value="ANNU"/&gt;
 *     &lt;enumeration value="TLIFE"/&gt;
 *     &lt;enumeration value="ULIFE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LifeInsurancePolicy")
@XmlEnum
public enum LifeInsurancePolicy {

    LIFE,
    ANNU,
    TLIFE,
    ULIFE;

    public String getValue() {
        return name();
    }

    public static LifeInsurancePolicy fromValue(String v) {
        return valueOf(v);
    }

}
