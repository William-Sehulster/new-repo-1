
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryResponse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="QueryResponse"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AE"/&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="NF"/&gt;
 *     &lt;enumeration value="QE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "QueryResponse")
@XmlEnum
public enum QueryResponse {

    AE,
    OK,
    NF,
    QE;

    public String getValue() {
        return name();
    }

    public static QueryResponse fromValue(String v) {
        return valueOf(v);
    }

}
