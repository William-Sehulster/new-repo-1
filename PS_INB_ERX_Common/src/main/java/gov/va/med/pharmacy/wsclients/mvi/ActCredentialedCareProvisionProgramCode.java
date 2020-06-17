
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActCredentialedCareProvisionProgramCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActCredentialedCareProvisionProgramCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AAMC"/&gt;
 *     &lt;enumeration value="AALC"/&gt;
 *     &lt;enumeration value="ABHC"/&gt;
 *     &lt;enumeration value="ACAC"/&gt;
 *     &lt;enumeration value="AHOC"/&gt;
 *     &lt;enumeration value="ACHC"/&gt;
 *     &lt;enumeration value="ALTC"/&gt;
 *     &lt;enumeration value="AOSC"/&gt;
 *     &lt;enumeration value="CACS"/&gt;
 *     &lt;enumeration value="CAMI"/&gt;
 *     &lt;enumeration value="CAST"/&gt;
 *     &lt;enumeration value="CBAR"/&gt;
 *     &lt;enumeration value="CCAR"/&gt;
 *     &lt;enumeration value="COPD"/&gt;
 *     &lt;enumeration value="CCAD"/&gt;
 *     &lt;enumeration value="CDEP"/&gt;
 *     &lt;enumeration value="CDIA"/&gt;
 *     &lt;enumeration value="CDGD"/&gt;
 *     &lt;enumeration value="CEPI"/&gt;
 *     &lt;enumeration value="CFEL"/&gt;
 *     &lt;enumeration value="CHFC"/&gt;
 *     &lt;enumeration value="CHRO"/&gt;
 *     &lt;enumeration value="CHYP"/&gt;
 *     &lt;enumeration value="CMIH"/&gt;
 *     &lt;enumeration value="CMSC"/&gt;
 *     &lt;enumeration value="CONC"/&gt;
 *     &lt;enumeration value="CORT"/&gt;
 *     &lt;enumeration value="COJR"/&gt;
 *     &lt;enumeration value="CPAD"/&gt;
 *     &lt;enumeration value="CPND"/&gt;
 *     &lt;enumeration value="CPST"/&gt;
 *     &lt;enumeration value="CSIC"/&gt;
 *     &lt;enumeration value="CSLD"/&gt;
 *     &lt;enumeration value="CSPT"/&gt;
 *     &lt;enumeration value="CSDM"/&gt;
 *     &lt;enumeration value="CTBU"/&gt;
 *     &lt;enumeration value="CVDC"/&gt;
 *     &lt;enumeration value="CWOH"/&gt;
 *     &lt;enumeration value="CWMA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActCredentialedCareProvisionProgramCode")
@XmlEnum
public enum ActCredentialedCareProvisionProgramCode {

    AAMC,
    AALC,
    ABHC,
    ACAC,
    AHOC,
    ACHC,
    ALTC,
    AOSC,
    CACS,
    CAMI,
    CAST,
    CBAR,
    CCAR,
    COPD,
    CCAD,
    CDEP,
    CDIA,
    CDGD,
    CEPI,
    CFEL,
    CHFC,
    CHRO,
    CHYP,
    CMIH,
    CMSC,
    CONC,
    CORT,
    COJR,
    CPAD,
    CPND,
    CPST,
    CSIC,
    CSLD,
    CSPT,
    CSDM,
    CTBU,
    CVDC,
    CWOH,
    CWMA;

    public String getValue() {
        return name();
    }

    public static ActCredentialedCareProvisionProgramCode fromValue(String v) {
        return valueOf(v);
    }

}
