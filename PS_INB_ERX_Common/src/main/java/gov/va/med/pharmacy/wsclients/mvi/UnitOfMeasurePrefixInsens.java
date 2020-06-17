
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfMeasurePrefixInsens.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfMeasurePrefixInsens"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="DA"/&gt;
 *     &lt;enumeration value="EX"/&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="GIB"/&gt;
 *     &lt;enumeration value="GA"/&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="KIB"/&gt;
 *     &lt;enumeration value="K"/&gt;
 *     &lt;enumeration value="MIB"/&gt;
 *     &lt;enumeration value="MA"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="PT"/&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="TIB"/&gt;
 *     &lt;enumeration value="TR"/&gt;
 *     &lt;enumeration value="YO"/&gt;
 *     &lt;enumeration value="YA"/&gt;
 *     &lt;enumeration value="ZO"/&gt;
 *     &lt;enumeration value="ZA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "UnitOfMeasurePrefixInsens")
@XmlEnum
public enum UnitOfMeasurePrefixInsens {

    A,
    C,
    D,
    DA,
    EX,
    F,
    GIB,
    GA,
    H,
    KIB,
    K,
    MIB,
    MA,
    U,
    M,
    N,
    PT,
    P,
    TIB,
    TR,
    YO,
    YA,
    ZO,
    ZA;

    public String getValue() {
        return name();
    }

    public static UnitOfMeasurePrefixInsens fromValue(String v) {
        return valueOf(v);
    }

}
