
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubcutaneousRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubcutaneousRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SQIMPLNT"/&gt;
 *     &lt;enumeration value="SQINFUS"/&gt;
 *     &lt;enumeration value="IPUMPINJ"/&gt;
 *     &lt;enumeration value="SQ"/&gt;
 *     &lt;enumeration value="SQSURGINS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SubcutaneousRoute")
@XmlEnum
public enum SubcutaneousRoute {

    SQIMPLNT,
    SQINFUS,
    IPUMPINJ,
    SQ,
    SQSURGINS;

    public String getValue() {
        return name();
    }

    public static SubcutaneousRoute fromValue(String v) {
        return valueOf(v);
    }

}
