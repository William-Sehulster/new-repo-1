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
 * <p>Java class for MandatoryAddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MandatoryAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{}AddressType">
 *       &lt;sequence>
 *         &lt;element name="AddressLine1" type="{}an1..40"/>
 *         &lt;element name="AddressLine2" type="{}an1..40" minOccurs="0"/>
 *         &lt;element name="City" type="{}an1..35"/>
 *         &lt;element name="StateProvince" type="{}an"/>
 *         &lt;element name="PostalCode" type="{}an"/>
 *         &lt;element name="CountryCode" type="{}an1..2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandatoryAddressType")
public class MandatoryAddressType
    extends AddressType
{


}
