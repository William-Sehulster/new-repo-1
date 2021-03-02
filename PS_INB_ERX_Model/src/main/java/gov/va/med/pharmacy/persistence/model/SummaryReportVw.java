package gov.va.med.pharmacy.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "SUMMARY_REPORT_MVW", schema = "ERX")
@Immutable
public class SummaryReportVw implements java.io.Serializable {


	private static final long serialVersionUID = -8976286905899369578L;
	
	private String pharmacyNcpdpId;
	private String pharmacyVaStationId;
	private String pharmacyDivisionName;
	private String visn;
	private String pharmacyAddress;
	private long newRxCnt;
	private long newRxCntCS;
	private long newRxPharmDisabledAtHub;
	private long newRxRejectedAtHub;
	private long newRxRejectedAtHubCS;
	private long newRxPassAutoChk;
	private long newRxPassAutoChkCS;
	private long newRxFailAutoChk;
	private long newRxFailAutoChkCS;
	private long newRxRejectedByPharmacist;
	private long newRxRejectedByPharmacistCS;
	private long newRxFilled;
	private long newRxFilledCS;
	private long newRxInProcess;
	private long newRxInProcessCS;
	private Date newRxMessageDate;
	
	
	

	

	public SummaryReportVw() {
	}

	public SummaryReportVw(String pharmacyNcpdpId, String pharmacyVaStationId, String pharmacyDivisionName, String visn) {
		this.pharmacyNcpdpId = pharmacyNcpdpId;
		this.pharmacyVaStationId = pharmacyVaStationId;
		this.pharmacyDivisionName = pharmacyDivisionName;
		this.visn = visn;
	}

