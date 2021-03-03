package gov.va.med.pharmacy.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "ERX_SUMMARY_REPORT_MVW1", schema = "ERX")
@Immutable
public class ErxSummaryReportVw implements java.io.Serializable {

	private static final long serialVersionUID = -8976286905899369578L;
	
	//M. Bolden - 5.0 - added fields to match new CS columns added for Controlled substance
	
	private String pharmacyNcpdpId;
	private String pharmacyVaStationId;
	private String pharmacyDivisionName;
	private String visn;
	private String pharmacyAddress;
	private long newRxCnt;
	private long newRxCntCS;
	private long refillRequest;
	private long refillRequestCS;    //5.0
	private long refillResponse;
	private long refillResponseCS;   //5.0
	private long rxChangeRequest;
	private long rxChangeRequestCS;  //5.0
	private long rxChangeResponse;
	private long rxChangeResponseCS; //5.0
	private long cancelRx;
	private long cancelRxCS;         //5.0
	private long cancelRxResponse;
	private long cancelRxResponseCS; //5.0
	private long rxFill;
	private long rxFillCS;           //5.0
	private long rxDoNotFillCS;      //5.0

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
			String pharmacyAddress, long newRxCnt, long newRxCntCS, long refillRequest, long refillRequestCS, long refillResponse,
			long refillResponseCS, long rxChangeRequest, long rxChangeRequestCS, long rxChangeResponse, long rxChangeResponseCS, 
			long cancelRx, long cancelRxCS, long cancelRxResponse, long cancelRxResponseCS, long rxFill, long rxFillCS, long rxDoNotFillCS, 
			Date newRxMessageDate) {

		this.pharmacyNcpdpId = pharmacyNcpdpId;
		this.pharmacyVaStationId = pharmacyVaStationId;
		this.pharmacyDivisionName = pharmacyDivisionName;
		this.visn = visn;
		this.pharmacyAddress = pharmacyAddress;
		this.newRxCnt = newRxCnt;
		this.newRxCntCS = newRxCntCS;
		this.refillRequest = refillRequest;
		this.refillRequestCS = refillRequestCS;
		this.refillResponse = refillResponse;
		this.refillResponseCS = refillResponseCS;
		this.rxChangeRequest = rxChangeRequest;
		this.rxChangeRequestCS = rxChangeRequestCS;
		this.rxChangeResponse = rxChangeResponse;
		this.rxChangeResponseCS = rxChangeResponseCS;
		this.cancelRx = cancelRx;
		this.cancelRxCS = cancelRxCS;
		this.cancelRxResponse = cancelRxResponse;
		this.cancelRxResponseCS = cancelRxResponseCS;
		this.rxFill = rxFill;
		this.rxFillCS = rxFillCS;
		this.rxDoNotFillCS = rxDoNotFillCS;
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
	
	
	//M. Bolden - 5.0

	@Column(name = "NEW_RX_CNT_CS", precision = 22, scale = 0)
	public long getNewRxCntCS() {
		return newRxCntCS;
	}

	public void setNewRxCntCS(long newRxCntCS) {
		this.newRxCntCS = newRxCntCS;
	}	

	@Column(name = "REFILL_REQUEST", precision = 22, scale = 0)
	public long getRefillRequest() {
		return refillRequest;
	}

	public void setRefillRequest(long refillRequest) {
		this.refillRequest = refillRequest;
	}
	
	//M. Bolden - 5.0
	@Column(name = "REFILL_REQUEST_CS", precision = 22, scale = 0)
	public long getRefillRequestCS() {
		return refillRequestCS;
	}

	public void setRefillRequestCS(long refillRequestCS) {
		this.refillRequestCS = refillRequestCS;

	}	


	@Column(name = "RX_CHANGE_REQUEST", precision = 22, scale = 0)
	public long getRefillResponse() {
		return refillResponse;
	}

	public void setRefillResponse(long refillResponse) {
		this.refillResponse = refillResponse;
	}
	

	//M. Bolden - 5.0

	@Column(name = "RX_CHANGE_REQUEST_CS", precision = 22, scale = 0)
	public long getRefillResponseCS() {
		return refillResponseCS;
	}

	public void setRefillResponseCS(long refillResponseCS) {
		this.refillResponseCS = refillResponseCS;

	}	


	@Column(name = "REFILL_RESPONSE", precision = 22, scale = 0)
	public long getRxChangeRequest() {
		return rxChangeRequest;
	}

	public void setRxChangeRequest(long rxChangeRequest) {
		this.rxChangeRequest = rxChangeRequest;
	}
	
	
	//M. Bolden - 5.0

	@Column(name = "REFILL_RESPONSE_CS", precision = 22, scale = 0)
	public long getRxChangeRequestCS() {
		return rxChangeRequestCS;
	}

	public void setRxChangeRequestCS(long rxChangeRequestCS) {
		this.rxChangeRequestCS = rxChangeRequestCS;

	}	


	@Column(name = "RX_CHANGE_RESPONSE", precision = 22, scale = 0)
	public long getRxChangeResponse() {
		return rxChangeResponse;
	}

	public void setRxChangeResponse(long rxChangeResponse) {
		this.rxChangeResponse = rxChangeResponse;
	}
	
	//M. Bolden - 5.0

	@Column(name = "RX_CHANGE_RESPONSE_CS", precision = 22, scale = 0)
	public long getRxChangeResponseCS() {
		return rxChangeResponseCS;
	}

	public void setRxChangeResponseCS(long rxChangeResponseCS) {
		this.rxChangeResponseCS = rxChangeResponseCS;
	}	

	@Column(name = "CANCEL_RX", precision = 22, scale = 0)
	public long getCancelRx() {
		return cancelRx;
	}

	public void setCancelRx(long cancelRx) {
		this.cancelRx = cancelRx;
	}
	
	//M. Bolden - 5.0

	@Column(name = "CANCEL_RX_CS", precision = 22, scale = 0)
	public long getCancelRxCS() {
		return cancelRxCS;
	}

	public void setCancelRxCS(long cancelRxCS) {
		this.cancelRxCS = cancelRxCS;

	}	


	@Column(name = "CANCEL_RX_RESPONSE", precision = 22, scale = 0)
	public long getCancelRxResponse() {
		return cancelRxResponse;
	}

	public void setCancelRxResponse(long cancelRxResponse) {
		this.cancelRxResponse = cancelRxResponse;
	}
	
	//M. Bolden - 5.0

	@Column(name = "CANCEL_RX_RESPONSE_CS", precision = 22, scale = 0)
	public long getCancelRxResponseCS() {
		return cancelRxResponseCS;
	}

	public void setCancelRxResponseCS(long cancelRxResponseCS) {
		this.cancelRxResponseCS = cancelRxResponseCS;
	}	

	@Column(name = "RX_FILL", precision = 22, scale = 0)
	public long getRxFill() {
		return rxFill;
	}

	public void setRxFill(long rxFill) {
		this.rxFill = rxFill;
	}

	//M. Bolden - 5.0

	@Column(name = "RX_FILL_CS", precision = 22, scale = 0)
	public long getRxFillCS() {
		return rxFillCS;
	}

	public void setRxFillCS(long rxFillCS) {
		this.rxFillCS = rxFillCS;
	}
	
	@Column(name = "RX_DO_NOT_FILL_CS", precision = 22, scale = 0)
	public long getrxDoNotFillCS() {
		return rxDoNotFillCS;
	}

	public void setrxDoNotFillCS(long rxDoNotFillCS) {
		this.rxDoNotFillCS = rxDoNotFillCS;
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
					String.valueOf(this.getNewRxCntCS()),
					String.valueOf(this.getRefillRequest()),
					String.valueOf(this.getRefillRequestCS()),
					String.valueOf(this.getRefillResponse()),
					String.valueOf(this.getRefillResponseCS()),
					String.valueOf(this.getRxChangeRequest()),
					String.valueOf(this.getRxChangeRequestCS()),
					String.valueOf(this.getRxChangeResponse()),
					String.valueOf(this.getRxChangeResponseCS()),
					String.valueOf(this.getCancelRx()),
					String.valueOf(this.getCancelRxCS()),
					String.valueOf(this.getCancelRxResponse()),
					String.valueOf(this.getCancelRxResponseCS()),
					String.valueOf(this.getRxFill()),
					String.valueOf(this.getRxFillCS()),
					String.valueOf(this.getrxDoNotFillCS())

		};
		
		return stringArray;
	}
	
	
	
	
}
