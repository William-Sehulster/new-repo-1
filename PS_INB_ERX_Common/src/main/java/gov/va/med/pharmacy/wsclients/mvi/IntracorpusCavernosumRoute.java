
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntracorpusCavernosumRoute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntracorpusCavernosumRoute"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ICORPCAVINJ"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntracorpusCavernosumRoute")
@XmlEnum
public enum IntracorpusCavernosumRoute {

    ICORPCAVINJ;

    public String getValue() {
        return name();
    }

    public static IntracorpusCavernosumRoute fromValue(String v) {
        return valueOf(v);
    }

}
