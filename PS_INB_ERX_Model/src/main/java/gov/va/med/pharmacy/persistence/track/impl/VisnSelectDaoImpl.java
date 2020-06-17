package gov.va.med.pharmacy.persistence.track.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import gov.va.med.pharmacy.persistence.report.VisnSelectModel;
import gov.va.med.pharmacy.persistence.track.VisnSelectDao;

@Component
public class VisnSelectDaoImpl implements VisnSelectDao {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(VisnSelectDaoImpl.class);

	@Autowired
	private DataSource dataSource;


	public VisnSelectDaoImpl() {
	}

	public VisnSelectDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public class VisnListRowMapper implements RowMapper<VisnSelectModel>
	{
		public VisnSelectModel mapRow(ResultSet rs, int rowNum) throws SQLException{
			VisnSelectModel visnSelectModel = new VisnSelectModel();


			visnSelectModel.setId(rs.getString("visn"));
			visnSelectModel.setLabel(rs.getString("visn"));


			return visnSelectModel;
		}
	}



	@Override
	public List<VisnSelectModel> getVisns() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "";

		sql = "select distinct visn from pharmacy order by to_number(visn)"; 


		List<VisnSelectModel> visnList = new ArrayList<VisnSelectModel>();

		try {

			visnList = jdbcTemplate.query(sql,new VisnListRowMapper());
		} catch (DataAccessException e) {
			
			
			LOG.info("Exception retrieving all visn from pharmacy." + e.getMessage());
		}

		return visnList;

	}
	
	@Override
	public List<VisnSelectModel> getSelectedVisns(List<String> userStationIdList) {
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		String sql = "";
		

		sql = "select distinct visn from pharmacy where va_station_id in (:stationids)  order by to_number(visn)"; 

		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("stationids", userStationIdList);

		List<VisnSelectModel> visnList = new ArrayList<VisnSelectModel>();

		try {
			visnList = jdbcTemplate.query(sql,params, new VisnListRowMapper());
		} catch (DataAccessException e) {
			
			LOG.info("Exception retrieving selected visn from pharmacy." + e.getMessage());
		}

		return visnList;

	}


}
