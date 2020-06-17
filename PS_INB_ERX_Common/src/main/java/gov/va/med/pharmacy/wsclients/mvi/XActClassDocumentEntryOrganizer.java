
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActClassDocumentEntryOrganizer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActClassDocumentEntryOrganizer"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="CLUSTER"/&gt;
 *     &lt;enumeration value="BATTERY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "x_ActClassDocumentEntryOrganizer")
@XmlEnum
public enum XActClassDocumentEntryOrganizer {

    CLUSTER,
    BATTERY;

    public String getValue() {
        return name();
    }

    public static XActClassDocumentEntryOrganizer fromValue(String v) {
        return valueOf(v);
    }

}
