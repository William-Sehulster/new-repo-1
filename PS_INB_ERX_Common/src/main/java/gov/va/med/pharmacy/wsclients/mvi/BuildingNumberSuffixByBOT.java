
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BuildingNumberSuffixByBOT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BuildingNumberSuffixByBOT"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BNS"/&gt;
 *     &lt;enumeration value="POB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BuildingNumberSuffixByBOT")
@XmlEnum
public enum BuildingNumberSuffixByBOT {

    BNS,
    POB;

    public String getValue() {
        return name();
    }

    public static BuildingNumberSuffixByBOT fromValue(String v) {
        return valueOf(v);
    }

}
