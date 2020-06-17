
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompressionAlgorithm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CompressionAlgorithm"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="Z"/&gt;
 *     &lt;enumeration value="DF"/&gt;
 *     &lt;enumeration value="GZ"/&gt;
 *     &lt;enumeration value="ZL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CompressionAlgorithm")
@XmlEnum
public enum CompressionAlgorithm {

    Z,
    DF,
    GZ,
    ZL;

    public String getValue() {
        return name();
    }

    public static CompressionAlgorithm fromValue(String v) {
        return valueOf(v);
    }

}
