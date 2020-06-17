package gov.va.med.pharmacy.persistence.service;

import java.util.Date;
import java.util.List;

import gov.va.med.pharmacy.persistence.model.AutoCheckReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


public interface AutoCheckReportService {

	// report data

	AutoCheckReportVw findByVisn(String id);

	List<AutoCheckReportVw> findByDate(Date dateFrom, Date dateTo);

	List<AutoCheckReportVw> find(SummaryReportFilter summaryReportFilter);
	
	List<AutoCheckReportVw> queryForExport(SummaryReportFilter summaryReportFilter);
	
	List<AutoCheckReportVw> find(String visn);



}
