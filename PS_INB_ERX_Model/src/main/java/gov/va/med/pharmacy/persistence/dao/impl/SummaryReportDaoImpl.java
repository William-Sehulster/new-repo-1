package gov.va.med.pharmacy.persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import gov.va.med.pharmacy.persistence.BaseDao;
import gov.va.med.pharmacy.persistence.dao.SummaryReportDao;
import gov.va.med.pharmacy.persistence.model.SummaryReportVw;
import gov.va.med.pharmacy.persistence.report.StationIdSelectModel;
import gov.va.med.pharmacy.persistence.report.SummaryReportFilter;


@Repository("summaryReportDao")
public class SummaryReportDaoImpl extends BaseDao<Integer, SummaryReportVw> implements SummaryReportDao{
	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(SummaryReportDaoImpl.class);

	@Autowired
	private DataSource dataSource;
	
	public SummaryReportDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public class StationIDListRowMapper implements RowMapper<StationIdSelectModel>
	{
		public StationIdSelectModel mapRow(ResultSet rs, int rowNum) throws SQLException{
			StationIdSelectModel stationIdSelectModel = new StationIdSelectModel();


			stationIdSelectModel.setId(rs.getString("va_station_id"));
			stationIdSelectModel.setLabel(rs.getString("va_station_id"));


			return stationIdSelectModel;
		}
	}
   
	@Override
	public List<StationIdSelectModel> getStationIDs(int visn) {
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		String sql = "";
		
		sql = "select distinct va_station_id from pharmacy where visn in (:visn) order by va_station_id";

		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("visn", visn);

		List<StationIdSelectModel> visnList = new ArrayList<StationIdSelectModel>();

		try {
			visnList = jdbcTemplate.query(sql,params, new StationIDListRowMapper());
		} catch (DataAccessException e) {
			
			LOG.info("Exception retrieving selected visn from pharmacy." + e.getMessage());
		}

		return visnList;

	}
	
	@Override
	public SummaryReportVw findByVisn(String visn) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("visn", visn));
        SummaryReportVw summaryReportVw = (SummaryReportVw)crit.uniqueResult();
        
        return summaryReportVw;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SummaryReportVw> findByDate(Date dateFrom, Date dateTo) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("pharmacyDivisionName"));
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// for unique results
        List<SummaryReportVw> summaryReportRows = (List<SummaryReportVw>) criteria.list();
        
        return summaryReportRows;
	}
	
	
	// Although it has return type of list, in fact it returns a map of objects
	@SuppressWarnings("unchecked")
	@Override
	public List<SummaryReportVw> find(SummaryReportFilter summaryReportFilter) {
		
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
				.add(Projections.sum("newRxCntCS").as("newRxCntCS"))
				.add(Projections.sum("newRxPharmDisabledAtHub").as("newRxPharmDisabledAtHub"))
				.add(Projections.sum("newRxRejectedAtHub").as("newRxRejectedAtHub"))
				.add(Projections.sum("newRxRejectedAtHubCS").as("newRxRejectedAtHubCS"))
				.add(Projections.sum("newRxPassAutoChk").as("newRxPassAutoChk"))
				.add(Projections.sum("newRxPassAutoChkCS").as("newRxPassAutoChkCS"))
				.add(Projections.sum("newRxFailAutoChk").as("newRxFailAutoChk"))
				.add(Projections.sum("newRxFailAutoChkCS").as("newRxFailAutoChkCS"))
				.add(Projections.sum("newRxRejectedByPharmacist").as("newRxRejectedByPharmacist"))
				.add(Projections.sum("newRxRejectedByPharmacistCS").as("newRxRejectedByPharmacistCS"))
				.add(Projections.sum("newRxFilled").as("newRxFilled"))
				.add(Projections.sum("newRxFilledCS").as("newRxFilledCS"))
				.add(Projections.sum("newRxInProcess").as("newRxInProcess"))
				.add(Projections.sum("newRxInProcessCS").as("newRxInProcessCS")));

		criteria.setResultTransformer(new AliasToBeanResultTransformer(SummaryReportVw.class));
		
		List<SummaryReportVw> summaryReportRows = (List<SummaryReportVw>) criteria.list();
		
		
		
        return summaryReportRows;
	}

	@SuppressWarnings("unchecked")
	@Override	
	public List<SummaryReportVw> find(String visn) {
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
        List<SummaryReportVw> selectRows = (List<SummaryReportVw>) criteria.list();
        
        return selectRows;
		

	}

	// This returns a list to be used for csv export.
	@SuppressWarnings("unchecked")
	@Override
	public List<SummaryReportVw> queryForExport(SummaryReportFilter summaryReportFilter) {
		
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
				.add(Projections.sum("newRxCntCS").as("newRxCntCS"))
				.add(Projections.sum("newRxPharmDisabledAtHub").as("newRxPharmDisabledAtHub"))
				.add(Projections.sum("newRxRejectedAtHub").as("newRxRejectedAtHub"))
				.add(Projections.sum("newRxRejectedAtHubCS").as("newRxRejectedAtHubCS"))
				.add(Projections.sum("newRxPassAutoChk").as("newRxPassAutoChk"))
				.add(Projections.sum("newRxPassAutoChkCS").as("newRxPassAutoChkCS"))
				.add(Projections.sum("newRxFailAutoChk").as("newRxFailAutoChk"))
				.add(Projections.sum("newRxFailAutoChkCS").as("newRxFailAutoChkCS"))
				.add(Projections.sum("newRxRejectedByPharmacist").as("newRxRejectedByPharmacist"))
				.add(Projections.sum("newRxRejectedByPharmacistCS").as("newRxRejectedByPharmacistCS"))
				.add(Projections.sum("newRxFilled").as("newRxFilled"))
				.add(Projections.sum("newRxFilledCS").as("newRxFilledCS"))
				.add(Projections.sum("newRxInProcess").as("newRxInProcess"))
				.add(Projections.sum("newRxInProcessCS").as("newRxInProcessCS")));

		criteria.setResultTransformer(new AliasToBeanResultTransformer(SummaryReportVw.class));
		
		List<SummaryReportVw> summaryReportRows = (List<SummaryReportVw>)criteria.list();
		
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
