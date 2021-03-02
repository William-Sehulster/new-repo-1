package gov.va.med.pharmacy.persistence.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import gov.va.med.pharmacy.persistence.BaseDao;
import gov.va.med.pharmacy.persistence.dao.AutoCheckReportDao;
import gov.va.med.pharmacy.persistence.model.AutoCheckReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


@Repository("autoCheckReportDao")
public class AutoCheckReportDaoImpl extends BaseDao<Integer, AutoCheckReportVw> implements AutoCheckReportDao{
   
	
	@Override
	public AutoCheckReportVw findByVisn(String visn) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("visn", visn));
        AutoCheckReportVw autoCheckReportVw = (AutoCheckReportVw)crit.uniqueResult();
        
        return autoCheckReportVw;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AutoCheckReportVw> findByDate(Date dateFrom, Date dateTo) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("pharmacyDivisionName"));
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results
        List<AutoCheckReportVw> autoCheckReportRows = (List<AutoCheckReportVw>) criteria.list();
        
        return autoCheckReportRows;
	}
	
	
	// Although it has return type of list, in fact it returns a map of objects
	@SuppressWarnings("unchecked")
	@Override
	public List<AutoCheckReportVw> find(SummaryReportFilter summaryReportFilter) {
		
		//System.out.print("DateFrom: " + summaryReportFilter.getDateFrom()
		//+ " DateTo: " + summaryReportFilter.getDateTo() + "VISN: " + summaryReportFilter.getVisn()
		//+ "Station ID: " + summaryReportFilter.getStationId());
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("pharmacyDivisionName"));

		criteria.add(Restrictions.ge("newRxMessageDate", getFormattedFromDateTime(summaryReportFilter.getDateFrom())));
		criteria.add(Restrictions.le("newRxMessageDate", getFormattedToDateTime(summaryReportFilter.getDateTo())));

		if (summaryReportFilter.getVisn().length() > 0){ //check for All value
			criteria.add(Restrictions.eq("visn", summaryReportFilter.getVisn()));
		}
		if (summaryReportFilter.getStationId() != null){
			if (summaryReportFilter.getStationId().compareTo("All") != 0){ //check for All value
				criteria.add(Restrictions.eq("pharmacyVaStationId", summaryReportFilter.getStationId()));
			}
		}
		criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("visn").as("visn"))
				.add(Projections.groupProperty("pharmacyNcpdpId").as("pharmacyNcpdpId"))
				.add(Projections.groupProperty("pharmacyVaStationId").as("pharmacyVaStationId"))
				.add(Projections.groupProperty("pharmacyDivisionName").as("pharmacyDivisionName"))
				.add(Projections.groupProperty("pharmacyAddress").as("pharmacyAddress"))
				.add(Projections.sum("newRxCnt").as("newRxCnt"))
				.add(Projections.sum("newRxPassAutoChk").as("newRxPassAutoChk"))
				.add(Projections.sum("newRxPassAutoChkCs").as("newRxPassAutoChkCs"))
				.add(Projections.sum("newRxFailAutoChk").as("newRxFailAutoChk"))
				.add(Projections.sum("newRxFailAutoChkCs").as("newRxFailAutoChkCs"))
				.add(Projections.sum("newRxMviPatFound").as("newRxMviPatFound"))
				.add(Projections.sum("newRxMviPatNotFound").as("newRxMviPatNotFound"))
				.add(Projections.sum("newRxEneElgbEnrl").as("newRxEneElgbEnrl"))
				.add(Projections.sum("newRxEneNotElgbEnrl").as("newRxEneNotElgbEnrl"))
				.add(Projections.sum("newRxPatNotEnrlSite").as("newRxPatNotEnrlSite"))
				.add(Projections.sum("newRxDrgMtchFnd").as("newRxDrgMtchFnd"))
				.add(Projections.sum("newRxDrgMtchNotFnd").as("newRxDrgMtchNotFnd"))
				.add(Projections.sum("newRxPvdMtchFnd").as("newRxPvdMtchFnd"))
				.add(Projections.sum("newRxPvdMtchNotFnd").as("newRxPvdMtchNotFnd"))
				);

		criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
		List<AutoCheckReportVw> autoCheckReportRows = (List<AutoCheckReportVw>) criteria.list();
		
		
		
        return autoCheckReportRows;
	}

	@SuppressWarnings("unchecked")
	@Override	
	public List<AutoCheckReportVw> find(String visn) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("pharmacyVaStationId"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results
        if (visn != null && visn.length() > 0){
		visn = visn.substring(0, visn.length()-1);
	       // if (visn.compareTo("") == 0){ //check for All value
				//visn = "%";	
			//}
        } 
        else{
        visn = "%";	
        }
	
		criteria.add(Restrictions.like("visn", visn));
        List<AutoCheckReportVw> selectRows = (List<AutoCheckReportVw>) criteria.list();
        
        return selectRows;
		

	}

	// This returns a list to be used for csv export.
	@SuppressWarnings("unchecked")
	@Override
	public List<AutoCheckReportVw> queryForExport(SummaryReportFilter summaryReportFilter) {
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("pharmacyDivisionName"));
	
		criteria.add(Restrictions.ge("newRxMessageDate", getFormattedFromDateTime(summaryReportFilter.getDateFrom())));
		criteria.add(Restrictions.le("newRxMessageDate", getFormattedToDateTime(summaryReportFilter.getDateTo())));
		
		if (summaryReportFilter.getVisn().length() > 0){ //check for All value
			criteria.add(Restrictions.eq("visn", summaryReportFilter.getVisn()));
		}
		if (summaryReportFilter.getStationId() != null){
			if (summaryReportFilter.getStationId().compareTo("All") != 0){ //check for All value
				criteria.add(Restrictions.eq("pharmacyVaStationId", summaryReportFilter.getStationId()));
			}
		}
		criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("visn").as("visn"))
				.add(Projections.groupProperty("pharmacyVaStationId").as("pharmacyVaStationId"))
				.add(Projections.groupProperty("pharmacyNcpdpId").as("pharmacyNcpdpId"))
				.add(Projections.groupProperty("pharmacyDivisionName").as("pharmacyDivisionName"))
				.add(Projections.groupProperty("pharmacyAddress").as("pharmacyAddress"))
				.add(Projections.sum("newRxCnt").as("newRxCnt"))
				.add(Projections.sum("newRxPassAutoChk").as("newRxPassAutoChk"))
				.add(Projections.sum("newRxPassAutoChkCs").as("newRxPassAutoChkCs"))
				.add(Projections.sum("newRxFailAutoChk").as("newRxFailAutoChk"))
				.add(Projections.sum("newRxFailAutoChkCs").as("newRxFailAutoChkCs"))
				.add(Projections.sum("newRxMviPatFound").as("newRxMviPatFound"))
				.add(Projections.sum("newRxMviPatNotFound").as("newRxMviPatNotFound"))
				.add(Projections.sum("newRxEneElgbEnrl").as("newRxEneElgbEnrl"))
				.add(Projections.sum("newRxEneNotElgbEnrl").as("newRxEneNotElgbEnrl"))
				.add(Projections.sum("newRxPatNotEnrlSite").as("newRxPatNotEnrlSite"))
				.add(Projections.sum("newRxDrgMtchFnd").as("newRxDrgMtchFnd"))
				.add(Projections.sum("newRxDrgMtchNotFnd").as("newRxDrgMtchNotFnd"))
				.add(Projections.sum("newRxPvdMtchFnd").as("newRxPvdMtchFnd"))
				.add(Projections.sum("newRxPvdMtchNotFnd").as("newRxPvdMtchNotFnd")));

		criteria.setResultTransformer(new AliasToBeanResultTransformer(AutoCheckReportVw.class));
		
		List<AutoCheckReportVw> autoCheckReportRows = (List<AutoCheckReportVw>)criteria.list();
		
        return autoCheckReportRows;
	}


	private Date getFormattedFromDateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		//cal.add(Calendar.DATE, -1);
		//System.out.println("FromDate:  " +  cal.getTime());
		return cal.getTime();
	}

	private Date getFormattedToDateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.DATE, 1);
		//System.out.println("ToDate:  " +  cal.getTime());
		return cal.getTime();
	}
}
