
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActAdjudicationGroupCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActAdjudicationGroupCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CONT"/&gt;
 *     &lt;enumeration value="DAY"/&gt;
 *     &lt;enumeration value="LOC"/&gt;
 *     &lt;enumeration value="MONTH"/&gt;
 *     &lt;enumeration value="PERIOD"/&gt;
 *     &lt;enumeration value="PROV"/&gt;
 *     &lt;enumeration value="WEEK"/&gt;
 *     &lt;enumeration value="YEAR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActAdjudicationGroupCode")
@XmlEnum
public enum ActAdjudicationGroupCode {

    CONT,
    DAY,
    LOC,
    MONTH,
    PERIOD,
    PROV,
    WEEK,
    YEAR;

    public String getValue() {
        return name();
    }

    public static ActAdjudicationGroupCode fromValue(String v) {
        return valueOf(v);
    }

}
