package gov.va.med.pharmacy.persistence.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.va.med.pharmacy.persistence.dao.ErxSummaryReportDao;
import gov.va.med.pharmacy.persistence.model.ErxSummaryReportVw;
import gov.va.med.pharmacy.persistence.service.ErxSummaryReportService;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


@Service("erxSummaryReportService")
@Transactional
public class ErxSummaryReportServiceImpl implements ErxSummaryReportService{


@Autowired
private ErxSummaryReportDao erxSummaryReportDao;

@Override
public ErxSummaryReportVw findByVisn(String id) {
	
	return erxSummaryReportDao.findByVisn(id);
}

@Override
public List<ErxSummaryReportVw> findByDate(Date dateFrom, Date dateTo) {
	
	return erxSummaryReportDao.findByDate(dateFrom, dateTo);
}

@Override
public List<ErxSummaryReportVw> find(SummaryReportFilter summaryReportFilter) {
	
	return erxSummaryReportDao.find(summaryReportFilter);
}

@Override
public List<ErxSummaryReportVw> find(String visn) {
	
	return erxSummaryReportDao.find(visn);
}

@Override
public List<ErxSummaryReportVw> queryForExport(SummaryReportFilter summaryReportFilter) {
	
	
	return erxSummaryReportDao.queryForExport(summaryReportFilter);
}


}
