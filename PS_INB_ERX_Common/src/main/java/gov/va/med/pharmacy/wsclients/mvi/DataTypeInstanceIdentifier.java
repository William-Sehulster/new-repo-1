
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeInstanceIdentifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeInstanceIdentifier"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="II"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeInstanceIdentifier")
@XmlEnum
public enum DataTypeInstanceIdentifier {

    II;

    public String getValue() {
        return name();
    }

    public static DataTypeInstanceIdentifier fromValue(String v) {
        return valueOf(v);
    }

}
