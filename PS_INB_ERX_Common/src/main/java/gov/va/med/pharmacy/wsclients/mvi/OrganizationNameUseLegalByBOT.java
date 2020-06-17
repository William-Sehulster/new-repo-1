
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganizationNameUseLegalByBOT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrganizationNameUseLegalByBOT"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="L"/&gt;
 *     &lt;enumeration value="OR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OrganizationNameUseLegalByBOT")
@XmlEnum
public enum OrganizationNameUseLegalByBOT {

    L,
    OR;

    public String getValue() {
        return name();
    }

    public static OrganizationNameUseLegalByBOT fromValue(String v) {
        return valueOf(v);
    }

}
