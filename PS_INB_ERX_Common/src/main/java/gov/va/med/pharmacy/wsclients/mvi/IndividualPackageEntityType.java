
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IndividualPackageEntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IndividualPackageEntityType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AMP"/&gt;
 *     &lt;enumeration value="MINIM"/&gt;
 *     &lt;enumeration value="NEBAMP"/&gt;
 *     &lt;enumeration value="OVUL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IndividualPackageEntityType")
@XmlEnum
public enum IndividualPackageEntityType {

    AMP,
    MINIM,
    NEBAMP,
    OVUL;

    public String getValue() {
        return name();
    }

    public static IndividualPackageEntityType fromValue(String v) {
        return valueOf(v);
    }

}
