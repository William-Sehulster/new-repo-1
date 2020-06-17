package gov.va.med.pharmacy.jaxrs.admin.dao.impl;

import java.io.IOException;
import java.util.Properties;

import gov.va.med.pharmacy.jaxrs.admin.dao.AppInfoDao;
import gov.va.med.pharmacy.jaxrs.admin.model.AppInfoResponse;

/**
 * @param appInfoResponseObj
 * @return
 * @throws IOException
 */

public class AppInfoDaoImpl implements AppInfoDao {

	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(AppInfoDaoImpl.class);
	private Properties buildProperties;

	public Properties getBuildProperties() {
		return buildProperties;
	}

	public void setBuildProperties(Properties buildProperties) {
		this.buildProperties = buildProperties;
	}


	@Override
	public AppInfoResponse getAppInfo() throws IOException{
		AppInfoResponse appInfoResponseObj = new AppInfoResponse();
		 try {
			if(buildProperties!=null){
				 String buildInfo = buildProperties.getProperty("buildinformation");
				 appInfoResponseObj.setAppVersion(buildInfo);}
		 } catch (Exception e) {
			 LOG.error("Error in AppInfoDaoImpl:"+e.getMessage());
				throw new IOException(e); // let the exception go all the way up.
		 }
		return appInfoResponseObj;
	}
}


