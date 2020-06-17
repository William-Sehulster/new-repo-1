
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActCredentialedCareProvisionPersonCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActCredentialedCareProvisionPersonCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CPGC"/&gt;
 *     &lt;enumeration value="CAMC"/&gt;
 *     &lt;enumeration value="CAIC"/&gt;
 *     &lt;enumeration value="CACC"/&gt;
 *     &lt;enumeration value="CAPC"/&gt;
 *     &lt;enumeration value="CANC"/&gt;
 *     &lt;enumeration value="CBGC"/&gt;
 *     &lt;enumeration value="CCCC"/&gt;
 *     &lt;enumeration value="CCGC"/&gt;
 *     &lt;enumeration value="CMGC"/&gt;
 *     &lt;enumeration value="CCPC"/&gt;
 *     &lt;enumeration value="CCSC"/&gt;
 *     &lt;enumeration value="CDEC"/&gt;
 *     &lt;enumeration value="CDRC"/&gt;
 *     &lt;enumeration value="CEMC"/&gt;
 *     &lt;enumeration value="CFPC"/&gt;
 *     &lt;enumeration value="CIMC"/&gt;
 *     &lt;enumeration value="CNSC"/&gt;
 *     &lt;enumeration value="CNEC"/&gt;
 *     &lt;enumeration value="CNQC"/&gt;
 *     &lt;enumeration value="CNMC"/&gt;
 *     &lt;enumeration value="COGC"/&gt;
 *     &lt;enumeration value="COMC"/&gt;
 *     &lt;enumeration value="COPC"/&gt;
 *     &lt;enumeration value="COSC"/&gt;
 *     &lt;enumeration value="COTC"/&gt;
 *     &lt;enumeration value="CPEC"/&gt;
 *     &lt;enumeration value="CPRC"/&gt;
 *     &lt;enumeration value="CPSC"/&gt;
 *     &lt;enumeration value="CPYC"/&gt;
 *     &lt;enumeration value="CPHC"/&gt;
 *     &lt;enumeration value="CROC"/&gt;
 *     &lt;enumeration value="CRPC"/&gt;
 *     &lt;enumeration value="CSUC"/&gt;
 *     &lt;enumeration value="CTSC"/&gt;
 *     &lt;enumeration value="CURC"/&gt;
 *     &lt;enumeration value="CVSC"/&gt;
 *     &lt;enumeration value="LGPC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActCredentialedCareProvisionPersonCode")
@XmlEnum
public enum ActCredentialedCareProvisionPersonCode {

    CPGC,
    CAMC,
    CAIC,
    CACC,
    CAPC,
    CANC,
    CBGC,
    CCCC,
    CCGC,
    CMGC,
    CCPC,
    CCSC,
    CDEC,
    CDRC,
    CEMC,
    CFPC,
    CIMC,
    CNSC,
    CNEC,
    CNQC,
    CNMC,
    COGC,
    COMC,
    COPC,
    COSC,
    COTC,
    CPEC,
    CPRC,
    CPSC,
    CPYC,
    CPHC,
    CROC,
    CRPC,
    CSUC,
    CTSC,
    CURC,
    CVSC,
    LGPC;

    public String getValue() {
        return name();
    }

    public static ActCredentialedCareProvisionPersonCode fromValue(String v) {
        return valueOf(v);
    }

}
