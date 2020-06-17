package gov.va.med.pharmacy.persistence.dao;

import java.util.Date;
import java.util.List;

import gov.va.med.pharmacy.persistence.model.SummaryReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


public interface SummaryReportDao {

	SummaryReportVw findByVisn(String networkID);

	List<SummaryReportVw> findByDate(Date dateFrom, Date dateTo);

	// Although this says list infact it returns a map of objects
	List<SummaryReportVw> find(SummaryReportFilter summaryReportFilter);
	
	List<SummaryReportVw> find(String visn);
	
	// This one returns list of objects.
	List<SummaryReportVw> queryForExport(SummaryReportFilter summaryReportFilter);
}
