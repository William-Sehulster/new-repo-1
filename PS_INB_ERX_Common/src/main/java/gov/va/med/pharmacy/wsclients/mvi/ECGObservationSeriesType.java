
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ECGObservationSeriesType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ECGObservationSeriesType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="REPRESENTATIVE_BEAT"/&gt;
 *     &lt;enumeration value="RHYTHM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ECGObservationSeriesType")
@XmlEnum
public enum ECGObservationSeriesType {

    REPRESENTATIVE_BEAT,
    RHYTHM;

    public String getValue() {
        return name();
    }

    public static ECGObservationSeriesType fromValue(String v) {
        return valueOf(v);
    }

}
