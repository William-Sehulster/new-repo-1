package gov.va.med.pharmacy.persistence.report;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SummaryReportFilter {

	// names should be same as those in the javascript.

	private Date dateTo;
	
	private Date dateFrom;
	
	private String visn;
	
	private String stationId;
	
	
	public Date getDateTo() {
		if (dateTo != null) {
			//dateTo.setTime(dateTo.getTime() + (1 * (5 * 60 * 60 * 1000)));
		}
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Date getDateFrom() {
		
		if (dateFrom != null) {
			//dateFrom.setTime(dateFrom.getTime() - (1 * (5 * 60 * 60 * 1000)));
		}
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getVisn() {
		return visn;
	}

	public void setVisn(String visn) {
		this.visn = visn;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	
}
