
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActCoverageQuantityLimitCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActCoverageQuantityLimitCode"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="NETAMT"/&gt;
 *     &lt;enumeration value="NETAMT"/&gt;
 *     &lt;enumeration value="UNITPRICE"/&gt;
 *     &lt;enumeration value="UNITPRICE"/&gt;
 *     &lt;enumeration value="UNITQTY"/&gt;
 *     &lt;enumeration value="UNITQTY"/&gt;
 *     &lt;enumeration value="COVPRD"/&gt;
 *     &lt;enumeration value="COVPRD"/&gt;
 *     &lt;enumeration value="LFEMX"/&gt;
 *     &lt;enumeration value="PRDMX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActCoverageQuantityLimitCode")
@XmlEnum
public enum ActCoverageQuantityLimitCode {

    NETAMT,
    UNITPRICE,
    UNITQTY,
    COVPRD,
    LFEMX,
    PRDMX;

    public String getValue() {
        return name();
    }

    public static ActCoverageQuantityLimitCode fromValue(String v) {
        return valueOf(v);
    }

}
