
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT201302UV02.Member.id.updateMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PRPA_MT201302UV02.Member.id.updateMode"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PRPA_MT201302UV02.Member.id.updateMode")
@XmlEnum
public enum PRPAMT201302UV02MemberIdUpdateMode {

    A,
    N;

    public String getValue() {
        return name();
    }

    public static PRPAMT201302UV02MemberIdUpdateMode fromValue(String v) {
        return valueOf(v);
    }

}
