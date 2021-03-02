package gov.va.med.pharmacy.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "REJECT_REASONS_REPORT_MVW1", schema = "ERX")
@Immutable
public class RejectReasonsReportVw implements java.io.Serializable {


	private static final long serialVersionUID = -8976286905899369578L;
	
	// E.Carlson - Remove newRxCsNotAllowed per ERXCS1729 and added "newRxInvalidCsDs", "newRxPrescriberCsCredInvalid", "newRxPatientAddrMissing", 
	//	"newRxCsDateProblem"
	private String pharmacyNcpdpId;
	private String pharmacyVaStationId;
	private String pharmacyDivisionName;
	private String visn;
	private String pharmacyAddress;
	private long newRx;
	private long newRxInProcess;
	private long newRxRejectedByPharmacist;
	private long newRxPatientNotElig;
	private long newRxPatientNotFound;
	private long newRxProviderNotElig;
	private long newRxProviderNotFound;
	private long newRxNotEligRefills;
	private long newRxNonFormulary;
	private long newRxDuplicate;
	private long newRxInvalidQty;
	private long newRxDupTheraClass;
	private long newRxMultiErrCallPharm;
	private long newRxIncorrectPharm;
	private long newRxErrCallPharm;
	private long newRxInvalidCsDs;
	private long newRxPrescriberCsCredInvalid;
	private long newRxPatientAddrMissing;
	private long newRxCsDateIssue;
	private Date newRxMessageDate;
	

	public RejectReasonsReportVw() {
	}

	public RejectReasonsReportVw(String pharmacyNcpdpId, String pharmacyVaStationId, String pharmacyDivisionName, String visn) {
		this.pharmacyNcpdpId = pharmacyNcpdpId;
		this.pharmacyVaStationId = pharmacyVaStationId;
		this.pharmacyDivisionName = pharmacyDivisionName;
		this.visn = visn;
	}

	public RejectReasonsReportVw(String pharmacyNcpdpId, String pharmacyVaStationId, String pharmacyDivisionName, String visn,
			String pharmacyAddress, long newRx, long newRxInProcess, long newRxRejectedByPharmacist, long newRxPatientNotElig,
			long newRxPatientNotFound, long newRxProviderNotElig, long newRxProviderNotFound, long newRxNotEligRefills, long newRxNonFormulary, long newRxDuplicate,
			long newRxInvalidQty, long newRxDupTheraClass, long newRxMultiErrCallPharm, long newRxIncorrectPharm, long newRxErrCallPharm, long newRxInvalidCsDs,
			long newRxPrescriberCsCredInvalid, long newRxPatientAddrMissing, long newRxCsDateIssue, Date newRxMessageDate) {
				
		this.pharmacyNcpdpId = pharmacyNcpdpId;
		this.pharmacyVaStationId = pharmacyVaStationId;
		this.pharmacyDivisionName = pharmacyDivisionName;
		this.visn = visn;
		this.pharmacyAddress = pharmacyAddress;
		this.newRx = newRx;
		this.newRxInProcess = newRxInProcess;
		this.newRxRejectedByPharmacist = newRxRejectedByPharmacist;
		this.newRxPatientNotElig = newRxPatientNotElig;
		this.newRxPatientNotFound = newRxPatientNotFound;
		this.newRxProviderNotElig = newRxProviderNotElig;
		this.newRxProviderNotFound = newRxProviderNotFound;
		this.newRxNotEligRefills = newRxNotEligRefills;
		this.newRxNonFormulary = newRxNonFormulary;
		this.newRxDuplicate = newRxDuplicate;
		this.newRxInvalidQty = newRxInvalidQty;
		this.newRxDupTheraClass = newRxDupTheraClass;
		this.newRxMultiErrCallPharm = newRxMultiErrCallPharm;
		this.newRxIncorrectPharm = newRxIncorrectPharm;
		this.newRxErrCallPharm = newRxErrCallPharm;
		this.newRxInvalidCsDs = newRxInvalidCsDs;
		this.newRxPrescriberCsCredInvalid = newRxPrescriberCsCredInvalid;
		this.newRxPatientAddrMissing = newRxPatientAddrMissing;
		this.newRxCsDateIssue = newRxCsDateIssue;
		this.newRxMessageDate = newRxMessageDate;
	}

	@Column(name = "PHARMACY_NCPDP_ID", nullable = false, length = 7)
	public String getPharmacyNcpdpId() {
		return this.pharmacyNcpdpId;
	}

	public void setPharmacyNcpdpId(String pharmacyNcpdpId) {
		this.pharmacyNcpdpId = pharmacyNcpdpId;
	}
	
	@Id
	@Column(name = "PHARMACY_VA_STATION_ID", nullable = false, length = 10)
	public String getPharmacyVaStationId() {
		return this.pharmacyVaStationId;
	}