	public SummaryReportVw(String pharmacyNcpdpId, String pharmacyVaStationId, String pharmacyDivisionName, String visn,
			String pharmacyAddress, long newRxCnt, long newRxCntCS, long newRxPharmDisabledAtHub,
			long newRxRejectedAtHub, long newRxRejectedAtHubCS, long newRxPassAutoChk, long newRxPassAutoChkCS, long newRxFailAutoChk, long newRxFailAutoChkCS,
			Date newRxMessageDate) {
		this.pharmacyNcpdpId = pharmacyNcpdpId;
		this.pharmacyVaStationId = pharmacyVaStationId;
		this.pharmacyDivisionName = pharmacyDivisionName;
		this.visn = visn;
		this.pharmacyAddress = pharmacyAddress;
		this.newRxCnt = newRxCnt;
		this.newRxCntCS = newRxCntCS;
		this.newRxPharmDisabledAtHub = newRxPharmDisabledAtHub;
		this.newRxRejectedAtHub = newRxRejectedAtHub;
		this.newRxRejectedAtHubCS = newRxRejectedAtHubCS;
		this.newRxPassAutoChk = newRxPassAutoChk;
		this.newRxPassAutoChkCS = newRxPassAutoChkCS;
		this.newRxFailAutoChk = newRxFailAutoChk;
		this.newRxFailAutoChkCS = newRxFailAutoChkCS;
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
	public long getNewRxCnt() {
		return this.newRxCnt;
	}

	public void setNewRxCnt(long newRxCnt) {
		this.newRxCnt = newRxCnt;
	}

	//M. Bolden - 5.0
	@Column(name = "NEW_RX_CNT_CS", precision = 22, scale = 0)
	public long getNewRxCntCS() {
		return this.newRxCntCS;
	}

	public void setNewRxCntCS(long newRxCntCS) {
		this.newRxCntCS = newRxCntCS;
	}
	
	
	@Column(name = "NEW_RX_PHARM_DISABLED_AT_HUB", precision = 22, scale = 0)
	public long getNewRxPharmDisabledAtHub() {
		return this.newRxPharmDisabledAtHub;
	}

	public void setNewRxPharmDisabledAtHub(long newRxPharmDisabledAtHub) {
		this.newRxPharmDisabledAtHub = newRxPharmDisabledAtHub;
	}

	@Column(name = "NEW_RX_REJECTED_AT_HUB", precision = 22, scale = 0)
	public long getNewRxRejectedAtHub() {
		return this.newRxRejectedAtHub;
	}

	public void setNewRxRejectedAtHub(long newRxRejectedAtHub) {
		this.newRxRejectedAtHub = newRxRejectedAtHub;
	}
	
	//M. Bolden - 5.0
	@Column(name = "NEW_RX_REJECTED_AT_HUB_CS", precision = 22, scale = 0)
	public long getNewRxRejectedAtHubCS() {
		return this.newRxRejectedAtHubCS;
	}

	public void setNewRxRejectedAtHubCS(long newRxRejectedAtHubCS) {
		this.newRxRejectedAtHubCS = newRxRejectedAtHubCS;
	}

	@Column(name = "NEW_RX_PASS_AUTO_CHK", precision = 22, scale = 0)
	public long getNewRxPassAutoChk() {
		return this.newRxPassAutoChk;
	}

	public void setNewRxPassAutoChk(long newRxPassAutoChk) {
		this.newRxPassAutoChk = newRxPassAutoChk;
	}
	
	//M. Bolden - 5.0
	@Column(name = "NEW_RX_PASS_AUTO_CHK_CS", precision = 22, scale = 0)
	public long getNewRxPassAutoChkCS() {
		return this.newRxPassAutoChkCS;
	}

	public void setNewRxPassAutoChkCS(long newRxPassAutoChkCS) {
		this.newRxPassAutoChkCS = newRxPassAutoChkCS;
	}
	
	//M. Bolden - 5.0
	@Column(name = "NEW_RX_FAIL_AUTO_CHK_CS", precision = 22, scale = 0)
	public long getNewRxFailAutoChkCS() {
		return this.newRxFailAutoChkCS;
	}

	public void setNewRxFailAutoChkCS(long newRxFailAutoChkCS) {
		this.newRxFailAutoChkCS = newRxFailAutoChkCS;
	}

	@Column(name = "NEW_RX_FAIL_AUTO_CHK", precision = 22, scale = 0)
	public long getNewRxFailAutoChk() {
		return this.newRxFailAutoChk;
	}

	public void setNewRxFailAutoChk(long newRxFailAutoChk) {
		this.newRxFailAutoChk = newRxFailAutoChk;
	}
	
	@Column(name = "NEW_RX_REJECTED_BY_PHARMACIST", precision = 22, scale = 0)
	public long getNewRxRejectedByPharmacist() {
		return this.newRxRejectedByPharmacist;
	}

	public void setNewRxRejectedByPharmacist(long newRxRejectedByPharmacist) {
		this.newRxRejectedByPharmacist = newRxRejectedByPharmacist;
	}
	
	//M. Bolden - 5.0
	@Column(name = "NEW_RX_REJECTED_BY_PHARMACIST_CS", precision = 22, scale = 0)
	public long getNewRxRejectedByPharmacistCS() {
		return this.newRxRejectedByPharmacistCS;
	}

	public void setNewRxRejectedByPharmacistCS(long newRxRejectedByPharmacistCS) {
		this.newRxRejectedByPharmacistCS = newRxRejectedByPharmacistCS;
	}

	@Column(name = "NEW_RX_FILLED", precision = 22, scale = 0)
	public long getNewRxFilled() {
		return this.newRxFilled;
	}

	public void setNewRxFilled(long newRxFilled) {
		this.newRxFilled = newRxFilled;
	}
	
	//M. Bolden - 5.0
	@Column(name = "NEW_RX_FILLED_CS", precision = 22, scale = 0)
	public long getNewRxFilledCS() {
		return this.newRxFilledCS;
	}

	public void setNewRxFilledCS(long newRxFilledCS) {
		this.newRxFilledCS = newRxFilledCS;
	}

	@Column(name = "NEW_RX_IN_PROCESS", precision = 22, scale = 0)
	public long getNewRxInProcess() {
		return this.newRxInProcess;
	}

	public void setNewRxInProcess(long newRxInProcess) {
		this.newRxInProcess = newRxInProcess;
	}
	
	//M. Bolden - 5.0
	@Column(name = "NEW_RX_IN_PROCESS_CS", precision = 22, scale = 0)
	public long getNewRxInProcessCS() {
		return this.newRxInProcessCS;
	}

	public void setNewRxInProcessCS(long newRxInProcessCS) {
		this.newRxInProcessCS = newRxInProcessCS;
	}

	@Column(name = "NEW_RX_MESSAGE_DATE", length = 8)
	public Date getNewRxMessageDate() {
		return this.newRxMessageDate;
	}

	public void setNewRxMessageDate(Date newRxMessageDate) {
		this.newRxMessageDate = newRxMessageDate;
	}

	

	// for csv, not to be removed, needs to match the hearder order.
	@javax.persistence.Transient
	public String[] getStringArray(){
		String[] stringArray = {this.getVisn(),
					this.getPharmacyVaStationId(),
					this.getPharmacyNcpdpId(),
					this.getPharmacyDivisionName(),
					this.getPharmacyAddress(),
					String.valueOf(this.getNewRxCnt()),
					String.valueOf(this.getNewRxCntCS()),
					String.valueOf(this.getNewRxPharmDisabledAtHub()),
					String.valueOf(this.getNewRxRejectedAtHub()),
					String.valueOf(this.getNewRxRejectedAtHubCS()),
					String.valueOf(this.getNewRxPassAutoChk()),
					String.valueOf(this.getNewRxPassAutoChkCS()),
					String.valueOf(this.getNewRxFailAutoChk()),
					String.valueOf(this.getNewRxFailAutoChkCS()),
					String.valueOf(this.getNewRxRejectedByPharmacist()),
					String.valueOf(this.getNewRxRejectedByPharmacistCS()),
					String.valueOf(this.getNewRxFilled()),
					String.valueOf(this.getNewRxFilledCS()),
					String.valueOf(this.getNewRxInProcess()),
					String.valueOf(this.getNewRxInProcessCS())
		};
		
		return stringArray;
	}
	
	
	
	
}
