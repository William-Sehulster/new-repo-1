
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SiblingInLaw.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SiblingInLaw"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SIBINLAW"/&gt;
 *     &lt;enumeration value="BROINLAW"/&gt;
 *     &lt;enumeration value="SISINLAW"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SiblingInLaw")
@XmlEnum
public enum SiblingInLaw {

    SIBINLAW,
    BROINLAW,
    SISINLAW;

    public String getValue() {
        return name();
    }

    public static SiblingInLaw fromValue(String v) {
        return valueOf(v);
    }

}
