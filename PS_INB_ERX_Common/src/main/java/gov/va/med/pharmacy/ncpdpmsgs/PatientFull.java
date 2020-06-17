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
 * <p>Java class for PatientFull complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientFull">
 *   &lt;complexContent>
 *     &lt;restriction base="{}PatientFullAbstract">
 *       &lt;sequence>
 *         &lt;element name="Identification" type="{}PatientID" minOccurs="0"/>
 *         &lt;element name="Name" type="{}NameType"/>
 *         &lt;element name="FormerName" type="{}NameType" minOccurs="0"/>
 *         &lt;element name="Gender" type="{}Gender"/>
 *         &lt;element name="DateOfBirth" type="{}DateType"/>
 *         &lt;element name="Address" type="{}AddressType" minOccurs="0"/>
 *         &lt;element name="CommunicationNumbers" type="{}CommunicationNumbersType" minOccurs="0"/>
 *         &lt;element name="PatientLocation" type="{}PatientLocation" minOccurs="0"/>
 *         &lt;element name="LanguageNameCode" type="{}an1..3" minOccurs="0"/>
 *         &lt;element name="ResidenceCode" type="{}ResidenceCode" minOccurs="0"/>
 *         &lt;element name="PregnancyIndicator" type="{}BooleanCode" minOccurs="0"/>
 *         &lt;element name="Race" type="{}CDCCode" minOccurs="0"/>
 *         &lt;element name="Ethnicity" type="{}CDCCode" minOccurs="0"/>
 *         &lt;element name="AlternateContact" type="{}AlternateContactStructure" minOccurs="0"/>
 *         &lt;element name="GestationalAge" type="{}n1..2" minOccurs="0"/>
 *         &lt;element name="HospiceIndicator" type="{}HospiceIndicator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientFull")
public class PatientFull
    extends PatientFullAbstract
{


}
