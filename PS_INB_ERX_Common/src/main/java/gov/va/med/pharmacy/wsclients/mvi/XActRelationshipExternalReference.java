
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActRelationshipExternalReference.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActRelationshipExternalReference"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="XCRPT"/&gt;
 *     &lt;enumeration value="ELNK"/&gt;
 *     &lt;enumeration value="SUBJ"/&gt;
 *     &lt;enumeration value="SPRT"/&gt;
 *     &lt;enumeration value="REFR"/&gt;
 *     &lt;enumeration value="RPLC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ActRelationshipExternalReference")
@XmlEnum
public enum XActRelationshipExternalReference {

    XCRPT,
    ELNK,
    SUBJ,
    SPRT,
    REFR,
    RPLC;

    public String getValue() {
        return name();
    }

    public static XActRelationshipExternalReference fromValue(String v) {
        return valueOf(v);
    }

}
