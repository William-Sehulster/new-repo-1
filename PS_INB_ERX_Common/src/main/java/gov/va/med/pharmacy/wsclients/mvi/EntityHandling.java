
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityHandling.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityHandling"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AMB"/&gt;
 *     &lt;enumeration value="C37"/&gt;
 *     &lt;enumeration value="CAMB"/&gt;
 *     &lt;enumeration value="CFRZ"/&gt;
 *     &lt;enumeration value="CREF"/&gt;
 *     &lt;enumeration value="DFRZ"/&gt;
 *     &lt;enumeration value="MTLF"/&gt;
 *     &lt;enumeration value="CATM"/&gt;
 *     &lt;enumeration value="PRTL"/&gt;
 *     &lt;enumeration value="REF"/&gt;
 *     &lt;enumeration value="SBU"/&gt;
 *     &lt;enumeration value="UFRZ"/&gt;
 *     &lt;enumeration value="PSA"/&gt;
 *     &lt;enumeration value="DRY"/&gt;
 *     &lt;enumeration value="FRZ"/&gt;
 *     &lt;enumeration value="NTR"/&gt;
 *     &lt;enumeration value="PSO"/&gt;
 *     &lt;enumeration value="UPR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EntityHandling")
@XmlEnum
public enum EntityHandling {

    AMB("AMB"),
    @XmlEnumValue("C37")
    C_37("C37"),
    CAMB("CAMB"),
    CFRZ("CFRZ"),
    CREF("CREF"),
    DFRZ("DFRZ"),
    MTLF("MTLF"),
    CATM("CATM"),
    PRTL("PRTL"),
    REF("REF"),
    SBU("SBU"),
    UFRZ("UFRZ"),
    PSA("PSA"),
    DRY("DRY"),
    FRZ("FRZ"),
    NTR("NTR"),
    PSO("PSO"),
    UPR("UPR");
    private final String value;

    EntityHandling(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static EntityHandling fromValue(String v) {
        for (EntityHandling c: EntityHandling.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
