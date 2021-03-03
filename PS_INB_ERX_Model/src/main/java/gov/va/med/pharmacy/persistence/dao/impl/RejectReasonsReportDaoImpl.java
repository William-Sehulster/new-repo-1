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
import gov.va.med.pharmacy.persistence.dao.RejectReasonsReportDao;
import gov.va.med.pharmacy.persistence.model.RejectReasonsReportVw;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


@Repository("rejectReasonsReportDao")
public class RejectReasonsReportDaoImpl extends BaseDao<Integer, RejectReasonsReportVw> implements RejectReasonsReportDao{
   
	
	@Override
	public RejectReasonsReportVw findByVisn(String visn) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("visn", visn));
        RejectReasonsReportVw rejectReasonsReportVw = (RejectReasonsReportVw)crit.uniqueResult();
        
        return rejectReasonsReportVw;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RejectReasonsReportVw> findByDate(Date dateFrom, Date dateTo) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("pharmacyDivisionName"));
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results
        List<RejectReasonsReportVw> rejectReasonsReportRows = (List<RejectReasonsReportVw>) criteria.list();
        
        return rejectReasonsReportRows;
	}
	
	
	// Although it has return type of list, in fact it returns a map of objects
	@SuppressWarnings("unchecked")
	@Override
	public List<RejectReasonsReportVw> find(SummaryReportFilter summaryReportFilter) {
		
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
				.add(Projections.sum("newRx").as("newRx"))
				.add(Projections.sum("newRxInProcess").as("newRxInProcess"))
				.add(Projections.sum("newRxRejectedByPharmacist").as("newRxRejectedByPharmacist"))
				.add(Projections.sum("newRxPatientNotElig").as("newRxPatientNotElig"))
				.add(Projections.sum("newRxPatientNotFound").as("newRxPatientNotFound"))
				.add(Projections.sum("newRxProviderNotElig").as("newRxProviderNotElig"))
				.add(Projections.sum("newRxProviderNotFound").as("newRxProviderNotFound"))
				.add(Projections.sum("newRxNotEligRefills").as("newRxNotEligRefills"))
				.add(Projections.sum("newRxNonFormulary").as("newRxNonFormulary"))
				.add(Projections.sum("newRxDuplicate").as("newRxDuplicate"))
				.add(Projections.sum("newRxInvalidQty").as("newRxInvalidQty"))
				.add(Projections.sum("newRxDupTheraClass").as("newRxDupTheraClass"))
				.add(Projections.sum("newRxMultiErrCallPharm").as("newRxMultiErrCallPharm"))
				.add(Projections.sum("newRxIncorrectPharm").as("newRxIncorrectPharm"))
				.add(Projections.sum("newRxErrCallPharm").as("newRxErrCallPharm"))
				.add(Projections.sum("newRxInvalidCsDs").as("newRxInvalidCsDs"))
				.add(Projections.sum("newRxPrescriberCsCredInvalid").as("newRxPrescriberCsCredInvalid"))
				.add(Projections.sum("newRxPatientAddrMissing").as("newRxPatientAddrMissing"))
				.add(Projections.sum("newRxCsDateIssue").as("newRxCsDateIssue"))
				);

		criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
		List<RejectReasonsReportVw> rejectReasonsReportRows = (List<RejectReasonsReportVw>) criteria.list();
		
		
		
        return rejectReasonsReportRows;
	}

	@SuppressWarnings("unchecked")
	@Override	
	public List<RejectReasonsReportVw> find(String visn) {
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
        List<RejectReasonsReportVw> selectRows = (List<RejectReasonsReportVw>) criteria.list();
        
        return selectRows;
		

	}

	// This returns a list to be used for csv export.
	@SuppressWarnings("unchecked")
	@Override
	public List<RejectReasonsReportVw> queryForExport(SummaryReportFilter summaryReportFilter) {
		
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
				.add(Projections.sum("newRx").as("newRx"))
				.add(Projections.sum("newRxInProcess").as("newRxInProcess"))
				.add(Projections.sum("newRxRejectedByPharmacist").as("newRxRejectedByPharmacist"))
				.add(Projections.sum("newRxPatientNotElig").as("newRxPatientNotElig"))
				.add(Projections.sum("newRxPatientNotFound").as("newRxPatientNotFound"))
				.add(Projections.sum("newRxProviderNotElig").as("newRxProviderNotElig"))
				.add(Projections.sum("newRxProviderNotFound").as("newRxProviderNotFound"))
				.add(Projections.sum("newRxNotEligRefills").as("newRxNotEligRefills"))
				.add(Projections.sum("newRxNonFormulary").as("newRxNonFormulary"))
				.add(Projections.sum("newRxDuplicate").as("newRxDuplicate"))
				.add(Projections.sum("newRxInvalidQty").as("newRxInvalidQty"))
				.add(Projections.sum("newRxDupTheraClass").as("newRxDupTheraClass"))
				.add(Projections.sum("newRxMultiErrCallPharm").as("newRxMultiErrCallPharm"))
				.add(Projections.sum("newRxIncorrectPharm").as("newRxIncorrectPharm"))
				.add(Projections.sum("newRxErrCallPharm").as("newRxErrCallPharm"))
				.add(Projections.sum("newRxInvalidCsDs").as("newRxInvalidCsDs"))
				.add(Projections.sum("newRxPrescriberCsCredInvalid").as("newRxPrescriberCsCredInvalid"))
				.add(Projections.sum("newRxPatientAddrMissing").as("newRxPatientAddrMissing"))
				.add(Projections.sum("newRxCsDateIssue").as("newRxCsDateIssue")));

		criteria.setResultTransformer(new AliasToBeanResultTransformer(RejectReasonsReportVw.class));
		
		List<RejectReasonsReportVw> autoCheckReportRows = (List<RejectReasonsReportVw>)criteria.list();
		
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
