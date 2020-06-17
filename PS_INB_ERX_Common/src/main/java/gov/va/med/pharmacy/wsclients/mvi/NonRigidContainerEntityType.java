
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NonRigidContainerEntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NonRigidContainerEntityType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BAG"/&gt;
 *     &lt;enumeration value="PACKT"/&gt;
 *     &lt;enumeration value="PCH"/&gt;
 *     &lt;enumeration value="SACH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NonRigidContainerEntityType")
@XmlEnum
public enum NonRigidContainerEntityType {

    BAG,
    PACKT,
    PCH,
    SACH;

    public String getValue() {
        return name();
    }

    public static NonRigidContainerEntityType fromValue(String v) {
        return valueOf(v);
    }

}
