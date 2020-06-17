
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassPartitivePartByBOT.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassPartitivePartByBOT"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PART"/&gt;
 *     &lt;enumeration value="ACTM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleClassPartitivePartByBOT")
@XmlEnum
public enum RoleClassPartitivePartByBOT {

    PART,
    ACTM;

    public String getValue() {
        return name();
    }

    public static RoleClassPartitivePartByBOT fromValue(String v) {
        return valueOf(v);
    }

}
