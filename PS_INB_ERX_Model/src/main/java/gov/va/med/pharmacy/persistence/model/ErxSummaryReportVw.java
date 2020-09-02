package gov.va.med.pharmacy.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "ERX_SUMMARY_REPORT_MVW", schema = "ERX")
@Immutable
public class ErxSummaryReportVw implements java.io.Serializable {


	private static final long serialVersionUID = -8976286905899369578L;
	
	private String pharmacyNcpdpId;
	private String pharmacyVaStationId;
	private String pharmacyDivisionName;
	private String visn;
	private String pharmacyAddress;
	private long newRxCnt;
	private long refillRequest;
	private long refillResponse;
	private long rxChangeRequest;
	private long rxChangeResponse;
	private long cancelRx;
	private long cancelRxResponse;
	private long rxFill;
	private Date newRxMessageDate;
	

	public ErxSummaryReportVw() {
	}

	public ErxSummaryReportVw(String pharmacyNcpdpId, String pharmacyVaStationId, String pharmacyDivisionName, String visn) {
		this.pharmacyNcpdpId = pharmacyNcpdpId;
		this.pharmacyVaStationId = pharmacyVaStationId;
		this.pharmacyDivisionName = pharmacyDivisionName;
		this.visn = visn;
	}

	public ErxSummaryReportVw(String pharmacyNcpdpId, String pharmacyVaStationId, String pharmacyDivisionName, String visn,
			String pharmacyAddress, long newRxCnt, long refillRequest, long refillResponse,
			long rxChangeRequest, long rxChangeResponse, long cancelRx, long cancelRxResponse, long rxFill, Date newRxMessageDate) {
		this.pharmacyNcpdpId = pharmacyNcpdpId;
		this.pharmacyVaStationId = pharmacyVaStationId;
		this.pharmacyDivisionName = pharmacyDivisionName;
		this.visn = visn;
		this.pharmacyAddress = pharmacyAddress;
		this.newRxCnt = newRxCnt;
		this.refillRequest = refillRequest;
		this.refillResponse = refillResponse;
		this.rxChangeRequest = rxChangeRequest;
		this.rxChangeResponse = rxChangeResponse;
		this.cancelRx = cancelRx;
		this.cancelRxResponse = cancelRxResponse;
		this.rxFill = rxFill;
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
		return newRxCnt;
	}

	public void setNewRxCnt(long newRxCnt) {
		this.newRxCnt = newRxCnt;
	}

	@Column(name = "REFILL_REQUEST", precision = 22, scale = 0)
	public long getRefillRequest() {
		return refillRequest;
	}

	public void setRefillRequest(long refillRequest) {
		this.refillRequest = refillRequest;
	}

	@Column(name = "RX_CHANGE_REQUEST", precision = 22, scale = 0)
	public long getRefillResponse() {
		return refillResponse;
	}

	public void setRefillResponse(long refillResponse) {
		this.refillResponse = refillResponse;
	}

	@Column(name = "REFILL_RESPONSE", precision = 22, scale = 0)
	public long getRxChangeRequest() {
		return rxChangeRequest;
	}

	public void setRxChangeRequest(long rxChangeRequest) {
		this.rxChangeRequest = rxChangeRequest;
	}

	@Column(name = "RX_CHANGE_RESPONSE", precision = 22, scale = 0)
	public long getRxChangeResponse() {
		return rxChangeResponse;
	}

	public void setRxChangeResponse(long rxChangeResponse) {
		this.rxChangeResponse = rxChangeResponse;
	}

	@Column(name = "CANCEL_RX", precision = 22, scale = 0)
	public long getCancelRx() {
		return cancelRx;
	}

	public void setCancelRx(long cancelRx) {
		this.cancelRx = cancelRx;
	}

	@Column(name = "CANCEL_RX_RESPONSE", precision = 22, scale = 0)
	public long getCancelRxResponse() {
		return cancelRxResponse;
	}

	public void setCancelRxResponse(long cancelRxResponse) {
		this.cancelRxResponse = cancelRxResponse;
	}

	@Column(name = "RX_FILL", precision = 22, scale = 0)
	public long getRxFill() {
		return rxFill;
	}

	public void setRxFill(long rxFill) {
		this.rxFill = rxFill;
	}

	@Column(name = "NEW_RX_MESSAGE_DATE", length = 8)
	public Date getNewRxMessageDate() {
		return this.newRxMessageDate;
	}

	public void setNewRxMessageDate(Date newRxMessageDate) {
		this.newRxMessageDate = newRxMessageDate;
	}


	// for csv, not to be removed, needs to match the header order.
	@javax.persistence.Transient
	public String[] getStringArray(){
		String[] stringArray = {this.getVisn(),
					this.getPharmacyVaStationId(),
					this.getPharmacyNcpdpId(),
					this.getPharmacyDivisionName(),
					this.getPharmacyAddress(),
					String.valueOf(this.getNewRxCnt()),
					String.valueOf(this.getRefillRequest()),
					String.valueOf(this.getRefillResponse()),
					String.valueOf(this.getRxChangeRequest()),
					String.valueOf(this.getRxChangeResponse()),
					String.valueOf(this.getCancelRx()),
					String.valueOf(this.getCancelRxResponse()),
					String.valueOf(this.getRxFill())
		};
		
		return stringArray;
	}
	
	
	
	
}
