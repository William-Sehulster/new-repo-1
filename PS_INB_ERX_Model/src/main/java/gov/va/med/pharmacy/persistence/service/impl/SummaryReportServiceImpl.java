package gov.va.med.pharmacy.persistence.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.va.med.pharmacy.persistence.dao.SummaryReportDao;
import gov.va.med.pharmacy.persistence.model.SummaryReportVw;
import gov.va.med.pharmacy.persistence.service.SummaryReportService;
import gov.va.med.pharmacy.persistence.report.StationIdSelectModel;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


@Service("summaryReportService")
@Transactional
public class SummaryReportServiceImpl implements SummaryReportService{


@Autowired
private SummaryReportDao summaryReportDao;

@Override
public List<StationIdSelectModel> getStationIDs(int visn) {
	
	return summaryReportDao.getStationIDs(visn);
}

@Override
public SummaryReportVw findByVisn(String id) {
	
	return summaryReportDao.findByVisn(id);
}

@Override
public List<SummaryReportVw> findByDate(Date dateFrom, Date dateTo) {
	
	return summaryReportDao.findByDate(dateFrom, dateTo);
}

@Override
public List<SummaryReportVw> find(SummaryReportFilter summaryReportFilter) {
	
	return summaryReportDao.find(summaryReportFilter);
}

@Override
public List<SummaryReportVw> find(String visn) {
	
	return summaryReportDao.find(visn);
}

@Override
public List<SummaryReportVw> queryForExport(SummaryReportFilter summaryReportFilter) {
	
	
	return summaryReportDao.queryForExport(summaryReportFilter);
}


}
