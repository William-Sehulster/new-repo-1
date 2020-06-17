package gov.va.med.pharmacy.persistence.service;

import java.util.Date;
import java.util.List;

import gov.va.med.pharmacy.persistence.model.ErxSummaryReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


public interface ErxSummaryReportService {

	// report data

	ErxSummaryReportVw findByVisn(String id);

	List<ErxSummaryReportVw> findByDate(Date dateFrom, Date dateTo);

	List<ErxSummaryReportVw> find(SummaryReportFilter summaryReportFilter);
	
	List<ErxSummaryReportVw> queryForExport(SummaryReportFilter summaryReportFilter);
	
	List<ErxSummaryReportVw> find(String visn);



}
