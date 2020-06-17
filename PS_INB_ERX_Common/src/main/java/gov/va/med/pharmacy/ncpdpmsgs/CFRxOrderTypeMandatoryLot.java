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
 * <p>Java class for CFRxOrderTypeMandatoryLot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFRxOrderTypeMandatoryLot">
 *   &lt;complexContent>
 *     &lt;restriction base="{}CFRxOrderType">
 *       &lt;sequence>
 *         &lt;element name="FillNumber" type="{}n2"/>
 *         &lt;element name="RxBarCode" type="{}an" minOccurs="0"/>
 *         &lt;element name="ChildResistantPackage" type="{}BooleanCode"/>
 *         &lt;element name="CFGenericSubstitutedForBrand" type="{}CFGenericSubstitutedForBrand" minOccurs="0"/>
 *         &lt;element name="Technician" type="{}CFRxEntryTechnician" minOccurs="0"/>
 *         &lt;element name="RxRefillMessage" type="{}an" minOccurs="0"/>
 *         &lt;element name="CFDrugImprint" type="{}CFDrugImprint" minOccurs="0"/>
 *         &lt;element name="CFMonograph" type="{}CFMonograph" minOccurs="0"/>
 *         &lt;element name="CFWarningLabel" type="{}CFWarningLabel" minOccurs="0"/>
 *         &lt;element name="Counsel" type="{}CFCounsel" minOccurs="0"/>
 *         &lt;element name="IngredientCost" type="{}an" minOccurs="0"/>
 *         &lt;element name="PrescriptionSellPrice" type="{}an" minOccurs="0"/>
 *         &lt;element name="TotalAmountBrandPenalty" type="{}an" minOccurs="0"/>
 *         &lt;element name="PatientPayAmount" type="{}an" minOccurs="0"/>
 *         &lt;element name="CalculatedPrescriptionSellingPrice" type="{}an" minOccurs="0"/>
 *         &lt;element name="DiscountAmount" type="{}an" minOccurs="0"/>
 *         &lt;element name="ShippingAmount" type="{}an" minOccurs="0"/>
 *         &lt;element name="AuthorizationNumber" type="{}an" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFRxOrderTypeMandatoryLot")
public class CFRxOrderTypeMandatoryLot
    extends CFRxOrderType
{


}
