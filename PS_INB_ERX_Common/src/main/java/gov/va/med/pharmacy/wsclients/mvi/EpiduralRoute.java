
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EpiduralRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EpiduralRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="EPI"/&gt;
 *     &lt;enumeration value="EPIDURINJ"/&gt;
 *     &lt;enumeration value="EPIINJ"/&gt;
 *     &lt;enumeration value="EPINJSP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EpiduralRoute")
@XmlEnum
public enum EpiduralRoute {

    EPI,
    EPIDURINJ,
    EPIINJ,
    EPINJSP;

    public String getValue() {
        return name();
    }

    public static EpiduralRoute fromValue(String v) {
        return valueOf(v);
    }

}
