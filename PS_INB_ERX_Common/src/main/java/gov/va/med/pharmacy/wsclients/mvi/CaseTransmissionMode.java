
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CaseTransmissionMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CaseTransmissionMode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AIRTRNS"/&gt;
 *     &lt;enumeration value="ANANTRNS"/&gt;
 *     &lt;enumeration value="ANHUMTRNS"/&gt;
 *     &lt;enumeration value="BLDTRNS"/&gt;
 *     &lt;enumeration value="BDYFLDTRNS"/&gt;
 *     &lt;enumeration value="ENVTRNS"/&gt;
 *     &lt;enumeration value="FECTRNS"/&gt;
 *     &lt;enumeration value="FOMTRNS"/&gt;
 *     &lt;enumeration value="FOODTRNS"/&gt;
 *     &lt;enumeration value="HUMHUMTRNS"/&gt;
 *     &lt;enumeration value="INDTRNS"/&gt;
 *     &lt;enumeration value="LACTTRNS"/&gt;
 *     &lt;enumeration value="NOSTRNS"/&gt;
 *     &lt;enumeration value="PARTRNS"/&gt;
 *     &lt;enumeration value="SEXTRNS"/&gt;
 *     &lt;enumeration value="DERMTRNS"/&gt;
 *     &lt;enumeration value="TRNSFTRNS"/&gt;
 *     &lt;enumeration value="PLACTRNS"/&gt;
 *     &lt;enumeration value="VECTRNS"/&gt;
 *     &lt;enumeration value="WATTRNS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CaseTransmissionMode")
@XmlEnum
public enum CaseTransmissionMode {

    AIRTRNS,
    ANANTRNS,
    ANHUMTRNS,
    BLDTRNS,
    BDYFLDTRNS,
    ENVTRNS,
    FECTRNS,
    FOMTRNS,
    FOODTRNS,
    HUMHUMTRNS,
    INDTRNS,
    LACTTRNS,
    NOSTRNS,
    PARTRNS,
    SEXTRNS,
    DERMTRNS,
    TRNSFTRNS,
    PLACTRNS,
    VECTRNS,
    WATTRNS;

    public String getValue() {
        return name();
    }

    public static CaseTransmissionMode fromValue(String v) {
        return valueOf(v);
    }

}
