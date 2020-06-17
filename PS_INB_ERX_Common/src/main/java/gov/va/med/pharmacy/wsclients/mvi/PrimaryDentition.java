
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrimaryDentition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrimaryDentition"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="TIDA"/&gt;
 *     &lt;enumeration value="TIDB"/&gt;
 *     &lt;enumeration value="TIDC"/&gt;
 *     &lt;enumeration value="TIDD"/&gt;
 *     &lt;enumeration value="TIDE"/&gt;
 *     &lt;enumeration value="TIDF"/&gt;
 *     &lt;enumeration value="TIDG"/&gt;
 *     &lt;enumeration value="TIDH"/&gt;
 *     &lt;enumeration value="TIDI"/&gt;
 *     &lt;enumeration value="TIDJ"/&gt;
 *     &lt;enumeration value="TIDK"/&gt;
 *     &lt;enumeration value="TIDL"/&gt;
 *     &lt;enumeration value="TIDM"/&gt;
 *     &lt;enumeration value="TIDN"/&gt;
 *     &lt;enumeration value="TIDO"/&gt;
 *     &lt;enumeration value="TIDP"/&gt;
 *     &lt;enumeration value="TIDQ"/&gt;
 *     &lt;enumeration value="TIDR"/&gt;
 *     &lt;enumeration value="TIDS"/&gt;
 *     &lt;enumeration value="TIDT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PrimaryDentition")
@XmlEnum
public enum PrimaryDentition {

    TIDA,
    TIDB,
    TIDC,
    TIDD,
    TIDE,
    TIDF,
    TIDG,
    TIDH,
    TIDI,
    TIDJ,
    TIDK,
    TIDL,
    TIDM,
    TIDN,
    TIDO,
    TIDP,
    TIDQ,
    TIDR,
    TIDS,
    TIDT;

    public String getValue() {
        return name();
    }

    public static PrimaryDentition fromValue(String v) {
        return valueOf(v);
    }

}
