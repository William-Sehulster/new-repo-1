
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonNameUsePseudonym.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PersonNameUsePseudonym"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="A"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PersonNameUsePseudonym")
@XmlEnum
public enum PersonNameUsePseudonym {

    P,
    A;

    public String getValue() {
        return name();
    }

    public static PersonNameUsePseudonym fromValue(String v) {
        return valueOf(v);
    }

}
