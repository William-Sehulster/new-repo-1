//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.18 at 03:04:58 PM EST 
//


package gov.va.med.pharmacy.ncpdpmsgs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Value PC
 * 
 * <p>Java class for Prescriber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Prescriber">
 *   &lt;complexContent>
 *     &lt;restriction base="{}OptionalPrescriber">
 *       &lt;sequence>
 *         &lt;element name="Identification" type="{}NonVeterinarianID"/>
 *         &lt;element name="Specialty" type="{}an1..10" minOccurs="0"/>
 *         &lt;element name="PracticeLocation" type="{}PracticeLocationType" minOccurs="0"/>
 *         &lt;element name="Name" type="{}NameType"/>
 *         &lt;element name="FormerName" type="{}NameType" minOccurs="0"/>
 *         &lt;element name="Address" type="{}AddressType" minOccurs="0"/>
 *         &lt;element name="PrescriberAgent" type="{}NameComposite" minOccurs="0"/>
 *         &lt;element name="CommunicationNumbers" type="{}CommunicationNumbersType"/>
 *         &lt;element name="PrescriberPlaceOfService" type="{}n2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Prescriber")
@XmlSeeAlso({
    MandatoryPrescriber.class
})
public class Prescriber
    extends OptionalPrescriber
{


}
