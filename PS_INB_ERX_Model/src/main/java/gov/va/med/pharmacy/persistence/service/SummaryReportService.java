package gov.va.med.pharmacy.persistence.service;

import java.util.Date;
import java.util.List;

import gov.va.med.pharmacy.persistence.model.SummaryReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


public interface SummaryReportService {

	// report data

	SummaryReportVw findByVisn(String id);

	List<SummaryReportVw> findByDate(Date dateFrom, Date dateTo);

	List<SummaryReportVw> find(SummaryReportFilter summaryReportFilter);
	
	List<SummaryReportVw> queryForExport(SummaryReportFilter summaryReportFilter);
	
	List<SummaryReportVw> find(String visn);



}
