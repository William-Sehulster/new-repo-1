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
 * <p>Java class for DrugAdministrationMedication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrugAdministrationMedication">
 *   &lt;complexContent>
 *     &lt;restriction base="{}MedicationAbstract">
 *       &lt;sequence>
 *         &lt;element name="DrugDescription" type="{}an1..105"/>
 *         &lt;element name="DrugCoded" type="{}DrugCoded" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{}Quantity"/>
 *         &lt;element name="DaysSupply" type="{}n1..3" minOccurs="0"/>
 *         &lt;element name="WrittenDate" type="{}DateType"/>
 *         &lt;element name="LastFillDate" type="{}DateType" minOccurs="0"/>
 *         &lt;element name="Substitutions" type="{}SubstitutionCode"/>
 *         &lt;element name="NumberOfRefills" type="{}n1..2" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Diagnosis" type="{}DiagnosisRestricted" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="PriorAuthorization" type="{}an1..35" minOccurs="0"/>
 *         &lt;element name="Note" type="{}an1..210" minOccurs="0"/>
 *         &lt;element name="DrugUseEvaluation" type="{}DrugUseEvaluation" maxOccurs="5" minOccurs="0"/>
 *         &lt;element name="DrugCoverageStatusCode" type="{}DrugCoverageStatusCode" maxOccurs="5" minOccurs="0"/>
 *         &lt;element name="PriorAuthorizationStatus" type="{}PriorAuthorizationStatus" minOccurs="0"/>
 *         &lt;element name="Sig" type="{}Sig"/>
 *         &lt;element name="PharmacyRequestedRefills" type="{}n1..2" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="DoNotFill" type="{}DoNotFill" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="TimeZone" type="{}TimeZone" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="RefillsRemaining" type="{}n1..2" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="HistoryPrescriberOrderNumber" type="{}an1..35" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="OrderCaptureMethod" type="{}OrderCaptureMethod" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Pharmacy" type="{}Pharmacy" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="Prescriber" type="{}PrescriberGeneralChoice" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="HistorySource" type="{}HistorySourceWithoutPayment" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="ReasonForSubstitutionCodeUsed" type="{}ReasonForSubstitutionCodeUsed" minOccurs="0"/>
 *         &lt;element name="SplitScript" type="{}SplitScript" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="ManufacturerName" type="{}an1..105" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="LotNumber" type="{}LotNumber" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="RxFillIndicator" type="{}RxFillIndicator" minOccurs="0"/>
 *         &lt;element name="Service" type="{}ServiceStructure" minOccurs="0"/>
 *         &lt;element name="IVAdministration" type="{}IVAdministrationType" minOccurs="0"/>
 *         &lt;element name="TreatmentIndicator" type="{}TreatmentIndicator" minOccurs="0"/>
 *         &lt;element name="ProphylacticOrEpisodic" type="{}ProphylacticOrEpisodic" minOccurs="0"/>
 *         &lt;element name="CurrentTreatmentCycle" type="{}n1..2" minOccurs="0"/>
 *         &lt;element name="NumberOfCyclesPlanned" type="{}n1..2" minOccurs="0"/>
 *         &lt;element name="CompoundInformation" type="{}CompoundLotNotUsed" minOccurs="0"/>
 *         &lt;element name="NumberOfPackagesToBeDispensed" type="{}n1..2" minOccurs="0"/>
 *         &lt;element name="OtherMedicationDate" type="{}OtherMedicationDate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NeedNoLaterThan" type="{}NeedNoLaterThan" maxOccurs="0" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DrugAdministrationMedication")
public class DrugAdministrationMedication
    extends MedicationAbstract
{


}
