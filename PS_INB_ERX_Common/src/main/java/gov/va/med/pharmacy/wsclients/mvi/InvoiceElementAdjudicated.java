
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvoiceElementAdjudicated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InvoiceElementAdjudicated"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ADNPPPELAT"/&gt;
 *     &lt;enumeration value="ADNPPPELCT"/&gt;
 *     &lt;enumeration value="ADNPPPMNAT"/&gt;
 *     &lt;enumeration value="ADNPPPMNCT"/&gt;
 *     &lt;enumeration value="ADNPSPELAT"/&gt;
 *     &lt;enumeration value="ADNPSPELCT"/&gt;
 *     &lt;enumeration value="ADNPSPMNAT"/&gt;
 *     &lt;enumeration value="ADNPSPMNCT"/&gt;
 *     &lt;enumeration value="ADNFPPELAT"/&gt;
 *     &lt;enumeration value="ADNFPPELCT"/&gt;
 *     &lt;enumeration value="ADNFPPMNAT"/&gt;
 *     &lt;enumeration value="ADNFPPMNCT"/&gt;
 *     &lt;enumeration value="ADNFSPELAT"/&gt;
 *     &lt;enumeration value="ADNFSPELCT"/&gt;
 *     &lt;enumeration value="ADNFSPMNAT"/&gt;
 *     &lt;enumeration value="ADNFSPMNCT"/&gt;
 *     &lt;enumeration value="ADPPPPELAT"/&gt;
 *     &lt;enumeration value="ADPPPPELCT"/&gt;
 *     &lt;enumeration value="ADPPPPMNAT"/&gt;
 *     &lt;enumeration value="ADPPPPMNCT"/&gt;
 *     &lt;enumeration value="ADPPSPELAT"/&gt;
 *     &lt;enumeration value="ADPPSPELCT"/&gt;
 *     &lt;enumeration value="ADPPSPMNAT"/&gt;
 *     &lt;enumeration value="ADPPSPMNCT"/&gt;
 *     &lt;enumeration value="ADRFPPELAT"/&gt;
 *     &lt;enumeration value="ADRFPPELCT"/&gt;
 *     &lt;enumeration value="ADRFPPMNAT"/&gt;
 *     &lt;enumeration value="ADRFPPMNCT"/&gt;
 *     &lt;enumeration value="ADRFSPELAT"/&gt;
 *     &lt;enumeration value="ADRFSPELCT"/&gt;
 *     &lt;enumeration value="ADRFSPMNAT"/&gt;
 *     &lt;enumeration value="ADRFSPMNCT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "InvoiceElementAdjudicated")
@XmlEnum
public enum InvoiceElementAdjudicated {

    ADNPPPELAT,
    ADNPPPELCT,
    ADNPPPMNAT,
    ADNPPPMNCT,
    ADNPSPELAT,
    ADNPSPELCT,
    ADNPSPMNAT,
    ADNPSPMNCT,
    ADNFPPELAT,
    ADNFPPELCT,
    ADNFPPMNAT,
    ADNFPPMNCT,
    ADNFSPELAT,
    ADNFSPELCT,
    ADNFSPMNAT,
    ADNFSPMNCT,
    ADPPPPELAT,
    ADPPPPELCT,
    ADPPPPMNAT,
    ADPPPPMNCT,
    ADPPSPELAT,
    ADPPSPELCT,
    ADPPSPMNAT,
    ADPPSPMNCT,
    ADRFPPELAT,
    ADRFPPELCT,
    ADRFPPMNAT,
    ADRFPPMNCT,
    ADRFSPELAT,
    ADRFSPELCT,
    ADRFSPMNAT,
    ADRFSPMNCT;

    public String getValue() {
        return name();
    }

    public static InvoiceElementAdjudicated fromValue(String v) {
        return valueOf(v);
    }

}
