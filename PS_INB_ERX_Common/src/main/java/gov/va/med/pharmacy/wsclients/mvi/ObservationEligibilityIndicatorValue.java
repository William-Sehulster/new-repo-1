
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObservationEligibilityIndicatorValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObservationEligibilityIndicatorValue"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ELSTAT"/&gt;
 *     &lt;enumeration value="ADOPT"/&gt;
 *     &lt;enumeration value="BTHCERT"/&gt;
 *     &lt;enumeration value="CCOC"/&gt;
 *     &lt;enumeration value="DRLIC"/&gt;
 *     &lt;enumeration value="FOSTER"/&gt;
 *     &lt;enumeration value="MRGCERT"/&gt;
 *     &lt;enumeration value="MIL"/&gt;
 *     &lt;enumeration value="PASSPORT"/&gt;
 *     &lt;enumeration value="MEMBER"/&gt;
 *     &lt;enumeration value="STUDENRL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ObservationEligibilityIndicatorValue")
@XmlEnum
public enum ObservationEligibilityIndicatorValue {

    ELSTAT,
    ADOPT,
    BTHCERT,
    CCOC,
    DRLIC,
    FOSTER,
    MRGCERT,
    MIL,
    PASSPORT,
    MEMBER,
    STUDENRL;

    public String getValue() {
        return name();
    }

    public static ObservationEligibilityIndicatorValue fromValue(String v) {
        return valueOf(v);
    }

}
