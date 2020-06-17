
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActInformationAccessContextCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActInformationAccessContextCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="INFCON"/&gt;
 *     &lt;enumeration value="INFDNG"/&gt;
 *     &lt;enumeration value="INFPWR"/&gt;
 *     &lt;enumeration value="INFEMER"/&gt;
 *     &lt;enumeration value="INFCRT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActInformationAccessContextCode")
@XmlEnum
public enum ActInformationAccessContextCode {

    INFCON,
    INFDNG,
    INFPWR,
    INFEMER,
    INFCRT;

    public String getValue() {
        return name();
    }

    public static ActInformationAccessContextCode fromValue(String v) {
        return valueOf(v);
    }

}
