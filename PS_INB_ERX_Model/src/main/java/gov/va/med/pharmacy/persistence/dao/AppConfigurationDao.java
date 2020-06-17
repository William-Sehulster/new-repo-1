package gov.va.med.pharmacy.persistence.dao;

import gov.va.med.pharmacy.persistence.model.AppConfiguration;

public interface AppConfigurationDao {
	
	public AppConfiguration findByKey(String key);

}
