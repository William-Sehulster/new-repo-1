package gov.va.med.pharmacy.persistence.dao;

import java.util.Date;
import java.util.List;

import gov.va.med.pharmacy.persistence.model.ErxSummaryReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


public interface ErxSummaryReportDao {

	ErxSummaryReportVw findByVisn(String networkID);

	List<ErxSummaryReportVw> findByDate(Date dateFrom, Date dateTo);

	// Although this says list infact it returns a map of objects
	List<ErxSummaryReportVw> find(SummaryReportFilter summaryReportFilter);
	
	List<ErxSummaryReportVw> find(String visn);
	
	// This one returns list of objects.
	List<ErxSummaryReportVw> queryForExport(SummaryReportFilter summaryReportFilter);
}
