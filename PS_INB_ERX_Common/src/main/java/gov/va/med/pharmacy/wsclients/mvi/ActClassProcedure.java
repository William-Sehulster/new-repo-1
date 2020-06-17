
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassProcedure.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassProcedure"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PROC"/&gt;
 *     &lt;enumeration value="SPECCOLLECT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActClassProcedure")
@XmlEnum
public enum ActClassProcedure {

    PROC,
    SPECCOLLECT;

    public String getValue() {
        return name();
    }

    public static ActClassProcedure fromValue(String v) {
        return valueOf(v);
    }

}