	public void setPharmacyVaStationId(String pharmacyVaStationId) {
		this.pharmacyVaStationId = pharmacyVaStationId;
	}

	@Column(name = "PHARMACY_DIVISION_NAME", nullable = false, length = 35)
	public String getPharmacyDivisionName() {
		return this.pharmacyDivisionName;
	}

	public void setPharmacyDivisionName(String pharmacyDivisionName) {
		this.pharmacyDivisionName = pharmacyDivisionName;
	}
	
	
	@Column(name = "VISN", nullable = false, length = 2)
	public String getVisn() {
		return this.visn;
	}

	public void setVisn(String visn) {
		this.visn = visn;
	}

	@Column(name = "PHARMACY_ADDRESS", length = 122)
	public String getPharmacyAddress() {
		return this.pharmacyAddress;
	}

	public void setPharmacyAddress(String pharmacyAddress) {
		this.pharmacyAddress = pharmacyAddress;
	}

	@Column(name = "NEW_RX_CNT", precision = 22, scale = 0)
	public long getNewRx() {
		return newRx;
	}

	public void setNewRx(long newRx) {
		this.newRx = newRx;
	}

	@Column(name = "NEW_RX_IN_PROCESS", precision = 22, scale = 0)
	public long getNewRxInProcess() {
		return newRxInProcess;
	}

	public void setNewRxInProcess(long newRxInProcess) {
		this.newRxInProcess = newRxInProcess;
	}

	@Column(name = "NEW_RX_REJECTED_BY_PHARMACIST", precision = 22, scale = 0)
	public long getNewRxRejectedByPharmacist() {
		return newRxRejectedByPharmacist;
	}

	public void setNewRxRejectedByPharmacist(long newRxRejectedByPharmacist) {
		this.newRxRejectedByPharmacist = newRxRejectedByPharmacist;
	}

	@Column(name = "NEW_RX_PATIENT_NOT_ELIG", precision = 22, scale = 0)
	public long getNewRxPatientNotElig() {
		return newRxPatientNotElig;
	}

	public void setNewRxPatientNotElig(long newRxPatientNotElig) {
		this.newRxPatientNotElig = newRxPatientNotElig;
	}

	@Column(name = "NEW_RX_PATIENT_NOT_FOUND", precision = 22, scale = 0)
	public long getNewRxPatientNotFound() {
		return newRxPatientNotFound;
	}

	public void setNewRxPatientNotFound(long newRxPatientNotFound) {
		this.newRxPatientNotFound = newRxPatientNotFound;
	}

	@Column(name = "NEW_RX_PROVIDER_NOT_ELIG", precision = 22, scale = 0)
	public long getNewRxProviderNotElig() {
		return newRxProviderNotElig;
	}

	public void setNewRxProviderNotElig(long newRxProviderNotElig) {
		this.newRxProviderNotElig = newRxProviderNotElig;
	}

	@Column(name = "NEW_RX_PROVIDER_NOT_FOUND", precision = 22, scale = 0)
	public long getNewRxProviderNotFound() {
		return newRxProviderNotFound;
	}

	public void setNewRxProviderNotFound(long newRxProviderNotFound) {
		this.newRxProviderNotFound = newRxProviderNotFound;
	}

	@Column(name = "NEW_RX_NON_FORMULARY", precision = 22, scale = 0)
	public long getNewRxNonFormulary() {
		return newRxNonFormulary;
	}

	public void setNewRxNonFormulary(long newRxNonFormulary) {
		this.newRxNonFormulary = newRxNonFormulary;
	}

	@Column(name = "NEW_RX_DUPLICATE", precision = 22, scale = 0)
	public long getNewRxDuplicate() {
		return newRxDuplicate;
	}

	public void setNewRxDuplicate(long newRxDuplicate) {
		this.newRxDuplicate = newRxDuplicate;
	}

	@Column(name = "NEW_RX_INVALID_QTY", precision = 22, scale = 0)
	public long getNewRxInvalidQty() {
		return newRxInvalidQty;
	}

	public void setNewRxInvalidQty(long newRxInvalidQty) {
		this.newRxInvalidQty = newRxInvalidQty;
	}

	@Column(name = "NEW_RX_DUP_THERA_CLASS", precision = 22, scale = 0)
	public long getNewRxDupTheraClass() {
		return newRxDupTheraClass;
	}

	public void setNewRxDupTheraClass(long newRxDupTheraClass) {
		this.newRxDupTheraClass = newRxDupTheraClass;
	}

	@Column(name = "NEW_RX_ERR_MULTI_CALL_PHARM", precision = 22, scale = 0)
	public long getNewRxMultiErrCallPharm() {
		return newRxMultiErrCallPharm;
	}

	public void setNewRxMultiErrCallPharm(long newRxMultiErrCallPharm) {
		this.newRxMultiErrCallPharm = newRxMultiErrCallPharm;
	}

