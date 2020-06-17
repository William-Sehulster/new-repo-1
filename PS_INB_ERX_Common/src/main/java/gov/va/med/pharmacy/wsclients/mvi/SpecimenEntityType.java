
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpecimenEntityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SpecimenEntityType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ABS"/&gt;
 *     &lt;enumeration value="AMN"/&gt;
 *     &lt;enumeration value="ASP"/&gt;
 *     &lt;enumeration value="BPH"/&gt;
 *     &lt;enumeration value="BIFL"/&gt;
 *     &lt;enumeration value="BLDCO"/&gt;
 *     &lt;enumeration value="BLDA"/&gt;
 *     &lt;enumeration value="BBL"/&gt;
 *     &lt;enumeration value="BLDC"/&gt;
 *     &lt;enumeration value="BPU"/&gt;
 *     &lt;enumeration value="BLDV"/&gt;
 *     &lt;enumeration value="FLU"/&gt;
 *     &lt;enumeration value="BON"/&gt;
 *     &lt;enumeration value="MILK"/&gt;
 *     &lt;enumeration value="BRO"/&gt;
 *     &lt;enumeration value="BRN"/&gt;
 *     &lt;enumeration value="CALC"/&gt;
 *     &lt;enumeration value="STON"/&gt;
 *     &lt;enumeration value="CNL"/&gt;
 *     &lt;enumeration value="CDM"/&gt;
 *     &lt;enumeration value="CTP"/&gt;
 *     &lt;enumeration value="CSF"/&gt;
 *     &lt;enumeration value="CVM"/&gt;
 *     &lt;enumeration value="CVX"/&gt;
 *     &lt;enumeration value="COL"/&gt;
 *     &lt;enumeration value="CNJT"/&gt;
 *     &lt;enumeration value="CRN"/&gt;
 *     &lt;enumeration value="CUR"/&gt;
 *     &lt;enumeration value="CYST"/&gt;
 *     &lt;enumeration value="DIAF"/&gt;
 *     &lt;enumeration value="DOSE"/&gt;
 *     &lt;enumeration value="DRN"/&gt;
 *     &lt;enumeration value="DUFL"/&gt;
 *     &lt;enumeration value="EAR"/&gt;
 *     &lt;enumeration value="EARW"/&gt;
 *     &lt;enumeration value="ELT"/&gt;
 *     &lt;enumeration value="ENDC"/&gt;
 *     &lt;enumeration value="ENDM"/&gt;
 *     &lt;enumeration value="EOS"/&gt;
 *     &lt;enumeration value="RBC"/&gt;
 *     &lt;enumeration value="BRTH"/&gt;
 *     &lt;enumeration value="EXG"/&gt;
 *     &lt;enumeration value="EYE"/&gt;
 *     &lt;enumeration value="FIB"/&gt;
 *     &lt;enumeration value="FLT"/&gt;
 *     &lt;enumeration value="FIST"/&gt;
 *     &lt;enumeration value="FOOD"/&gt;
 *     &lt;enumeration value="GAS"/&gt;
 *     &lt;enumeration value="GAST"/&gt;
 *     &lt;enumeration value="GEN"/&gt;
 *     &lt;enumeration value="GENC"/&gt;
 *     &lt;enumeration value="GENF"/&gt;
 *     &lt;enumeration value="GENL"/&gt;
 *     &lt;enumeration value="GENV"/&gt;
 *     &lt;enumeration value="HAR"/&gt;
 *     &lt;enumeration value="IHG"/&gt;
 *     &lt;enumeration value="IT"/&gt;
 *     &lt;enumeration value="ISLT"/&gt;
 *     &lt;enumeration value="LAM"/&gt;
 *     &lt;enumeration value="WBC"/&gt;
 *     &lt;enumeration value="LN"/&gt;
 *     &lt;enumeration value="LNA"/&gt;
 *     &lt;enumeration value="LNV"/&gt;
 *     &lt;enumeration value="LIQ"/&gt;
 *     &lt;enumeration value="LYM"/&gt;
 *     &lt;enumeration value="MAC"/&gt;
 *     &lt;enumeration value="MAR"/&gt;
 *     &lt;enumeration value="MEC"/&gt;
 *     &lt;enumeration value="MBLD"/&gt;
 *     &lt;enumeration value="MLK"/&gt;
 *     &lt;enumeration value="NAIL"/&gt;
 *     &lt;enumeration value="NOS"/&gt;
 *     &lt;enumeration value="PAFL"/&gt;
 *     &lt;enumeration value="PAT"/&gt;
 *     &lt;enumeration value="PRT"/&gt;
 *     &lt;enumeration value="PLC"/&gt;
 *     &lt;enumeration value="PLAS"/&gt;
 *     &lt;enumeration value="PLB"/&gt;
 *     &lt;enumeration value="PPP"/&gt;
 *     &lt;enumeration value="PRP"/&gt;
 *     &lt;enumeration value="PLR"/&gt;
 *     &lt;enumeration value="PMN"/&gt;
 *     &lt;enumeration value="PUS"/&gt;
 *     &lt;enumeration value="SAL"/&gt;
 *     &lt;enumeration value="SMN"/&gt;
 *     &lt;enumeration value="SMPLS"/&gt;
 *     &lt;enumeration value="SER"/&gt;
 *     &lt;enumeration value="SKM"/&gt;
 *     &lt;enumeration value="SKN"/&gt;
 *     &lt;enumeration value="SPRM"/&gt;
 *     &lt;enumeration value="SPT"/&gt;
 *     &lt;enumeration value="SPTC"/&gt;
 *     &lt;enumeration value="SPTT"/&gt;
 *     &lt;enumeration value="STL"/&gt;
 *     &lt;enumeration value="SWT"/&gt;
 *     &lt;enumeration value="SNV"/&gt;
 *     &lt;enumeration value="TEAR"/&gt;
 *     &lt;enumeration value="THRT"/&gt;
 *     &lt;enumeration value="THRB"/&gt;
 *     &lt;enumeration value="TISG"/&gt;
 *     &lt;enumeration value="TLGI"/&gt;
 *     &lt;enumeration value="TLNG"/&gt;
 *     &lt;enumeration value="TISPL"/&gt;
 *     &lt;enumeration value="TSMI"/&gt;
 *     &lt;enumeration value="TISU"/&gt;
 *     &lt;enumeration value="TISS"/&gt;
 *     &lt;enumeration value="TUB"/&gt;
 *     &lt;enumeration value="ULC"/&gt;
 *     &lt;enumeration value="UMB"/&gt;
 *     &lt;enumeration value="UMED"/&gt;
 *     &lt;enumeration value="USUB"/&gt;
 *     &lt;enumeration value="URTH"/&gt;
 *     &lt;enumeration value="UR"/&gt;
 *     &lt;enumeration value="URT"/&gt;
 *     &lt;enumeration value="URC"/&gt;
 *     &lt;enumeration value="URNS"/&gt;
 *     &lt;enumeration value="VOM"/&gt;
 *     &lt;enumeration value="WAT"/&gt;
 *     &lt;enumeration value="BLD"/&gt;
 *     &lt;enumeration value="BDY"/&gt;
 *     &lt;enumeration value="WICK"/&gt;
 *     &lt;enumeration value="WND"/&gt;
 *     &lt;enumeration value="WNDA"/&gt;
 *     &lt;enumeration value="WNDD"/&gt;
 *     &lt;enumeration value="WNDE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SpecimenEntityType")
