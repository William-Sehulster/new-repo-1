
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PasteDrugForm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PasteDrugForm"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="PASTE"/&gt;
 *     &lt;enumeration value="PUD"/&gt;
 *     &lt;enumeration value="TPASTE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PasteDrugForm")
@XmlEnum
public enum PasteDrugForm {

    PASTE,
    PUD,
    TPASTE;

    public String getValue() {
        return name();
    }

    public static PasteDrugForm fromValue(String v) {
        return valueOf(v);
    }

}
