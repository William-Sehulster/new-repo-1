
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_DeterminerInstanceKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_DeterminerInstanceKind"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="KIND"/&gt;
 *     &lt;enumeration value="QUANTIFIED_KIND"/&gt;
 *     &lt;enumeration value="INSTANCE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_DeterminerInstanceKind")
@XmlEnum
public enum XDeterminerInstanceKind {

    KIND,
    QUANTIFIED_KIND,
    INSTANCE;

    public String getValue() {
        return name();
    }

    public static XDeterminerInstanceKind fromValue(String v) {
        return valueOf(v);
    }

}
