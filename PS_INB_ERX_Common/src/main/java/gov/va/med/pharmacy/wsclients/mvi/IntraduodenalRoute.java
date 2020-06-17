
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntraduodenalRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntraduodenalRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IDUODINSTIL"/&gt;
 *     &lt;enumeration value="IDOUDMAB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntraduodenalRoute")
@XmlEnum
public enum IntraduodenalRoute {

    IDUODINSTIL,
    IDOUDMAB;

    public String getValue() {
        return name();
    }

    public static IntraduodenalRoute fromValue(String v) {
        return valueOf(v);
    }

}
