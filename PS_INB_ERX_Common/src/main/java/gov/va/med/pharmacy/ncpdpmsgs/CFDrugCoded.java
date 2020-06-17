//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.18 at 03:04:58 PM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Coded Drug Structure used in Medication
 * 
 * <p>Java class for CFDrugCoded complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFDrugCoded">
 *   &lt;complexContent>
 *     &lt;restriction base="{}DrugCoded">
 *       &lt;sequence>
 *         &lt;element name="ProductCode" type="{}ProductCode"/>
 *         &lt;element name="Strength" type="{}Strength" minOccurs="0"/>
 *         &lt;element name="DrugDBCode" type="{}DrugDBCode" minOccurs="0"/>
 *         &lt;element name="DEASchedule" type="{}NCICode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFDrugCoded")
public class CFDrugCoded
    extends DrugCoded
{


}
