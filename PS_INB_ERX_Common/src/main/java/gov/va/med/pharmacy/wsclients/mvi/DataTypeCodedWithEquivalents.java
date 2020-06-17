
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeCodedWithEquivalents.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeCodedWithEquivalents"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeCodedWithEquivalents")
@XmlEnum
public enum DataTypeCodedWithEquivalents {

    CE;

    public String getValue() {
        return name();
    }

    public static DataTypeCodedWithEquivalents fromValue(String v) {
        return valueOf(v);
    }

}
