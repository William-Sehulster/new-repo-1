
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActCoverageMaximaCodes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActCoverageMaximaCodes"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="COVMX"/&gt;
 *     &lt;enumeration value="LFEMX"/&gt;
 *     &lt;enumeration value="PRDMX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActCoverageMaximaCodes")
@XmlEnum
public enum ActCoverageMaximaCodes {

    COVMX,
    LFEMX,
    PRDMX;

    public String getValue() {
        return name();
    }

    public static ActCoverageMaximaCodes fromValue(String v) {
        return valueOf(v);
    }

}
