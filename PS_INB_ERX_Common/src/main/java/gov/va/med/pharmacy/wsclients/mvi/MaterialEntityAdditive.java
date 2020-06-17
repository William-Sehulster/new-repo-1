
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MaterialEntityAdditive.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MaterialEntityAdditive"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="F10"/&gt;
 *     &lt;enumeration value="C32"/&gt;
 *     &lt;enumeration value="C38"/&gt;
 *     &lt;enumeration value="HCL6"/&gt;
 *     &lt;enumeration value="ACDA"/&gt;
 *     &lt;enumeration value="ACDB"/&gt;
 *     &lt;enumeration value="ACET"/&gt;
 *     &lt;enumeration value="AMIES"/&gt;
 *     &lt;enumeration value="HEPA"/&gt;
 *     &lt;enumeration value="BACTM"/&gt;
 *     &lt;enumeration value="BOR"/&gt;
 *     &lt;enumeration value="BOUIN"/&gt;
 *     &lt;enumeration value="BF10"/&gt;
 *     &lt;enumeration value="WEST"/&gt;
 *     &lt;enumeration value="BSKM"/&gt;
 *     &lt;enumeration value="CTAD"/&gt;
 *     &lt;enumeration value="CARS"/&gt;
 *     &lt;enumeration value="CARY"/&gt;
 *     &lt;enumeration value="CHLTM"/&gt;
 *     &lt;enumeration value="ENT"/&gt;
 *     &lt;enumeration value="JKM"/&gt;
 *     &lt;enumeration value="KARN"/&gt;
 *     &lt;enumeration value="LIA"/&gt;
 *     &lt;enumeration value="HEPL"/&gt;
 *     &lt;enumeration value="M4"/&gt;
 *     &lt;enumeration value="M4RT"/&gt;
 *     &lt;enumeration value="M5"/&gt;
 *     &lt;enumeration value="MMDTM"/&gt;
 *     &lt;enumeration value="MICHTM"/&gt;
 *     &lt;enumeration value="HNO3"/&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *     &lt;enumeration value="PAGE"/&gt;
 *     &lt;enumeration value="PHENOL"/&gt;
 *     &lt;enumeration value="PVA"/&gt;
 *     &lt;enumeration value="KOX"/&gt;
 *     &lt;enumeration value="EDTK15"/&gt;
 *     &lt;enumeration value="EDTK75"/&gt;
 *     &lt;enumeration value="RLM"/&gt;
 *     &lt;enumeration value="SST"/&gt;
 *     &lt;enumeration value="SILICA"/&gt;
 *     &lt;enumeration value="NAF"/&gt;
 *     &lt;enumeration value="FL100"/&gt;
 *     &lt;enumeration value="FL10"/&gt;
 *     &lt;enumeration value="SPS"/&gt;
 *     &lt;enumeration value="HEPN"/&gt;
 *     &lt;enumeration value="EDTN"/&gt;
 *     &lt;enumeration value="STUTM"/&gt;
 *     &lt;enumeration value="THROM"/&gt;
 *     &lt;enumeration value="FDP"/&gt;
 *     &lt;enumeration value="THYMOL"/&gt;
 *     &lt;enumeration value="THYO"/&gt;
 *     &lt;enumeration value="TOLU"/&gt;
 *     &lt;enumeration value="URETM"/&gt;
 *     &lt;enumeration value="VIRTM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MaterialEntityAdditive")
@XmlEnum
public enum MaterialEntityAdditive {

    @XmlEnumValue("F10")
    F_10("F10"),
    @XmlEnumValue("C32")
    C_32("C32"),
    @XmlEnumValue("C38")
    C_38("C38"),
    @XmlEnumValue("HCL6")
    HCL_6("HCL6"),
    ACDA("ACDA"),
    ACDB("ACDB"),
    ACET("ACET"),
    AMIES("AMIES"),
    HEPA("HEPA"),
    BACTM("BACTM"),
    BOR("BOR"),
    BOUIN("BOUIN"),
    @XmlEnumValue("BF10")
    BF_10("BF10"),
    WEST("WEST"),
    BSKM("BSKM"),
    CTAD("CTAD"),
    CARS("CARS"),
    CARY("CARY"),
    CHLTM("CHLTM"),
    ENT("ENT"),
    JKM("JKM"),
    KARN("KARN"),
    LIA("LIA"),
    HEPL("HEPL"),
    @XmlEnumValue("M4")
    M_4("M4"),
    @XmlEnumValue("M4RT")
    M_4_RT("M4RT"),
    @XmlEnumValue("M5")
    M_5("M5"),
    MMDTM("MMDTM"),
    MICHTM("MICHTM"),
    @XmlEnumValue("HNO3")
    HNO_3("HNO3"),
    NONE("NONE"),
    PAGE("PAGE"),
    PHENOL("PHENOL"),
    PVA("PVA"),
    KOX("KOX"),
    @XmlEnumValue("EDTK15")
    EDTK_15("EDTK15"),
    @XmlEnumValue("EDTK75")
    EDTK_75("EDTK75"),
    RLM("RLM"),
    SST("SST"),
    SILICA("SILICA"),
    NAF("NAF"),
    @XmlEnumValue("FL100")
    FL_100("FL100"),
    @XmlEnumValue("FL10")
    FL_10("FL10"),
    SPS("SPS"),
    HEPN("HEPN"),
    EDTN("EDTN"),
    STUTM("STUTM"),
    THROM("THROM"),
    FDP("FDP"),
    THYMOL("THYMOL"),
    THYO("THYO"),
    TOLU("TOLU"),
    URETM("URETM"),
    VIRTM("VIRTM");
    private final String value;

    MaterialEntityAdditive(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    public static MaterialEntityAdditive fromValue(String v) {
        for (MaterialEntityAdditive c: MaterialEntityAdditive.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