	@Column(name = "NEW_RX_INCORRECT_PHARM", precision = 22, scale = 0)
	public long getNewRxIncorrectPharm() {
		return newRxIncorrectPharm;
	}

	public void setNewRxIncorrectPharm(long newRxIncorrectPharm) {
		this.newRxIncorrectPharm = newRxIncorrectPharm;
	}

	@Column(name = "NEW_RX_ERR_CALL_PHARM", precision = 22, scale = 0)
	public long getNewRxErrCallPharm() {
		return newRxErrCallPharm;
	}

	public void setNewRxErrCallPharm(long newRxErrCallPharm) {
		this.newRxErrCallPharm = newRxErrCallPharm;
	}
	
	// E.Carlson - Added new columns per ERXCS1729 for CS.
	@Column(name = "NEW_RX_MISSING_CS_DS", precision = 22, scale = 0)
	public long getNewRxInvalidCsDs() {
		return newRxInvalidCsDs;
	}

	public void setNewRxInvalidCsDs(long newRxInvalidCsDs) {
		this.newRxInvalidCsDs = newRxInvalidCsDs;
	}
	
	@Column(name = "NEW_RX_PRES_CS_CRED_INVALID", precision = 22, scale = 0)
	public long getNewRxPrescriberCsCredInvalid() {
		return newRxPrescriberCsCredInvalid;
	}

	public void setNewRxPrescriberCsCredInvalid(long newRxPrescriberCsCredInvalid) {
		this.newRxPrescriberCsCredInvalid = newRxPrescriberCsCredInvalid;
	}
	
	@Column(name = "NEW_RX_PATIENT_ADDR_MISSING", precision = 22, scale = 0)
	public long getNewRxPatientAddrMissing() {
		return newRxPatientAddrMissing;
	}

	public void setNewRxPatientAddrMissing(long newRxPatientAddrMissing) {
		this.newRxPatientAddrMissing = newRxPatientAddrMissing;
	}
	
	@Column(name = "NEW_RX_CS_DATE_ISSUE", precision = 22, scale = 0)
	public long getNewRxCsDateIssue() {
		return newRxCsDateIssue;
	}

	public void setNewRxCsDateIssue(long newRxCsDateIssue) {
		this.newRxCsDateIssue = newRxCsDateIssue;
	}

	@Column(name = "NEW_RX_MESSAGE_DATE", length = 8)
	public Date getNewRxMessageDate() {
		return this.newRxMessageDate;
	}

	public void setNewRxMessageDate(Date newRxMessageDate) {
		this.newRxMessageDate = newRxMessageDate;
	}

	@Column(name = "NEW_RX_NOT_ELIG_REFILLS", precision = 22, scale = 0)
	public long getNewRxNotEligRefills() {
		return newRxNotEligRefills;
	}

	public void setNewRxNotEligRefills(long newRxNotEligRefills) {
		this.newRxNotEligRefills = newRxNotEligRefills;
	}

	// for csv, not to be removed, needs to match the header order.
	// E.Carlson - Remove newRxCsNotAllowed per ERXCS1729 and added "newRxInvalidCsDs", "newRxPrescriberCsCredInvalid", "newRxPatientAddrMissing", 
	//	"newRxCsDateProblem"
	@javax.persistence.Transient
	public String[] getStringArray(){
		String[] stringArray = {this.getVisn(),
					this.getPharmacyVaStationId(),
					this.getPharmacyNcpdpId(),
					this.getPharmacyDivisionName(),
					this.getPharmacyAddress(),
					String.valueOf(this.getNewRx()),
					String.valueOf(this.getNewRxInProcess()),
					String.valueOf(this.getNewRxRejectedByPharmacist()),
					String.valueOf(this.getNewRxPatientNotElig()),
					String.valueOf(this.getNewRxPatientNotFound()),
					String.valueOf(this.getNewRxProviderNotElig()),
					String.valueOf(this.getNewRxProviderNotFound()),
					String.valueOf(this.getNewRxNotEligRefills()),
					String.valueOf(this.getNewRxNonFormulary()),
					String.valueOf(this.getNewRxDuplicate()),
					String.valueOf(this.getNewRxInvalidQty()),
					String.valueOf(this.getNewRxDupTheraClass()),
					String.valueOf(this.getNewRxMultiErrCallPharm()),
					String.valueOf(this.getNewRxIncorrectPharm()),
					String.valueOf(this.getNewRxErrCallPharm()),
					String.valueOf(this.getNewRxInvalidCsDs()),
					String.valueOf(this.getNewRxPrescriberCsCredInvalid()),
					String.valueOf(this.getNewRxPatientAddrMissing()),
					String.valueOf(this.getNewRxCsDateIssue())
		};
		
		return stringArray;
	}
	
	
	
	
}
