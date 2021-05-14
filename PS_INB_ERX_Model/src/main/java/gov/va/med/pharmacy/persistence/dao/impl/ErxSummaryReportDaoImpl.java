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
import gov.va.med.pharmacy.persistence.dao.ErxSummaryReportDao;
import gov.va.med.pharmacy.persistence.model.ErxSummaryReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


@Repository("erxSummaryReportDao")
public class ErxSummaryReportDaoImpl extends BaseDao<Integer, ErxSummaryReportVw> implements ErxSummaryReportDao{
   
	
	@Override
	public ErxSummaryReportVw findByVisn(String visn) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("visn", visn));
        ErxSummaryReportVw erxSummaryReportVw = (ErxSummaryReportVw)crit.uniqueResult();
        
        return erxSummaryReportVw;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ErxSummaryReportVw> findByDate(Date dateFrom, Date dateTo) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("pharmacyDivisionName"));
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results
        List<ErxSummaryReportVw> erxSummaryReportRows = (List<ErxSummaryReportVw>) criteria.list();
        
        return erxSummaryReportRows;
	}
	
	
	// Although it has return type of list, in fact it returns a map of objects
	@SuppressWarnings("unchecked")
	@Override
	public List<ErxSummaryReportVw> find(SummaryReportFilter summaryReportFilter) {
		
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
		
		//M. Bolden - 5.0 - Updated below to include new fields for Controlled Substance
		criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("visn").as("visn"))
				.add(Projections.groupProperty("pharmacyNcpdpId").as("pharmacyNcpdpId"))
				.add(Projections.groupProperty("pharmacyVaStationId").as("pharmacyVaStationId"))
				.add(Projections.groupProperty("pharmacyDivisionName").as("pharmacyDivisionName"))
				.add(Projections.groupProperty("pharmacyAddress").as("pharmacyAddress"))
				.add(Projections.sum("newRxCnt").as("newRxCnt"))
				.add(Projections.sum("newRxCntCS").as("newRxCntCS"))
				.add(Projections.sum("refillRequest").as("refillRequest"))
				.add(Projections.sum("refillRequestCS").as("refillRequestCS"))
				.add(Projections.sum("refillResponse").as("refillResponse"))
				.add(Projections.sum("refillResponseCS").as("refillResponseCS"))
				.add(Projections.sum("rxChangeRequest").as("rxChangeRequest"))
				.add(Projections.sum("rxChangeRequestCS").as("rxChangeRequestCS"))
				.add(Projections.sum("rxChangeResponse").as("rxChangeResponse"))
				.add(Projections.sum("rxChangeResponseCS").as("rxChangeResponseCS"))
				.add(Projections.sum("cancelRx").as("cancelRx"))
				.add(Projections.sum("cancelRxCS").as("cancelRxCS"))
				.add(Projections.sum("cancelRxResponse").as("cancelRxResponse"))
				.add(Projections.sum("cancelRxResponseCS").as("cancelRxResponseCS"))
				.add(Projections.sum("rxFill").as("rxFill"))
				.add(Projections.sum("rxFillCS").as("rxFillCS"))
				.add(Projections.sum("rxDoNotFillCS").as("rxDoNotFillCS"))
				);

		criteria.setResultTransformer(new AliasToBeanResultTransformer(ErxSummaryReportVw.class));
		
		List<ErxSummaryReportVw> erxSummaryReportRows = (List<ErxSummaryReportVw>) criteria.list();
		
		
		
        return erxSummaryReportRows;
	}

	@SuppressWarnings("unchecked")
	@Override	
	public List<ErxSummaryReportVw> find(String visn) {
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
        List<ErxSummaryReportVw> selectRows = (List<ErxSummaryReportVw>) criteria.list();
        
        return selectRows;
		

	}

	// This returns a list to be used for csv export.
	@SuppressWarnings("unchecked")
	@Override
	public List<ErxSummaryReportVw> queryForExport(SummaryReportFilter summaryReportFilter) {
		
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
		
		//M. Bolden - 5.0 - Updated below to include new fields for Controlled Substance
		criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("visn").as("visn"))
				.add(Projections.groupProperty("pharmacyNcpdpId").as("pharmacyNcpdpId"))
				.add(Projections.groupProperty("pharmacyVaStationId").as("pharmacyVaStationId"))
				.add(Projections.groupProperty("pharmacyDivisionName").as("pharmacyDivisionName"))
				.add(Projections.groupProperty("pharmacyAddress").as("pharmacyAddress"))
				.add(Projections.sum("newRxCnt").as("newRxCnt"))
				.add(Projections.sum("newRxCntCS").as("newRxCntCS"))
				.add(Projections.sum("refillRequest").as("refillRequest"))
				.add(Projections.sum("refillRequestCS").as("refillRequestCS"))
				.add(Projections.sum("refillResponse").as("refillResponse"))
				.add(Projections.sum("refillResponseCS").as("refillResponseCS"))
				.add(Projections.sum("rxChangeRequest").as("rxChangeRequest"))
				.add(Projections.sum("rxChangeRequestCS").as("rxChangeRequestCS"))
				.add(Projections.sum("rxChangeResponse").as("rxChangeResponse"))
				.add(Projections.sum("rxChangeResponseCS").as("rxChangeResponseCS"))
				.add(Projections.sum("cancelRx").as("cancelRx"))
				.add(Projections.sum("cancelRxCS").as("cancelRxCS"))
				.add(Projections.sum("cancelRxResponse").as("cancelRxResponse"))
				.add(Projections.sum("cancelRxResponseCS").as("cancelRxResponseCS"))
				.add(Projections.sum("rxFill").as("rxFill"))
				.add(Projections.sum("rxFillCS").as("rxFillCS"))
				.add(Projections.sum("rxDoNotFillCS").as("rxDoNotFillCS"))
				);


		criteria.setResultTransformer(new AliasToBeanResultTransformer(ErxSummaryReportVw.class));
		
		List<ErxSummaryReportVw> summaryReportRows = (List<ErxSummaryReportVw>)criteria.list();
		
        return summaryReportRows;
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
