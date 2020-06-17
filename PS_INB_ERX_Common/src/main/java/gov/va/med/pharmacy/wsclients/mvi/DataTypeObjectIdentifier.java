
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeObjectIdentifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeObjectIdentifier"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="OID"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeObjectIdentifier")
@XmlEnum
public enum DataTypeObjectIdentifier {

    OID;

    public String getValue() {
        return name();
    }

    public static DataTypeObjectIdentifier fromValue(String v) {
        return valueOf(v);
    }

}
