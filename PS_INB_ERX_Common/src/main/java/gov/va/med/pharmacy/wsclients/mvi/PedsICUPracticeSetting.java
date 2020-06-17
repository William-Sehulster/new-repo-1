
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PedsICUPracticeSetting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PedsICUPracticeSetting"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PEDICU"/&gt;
 *     &lt;enumeration value="PEDNICU"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PedsICUPracticeSetting")
@XmlEnum
public enum PedsICUPracticeSetting {

    PEDICU,
    PEDNICU;

    public String getValue() {
        return name();
    }

    public static PedsICUPracticeSetting fromValue(String v) {
        return valueOf(v);
    }

}
