package gov.va.med.pharmacy.persistence.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.va.med.pharmacy.persistence.dao.RejectReasonsReportDao;
import gov.va.med.pharmacy.persistence.model.RejectReasonsReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;
import gov.va.med.pharmacy.persistence.service.RejectReasonsReportService;


@Service("rejectReasonsReportService")
@Transactional
public class RejectReasonsReportServiceImpl implements RejectReasonsReportService{


@Autowired
private RejectReasonsReportDao rejectReasonsReportDao;

@Override
public RejectReasonsReportVw findByVisn(String id) {
	
	return rejectReasonsReportDao.findByVisn(id);
}

@Override
public List<RejectReasonsReportVw> findByDate(Date dateFrom, Date dateTo) {
	
	return rejectReasonsReportDao.findByDate(dateFrom, dateTo);
}

@Override
public List<RejectReasonsReportVw> find(SummaryReportFilter summaryReportFilter) {
	
	return rejectReasonsReportDao.find(summaryReportFilter);
}

@Override
public List<RejectReasonsReportVw> find(String visn) {
	
	return rejectReasonsReportDao.find(visn);
}

@Override
public List<RejectReasonsReportVw> queryForExport(SummaryReportFilter summaryReportFilter) {
	
	
	return rejectReasonsReportDao.queryForExport(summaryReportFilter);
}


}
