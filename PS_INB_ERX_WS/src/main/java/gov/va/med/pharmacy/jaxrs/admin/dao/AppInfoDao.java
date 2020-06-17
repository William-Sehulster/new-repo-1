package gov.va.med.pharmacy.jaxrs.admin.dao;

import java.io.IOException;

import gov.va.med.pharmacy.jaxrs.admin.model.AppInfoResponse;

public interface AppInfoDao {

	
	/**
	 * @param appInfoResponseObj
	 * @return
	 * @throws IOException
	 */
	public AppInfoResponse getAppInfo() throws IOException;
}
