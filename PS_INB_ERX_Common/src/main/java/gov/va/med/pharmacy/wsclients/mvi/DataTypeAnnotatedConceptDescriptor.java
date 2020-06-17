
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTypeAnnotatedConceptDescriptor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTypeAnnotatedConceptDescriptor"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ANT&lt;CD&gt;"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DataTypeAnnotatedConceptDescriptor")
@XmlEnum
public enum DataTypeAnnotatedConceptDescriptor {

    @XmlEnumValue("ANT<CD>")
    ANT_CD("ANT<CD>");
    private final String value;

    DataTypeAnnotatedConceptDescriptor(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static DataTypeAnnotatedConceptDescriptor fromValue(String v) {
        for (DataTypeAnnotatedConceptDescriptor c: DataTypeAnnotatedConceptDescriptor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
