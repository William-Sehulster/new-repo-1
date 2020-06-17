
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TranstympanicRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TranstympanicRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="TRTYMPINSTIL"/&gt;
 *     &lt;enumeration value="TTYMPTABSORP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TranstympanicRoute")
@XmlEnum
public enum TranstympanicRoute {

    TRTYMPINSTIL,
    TTYMPTABSORP;

    public String getValue() {
        return name();
    }

    public static TranstympanicRoute fromValue(String v) {
        return valueOf(v);
    }

}