@XmlEnum
public enum SpecimenEntityType {

    ABS,
    AMN,
    ASP,
    BPH,
    BIFL,
    BLDCO,
    BLDA,
    BBL,
    BLDC,
    BPU,
    BLDV,
    FLU,
    BON,
    MILK,
    BRO,
    BRN,
    CALC,
    STON,
    CNL,
    CDM,
    CTP,
    CSF,
    CVM,
    CVX,
    COL,
    CNJT,
    CRN,
    CUR,
    CYST,
    DIAF,
    DOSE,
    DRN,
    DUFL,
    EAR,
    EARW,
    ELT,
    ENDC,
    ENDM,
    EOS,
    RBC,
    BRTH,
    EXG,
    EYE,
    FIB,
    FLT,
    FIST,
    FOOD,
    GAS,
    GAST,
    GEN,
    GENC,
    GENF,
    GENL,
    GENV,
    HAR,
    IHG,
    IT,
    ISLT,
    LAM,
    WBC,
    LN,
    LNA,
    LNV,
    LIQ,
    LYM,
    MAC,
    MAR,
    MEC,
    MBLD,
    MLK,
    NAIL,
    NOS,
    PAFL,
    PAT,
    PRT,
    PLC,
    PLAS,
    PLB,
    PPP,
    PRP,
    PLR,
    PMN,
    PUS,
    SAL,
    SMN,
    SMPLS,
    SER,
    SKM,
    SKN,
    SPRM,
    SPT,
    SPTC,
    SPTT,
    STL,
    SWT,
    SNV,
    TEAR,
    THRT,
    THRB,
    TISG,
    TLGI,
    TLNG,
    TISPL,
    TSMI,
    TISU,
    TISS,
    TUB,
    ULC,
    UMB,
    UMED,
    USUB,
    URTH,
    UR,
    URT,
    URC,
    URNS,
    VOM,
    WAT,
    BLD,
    BDY,
    WICK,
    WND,
    WNDA,
    WNDD,
    WNDE;

    public String getValue() {
        return name();
    }

    public static SpecimenEntityType fromValue(String v) {
        return valueOf(v);
    }

}
