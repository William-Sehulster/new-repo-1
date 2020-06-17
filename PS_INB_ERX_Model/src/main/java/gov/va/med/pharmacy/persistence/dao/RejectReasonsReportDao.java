package gov.va.med.pharmacy.persistence.dao;

import java.util.Date;
import java.util.List;

import gov.va.med.pharmacy.persistence.model.RejectReasonsReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


public interface RejectReasonsReportDao {

	RejectReasonsReportVw findByVisn(String networkID);

	List<RejectReasonsReportVw> findByDate(Date dateFrom, Date dateTo);

	// Although this says list infact it returns a map of objects
	List<RejectReasonsReportVw> find(SummaryReportFilter summaryReportFilter);
	
	List<RejectReasonsReportVw> find(String visn);
	
	// This one returns list of objects.
	List<RejectReasonsReportVw> queryForExport(SummaryReportFilter summaryReportFilter);
}
