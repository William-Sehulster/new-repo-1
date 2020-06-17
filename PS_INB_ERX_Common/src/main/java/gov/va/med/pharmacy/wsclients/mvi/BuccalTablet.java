
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BuccalTablet.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BuccalTablet"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BUCTAB"/&gt;
 *     &lt;enumeration value="SRBUCTAB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BuccalTablet")
@XmlEnum
public enum BuccalTablet {

    BUCTAB,
    SRBUCTAB;

    public String getValue() {
        return name();
    }

    public static BuccalTablet fromValue(String v) {
        return valueOf(v);
    }

}
