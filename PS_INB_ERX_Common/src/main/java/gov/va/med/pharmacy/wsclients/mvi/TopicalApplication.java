
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TopicalApplication.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TopicalApplication"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="OCDRESTA"/&gt;
 *     &lt;enumeration value="SUBCONJTA"/&gt;
 *     &lt;enumeration value="TOPICAL"/&gt;
 *     &lt;enumeration value="BUC"/&gt;
 *     &lt;enumeration value="CERV"/&gt;
 *     &lt;enumeration value="DEN"/&gt;
 *     &lt;enumeration value="GIN"/&gt;
 *     &lt;enumeration value="HAIR"/&gt;
 *     &lt;enumeration value="ICORNTA"/&gt;
 *     &lt;enumeration value="ICORONTA"/&gt;
 *     &lt;enumeration value="IESOPHTA"/&gt;
 *     &lt;enumeration value="IILEALTA"/&gt;
 *     &lt;enumeration value="ILTOP"/&gt;
 *     &lt;enumeration value="ILUMTA"/&gt;
 *     &lt;enumeration value="IOTOP"/&gt;
 *     &lt;enumeration value="IONTO"/&gt;
 *     &lt;enumeration value="LARYNGTA"/&gt;
 *     &lt;enumeration value="MUC"/&gt;
 *     &lt;enumeration value="NAIL"/&gt;
 *     &lt;enumeration value="NASAL"/&gt;
 *     &lt;enumeration value="OPTHALTA"/&gt;
 *     &lt;enumeration value="ORALTA"/&gt;
 *     &lt;enumeration value="ORMUC"/&gt;
 *     &lt;enumeration value="OROPHARTA"/&gt;
 *     &lt;enumeration value="PERIANAL"/&gt;
 *     &lt;enumeration value="PERINEAL"/&gt;
 *     &lt;enumeration value="PDONTTA"/&gt;
 *     &lt;enumeration value="RECTAL"/&gt;
 *     &lt;enumeration value="SCALP"/&gt;
 *     &lt;enumeration value="SKIN"/&gt;
 *     &lt;enumeration value="DRESS"/&gt;
 *     &lt;enumeration value="SWAB"/&gt;
 *     &lt;enumeration value="TMUCTA"/&gt;
 *     &lt;enumeration value="VAGINS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TopicalApplication")
@XmlEnum
public enum TopicalApplication {

    OCDRESTA,
    SUBCONJTA,
    TOPICAL,
    BUC,
    CERV,
    DEN,
    GIN,
    HAIR,
    ICORNTA,
    ICORONTA,
    IESOPHTA,
    IILEALTA,
    ILTOP,
    ILUMTA,
    IOTOP,
    IONTO,
    LARYNGTA,
    MUC,
    NAIL,
    NASAL,
    OPTHALTA,
    ORALTA,
    ORMUC,
    OROPHARTA,
    PERIANAL,
    PERINEAL,
    PDONTTA,
    RECTAL,
    SCALP,
    SKIN,
    DRESS,
    SWAB,
    TMUCTA,
    VAGINS;

    public String getValue() {
        return name();
    }

    public static TopicalApplication fromValue(String v) {
        return valueOf(v);
    }

}
