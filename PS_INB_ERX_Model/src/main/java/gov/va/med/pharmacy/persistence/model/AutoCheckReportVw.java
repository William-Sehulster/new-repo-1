package gov.va.med.pharmacy.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "AUTO_CHECK_REPORT_MVW1", schema = "ERX")
@Immutable
public class AutoCheckReportVw implements java.io.Serializable {


	private static final long serialVersionUID = -8976286905899369578L;
	
	private String pharmacyNcpdpId;
	private String pharmacyVaStationId;
	private String pharmacyDivisionName;
	private String visn;
	private String pharmacyAddress;
	private long newRxCnt;
	private long newRxPassAutoChk;
	private long newRxPassAutoChkCS;
	private long newRxFailAutoChk;
	private long newRxFailAutoChkCS;
	private long newRxMviPatFound;
	private long newRxMviPatNotFound;
	private long newRxEneElgbEnrl;
	private long newRxEneNotElgbEnrl;
	private long newRxPatNotEnrlSite;
	private long newRxDrgMtchFnd;
	private long newRxDrgMtchNotFnd;
	private long newRxPvdMtchFnd;
	private long newRxPvdMtchNotFnd;
	private Date newRxMessageDate;
	


	public AutoCheckReportVw() {
	}

	public AutoCheckReportVw(String pharmacyNcpdpId, String pharmacyVaStationId, String pharmacyDivisionName, String visn) {
		this.pharmacyNcpdpId = pharmacyNcpdpId;
		this.pharmacyVaStationId = pharmacyVaStationId;
		this.pharmacyDivisionName = pharmacyDivisionName;
		this.visn = visn;
	}

