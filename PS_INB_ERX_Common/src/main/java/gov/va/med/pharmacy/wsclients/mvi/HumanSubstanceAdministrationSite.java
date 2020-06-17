
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HumanSubstanceAdministrationSite.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HumanSubstanceAdministrationSite"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="BE"/&gt;
 *     &lt;enumeration value="OU"/&gt;
 *     &lt;enumeration value="BU"/&gt;
 *     &lt;enumeration value="LACF"/&gt;
 *     &lt;enumeration value="LAC"/&gt;
 *     &lt;enumeration value="LA"/&gt;
 *     &lt;enumeration value="LD"/&gt;
 *     &lt;enumeration value="LE"/&gt;
 *     &lt;enumeration value="LEJ"/&gt;
 *     &lt;enumeration value="OS"/&gt;
 *     &lt;enumeration value="LF"/&gt;
 *     &lt;enumeration value="LG"/&gt;
 *     &lt;enumeration value="LH"/&gt;
 *     &lt;enumeration value="LIJ"/&gt;
 *     &lt;enumeration value="LLAQ"/&gt;
 *     &lt;enumeration value="LLFA"/&gt;
 *     &lt;enumeration value="LMFA"/&gt;
 *     &lt;enumeration value="LN"/&gt;
 *     &lt;enumeration value="LPC"/&gt;
 *     &lt;enumeration value="LSC"/&gt;
 *     &lt;enumeration value="LT"/&gt;
 *     &lt;enumeration value="LUAQ"/&gt;
 *     &lt;enumeration value="LUA"/&gt;
 *     &lt;enumeration value="LUFA"/&gt;
 *     &lt;enumeration value="LVL"/&gt;
 *     &lt;enumeration value="LVG"/&gt;
 *     &lt;enumeration value="PA"/&gt;
 *     &lt;enumeration value="PERIN"/&gt;
 *     &lt;enumeration value="RACF"/&gt;
 *     &lt;enumeration value="RAC"/&gt;
 *     &lt;enumeration value="RA"/&gt;
 *     &lt;enumeration value="RD"/&gt;
 *     &lt;enumeration value="RE"/&gt;
 *     &lt;enumeration value="REJ"/&gt;
 *     &lt;enumeration value="OD"/&gt;
 *     &lt;enumeration value="RF"/&gt;
 *     &lt;enumeration value="RG"/&gt;
 *     &lt;enumeration value="RH"/&gt;
 *     &lt;enumeration value="RIJ"/&gt;
 *     &lt;enumeration value="RLAQ"/&gt;
 *     &lt;enumeration value="RLFA"/&gt;
 *     &lt;enumeration value="RMFA"/&gt;
 *     &lt;enumeration value="RPC"/&gt;
 *     &lt;enumeration value="RSC"/&gt;
 *     &lt;enumeration value="RT"/&gt;
 *     &lt;enumeration value="RUAQ"/&gt;
 *     &lt;enumeration value="RUA"/&gt;
 *     &lt;enumeration value="RUFA"/&gt;
 *     &lt;enumeration value="RVL"/&gt;
 *     &lt;enumeration value="RVG"/&gt;
 *     &lt;enumeration value="BN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HumanSubstanceAdministrationSite")
@XmlEnum
public enum HumanSubstanceAdministrationSite {

    BE,
    OU,
    BU,
    LACF,
    LAC,
    LA,
    LD,
    LE,
    LEJ,
    OS,
    LF,
    LG,
    LH,
    LIJ,
    LLAQ,
    LLFA,
    LMFA,
    LN,
    LPC,
    LSC,
    LT,
    LUAQ,
    LUA,
    LUFA,
    LVL,
    LVG,
    PA,
    PERIN,
    RACF,
    RAC,
    RA,
    RD,
    RE,
    REJ,
    OD,
    RF,
    RG,
    RH,
    RIJ,
    RLAQ,
    RLFA,
    RMFA,
    RPC,
    RSC,
    RT,
    RUAQ,
    RUA,
    RUFA,
    RVL,
    RVG,
    BN;

    public String getValue() {
        return name();
    }

    public static HumanSubstanceAdministrationSite fromValue(String v) {
        return valueOf(v);
    }

}
