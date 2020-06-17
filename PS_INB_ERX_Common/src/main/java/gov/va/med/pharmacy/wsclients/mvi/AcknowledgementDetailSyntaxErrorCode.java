
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcknowledgementDetailSyntaxErrorCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AcknowledgementDetailSyntaxErrorCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="SYN"/&gt;
 *     &lt;enumeration value="SYN102"/&gt;
 *     &lt;enumeration value="SYN104"/&gt;
 *     &lt;enumeration value="SYN110"/&gt;
 *     &lt;enumeration value="SYN112"/&gt;
 *     &lt;enumeration value="SYN100"/&gt;
 *     &lt;enumeration value="SYN101"/&gt;
 *     &lt;enumeration value="SYN103"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AcknowledgementDetailSyntaxErrorCode")
@XmlEnum
public enum AcknowledgementDetailSyntaxErrorCode {

    SYN("SYN"),
    @XmlEnumValue("SYN102")
    SYN_102("SYN102"),
    @XmlEnumValue("SYN104")
    SYN_104("SYN104"),
    @XmlEnumValue("SYN110")
    SYN_110("SYN110"),
    @XmlEnumValue("SYN112")
    SYN_112("SYN112"),
    @XmlEnumValue("SYN100")
    SYN_100("SYN100"),
    @XmlEnumValue("SYN101")
    SYN_101("SYN101"),
    @XmlEnumValue("SYN103")
    SYN_103("SYN103");
    private final String value;

    AcknowledgementDetailSyntaxErrorCode(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static AcknowledgementDetailSyntaxErrorCode fromValue(String v) {
        for (AcknowledgementDetailSyntaxErrorCode c: AcknowledgementDetailSyntaxErrorCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
