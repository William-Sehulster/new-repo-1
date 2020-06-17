package gov.va.med.pharmacy.persistence.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.va.med.pharmacy.persistence.dao.AutoCheckReportDao;
import gov.va.med.pharmacy.persistence.model.AutoCheckReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;
import gov.va.med.pharmacy.persistence.service.AutoCheckReportService;


@Service("autoCheckReportService")
@Transactional
public class AutoCheckReportServiceImpl implements AutoCheckReportService{


@Autowired
private AutoCheckReportDao autoCheckReportDao;

@Override
public AutoCheckReportVw findByVisn(String id) {
	
	return autoCheckReportDao.findByVisn(id);
}

@Override
public List<AutoCheckReportVw> findByDate(Date dateFrom, Date dateTo) {
	
	return autoCheckReportDao.findByDate(dateFrom, dateTo);
}

@Override
public List<AutoCheckReportVw> find(SummaryReportFilter summaryReportFilter) {
	
	return autoCheckReportDao.find(summaryReportFilter);
}

@Override
public List<AutoCheckReportVw> find(String visn) {
	
	return autoCheckReportDao.find(visn);
}

@Override
public List<AutoCheckReportVw> queryForExport(SummaryReportFilter summaryReportFilter) {
	
	
	return autoCheckReportDao.queryForExport(summaryReportFilter);
}


}
