package gov.va.med.pharmacy.jaxrs.admin.service.impl;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import gov.va.med.pharmacy.jaxrs.admin.dao.impl.AppInfoDaoImpl;
import gov.va.med.pharmacy.jaxrs.admin.model.AppInfoResponse;
import gov.va.med.pharmacy.jaxrs.admin.service.AppInfoSearch;



/**
 * A class that returns application info/version information in a JSON response.
 *
 */

@Consumes("application/json")
@Produces("application/json")
public class AppInfoSearchImpl implements AppInfoSearch {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(AppInfoSearchImpl.class);
	
	private AppInfoDaoImpl appInfoDao;
	

	public AppInfoDaoImpl getAppInfoDao() {
		return appInfoDao;
	}

	public void setAppInfoDao(AppInfoDaoImpl appInfoDao) {
		this.appInfoDao = appInfoDao;
	}


	@POST
	@Path("/getAppInfo/")
	public AppInfoResponse view() {
		

		AppInfoResponse searchResponse = new AppInfoResponse();

	try {
		
		searchResponse = appInfoDao.getAppInfo();

		} catch (Exception e) {
			searchResponse.setAppVersion("Unknown");

			LOG.error("Error in AppInfoSearchImpl:"+e.getMessage());
		}

		return searchResponse;
	}


}
