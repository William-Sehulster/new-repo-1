package gov.va.med.pharmacy.persistence.service;

import java.util.Date;
import java.util.List;

import gov.va.med.pharmacy.persistence.model.RejectReasonsReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


public interface RejectReasonsReportService {

	// report data

	RejectReasonsReportVw findByVisn(String id);

	List<RejectReasonsReportVw> findByDate(Date dateFrom, Date dateTo);

	List<RejectReasonsReportVw> find(SummaryReportFilter summaryReportFilter);
	
	List<RejectReasonsReportVw> queryForExport(SummaryReportFilter summaryReportFilter);
	
	List<RejectReasonsReportVw> find(String visn);



}
