package gov.va.med.pharmacy.persistence.dao;

import java.util.Date;
import java.util.List;

import gov.va.med.pharmacy.persistence.model.AutoCheckReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


public interface AutoCheckReportDao {

	AutoCheckReportVw findByVisn(String networkID);

	List<AutoCheckReportVw> findByDate(Date dateFrom, Date dateTo);

	// Although this says list infact it returns a map of objects
	List<AutoCheckReportVw> find(SummaryReportFilter summaryReportFilter);
	
	List<AutoCheckReportVw> find(String visn);
	
	// This one returns list of objects.
	List<AutoCheckReportVw> queryForExport(SummaryReportFilter summaryReportFilter);
}
