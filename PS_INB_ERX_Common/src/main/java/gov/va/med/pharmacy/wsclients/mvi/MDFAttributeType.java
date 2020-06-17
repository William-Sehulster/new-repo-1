
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MDFAttributeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MDFAttributeType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ADDR"/&gt;
 *     &lt;enumeration value="CD"/&gt;
 *     &lt;enumeration value="COM"/&gt;
 *     &lt;enumeration value="DTTM"/&gt;
 *     &lt;enumeration value="DESC"/&gt;
 *     &lt;enumeration value="EXPR"/&gt;
 *     &lt;enumeration value="FRC"/&gt;
 *     &lt;enumeration value="TIME"/&gt;
 *     &lt;enumeration value="ID"/&gt;
 *     &lt;enumeration value="IND"/&gt;
 *     &lt;enumeration value="NM"/&gt;
 *     &lt;enumeration value="NBR"/&gt;
 *     &lt;enumeration value="PHON"/&gt;
 *     &lt;enumeration value="QTY"/&gt;
 *     &lt;enumeration value="TXT"/&gt;
 *     &lt;enumeration value="TMR"/&gt;
 *     &lt;enumeration value="VALUE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MDFAttributeType")
@XmlEnum
public enum MDFAttributeType {

    ADDR,
    CD,
    COM,
    DTTM,
    DESC,
    EXPR,
    FRC,
    TIME,
    ID,
    IND,
    NM,
    NBR,
    PHON,
    QTY,
    TXT,
    TMR,
    VALUE;

    public String getValue() {
        return name();
    }

    public static MDFAttributeType fromValue(String v) {
        return valueOf(v);
    }

}
