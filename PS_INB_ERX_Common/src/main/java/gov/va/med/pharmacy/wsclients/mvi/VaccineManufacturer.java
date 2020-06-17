
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VaccineManufacturer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VaccineManufacturer"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AB"/&gt;
 *     &lt;enumeration value="AD"/&gt;
 *     &lt;enumeration value="ALP"/&gt;
 *     &lt;enumeration value="AR"/&gt;
 *     &lt;enumeration value="PMC"/&gt;
 *     &lt;enumeration value="AVI"/&gt;
 *     &lt;enumeration value="BA"/&gt;
 *     &lt;enumeration value="BAY"/&gt;
 *     &lt;enumeration value="BPC"/&gt;
 *     &lt;enumeration value="BP"/&gt;
 *     &lt;enumeration value="MIP"/&gt;
 *     &lt;enumeration value="CEN"/&gt;
 *     &lt;enumeration value="CHI"/&gt;
 *     &lt;enumeration value="CON"/&gt;
 *     &lt;enumeration value="EVN"/&gt;
 *     &lt;enumeration value="GRE"/&gt;
 *     &lt;enumeration value="IAG"/&gt;
 *     &lt;enumeration value="IUS"/&gt;
 *     &lt;enumeration value="KGC"/&gt;
 *     &lt;enumeration value="LED"/&gt;
 *     &lt;enumeration value="MA"/&gt;
 *     &lt;enumeration value="MED"/&gt;
 *     &lt;enumeration value="MSD"/&gt;
 *     &lt;enumeration value="IM"/&gt;
 *     &lt;enumeration value="MIL"/&gt;
 *     &lt;enumeration value="NAB"/&gt;
 *     &lt;enumeration value="NYB"/&gt;
 *     &lt;enumeration value="NAV"/&gt;
 *     &lt;enumeration value="NOV"/&gt;
 *     &lt;enumeration value="OTC"/&gt;
 *     &lt;enumeration value="ORT"/&gt;
 *     &lt;enumeration value="PD"/&gt;
 *     &lt;enumeration value="PRX"/&gt;
 *     &lt;enumeration value="SCL"/&gt;
 *     &lt;enumeration value="SKB"/&gt;
 *     &lt;enumeration value="SI"/&gt;
 *     &lt;enumeration value="JPN"/&gt;
 *     &lt;enumeration value="USA"/&gt;
 *     &lt;enumeration value="WAL"/&gt;
 *     &lt;enumeration value="WA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VaccineManufacturer")
@XmlEnum
public enum VaccineManufacturer {

    AB,
    AD,
    ALP,
    AR,
    PMC,
    AVI,
    BA,
    BAY,
    BPC,
    BP,
    MIP,
    CEN,
    CHI,
    CON,
    EVN,
    GRE,
    IAG,
    IUS,
    KGC,
    LED,
    MA,
    MED,
    MSD,
    IM,
    MIL,
    NAB,
    NYB,
    NAV,
    NOV,
    OTC,
    ORT,
    PD,
    PRX,
    SCL,
    SKB,
    SI,
    JPN,
    USA,
    WAL,
    WA;

    public String getValue() {
        return name();
    }

    public static VaccineManufacturer fromValue(String v) {
        return valueOf(v);
    }

}