	// E.Carlson - Added new Pass and Fail autocheck column counts for CS.
	public AutoCheckReportVw(String pharmacyNcpdpId, String pharmacyVaStationId, String pharmacyDivisionName, String visn,
			String pharmacyAddress, long newRxCnt, long newRxPassAutoChk, long newRxPassAutoChkCS, long newRxFailAutoChk, 
			long newRxFailAutoChkCS, long newRxMviPatFound, long newRxMviPatNotFound, long newRxEneElgbEnrl, long newRxEneNotElgbEnrl, 
			long newRxPatNotEnrlSite, long newRxDrgMtchFnd,  long newRxDrgMtchNotFnd, long newRxPvdMtchFnd, long newRxPvdMtchNotFnd, 
			Date newRxMessageDate) {
		this.pharmacyNcpdpId = pharmacyNcpdpId;
		this.pharmacyVaStationId = pharmacyVaStationId;
		this.pharmacyDivisionName = pharmacyDivisionName;
		this.visn = visn;
		this.pharmacyAddress = pharmacyAddress;
		this.newRxCnt = newRxCnt;
		this.newRxPassAutoChk = newRxPassAutoChk;
		this.newRxPassAutoChkCS = newRxPassAutoChkCS;
		this.newRxFailAutoChk = newRxFailAutoChk;
		this.newRxFailAutoChkCS = newRxFailAutoChkCS;
		this.newRxMviPatFound = newRxMviPatFound;
		this.newRxMviPatNotFound = newRxMviPatNotFound;
		this.newRxEneElgbEnrl = newRxEneElgbEnrl;
		this.newRxEneNotElgbEnrl = newRxEneNotElgbEnrl;
		this.newRxPatNotEnrlSite = newRxPatNotEnrlSite;
		this.newRxDrgMtchFnd = newRxDrgMtchFnd;
		this.newRxDrgMtchNotFnd = newRxDrgMtchNotFnd;
		this.newRxPvdMtchFnd = newRxPvdMtchFnd;
		this.newRxPvdMtchNotFnd = newRxPvdMtchNotFnd;
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

	@Column(name = "NEW_RX_PASS_AUTO_CHK", precision = 22, scale = 0)
	public long getNewRxPassAutoChk() {
		return this.newRxPassAutoChk;
	}

	public void setNewRxPassAutoChk(long newRxPassAutoChk) {
		this.newRxPassAutoChk = newRxPassAutoChk;
	}
	
	@Column(name = "NEW_RX_PASS_AUTO_CHK_CS", precision = 22, scale = 0)
	public long getNewRxPassAutoChkCS() {
		return this.newRxPassAutoChkCS;
	}

	public void setNewRxPassAutoChkCS(long newRxPassAutoChkCS) {
		this.newRxPassAutoChkCS = newRxPassAutoChkCS;
	}

	@Column(name = "NEW_RX_FAIL_AUTO_CHK", precision = 22, scale = 0)
	public long getNewRxFailAutoChk() {
		return this.newRxFailAutoChk;
	}

	public void setNewRxFailAutoChk(long newRxFailAutoChk) {
		this.newRxFailAutoChk = newRxFailAutoChk;
	}
	
	@Column(name = "NEW_RX_FAIL_AUTO_CHK_CS", precision = 22, scale = 0)
	public long getNewRxFailAutoChkCS() {
		return this.newRxFailAutoChkCS;
	}

	public void setNewRxFailAutoChkCS(long newRxFailAutoChkCS) {
		this.newRxFailAutoChkCS = newRxFailAutoChkCS;
	}
	
	@Column(name = "NEW_RX_MVI_PAT_FOUND", precision = 22, scale = 0)
	public long getNewRxMviPatFound() {
		return newRxMviPatFound;
	}

	public void setNewRxMviPatFound(long newRxMviPatFound) {
		this.newRxMviPatFound = newRxMviPatFound;
	}

	@Column(name = "NEW_RX_MVI_PAT_NOT_FOUND", precision = 22, scale = 0)
	public long getNewRxMviPatNotFound() {
		return newRxMviPatNotFound;
	}

	public void setNewRxMviPatNotFound(long newRxMviPatNotFound) {
		this.newRxMviPatNotFound = newRxMviPatNotFound;
	}

	@Column(name = "NEW_RX_ENE_ELGB_ENRL", precision = 22, scale = 0)
	public long getNewRxEneElgbEnrl() {
		return newRxEneElgbEnrl;
	}

	public void setNewRxEneElgbEnrl(long newRxEneElgbEnrl) {
		this.newRxEneElgbEnrl = newRxEneElgbEnrl;
	}

	@Column(name = "NEW_RX_ENE_NOT_ELGB_ENRL", precision = 22, scale = 0)
	public long getNewRxEneNotElgbEnrl() {
		return newRxEneNotElgbEnrl;
	}

	public void setNewRxEneNotElgbEnrl(long newRxEneNotElgbEnrl) {
		this.newRxEneNotElgbEnrl = newRxEneNotElgbEnrl;
	}

	@Column(name = "NEW_RX_PAT_NOT_ENRL_SITE", precision = 22, scale = 0)
	public long getNewRxPatNotEnrlSite() {
		return newRxPatNotEnrlSite;
	}

	public void setNewRxPatNotEnrlSite(long newRxPatNotEnrlSite) {
		this.newRxPatNotEnrlSite = newRxPatNotEnrlSite;
	}

	@Column(name = "NEW_RX_DRG_MTCH_FND", precision = 22, scale = 0)
	public long getNewRxDrgMtchFnd() {
		return newRxDrgMtchFnd;
	}

	public void setNewRxDrgMtchFnd(long newRxDrgMtchFnd) {
		this.newRxDrgMtchFnd = newRxDrgMtchFnd;
	}

	@Column(name = "NEW_RX_DRG_MTCH_NOT_FND", precision = 22, scale = 0)
	public long getNewRxDrgMtchNotFnd() {
		return newRxDrgMtchNotFnd;
	}

	public void setNewRxDrgMtchNotFnd(long newRxDrgMtchNotFnd) {
		this.newRxDrgMtchNotFnd = newRxDrgMtchNotFnd;
	}

	@Column(name = "NEW_RX_PVD_MTCH_FND", precision = 22, scale = 0)
	public long getNewRxPvdMtchFnd() {
		return newRxPvdMtchFnd;
	}

	public void setNewRxPvdMtchFnd(long newRxPvdMtchFnd) {
		this.newRxPvdMtchFnd = newRxPvdMtchFnd;
	}

	@Column(name = "NEW_RX_PVD_MTCH_NOT_FND", precision = 22, scale = 0)
	public long getNewRxPvdMtchNotFnd() {
		return newRxPvdMtchNotFnd;
	}

	public void setNewRxPvdMtchNotFnd(long newRxPvdMtchNotFnd) {
		this.newRxPvdMtchNotFnd = newRxPvdMtchNotFnd;
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
					String.valueOf(this.getNewRxPassAutoChk()),
					String.valueOf(this.getNewRxPassAutoChkCS()),
					String.valueOf(this.getNewRxFailAutoChk()),
					String.valueOf(this.getNewRxFailAutoChkCS()),
					String.valueOf(this.getNewRxMviPatFound()),
					String.valueOf(this.getNewRxMviPatNotFound()),
					String.valueOf(this.getNewRxEneElgbEnrl()),
					String.valueOf(this.getNewRxEneNotElgbEnrl()),
					String.valueOf(this.getNewRxPatNotEnrlSite()),
					String.valueOf(this.getNewRxDrgMtchFnd()),
					String.valueOf(this.getNewRxDrgMtchNotFnd()),
					String.valueOf(this.getNewRxPvdMtchFnd()),
					String.valueOf(this.getNewRxPvdMtchNotFnd())
		};
		
		return stringArray;
	}
	
	
	
	
}
