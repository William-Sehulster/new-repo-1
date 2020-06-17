
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationAlert.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationAlert"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="OBSA"/&gt;
 *     &lt;enumeration value="AGE"/&gt;
 *     &lt;enumeration value="COND"/&gt;
 *     &lt;enumeration value="GEND"/&gt;
 *     &lt;enumeration value="GEN"/&gt;
 *     &lt;enumeration value="LAB"/&gt;
 *     &lt;enumeration value="REACT"/&gt;
 *     &lt;enumeration value="RREACT"/&gt;
 *     &lt;enumeration value="CREACT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationAlert")
@XmlEnum
public enum ObservationAlert {

    OBSA,
    AGE,
    COND,
    GEND,
    GEN,
    LAB,
    REACT,
    RREACT,
    CREACT;

    public String getValue() {
        return name();
    }

    public static ObservationAlert fromValue(String v) {
        return valueOf(v);
    }

}
