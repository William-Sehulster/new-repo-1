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
 * <p>Java class for RxChangeResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RxChangeResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{}ResponseAbstractType">
 *       &lt;choice>
 *         &lt;element name="Approved" type="{}ApprovedWithoutReasonType"/>
 *         &lt;element name="Denied" type="{}RxChangeResponseDeniedType"/>
 *         &lt;element name="DeniedNewPrescriptionToFollow" type="{}NoteType" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="ApprovedWithChanges" type="{}ApprovedWithoutReasonType"/>
 *         &lt;element name="Replace" type="{}NoteType" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Validated" type="{}ValidatedAbstractType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RxChangeResponseType")
public class RxChangeResponseType
    extends ResponseAbstractType
{


}
