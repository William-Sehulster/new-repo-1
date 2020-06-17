
package gov.va.med.pharmacy.wsclients.mvi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IrrigationSolution.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IrrigationSolution"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="IRSOL"/&gt;
 *     &lt;enumeration value="DOUCHE"/&gt;
 *     &lt;enumeration value="ENEMA"/&gt;
 *     &lt;enumeration value="OPIRSOL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IrrigationSolution")
@XmlEnum
public enum IrrigationSolution {

    IRSOL,
    DOUCHE,
    ENEMA,
    OPIRSOL;

    public String getValue() {
        return name();
    }

    public static IrrigationSolution fromValue(String v) {
        return valueOf(v);
    }

}
